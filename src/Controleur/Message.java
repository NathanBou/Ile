/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Controleur.TypesMessage;
import Modele.NomRole;
import Modele.Tuile;
import java.util.ArrayList;

/**
 *
 * @author bouviern
 */
public class Message {
    TypesMessage type;
    ArrayList<NomRole> joueurs = new ArrayList<NomRole>();
    int lig;
    int col;
    Tuile tuile;
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
    }

    public int getLig() {
        return lig;
    }

    public int getCol() {
        return col;
    }

    public void setLig(int lig) {
        this.lig = lig;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
