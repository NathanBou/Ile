/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vues;

import javax.swing.JButton;

/**
 *
 * @author bouviern
 */
public class Carte extends JButton {

    private int numJoueur;
    private int numCarte;
    private String nomCarte;

    public Carte(int numJoueur, int numCarte, String nomCarte) {
        this.numJoueur = numJoueur;
        this.numCarte = numCarte;
        this.setText(nomCarte);
    }

    public int getNumJoueur() {
        return numJoueur;
    }

    public void setNumJoueur(int numJoueur) {
        this.numJoueur = numJoueur;
    }

    public int getNumCarte() {
        return numCarte;
    }

    public void setNumCarte(int numCarte) {
        this.numCarte = numCarte;
    }

}
