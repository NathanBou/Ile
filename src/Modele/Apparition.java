package Modele;

import Modele.Utils.EtatTuile;

public class Apparition extends Tuile {

	private Role role;
        
        Apparition(NomTuile nomTuile, Role role,EtatTuile etat) {
            super(nomTuile,etat);
            this.role=role;
        }

        
        public Role getRole() {
            return this.role;
        }
}