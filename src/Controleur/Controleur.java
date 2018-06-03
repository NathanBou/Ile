/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Aventurier;
import Modele.CTresor;
import Modele.Grille;
import Modele.GrilleTest;
import Modele.Innondation;
import Modele.Tuile;
import Vues.Vue;
import java.util.ArrayList;

/**
 *
 * @author bouviern
 */
public class Controleur implements Observateur {

    private Vue vue;
    private GrilleTest grille;
    private ArrayList<Aventurier> joueurs;
    private ArrayList<Innondation> pileCartes;
    private ArrayList<Innondation> defausse;
    private ArrayList<CTresor> pileCarte;

    public Controleur(Vue vue, GrilleTest grille) {
        this.vue = vue;
        vue.addObservateur(this);
        this.grille = grille;
        
    }
    @Override
    public void traiterMessage(Message m) {
      if (m.type == TypesMessage.FINIRTOUR) {
          System.out.println("Clic sur FINTOUR");
      }else if ( m.type == TypesMessage.DEPLACER){
          System.out.println("Clic sur Deplacer");
      }else if ( m.type == TypesMessage.ASSECHER){
          System.out.println("Clic sur ASSECHER");
      }
    }
    public void initJeu(){
        System.out.println("INITIALISATION");
        vue.creeJeu(grille);
    }

}
