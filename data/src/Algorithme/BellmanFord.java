import java.util.ArrayList;

public class BellmanFord implements Algorithme{

    /* Algorithme
    fonction pointFixe(Graphe g InOut, Noeud depart)
    debut
    pour chaque sommet u de S faire
        u.valeur <- infini
        u.parent <- indefini
    fin pour
    dep <- 0
    pour i de 1 à taille(S) - 1 faire
        pour chaque arc (u,v) de A faire
            si u.valeur + poids(u,v) <  v.valeur alors
                v.valeur <- u.valeur + poids(u,v)
                v.parent <- u
            fin si
        fin pour
    fin pour
    retourner g

    lexique :
    S : Liste, liste des sommets du graphe g
    A : Liste, liste des arcs du graphe g
    dep : Noeud, sommet de depart
     */

    /**
     * methode qui donne les valeurs des plus courts chemins entre le sommet depart et les autres sommets
     * @param g est le graphe a resoudre
     * @param depart est une chaine correspondant au sommet de depart
     * @return un objet Valeur qui contient les longueurs des differents chemins entre depart et les autres sommets
     */
    public Valeur resoudre(Graphe g, String depart) {
        Valeur v = new Valeur();
        ArrayList<String> s = (ArrayList<String>) g.listeNoeuds();

        for(String u : s) {
            v.setValeur(u, Double.MAX_VALUE);
            v.setParent(u, null);
        }
        v.setValeur(depart, 0);

        boolean modif = true;
        while (modif) {
            modif = false;
            for (int i = 0; i < s.size(); i++) {
                for (Arc a : (ArrayList<Arc>) g.suivants(s.get(i))) {
                    if ((v.getValeur(s.get(i)) + a.getCout()) < v.getValeur(a.getDest())) {
                        v.setValeur(a.getDest(), v.getValeur(s.get(i)) + a.getCout());
                        v.setParent(a.getDest(), s.get(i));
                        modif = true;
                    }
                }
            }
        }
        return v;
    }
}
