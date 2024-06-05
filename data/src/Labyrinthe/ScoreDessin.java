package Labyrinthe;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

import java.io.IOException;

public class ScoreDessin implements DessinJeu {
    /**
     * Affiche le score du joueur en temps réel
     * @param jeu    jeu a afficher
     * @param canvas canvas dans lequel dessiner l'etat du jeu
     */
    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {
        //Creation Labyrinthe.LabyJeu à partir du Jeu en paramètre
        ScoreJeu laby = (ScoreJeu) jeu;

        //Initialisation du canva d'affichage du jeu
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());

        gc.setFill(Color.BLACK);
        gc.fillText("SCORE: " + laby.getScore(), 0, 0);
        gc.setFill(Color.RED);
        try {
            gc.fillText("MEILLEUR SCORE: " + laby.getMeilleurScore(), 500, 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
