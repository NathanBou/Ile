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

    private Tuile[][] tuiles;

    public Grille() {
        tuiles = new Tuile[6][6];

        tuiles[0][0] = new Tuile(NomTuile.BORDURE, EtatTuile.COULEE,0,0);
        tuiles[0][1] = new Tuile(NomTuile.BORDURE, EtatTuile.COULEE,0,1);
        tuiles[0][2] = new Tuile(NomTuile.PONTABIMES, EtatTuile.ASSECHEE,0,2);
        tuiles[0][3] = new Apparition(NomTuile.PORTEBRONZE, new Role(NomRole.INGENIEUR, Utils.Pion.ROUGE), EtatTuile.INONDEE,0,3);//3
        tuiles[0][4] = new Tuile(NomTuile.BORDURE, EtatTuile.COULEE,0,4);
        tuiles[0][5] = new Tuile(NomTuile.BORDURE, EtatTuile.COULEE,0,5);
        tuiles[1][0] = new Tuile(NomTuile.BORDURE, EtatTuile.COULEE,1,0);
        tuiles[1][1] = new Tuile(NomTuile.CAVERNEOMBRES, EtatTuile.ASSECHEE,1,1);
        tuiles[1][2] = new Apparition(NomTuile.PORTEFER, new Role(NomRole.PLONGEUR, Utils.Pion.VIOLET), EtatTuile.ASSECHEE,1,2);//8
        tuiles[1][3] = new Apparition(NomTuile.PORTEOR, new Role(NomRole.NAVIGATEUR, Utils.Pion.JAUNE), EtatTuile.ASSECHEE,1,3);//9
        tuiles[1][4] = new Tuile(NomTuile.FALAISEOUBLI, EtatTuile.ASSECHEE,1,4);
        tuiles[1][5] = new Tuile(NomTuile.BORDURE, EtatTuile.COULEE,1,5);
        tuiles[2][0] = new Tuile(NomTuile.PALAISCORAIL, EtatTuile.ASSECHEE,2,0);
        tuiles[2][1] = new Apparition(NomTuile.PORTEARGENT, new Role(NomRole.MESSAGER, Utils.Pion.ORANGE), EtatTuile.ASSECHEE,2,1);//13
        tuiles[2][2] = new Tuile(NomTuile.DUNESILLUSION, EtatTuile.COULEE,2,2);
        tuiles[2][3] = new Heliport(2,3);//15
        tuiles[2][4] = new Apparition(NomTuile.PORTECUIVRE, new Role(NomRole.EXPLORATEUR, Utils.Pion.VERT), EtatTuile.ASSECHEE,2,4);//16
        tuiles[2][5] = new Tuile(NomTuile.JARDINHURLEMENTS, EtatTuile.ASSECHEE,2,5);
        tuiles[3][0] = new Tuile(NomTuile.FORETPOURPRE, EtatTuile.ASSECHEE,3,0);
        tuiles[3][1] = new Tuile(NomTuile.LAGONPERDU, EtatTuile.INONDEE,3,1);
        tuiles[3][2] = new Tuile(NomTuile.MARAISBRUMEUX, EtatTuile.COULEE,3,2);
        tuiles[3][3] = new Tuile(NomTuile.OBSERTVATOIRE, EtatTuile.INONDEE,3,3);
        tuiles[3][4] = new Tuile(NomTuile.ROCHERFANTOME, EtatTuile.COULEE,3,4);
        tuiles[3][5] = new Tuile(NomTuile.CAVERNEBRASIER, EtatTuile.INONDEE,3,5);
        tuiles[4][0] = new Tuile(NomTuile.BORDURE, EtatTuile.COULEE,4,0);
        tuiles[4][1] = new Tuile(NomTuile.TEMPLESOLEIL, EtatTuile.ASSECHEE,4,1);
        tuiles[4][2] = new Tuile(NomTuile.TEMPLELUNE, EtatTuile.COULEE,4,2);
        tuiles[4][3] = new Tuile(NomTuile.PALAISMAREES, EtatTuile.ASSECHEE,4,3);
        tuiles[4][4] = new Tuile(NomTuile.VALCREPUSCULE, EtatTuile.ASSECHEE,4,4);
        tuiles[4][5] = new Tuile(NomTuile.BORDURE, EtatTuile.COULEE,4,5);
        tuiles[5][0] = new Tuile(NomTuile.BORDURE, EtatTuile.COULEE,5,0);
        tuiles[5][1] = new Tuile(NomTuile.BORDURE, EtatTuile.COULEE,5,1);
        tuiles[5][2] = new Tuile(NomTuile.TOURDEGUET, EtatTuile.ASSECHEE,5,2);
        tuiles[5][3] = new Tuile(NomTuile.JARDINMURMURES, EtatTuile.INONDEE,5,3);
        tuiles[5][4] = new Tuile(NomTuile.BORDURE, EtatTuile.COULEE,5,4);
        tuiles[5][5] = new Tuile(NomTuile.BORDURE, EtatTuile.COULEE,5,5);
    }

    public Tuile[][] getTuiles() {
        return tuiles;

    }
    public Tuile getTuile(int i, int j){
        return tuiles[i][j];
    }
}
