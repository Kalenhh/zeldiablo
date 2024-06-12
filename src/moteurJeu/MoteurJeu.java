package moteurJeu;

import Labyrinthe.Score;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import java.io.IOException;

public class MoteurJeu extends Application {

    private static double FPS = 100;
    private static double dureeFPS = 1000 / (FPS + 1);

    private final static double WIDTH = 800;
    private final static double HEIGHT = 600;

    private static final FrameStats frameStats = new FrameStats();

    private static Jeu jeu = null;
    private static DessinJeu dessin = null;

    private static Stage primaryStage;

    private static final Clavier controle = new Clavier();

    public static AnimationTimer timer;

    public static void launch(Jeu jeu, DessinJeu dessin) {
        MoteurJeu.jeu = jeu;
        MoteurJeu.dessin = dessin;

        if (jeu != null)
            launch();
    }

    public static void setFPS(int FPSSouhaitees) {
        FPS = FPSSouhaitees;
        dureeFPS = 1000 / (FPS + 1);
    }

    public void start (Stage primaryStage) {
        MoteurJeu.primaryStage = primaryStage;
        Menu menu = new Menu(WIDTH, HEIGHT);

        menu.getBoutonJouer().setOnAction(e -> {
            try {
                jeu.init(); // Réinitialise pv joueur
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            lancerJeu();
        });


        menu.getBoutonQuitter().setOnAction(e -> quitterJeu());

        Scene scene = new Scene(menu, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

        public static void lancerJeu ()   {
            try {
                jeu.init();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Pane canvasContainer = new Pane();
            Canvas canvas = new Canvas();
            canvas.widthProperty().bind(canvasContainer.widthProperty());
            canvas.heightProperty().bind(canvasContainer.heightProperty());
            canvasContainer.getChildren().add(canvas);

            BorderPane root = new BorderPane();
            root.setCenter(canvasContainer);
            Label stats = new Label();
            stats.textProperty().bind(frameStats.textProperty());
            root.setBottom(stats);

            Scene scene = new Scene(root, WIDTH, HEIGHT);
            primaryStage.setScene(scene);

            scene.setOnKeyPressed(controle::appuyerTouche);
            scene.setOnKeyReleased(controle::relacherTouche);


            startAnimation(canvas);
        }

        private static void startAnimation ( final Canvas canvas){
            final LongProperty lastUpdateTime = new SimpleLongProperty(0);

            timer = new AnimationTimer() {
                @Override
                public void handle(long timestamp) {
                    if (lastUpdateTime.get() == 0) {
                        lastUpdateTime.set(timestamp);
                    }

                    long elapsedTime = timestamp - lastUpdateTime.get();
                    double dureeEnMilliSecondes = elapsedTime / 1_000_000.0;

                    if (dureeEnMilliSecondes > dureeFPS) {
                        try {
                            jeu.update(dureeEnMilliSecondes / 1_000., controle);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        dessin.dessinerJeu(jeu, canvas);
                        frameStats.addFrame(elapsedTime);
                        lastUpdateTime.set(timestamp);
                    }
                }
            };

            timer.start();
        }

        public static void stopAnimation () {
            if (timer != null) {
                timer.stop();
            }
        }

        public static void afficherEcranGameOver () {
            VBox root = new VBox();
            root.setAlignment(Pos.CENTER);

            //Image
            Image blob = new Image("file:img/blob_gameover.png");
            ImageView vIm = new ImageView(blob);
            vIm.setFitWidth(600);
            vIm.setFitHeight(300);

            Label gameOverLabel = new Label("GAME OVER");
            gameOverLabel.setStyle("-fx-font-size: 100px;");

            Button menuButton = new Button("Revenir au menu");
            menuButton.setOnAction(event -> {
                try {
                    retournerAuMenu();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });

            root.getChildren().addAll(vIm, gameOverLabel, menuButton);

            Scene gameOverScene = new Scene(root, WIDTH, HEIGHT);
            primaryStage.setScene(gameOverScene);
        }


        public static void quitterJeu () {
            System.exit(0);
        }

        public static void retournerAuMenu () throws IOException {
            stopAnimation();
            if(Score.bestScore < Score.score){
                Score.bestScore = Score.score;
            }
            Menu menu = new Menu(WIDTH, HEIGHT);
            Score.score = 0;
            menu.getBoutonJouer().setOnAction(e -> lancerJeu());
            menu.getBoutonQuitter().setOnAction(e -> quitterJeu());

            Scene menuScene = new Scene(menu, WIDTH, HEIGHT);
            primaryStage.setScene(menuScene);
        }
}
