package toucan.graphique.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import toucan.modele.Modele;

public class EcouteurPerso implements ActionListener {

	protected Modele m;
	
	public EcouteurPerso(Modele m) {
		this.m=m;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		m.setNumAlgo(3);
	}

}
