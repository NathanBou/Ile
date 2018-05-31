/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileinterdite;

/**
 *
 * @author perrbeno
 */
public class Ingenieur extends Aventurier {
    Ingenieur() {
        super(new Role(NomRole.MESSAGER, Utils.Pion.ORANGE));
    }
}
