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
    private Aventurier joueurCourant;
    private boolean gagner;
    private int nbTour;

    public Controleur(Vue vue, Grille grille) {
        this.vue = vue;
        vue.addObservateur(this);
        this.grille = grille;
    }

    @Override
    public void traiterMessage(Message m) {
        switch (m.type) {
            case DEPLACER:
                System.out.println("Clic sur Deplacer");
                joueurCourant.setNbAction(joueurCourant.getNbAction() + 1);
                System.out.println(joueurCourant.getNbAction());
                vue.afficherTuileAccessible(joueurCourant.getTuilesAccessibles(grille));
                break;
            case FINIRTOUR:
                System.out.println("Clic sur FINTOUR");
                joueurCourant.finTour();
                break;
            case ASSECHER:
                System.out.println("Clic sur ASSECHER");
                joueurCourant.setNbAction(joueurCourant.getNbAction() + 1);
                vue.afficherTuileAccessible(joueurCourant.getTuilesInondees(grille));
                break;
            case INITIALISATIONGRILLE:
                System.out.println("INITIALISATION");
                joueurs = new ArrayList<Aventurier>();
                for (NomRole joueur : m.joueurs) {
                    if (joueur == NomRole.EXPLORATEUR && joueurs.size() < 4) {
                        Explorateur explorateur = new Explorateur();
                        joueurs.add(explorateur);
                        explorateur.setApparition(grille.getTuiles().get(16));
                        grille.getTuiles().get(16).estSurTuile(explorateur);
                        System.out.println("EXPLORATEUR");
                    } else if (joueur == NomRole.PLONGEUR && joueurs.size() < 4) {
                        Plongeur plongeur = new Plongeur();
                        joueurs.add(plongeur);
                        plongeur.setApparition(grille.getTuiles().get(8));
                        grille.getTuiles().get(8).estSurTuile(plongeur);
                        System.out.println("PLONGEUR");
                    } else if (joueur == NomRole.INGENIEUR && joueurs.size() < 4) {
                        Ingenieur ingenieur = new Ingenieur();
                        joueurs.add(ingenieur);
                        ingenieur.setApparition(grille.getTuiles().get(3));
                        grille.getTuiles().get(3).estSurTuile(ingenieur);
                        System.out.println("INGENIEUR");
                    } else if (joueur == NomRole.MESSAGER && joueurs.size() < 4) {
                        Messager messager = new Messager();
                        joueurs.add(messager);
                        messager.setApparition(grille.getTuiles().get(13));
                        grille.getTuiles().get(13).estSurTuile(messager);
                        System.out.println("MESSAGER");
                    } else if (joueur == NomRole.NAVIGATEUR && joueurs.size() < 4) {
                        Navigateur navigateur = new Navigateur();
                        joueurs.add(navigateur);
                        navigateur.setApparition(grille.getTuiles().get(9));
                        grille.getTuiles().get(9).estSurTuile(navigateur);
                        System.out.println("NAVIGATEUR");
                    } else if (joueur == NomRole.PILOTE && joueurs.size() < 4) {
                        Pilote pilote = new Pilote();
                        joueurs.add(pilote);
                        pilote.setApparition(grille.getTuiles().get(15));
                        grille.getTuiles().get(15).estSurTuile(pilote);
                        System.out.println("PILOTE");
                    }
                }
                for (Aventurier joueur : joueurs) {
                    System.out.println("*" + joueur.getRole().getNomRole().toString());
                }
                vue.creeJeu(grille);
                gagner = false;
                nbTour = 0;
                for (Aventurier joueur : joueurs) {
                    tourDeJeu(joueur);
                }
                
                break;
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

    public void tourDeJeu(Aventurier joueur) {
            
                System.out.println("Tour numero :" + nbTour);
                joueur.debutTour();
                joueurCourant = joueur;
                vue.afficherEtatJeu(nbTour, nbTour, joueur.getRole().getNomRole().toString());
                if (joueur.getNbAction() == 3) {
                    joueur.finTour();
                }
                nbTour++;
    }
    

}
