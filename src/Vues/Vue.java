package Vues;

import Controleur.Message;
import Controleur.TypesMessage;
import Controleur.Observateur;
import Controleur.Observe;
import Modele.Aventurier;
import Modele.CarteTirage;
import Modele.Cartes;
import Modele.Grille;
import Modele.Grille;
import Modele.NomRole;
import Modele.NomTuile;
import Modele.Tuile;
import Modele.Utils;
import Modele.Utils.EtatTuile;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import static java.awt.SystemColor.window;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import Vues.CelluleTuile;

public class Vue implements Observe {

    private final JFrame fenetreInit = new JFrame();
    private final JFrame fenetreJeu = new JFrame();
    private JPanel panelGrilleTuile;
    private Observateur observateur;
    private JLabel tour = new JLabel("", SwingConstants.CENTER);
    private JLabel niveau = new JLabel("", SwingConstants.CENTER);
    private JLabel joueur = new JLabel("", SwingConstants.CENTER);
    private Carte carte;
    private JButton[][] tabTuile;
    private JButton[][] tabCarte;
    private JButton prendreTresor;
    private JButton donnerCarte;
    private JButton deplacer;
    private JButton assecher;
    private JButton annuler;
    private JButton finTour;
    private JPanel panelCartes1;
    private JPanel panelCartes2;
    private JPanel panelCartes3;
    private JPanel panelCartes4;
    private JCheckBox[] selectionJoueurs;
    private JButton calice;
    private JButton lion;
    private JButton pierre;
    private JButton crystal;

    public Vue() {
        fenetreInit.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        fenetreInit.setTitle("L 'ILE INTERDITE INITIALISATION");
        // Définit la taille de la fenêtre en pixels
        fenetreInit.setSize(650, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        fenetreInit.setLocation(dim.width / 2 - fenetreJeu.getSize().width / 2, dim.height / 2 - fenetreJeu.getSize().height / 2);
        JPanel mainPanelInit = new JPanel(new GridLayout(2, 0));
        for (int k = 0; k <= 1; k++) {
            if (k == 0) {
                JPanel panelJoueur = new JPanel(new BorderLayout());
                JLabel titreJeu = new JLabel("BIENVENUE SUR L'ILE INTERDITE");
                titreJeu.setForeground(Color.BLUE);
                titreJeu.setFont(new Font("Dialog", Font.BOLD, 30));
                titreJeu.setHorizontalAlignment(JLabel.CENTER);
                panelJoueur.add(titreJeu, BorderLayout.NORTH);
                mainPanelInit.add(panelJoueur);
            } else {
                JPanel panelAventurier = new JPanel(new BorderLayout());
                JLabel saisirJ = new JLabel("Cocher le nombre de joueur");
                JLabel messageErreur = new JLabel("", SwingConstants.CENTER);
                saisirJ.setHorizontalAlignment(JLabel.CENTER);
                JPanel casesTexte = new JPanel(new GridLayout(2,0));
                panelAventurier.add(casesTexte, BorderLayout.NORTH);
                casesTexte.add(saisirJ);
                casesTexte.add(messageErreur);
                JCheckBox explorateur = new JCheckBox("Explorateur");
                JCheckBox ingenieur = new JCheckBox("Ingenieur");
                JCheckBox messager = new JCheckBox("Messager");
                JCheckBox navigateur = new JCheckBox("Navigateur");
                JCheckBox pilote = new JCheckBox("Pilote");
                JCheckBox plongeur = new JCheckBox("Plongeur");
                JPanel panelBAventu = new JPanel(new GridLayout(0, 6));
                selectionJoueurs = new JCheckBox[6];
                for (int j = 0; j < 6; j++) {
                    if (j == 0) {
                        selectionJoueurs[j] = explorateur;
                        panelBAventu.add(explorateur);
                    } else if (j == 1) {
                        selectionJoueurs[j] = ingenieur;
                        panelBAventu.add(ingenieur);
                    } else if (j == 2) {
                        selectionJoueurs[j] = messager;
                        panelBAventu.add(messager);
                    } else if (j == 3) {
                        selectionJoueurs[j] = navigateur;
                        panelBAventu.add(navigateur);
                    } else if (j == 4) {
                        selectionJoueurs[j] = plongeur;
                        panelBAventu.add(plongeur);
                    } else {
                        selectionJoueurs[j] = pilote;
                        panelBAventu.add(pilote);
                    }
                }
                

                panelAventurier.add(panelBAventu, BorderLayout.CENTER);
                JButton valider = new JButton("Valider");
                panelAventurier.add(valider, BorderLayout.SOUTH);
                
                valider.addActionListener(
                        new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Message m = new Message(TypesMessage.INITIALISATIONGRILLE);
                        int compt = 0;
                        for (int i = 0; i < selectionJoueurs.length; i++) {
                            if (selectionJoueurs[i].isSelected()) {
                                compt += 1;
                            }
                        }
                        if (compt >= 2 && compt <= 4) {
                            if(explorateur.isSelected()) {
                                m.ajouterJoueur(NomRole.EXPLORATEUR);
                            }
                            if(ingenieur.isSelected()) {
                                m.ajouterJoueur(NomRole.INGENIEUR);
                            }
                            if(messager.isSelected()) {
                                m.ajouterJoueur(NomRole.MESSAGER);
                            }
                            if(navigateur.isSelected()) {
                                m.ajouterJoueur(NomRole.NAVIGATEUR);
                            }
                            if(plongeur.isSelected()) {
                                m.ajouterJoueur(NomRole.PLONGEUR);
                            }
                            if(pilote.isSelected()) {
                                m.ajouterJoueur(NomRole.PILOTE);
                            }
                            notifierObservateur(m);
                            fenetreInit.dispose();
                        } else {
                            messageErreur.setText("Veuillez ne sélectionner que 2, 3 ou 4 joueurs.");
                        }
                    }
                });
                mainPanelInit.add(panelAventurier);
                
            }
        }

        fenetreInit.add(mainPanelInit);
        fenetreInit.setVisible(true);

    }

    public void creeJeu(Grille grille, ArrayList<Aventurier> joueurs) {

        fenetreJeu.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        fenetreJeu.setTitle("L 'ILE INTERDITE");
        // Définit la taille de la fenêtre en pixels
        fenetreJeu.setSize(1650, 950);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        fenetreJeu.setLocation(dim.width / 2 - fenetreJeu.getSize().width / 2, dim.height / 2 - fenetreJeu.getSize().height / 2);
        // Panel Principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        fenetreJeu.add(mainPanel);
        // Panel Haut
        JPanel panelHaut = new JPanel();
        panelHaut.setBackground(Color.GREEN);
        panelHaut.setPreferredSize(new Dimension(1650, 100));
        mainPanel.add(panelHaut, BorderLayout.NORTH);
        // Panel EST/OUEST
        JPanel panelEst = new JPanel();
        JPanel panelOuest = new JPanel();
        panelEst.setPreferredSize(new Dimension(10, 950));
        panelOuest.setPreferredSize(new Dimension(10, 950));
        panelEst.setBackground(Color.MAGENTA);
        panelOuest.setBackground(Color.MAGENTA);
        mainPanel.add(panelEst, BorderLayout.EAST);
        mainPanel.add(panelOuest, BorderLayout.WEST);

        // Panel MillieuSystem.out.println(joueurCourant);
        JPanel panelMilieu = new JPanel(new BorderLayout()); // BorderLayout.CENTER
        JPanel panelCentre = new JPanel(new GridLayout(0, 2)); //SEPARATION GRILLE / COMMANDE
        JPanel panelGrille = new JPanel(new BorderLayout()); //Pânel contenant la grille
        for (int j = 0; j <= 1; j++) {
            if (j == 0) {
                JPanel panelGrilleTuile = new JPanel(new GridLayout(6, 6, 2, 2)); //Grille
                tabTuile = new JButton[6][6];
                for (int i = 0; i < 6; i++) {
                    for (int k = 0; k < 6; k++) {
                        if (grille.getTuile(i, k).getNomTuile() == NomTuile.BORDURE) {
                            if((i==0 && k==0) || (i==0 && k==5) || (i==5 && k==0) || (i==5 && k==5)) {
                                if(i==0) {
                                    if(k==0) {
                                        calice = new CelluleTuile(i, k);
                                        calice.setText("Calice");
                                        tabTuile[i][k] = calice;
                                        panelGrilleTuile.add(calice);
                                        calice.setBackground(new Color(0, 149, 182));
                                        calice.setForeground(Color.WHITE);
                                    } else {
                                        pierre = new CelluleTuile(i, k);
                                        pierre.setText("Pierre");
                                        tabTuile[i][k] = pierre;
                                        panelGrilleTuile.add(pierre);
                                        pierre.setBackground(new Color(91, 60, 17));
                                        pierre.setForeground(Color.WHITE);
                                    }
                                } else {
                                    if(k==0) {
                                        lion = new CelluleTuile(i, k);
                                        lion.setText("Lion");
                                        tabTuile[i][k] = lion;
                                        panelGrilleTuile.add(lion);
                                        lion.setBackground(new Color(120,120,120));
                                        lion.setForeground(Color.WHITE);
                                    } else {
                                        crystal = new CelluleTuile(i, k);
                                        crystal.setText("Rubis");
                                        tabTuile[i][k] = crystal;
                                        panelGrilleTuile.add(crystal);
                                        crystal.setBackground(Color.RED);
                                        crystal.setForeground(Color.WHITE);
                                    }
                                }
                            } else {
                            panelGrilleTuile.add(new JLabel("", SwingConstants.CENTER));
                            CelluleTuile tuile = new CelluleTuile(i, k);
                            tabTuile[i][k] = tuile;
                            }
                        } else {
                            CelluleTuile bTuile = new CelluleTuile(i, k);
                            tabTuile[i][k] = bTuile;
                            bTuile.setText(grille.getTuile(i, k).getNomTuile().toString());
                            bTuile.setFont(new Font("Dialog", Font.BOLD, 10));
                            if (grille.getTuile(i, k).getEtat() == Utils.EtatTuile.COULEE) {
                                bTuile.setBackground(Color.lightGray);
                            } else if (grille.getTuile(i, k).getEtat() == Utils.EtatTuile.INONDEE) {
                                bTuile.setBackground(new Color(30, 127, 203));
                            }
                            if (!grille.getTuile(i, k).getASurTuile().isEmpty()) {
                                bTuile.setBorder(BorderFactory.createLineBorder(grille.getTuile(i, k).getASurTuile().get(0).getRole().getCouleur().getCouleur(), 4));
                            }
                            bTuile.setEnabled(false);
                            bTuile.setPreferredSize(new Dimension(118, 118));
                            bTuile.addActionListener(
                                    new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    Message m = new Message(TypesMessage.COORDONNEE);
                                    m.setLig(bTuile.lig_cellule);
                                    m.setCol(bTuile.col_cellule);
                                    notifierObservateur(m);
                                }
                            });
                            panelGrilleTuile.add(bTuile);
                        }
                    }

                }
                panelGrille.add(panelGrilleTuile);                         // Ajout de la grille dans le panel
                JPanel panelEstG = new JPanel();
                JPanel panelOuestG = new JPanel();
                panelEstG.setPreferredSize(new Dimension(10, 950));
                panelOuestG.setPreferredSize(new Dimension(10, 950));
                panelEstG.setBackground(Color.blue);
                panelOuestG.setBackground(Color.BLUE);
                panelGrille.add(panelEstG, BorderLayout.EAST);
                panelGrille.add(panelOuestG, BorderLayout.WEST);
                panelCentre.add(panelGrille);
            } else {
                // Panel Top
                JPanel panelBouton = new JPanel(new BorderLayout());
                JPanel panelInfo = new JPanel(new GridLayout(0, 3));
                JLabel Tour = new JLabel();
                tour.setText("Tour numéro : ");
                niveau.setText("Niveau d'eau : ");
                joueur.setText("Joueur : ");
                tour.setPreferredSize(new Dimension(200, 100));
                niveau.setPreferredSize(new Dimension(200, 100));
                joueur.setPreferredSize(new Dimension(200, 100));
                panelInfo.add(tour);
                panelInfo.add(niveau);
                panelInfo.add(joueur);

                // PanelCartes
                JPanel panelCartes = new JPanel(new GridLayout(2, 2, 4, 4));

                JPanel BorderCartes1 = new JPanel(new BorderLayout());
                JPanel BorderCartes2 = new JPanel(new BorderLayout());
                JPanel BorderCartes3 = new JPanel(new BorderLayout());
                JPanel BorderCartes4 = new JPanel(new BorderLayout());

                panelCartes1 = new JPanel(new GridLayout(3, 3));
                panelCartes2 = new JPanel(new GridLayout(3, 3));
                panelCartes3 = new JPanel(new GridLayout(3, 3));
                panelCartes4 = new JPanel(new GridLayout(3, 3));

                panelCartes.add(BorderCartes1);
                panelCartes.add(BorderCartes2);
                panelCartes.add(BorderCartes3);
                panelCartes.add(BorderCartes4);

                BorderCartes1.add(panelCartes1, BorderLayout.CENTER);
                BorderCartes2.add(panelCartes2, BorderLayout.CENTER);
                BorderCartes3.add(panelCartes3, BorderLayout.CENTER);
                BorderCartes4.add(panelCartes4, BorderLayout.CENTER);

                // dessin carrés dans panelCartes1,2,3 et 4
                tabCarte= new JButton[joueurs.size()][9];
                for (int a = 0; a < joueurs.size(); a++) {
                    for (int i = 0; i < 9; i++) {                        
                        if(i < joueurs.get(a).getCartePossedees().size()){
                            carte = new Carte(a,i,joueurs.get(a).getCartePossedees().get(i).getNomCarte().toString());                            
                        }else{
                            carte = new Carte(a,i,"/");
                        }
                        tabCarte[a][i]=carte;
                        carte.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Message m = new Message(TypesMessage.DEFAUSSERCARTE);
                                m.setNumCarte(carte.getNumCarte());
                                notifierObservateur(m);
                            }
                        });
                        carte.setEnabled(false);
                        if (a == 0) {
                            panelCartes1.add(carte);
                        } else if (a == 1) {
                            panelCartes2.add(carte);
                        } else if (a == 2) {
                            panelCartes3.add(carte);
                        } else if (a == 3) {
                            panelCartes4.add(carte);
                        }
                    }
                    if (a == 0) {
                        BorderCartes1.add(new JLabel(joueurs.get(a).getRole().getNomRole().toString()), BorderLayout.NORTH);
                    } else if (a == 1) {
                        BorderCartes2.add(new JLabel(joueurs.get(a).getRole().getNomRole().toString()), BorderLayout.NORTH);
                    } else if (a == 2) {
                        BorderCartes3.add(new JLabel(joueurs.get(a).getRole().getNomRole().toString()), BorderLayout.NORTH);
                    } else if (a == 3) {
                        BorderCartes4.add(new JLabel(joueurs.get(a).getRole().getNomRole().toString()), BorderLayout.NORTH);
                    }
                }

                // Panel Centre
                JPanel panelGrilleBouton = new JPanel(new GridLayout(2, 5));
                for (int v = 0; v <= 5; v++) {
                    if (v == 0) {
                        finTour = new JButton("Fin tour");
                        finTour.setPreferredSize(new Dimension(40, 25));
                        panelGrilleBouton.add(finTour);
                        finTour.addActionListener(
                                new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Message m = new Message(TypesMessage.FINIRTOUR);
                                notifierObservateur(m);
                            }
                        });

                    } else if (v == 1) {
                        deplacer = new JButton("Se déplacer");
                        deplacer.setPreferredSize(new Dimension(40, 25));
                        deplacer.addActionListener(
                                new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Message m = new Message(TypesMessage.DEPLACER);
                                notifierObservateur(m);
                            }
                        });
                        panelGrilleBouton.add(deplacer);

                    } else if (v == 2) {
                        assecher = new JButton("Assécher");
                        assecher.setPreferredSize(new Dimension(40, 25));
                        assecher.addActionListener(
                                new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Message m = new Message(TypesMessage.ASSECHER);
                                notifierObservateur(m);
                            }
                        });
                        panelGrilleBouton.add(assecher);
                    } else if (v == 3) {
                        donnerCarte = new JButton("Donner une carte");
                        donnerCarte.setPreferredSize(new Dimension(40, 25));
                        panelGrilleBouton.add(donnerCarte);                     //ActionListener a ajouter
                    } else if (v == 4) {
                        prendreTresor = new JButton("Prendre trésor");
                        prendreTresor.setPreferredSize(new Dimension(40, 25));
                        panelGrilleBouton.add(prendreTresor);                   //ActionListener a ajouter
                    } else if (v == 5) {
                        annuler = new JButton("Annuler");
                        annuler.setPreferredSize(new Dimension(40, 25));
                        panelGrilleBouton.add(annuler);
                        annuler.setEnabled(false);                              //ActionListener a ajouter
                        annuler.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Message m = new Message(TypesMessage.ANNULER);
                                notifierObservateur(m);

                            }
                        });
                    }

                }
                panelBouton.add(panelInfo, BorderLayout.NORTH);
                panelBouton.add(panelGrilleBouton, BorderLayout.SOUTH);
                panelBouton.add(panelCartes, BorderLayout.CENTER);
                panelCentre.add(panelBouton);

            }
        }
        
        calice = new JButton("Calice");
        pierre = new JButton("Pierre");
        lion = new JButton("Lion");
        crystal = new JButton("Rubis");
        
        
        
        panelMilieu.add(panelCentre);
        mainPanel.add(panelMilieu, BorderLayout.CENTER);
        // Panel Bas
        JPanel panelBas = new JPanel();
        panelBas.setBackground(Color.PINK);
        panelBas.setPreferredSize(new Dimension(1650, 100));
        mainPanel.add(panelBas, BorderLayout.SOUTH);
        fenetreJeu.setVisible(true);
    }

    public void afficherTuileAccessible(ArrayList<Tuile> tuilesAccessibles) {
        for (Tuile tuile : tuilesAccessibles) {
            for (int i = 0; i < 6; i++) {
                for (int k = 0; k < 6; k++) {
                    if (i == tuile.getLig() && k == tuile.getCol()) {
                        tabTuile[i][k].setEnabled(true);
                    }
                }

            }
        }
    }

    public void afficherDeplacement(int lig, int col, Aventurier joueur, Tuile tuileAvantDeplacement) {
        tabTuile[tuileAvantDeplacement.getLig()][tuileAvantDeplacement.getCol()].setBorder((BorderFactory.createLineBorder(Color.LIGHT_GRAY)));
        tabTuile[lig][col].setBorder(BorderFactory.createLineBorder(joueur.getRole().getCouleur().getCouleur(), 4));
        this.reinitialiserGrille();
    }

    public void afficherDeplacement(int lig, int col, Aventurier joueur, Tuile tuileAvantDeplacement, Tuile tuileApresDeplacement) {
        tabTuile[tuileAvantDeplacement.getLig()][tuileAvantDeplacement.getCol()].setBorder((BorderFactory.createLineBorder(Color.LIGHT_GRAY)));
        tabTuile[tuileApresDeplacement.getLig()][tuileApresDeplacement.getCol()].setBorder(BorderFactory.createLineBorder(joueur.getRole().getCouleur().getCouleur(), 4));
        for (int i = 0; i < 6; i++) {
            for (int k = 0; k < 6; k++) {
                tabTuile[i][k].setEnabled(false);
            }

        }
    }
    public void actualiserMain(Aventurier joueur,int numJoueur){
        tabCarte[numJoueur][joueur.cartePossedees.size()-2].setText(joueur.cartePossedees.get(joueur.cartePossedees.size()-2).getNomCarte().toString());
        tabCarte[numJoueur][joueur.cartePossedees.size()-1].setText(joueur.cartePossedees.get(joueur.cartePossedees.size()-1).getNomCarte().toString());
    }
    public void supprimerCarte(int numJoueurs,int numCarte){
        tabCarte[numJoueurs][numCarte].setText("/");
    }
    public void assecherTuile(int lig, int col) {
        tabTuile[lig][col].setBackground(null);
        tabTuile[lig][col].setEnabled(false);
    }

    public void afficherTuileAssechable(ArrayList<Tuile> tuilesInondees) {
        for (Tuile tuile : tuilesInondees) {
            for (int i = 0; i < 6; i++) {
                for (int k = 0; k < 6; k++) {
                    if (i == tuile.getLig() && k == tuile.getCol()) {
                        tabTuile[i][k].setEnabled(true);
                    }
                }

            }
        }
    }
    public void activerCarte(int numJoueur){
        for (int i =0;i<9;i++){
            tabCarte[numJoueur][i].setEnabled(true);
        }
    }
    public void afficherFinTour() {

        finTour.setEnabled(true);
        deplacer.setEnabled(false);
        deplacer.setBackground(Color.GREEN);
        assecher.setEnabled(false);
        assecher.setBackground(Color.GREEN);
        prendreTresor.setEnabled(false);
        donnerCarte.setEnabled(false);
        annuler.setEnabled(false);
        annuler.setBackground(Color.GREEN);
    }

    public void afficherDebutTour() {
        deplacer.setEnabled(true);
        assecher.setEnabled(true);
        prendreTresor.setEnabled(true);
        donnerCarte.setEnabled(true);
    }

    public void afficherEtatJeu(int nbTour, int nivEau, String nomJoueur) {
        tour.setText("Tour numero :" + nbTour);
        niveau.setText("Niveau d'eau :" + nivEau);
        joueur.setText("Joueur :" + nomJoueur);
    }

    public void afficherEtatJeu(int nbTour) {
        tour.setText("Tour numero :" + nbTour);
    }

    public void afficherEtatJeu(int nbTour, String nomJoueur) {
        tour.setText("Tour numero :" + nbTour);
        joueur.setText("Joueur :" + nomJoueur);
    }

    public void setVueDeplacement() {
        deplacer.setBackground(Color.BLUE);
        deplacer.setEnabled(false);
        prendreTresor.setEnabled(false);
        donnerCarte.setEnabled(false);
        assecher.setEnabled(false);
        finTour.setEnabled(false);
        annuler.setBackground(Color.RED);
        annuler.setEnabled(true);
    }

    public void setVueAssecher() {
        assecher.setBackground(Color.BLUE);
        deplacer.setEnabled(false);
        prendreTresor.setEnabled(false);
        donnerCarte.setEnabled(false);
        assecher.setEnabled(false);
        finTour.setEnabled(false);
        annuler.setBackground(Color.RED);
        annuler.setEnabled(true);
    }

    public void setVuePrendreTresor() {
        prendreTresor.setBackground(Color.BLUE);
        deplacer.setEnabled(false);
        prendreTresor.setEnabled(false);
        donnerCarte.setEnabled(false);
        assecher.setEnabled(false);
        annuler.setBackground(Color.RED);
        annuler.setEnabled(true);
    }

    public void setVueDonnerCarte() {
        donnerCarte.setBackground(Color.BLUE);
        deplacer.setEnabled(false);
        prendreTresor.setEnabled(false);
        donnerCarte.setEnabled(false);
        assecher.setEnabled(false);
        annuler.setBackground(Color.RED);
        annuler.setEnabled(true);
    }

    public void setVueBoutonsEnabled() {
        deplacer.setBackground(Color.GREEN);
        deplacer.setEnabled(true);
        prendreTresor.setBackground(Color.GREEN);
        prendreTresor.setEnabled(true);
        donnerCarte.setBackground(Color.GREEN);
        donnerCarte.setEnabled(true);
        assecher.setBackground(Color.GREEN);
        assecher.setEnabled(true);
        finTour.setEnabled(true);
        annuler.setBackground(Color.GREEN);
        annuler.setEnabled(false);
    }

    public void reinitialiserGrille() {
        for (int i = 0; i < 6; i++) {
            for (int k = 0; k < 6; k++) {
                tabTuile[i][k].setEnabled(false);
            }

        }
    }
    public void actualiserGrille(Grille g){
        for (int i = 0; i < 6; i++) {
            for (int k = 0; k < 6; k++) {
                if (g.getTuile(i, k).getEtat() == Utils.EtatTuile.COULEE && g.getTuile(i, k).getNomTuile()!=NomTuile.BORDURE) {
                    //System.out.println(g.getTuile(i, k).getNomTuile().toString());
                    tabTuile[i][k].setBackground(Color.lightGray);
                } else if (g.getTuile(i, k).getEtat() == Utils.EtatTuile.INONDEE) {
                    tabTuile[i][k].setBackground(new Color(30, 127, 203));
                }
            }

        }
    }

    public void addObservateur(Observateur o) {
        this.observateur = o;
    }

    public void notifierObservateur(Message m) {
        if (observateur != null) {
            observateur.traiterMessage(m);
        }
    }

    public void tresorPris(int a) {
        if(a==0) {
            calice.setEnabled(false);
        } else if(a==1) {
            lion.setEnabled(false);
        } else if(a==2) {
            pierre.setEnabled(false);
        } else {
            crystal.setEnabled(false);
        }
    }

}
