package ileinterdite;

public class Apparition extends Tuile {

	private Role role;
        
        Apparition(int x, int y, NomTuile nomTuile, Role role) {
            super(x, y, nomTuile);
            this.role=role;
        }

        public NomTuile getNomApparition(Role role) {
            
        }
        
        public Role getRole() {
            return this.role;
        }
}