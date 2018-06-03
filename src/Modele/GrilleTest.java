/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;
import Modele.Tuile;
/**
 *
 * @author nathan
 */
public class GrilleTest {
    private ArrayList<Tuile> tuiles;
        public GrilleTest() {
            tuiles = new ArrayList<Tuile>();
            tuiles.add(new Tuile(NomTuile.BORDURE));
            tuiles.add(new Tuile(NomTuile.BORDURE));
            tuiles.add(new Tuile(NomTuile.PONTABIMES));
            tuiles.add(new Apparition(NomTuile.PORTEBRONZE,new Role(NomRole.INGENIEUR, Utils.Pion.ROUGE)));
            tuiles.add(new Tuile(NomTuile.BORDURE));
            tuiles.add(new Tuile(NomTuile.BORDURE));
            tuiles.add(new Tuile(NomTuile.BORDURE));
            tuiles.add(new Tuile(NomTuile.CAVERNEOMBRES));
            tuiles.add(new Apparition(NomTuile.PORTEFER,new Role(NomRole.PLONGEUR, Utils.Pion.VIOLET)));
            tuiles.add(new Apparition(NomTuile.PORTEOR,new Role(NomRole.NAVIGATEUR, Utils.Pion.JAUNE)));
            tuiles.add(new Tuile(NomTuile.FALAISEOUBLI));
            tuiles.add(new Tuile(NomTuile.BORDURE));
            tuiles.add(new Tuile(NomTuile.PALAISCORAIL));
            tuiles.add(new Apparition(NomTuile.PORTEARGENT,new Role(NomRole.MESSAGER, Utils.Pion.ORANGE)));
            tuiles.add(new Tuile(NomTuile.DUNESILLUSION));
            tuiles.add(new Heliport());
            tuiles.add(new Apparition(NomTuile.PORTECUIVRE,new Role(NomRole.EXPLORATEUR, Utils.Pion.VERT)));
            tuiles.add(new Tuile(NomTuile.JARDINHURLEMENTS));
            tuiles.add(new Tuile(NomTuile.FORETPOURPRE));
            tuiles.add(new Tuile(NomTuile.LAGONPERDU));
            tuiles.add(new Tuile(NomTuile.MARAISBRUMEUX));
            tuiles.add(new Tuile(NomTuile.OBSERTVATOIRE));
            tuiles.add(new Tuile(NomTuile.ROCHERFANTOME));
            tuiles.add(new Tuile(NomTuile.CAVERNEBRASIER));
            tuiles.add(new Tuile(NomTuile.BORDURE));
            tuiles.add(new Tuile(NomTuile.TEMPLESOLEIL));
            tuiles.add(new Tuile(NomTuile.TEMPLELUNE));
            tuiles.add(new Tuile(NomTuile.PALAISMAREES));
            tuiles.add(new Tuile(NomTuile.VALCREPUSCULE));
            tuiles.add(new Tuile(NomTuile.BORDURE));
            tuiles.add(new Tuile(NomTuile.BORDURE));
            tuiles.add(new Tuile(NomTuile.BORDURE));
            tuiles.add(new Tuile(NomTuile.TOURDEGUET));
            tuiles.add(new Tuile(NomTuile.JARDINMURMURES));
            tuiles.add(new Tuile(NomTuile.BORDURE));
            tuiles.add(new Tuile(NomTuile.BORDURE));
        }
        
        public ArrayList getTuiles() {
            for (Tuile tuile :tuiles){
                System.out.println(tuile.getNomTuile());
                
            }
            System.out.println(tuiles.size());
            return tuiles;
            
        }
}
