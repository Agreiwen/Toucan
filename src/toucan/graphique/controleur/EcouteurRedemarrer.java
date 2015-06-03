package toucan.graphique.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import toucan.modele.Modele;

public class EcouteurRedemarrer implements ActionListener {

	protected Modele m;
	
	public EcouteurRedemarrer(Modele m) {
		// TODO Auto-generated constructor stub
		this.m=m;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(m.getDemarrer()!=0){
			m.setTemps(0);
			m.setDemarrerPause();
			m.miseAJour();
		}
		m.setTemps(0);
		m.miseAJour();
	}

}
