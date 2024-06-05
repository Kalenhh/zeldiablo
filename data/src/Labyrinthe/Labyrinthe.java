package Labyrinthe;

import Entite.Perso;
import Entite.Position;
import Item.Mur;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;


/**
 * classe labyrinthe. represente un labyrinthe
 */
public class Labyrinthe {

    /**
     * Constantes char
     */
    public static final char MUR = 'X';
    public static final char JOUEUR = 'P';
    public static final char VIDE = '.';
    public static final char PLANTE = 'P';


    /**
     * constantes actions possibles
     */
    public static final String HAUT = "Haut";
    public static final String BAS = "Bas";
    public static final String GAUCHE = "Gauche";
    public static final String DROITE = "Droite";

    public int NBR_LIGNE ;
    public int NBR_COLONNE ;

    /**
     * variable utilisé
     */
    private Perso pj;
    private int score;
    private Random rand;

    /**
     * les elements du labyrinthe
     * Chaque éléments est défini par une Entite.Position
     */
    public Position[][] laby;


    /**
     * Constructeur
     * charge le labyrinthe
     *
     * @param nom nom du fichier de labyrinthe
     * @throws IOException probleme a la lecture / ouverture
     */
    public Labyrinthe(String nom) throws IOException {
        // ouvrir fichier
        FileReader fichier = new FileReader(nom);
        BufferedReader bfRead = new BufferedReader(fichier);

        int nbLignes, nbColonnes;
        // lecture nblignes
        NBR_LIGNE = Integer.parseInt(bfRead.readLine());
        // lecture nbcolonnes
        NBR_COLONNE = Integer.parseInt(bfRead.readLine());

        // creation labyrinthe vide
        this.laby = new Position[NBR_COLONNE][NBR_LIGNE];
        this.pj = null;

        // lecture des cases
        String ligne = bfRead.readLine();

        // stocke les indices courants
        int numeroLigne = 0;

        // parcours le fichier
        while (ligne != null) {

            // parcours de la ligne
            for (int colonne = 0; colonne < ligne.length(); colonne++) {
                char c = ligne.charAt(colonne);
                switch (c) {
                    case MUR:
                        this.laby[colonne][numeroLigne] = new Mur(colonne,numeroLigne,10,10);
                        break;
                    case VIDE:
                        this.laby[colonne][numeroLigne] = null;
                        break;
                    case JOUEUR:
                        this.pj = new Perso(colonne, numeroLigne,0,0);
                        this.laby[colonne][numeroLigne] = this.pj;
                        break;
                    default:
                        throw new Error("caractere inconnu :" + c);
                }
            }

            // lecture
            ligne = bfRead.readLine();
            numeroLigne++;
        }
        // ferme fichier
        bfRead.close();
    }

    /**
     * retourne la case suivante selon une actions
     *
     * @param x      case depart
     * @param y      case depart
     * @param action action effectuee
     * @return case suivante
     */
    static int[] getSuivant(int x, int y, String action){
        switch (action) {
            case HAUT:
                // on monte une ligne
                y--;
                break;
            case BAS:
                // on descend une ligne
                y++;
                break;
            case DROITE:
                // on augmente colonne
                x++;
                break;
            case GAUCHE:
                // on augmente colonne
                x--;
                break;
            default:
                throw new Error("action inconnue");
        }
        return new int[]{x, y};
    }

    /**
     * deplace le personnage en fonction de l'action.
     * gere la collision avec les murs
     *
     * @param action une des actions possibles
     */
    public void deplacerPerso(String action) {
        // case courante
        int[] courante = {this.pj.getX(), this.pj.getY()};

        // calcule case suivante
        int[] suivante = getSuivant(courante[0], courante[1], action);

        // si c'est pas un mur, on effectue le deplacement
        if (!(this.laby[suivante[0]][suivante[1]] instanceof Mur)) {
            // on met a jour personnage
            this.pj.setX(suivante[0]);
            this.pj.setY(suivante[1]);
        }
    }


    /**
     * jamais fini
     *
     * @return fin du jeu
     */
    public boolean etreFini() {
        return false;
    }

    // ##################################
    // GETTER
    // ##################################

    /**
     * Getter taille selon Y
     *
     * @return la taille y
     */
    public int getLengthY() {
        return laby[0].length;
    }

    /**
     * Getter taille selon X
     *
     * @return la taille X
     */
    public int getLengthX() {
        return laby.length;
    }

    /**
     * return mur en (i,j)
     *
     * @param x position en x
     * @param y position en y
     * @return booleen
     */
    public Position getMur(int x, int y) {
        // utilise le tableau de boolean
        return this.laby[x][y];
    }

    /**
     * Getter de l'attribut pj de type Entite.Perso
     *
     * @return pj
     */
    public Perso getPerso() {
        return this.pj;
    }

    public int getScore(){return this.score;}
}
