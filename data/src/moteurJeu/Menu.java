package moteurJeu;

import Labyrinthe.LabyJeu;
import Labyrinthe.Score;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.io.IOException;

/**
 * Classe Menu. Représente le menu d'accueil du jeu.
 */
public class Menu extends StackPane {

    private final Button boutonJouer;
    private final Button boutonQuitter;

    /**
     * Constructeur du menu. Permet d'afficher le menu au début du jeu.
     *
     * @param largueur_image Largeur de l'image de fond.
     * @param hauteur_image  Hauteur de l'image de fond.
     *
     */
    public Menu(double largueur_image, double hauteur_image, Score score) {
        //Creation du pane de score
        VBox scores = new VBox();
        scores.setAlignment(Pos.CENTER);

        //Recuperation des scores
        Label scoreLabel = new Label("SCORE: " + score.getScore());
        Label meilleurScoreLabel;
        meilleurScoreLabel = new Label("MEILLEUR SCORE: " + Score.bestScore);

        //Redesign des labels
        scoreLabel.setFont(Font.font(25));
        meilleurScoreLabel.setFont(Font.font(25));
        scoreLabel.setStyle("-fx-background-color: #CCCCCC;");
        meilleurScoreLabel.setStyle("-fx-background-color: #CCCCCC;");

        //Ajout dans le pane
        scores.getChildren().addAll(scoreLabel, meilleurScoreLabel);

        // Texte du menu
        Text texte = new Text("Bienvenue dans Blob Adventure\n l'objectif est simple : défendre votre labyrinthe contre les envahisseurs !");
        texte.setTextAlignment(TextAlignment.CENTER);
        texte.setFont(Font.font("Arial", FontWeight.BOLD, 20));

        // Bouton pour lancer le jeu
        this.boutonJouer = new Button("Jouer");
        this.boutonJouer.setMinSize(60, 30);
        this.boutonJouer.setStyle("-fx-text-fill: " + "GREEN" + ";");

        // Bouton pour quitter le menu
        this.boutonQuitter = new Button("Quitter");
        this.boutonQuitter.setMinSize(60, 30);
        this.boutonQuitter.setStyle("-fx-text-fill: " + "RED" + ";");

        // Image du menu
        ImageView fondMenu = new ImageView(new Image("file:blob_fond_menu.png"));
        fondMenu.setFitWidth(largueur_image * 0.7);
        fondMenu.setFitHeight(hauteur_image * 0.7);
        fondMenu.setPreserveRatio(true);

        // VBox pour aligner les boutons et l'image à la verticale
        VBox vbox = new VBox(10); // 10 est l'espacement entre les boutons
        vbox.setAlignment(Pos.CENTER); // Centre les boutons horizontalement
        vbox.getChildren().addAll(texte, fondMenu, scores, boutonJouer, boutonQuitter);
        this.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(0), null)));

        // Ajoute le VBox au StackPane
        this.getChildren().addAll(vbox);
        this.setStyle("-fx-background-color: lightblue;");
    }

    /**
     * Getter pour le bouton "Jouer".
     *
     * @return boutonJouer Bouton pour lancer le jeu.
     */
    public Button getBoutonJouer() {
        return boutonJouer;
    }

    /**
     * Getter pour le bouton "Quitter".
     *
     * @return boutonQuitter Bouton pour quitter le menu.
     */
    public Button getBoutonQuitter() {
        return boutonQuitter;
    }
}
