/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import Modele.Aventurier;
import Modele.NomTuile;
import Modele.Utils.EtatTuile;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author nathan
 */
public class CelluleTuile extends JButton {

    public int lig_cellule;
    public int col_cellule;


   /* public CelluleTuile(int i, int k, EtatTuile etat, NomTuile nom, ArrayList<Aventurier> joueurs) {
        tuile = new JPanel(new BorderLayout());
        this.lig_cellule = i;
        this.col_cellule = k;
        this.nomTuile = new JLabel(nom.toString(), SwingConstants.CENTER);
        nomTuile.setFont(new Font("Dialog", Font.BOLD, 10));
        tuile.add(nomTuile, BorderLayout.NORTH);
        pions = new JPanel(new GridLayout(2, 2, 1, 1));
        if (!joueurs.isEmpty()) {
            for (int n = 0; n < joueurs.size(); n++) {
                JLabel jou = new JLabel();
                jou.setBackground(joueurs.get(n).getRole().getCouleur().getCouleur());
                pions.add(jou);
            }
            tuile.add(pions);
        }

        if (etat == EtatTuile.INONDEE) {
            pions.setBackground(new Color(30, 127, 203));
            tuile.setBackground(new Color(30, 127, 203));
            this.setBackground(new Color(30, 127, 203));
        } else if (etat == EtatTuile.COULEE) {
            pions.setBackground(Color.lightGray);
            tuile.setBackground(Color.lightGray);
            this.setBackground(Color.lightGray);
        } else if(etat==EtatTuile.ASSECHEE){
            pions.setBackground(null);
            tuile.setBackground(null);
            this.setBackground(null);
        }
        this.add(tuile);

    }*/

    public CelluleTuile(int i, int k) {
        this.lig_cellule = i;
        this.col_cellule = k;
    }
}
