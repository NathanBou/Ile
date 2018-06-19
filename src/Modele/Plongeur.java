/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Modele.Utils.EtatTuile;
import static Modele.Utils.EtatTuile.ASSECHEE;
import static Modele.Utils.EtatTuile.INONDEE;
import static Modele.Utils.EtatTuile.COULEE;

import java.util.ArrayList;

/**
 *
 * @author perrbeno
 */
public class Plongeur extends Aventurier {

    private ArrayList<Tuile> dejaPasse;
    
    public Plongeur() {
        super(new Role(NomRole.PLONGEUR, Utils.Pion.VIOLET));
        dejaPasse = new ArrayList();
    }

    @Override
    public ArrayList<Tuile> getTuilesAccessibles(ArrayList<Tuile> tuilesAccessibles,Tuile t, Grille g) {
        int x = t.getLig();
        int y = t.getCol();
        
        Tuile t1 = (y!=0 ? g.getTuile(x, y-1):null);
        Tuile t2 = (x!=0 ? g.getTuile(x-1, y):null);
        Tuile t3 = (x!=5 ? g.getTuile(x+1, y):null);
        Tuile t4 = (y!=5 ? g.getTuile(x, y+1):null);
        
        if(y!=0 && !tuilesAccessibles.contains(t1) && t1!= null) {
            if(t1.getEtat()!=EtatTuile.COULEE && !tuilesAccessibles.contains(t1)) {
                tuilesAccessibles.add(t1);
            }
            if(t1.getEtat()!=EtatTuile.ASSECHEE && !dejaPasse.contains(t1)) {
                dejaPasse.add(t1);
                getTuilesAccessibles(tuilesAccessibles,t1, g);
            }
        }
        
        if(x!=0 && !tuilesAccessibles.contains(t2) && t2!= null) {
            if(t2.getEtat()!=EtatTuile.COULEE && !tuilesAccessibles.contains(t2)) {
                tuilesAccessibles.add(t2);
            }
            if(t2.getEtat()!=EtatTuile.ASSECHEE && !dejaPasse.contains(t2)) {
                dejaPasse.add(t2);
                getTuilesAccessibles(tuilesAccessibles,t2, g);
            }
        }
        if(y!=5 && !tuilesAccessibles.contains(t4) && t4!= null) {
            if(t4.getEtat()!=EtatTuile.COULEE && !tuilesAccessibles.contains(t4)) {
                tuilesAccessibles.add(t4);
            }
            if(t4.getEtat()!=EtatTuile.ASSECHEE && !dejaPasse.contains(t4)) {
                dejaPasse.add(t4);
                getTuilesAccessibles(tuilesAccessibles,t4, g);
            }
        }
        if(x!=5 && !tuilesAccessibles.contains(t3) && t3!= null) {
            if(t3.getEtat()!=EtatTuile.COULEE && !tuilesAccessibles.contains(t3)) {
                tuilesAccessibles.add(t3);
            }
            if(t3.getEtat()!=EtatTuile.ASSECHEE && !dejaPasse.contains(t3)) {
                dejaPasse.add(t3);
                getTuilesAccessibles(tuilesAccessibles,t3, g);
            }
        }
        
        
        
        return tuilesAccessibles;
    }
}
