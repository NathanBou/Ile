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
public enum Cartes {
    PIERRE("Pierre"),
    ZEPHYR("Zéphyr"),
    CRISTAL("Cristal"),
    CALICE("Calice"),
    HELICOPTERE("Hélicoptère"),
    SACDESABLE("Sac de sable"),
    MONTEEDESEAUX("Montée des eaux");

    String libelle;

    Cartes(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return this.libelle;
    }
}
