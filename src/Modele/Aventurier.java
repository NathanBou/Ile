package Modele;

import Modele.Utils.EtatTuile;
import java.util.ArrayList;

public abstract class Aventurier {

    private int nbAction;
    public Tuile estSurTuile;
    private int nbCarte;
    private Role role;
    public ArrayList<Tuile> tuilesAdjacentes;
    public ArrayList<CarteTirage> cartePossedees;

    Aventurier(Role role) {
        this.role = role;
        this.tuilesAdjacentes = new ArrayList<>();
        this.cartePossedees = new ArrayList();
        this.nbAction=0;
    }

    public int getNbCarte() {
        nbCarte = cartePossedees.size();
        return nbCarte;
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

        this.getEstSurTuile().estPlusSurTuile(this);
        this.setEstSurTuile(tuile);
        tuile.getASurTuile().add(this);

    }

    /**
     *
     * @param Aventurier
     * @param Carte
     */
    public void donnerCarte(Aventurier joueur, CarteTirage carte) {
            joueur.cartePossedees.add(carte);
            this.cartePossedees.remove(carte);
            joueur.nbCarte++;
            nbCarte--;
            nbAction++;
    }

    public void piocherCarte(ArrayList<CarteTirage> pileCarte) {
        for (int i = 0; i < 2 ;i++){
            this.cartePossedees.add(pileCarte.get(0));
            pileCarte.remove(0);
            nbCarte++;
        }       
    }
    
    public void defausserCarte(CarteTirage carte) {
        this.cartePossedees.remove(carte);
        nbCarte--;
    }

    /**
     *
     * @param Tuile
     */
    public void assecher(Tuile tuile) {
        // TODO - implement Aventurier.assecher
        tuile.assecher();

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
        if (this.getRole().getNomRole() == NomRole.PLONGEUR) {
            tuilesAccessibles = getTuilesAccessibles(tuilesAccessibles, this.getEstSurTuile(), g);
        } else {
            tuilesAdjacentes = getTuilesAdjacentes(g);
            for (Tuile tuile : tuilesAdjacentes) {
                if (tuile.getEtat() != EtatTuile.COULEE) {
                    tuilesAccessibles.add(tuile);
                }
            }
        }
        tuilesAccessibles.remove(this.estSurTuile);
        return tuilesAccessibles;
    }

    public ArrayList<Tuile> getTuilesInondees(Grille g) {
        ArrayList<Tuile> tuilesInondees = new ArrayList();
        tuilesAdjacentes = getTuilesAdjacentes(g);
        for (Tuile tuile : tuilesAdjacentes) {
            if (tuile.getEtat() == EtatTuile.INONDEE) {
                tuilesInondees.add(tuile);
            }
        }
        if(this.estSurTuile.getEtat()==EtatTuile.INONDEE){
            tuilesInondees.add(estSurTuile);
        }
        return tuilesInondees;
    }

    public ArrayList<Tuile> getTuilesAdjacentes(Grille g) {
        tuilesAdjacentes.clear();
        tuilesAdjacentes.add(g.getTuile(this.getEstSurTuile().getLig() + 1 > 5 ? 5 : this.getEstSurTuile().getLig() + 1, this.getEstSurTuile().getCol()));
        tuilesAdjacentes.add(g.getTuile(this.getEstSurTuile().getLig() - 1 < 0 ? 0 : this.getEstSurTuile().getLig() - 1, this.getEstSurTuile().getCol()));
        tuilesAdjacentes.add(g.getTuile(this.getEstSurTuile().getLig(), this.getEstSurTuile().getCol() + 1 > 5 ? 5 : this.getEstSurTuile().getCol() + 1));
        tuilesAdjacentes.add(g.getTuile(this.getEstSurTuile().getLig(), this.getEstSurTuile().getCol() - 1 < 0 ? 0 : this.getEstSurTuile().getCol() - 1));
        return tuilesAdjacentes;
    }

    public ArrayList<Tuile> getTuilesAccessibles(ArrayList<Tuile> tuilesAccessibles, Tuile t, Grille g) {
        int x = t.getLig();
        int y = t.getCol();

        Tuile t1 = (y != 0 ? g.getTuile(x, y - 1) : null);
        Tuile t2 = (x != 0 ? g.getTuile(x - 1, y) : null);
        Tuile t3 = (x != 5 ? g.getTuile(x + 1, y) : null);
        Tuile t4 = (y != 5 ? g.getTuile(x, y + 1) : null);

        if (t1 != null) {
            tuilesAccessibles.add(t1);
        }
        if (t2 != null) {
            tuilesAccessibles.add(t2);
        }
        if (t3 != null) {
            tuilesAccessibles.add(t3);
        }
        if (t4 != null) {
            tuilesAccessibles.add(t4);
        }

        return tuilesAccessibles;

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
        nbAction = 0;
    }

    public ArrayList<CarteTirage> getCartePossedees() {
        return cartePossedees;
    }
    
    

}
