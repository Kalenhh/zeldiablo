package Item;
import Entite.Position;
import Interaction.Interaction;

/**
 * Classe abstraite definissant les obstacles
 */
public abstract class Item extends Position {
    //resistance qui correspond a la solidite de l'item
    private int resistance;
    //pointVie nombre de points de vie restant
    private int durabilite;
    private Interaction interaction;

    public int getDurabilite() {
        return durabilite;
    }

    public Object getInteraction() {
        return interaction;
    }

    /**
     * Construit une Item.Item
     *
     * @param resistance solidite
     * @param durabilite vie
     * @param x          position abscisse
     * @param y          position ordonnee
     */
    public Item(int resistance, int durabilite, int x, int y) {
        super(x,y);
        //Verification du parametre de resistance
        if(resistance > 1){
            this.resistance = resistance;
        }else this.resistance = 1;

        //Verification du parametre de pv
        if(durabilite > 0){
            this.durabilite = durabilite;
        }else this.durabilite = 1;
    }



    //GETTER et SETTER
    /**
     * Accesseur a la resistance
     * @return resistance de l'item
     */
    public int getResistance() {
        return resistance;
    }

    /**
     * Changer l'etat de la resistance
     * @param resistance de l'item
     */
    public void briser(int resistance) {
        this.resistance -= resistance;
    }

    /**
     * Accesseur des points de vie
     * @return pv de l'item
     */
    public int getPointVie() {
        return durabilite;
    }

    /**
     * Changer le nombre de pv
     * @param pointVie nombre de pv
     */
    public void attaquer(int pointVie) {
        this.durabilite -= pointVie;
    }
}
