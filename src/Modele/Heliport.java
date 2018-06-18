package Modele;

import Modele.Utils.EtatTuile;
import Modele.Utils.Pion;
import java.awt.Color;

public class Heliport extends Apparition {

    public Heliport() {
        super(NomTuile.HELIPORT,new Role(NomRole.PILOTE, Pion.BLEU),EtatTuile.ASSECHEE);
    }
}