/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Aventurier;
import Modele.CTresor;
import Modele.Grille;
import Modele.Innondation;
import Vues.Vue;
import java.util.ArrayList;

/**
 *
 * @author bouviern
 */
public class Controleur implements Observateur {

    private Vue vue;
    private Grille grille;
    private ArrayList<Aventurier> joueurs;
    private ArrayList<Innondation> pileCartes;
    private ArrayList<Innondation> defausse;
    private ArrayList<CTresor> pileCarte;


    @Override
    public void traiterMessage(Message m) {
        // TODO - implement Controleur.TraiterMessage
      if (TypesMessage.FINIRTOUR == m.type) {

      }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Vue ihm = new Vue();
        ihm.afficher();
    }

}
