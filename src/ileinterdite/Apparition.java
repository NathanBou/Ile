package ileinterdite;

public class Apparition extends Tuile {

	private Couleur couleur;
        
        Apparition(int x, int y, NomTuile nomTuile, Couleur couleur) {
            super(x, y, nomTuile);
            this.couleur=couleur;
        }

        public NomTuile getNomApparition(Couleur couleur) {
            if (getCouleur() == couleur) {
                return this.getNomTuile();
            } else {
                return ;
            }
        }
        
        public Couleur getCouleur() {
            return this.couleur;
        }
}