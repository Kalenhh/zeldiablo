package moteurJeu;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Menu extends StackPane {

    private final Button boutonJouer;
    private final Button boutonQuitter;
    private final ImageView fondMenu;
    private final Text texte;
    /**
     * 
     * @param largueur_image
     * @param hauteur_image
     * 
     * Methode qui permet d'afficher le menu au début du jeu
     */
    public Menu(double largueur_image, double hauteur_image) {

        // Texte du menu
        this.texte = new Text("Bienvenue dans Blob Adventure\n l'objectif est simple : defendre votre labyrinthe contre les envahisseurs !");
        this.texte.setTextAlignment(TextAlignment.CENTER);
        this.texte.setFont(Font.font("Arial", FontWeight.BOLD,  20));

        // Bouton pour lancer le jeu
        this.boutonJouer = new Button("Jouer");
        this.boutonJouer.setMinSize(60, 30);
        this.boutonJouer.setStyle("-fx-text-fill: " + "GREEN" + ";");

        // Bouton pour quitter le menu
        this.boutonQuitter = new Button("Quitter");
        this.boutonQuitter.setMinSize(60, 30);
        this.boutonQuitter.setStyle("-fx-text-fill: " + "RED" + ";");

        // Image du menu
        this.fondMenu = new ImageView(new Image("file:blob_fond_menu.png"));
        this.fondMenu.setFitWidth(largueur_image*0.7);
        this.fondMenu.setFitHeight(hauteur_image*0.7);
        this.fondMenu.setPreserveRatio(true);

        // VBox pour aligner les boutons et l'image à la verticale
        VBox vbox = new VBox(10); // 10 est l'espacement entre les boutons
        vbox.setAlignment(Pos.CENTER); // Centre les boutons horizontalement
        vbox.getChildren().addAll(texte, fondMenu, boutonJouer, boutonQuitter);
        this.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, null)));


        // Ajoute le vbox au StackPane
        this.getChildren().addAll(vbox);
        this.setStyle("-fx-background-color: lightblue;");
    }

    // Getters
    public Button getBoutonJouer() {
        return boutonJouer;
    }

    public Button getBoutonQuitter() {
        return boutonQuitter;
    }

    public ImageView getFondMenu() {
        return fondMenu;
    }

    public Text getTexte() {
        return texte;
    }
}