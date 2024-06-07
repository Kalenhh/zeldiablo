package Interaction;

import Entite.*;
import Item.Mur;

public class InteractionJaune implements Interaction{
    @Override
    public void interagirAvec(Entite e,Position p) {
        if (p instanceof Mur){
            e.setX(e.getAncienX());
            e.setY(e.getAncienY());
        }

    }
}
