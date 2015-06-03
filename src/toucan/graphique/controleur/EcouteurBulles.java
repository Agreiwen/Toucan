package toucan.graphique.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import toucan.modele.Modele;

/**
 * Classe EcouteurBulles.
 * 
 * @author ANDRE Aurélien.
 */

public class EcouteurBulles implements ActionListener {
	
	/** Attribut m (Modele). */
	protected Modele m;
	
	/**
	 * Instantiatino de EcouteurBulles.
	 *
	 * @param m, le Modele.
	 */
	
	public EcouteurBulles(Modele m) {
		this.m=m;
	}

	/*
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		m.setNumAlgo(0);
	}
}
