package Modele;

import java.util.*;
import Modele.Utils.EtatTuile;

public class Tuile {

    private ArrayList<Aventurier> aSurTuile;
    private EtatTuile etat;
    private NomTuile nomTuile;
    private int lig;
    private int col;

    Tuile(NomTuile nomTuile, EtatTuile etat,int lig,int col) {
        this.nomTuile = nomTuile;
        this.etat = etat;
        this.lig=lig;
        this.col=col;
        aSurTuile = new ArrayList<Aventurier>();
    }

    public EtatTuile getEtat() {
        return this.etat;
    }


    /**
     *
     * @param Etat
     */
    public void setEtat(EtatTuile etat) {
        this.etat = etat;
    }

    public void estSurTuile(Aventurier joueur) {
        this.aSurTuile.add(joueur);
    }

    public void assecher() {
        // TODO - implement Tuile.setAssecher
        this.setEtat(EtatTuile.ASSECHEE);
    }

    public void estPlusSurTuile(Aventurier joueur) {
        // TODO - implement Tuile.EstPlusSurTuile
        if (aSurTuile.contains(joueur)) {
            aSurTuile.remove(joueur);
        } else {
            System.out.println("Le joueur n'est pas sur la tuile.");
        }
    }

    public ArrayList<Aventurier> getASurTuile() {
        return aSurTuile;
    }

    public NomTuile getNomTuile() {
        return nomTuile;
    }

    public void setNomTuile(NomTuile nomTuile) {
        this.nomTuile = nomTuile;
    }

    @Override
    public String toString() {
        return this.nomTuile.toString();
    }

    public int getCol() {
        return this.col;
    }

    public int getLig() {
        return this.lig;
    }
    
}
