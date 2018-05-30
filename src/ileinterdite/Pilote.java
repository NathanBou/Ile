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
public class Pilote extends Aventurier{
    Pilote () {
        super(new Role(NomRole.PILOTE, Utils.Pion.BLEU));
    }
}
