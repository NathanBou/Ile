package Modele;

import Modele.Utils.Pion;

public class Role {

    private NomRole nomRole;
    private Pion pion;

    Role(NomRole nomRole, Pion pion) {
        this.pion = pion;
        this.nomRole = nomRole;
    }

    public NomRole getNomRole() {
        return nomRole;
    }

    public void setNomRole(NomRole nomRole) {
        this.nomRole = nomRole;
    }

    public Pion getCouleur() {
        return pion;
    }

    public void setCouleur(Pion pion) {
        this.pion = pion;
    }

}
