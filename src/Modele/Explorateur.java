/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.util.ArrayList;

/**
 *
 * @author perrbeno
 */
public class Explorateur extends Aventurier {

    public Explorateur() {
        super(new Role(NomRole.EXPLORATEUR, Utils.Pion.VERT));
    }

    @Override
    public ArrayList<Tuile> getTuilesAdjacentes(Grille g) {
        ArrayList<Tuile> tuilesAdjacentes = new ArrayList();
        tuilesAdjacentes = super.getTuilesAdjacentes(g);
        tuilesAdjacentes.add(g.getTuile(this.getEstSurTuile().getLig() + 1 > 5 ? 5 : this.getEstSurTuile().getLig() + 1,this.getEstSurTuile().getCol() + 1 > 5 ? 5 : this.getEstSurTuile().getCol() + 1));
        tuilesAdjacentes.add(g.getTuile(this.getEstSurTuile().getLig() + 1 > 5 ? 5 : this.getEstSurTuile().getLig() + 1,this.getEstSurTuile().getCol() - 1 < 0 ? 0 : this.getEstSurTuile().getCol() - 1));
        tuilesAdjacentes.add(g.getTuile(this.getEstSurTuile().getLig() - 1 < 0 ? 0 : this.getEstSurTuile().getLig() - 1,this.getEstSurTuile().getCol() + 1 > 5 ? 5 : this.getEstSurTuile().getCol() + 1));
        tuilesAdjacentes.add(g.getTuile(this.getEstSurTuile().getLig() - 1 < 0 ? 0 : this.getEstSurTuile().getLig() - 1,this.getEstSurTuile().getCol() - 1 < 0 ? 0 : this.getEstSurTuile().getCol() - 1));
        return tuilesAdjacentes;
    }
}
