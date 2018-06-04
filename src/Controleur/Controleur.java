/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Aventurier;
import Modele.CTresor;
import Modele.Grille;
import Modele.Grille;
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
    private Grille grille;
    private ArrayList<Aventurier> joueurs;
    private ArrayList<Innondation> pileInnondation;
    private ArrayList<Innondation> defausseInnondation;
    private ArrayList<CTresor> pileCarte;
    private ArrayList<CTresor> defausseCarte;

    public Controleur(Vue vue, Grille grille) {
        this.vue = vue;
        vue.addObservateur(this);
        this.grille = grille;

    }

    @Override
    public void traiterMessage(Message m) {
        if (m.type == TypesMessage.FINIRTOUR) {
            System.out.println("Clic sur FINTOUR");
        } else if (m.type == TypesMessage.DEPLACER) {
            System.out.println("Clic sur Deplacer");
        } else if (m.type == TypesMessage.ASSECHER) {
            System.out.println("Clic sur ASSECHER");
        } else if (m.type == TypesMessage.INITIALISATIONGRILLE) {
            System.out.println("INITIALISATION");
            vue.creeJeu(grille);
        }
       
    }
    
    public ArrayList<Aventurier> getJoueurs() {
        return joueurs;
    }


    public Grille getGrille() {
        return grille;
    }

    public ArrayList<CTresor> getPileCarte() {
        return pileCarte;
    }


    public Vue getVue() {
        return vue;
    }

    public ArrayList<Innondation> getPileInnondation() {
        return pileInnondation;
    }

    public ArrayList<Innondation> getDefausseInnondation() {
        return defausseInnondation;
    }

    public ArrayList<CTresor> getDefausseCarte() {
        return defausseCarte;
    }

    public void TourDeJeu(Aventurier joueur, Grille grille) {
        boolean finTour = false;
        while (!finTour || joueur.getNbAction()<=2){
            
        }
    }
}
