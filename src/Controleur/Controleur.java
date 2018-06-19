/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Aventurier;
import Modele.CarteTirage;
import Modele.Cartes;
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
import java.util.Collections;

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
    private ArrayList<CarteTirage> pileCarte;
    private ArrayList<CarteTirage> pileDefausse;
    private Aventurier joueurCourant;
    private boolean gagner;
    private boolean deplacement;
    private boolean assechement;
    private int nbTour;
    private int i = 0;

    public Controleur(Vue vue, Grille grille) {
        this.vue = vue;
        vue.addObservateur(this);
        this.grille = grille;
        pileCarte = new ArrayList();
        pileDefausse=new ArrayList();
    }

    @Override
    public void traiterMessage(Message m) {
        switch (m.type) {
            case DEPLACER:
                System.out.println("Clic sur Deplacer");
                System.out.println(joueurCourant);
                vue.setVueDeplacement();
                vue.afficherTuileAccessible(joueurCourant.getTuilesAccessibles(grille));

                if (joueurCourant instanceof Pilote) {
                    Pilote p = (Pilote) joueurCourant;
                    p.setUtilise(false);
                }

                deplacement = true;
                break;
            case COORDONNEE:
                if (deplacement) {
                    System.out.println("Clic sur tuile choisi pour deplacement");
                    joueurCourant.setNbAction(joueurCourant.getNbAction() + 1);
                    Tuile tuileAvantDeplacement = joueurCourant.getEstSurTuile();
                    Tuile tuileApresDeplacement = grille.getTuile(m.lig, m.col);
                    if (joueurCourant instanceof Pilote) {
                        Pilote p = (Pilote) joueurCourant;
                        int x = joueurCourant.getEstSurTuile().getLig();
                        int y = joueurCourant.getEstSurTuile().getCol();

                        if (!((m.col == y + 1 && m.lig == x) || (m.col == y - 1 && m.lig == x) || (m.col == y && m.lig == x + 1) || (m.col == y && m.lig == x - 1))) {
                            //Si le joueur est un pilote et que son déplacement induit l'utilisation de son pouvoir, le pouvoir du Pilote devient "utilisé"
                            p.setUtilise(true);
                        }//Sinon, l'utilisation du pilote reste à faux
                    }
                    if (tuileApresDeplacement.getASurTuile().isEmpty()) {
                        joueurCourant.deplacement(tuileApresDeplacement);
                        vue.afficherDeplacement(m.lig, m.col, joueurCourant, tuileAvantDeplacement);
                    } else {
                        joueurCourant.deplacement(tuileApresDeplacement);
                        vue.afficherDeplacement(m.lig, m.col, joueurCourant, tuileAvantDeplacement, tuileApresDeplacement);
                    }

                    deplacement = false;
                } else if (assechement) {
                    System.out.println("Clic sur tuile choisi pour assechement");
                    joueurCourant.setNbAction(joueurCourant.getNbAction() + 1);
                    vue.assecherTuile(m.lig, m.col);
                    grille.getTuile(m.lig, m.col).assecher();
                    assechement = false;
                }

                if (joueurCourant.getNbAction() == 3) {
                    System.out.println("ZOB");
                    vue.afficherFinTour();
                } else {
                    vue.setVueBoutonsEnabled();
                }
                break;
            case FINIRTOUR:
                System.out.println("Clic sur FINTOUR");
                if (joueurCourant instanceof Pilote) {
                    Pilote p = (Pilote) joueurCourant;
                    p.setUtilise(false);
                }
                i++;
                joueurCourant = joueurs.get(i == joueurs.size() ? i = 0 : i);
                nbTour++;
                vue.afficherEtatJeu(nbTour,joueurCourant.getRole().getNomRole().toString());
                joueurCourant.piocherCarte(pileCarte.get(0));
                pileCarte.remove(0);
                joueurCourant.finTour();
                vue.afficherDebutTour();
                if (joueurCourant.getNbCarte()>9) {
                    for (int i = 0; i < joueurCourant.getNbCarte()-9; i++) {
                        joueurCourant.defausserCarte(joueurCourant.cartePossedees.get(m.numCarte));
                        pileDefausse.add(joueurCourant.cartePossedees.get(m.numCarte));
                    }
                }
                break;
            case ASSECHER:
                System.out.println("Clic sur ASSECHER");
                vue.afficherTuileAssechable(joueurCourant.getTuilesInondees(grille));
                System.out.println(joueurCourant.getTuilesInondees(grille));
                vue.setVueAssecher();
                if (joueurCourant.getNbAction() == 3) {
                    vue.afficherFinTour();
                }
                assechement = true;
                break;
            case INITIALISATIONGRILLE:
                System.out.println("INITIALISATION");
                joueurs = new ArrayList<Aventurier>();
                for (NomRole joueur : m.joueurs) {
                    if (joueur == NomRole.EXPLORATEUR && joueurs.size() < 4) {
                        Explorateur explorateur = new Explorateur();
                        joueurs.add(explorateur);
                        explorateur.setApparition(grille.getTuile(2, 4));
                        grille.getTuile(2, 4).estSurTuile(explorateur);
                        System.out.println("EXPLORATEUR");
                    } else if (joueur == NomRole.PLONGEUR && joueurs.size() < 4) {
                        Plongeur plongeur = new Plongeur();
                        joueurs.add(plongeur);
                        plongeur.setApparition(grille.getTuile(1, 2));
                        grille.getTuile(1, 2).estSurTuile(plongeur);
                        System.out.println("PLONGEUR");
                    } else if (joueur == NomRole.INGENIEUR && joueurs.size() < 4) {
                        Ingenieur ingenieur = new Ingenieur();
                        joueurs.add(ingenieur);
                        ingenieur.setApparition(grille.getTuile(0, 3));
                        grille.getTuile(0, 3).estSurTuile(ingenieur);
                        System.out.println("INGENIEUR");
                    } else if (joueur == NomRole.MESSAGER && joueurs.size() < 4) {
                        Messager messager = new Messager();
                        joueurs.add(messager);
                        messager.setApparition(grille.getTuile(2, 1));
                        grille.getTuile(2, 1).estSurTuile(messager);
                        System.out.println("MESSAGER");
                    } else if (joueur == NomRole.NAVIGATEUR && joueurs.size() < 4) {
                        Navigateur navigateur = new Navigateur();
                        joueurs.add(navigateur);
                        navigateur.setApparition(grille.getTuile(1, 3));
                        grille.getTuile(1, 3).estSurTuile(navigateur);
                        System.out.println("NAVIGATEUR");
                    } else if (joueur == NomRole.PILOTE && joueurs.size() < 4) {
                        Pilote pilote = new Pilote();
                        joueurs.add(pilote);
                        pilote.setApparition(grille.getTuile(2, 3));
                        grille.getTuile(2, 3).estSurTuile(pilote);
                        System.out.println("PILOTE");
                    }
                }
                for (Aventurier joueur : joueurs) {
                    System.out.println("*" + joueur.getRole().getNomRole().toString());
                }
                vue.creeJeu(grille, joueurs);
                vue.setVueBoutonsEnabled();
                gagner = false;
                nbTour = 1;
                joueurCourant=joueurs.get(i);
                vue.afficherEtatJeu(nbTour,0,joueurCourant.getRole().getNomRole().toString());
                
                for (int i = 0; i < 5; i++) {
                    pileCarte.add(new CarteTirage(Cartes.CALICE));
                    pileCarte.add(new CarteTirage(Cartes.CRISTAL));
                    pileCarte.add(new CarteTirage(Cartes.PIERRE));
                    pileCarte.add(new CarteTirage(Cartes.ZEPHYR));
                } 
                
                for (int i = 0; i < 2; i++) {
                    pileCarte.add(new CarteTirage(Cartes.MONTEEDESEAUX));
                    pileCarte.add(new CarteTirage(Cartes.SACDESABLE));
                }
                
                for (int i = 0; i < 3; i++) {
                    pileCarte.add(new CarteTirage(Cartes.HELICOPTERE));
                }
                
                Collections.shuffle(pileCarte);
                
                for (Aventurier joueur : joueurs) {
                    for (int i = 0; i < 2; i++) {
                        joueur.piocherCarte(pileCarte.get(0));
                        pileCarte.remove(0);
                    }
                }
                
                break;
            
            case ANNULER:
                System.out.println("Annuler");
                vue.setVueBoutonsEnabled();
                vue.reinitialiserGrille();
                System.out.println("**********");
                System.out.println(joueurCourant.getNbAction());
                break;
        }

    }

    public ArrayList<Aventurier> getJoueurs() {
        return joueurs;
    }

    public Grille getGrille() {
        return grille;
    }

    public ArrayList<CarteTirage> getPileCarte() {
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

    public ArrayList<CarteTirage> getPileDefausse() {
        return pileDefausse;
    }

}
