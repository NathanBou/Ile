package ileinterdite;

import java.util.ArrayList;

public class Controleur implements Observateur {

	private VueAventurier vueAventurier;
	private Vue vue;
	private Grille grille;
	private ArrayList<Aventurier> joueurs;
	private ArrayList<Innondation> pileCartes;
	private ArrayList<Innondation> defausse;
	private ArrayList<CTresor> pileCarte;

        
        Controleur() {
            
        }
	/**
	 * 
	 * @param Action
	 */
	public void ChoisirAction(enum Action) {
		// TODO - implement Controleur.ChoisirAction
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Message
	 */
	public void TraiterMessage(Message message) {
		// TODO - implement Controleur.TraiterMessage
		
	}

}