package Entite;

import Interaction.Interaction;

public abstract class Position {

    //Coordonnees x et y
    private int x;
    private int y;

    public Position(int dx, int dy){
        this.x = dx ;
        this.y = dy ;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }



    //Retourne si l'objet se trouve aux positions x et y en paramètre
    public boolean etrePresent(int x,int y){
        return this.x == x && this.y == y ;
    }
}
