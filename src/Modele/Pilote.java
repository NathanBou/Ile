/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;

/**
 *
 * @author perrbeno
 */
public class Pilote extends Aventurier {

    private boolean utilise;

    public Pilote() {

        super(new Role(NomRole.PILOTE, Utils.Pion.BLEU));
        utilise = false;
    }

    @Override
    public ArrayList<Tuile> getTuilesAccessibles(Grille g) {
        ArrayList<Tuile> tuilesAccessibles = new ArrayList();
        for (int col = 0; col < 5; col++) {
            for (int lig = 0; lig < 5; lig++) {
                if ((((lig == 2 || lig == 3) && (col == 0 || col == 5)) || ((lig != 0 && lig != 5) && (col == 1 && col == 4))) && g.getTuiles()[lig][col].getEtat() == Utils.EtatTuile.ASSECHEE) {
                    tuilesAccessibles.add(g.getTuiles()[lig][col]);
                }
            }
        }
        return tuilesAccessibles;
    }
}
