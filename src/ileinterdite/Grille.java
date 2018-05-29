package ileinterdite;

import java.util.HashMap;
import ileinterdite.NomTuile;

public abstract class Grille {

	private Tuile[][] tuiles;
        
        Grille() {
            int nbTuile = 0;
            for (int col = 0; col<5; col++) {
                for (int lig = 0; lig<5; lig++) {
                    ajouterTuile(new Tuile(col, lig, shuffle(NomTuile)));
                }
            }
        }
        
        public void ajouterTuile(Tuile tuile) {
            tuiles[tuile.getX()][tuile.getY()] = tuile;
        }

}