/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileinterdite;

/**
 *
 * @author perrbeno
 */
public enum NomTuile {
    PONTABIMES("Pont des Abimes"),
    PORTEBRONZE("Porte de Bronze"),
    CAVERNEOMBRES("Caverne des Ombres"),
    PORTEFER("Porte de Fer"),
    PORTEOR("Porte d'Or"),
    FALAISEOUBLI("Falaise de l'Oubli"),
    PALAISCORAIL("Palais de Corail"),
    PORTEARGENT("Porte d'Argent"),
    DUNESILLUSION("Dune de l'Illusion"),
    HELIPORT("Heliport"),
    PORTECUIVRE("Porte de Cuivre"),
    JARDINHURLEMENTS("Jardin des Hurlements"),
    FORETPOURPRE("Foret Pourpre"),
    LAGONPERDU("Lagon Perdu"),
    MARAISBRUMEUX("Marais Brumeux"),
    OBSERTVATOIRE("Observatoire"),
    ROCHERFANTOME("Rocher Fantome"),
    CAVERNEBRASIER("Caverne du Brasier"),
    TEMPLESOLEIL("Temple du Soleil"),
    TEMPLELUNE("Temple de la Lune"),
    PALAISMAREES("Palais des Marees"),
    VALCREPUSCULE("Cal du Crepuscule"),
    TOURDEGUET("Tour de Guet"),
    JARDINMUEMURES("Jardin des Murmures");
        
        String libelle ;
        int rang;
        
        NomTuile(String libelle) {
            this.libelle = libelle ;
        }
        NomTuile(int rang) {
            
        }

        @Override
        public String toString() {
            return this.libelle ;
        }
        
        public ArrayList<NomTuile> jg() {
            return 
        }
}
