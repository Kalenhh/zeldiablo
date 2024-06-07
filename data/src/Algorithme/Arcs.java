import java.util.ArrayList;
import java.util.List;

public class Arcs {
    /**
     * Liste d'arc
     */
    private List<Arc> arcs;

    /**
     * Constructeur d'Arcs
     */

    public Arcs(){
        this.arcs = new ArrayList<Arc>();
    }

    /**
     * Permet d'ajouter un arc a la liste
     * @param a Arc a ajouté
     */

    public void ajouterArc(Arc a){
        this.arcs.add(a);
    }

    /**
     * Retourne la liste d'arc
     * @return
     */
    public List<Arc> getArcs(){
        return this.arcs;
    }
}
