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

    public Controleur(Vue ihm) {
        this.vue = ihm;
        ihm.addObservateur(this);
    }
    @Override
    public void traiterMessage(Message m) {
        // TODO - implement Controleur.TraiterMessage
      if (TypesMessage.FINIRTOUR == m.type) {
          System.out.println("Clic sur FINTOUR");
      }else if (TypesMessage.DEPLACER == m.type){
          System.out.println("Clic sur Deplacer");
      }else if (TypesMessage.ASSECHER == m.type){
          System.out.println("Clic sur ASSECHER");
      }
    }
}
