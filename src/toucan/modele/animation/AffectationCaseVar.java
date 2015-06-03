package toucan.modele.animation;

import toucan.modele.Case;
import toucan.modele.LesCases;

/**
 * Classe AffectationCaseVar.
 * 
 * @author ANDRE Aurélien.
 */

public class AffectationCaseVar implements IAnimation{

	/*
	 * @see toucan.modele.animation.IAnimation#executer(toucan.modele.LesCases, int, int)
	 */
	@Override
	public void executer(LesCases lc, int a, int b) {
		
		a = 0;
		
		Case c1 = lc.getCase(a);
		Case c2 = lc.getCase(b);
		
		int horizontal = c2.getPositionX()-c1.getPositionX();
		int vertical = 100;
		
		for(int i=0; i<lc.size();i++){
			if(lc.getCase(i) != c1 && lc.getCase(i) != c2){
				lc.getCase(i).rester((vertical+horizontal)*2);
			}
		}
		
		c1.rester(vertical+horizontal);
		c2.descendre(vertical);
		c2.gauche(horizontal);
		
		c1.setValeur(c2.getValeur());
		
		c1.rester(vertical+horizontal);
		c2.droite(horizontal);
		c2.monter(vertical);
	}

	@Override
	public void executer(LesCases lc, String exp, String var) {
		// TODO Auto-generated method stub
		
	}
}
