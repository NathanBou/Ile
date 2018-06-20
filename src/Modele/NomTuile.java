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
public enum NomTuile {
    BORDURE("Bordure",0),
    PONTABIMES("Pont des Abimes",1),
    PORTEBRONZE("Porte de Bronze",2),
    CAVERNEOMBRES("Caverne des Ombres",3),
    PORTEFER("Porte de Fer",4),
    PORTEOR("Porte d'Or",5),
    FALAISEOUBLI("Falaise de l'Oubli",6),
    PALAISCORAIL("Palais de Corail",7),
    PORTEARGENT("Porte d'Argent",8),
    DUNESILLUSION("Dune de l'Illusion",9),
    HELIPORT("Heliport",10),
    PORTECUIVRE("Porte de Cuivre",11),
    JARDINHURLEMENTS("Jardin des Hurlements",12),
    FORETPOURPRE("Foret Pourpre",13),
    LAGONPERDU("Lagon Perdu",14),
    MARAISBRUMEUX("Marais Brumeux",15),
    OBSERTVATOIRE("Observatoire",16),
    ROCHERFANTOME("Rocher Fantome",17),
    CAVERNEBRASIER("Caverne du Brasier",18),
    TEMPLESOLEIL("Temple du Soleil",19),
    TEMPLELUNE("Temple de la Lune",20),
    PALAISMAREES("Palais des Marees",21),
    VALCREPUSCULE("Val du Crepuscule",22),
    TOURDEGUET("Tour de Guet",23),
    JARDINMURMURES("Jardin des Murmures",24);
        
        String libelle ;
        ArrayList<NomTuile> arrayTuiles;
        int rang;
        NomTuile(String libelle, int rang) {
            this.libelle = libelle ;
            this.rang = rang;
            
        }

        @Override
        public String toString() {
            return this.libelle ;
        }

}
