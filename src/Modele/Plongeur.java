/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

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
        Tuile cd;
        Tuile cg;
        Tuile ch;
        Tuile cb;
        Tuile cdbis;
        Tuile cgbis;
        Tuile chbis;
        Tuile cbbis;
        boolean queAccessibles = false;             //vérifie que toutes les cases de l'arraylist sont accessibles.
        ArrayList<Tuile> tuilesAccessibles = new ArrayList();
        cd = g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile)+1);
        cg = g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile)-1);
        ch = g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile)-6);
        cb = g.getTuiles().get(g.getTuiles().indexOf(this.estSurTuile)+6);
        
        
        if(cd != null && cd.getEtat()!=Utils.EtatTuile.COULEE && !tuilesAccessibles.contains(cd)) {
            tuilesAccessibles.add(cd);
        } else if (cd!= null && cd.getEtat()==Utils.EtatTuile.COULEE) {
            cdbis = g.getTuiles().get(g.getTuiles().indexOf(cd)+1);
            if(cdbis != null && cdbis.getEtat()!=Utils.EtatTuile.COULEE && !tuilesAccessibles.contains(cdbis)) {
                tuilesAccessibles.add(cdbis);
            }
            cgbis = g.getTuiles().get(g.getTuiles().indexOf(cd)-1);
            if(cgbis != null && cgbis.getEtat()!=Utils.EtatTuile.COULEE && !tuilesAccessibles.contains(cgbis)) {
                tuilesAccessibles.add(cgbis);
            }
            chbis = g.getTuiles().get(g.getTuiles().indexOf(cd)-6);
            if(chbis != null && chbis.getEtat()!=Utils.EtatTuile.COULEE && !tuilesAccessibles.contains(chbis)) {
                tuilesAccessibles.add(chbis);
            }
            cbbis = g.getTuiles().get(g.getTuiles().indexOf(cd)+6);
            if(cbbis != null && cbbis.getEtat()!=Utils.EtatTuile.COULEE && !tuilesAccessibles.contains(cbbis)) {
                tuilesAccessibles.add(cbbis);
            }
        }
        
        
        if(cg != null && cg.getEtat()!=Utils.EtatTuile.COULEE && !tuilesAccessibles.contains(cg)) {
            tuilesAccessibles.add(cg);
        } else if (cg.getEtat()==Utils.EtatTuile.COULEE) {
            cdbis = g.getTuiles().get(g.getTuiles().indexOf(cd)+1);
            if(cdbis != null && cdbis.getEtat()!=Utils.EtatTuile.COULEE && !tuilesAccessibles.contains(cdbis)) {
                tuilesAccessibles.add(cdbis);
            }
            cgbis = g.getTuiles().get(g.getTuiles().indexOf(cd)-1);
            if(cgbis != null && cgbis.getEtat()!=Utils.EtatTuile.COULEE && !tuilesAccessibles.contains(cgbis)) {
                tuilesAccessibles.add(cgbis);
            }
            chbis = g.getTuiles().get(g.getTuiles().indexOf(cd)-6);
            if(chbis != null && chbis.getEtat()!=Utils.EtatTuile.COULEE && !tuilesAccessibles.contains(chbis)) {
                tuilesAccessibles.add(chbis);
            }
            cbbis = g.getTuiles().get(g.getTuiles().indexOf(cd)+6);
            if(cbbis != null && cbbis.getEtat()!=Utils.EtatTuile.COULEE && !tuilesAccessibles.contains(cbbis)) {
                tuilesAccessibles.add(cbbis);
            }
        }
        
        
        if(ch != null && ch.getEtat()!=Utils.EtatTuile.COULEE && !tuilesAccessibles.contains(ch)) {
            tuilesAccessibles.add(ch);
        } else if (cd.getEtat()==Utils.EtatTuile.COULEE) {
            cdbis = g.getTuiles().get(g.getTuiles().indexOf(cd)+1);
            if(cdbis.getEtat()!=Utils.EtatTuile.COULEE && !tuilesAccessibles.contains(cdbis)) {
                tuilesAccessibles.add(cdbis);
            }
            cgbis = g.getTuiles().get(g.getTuiles().indexOf(cd)-1);
            if(cgbis.getEtat()!=Utils.EtatTuile.COULEE && !tuilesAccessibles.contains(cgbis)) {
                tuilesAccessibles.add(cgbis);
            }
            chbis = g.getTuiles().get(g.getTuiles().indexOf(cd)-6);
            if(chbis.getEtat()!=Utils.EtatTuile.COULEE && !tuilesAccessibles.contains(chbis)) {
                tuilesAccessibles.add(chbis);
            }
            cbbis = g.getTuiles().get(g.getTuiles().indexOf(cd)+6);
            if(cbbis.getEtat()!=Utils.EtatTuile.COULEE && !tuilesAccessibles.contains(cbbis)) {
                tuilesAccessibles.add(cbbis);
            }
        }
        
        
        if(cb != null && cb.getEtat()!=Utils.EtatTuile.COULEE && !tuilesAccessibles.contains(cb)) {
            tuilesAccessibles.add(cb);
        } else if (cd.getEtat()==Utils.EtatTuile.COULEE) {
            cdbis = g.getTuiles().get(g.getTuiles().indexOf(cd)+1);
            if(cdbis.getEtat()!=Utils.EtatTuile.COULEE && !tuilesAccessibles.contains(cdbis)) {
                tuilesAccessibles.add(cdbis);
            }
            cgbis = g.getTuiles().get(g.getTuiles().indexOf(cd)-1);
            if(cgbis.getEtat()!=Utils.EtatTuile.COULEE && !tuilesAccessibles.contains(cgbis)) {
                tuilesAccessibles.add(cgbis);
            }
            chbis = g.getTuiles().get(g.getTuiles().indexOf(cd)-6);
            if(chbis.getEtat()!=Utils.EtatTuile.COULEE && !tuilesAccessibles.contains(chbis)) {
                tuilesAccessibles.add(chbis);
            }
            cbbis = g.getTuiles().get(g.getTuiles().indexOf(cd)+6);
            if(cbbis.getEtat()!=Utils.EtatTuile.COULEE && !tuilesAccessibles.contains(cbbis)) {
                tuilesAccessibles.add(cbbis);
            }
        }
        
        
        
        
        
        
        while (!queAccessibles) {
            queAccessibles= true;
            for (Tuile tuile : tuilesAccessibles) {
                if (tuile.getEtat()==Utils.EtatTuile.COULEE) {
                    if (!tuilesAccessibles.contains(g.getTuiles().get(g.getTuiles().indexOf(this.getEstSurTuile())+1))) {
                        tuilesAccessibles.add(tuile);
                    }
                }
            }
        }
        for (Tuile tuile : tuilesAccessibles) {
            if (tuile.getEtat() == ASSECHEE) {
                tuilesAccessibles.add(tuile);
            } else if (tuile.getEtat() == COULEE) {
                
                queAccessibles = false;
            } else if(tuile.getEtat()== INONDEE) {
                tuilesAccessibles.add(tuile);
                tuilesAccessibles = getTuilesAdjacentes(g,tuile);
                
            }
        }
        return tuilesAccessibles;

    }
}
