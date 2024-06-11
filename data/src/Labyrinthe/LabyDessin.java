package Labyrinthe;

import Entite.*;
import Item.Fleur;
import Item.Mur;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

public class LabyDessin implements DessinJeu {

    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {
        LabyJeu laby = (LabyJeu) jeu;

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.LIGHTGREEN);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        int sc = laby.getLaby().getScore();
        if (sc > 40) {
            sc = 40;
        }

        // Dessine le personnage jouable
//        gc.setFill(Color.RED);
//        Joueur p = (Joueur)laby.getLaby().getPerso();
//        double px = p.getX();
//        double py = p.getY();
//        gc.fillOval(px * 40 + 20 - (double) sc / 2, py * 40 + 20 - (double) sc / 2, sc + 5, sc + 5);

        // Dessine les autres éléments du labyrinthe
        for (Position pos : laby.getLaby().getGrid()) {
            if (pos instanceof Joueur) {
                gc.drawImage(new Image("file:blob_jeu.png"), pos.getX() * 40, pos.getY() * 40);
            }
            if (pos instanceof Mur) {
                gc.drawImage(new Image("file:mur_jeu.png"), pos.getX() * 40, pos.getY() * 40);
            }
            if (pos instanceof Fleur) {
                gc.drawImage(new Image("file:fleur.png"), pos.getX() * 40, pos.getY() * 40);
            }
            if (pos instanceof Jaune) {
                gc.drawImage(new Image("file:monstreJaune.png"), pos.getX() * 40, pos.getY() * 40);
            }
            if (pos instanceof Rouge) {
                gc.drawImage(new Image("file:monstreRouge.png"), pos.getX() * 40, pos.getY() * 40);
            }
        }

        // Affiche le score
        gc.setFill(Color.WHITE);
        gc.setFont(new Font("Arial", 30));
        gc.fillText("Score: " + sc, 10, 35);
    }
}
