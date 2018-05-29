package ileinterdite;

import java.util.HashMap;


public abstract class Grille {

	private HashMap<int, Tuile> tuiles;
        
        Grille(HashMap<int, Tuile> tuiles) {
            this.tuiles = new HashMap();
            int nbTuile = 0;
            for (int col = 0; col<5; col++) {
                for (int lig = 0; lig<5; lig++) {
                    this.tuiles.add(new Tuile(lig, col, tuiles.getNb(nbTuile)));
                }
            }
        }

}