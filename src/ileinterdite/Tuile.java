package ileinterdite;

import java.util.*;
import ileinterdite.Utils.EtatTuile;
public class Tuile {

	ArrayList<Aventurier> aSurTuile;
	private EtatTuile etat;
	private NomTuile nomTuile;
        
        Tuile(NomTuile nomTuile) {
            this.nomTuile = nomTuile;
            etat = EtatTuile.ASSECHEE;
            ArrayList<Aventurier> aSurTuile = new ArrayList<>();
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

	public void setAssecher(Tuile tuile) {
		// TODO - implement Tuile.setAssecher
		tuile.setEtat(EtatTuile.ASSECHEE);
	}

	/**
	 * 
	 * @param Joueur
	 */
	public void EstSurTuile(Aventurier Joueur) {
		// TODO - implement Tuile.EstSurTuile
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Joueur
	 */
	public void EstPlusSurTuile(Aventurier Joueur) {
		// TODO - implement Tuile.EstPlusSurTuile
		throw new UnsupportedOperationException();
	}

        public ArrayList<Aventurier> getaSurTuile() {
            return aSurTuile;
        }

        public void setaSurTuile(ArrayList<Aventurier> aSurTuile) {
            this.aSurTuile = aSurTuile;
        }

        public NomTuile getNomTuile() {
            return nomTuile;
        }

        public void setNomTuile(NomTuile nomTuile) {
            this.nomTuile = nomTuile;
        }
        
        

}