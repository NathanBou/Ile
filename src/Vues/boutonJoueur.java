/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import javax.swing.JButton;

/**
 *
 * @author commeroy
 */
public class boutonJoueur extends JButton {

    private int numJoueur;
    private String nomJoueur;

    public boutonJoueur(int numJoueur, String nomJoueur) {
        this.numJoueur = numJoueur;
        this.nomJoueur = nomJoueur;
        this.setText(nomJoueur);
    }

    public int getNumJoueur() {
        return numJoueur;
    }

    public void setNumJoueur(int numJoueur) {
        this.numJoueur = numJoueur;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

}
