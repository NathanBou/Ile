package ileinterdite;

public class Role {

    private NomRole nomRole;
    private Couleur couleur;
        
    Role(NomRole nomRole, Couleur couleur) {
        this.couleur = couleur;
        this.nomRole = nomRole;
    }

    public NomRole getNomRole() {
        return nomRole;
    }

    public void setNomRole(NomRole nomRole) {
        this.nomRole = nomRole;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }
    
    
}