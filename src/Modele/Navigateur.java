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
public class Navigateur extends Aventurier {

    public Navigateur() {
        super(new Role(NomRole.NAVIGATEUR, Utils.Pion.JAUNE));
    }

}
