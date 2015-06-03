package toucan.graphique.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import toucan.modele.Modele;

/**
 * Classe EcouteurDemarrer.
 * 
 * @author ANDRE Aurélien.
 */

public class EcouteurDemarrer implements ActionListener {
	
	/** Attribut m (Modele). */
	protected Modele m;
	
	/**
	 * Instantiation de EcouteurDemarrer.
	 *
	 * @param m, le Modele.
	 */
	
	public EcouteurDemarrer(Modele m){
		this.m=m;
	}
	
	/*
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		if(m.getDemarrer()==0){
			m.setTemps(0);
			m.setDemarrerPause();
			Thread t = new Thread((Runnable)m, "Toucan");
			t.start() ;
		}
		else if(m.getDemarrer()==1){
			m.setDemarrerReprendre();
		}
		else m.setDemarrerRedemarrer();
	}
}
