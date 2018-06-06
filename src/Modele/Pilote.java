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
public class Pilote extends Aventurier{


    
    private boolean utilise;
    
    public Pilote () {

        super(new Role(NomRole.PILOTE, Utils.Pion.BLEU));
        utilise = false;
    }
    
    @Override
    public ArrayList<Tuile> getTuilesAccessibles(Grille g) {
        ArrayList<Tuile> tuilesAccessibles = new ArrayList();
        for(int i=0; i<36;i++) {
            if(!(i==0 || i== 1 || i== 4 || i==5 || i== 6 || i== 11 || i==24 || i==29 || i== 30 || i== 31 || i== 34|| i==35)) {
                if(g.getTuiles().get(i).getEtat()!=Utils.EtatTuile.COULEE) {
                    tuilesAccessibles.add(g.getTuiles().get(i));
                }
            }
        }
        return tuilesAccessibles;
    }

}
