package toucan.graphique;

import java.lang.reflect.InvocationTargetException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import toucan.modele.Modele;

/**
 * Classe VueGraphique.
 * 
 * @author ANDRE Aurélien.
 */

public class VueGraphique extends JPanel implements Observer{
	
	/** Attribut va (VueAnimation). */
	protected VueAnimation va;
	
	/** Attribut m (Modele). */
	protected Modele m;
	
	/**
	 * Instantiation de VueGraphique.
	 *
	 * @param mod, le Modele.
	 */
	
	public VueGraphique(Modele mod){
		mod.addObserver(this);
		this.m=mod;
		//System.out.println("--VueGraphique-- Création et ajout de la VueAnimation au modèle\n");
		va = new VueAnimation(m);
		this.add(va);
	}
	
	/*
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		//System.out.println("--VueGraphique-- Repaint du update");
		
		Runnable code = new Runnable() {
			public void run() {
				va.creerlescasesgraphiques();
				va.repaint();
			}
		};
		if (SwingUtilities.isEventDispatchThread())
			code.run() ;
		else
			try {
				SwingUtilities.invokeAndWait(code) ;
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}