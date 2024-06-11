package Labyrinthe;

import Algorithme.Arc;
import Algorithme.Graphe;
import Entite.*;
import Item.Fleur;
import Item.Mur;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Classe Labyrinthe. Représente un labyrinthe avec des entités et des éléments de jeu.
 */
public class Labyrinthe implements Graphe {

    // Constantes char
    public static final char MUR = 'X';
    public static final char JOUEUR = 'J';
    public static final char VIDE = '.';
    public static final char PLANTE = 'P';
    public static final char JAUNE = 'Y';
    public static final char ROUGE = 'R';

    // Constantes actions possibles
    public static final String HAUT = "Haut";
    public static final String BAS = "Bas";
    public static final String GAUCHE = "Gauche";
    public static final String DROITE = "Droite";

    public static int NBR_LIGNE = 0;
    public static int NBR_COLONNE = 0;

    // Variables utilisées
    private Joueur pj;
    private int score;

    // Les éléments du labyrinthe
    private final ArrayList<Position> grid;

    // Liste des noeuds pour le calcul des chemins
    private final ArrayList<String> listeNoeud;




    /**
     * Constructeur. Charge le labyrinthe à partir d'un fichier.
     *
     * @param chemin nom du fichier de labyrinthe
     * @throws IOException si une erreur survient lors de la lecture du fichier
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
        this.grid = new ArrayList<>();
        this.pj = null;

        this.listeNoeud = new ArrayList<>();

        // lecture des cases
        String ligne = bfRead.readLine();

        // stocke les indices courants
        int numeroLigne = 0;

        // parcours le fichier
        while (ligne != null) {
            // parcours de la ligne
            for (int colonne = 0; colonne < ligne.length(); colonne++) {
                char c = ligne.charAt(colonne);
                this.listeNoeud.add(colonne + ":" + numeroLigne);
                switch (c) {
                    case MUR:
                        this.grid.add(new Mur(0, 0, colonne, numeroLigne));
                        this.listeNoeud.remove(colonne + ":" + numeroLigne);
                        break;
                    case VIDE:
                        break;
                    case PLANTE:
                        this.grid.add(new Fleur(0, 0, colonne, numeroLigne));
                        break;
                    case JAUNE:
                        this.grid.add(new Jaune(colonne, numeroLigne, 2, 1));
                        break;
                    case ROUGE:
                        this.grid.add(new Rouge(colonne, numeroLigne, 2, 1, this));
                        break;
                    case JOUEUR:
                        this.pj = new Joueur(colonne, numeroLigne, 2, 1);
                        this.grid.add(this.pj);
                        break;
                    default:
                        throw new Error("caractère inconnu :" + c);
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
     * Retourne la case suivante selon une action
     *
     * @param x      case de départ
     * @param y      case de départ
     * @param action action effectuée
     * @return case suivante
     */
    static int[] getSuivant(int x, int y, String action) {
        switch (action) {
            case HAUT:
                y--;
                break;
            case BAS:
                y++;
                break;
            case DROITE:
                x++;
                break;
            case GAUCHE:
                x--;
                break;
            default:
                throw new Error("action inconnue");
        }
        return new int[]{x, y};
    }

    /**
     * Déplace le personnage en fonction de l'action. Gère la collision avec les murs.
     *
     * @param action une des actions possibles
     */
    public void deplacerPerso(String action) {
        int[] courante = {this.pj.getX(), this.pj.getY()};
        int[] suivante = getSuivant(courante[0], courante[1], action);
        this.pj.setX(suivante[0]);
        this.pj.setY(suivante[1]);

        this.pj.setAncienX(courante[0]);
        this.pj.setAncienY(courante[1]);

        for (Position cible : grid) {
            if (pj.etrePresent(cible.getX(), cible.getY())) {
                ((Entite) pj).interagir(cible);
            }
        }
    }

    /**
     * Déplace toutes les entités du labyrinthe.
     */
    public void deplacementEntite() {
        for (Position p : grid) {
            if (p instanceof Entite) {
                ((Entite) p).seDeplacer();
            }
        }
    }

    /**
     * Gère les interactions entre les entités et les autres positions du labyrinthe.
     */
    public void gererInteraction() {
        for (Position p : grid) {
            if (p instanceof Entite) {
                for (Position cible : grid) {
                    if (p.etrePresent(cible.getX(), cible.getY())) {
                        ((Entite) p).interagir(cible);
                    }
                }
            }
        }
    }

    /**
     * Retire la position d'un element
     * @param position La position de l'element.
     */
    public void retirerElement(Position position) {
        grid.remove(position);
    }

    /**
     * Indique si le jeu est terminé.
     *
     * @return false (le jeu n'est jamais terminé)
     */
    public boolean etreFini() {
        if (pj.etreMort()){
            return true;
        } else {return false;}
    }

    /**
     * Renvoie la liste des noeuds sous forme "x:y".
     *
     * @return liste des noeuds
     */
    public ArrayList<String> listeNoeuds() {
        return this.listeNoeud;
    }

    /**
     * Renvoie la liste des noeuds adjacents.
     *
     * @param d noeud de départ
     * @return liste des noeuds adjacents
     */
    public ArrayList<Arc> suivants(String d){

        if(!this.listeNoeuds().contains(d)){
            System.out.println("D = " + d);
            return null;
        }


        ArrayList<Arc> ret = new ArrayList<>();
        int x = Integer.parseInt(d.split(":")[0]);
        int y = Integer.parseInt(d.split(":")[1]);

        if(x+1 < NBR_COLONNE && this.listeNoeud.contains(x+1 + ":" + y))
            ret.add(new Arc(x + 1 +":"+ y,1));
        if(x-1 >= 0 && this.listeNoeud.contains(x-1 + ":" + y))
            ret.add(new Arc(x-1 + ":" + y, 1));
        if(y+1 < NBR_LIGNE && this.listeNoeud.contains(x + ":" + (y+1)))
            ret.add(new Arc(x + ":" + (y+1),1));

        if(y-1 >= 0 && this.listeNoeud.contains(x + ":" + (y-1)))
            ret.add(new Arc(x + ":" + (y-1),1));
        return ret;
    }

    // GETTERS

    /**
     * Getter de l'attribut pj de type Perso
     *
     * @return pj
     */
    public Perso getPerso() {
        return this.pj;
    }

    /**
     * Getter du score
     *
     * @return score
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Getter de la grille du labyrinthe
     *
     * @return grille du labyrinthe
     */
    public ArrayList<Position> getGrid() {
        return this.grid;
    }
}
