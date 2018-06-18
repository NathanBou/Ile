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
        
        NomTuile[] lesTuiles = NomTuile.values();
        int i=0;
        int k=0;
        for(NomTuile nomTuile : lesTuiles) {
            if (((i==0 || i==5) && (k!= 2 && k!=3)) && ((k!=0 && k!=5) && (i!=1 && i!=4))) {
                tuiles[i][k] = new Tuile(nomTuile, EtatTuile.ASSECHEE);
            }
            k++;
            if(k==6) {
                i++;
                k=0;
            }
        }
        
        /*tuiles[0][0] = new Tuile(NomTuile.BORDURE, EtatTuile.COULEE, 0);
        tuiles[0][1] = new Tuile(NomTuile.BORDURE, EtatTuile.COULEE, 1);
        tuiles[0][2] = new Tuile(NomTuile.PONTABIMES, EtatTuile.ASSECHEE, 2);
        tuiles[0][3] = new Apparition(NomTuile.PORTEBRONZE, new Role(NomRole.INGENIEUR, Utils.Pion.ROUGE), EtatTuile.INONDEE, 3);//3
        tuiles[0][4] = new Tuile(NomTuile.BORDURE, EtatTuile.COULEE, 4);
        tuiles[0][5] = new Tuile(NomTuile.BORDURE, EtatTuile.COULEE, 5);
        tuiles[1][0] = new Tuile(NomTuile.BORDURE, EtatTuile.COULEE, 6);
        tuiles[1][1] = new Tuile(NomTuile.CAVERNEOMBRES, EtatTuile.ASSECHEE, 7);
        tuiles[1][2] = new Apparition(NomTuile.PORTEFER, new Role(NomRole.PLONGEUR, Utils.Pion.VIOLET), EtatTuile.ASSECHEE, 8);//8
        tuiles[1][3] = new Apparition(NomTuile.PORTEOR, new Role(NomRole.NAVIGATEUR, Utils.Pion.JAUNE), EtatTuile.ASSECHEE, 9);//9
        tuiles[1][4] = new Tuile(NomTuile.FALAISEOUBLI, EtatTuile.ASSECHEE, 10);
        tuiles[1][5] = new Tuile(NomTuile.BORDURE, EtatTuile.COULEE, 11);
        tuiles[2][0] = new Tuile(NomTuile.PALAISCORAIL, EtatTuile.ASSECHEE, 12);
        tuiles[2][1] = new Apparition(NomTuile.PORTEARGENT, new Role(NomRole.MESSAGER, Utils.Pion.ORANGE), EtatTuile.ASSECHEE, 13);//13
        tuiles[2][2] = new Tuile(NomTuile.DUNESILLUSION, EtatTuile.COULEE, 14);
        tuiles[2][3] = new Heliport(15);//15
        tuiles[2][4] = new Apparition(NomTuile.PORTECUIVRE, new Role(NomRole.EXPLORATEUR, Utils.Pion.VERT), EtatTuile.ASSECHEE, 16);//16
        tuiles[2][5] = new Tuile(NomTuile.JARDINHURLEMENTS, EtatTuile.ASSECHEE, 17);
        tuiles[3][0] = new Tuile(NomTuile.FORETPOURPRE, EtatTuile.ASSECHEE, 18);
        tuiles[3][1] = new Tuile(NomTuile.LAGONPERDU, EtatTuile.INONDEE, 19);
        tuiles[3][2] = new Tuile(NomTuile.MARAISBRUMEUX, EtatTuile.COULEE, 20);
        tuiles[3][3] = new Tuile(NomTuile.OBSERTVATOIRE, EtatTuile.INONDEE, 21);
        tuiles[3][4] = new Tuile(NomTuile.ROCHERFANTOME, EtatTuile.COULEE, 22);
        tuiles[3][5] = new Tuile(NomTuile.CAVERNEBRASIER, EtatTuile.INONDEE, 23);
        tuiles[4][0] = new Tuile(NomTuile.BORDURE, EtatTuile.COULEE, 24);
        tuiles[4][1] = new Tuile(NomTuile.TEMPLESOLEIL, EtatTuile.ASSECHEE, 25);
        tuiles[4][2] = new Tuile(NomTuile.TEMPLELUNE, EtatTuile.COULEE, 26);
        tuiles[4][3] = new Tuile(NomTuile.PALAISMAREES, EtatTuile.ASSECHEE, 27);
        tuiles[4][4] = new Tuile(NomTuile.VALCREPUSCULE, EtatTuile.ASSECHEE, 28);
        tuiles[4][5] = new Tuile(NomTuile.BORDURE, EtatTuile.COULEE, 29);
        tuiles[5][0] = new Tuile(NomTuile.BORDURE, EtatTuile.COULEE, 30);
        tuiles[5][1] = new Tuile(NomTuile.BORDURE, EtatTuile.COULEE, 31);
        tuiles[5][2] = new Tuile(NomTuile.TOURDEGUET, EtatTuile.ASSECHEE, 32);
        tuiles[5][3] = new Tuile(NomTuile.JARDINMURMURES, EtatTuile.INONDEE, 33);
        tuiles[5][4] = new Tuile(NomTuile.BORDURE, EtatTuile.COULEE, 34);
        tuiles[5][5] = new Tuile(NomTuile.BORDURE, EtatTuile.COULEE, 35);*/
    }

    public Tuile[][] getTuiles() {
        return tuiles;

    }
    public Tuile getTuile(int i, int j){
        return tuiles[i][j];
    }
}
