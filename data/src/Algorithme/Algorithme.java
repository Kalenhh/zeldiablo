public interface Algorithme {
    /**
     * Interface permettant de resoudre un graphe
     * @param g Graphe de départ
     * @param depart Sommet de départ
     * @return Valeur des chemins les plus courts
     */
    public Valeur resoudre(Graphe g, String depart);
}