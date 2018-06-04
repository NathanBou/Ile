/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Controleur.TypesMessage;
import Modele.NomRole;
import java.util.ArrayList;

/**
 *
 * @author bouviern
 */
public class Message {
    TypesMessage type;
    ArrayList<NomRole> joueurs = new ArrayList<NomRole>();
    int nbJoueur=0;
    public Message(TypesMessage type) {
        this.type = type;    
    }

    public TypesMessage getType() {
        return type;
    }

    public void setType(TypesMessage type) {
        this.type = type;
    }
    public void ajouterJoueur(NomRole joueur){
        joueurs.add(joueur);
        nbJoueur++;
    }
}
