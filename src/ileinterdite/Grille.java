package ileinterdite;

import ileinterdite.Utils.Pion;

public abstract class Grille {

	private Tuile[][] tuiles;
        
        Grille() {
            tuiles[0][0] = null;
            tuiles[0][1] = null;
            tuiles[0][2] = new Tuile(NomTuile.PONTABIMES);
            tuiles[0][3] = new Tuile(NomTuile.PORTEBRONZE);
            tuiles[0][4] = null;
            tuiles[0][5] = null;
            tuiles[1][0] = null;
            tuiles[1][1] = new Tuile(NomTuile.CAVERNEOMBRES);
            tuiles[1][2] = new Apparition(NomTuile.PORTEFER,new Role(NomRole.PLONGEUR, Pion.VIOLET));
            tuiles[1][3] = new Apparition(NomTuile.PORTEOR,new Role(NomRole.NAVIGATEUR, Pion.JAUNE));
            tuiles[1][4] = new Tuile(NomTuile.FALAISEOUBLI);
            tuiles[1][5] = null;
            tuiles[2][0] = new Tuile(NomTuile.PALAISCORAIL);
            tuiles[2][1] = new Apparition(NomTuile.PORTEARGENT,new Role(NomRole.MESSAGER, Pion.ORANGE));
            tuiles[2][2] = new Tuile(NomTuile.DUNESILLUSION);
            tuiles[2][3] = new Heliport();
            tuiles[2][4] = new Apparition(NomTuile.PORTECUIVRE,new Role(NomRole.EXPLORATEUR, Pion.VERT));
            tuiles[2][5] = new Tuile(NomTuile.JARDINHURLEMENTS);
            tuiles[3][0] = new Tuile(NomTuile.FORETPOURPRE);
            tuiles[3][1] = new Tuile(NomTuile.LAGONPERDU);
            tuiles[3][2] = new Tuile(NomTuile.MARAISBRUMEUX);
            tuiles[3][3] = new Tuile(NomTuile.OBSERTVATOIRE);
            tuiles[3][4] = new Tuile(NomTuile.ROCHERFANTOME);
            tuiles[3][5] = new Tuile(NomTuile.CAVERNEBRASIER);
            tuiles[4][0] = null;
            tuiles[4][1] = new Tuile(NomTuile.TEMPLESOLEIL);
            tuiles[4][2] = new Tuile(NomTuile.TEMPLELUNE);
            tuiles[4][3] = new Tuile(NomTuile.PALAISMAREES);
            tuiles[4][4] = new Tuile(NomTuile.VALCREPUSCULE);
            tuiles[4][5] = null;
            tuiles[5][0] = null;
            tuiles[5][1] = null;
            tuiles[5][2] = new Tuile(NomTuile.TOURDEGUET);
            tuiles[5][3] = new Tuile(NomTuile.JARDINMURMURES);
            tuiles[5][4] = null;
            tuiles[5][5] = null;
        }
        
        public Tuile[][] getTuiles() {
            return tuiles;
        }
}