/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controleur;


public interface Observateur {
    public void traiterMessage(Message m);
    public void initJeu();
}
