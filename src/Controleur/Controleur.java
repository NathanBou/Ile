/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

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
    private Aventurier joueurCible;
    private boolean gagner;
    private boolean deplacement;
    private boolean assechement;
    private boolean defausser;
    private boolean donnerCarte = false;
    private int numJoueurCible;
    private int nbTour;
    private int nivEau;
    private int grad;
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
                vue.setVueDeplacement();
                vue.afficherTuileAccessible(joueurCourant.getTuilesAccessibles(grille));
                deplacement = true;
                vue.afficherMessage1("Veuillez cliquer sur la case où vous voulez vous déplacer.");
                vue.afficherMessage2("“Annuler“ pour choisir une autre action à réaliser");
                break;

            case COORDONNEE: // ENLEVER TUILES TRESORS DE LA FONCTION QUI DISABLE TOUTES LES TUILES

                if (deplacement) {
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
                    vue.afficherMessage1("Déplacement vers la case :");
                    vue.afficherMessage2(grille.getTuile(m.lig, m.col).toString());

                } else if (assechement) {
                    if (joueurCourant instanceof Ingenieur) {
                        Ingenieur i = (Ingenieur) joueurCourant;
                        i.utiliseSpecial();
                        if (i.getSpecial() != 1) {
                            joueurCourant.setNbAction(joueurCourant.getNbAction() + 1);
                        }
                        i.reinitSpecial();
                        
                    } else {
                        joueurCourant.setNbAction(joueurCourant.getNbAction() + 1);
                    }
                    vue.assecherTuile(m.lig, m.col);
                    grille.getTuile(m.lig, m.col).assecher();
                    assechement = false;
                    vue.afficherMessage1("La case suivante a été asséchée :");
                    vue.afficherMessage2(grille.getTuile(m.lig, m.col).toString());
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
                if (joueurCourant instanceof Pilote) {
                    Pilote p = (Pilote) joueurCourant;
                    p.setUtilise(false);
                }
                if (this.joueurCourant.getCartePossedees().size() + 2 > 5) {

                    Utils.afficherInformation("Choisir " + (this.joueurCourant.cartePossedees.size() + 2 - 5) + " carte a défausser");
                    defausser = true;
                    if (joueurCourant.getCartePossedees().size() + 2 > 5) {
                        vue.activerCarte(numJoueurs);
                        vue.setVueBoutonsDesactive();
                    }
                }
                if (this.getPileCarte().size() <= 2) {
                    CarteTirage carte0 = (this.getPileCarte().size() == 1 ? this.getPileCarte().get(0) : null);
                    CarteTirage carte1 = (this.getPileCarte().size() == 2 ? this.getPileCarte().get(1) : null);
                    this.getPileCarte().remove(carte0);
                    joueurCourant.piocherCarte(carte0);
                    if (carte1 != null) {
                        joueurCourant.piocherCarte(carte0);
                        joueurCourant.piocherCarte(carte1);
                        this.getPileDefausse().add(carte0);
                        this.getPileDefausse().add(carte1);
                        this.refillPileCarte(pileDefausseTresor);
                    } else {
                        if (carte0 != null) {
                            joueurCourant.piocherCarte(carte0);
                            this.getPileDefausse().add(carte0);
                            this.refillPileCarte(pileDefausseTresor);
                        }
                    }
                    vue.actualiserMain(joueurCourant, numJoueurs);
                } else {
                    boolean montee = false;
                    montee = joueurCourant.piocherCarte(pileCarteTresor, pileDefausseTresor);
                    if (montee) {
                        grad++;
                        if (grad == 2 || grad == 5 || grad == 7) {
                            nivEau++;
                            vue.afficherEtatJeu(nivEau, grad);
                        }
                        
                        ArrayList<CarteInondation> temp = new ArrayList();
                        for (CarteInondation carte : this.getPileInondation()) {
                            temp.add(carte);
                        }
                        this.getPileInondation().clear();
                        Collections.shuffle(this.getPileDefausseInondation());
                        for (CarteInondation carte2 : this.getPileDefausseInondation()) {
                            this.getPileInondation().add(carte2);
                        }
                        for (CarteInondation carte2 : temp) {
                            this.getPileInondation().add(carte2);
                        }
                    }
                    vue.actualiserMain(joueurCourant, numJoueurs);
                }
                joueurCourant.piocherCarteInondation(this.getPileInondation(), this.getPileDefausseInondation(), nivEau);
                vue.actualiserGrille(grille);
                if (grad == 9) {
                    gagner = false;
                    vue.finirJeu(gagner);
                }
                if (!defausser) {
                    numJoueurs++;
                }
                joueurCourant = joueurs.get(numJoueurs == joueurs.size() ? numJoueurs = 0 : numJoueurs);
                nbTour++;
                vue.afficherEtatJeu(nbTour, nivEau, grad ,joueurCourant.getRole().getNomRole().toString());
                joueurCourant.debutTour();
                if (donnerCarte) {
                    if (this.joueurCourant.getCartePossedees().size() > 5) {
                        Utils.afficherInformation("Choisir " + (this.joueurCourant.cartePossedees.size() - 5) + " carte a défausser");
                        defausser = true;
                        vue.activerCarte(numJoueurs);
                        vue.setVueBoutonsDesactive();
                    }
                }
                vue.afficherDebutTour();
                vue.afficherMessage1(joueurCourant.toString()+", a vous de jouer !");
                vue.afficherMessage2("Choisissez une action à réaliser.");
                break;

            case ASSECHER:
                vue.afficherTuileAssechable(joueurCourant.getTuilesInondees(grille));
                vue.setVueAssecher();
                if (joueurCourant.getNbAction() == 3) {
                    vue.afficherFinTour();
                }
                assechement = true;
                vue.afficherMessage1("Veuillez cliquer sur la case à assécher.");
                vue.afficherMessage2("“Annuler“ pour choisir une autre action à réaliser");
                break;

            case INITIALISATIONGRILLE:
                joueurs = new ArrayList<Aventurier>();
                for (NomRole joueur : m.joueurs) {
                    if (joueur == NomRole.EXPLORATEUR) {
                        Explorateur explorateur = new Explorateur();
                        joueurs.add(explorateur);
                        explorateur.setApparition(grille.getTuile(2, 4));
                        grille.getTuile(2, 4).estSurTuile(explorateur);
                    } else if (joueur == NomRole.PLONGEUR) {
                        Plongeur plongeur = new Plongeur();
                        joueurs.add(plongeur);
                        plongeur.setApparition(grille.getTuile(1, 2));
                        grille.getTuile(1, 2).estSurTuile(plongeur);
                    } else if (joueur == NomRole.INGENIEUR) {
                        Ingenieur ingenieur = new Ingenieur();
                        joueurs.add(ingenieur);
                        ingenieur.setApparition(grille.getTuile(0, 3));
                        grille.getTuile(0, 3).estSurTuile(ingenieur);
                    } else if (joueur == NomRole.MESSAGER) {
                        Messager messager = new Messager();
                        joueurs.add(messager);
                        messager.setApparition(grille.getTuile(2, 1));
                        grille.getTuile(2, 1).estSurTuile(messager);
                    } else if (joueur == NomRole.NAVIGATEUR) {
                        Navigateur navigateur = new Navigateur();
                        joueurs.add(navigateur);
                        navigateur.setApparition(grille.getTuile(1, 3));
                        grille.getTuile(1, 3).estSurTuile(navigateur);
                    } else if (joueur == NomRole.PILOTE) {
                        Pilote pilote = new Pilote();
                        joueurs.add(pilote);
                        pilote.setApparition(grille.getTuile(2, 3));
                        grille.getTuile(2, 3).estSurTuile(pilote);
                    }
                }
                Collections.shuffle(joueurs);
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
                    joueur.piocherCarte(pileCarteTresor, pileDefausseTresor);
                }
                vue.creeJeu(grille, joueurs);
                vue.setVueBoutonsEnabled();
                gagner = false;
                nivEau = m.getNiveauEau();
                grad = m.getGrad();
                nbTour = 1;
                joueurCourant = joueurs.get(numJoueurs);
                vue.afficherEtatJeu(nbTour, nivEau, grad, joueurCourant.getRole().getNomRole().toString());
                vue.afficherMessage2(joueurCourant.toString()+", a toi de jouer !");

                break;

            case ANNULER:
                vue.setVueBoutonsEnabled();
                vue.desactiverJoueur();
                vue.reinitialiserGrille();
                deplacement = false;
                assechement = false;
                break;

            case PRENDRETRESOR:
                if (joueurCourant.getEstSurTuile() instanceof Tresor) {
                    Tresor t = (Tresor) joueurCourant.getEstSurTuile();
                    
                    NomTresors nt = t.getTresor();
                    if(joueurCourant.containsQuatre(nt)) {
                        this.collectionTresor.add(t);
                        joueurCourant.enleverCartesPourTresor(t);
                        vue.tresorPris(nt==NomTresors.CALICE?0:nt==NomTresors.ZEPHYR?1:nt==NomTresors.PIERRE?2:3);
                    } else {
                        vue.afficherMessage1("Il faut 4 cartes du même type pour");
                        vue.afficherMessage2("ramasser le trésor correspondant.");
                    }
                } else {
                    vue.afficherMessage1("Vous n'êtes pas sur une casee à trésor.");
                    vue.afficherMessage2("Choisissez une autre action.");
                }
                
                
                
                /*if (grille.getTuile(m.lig, m.col) instanceof Tresor) {
                    Tresor t = (Tresor) grille.getTuile(m.lig, m.col);
                    NomTresors nt = t.getTresor();
                    int compt = 0;
                    for (CarteTirage ct : joueurCourant.getCartePossedees()) {
                        if (ct.getNomCarte().toString().equals(nt.toString())) {
                            compt += 1;
                        }
                    }
                    if (compt >= 4) {
                        int i = 0;
                        int compt2 = 0;
                        int a = (nt == NomTresors.CALICE ? 0 : nt == NomTresors.ZEPHYR ? 1 : nt == NomTresors.PIERRE ? 2 : 3); // Calice = 0, Lion = 1, Pierre = 2, Crystal = 3.
                        vue.tresorPris(a);
                        while (compt2 != 4) {
                            if (joueurCourant.getCartePossedees().get(i).getNomCarte().toString() == nt.toString()) {
                                joueurCourant.getCartePossedees().remove(joueurCourant.getCartePossedees().get(i));
                                compt2++;
                            } else {
                                i++;
                            }
                        }
                    }
                }*/
                break;

            case CARTE:
                if (defausser) {
                    this.getPileDefausse().add(joueurCourant.getCartePossedees().get(m.numCarte));
                    joueurCourant.getCartePossedees().remove(joueurCourant.getCartePossedees().get(m.numCarte));
                    vue.supprimerCarte(numJoueurs, m.numCarte);
                    vue.actualiserMain(joueurCourant, numJoueurs);
                    vue.setVueBoutonsEnabled();
                    if (joueurCourant.getCartePossedees().size() <= 5) {
                        vue.disableBoutonsMain(numJoueurs);
                        vue.actualiserMain(joueurCourant, numJoueurs);
                        joueurCourant.debutTour();
                        numJoueurs++;
                        joueurCourant = joueurs.get(numJoueurs == joueurs.size() ? numJoueurs = 0 : numJoueurs);
                        nbTour++;
                        vue.afficherEtatJeu(nbTour, joueurCourant.getRole().getNomRole().toString());
                        defausser = false;

                    }

                } else if (donnerCarte) {
                    joueurCourant.donnerCarte(this.getJoueurCible(), joueurCourant.getCartePossedees().get(m.getNumCarte()));
                    vue.actualiserMain(this.getJoueurCible(), this.getNumJoueurCible());
                    vue.actualiserMain(joueurCourant, numJoueurs);
                    vue.desactiverJoueur();
                    vue.disableBoutonsMain(numJoueurs);
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
                }
                break;
            case DONNERCARTE:
                if(joueurCourant.getEstSurTuile().getASurTuile().size()>1) {
                    vue.setVueDonnerCarte();
                    vue.activerJoueur(joueurCourant, this.joueurCourant.getEstSurTuile().getASurTuile());
                    vue.afficherMessage1("Sélectionnez le joueur à qui donner une carte.");
                    vue.afficherMessage2("Annuler pour changer d'action à réaliser.");
                } else {
                    vue.afficherMessage1("Aucun autre aventurier sur la même case");
                    vue.afficherMessage2("Veuillez choisir une autre action.");
                }
                break;
            case JOUEURCIBLE:
                donnerCarte = true;
                setJoueurCible(this.joueurs.get(m.getNumJoueur()));
                numJoueurCible = m.getNumJoueur();
                vue.activerCarte(this.numJoueurs);
                vue.desactiverJoueur();
                vue.afficherMessage1("Sélectionnez la carte à donner à");
                vue.afficherMessage2(this.joueurs.get(m.getNumJoueur()).toString());
                break;
            case CARTESPECIAL:
                vue.activerCarteSpecial(this.numJoueurs);
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

    public Aventurier getJoueurCible() {
        return joueurCible;
    }

    public void setJoueurCible(Aventurier joueurCible) {
        this.joueurCible = joueurCible;
    }

    public int getNumJoueurCible() {
        return numJoueurCible;
    }

    public void setNumJoueurCible(int numJoueurCible) {
        this.numJoueurCible = numJoueurCible;
    }

    private void refillPileCarte(ArrayList<CarteTirage> pileDefausse) {
        this.pileCarteTresor.clear();
        Collections.shuffle(pileDefausse);
        for (CarteTirage carte : pileDefausse) {
            this.getPileCarte().add(carte);
        }
    }

    private ArrayList<CarteInondation> getPileInondation() {
        return this.pileCarteInondation;
    }

    public ArrayList<CarteInondation> getPileDefausseInondation() {
        return this.pileDefausseInondation;
    }

}
