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
    private NomTuile nomCarte;
    public CarteInondation(Tuile tuile){
        this.nomCarte=tuile.getNomTuile();
    }

    public NomTuile getNomCarte() {
        return nomCarte;
    }

    public void setNomCarte(NomTuile nomtuile) {
        this.nomCarte = nomtuile;
    }
    
}
