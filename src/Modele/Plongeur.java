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
public class Plongeur extends Aventurier {
    Plongeur() {
        super(new Role(NomRole.PLONGEUR, Utils.Pion.VIOLET));
    }
    
    @Override
    public ArrayList<Tuile> getTuilesAccessibles(Grille g) {
        boolean queSecs = false;
        ArrayList<Tuile> tuilesAccessibles = new ArrayList();
        tuilesAccessibles = super.getTuilesAccessibles(g);
        while(!queSecs) {
            queSecs = true;
            for (Tuile tuile : tuilesAccessibles) {
                if(tuile.getEtat()!= Utils.EtatTuile.ASSECHEE) {
                    queSecs = false;
                    tuilesAccessibles = getTuilesAdjacentes(g, tuile);
                }
            }
        }
        return tuilesAccessibles;
        
    }
}
