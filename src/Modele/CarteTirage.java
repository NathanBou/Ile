/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author commeroy
 */
public class CarteTirage {
    private Cartes nomCarte;
    
    public CarteTirage(Cartes nomCarte){
        this.nomCarte = nomCarte;
    }

    public Cartes getNomCarte() {
        return nomCarte;
    }

    public void setNomCarte(Cartes nomCarte) {
        this.nomCarte = nomCarte;
    }
    
    
}
