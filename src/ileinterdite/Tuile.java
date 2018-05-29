package ileinterdite;

import java.util.*;

public class Tuile {

	ArrayList<Aventurier> aSurTuile;
	private int x;
	private int y;
	private Etat etat;
	private NomTuile nomTuile;
        
        Tuile(int x, int y, NomTuile nomTuile) {
            this.x = x;
            this.y = y;
            this.nomTuile = nomTuile;
            etat = Etat.NORMAL;
        }

	public Etat getEtat() {
		return this.etat;
	}

	/**
	 * 
	 * @param Etat
	 */
	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public void setAssecher(Tuile tuile) {
		// TODO - implement Tuile.setAssecher
		tuile.setEtat(Etat.NORMAL);
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

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public NomTuile getNomTuile() {
            return nomTuile;
        }

        public void setNomTuile(NomTuile nomTuile) {
            this.nomTuile = nomTuile;
        }
        
        

}