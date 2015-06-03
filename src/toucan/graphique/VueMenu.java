package toucan.graphique;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import toucan.graphique.controleur.EcouteurBulles;
import toucan.graphique.controleur.EcouteurPerso;
import toucan.graphique.controleur.EcouteurTest;
import toucan.modele.Modele;

/**
 * Classe VueMenu.
 * 
 * @author ANDRE Aur√©lien.
 */

public class VueMenu extends JMenuBar{
	
	/** Attribut m (Modele). */
	protected Modele m;


	/**
	 * Instantiation de VueMenu.
	 *
	 * @param m, le Modele.
	 */
	
	public VueMenu(Modele m) {
		this.m=m;
		JMenu jMenu = new JMenu("Algo");
		
		JMenuItem jMenuItemTest= new JMenuItem("Tri de test");
		JMenuItem jMenuItemBulle= new JMenuItem("Tri ‡†bulles");
		JMenuItem jMenuItemPerso= new JMenuItem("Algo perso");
		
		jMenuItemPerso.addActionListener(new EcouteurPerso(m));
		jMenuItemTest.addActionListener(new EcouteurTest(m));
		jMenuItemBulle.addActionListener(new EcouteurBulles(m));
		
		jMenu.add(jMenuItemPerso);
		jMenu.add(jMenuItemBulle);
		jMenu.add(jMenuItemTest);
		
		this.add(jMenu);
	}
}
