package Modele;

public class Apparition extends Tuile {

	private Role role;
        
        Apparition(NomTuile nomTuile, Role role) {
            super(nomTuile);
            this.role=role;
        }

        
        public Role getRole() {
            return this.role;
        }
}