package toucan.graphique;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import toucan.graphique.controleur.EcouteurDemarrer;
import toucan.graphique.controleur.EcouteurGenererCases;
import toucan.graphique.controleur.EcouteurQuitter;
import toucan.graphique.controleur.EcouteurRedemarrer;
import toucan.graphique.controleur.EcouteurTexte;
import toucan.modele.Modele;

/**
 * Classe VueBoutons.
 * 
 * @author ANDRE Aurélien.
 */

public class VueBoutons extends JPanel implements Observer{
	
	/** Attribut demarrer (JButton). */
	protected JButton demarrer;
	
	/** Attribut fermer (JButton). */
	protected JButton fermer;
	
	protected JButton redemarrer;
	
	/** Attribut slider (JSlider). */
	protected JSlider slider;
	
	/** Attribut genererCases (JButton). */
	protected JButton genererCases;
	
	/** Attribut m (Modele). */
	protected Modele m;
	
	/** Attribut minimum (final int). */
	static final int minimum = 0;
	
	/** Attribut maximum (final int). */
	static final int maximum = 100;
	
	/** Attribut defaut (final int). */
	static final int defaut = 50; 
	
	/**
	 * Instantiation de VueBoutons.
	 *
	 * @param m, le Modele.
	 */
	public VueBoutons(final Modele m){
		super();
		this.m=m;
		this.setBackground(Color.LIGHT_GRAY);
		
		// Bouton DÃ©marrer (les mouvements)
		this.demarrer = new JButton("Demarrer");
		this.add(demarrer);
		demarrer.addActionListener(new EcouteurDemarrer(m));
		
		this.redemarrer = new JButton("Redemarrer");
		this.add(redemarrer);
		redemarrer.addActionListener(new EcouteurRedemarrer(m));
		
		// Bouton Quitter
		this.fermer = new JButton("Quitter");
		this.add(fermer);
		fermer.addActionListener(new EcouteurQuitter(m));
		
		// Bouton generation cases
		this.genererCases = new JButton("Generer les Cases");
		this.add(genererCases);
		genererCases.addActionListener(new EcouteurGenererCases(m));
		
		// Slider pour la vitesse de l'animation
		this.slider = new JSlider(JSlider.HORIZONTAL, minimum, maximum, defaut);
		this.slider.setBackground(Color.LIGHT_GRAY);
		slider.setMinorTickSpacing(20);
		slider.setPaintTicks(true);
		Hashtable<Integer, JLabel> labelTable = new Hashtable<Integer, JLabel>();
		labelTable.put( new Integer( 10 ), new JLabel("Rapide") );
		labelTable.put( new Integer( maximum ), new JLabel("Lent") );
		slider.setLabelTable( labelTable );
		slider.setPaintLabels(true);
		this.add(slider);
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				 JSlider source = (JSlider)e.getSource();
				 if (!source.getValueIsAdjusting()) {
					 int val = (int)source.getValue();
					 m.setTemporisation(val);
				 }
			}
		});
		m.addObserver(this);
		
	}
	
	/*
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	
	public void update(Observable arg0, Object arg1) {
		m.notifyObservers();
		if(m.getDemarrer()==1){
			demarrer.setText("Pause");
		}
		else if(m.getDemarrer()==2){
			demarrer.setText("Reprendre");
		}
		else demarrer.setText("Demarrer");
		
		if(m.getDemarrer()==0){
			redemarrer.setEnabled(false);
		}
		else{
			redemarrer.setEnabled(true);
		}
	}
}
