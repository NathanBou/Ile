/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import javax.swing.JButton;

/**
 *
 * @author nathan
 */
public class CelluleTuile extends JButton {
    public int lig_cellule;
    public int col_cellule;
    public CelluleTuile(int i, int k){
        this.lig_cellule=i;
        this.col_cellule=k;
    }
}
