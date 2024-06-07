package Entite;

public class Rouge extends Monstre{

        /**
         * constructeur
         *
         * @param dx     position selon x
         * @param dy     position selon y
         * @param pv
         * @param degats
         */
        public Rouge(int dx, int dy, int pv, int degats) {
            super(dx, dy, pv, degats);
        }

        /**
         * Classe représentant un Entite.Monstre, qui hérite de Entite.Perso
         */

        public void attaquer(Entite e){
            e.subirDegat(super.degats);
        }

        public void sedeplacer(){
            //se deplace de sorte a ce qu'il se déplace comstamment vers le joueur
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


