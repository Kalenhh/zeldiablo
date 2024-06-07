import java.util.ArrayList;

public class Dijkstra implements Algorithme{
    /**
     * Entrées :
     * G un graphe orienté avec une pondération positive des arcs (co^ut ou poids)
     * A un sommet (départ) de G
     * D´ebut
     * Q <- {} // utilisation d’une liste de noeuds `a traiter
     * Pour chaque sommet v de G faire
     * v.valeur <- Infini
     * v.parent <- Ind´efini
     * Q <- Q U {v} // ajouter le sommet v `a la liste Q
     * Fin Pour
     * A.valeur <- 0
     * Tant que Q est un ensemble non vide faire
     * u <- un sommet de Q telle que u.valeur est minimal
     * // enlever le sommet u de la liste Q
     * Q <- Q \ {u}
     * Pour chaque sommet v de Q tel que l’arc (u,v) existe faire
     * d <- u.valeur + poids(u,v)
     * Si d < v.valeur
     * // le chemin est plus interessant
     * Alors v.valeur <- d
     * v.parent <- u
     * Fin Si
     * Fin Pour
     * Fin Tant que
     *
     * G graphe
     * A sommet de G
     * Q liste de noeuds
     * V valeur de chaque sommet de G
     * U sommet de liste Q avec valeur minimale
     *
     */


    public Valeur resoudre(Graphe g, String depart){
        Valeur v = new Valeur();
        ArrayList<String> listeSommet = (ArrayList<String>) g.listeNoeuds();

        ArrayList<String> Q = new ArrayList<String>();
        for(String sommet : listeSommet){
            v.setValeur(sommet,Double.MAX_VALUE);
            v.setParent(sommet,null);
            Q.add(sommet);
        }
        v.setValeur(depart,0);
        while(!Q.isEmpty()){
            // recherche minimum dans Q
            double min = Double.MAX_VALUE;
            String sMin = null;
            for (String s : Q) {
                if(v.getValeur(s) < min){
                    min = v.getValeur(s);
                    sMin = s;
                }
            }
            Q.remove(sMin);
            if(g.suivants(sMin) == null){
                return v;
            }
            for(Arc a : g.suivants(sMin)){
                double d = v.getValeur(sMin) + a.getCout();
                if (d < v.getValeur(a.getDest())) { // alors le chemin est plus interessant
                    v.setValeur(a.getDest(), d);
                    v.setParent(a.getDest(), sMin);
                }
            }
        }
        return v;

    }
}
