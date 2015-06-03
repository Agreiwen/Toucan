package toucan.graphique.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import toucan.modele.Modele;

/**
 * Classe EcouteurQuitter.
 * 
 * @author ANDRE Aurélien.
 */
public class EcouteurQuitter implements ActionListener {
	
	/** Attribut m (Modele). */
	protected Modele m;
	
	/**
	 * Instantiation de EcouteurQuitter.
	 *
	 * @param m, le Modele
	 */
	
	public EcouteurQuitter(Modele m) {
		// TODO Auto-generated constructor stub
		this.m=m;
	}

	/*
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}
}
