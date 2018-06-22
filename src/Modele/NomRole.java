package Modele;

public enum NomRole {
    EXPLORATEUR("Explorateur"),
    INGENIEUR("Ingénieur"),
    MESSAGER("Messager"),
    NAVIGATEUR("Navigateur"),
    PILOTE("Pilote"),
    PLONGEUR("Plongeur");

    String libelle;

    NomRole(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return this.libelle;
    }
}
