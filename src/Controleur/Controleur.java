/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import static Controleur.TypesMessage.DEFAUSSERCARTE;
import Modele.Aventurier;
import Modele.CarteInondation;
import Modele.CarteTirage;
import Modele.Cartes;
import Modele.Explorateur;
import Modele.Grille;
import Modele.Ingenieur;
import Modele.Messager;
import Modele.Navigateur;
import Modele.NomRole;
import Modele.NomTresors;
import Modele.NomTuile;
import Modele.Pilote;
import Modele.Plongeur;
import Modele.Tresor;
import Modele.Tuile;
import Modele.Utils;
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
    private ArrayList<CarteTirage> pileCarteTresor;
    private ArrayList<CarteTirage> pileDefausseTresor;
    private ArrayList<CarteInondation> pileCarteInondation;
    private ArrayList<CarteInondation> pileDefausseInondation;
    private Aventurier joueurCourant;
    private boolean gagner;
    private boolean deplacement;
    private boolean assechement;
    private boolean defausser;
    private int nbTour;
    private int nivEau;
    private int numJoueurs = 0;
    private ArrayList<Tresor> collectionTresor;

    public Controleur(Vue vue, Grille grille) {
        this.vue = vue;
        vue.addObservateur(this);
        this.grille = grille;
        pileCarteTresor = new ArrayList();
        pileDefausseTresor = new ArrayList();
        pileCarteInondation = new ArrayList();
        pileDefausseInondation = new ArrayList();
        collectionTresor = new ArrayList();
    }

    @Override
    public void traiterMessage(Message m) {
        switch (m.type) {

            case DEPLACER:
                System.out.println("Clic sur Deplacer");
                System.out.println(joueurCourant);
                vue.setVueDeplacement();
                vue.afficherTuileAccessible(joueurCourant.getTuilesAccessibles(grille));
                deplacement = true;
                break;

            case COORDONNEE: // ENLEVER TUILES TRESORS DE LA FONCTION QUI DISABLE TOUTES LES TUILES

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
                    if (joueurCourant instanceof Ingenieur) {
                        Ingenieur i = (Ingenieur) joueurCourant;
                        i.utiliseSpecial();
                        if (i.getSpecial() != 1) {
                            joueurCourant.setNbAction(joueurCourant.getNbAction() + 1);
                        } else if (i.getSpecial() == 1) {
                            System.out.println("Pouvoir utilisé");
                            i.reinitSpecial();
                        }
                    } else {
                        joueurCourant.setNbAction(joueurCourant.getNbAction() + 1);
                    }
                    vue.assecherTuile(m.lig, m.col);
                    grille.getTuile(m.lig, m.col).assecher();
                    assechement = false;
                }

                if (joueurCourant.getRole().getNomRole() != NomRole.NAVIGATEUR) {
                    if (joueurCourant.getNbAction() >= 3) {
                        vue.afficherFinTour();
                    } else {
                        vue.setVueBoutonsEnabled();
                    }
                } else { // Si le joueur est un navigateur, il dispose de 4 actions.
                    if (joueurCourant.getNbAction() >= 4) {
                        vue.afficherFinTour();
                    } else {
                        vue.setVueBoutonsEnabled();
                    }
                }
                break;

            case FINIRTOUR:
                System.out.println("Clic sur FINTOUR");
                if (joueurCourant instanceof Pilote) {
                    Pilote p = (Pilote) joueurCourant;
                    p.setUtilise(false);
                }

                if (this.joueurCourant.cartePossedees.size() + 2 > 5) {

                    Utils.afficherInformation("Choisir " + (this.joueurCourant.cartePossedees.size() + 2 - 5) + "carte a défausser");
                    defausser = true;
                    vue.activerCarte(numJoueurs);
                    System.out.println("suppr");
                    switch (m.type.DEFAUSSERCARTE){
                        case DEFAUSSERCARTE :
                        System.out.println("Defausser carte");
                        joueurCourant.defausserCarte(joueurCourant.cartePossedees.get(m.numCarte));
                        pileDefausseTresor.add(joueurCourant.cartePossedees.get(m.numCarte));
                        vue.supprimerCarte(numJoueurs, m.numCarte);
                        System.out.println("suppr");
                        defausser = this.joueurCourant.cartePossedees.size() > 5;
                    }

                }

                joueurCourant.piocherCarte(pileCarteTresor);
                vue.actualiserMain(joueurCourant, numJoueurs);
                joueurCourant.piocherCarteInondation(pileCarteInondation, nivEau);
                vue.actualiserGrille(grille);
                numJoueurs++;
                joueurCourant = joueurs.get(numJoueurs == joueurs.size() ? numJoueurs = 0 : numJoueurs);
                nbTour++;
                vue.afficherEtatJeu(nbTour, joueurCourant.getRole().getNomRole().toString());

                joueurCourant.finTour();
                vue.afficherDebutTour();

                break;

            case ASSECHER:
                System.out.println("Clic sur ASSECHER");
                vue.afficherTuileAssechable(joueurCourant.getTuilesInondees(grille));
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
                    if (joueur == NomRole.EXPLORATEUR) {
                        Explorateur explorateur = new Explorateur();
                        joueurs.add(explorateur);
                        explorateur.setApparition(grille.getTuile(2, 4));
                        grille.getTuile(2, 4).estSurTuile(explorateur);
                        System.out.println("EXPLORATEUR");
                    } else if (joueur == NomRole.PLONGEUR) {
                        Plongeur plongeur = new Plongeur();
                        joueurs.add(plongeur);
                        plongeur.setApparition(grille.getTuile(1, 2));
                        grille.getTuile(1, 2).estSurTuile(plongeur);
                        System.out.println("PLONGEUR");
                    } else if (joueur == NomRole.INGENIEUR) {
                        Ingenieur ingenieur = new Ingenieur();
                        joueurs.add(ingenieur);
                        ingenieur.setApparition(grille.getTuile(0, 3));
                        grille.getTuile(0, 3).estSurTuile(ingenieur);
                        System.out.println("INGENIEUR");
                    } else if (joueur == NomRole.MESSAGER) {
                        Messager messager = new Messager();
                        joueurs.add(messager);
                        messager.setApparition(grille.getTuile(2, 1));
                        grille.getTuile(2, 1).estSurTuile(messager);
                        System.out.println("MESSAGER");
                    } else if (joueur == NomRole.NAVIGATEUR) {
                        Navigateur navigateur = new Navigateur();
                        joueurs.add(navigateur);
                        navigateur.setApparition(grille.getTuile(1, 3));
                        grille.getTuile(1, 3).estSurTuile(navigateur);
                        System.out.println("NAVIGATEUR");
                    } else if (joueur == NomRole.PILOTE) {
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
                //Creation et distribution des cartes
                for (int i = 0; i < 5; i++) {                           //CARTE TRESOR
                    pileCarteTresor.add(new CarteTirage(Cartes.CALICE));
                    pileCarteTresor.add(new CarteTirage(Cartes.CRISTAL));
                    pileCarteTresor.add(new CarteTirage(Cartes.PIERRE));
                    pileCarteTresor.add(new CarteTirage(Cartes.ZEPHYR));
                }

                for (int i = 0; i < 2; i++) {                           //CARTE SPECIAL
                    pileCarteTresor.add(new CarteTirage(Cartes.MONTEEDESEAUX));
                    pileCarteTresor.add(new CarteTirage(Cartes.SACDESABLE));
                }

                for (int i = 0; i < 3; i++) {                           //CARTE HELICOPTERE
                    pileCarteTresor.add(new CarteTirage(Cartes.HELICOPTERE));
                }
                for (int i = 0; i < 24; i++) {                          //CARTE INNONDATION
                    pileCarteInondation.add(new CarteInondation(grille.getTuile().get(i)));
                }

                Collections.shuffle(pileCarteInondation);                      //MELANDE DES CARTES INNONDATION
                Collections.shuffle(pileCarteTresor);                         //MELANGE DES CARTES  TRESOR

                for (Aventurier joueur : joueurs) {                     //DISTRIBUTION DES CARTES
                    joueur.piocherCarte(pileCarteTresor);
                }
                vue.creeJeu(grille, joueurs);
                vue.setVueBoutonsEnabled();
                gagner = false;
                nivEau = m.getNiveauEau();
                nbTour = 1;
                joueurCourant = joueurs.get(numJoueurs);
                vue.afficherEtatJeu(nbTour, nivEau, joueurCourant.getRole().getNomRole().toString());

                break;

            case ANNULER:
                System.out.println("Annuler");
                vue.setVueBoutonsEnabled();
                vue.reinitialiserGrille();
                deplacement = false;
                assechement = false;
                break;
                
            case PRENDRETRESOR:
                System.out.println("Prendre Trésor");
                    if(grille.getTuile(m.lig, m.col) instanceof Tresor) {
                        Tresor t = (Tresor)grille.getTuile(m.lig, m.col);
                        int a = (t.getTresor()== NomTresors.CALICE? 0 : t.getTresor()== NomTresors.LION? 1 : t.getTresor()== NomTresors.PIERRE? 2 : 3 ); // Calice = 0, Lion = 1, Pierre = 2, Crystal = 3.
                        vue.tresorPris(a);
                        if(!collectionTresor.contains(t)) {
                            collectionTresor.add(t);
                        }
                    }
        }

    }

    public ArrayList<Aventurier> getJoueurs() {
        return joueurs;
    }

    public Grille getGrille() {
        return grille;
    }

    public ArrayList<CarteTirage> getPileCarte() {
        return pileCarteTresor;
    }

    public Vue getVue() {
        return vue;
    }

    public ArrayList<CarteTirage> getPileDefausse() {
        return pileDefausseTresor;
    }

}
