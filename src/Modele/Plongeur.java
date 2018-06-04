/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import static Modele.Utils.EtatTuile.ASSECHEE;
import static Modele.Utils.EtatTuile.INONDEE;
import static Modele.Utils.EtatTuile.COULEE;

import java.util.ArrayList;

/**
 *
 * @author perrbeno
 */
public class Plongeur extends Aventurier {
    
    public Plongeur() {
        super(new Role(NomRole.PLONGEUR, Utils.Pion.VIOLET));
    }

    @Override
    public ArrayList<Tuile> getTuilesAccessibles(Grille g) {
        boolean queAccessibles = false;
        ArrayList<Tuile> tuilesAccessibles = new ArrayList();
        tuilesAccessibles = getTuilesAdjacentes(g);
        while (!queAccessibles) {
            queAccessibles= true;
        }
        for (Tuile tuile : tuilesAccessibles) {
            if (tuile.getEtat() == ASSECHEE) {
                tuilesAccessibles.add(tuile);
            } else if (tuile.getEtat() == COULEE) {
                
                queAccessibles = false;
            } else if(tuile.getEtat()== INONDEE) {
                tuilesAccessibles.add(tuile);
                tuilesAccessibles = getTuilesAdjacentes(g,tuile);
                
            }
        }
        return tuilesAccessibles;
        //Si jamais ya quelqu'un..
        //sms : "et sinon comment ça va mal ?"
        //on verra si tu peux m'aider..
        //Plus aucune motivation.

    }
}
