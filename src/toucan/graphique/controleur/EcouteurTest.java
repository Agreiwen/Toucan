package toucan.graphique.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import toucan.modele.Modele;

/**
 * Classe EcouteurTest.
 * 
 * @author ANDRE Aurélien.
 */
public class EcouteurTest implements ActionListener {
	
	/** Attribut m (Modele). */
	protected Modele m;
	
	/**
	 * Instantiation de EcouteurTest.
	 *
	 * @param m, le Modele.
	 */
	
	public EcouteurTest(Modele m) {
		this.m=m;
	}

	/*
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		m.setNumAlgo(1);
	}
}
