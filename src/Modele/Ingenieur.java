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
public class Ingenieur extends Aventurier {
    public Ingenieur() {
        super(new Role(NomRole.INGENIEUR, Utils.Pion.ORANGE));
    }
}
