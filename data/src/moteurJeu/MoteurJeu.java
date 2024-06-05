package moteurJeu;

//https://github.com/zarandok/megabounce/blob/master/MainCanvas.java

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MoteurJeu extends Application {

    private static double FPS = 100;
    private static double dureeFPS = 1000 / (FPS + 1);

    private static double WIDTH = 800;
    private static double HEIGHT = 600;

    private final FrameStats frameStats = new FrameStats();

    private static Jeu jeu = null;
    private static DessinJeu dessin = null;

    private Stage primaryStage;


    Clavier controle = new Clavier();

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

    public static void setTaille(double width, double height) {
        WIDTH = width;
        HEIGHT = height;
    }

    @Override
    public void start(Stage primaryStage) {

        this.primaryStage = primaryStage; // Initialisation de primaryStage
        //Creation de la racine menu
        Menu menu = new Menu(WIDTH, HEIGHT);

        // Handler pour le bouton jouer
        //Cliquer sur le bouton revient à initialiser entièrement le jeu
        menu.getBoutonJouer().setOnAction(e -> lancerJeu());

        //Handler du boutton pour quitter le jeu
        menu.getBoutonQuitter().setOnAction(e -> quitterJeu());

        //Scene du menu
        Scene scene = new Scene(menu, WIDTH, HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void startAnimation(final Canvas canvas) {
        final LongProperty lastUpdateTime = new SimpleLongProperty(0);

        final AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long timestamp) {
                if (lastUpdateTime.get() == 0) {
                    lastUpdateTime.set(timestamp);
                }

                long elapsedTime = timestamp - lastUpdateTime.get();
                double dureeEnMilliSecondes = elapsedTime / 1_000_000.0;

                if (dureeEnMilliSecondes > dureeFPS) {
                    jeu.update(dureeEnMilliSecondes / 1_000., controle);
                    dessin.dessinerJeu(jeu, canvas);
                    frameStats.addFrame(elapsedTime);
                    lastUpdateTime.set(timestamp);
                }
            }
        };
        timer.start();
    }

    public void lancerJeu(){
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
        primaryStage.setScene(scene); // Utilisation de primaryStage

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                controle.appuyerTouche(event);
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                controle.relacherTouche(event);
            }
        });
        canvas.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    jeu.init();
                }
            }
        });

        startAnimation(canvas);
    }
    public void quitterJeu(){
        System.exit(0);
    }
}
