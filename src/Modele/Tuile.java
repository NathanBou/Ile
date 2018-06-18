package Modele;

import java.util.*;
import Modele.Utils.EtatTuile;

public class Tuile {

    private ArrayList<Aventurier> aSurTuile;
    private EtatTuile etat;
    private NomTuile nomTuile;
    private int num_Tuile;

    Tuile(NomTuile nomTuile, EtatTuile etat, int num_Tuile) {
        this.nomTuile = nomTuile;
        this.etat = etat;
        aSurTuile = new ArrayList<Aventurier>();
        this.num_Tuile = num_Tuile;
    }

    public EtatTuile getEtat() {
        return this.etat;
    }

    public int getNumTuile() {
        return this.num_Tuile;
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

    public int getCol(Grille g) {
        int col = 0;
        int lig = 0;
        boolean found = false;
        while (lig < 5 | !found) {
            col = 0;
            while (col < 5 | !found) {
                found = this == g.getTuiles()[lig][col];
                col++;
            }
            lig++;
        }
        return col;
    }

    public int getLig(Grille g) {
        int lig = 0;
        boolean found = false;
        while (lig < 5 | !found) {
            int col = 0;
            while (col < 5 | !found) {
                found = this == g.getTuiles()[lig][col];
                col++;
            }
            lig++;
        }
        return lig;
    }

}
