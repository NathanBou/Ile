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
    public int special;
    
    public Ingenieur() {
        super(new Role(NomRole.INGENIEUR,Utils.Pion.ROUGE));
        special = -1;
    }

    public int getSpecial() {
        return special;
    }

    public void utiliseSpecial() {
        if(getSpecial()<1) {
            special++;
            if(special ==0) {
                System.out.println("Pouvoir Ingenieur : assechement possible.");
            }
        }
    }
}
