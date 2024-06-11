package Labyrinthe;

import java.io.*;

/**
 * Classe ScoreJeu. Gère la sauvegarde et la récupération des scores de jeu dans un fichier.
 */
public class ScoreJeu {
    private final String nomFichier;
    private final FileWriter fw;

    /**
     * Constructeur du score du jeu, sauvegardé sur un fichier.
     *
     * @param nomFichier Nom du fichier de sauvegarde des scores.
     * @throws IOException Si une erreur survient lors de l'ouverture du fichier.
     */
    public ScoreJeu(String nomFichier) throws IOException {
        this.nomFichier = nomFichier;
        this.fw = new FileWriter(nomFichier);
    }

    /**
     * Met à jour le score contenu dans un fichier.
     *
     * @param pseudo Nom du joueur.
     * @param score  Score du joueur.
     * @throws IOException Si une erreur survient lors de l'écriture dans le fichier.
     */
    public void ajouterScore(String pseudo, int score) throws IOException {
        this.fw.write(pseudo + ";" + score + ";\r");
    }

    /**
     * Ferme le fichier de sauvegarde.
     *
     * @throws IOException Si une erreur survient lors de la fermeture du fichier.
     */
    public void fermerFichier() throws IOException {
        this.fw.close();
    }

    /**
     * Récupère le meilleur score contenu dans le fichier.
     *
     * @return Le meilleur score sous forme de chaîne de caractères.
     * @throws IOException Si une erreur survient lors de la lecture du fichier.
     */
    public String getMeilleurScore() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(this.nomFichier));
        int meilleurScore = 0;
        String ligne;

        while (true) {
            try {
                ligne = br.readLine();
                if (ligne == null) {
                    break;
                }
                String[] ligneSepare = ligne.split(";");
                int scoreCourant = Integer.parseInt(ligneSepare[1]);
                if (scoreCourant > meilleurScore) {
                    meilleurScore = scoreCourant;
                }
            } catch (EOFException e) {
                break;
            } catch (IOException e) {
                break;
            }
        }
        br.close();
        return String.valueOf(meilleurScore);
    }

    /**
     * Méthode placeholder pour obtenir le score.
     *
     * @return 0 (cette méthode n'est pas implémentée).
     */
    public int getScore() {
        return 0;
    }
}

