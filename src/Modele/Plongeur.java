/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Modele.Utils.EtatTuile;
import static Modele.Utils.EtatTuile.ASSECHEE;
import static Modele.Utils.EtatTuile.INONDEE;
import static Modele.Utils.EtatTuile.COULEE;

import java.util.ArrayList;

/**
 *
 * @author perrbeno
 */
public class Plongeur extends Aventurier {

    public Plongeur() {
        super(new Role(NomRole.PLONGEUR, Utils.Pion.VIOLET));
    }

    @Override
    public ArrayList<Tuile> getTuilesAccessibles(Grille g) {
        ArrayList<Tuile> tuilesAccessibles = new ArrayList();
        // Attributs nécessaires
        ArrayList<Tuile> tuilesAdjacentes2 = new ArrayList();
        tuilesAdjacentes2 = getTuilesAdjacentes(g);
        
        // Ajout des cases assechées et inondées des tuiles adjacentes
        tuilesAccessibles = super.getTuilesAccessibles(g);
        // Gestion des cases coulées et inondées des tuiles adjacentes
        // tuiles inondées
        // Pour chaque tuile de tuilesAccessibles, trouver celles qui sont inondées et coulées et ajouter a tuilesAdjacentes2 les cases adjacentes à la case inondées
        for (Tuile tuile : tuilesAccessibles) {
            if (tuile.getEtat()!=EtatTuile.ASSECHEE) {
                
            }
        }
        
        
        
        
        return tuilesAccessibles;
    }
}
