package Vues;

import Controleur.Message;
import Controleur.TypesMessage;
import Controleur.Observateur;
import Controleur.Observe;
import Modele.Grille;
import Modele.Grille;
import Modele.Tuile;
import Modele.Utils;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import static java.awt.SystemColor.window;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Vue implements Observe {

    private final JFrame fenetreInit = new JFrame();
    private final JFrame fenetreJeu = new JFrame();
    private JPanel panelGrilleTuile;
    private Observateur observateur;

    public Vue() {

        fenetreInit.setTitle("L 'ILE INTERDITE INITIALISATION");
        // Définit la taille de la fenêtre en pixels
        fenetreInit.setSize(650, 500);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        fenetreInit.setLocation(dim.width / 2 - fenetreJeu.getSize().width / 2, dim.height / 2 - fenetreJeu.getSize().height / 2);
        JPanel mainPanelInit = new JPanel(new GridLayout(2,0));
        for (int k = 0; k <= 1; k++) {
            if (k==0){
                JPanel panelJoueur = new JPanel(new BorderLayout());
                JLabel titreJeu = new JLabel("BIENVENUE SUR L'ILE INTERDITE");
                titreJeu.setForeground(Color.BLUE);
                titreJeu.setFont(new Font("Dialog",Font.BOLD,30));
                titreJeu.setHorizontalAlignment(JLabel.CENTER);
                panelJoueur.add(titreJeu,BorderLayout.NORTH);
                mainPanelInit.add(panelJoueur);
            }else{
                JPanel panelAventurier = new JPanel(new BorderLayout()); 
                JLabel saisirJ = new JLabel("Cocher le nombre de joueur");
                saisirJ.setHorizontalAlignment(JLabel.CENTER);
                panelAventurier.add(saisirJ,BorderLayout.NORTH);
                JCheckBox explorateur = new JCheckBox("Explorateur");
                JCheckBox ingenieur = new JCheckBox("Ingenieur");
                JCheckBox messager = new JCheckBox("Messager");
                JCheckBox navigateur = new JCheckBox("Navigateur");
                JCheckBox pilote = new JCheckBox("Pilote");
                JCheckBox plongeur = new JCheckBox("Plongeur");
                JPanel panelBAventu = new JPanel(new GridLayout(0,6));
                for (int j=0;j<6;j++){
                    if (j==0){
                        panelBAventu.add(explorateur);
                    }else if (j==1){
                        panelBAventu.add(ingenieur);
                    }else if (j==2){
                        panelBAventu.add(messager);
                    }else if (j==3){
                        panelBAventu.add(navigateur);
                    }else if (j==4){
                        panelBAventu.add(plongeur);
                    }else{
                        panelBAventu.add(pilote);                   
                    }
                }
                
                
                
                
                panelAventurier.add(panelBAventu, BorderLayout.CENTER);
                JButton valider = new JButton ("Valider");
                panelAventurier.add(valider, BorderLayout.SOUTH);
                valider.addActionListener(
                                new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Message m = new Message(TypesMessage.INITIALISATIONGRILLE);
                                notifierObservateur(m);
                                fenetreInit.dispose();
                            }
                        });
                mainPanelInit.add(panelAventurier);
            }
        }
        
        
        
        
        fenetreInit.add(mainPanelInit);
        fenetreInit.setVisible(true);
    }

    public void creeJeu(Grille grille) {

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

        // Panel Millieu
        JPanel panelMilieu = new JPanel(new BorderLayout()); // BorderLayout.CENTER
        JPanel panelCentre = new JPanel(new GridLayout(0, 2)); //SEPARATION GRILLE / COMMANDE
        JPanel panelGrille = new JPanel(new BorderLayout()); //Pânel contenant la grille
        for (int j = 0; j <= 1; j++) {
            if (j == 0) {
                JPanel panelGrilleTuile = new JPanel(new GridLayout(6, 6, 2 ,2)); //Grille
                for (int i = 0; i <= 35; i++) {
                    if (i == 0 || i == 1 || i == 4 || i == 5 || i == 6 || i == 11 || i == 24 || i == 29 || i == 30 || i == 31 || i == 34 || i == 35) {
                        panelGrilleTuile.add(new JLabel("", SwingConstants.CENTER));

                    } else {  
                        JButton bTuile = new JButton(grille.getTuiles().get(i).getNomTuile().toString());
                        if (grille.getTuiles().get(i).getEtat()== Utils.EtatTuile.COULEE){
                            bTuile.setBackground(Color.BLUE);
                        }else if (grille.getTuiles().get(i).getEtat()== Utils.EtatTuile.INONDEE){
                            bTuile.setBackground(Color.YELLOW);
                        }
                                
                        bTuile.setFont(new Font("Dialog",Font.BOLD,10));
                        bTuile.setPreferredSize(new Dimension(118, 118));
                        panelGrilleTuile.add(bTuile);
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
                JLabel Tour = new JLabel("Tour numéro : ", SwingConstants.CENTER);
                JLabel Niveau = new JLabel("Niveau d'eau : ", SwingConstants.CENTER);
                JLabel Joueur = new JLabel("Joueur numéro : ", SwingConstants.CENTER);
                Tour.setPreferredSize(new Dimension(200, 100));
                Niveau.setPreferredSize(new Dimension(200, 100));
                Joueur.setPreferredSize(new Dimension(200, 100));
                panelInfo.add(Tour);
                panelInfo.add(Niveau);
                panelInfo.add(Joueur);

                // Panel Centre
                JPanel panelGrilleBouton = new JPanel(new GridLayout(2, 5));
                for (int v = 0; v <= 4; v++) {
                    if (v == 0) {
                        JButton nrf = new JButton("Fin tour");
                        nrf.setPreferredSize(new Dimension(40, 25));
                        panelGrilleBouton.add(nrf);
                        nrf.addActionListener(
                                new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Message m = new Message(TypesMessage.FINIRTOUR);
                                notifierObservateur(m);
                            }
                        });

                    } else if (v == 1) {
                        JButton d = new JButton("Se déplacer");
                        d.setPreferredSize(new Dimension(40, 25));
                        d.addActionListener(
                                new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Message m = new Message(TypesMessage.INITIALISATIONGRILLE);
                                notifierObservateur(m);
                            }
                        });
                        panelGrilleBouton.add(d);

                    } else if (v == 2) {
                        JButton a = new JButton("Assécher");
                        a.setPreferredSize(new Dimension(40, 25));
                        a.addActionListener(
                                new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Message m = new Message(TypesMessage.ASSECHER);
                                notifierObservateur(m);
                            }
                        });
                        panelGrilleBouton.add(a);
                    } else if (v == 3) {
                        JButton dn = new JButton("Donner une carte");
                        dn.setPreferredSize(new Dimension(40, 25));
                        panelGrilleBouton.add(dn);
                    } else if (v == 4) {
                        JButton p = new JButton("Prendre trésor");
                        p.setPreferredSize(new Dimension(40, 25));
                        panelGrilleBouton.add(p);
                    }

                }
                panelBouton.add(panelInfo, BorderLayout.NORTH);
                panelBouton.add(panelGrilleBouton, BorderLayout.SOUTH);
                panelCentre.add(panelBouton);

            }
        }
        panelMilieu.add(panelCentre);
        mainPanel.add(panelMilieu, BorderLayout.CENTER);
        // Panel Bas
        JPanel panelBas = new JPanel();
        panelBas.setBackground(Color.RED);
        panelBas.setPreferredSize(new Dimension(1650, 100));
        mainPanel.add(panelBas, BorderLayout.SOUTH);
        fenetreJeu.setVisible(true);
    }

    public void addObservateur(Observateur o) {
        this.observateur = o;
    }

    public void notifierObservateur(Message m) {
        if (observateur != null) {
            observateur.traiterMessage(m);
        }
    }

}
