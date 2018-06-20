package Modele;
import Modele.Utils.EtatTuile;
public class Tresor extends Tuile {
    private NomTresors tresor;
    public Tresor(NomTuile nomTuile,EtatTuile etat,int lig, int col,NomTresors tresor) {
        super(nomTuile,etat,lig,col);
        this.tresor=tresor;
    }
}