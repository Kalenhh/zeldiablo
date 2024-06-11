package Algorithme;

public interface Algorithme {
    /**
     * Interface permettant de resoudre un graphe
     * @param g Graphe de départ
     * @param depart Sommet de départ
     * @return Valeur des chemins les plus courts
     */
    Valeur resoudre(Graphe g, String depart);
}