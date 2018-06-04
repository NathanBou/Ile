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
            tuiles.add(new Tuile(NomTuile.BORDURE,EtatTuile.COULEE));
            tuiles.add(new Tuile(NomTuile.BORDURE,EtatTuile.COULEE));
            tuiles.add(new Tuile(NomTuile.PONTABIMES,EtatTuile.ASSECHEE));
            tuiles.add(new Apparition(NomTuile.PORTEBRONZE,new Role(NomRole.INGENIEUR, Utils.Pion.ROUGE),EtatTuile.INONDEE));
            tuiles.add(new Tuile(NomTuile.BORDURE,EtatTuile.COULEE));
            tuiles.add(new Tuile(NomTuile.BORDURE,EtatTuile.COULEE));
            tuiles.add(new Tuile(NomTuile.BORDURE,EtatTuile.COULEE));
            tuiles.add(new Tuile(NomTuile.CAVERNEOMBRES,EtatTuile.ASSECHEE));
            tuiles.add(new Apparition(NomTuile.PORTEFER,new Role(NomRole.PLONGEUR, Utils.Pion.VIOLET),EtatTuile.ASSECHEE));
            tuiles.add(new Apparition(NomTuile.PORTEOR,new Role(NomRole.NAVIGATEUR, Utils.Pion.JAUNE),EtatTuile.ASSECHEE));
            tuiles.add(new Tuile(NomTuile.FALAISEOUBLI,EtatTuile.ASSECHEE));
            tuiles.add(new Tuile(NomTuile.BORDURE,EtatTuile.COULEE));
            tuiles.add(new Tuile(NomTuile.PALAISCORAIL,EtatTuile.ASSECHEE));
            tuiles.add(new Apparition(NomTuile.PORTEARGENT,new Role(NomRole.MESSAGER, Utils.Pion.ORANGE),EtatTuile.ASSECHEE));
            tuiles.add(new Tuile(NomTuile.DUNESILLUSION,EtatTuile.COULEE));
            tuiles.add(new Heliport());
            tuiles.add(new Apparition(NomTuile.PORTECUIVRE,new Role(NomRole.EXPLORATEUR, Utils.Pion.VERT),EtatTuile.ASSECHEE));
            tuiles.add(new Tuile(NomTuile.JARDINHURLEMENTS,EtatTuile.ASSECHEE));
            tuiles.add(new Tuile(NomTuile.FORETPOURPRE,EtatTuile.ASSECHEE));
            tuiles.add(new Tuile(NomTuile.LAGONPERDU,EtatTuile.INONDEE));
            tuiles.add(new Tuile(NomTuile.MARAISBRUMEUX,EtatTuile.COULEE));
            tuiles.add(new Tuile(NomTuile.OBSERTVATOIRE,EtatTuile.INONDEE));
            tuiles.add(new Tuile(NomTuile.ROCHERFANTOME,EtatTuile.COULEE));
            tuiles.add(new Tuile(NomTuile.CAVERNEBRASIER,EtatTuile.INONDEE));
            tuiles.add(new Tuile(NomTuile.BORDURE,EtatTuile.COULEE));
            tuiles.add(new Tuile(NomTuile.TEMPLESOLEIL,EtatTuile.ASSECHEE));
            tuiles.add(new Tuile(NomTuile.TEMPLELUNE,EtatTuile.COULEE));
            tuiles.add(new Tuile(NomTuile.PALAISMAREES,EtatTuile.ASSECHEE));
            tuiles.add(new Tuile(NomTuile.VALCREPUSCULE,EtatTuile.ASSECHEE));
            tuiles.add(new Tuile(NomTuile.BORDURE,EtatTuile.COULEE));
            tuiles.add(new Tuile(NomTuile.BORDURE,EtatTuile.COULEE));
            tuiles.add(new Tuile(NomTuile.BORDURE,EtatTuile.COULEE));
            tuiles.add(new Tuile(NomTuile.TOURDEGUET,EtatTuile.ASSECHEE));
            tuiles.add(new Tuile(NomTuile.JARDINMURMURES,EtatTuile.INONDEE));
            tuiles.add(new Tuile(NomTuile.BORDURE,EtatTuile.COULEE));
            tuiles.add(new Tuile(NomTuile.BORDURE,EtatTuile.COULEE));
        }
        
        public ArrayList<Tuile> getTuiles() {
            return tuiles;
            
        }
}
