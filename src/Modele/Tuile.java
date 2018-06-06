package Modele;

import java.util.*;
import Modele.Utils.EtatTuile;
public class Tuile {

	private ArrayList<Aventurier> aSurTuile;
	private EtatTuile etat;
	private NomTuile nomTuile;
        
        Tuile(NomTuile nomTuile, EtatTuile etat) {
            this.nomTuile = nomTuile;
            this.etat = etat;

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
        


	public void Assecher() {
		// TODO - implement Tuile.setAssecher
		this.setEtat(EtatTuile.ASSECHEE);
	}

	public void estPlusSurTuile(Aventurier joueur) {
		// TODO - implement Tuile.EstPlusSurTuile
                if(aSurTuile.contains(joueur)) {
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
        public String toString(){
            return this.nomTuile.toString();
        }
        public void estSurTuile(Aventurier joueur) {
		// TODO - implement Tuile.EstSurTuile
                 aSurTuile.add(joueur);

	}

}