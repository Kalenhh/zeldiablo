package Labyrinthe;

import Entite.*;
import Item.Fleur;
import Item.Mur;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

import java.security.Key;
import java.util.ArrayList;

public class LabyDessin implements DessinJeu {

    /**
     * Dessine l'etat du jeu sur le canvas mis en parametres
     * Est appellé à toute les frames
     *
     * @param jeu    jeu a afficher
     * @param canvas canvas dans lequel dessiner l'etat du jeu
     */
    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {
        LabyJeu laby = (LabyJeu) jeu;

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());


        int sc = laby.getLaby().getScore();
        if (sc > 40) {
            sc = 40;
        }

        //Personnage jouable
        gc.setFill(Color.RED);
        Perso p = laby.getLaby().getPerso();
        double px = p.getX();
        double py = p.getY();
        gc.fillOval(px * 40 + 20 - sc / 2, py * 40 + 20 - sc / 2, sc + 5, sc + 5);





        for (Position pos : laby.getLaby().getGrid()) {
            //Pour un mur
            if (pos instanceof Mur) {
                gc.setFill(Color.BLACK);
                gc.fillRect(pos.getX() * 40, pos.getY() * 40, 40, 40);
            }
            //Pour une fleur
            if (pos instanceof Fleur) {
                gc.setFill(Color.GREEN);
                gc.fillOval(pos.getX() * 40, pos.getY() * 40, 40, 40);
            }
            //Si c'est un monstre jaune
            if (pos instanceof Jaune) {
                gc.setFill(Color.YELLOW);
                gc.fillOval(pos.getX() * 40, pos.getY() * 40, 40, 40);
            }
        }

        gc.setFill(Color.WHITE);
        gc.setFont(new Font("Arial", 30));
        gc.fillText("Score: " + sc, 10, 35);



    }

}
