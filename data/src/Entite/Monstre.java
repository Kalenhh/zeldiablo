package Entite;

import Interaction.Interaction;

public class Monstre extends Perso{

    /**
     * constructeur
     *
     * @param dx     position selon x
     * @param dy     position selon y
     * @param pv
     * @param degats
     */
    public Monstre(int dx, int dy, int pv, int degats, Interaction inter) {
        super(dx, dy,pv, degats,inter);
    }

    /**
     * Classe représentant un Entite.Monstre, qui hérite de Entite.Perso
     */

        public void attaquer(Entite e){
            e.subirDegat(degats);
        }

        public void seDeplacer(){

        }

        public void subirDegat(int degats){
            pv = pv-degats;
        }

        public boolean etrePresent(){
            return super.etrePresent(this.getX(), this.getY());
        }

        public boolean etreMort(){
            return pv ==0;
        }
}



