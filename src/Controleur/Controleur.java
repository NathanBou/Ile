/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Aventurier;
import Modele.CTresor;
import Modele.Explorateur;
import Modele.Grille;
import Modele.Grille;
import Modele.Ingenieur;
import Modele.Innondation;
import Modele.Messager;
import Modele.Navigateur;
import Modele.NomRole;
import Modele.Pilote;
import Modele.Plongeur;
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
            joueurs = new ArrayList<Aventurier>();
            for (NomRole joueur : m.joueurs) {
                if (joueur == NomRole.EXPLORATEUR) {
                    Explorateur explorateur = new Explorateur();
                    joueurs.add(explorateur);
                    explorateur.setApparition(grille.getTuiles().get(16));
                    System.out.println("EXPLORATEUR");
                } else if (joueur == NomRole.PLONGEUR) {
                    Plongeur plongeur = new Plongeur();
                    joueurs.add(plongeur);
                    plongeur.setApparition(grille.getTuiles().get(8));
                    System.out.println("PLONGEUR");
                } else if (joueur == NomRole.INGENIEUR) {
                    Ingenieur ingenieur = new Ingenieur();
                    joueurs.add(ingenieur);
                    ingenieur.setApparition(grille.getTuiles().get(3));
                    System.out.println("INGENIEUR");
                } else if (joueur == NomRole.MESSAGER) {
                    Messager messager = new Messager();
                    joueurs.add(messager);
                    messager.setApparition(grille.getTuiles().get(13));
                    System.out.println("MESSAGER");
                } else if (joueur == NomRole.NAVIGATEUR) {
                    Navigateur navigateur = new Navigateur();
                    joueurs.add(navigateur);
                    navigateur.setApparition(grille.getTuiles().get(9));
                    System.out.println("NAVIGATEUR");
                } else if (joueur == NomRole.PILOTE) {
                    Pilote pilote = new Pilote();
                    joueurs.add(pilote);
                    pilote.setApparition(grille.getTuiles().get(15));
                    System.out.println("PILOTE");
                }
            }
            for (Aventurier joueur : joueurs){
                System.out.println("*"+joueur.getRole().getNomRole().toString());
            }
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
        while (!finTour || joueur.getNbAction() <= 2) {

        }
    }
}
