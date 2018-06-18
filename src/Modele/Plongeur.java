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
        boolean allTraitees = true;
        
        ArrayList<Tuile> tuilesAdjacentes2 = new ArrayList();
        tuilesAdjacentes2 = getTuilesAdjacentes(g);
        
        // Ajout des cases assechées et inondées des tuiles adjacentes
        tuilesAccessibles = super.getTuilesAccessibles(g);
        
        // Gestion des cases coulées et inondées des tuiles adjacentes
        // Tant qu'on a pas parcouru toutes les possibilités et ajouté celles qui sont bonnes,
        // pour chaque tuile de tuilesAccessibles, trouver celles qui sont inondées et coulées
        // et ajouter a tuilesAdjacentes2 les cases adjacentes à la case inondées
        for(Tuile tuile : tuilesAccessibles) {
            if(tuile.getEtat()!=EtatTuile.ASSECHEE) {
                allTraitees = false;
            }
        }
        
        while(!allTraitees){
            for (Tuile tuile : tuilesAccessibles) {
                if (tuile.getEtat()!=EtatTuile.ASSECHEE) {
                    tuilesAdjacentes2 = getTuilesAdjacentes(g,tuile);
                    tuilesAdjacentes2.remove(tuile);
                    for(Tuile tuile2 : tuilesAdjacentes2) {
                        if (!tuilesAccessibles.contains(tuile2) && tuile2.getEtat()==EtatTuile.COULEE) {
                            tuilesAccessibles.add(tuile2);
                        }
                    }
                }
            }
        }
        
        
        
        
        return tuilesAccessibles;
    }
}
