package toucan.graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;

import toucan.graphique.controleur.EcouteurTexte;
import toucan.modele.Modele;

public class VueTexte extends JPanel implements Observer{
	
	protected Modele m;
	protected JButton valide;
	protected JLabel erreur;
	
	public VueTexte(Modele mod){
		super();
		this.m = mod;
		m.addObserver(this);
		
		BorderLayout texte = new BorderLayout();
		this.setLayout(texte);
		
		
		JEditorPane jt = new JEditorPane();
		jt.setPreferredSize(new Dimension(250,450));
		this.add(jt,BorderLayout.EAST);
		jt.setText("/* Ecrivez votre code ici. */");
		jt.setForeground(new Color(195,195,195));
		
		
		this.valide = new JButton("Valider");
		this.add(valide,BorderLayout.SOUTH);
		valide.addActionListener(new EcouteurTexte(m,jt));
		
		this.erreur = new JLabel();
		erreur.setForeground(new Color(255,0,0));
		this.add(erreur, BorderLayout.NORTH);
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		if(m.getErreur()== true){
			erreur.setText("Il y a une erreur");
		}
		else {
			erreur.setText("");
		}
	}
	
	
}
