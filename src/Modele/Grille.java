/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;
import Modele.Tuile;
import Modele.Utils.EtatTuile;
/**
 *
 * @author nathan
 */
public class Grille {
    private ArrayList<Tuile> tuiles;
        public Grille() {
            tuiles = new ArrayList<Tuile>();
            tuiles.add(new Tuile(NomTuile.BORDURE,EtatTuile.COULEE,0));
            tuiles.add(new Tuile(NomTuile.BORDURE,EtatTuile.COULEE,1));
            tuiles.add(new Tuile(NomTuile.PONTABIMES,EtatTuile.ASSECHEE,2));
            tuiles.add(new Apparition(NomTuile.PORTEBRONZE,new Role(NomRole.INGENIEUR, Utils.Pion.ROUGE),EtatTuile.INONDEE,3));//3
            tuiles.add(new Tuile(NomTuile.BORDURE,EtatTuile.COULEE,4));
            tuiles.add(new Tuile(NomTuile.BORDURE,EtatTuile.COULEE,5));
            tuiles.add(new Tuile(NomTuile.BORDURE,EtatTuile.COULEE,6));
            tuiles.add(new Tuile(NomTuile.CAVERNEOMBRES,EtatTuile.ASSECHEE,7));
            tuiles.add(new Apparition(NomTuile.PORTEFER,new Role(NomRole.PLONGEUR, Utils.Pion.VIOLET),EtatTuile.ASSECHEE,8));//8
            tuiles.add(new Apparition(NomTuile.PORTEOR,new Role(NomRole.NAVIGATEUR, Utils.Pion.JAUNE),EtatTuile.ASSECHEE,9));//9
            tuiles.add(new Tuile(NomTuile.FALAISEOUBLI,EtatTuile.ASSECHEE,10));
            tuiles.add(new Tuile(NomTuile.BORDURE,EtatTuile.COULEE,11));
            tuiles.add(new Tuile(NomTuile.PALAISCORAIL,EtatTuile.ASSECHEE,12));
            tuiles.add(new Apparition(NomTuile.PORTEARGENT,new Role(NomRole.MESSAGER, Utils.Pion.ORANGE),EtatTuile.ASSECHEE,13));//13
            tuiles.add(new Tuile(NomTuile.DUNESILLUSION,EtatTuile.COULEE,14));
            tuiles.add(new Heliport(15));//15
            tuiles.add(new Apparition(NomTuile.PORTECUIVRE,new Role(NomRole.EXPLORATEUR, Utils.Pion.VERT),EtatTuile.ASSECHEE,16));//16
            tuiles.add(new Tuile(NomTuile.JARDINHURLEMENTS,EtatTuile.ASSECHEE,17));
            tuiles.add(new Tuile(NomTuile.FORETPOURPRE,EtatTuile.ASSECHEE,18));
            tuiles.add(new Tuile(NomTuile.LAGONPERDU,EtatTuile.INONDEE,19));
            tuiles.add(new Tuile(NomTuile.MARAISBRUMEUX,EtatTuile.COULEE,20));
            tuiles.add(new Tuile(NomTuile.OBSERTVATOIRE,EtatTuile.INONDEE,21));
            tuiles.add(new Tuile(NomTuile.ROCHERFANTOME,EtatTuile.COULEE,22));
            tuiles.add(new Tuile(NomTuile.CAVERNEBRASIER,EtatTuile.INONDEE,23));
            tuiles.add(new Tuile(NomTuile.BORDURE,EtatTuile.COULEE,24));
            tuiles.add(new Tuile(NomTuile.TEMPLESOLEIL,EtatTuile.ASSECHEE,25));
            tuiles.add(new Tuile(NomTuile.TEMPLELUNE,EtatTuile.COULEE,26));
            tuiles.add(new Tuile(NomTuile.PALAISMAREES,EtatTuile.ASSECHEE,27));
            tuiles.add(new Tuile(NomTuile.VALCREPUSCULE,EtatTuile.ASSECHEE,28));
            tuiles.add(new Tuile(NomTuile.BORDURE,EtatTuile.COULEE,29));
            tuiles.add(new Tuile(NomTuile.BORDURE,EtatTuile.COULEE,30));
            tuiles.add(new Tuile(NomTuile.BORDURE,EtatTuile.COULEE,31));
            tuiles.add(new Tuile(NomTuile.TOURDEGUET,EtatTuile.ASSECHEE,32));
            tuiles.add(new Tuile(NomTuile.JARDINMURMURES,EtatTuile.INONDEE,33));
            tuiles.add(new Tuile(NomTuile.BORDURE,EtatTuile.COULEE,34));
            tuiles.add(new Tuile(NomTuile.BORDURE,EtatTuile.COULEE,35));
        }
        
        public ArrayList<Tuile> getTuiles() {
            return tuiles;
            
        }
}
