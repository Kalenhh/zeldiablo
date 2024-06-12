package Labyrinthe;

import moteurJeu.Clavier;
import moteurJeu.Jeu;

import java.io.*;

/**
 * Classe Score. Gère la sauvegarde et la récupération des scores de jeu dans un fichier.
 */
public class Score implements Jeu {
    public static int score = 0;
    public static int bestScore = 0;

    /**
     * Constructeur du score du jeu, sauvegardé sur un fichier.
     *
     * @param nomFichier Nom du fichier de sauvegarde des scores.
     * @throws IOException Si une erreur survient lors de l'ouverture du fichier.
     */
    public Score(String nomFichier) throws IOException {
        new FileWriter(nomFichier);
    }

    /**
     * Méthode placeholder pour obtenir le score.
     *
     * @return 0 (cette méthode n'est pas implémentée).
     */
    public int getScore() {
        return score;
    }

    @Override
    public void update(double secondes, Clavier clavier) {

    }

    @Override
    public void init() {

    }

    @Override
    public boolean tousMonstresElimines() {
        return false;
    }
}

