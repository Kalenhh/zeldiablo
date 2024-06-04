import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import moteurJeu.DessinJeu;
import moteurJeu.Jeu;
import org.w3c.dom.Text;

public class ScoreDessin implements DessinJeu {
    /**
     * Affiche le score du joueur en temps réel
     * @param jeu    jeu a afficher
     * @param canvas canvas dans lequel dessiner l'etat du jeu
     */
    @Override
    public void dessinerJeu(Jeu jeu, Canvas canvas) {
        //Creation LabyJeu à partir du Jeu en paramètre
        LabyJeu laby = (ScoreJeu) jeu;

        //Initialisation du canva d'affichage du jeu
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(0,0,canvas.getWidth(),canvas.getHeight());

        gc.setFill(Color.BLACK);
        gc.fillText("SCORE: " + laby.getScore(), 0, 0);
    }
}
