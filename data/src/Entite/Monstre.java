package Entite;

public class Monstre extends Perso{

    /**
     * constructeur
     *
     * @param dx     position selon x
     * @param dy     position selon y
     * @param pv
     * @param degats
     */
    public Monstre(int dx, int dy, int pv, int degats) {
        super(dx, dy,pv, degats);
    }

    /**
     * Classe représentant un Entite.Monstre, qui hérite de Entite.Perso
     */

        public void attaquer(Entite e){
            e.subirDegat(super.degats);
        }

        public void seDeplacer(){

        }

        public void subirDegat(int degats){
            super.pv = super.pv-degats;
        }

        public boolean etrePresent(){
            return super.etrePresent(this.getX(), this.getY());
        }

        public boolean etreMort(){
            return super.pv ==0;
        }
}



