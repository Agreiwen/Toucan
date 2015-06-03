package toucan.graphique.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import toucan.modele.Modele;

/**
 * Classe EcouteurGenererCases.
 * 
 * @author ANDRE Aurélien.
 */

public class EcouteurGenererCases implements ActionListener {
	
	/** Attribut m (Modele). */
	protected Modele m;

	/**
	 * Instantiation de EcouteurGenererCases.
	 *
	 * @param m, le Modele.
	 */
	public EcouteurGenererCases(Modele m) {
		this.m=m;
	}

	/*
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("--EcouteurGenererCases-- actionPerformed : Demande au modele de generer les cases aléatoirements");
		m.setTemps(0);
		m.genererCases();
		m.setDemarrer();
		//System.out.println(m.getTemps());
		//m.setDeverrouille();
	}
}
