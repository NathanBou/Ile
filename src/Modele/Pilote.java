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
        if (utilise) {
            tuilesAccessibles = super.getTuilesAccessibles(g);
        } else {
            for (int i = 0; i < 6; i++) {
                for (int k = 0; k < 6; k++) {
                    if (g.getTuile(i, k) != null && g.getTuile(i, k).getEtat() != Utils.EtatTuile.COULEE) {
                        tuilesAccessibles.add(g.getTuile(i, k));
                    }
                }
            }
            tuilesAccessibles.remove(this.getEstSurTuile());
        }
        return tuilesAccessibles;
    }

    public void setUtilise(boolean utilise) {
        this.utilise = utilise;
    }

}
