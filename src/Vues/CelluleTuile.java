/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import java.awt.BorderLayout;
import java.awt.GridLayout;
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
    public JPanel tuile;
    public JPanel pions;
    public JLabel nomTuile = new JLabel("",SwingConstants.CENTER);
    
    public CelluleTuile(int i, int k){
        this.lig_cellule=i;
        this.col_cellule=k;
        tuile = new JPanel(new BorderLayout());
        pions = new JPanel(new GridLayout(2,2,1,1));
        tuile.add(nomTuile,BorderLayout.NORTH);
        tuile.add(pions,BorderLayout.CENTER);
        this.add(tuile);
        
    }
}
