package Modele;

import Modele.Utils.EtatTuile;
import java.util.ArrayList;

public abstract class Aventurier {

    private int nbAction;
    public Tuile estSurTuile;
    private int nbCarte;
    private Role role;
    public ArrayList<Tuile> tuilesAdjacentes;
    private boolean monTour = false;

    Aventurier(Role role) {
        this.role = role;
        //ArrayList<Tuile> tuilesAdjacentes = new ArrayList<>();
    }

    public int getNbCarte() {
        return this.nbCarte;
    }

    public void setNbCarte(int nbCarte) {
        this.nbCarte = nbCarte;
    }

    public boolean isMonTour() {
        return monTour;
    }

    public void setMonTour(boolean monTour) {
        this.monTour = monTour;
    }

    public int getNbAction() {
        return nbAction;
    }

    public void setNbAction(int i) {
        this.nbAction = i;
    }

    /**
     *
     * @param Tuile
     */
    public void deplacement(Tuile tuile) {
        // TODO - implement Aventurier.deplacement
        if (nbAction >= 3) {
            System.out.println("Deplacement impossible, nombre d'actions disponibles insuffisants.");
        } else {
            this.getEstSurTuile().estPlusSurTuile(this);
            tuile.getASurTuile().add(this);
            nbAction++;
        }
    }

    /**
     *
     * @param Aventurier
     * @param Carte
     */
    public void donnerCarte(Aventurier joueur, CTresor carte) {
        if (nbAction >= 3) {
            System.out.println("Action impossible, nombre d'actions disponibles insuffisants.");
        } else {

            nbAction++;
        }
    }

    /**
     *
     * @param Tuile
     */
    public void assecher(Tuile tuile) {
        // TODO - implement Aventurier.assecher
        if (nbAction >= 3) {
            System.out.println("Assechage impossible, nombre d'actions disponibles insuffisants.");
        } else {
            tuile.assecher();
            nbAction++;
        }
    }

    /**
     *
     * @param Tresor
     */
    public void prendreTresor(Tresor tresor) {
        // TODO - implement Aventurier.prendreTresor
        if (nbAction >= 3) {
            System.out.println("Action impossible, nombre d'actions disponibles insuffisants.");
        } else {

            nbAction++;
        }
    }

    public ArrayList<Tuile> getTuilesAccessibles(Grille g) {
        // TODO - implement Aventurier.TuilesAccessibles
        ArrayList<Tuile> tuilesAccessibles = new ArrayList();
        tuilesAdjacentes = getTuilesAdjacentes(g);
        for (Tuile tuile : tuilesAdjacentes) {
            if (tuile.getEtat() != EtatTuile.COULEE) {
                tuilesAccessibles.add(tuile);
            }
        }
        return tuilesAccessibles;
    }

    public ArrayList<Tuile> getTuilesInondees(Grille g) {
        ArrayList<Tuile> tuilesInondees = new ArrayList();
        tuilesAdjacentes=getTuilesAdjacentes(g);
        for (Tuile tuile : tuilesAdjacentes) {
            if (tuile.getEtat() == EtatTuile.INONDEE) {
                tuilesInondees.add(tuile);
            }
        }
        return tuilesInondees;
    }

    public ArrayList<Tuile> getTuilesAdjacentes(Grille g) {
        // tuilesAdjacentes.clear();
        //tuilesAdjacentes.add(g.getTuiles()[this.getEstSurTuile().getLig(g) + 1][this.getEstSurTuile().getCol(g)]);
        ArrayList<Tuile> tuilesAdjacentes = new ArrayList<>();
        tuilesAdjacentes.add(g.getTuile(this.getEstSurTuile().getLig(g) + 1 >5 ? 5 : this.getEstSurTuile().getLig(g) + 1, this.getEstSurTuile().getCol(g)));
        tuilesAdjacentes.add(g.getTuile(this.getEstSurTuile().getLig(g) - 1 <0 ? 0 : this.getEstSurTuile().getLig(g) - 1, this.getEstSurTuile().getCol(g)));
        tuilesAdjacentes.add(g.getTuile(this.getEstSurTuile().getLig(g), this.getEstSurTuile().getCol(g) + 1 >5 ? 5 : this.getEstSurTuile().getCol(g) + 1));
        tuilesAdjacentes.add(g.getTuile(this.getEstSurTuile().getLig(g), this.getEstSurTuile().getCol(g) - 1 <0 ? 0 : this.getEstSurTuile().getCol(g) - 1));
        return tuilesAdjacentes;
    }

    public ArrayList<Tuile> getTuilesAdjacentes(Grille g, Tuile t) {
        tuilesAdjacentes.add(g.getTuiles()[t.getLig(g) + 1][t.getCol(g)]);
        tuilesAdjacentes.add(g.getTuiles()[t.getLig(g) - 1][t.getCol(g)]);
        tuilesAdjacentes.add(g.getTuiles()[t.getLig(g)][t.getCol(g) + 1]);
        tuilesAdjacentes.add(g.getTuiles()[t.getLig(g)][t.getCol(g) - 1]);
        return tuilesAdjacentes;

    }

    public void debutTour() {
        nbAction = 0;
        monTour = true;
    }

    public Role getRole() {
        return role;
    }

    public Tuile getEstSurTuile() {
        return estSurTuile;
    }

    public void setEstSurTuile(Tuile estSurTuile) {
        this.estSurTuile = estSurTuile;
    }

    public void setApparition(Tuile apparition) {
        this.estSurTuile = apparition;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void finTour() {
        monTour = false;
    }

}
