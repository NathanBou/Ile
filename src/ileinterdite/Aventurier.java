package ileinterdite;


import java.util.ArrayList;

public abstract class Aventurier {

	private Tuile estSurTuile;
	private int nbCarte = 0;
	private Role role;
        private ArrayList<Tuile> tuilesAdjacentes;
        
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

	/**
	 * 
	 * @param Tuile
	 */
	public void Deplacement(Tuile Tuile) {
		// TODO - implement Aventurier.Deplacement
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Aventurier
	 * @param Carte
	 */
	public void DonnerCarte(Aventurier Aventurier, CTresor Carte) {
		// TODO - implement Aventurier.DonnerCarte
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Tuile
	 */
	public void Assecher(Tuile Tuile) {
		// TODO - implement Aventurier.Assecher
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Tresor
	 */
	public void PrendreTresor(Tresor Tresor) {
		// TODO - implement Aventurier.PrendreTresor
		throw new UnsupportedOperationException();
	}

	public ArrayList<Tuile> TuilesAccessibles() {
		// TODO - implement Aventurier.TuilesAccessibles
                boolean queSecs = false;
		ArrayList<Tuile> tuilesAccessibles = new ArrayList();
                tuilesAccessibles = getTuilesAssechees(tuilesAdjacentes);
                for(Tuile tuile : tuil)
                if("Explorateur".equals(this.getRole().getNomRole().toString())) {
                    tuilesAccessibles.add(g.getTuiles()[this.getEstSurTuile().getLig(g)+1][this.getEstSurTuile().getCol(g)+1]);
                    tuilesAccessibles.add(g.getTuiles()[this.getEstSurTuile().getLig(g)+1][this.getEstSurTuile().getCol(g)-1]);
                    tuilesAccessibles.add(g.getTuiles()[this.getEstSurTuile().getLig(g)-1][this.getEstSurTuile().getCol(g)+1]);
                    tuilesAccessibles.add(g.getTuiles()[this.getEstSurTuile().getLig(g)-1][this.getEstSurTuile().getCol(g)-1]);
                } else if ("Plongeur".equals(this.getRole().getNomRole().toString())) {
                    while (!queSecs) {
                    for (int i=0; i<4; i++) {
                        if(tuilesAccessibles.get(i).getEtat()!=Utils.EtatTuile.ASSECHEE) {
                            
                        }
                    }
                }
                }
                   
	}
        
        public ArrayList<Tuile> getTuilesAssechees(ArrayList<Tuile> tuilesAdjacentes) {
            ArrayList<Tuile> tuilesAssechees = new ArrayList();
            for (Tuile tuile : tuilesAdjacentes) {
                if (tuile.getEtat()==Utils.EtatTuile.ASSECHEE) {
                    tuilesAssechees.add(tuile);
                } else if ("Plongeur".equals(this.getRole().getNomRole().toString())) {
                    getTuilesAdjacentes
                }
            }
            return tuilesAssechees;
        }

	public ArrayList<Tuile> getTuilesAdjacentes(Grille g) {
		// TODO - implement Aventurier.TuilesAssechables
		tuilesAdjacentes.clear();
                tuilesAdjacentes.add(g.getTuiles()[this.getEstSurTuile().getLig(g)+1][this.getEstSurTuile().getCol(g)]);
                tuilesAdjacentes.add(g.getTuiles()[this.getEstSurTuile().getLig(g)-1][this.getEstSurTuile().getCol(g)]);
                tuilesAdjacentes.add(g.getTuiles()[this.getEstSurTuile().getLig(g)][this.getEstSurTuile().getCol(g)+1]);
                tuilesAdjacentes.add(g.getTuiles()[this.getEstSurTuile().getLig(g)][this.getEstSurTuile().getCol(g)-1]);
                if ("Explorateur".equals(this.getRole().getNomRole().toString())) {
                    tuilesAdjacentes.add(g.getTuiles()[this.getEstSurTuile().getLig(g)+1][this.getEstSurTuile().getCol(g)+1]);
                    tuilesAdjacentes.add(g.getTuiles()[this.getEstSurTuile().getLig(g)+1][this.getEstSurTuile().getCol(g)-1]);
                    tuilesAdjacentes.add(g.getTuiles()[this.getEstSurTuile().getLig(g)-1][this.getEstSurTuile().getCol(g)+1]);
                    tuilesAdjacentes.add(g.getTuiles()[this.getEstSurTuile().getLig(g)-1][this.getEstSurTuile().getCol(g)-1]);
                }
                return tuilesAdjacentes;
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
    
    public void setRole(Role role) {
        this.role = role;
    }
    
    

}