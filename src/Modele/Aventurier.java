package Modele;

import java.util.ArrayList;

public abstract class Aventurier {

    private int nbAction = 3;
    protected Tuile estSurTuile;
    private int nbCarte = 0;
    private Role role;
    protected ArrayList<Tuile> tuilesAdjacentes;
    private boolean monTour = false;

    Aventurier(Role role) {
        this.role = role;
        ArrayList<Tuile> tuilesAdjacentes = new ArrayList<>();
    }

    public int getNbCarte() {
        return this.nbCarte;
    }

    public void setNbCarte(int nbCarte) {
        this.nbCarte = nbCarte;
    }

    public int getNbAction() {
        return nbAction;
    }

    /**
     *
     * @param Tuile
     */
    public void Deplacement(Tuile tuile) {
        // TODO - implement Aventurier.Deplacement
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
    public void DonnerCarte(Aventurier joueur, CTresor carte) {
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
    public void Assecher(Tuile tuile) {
        // TODO - implement Aventurier.Assecher
        if (nbAction >= 3) {
            System.out.println("Assechage impossible, nombre d'actions disponibles insuffisants.");
        } else {
            tuile.Assecher();
            nbAction++;
        }
    }

    /**
     *
     * @param Tresor
     */
    public void PrendreTresor(Tresor tresor) {
        // TODO - implement Aventurier.PrendreTresor
        if (nbAction >= 3) {
            System.out.println("Action impossible, nombre d'actions disponibles insuffisants.");
        } else {

            nbAction++;
        }
    }

    public ArrayList<Tuile> getTuilesAccessibles(Grille g) {
        // TODO - implement Aventurier.TuilesAccessibles
        ArrayList<Tuile> tuilesAccessibles = new ArrayList();
        for (Tuile tuile : tuilesAdjacentes) {
            if (tuile.getEtat() != Utils.EtatTuile.COULEE) {
                tuilesAccessibles.add(tuile);
            }
        }
        return tuilesAccessibles;

    }


    public ArrayList<Tuile> getTuilesInondees(Grille g) {
        ArrayList<Tuile> tuilesInondees = new ArrayList();
        for (Tuile tuile : tuilesAdjacentes) {
            if (tuile.getEtat() == Utils.EtatTuile.INONDEE) {
                tuilesInondees.add(tuile);
            }
        }
        return tuilesInondees;
    }

    public ArrayList<Tuile> getTuilesAdjacentes(Grille g) {
        // TODO - implement Aventurier.TuilesAssechables
        tuilesAdjacentes.clear();
        if (g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) + 1).getEtat() != Utils.EtatTuile.COULEE) {
            tuilesAdjacentes.add(g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) + 1));
        }
        if (g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) - 1).getEtat() != Utils.EtatTuile.COULEE) {
            tuilesAdjacentes.add(g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) - 1));
        }
        if (g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) + 6).getEtat() != Utils.EtatTuile.COULEE) {
            tuilesAdjacentes.add(g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) + 6));
        }
        if (g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) - 6).getEtat() != Utils.EtatTuile.COULEE) {
            tuilesAdjacentes.add(g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile) - 6));
        }
        return tuilesAdjacentes;
    }

    public ArrayList<Tuile> getTuilesAdjacentes(Grille g, Tuile t) {
        if (g.getTuiles().get(g.getTuiles().indexOf(t)).getEtat() != Utils.EtatTuile.COULEE) {
            tuilesAdjacentes.add(g.getTuiles().get(g.getTuiles().indexOf(t)));
        }
        if (g.getTuiles().get(g.getTuiles().indexOf(t)).getEtat() != Utils.EtatTuile.COULEE) {
            tuilesAdjacentes.add(g.getTuiles().get(g.getTuiles().indexOf(t)));
        }
        if (g.getTuiles().get(g.getTuiles().indexOf(t)).getEtat() != Utils.EtatTuile.COULEE) {
            tuilesAdjacentes.add(g.getTuiles().get(g.getTuiles().indexOf(t)));
        }
        if (g.getTuiles().get(g.getTuiles().indexOf(t)).getEtat() != Utils.EtatTuile.COULEE) {
            tuilesAdjacentes.add(g.getTuiles().get(g.getTuiles().indexOf(t)));
        }
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
    public void setApparition(Tuile apparition){
        this.estSurTuile=apparition;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    public void finTour() {
        nbAction = 3;
        monTour = false;
    }

}
