/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Controleur.TypesMessage;
import Modele.Aventurier;
import Modele.Cartes;
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
    int numCarte;
    int niveauEau;
    int grad;
    Tuile tuile;
    int numJoueurs;
    Cartes typeCarte;

    public Message(TypesMessage type) {
        this.type = type;
    }

    public TypesMessage getType() {
        return type;
    }

    public void setType(TypesMessage type) {
        this.type = type;
    }

    public void ajouterJoueur(NomRole joueur) {
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

    public int getNumCarte() {
        return numCarte;
    }

    public void setNumCarte(int numCarte) {
        this.numCarte = numCarte;
    }

    public int getNiveauEau() {
        return niveauEau;
    }

    public void setNiveauEau(int niveauEau) {
        this.niveauEau = niveauEau;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    public int getGrad() {
        return this.grad;
    }

    public int getNumJoueur() {

        return this.numJoueurs;
    }

    public void setNumJoueur(int numJoueurs) {
        this.numJoueurs = numJoueurs;
    }

    public Cartes getTypeCarte() {
        return typeCarte;
    }

    public void setTypeCarte(Cartes typeCarte) {
        this.typeCarte = typeCarte;
    }
    
}
