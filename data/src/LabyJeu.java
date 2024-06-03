import moteurJeu.*;

import java.io.IOException;

public class LabyJeu extends Labyrinthe implements Jeu {

    public LabyJeu(String path) throws IOException {
        super(path);

    }
    @Override
    public void update(double secondes, Clavier clavier) {

    }

    @Override
    public void init() {

    }

    @Override
    public boolean etreFini() {
        return false;
    }
}
