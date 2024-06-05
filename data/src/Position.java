public abstract class Position {

    //Coordonnees x et y
    private int x;
    private int y;

    //Retourne si l'objet se trouve aux positions x et y en paramètre
    public abstract boolean etrePresent(int x,int y);


}
