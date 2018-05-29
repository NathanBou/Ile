package ileinterdite;


import java.util.ArrayList;

public abstract class Aventurier {

	private Tuile estSurTuile;
	private int nbCarteMax = 6;
	private Role role;
        
        Aventurier(Apparition spawn) {
            estSurTuile = estSurTuile;
        }

	public int getNbCarteMax() {
		return this.nbCarteMax;
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
		throw new UnsupportedOperationException();
	}

	public ArrayList<Tuile> TuilesAssechables() {
		// TODO - implement Aventurier.TuilesAssechables
		throw new UnsupportedOperationException();
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