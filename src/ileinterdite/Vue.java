package ileinterdite;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import static java.awt.SystemColor.window;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Vue {
        private final JFrame window ;
        private JButton tuile;

    public Vue(){

        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setTitle("L 'ILE INTERDITE");
        // Définit la taille de la fenêtre en pixels
        window.setSize(1650, 950);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2, dim.height/2-window.getSize().height/2);
        // Panel Principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        window.add(mainPanel) ;
        // Panel Haut
        JPanel panelHaut = new JPanel() ;
        panelHaut.setBackground(Color.GREEN);
        panelHaut.setPreferredSize(new Dimension(1650, 100));
        mainPanel.add(panelHaut, BorderLayout.NORTH);
        // Panel EST/OUEST
        JPanel panelEst = new JPanel() ;
        JPanel panelOuest = new JPanel() ;
        panelEst.setPreferredSize(new Dimension(10,950));
        panelOuest.setPreferredSize(new Dimension(10, 950));
        panelEst.setBackground(Color.MAGENTA);
        panelOuest.setBackground(Color.MAGENTA);
        mainPanel.add(panelEst, BorderLayout.EAST);
        mainPanel.add(panelOuest, BorderLayout.WEST);

        

  
        // Panel Millieu
        JPanel panelMilieu = new JPanel(); // BorderLayout.CENTER
        JPanel panelCentre = new JPanel(new GridLayout(0, 2)) ; //SEPARATION GRILLE / COMMANDE
        for (int j=0;j<=1;j++){
            if (j==0){
                JPanel panelGrille = new JPanel(new GridLayout(6,6));
                for (int i=0;i<=35;i++){
                    if (i==0 || i==1 || i==4 || i==5 || i==6 || i==11 || i==24 ||i==29 || i==30 || i==31 || i==34 || i==35){
                        panelGrille.add(new JLabel("BRD"));
                        
                    }else{
                        JButton tuile  = new JButton("Tuile n° "+i);
                        tuile.setPreferredSize(new Dimension(118, 118));
                        panelGrille.add(tuile);
                    }
                }
                panelCentre.add(panelGrille);
            }else{

            }
        }
        panelMilieu.add(panelCentre);
        mainPanel.add(panelMilieu, BorderLayout.CENTER);
        // Panel Bas
        JPanel panelBas = new JPanel();
        panelBas.setBackground(Color.RED);
        panelBas.setPreferredSize(new Dimension(1650, 100));
        mainPanel.add(panelBas, BorderLayout.SOUTH);

    }
    public void afficher(){
        this.window.setVisible(true);
    }
}
   