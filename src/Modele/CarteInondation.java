/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author bouviern
 */
public class CarteInondation {
    private Tuile nomCarte;
    public CarteInondation(Tuile tuile){
        this.nomCarte=tuile;
    }

    public Tuile getNomCarte() {
        return nomCarte;
    }

    public void setNomCarte(Tuile nomtuile) {
        this.nomCarte = nomtuile;
    }
    
}
