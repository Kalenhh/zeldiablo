package Labyrinthe;

import Entite.Perso;
import Item.Mur;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;

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


        int sc = laby.getLaby().getScore() ;
        if(sc>40){
            sc = 40 ;
        }

        gc.setFill(Color.RED);
        Perso p = laby.getLaby().getPerso();
        double px = p.getX();
        double py = p.getY();
        gc.fillOval(px*40+20-sc/2, py*40+20-sc/2, sc+5, sc+5);


        for (int y = 0; y < laby.getLaby().getLengthY(); y++) {
            // affiche la ligne
            for (int x = 0; x < laby.getLaby().getLengthX(); x++) {
                if (laby.getLaby().getMur(x, y) instanceof Mur) {
                    gc.setFill(Color.BLACK);
                    gc.fillRect(x * 40, y * 40, 40, 40);
                }
            }
        }
    }
}