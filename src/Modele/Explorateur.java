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
        tuilesAdjacentes.clear();
        if (g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) + 1) != null && g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) + 1).getEtat() != Utils.EtatTuile.COULEE) {
            tuilesAdjacentes.add(g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) + 1));
        }
        if (g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) - 1) != null && g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) - 1).getEtat() != Utils.EtatTuile.COULEE) {
            tuilesAdjacentes.add(g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) - 1));
        }
        if (g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) + 6) != null && g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) + 6).getEtat() != Utils.EtatTuile.COULEE) {
            tuilesAdjacentes.add(g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) + 6));
        }
        if (g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) - 6) != null && g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) - 6).getEtat() != Utils.EtatTuile.COULEE) {
            tuilesAdjacentes.add(g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) - 6));
        }
        if (g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) - 5) != null && g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) - 5).getEtat() != Utils.EtatTuile.COULEE) {
            tuilesAdjacentes.add(g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) - 5));
        }
        if (g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) + 5) != null && g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) + 5).getEtat() != Utils.EtatTuile.COULEE) {
            tuilesAdjacentes.add(g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) + 5));
        }
        if (g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) - 7) != null && g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) - 7).getEtat() != Utils.EtatTuile.COULEE) {
            tuilesAdjacentes.add(g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) - 7));
        }
        if (g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) + 7) != null && g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) + 7).getEtat() != Utils.EtatTuile.COULEE) {
            tuilesAdjacentes.add(g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) + 7));
        }
        return tuilesAdjacentes;
    }
}
