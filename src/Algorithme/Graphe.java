package Algorithme;

import java.util.List;

public interface Graphe {
    /**
     * Retourne tout les noeuds du graphe sous une forme de liste de String
     * @return tout les noeuds du graphes
     */
    List<String> listeNoeuds();

    /**
     * Retourne la liste des arcs du noeud passé
     * @param n noeud passé en paramètre
     * @return liste des arcs du noeuds
     */
    List<Arc> suivants(String n);
}
