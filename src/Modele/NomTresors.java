/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.awt.Color;

/**
 *
 * @author perrbeno
 */
public enum NomTresors {
    ZEPHYR("Zéphyr"),
    CALICE("Calice"),
    CRISTAL("Cristal"),
    PIERRE("Pierre");

    private String libelle;
    private Color color;
    NomTresors(String libelle) {
        this.libelle = libelle;
    }
    public Color getColorTresor(NomTresors tresor){
        
        if (tresor == this.CALICE){
            color = new Color(0, 149, 182);
        }else if(tresor == this.CRISTAL){
            color = Color.RED;
        }else if(tresor == this.PIERRE){
            color = new Color(91, 60, 17);
        }else {
            color = new Color(240, 195, 0);
        }
        return color;
    }
    @Override
    public String toString() {
        return this.libelle;
    }
}
