package Algorithme;
public class Arc {
    /**
     * chaine correspondant au nom du noeud de destination de l'arc
     */
    private final String dest;

    /**
     * attribut correspondant au cout de l'arc
     */
    private final double cout;

    /**
     * constructeur d'Arc
     * @param d est une chaine
     * @param c est un reel
     */
    public Arc(String d, double c){
        this.dest =  d;
        this.cout = c;
    }

    /**
     * Retourne la destination de l'arc
     * @return destination de l'arc
     */

    public String getDest() {
        return dest;
    }

    /**
     * Retourne le cout de l'arc
     * @return cout de l'arc
     */
    public double getCout() {
        return cout;
    }
}