/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author perrbeno
 */
public enum NomTresors {
    LION("Lion"),
    CALICE("Calice"),
    CRYSTAL("Crystal"),
    PIERRE("Pierre");
    
    private String libelle;
    
    NomTresors(String libelle){
        this.libelle = libelle;
    }
    
    @Override
    public String toString() {
        return this.libelle;
    }
}
