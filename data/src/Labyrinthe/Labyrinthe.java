package Labyrinthe;

import Entite.Perso;
import Entite.Position;
import Item.Fleur;
import Item.Mur;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


/**
 * classe labyrinthe. represente un labyrinthe
 */
public class Labyrinthe {

    /**
     * Constantes char
     */
    public static final char MUR = 'X';
    public static final char JOUEUR = 'J';
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
     * Chaque éléments est défini par une Position
     */
    private ArrayList<Position> grid;


    /**
     * Constructeur
     * charge le labyrinthe
     *
     * @param chemin nom du fichier de labyrinthe
     */
    public Labyrinthe(String chemin) throws IOException {

        // ouvrir fichier
        FileReader fichier = new FileReader(chemin);
        BufferedReader bfRead = new BufferedReader(fichier);

        // lecture nblignes
        NBR_LIGNE = Integer.parseInt(bfRead.readLine());
        // lecture nbcolonnes
        NBR_COLONNE = Integer.parseInt(bfRead.readLine());

        // creation labyrinthe vide
        this.grid = new ArrayList<Position>();
        this.pj = null;
        this.rand = new Random();

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
                        this.grid.add(new Mur(0,0,colonne,numeroLigne));
                        break;
                    case VIDE:
                        break;
                    case PLANTE:
                        this.grid.add(new Fleur(0,0,colonne,numeroLigne));
                        break;
                    case JOUEUR:
                        this.pj = new Perso(colonne, numeroLigne,0,0);
                        this.grid.add(this.pj);
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
        this.pj.setX(suivante[0]);
        this.pj.setY(suivante[1]);

        // si le deplacement fini sur un mur, on inverse le deplacement
        for (Position p : this.grid){
            if(p.etrePresent(suivante[0],suivante[1])) {
                if (p instanceof Mur) {
                    this.pj.setX(courante[0]);
                    this.pj.setY(courante[1]);
                }
                if (p instanceof Fleur){
                    score++;
                    int x = rand.nextInt(NBR_COLONNE) ;
                    int y = rand.nextInt(NBR_LIGNE) ;
                    while(!estVide(x,y)){
                        x = rand.nextInt(NBR_COLONNE) ;
                        y = rand.nextInt(NBR_LIGNE) ;
                    }
                    p.setX(x);
                    p.setY(y);
                }
            }
        }
    }

    /**
     * Verifie si l'emplacement est vide ou non
     * @param px
     * @param py
     * @return
     */
    public boolean estVide(int px, int py){
        for(Position p : this.grid){
            if(p.etrePresent(px,py)){
                return false ;
            }
        }
        return true ;
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
     * Getter de l'attribut pj de type Perso
     *
     * @return pj
     */
    public Perso getPerso() {
        return this.pj;
    }

    public int getScore(){return this.score;}

    public ArrayList<Position> getGrid(){
        return this.grid ;
    }
}
