/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Grille;
import Vues.Vue;

/**
 *
 * @author bouviern
 */
public class Main {

    private Vue ihm;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Grille grille = new Grille();
        Vue ihm = new Vue();
        Controleur cont = new Controleur(ihm, grille);
    }

}
