package Modele;

import Modele.Utils.EtatTuile;

public class Apparition extends Tuile {

	private Role role;
        
        Apparition(NomTuile nomTuile, Role role,EtatTuile etat,int num_Tuile) {
            super(nomTuile,etat,num_Tuile);
            this.role=role;
        }

        
        public Role getRole() {
            return this.role;
        }
}