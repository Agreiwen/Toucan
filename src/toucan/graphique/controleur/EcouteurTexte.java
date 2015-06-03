package toucan.graphique.controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;

import toucan.modele.Modele;

public class EcouteurTexte implements ActionListener {

	protected Modele m;
	protected JEditorPane jt;
	
	public EcouteurTexte(Modele m, JEditorPane jt){
		this.m=m;
		this.jt=jt;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = jt.getText();
		m.setTexte(s);
		m.setDemarrer();
		m.miseAJour();
	}
}
