package toucan.modele.animation;

import toucan.modele.Case;
import toucan.modele.LesCases;

/**
 * Classe AffectationVarCase.
 * 
 * @author ANDRE Aurélien.
 */
public class AffectationVarCase implements IAnimation{

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
		
		c2.rester(vertical+horizontal);
		c1.droite(horizontal);
		c1.monter(vertical);
		
		c2.setValeur(c1.getValeur());
		
		c2.rester(vertical+horizontal);
		c1.descendre(vertical);
		c1.gauche(horizontal);
	}

	@Override
	public void executer(LesCases lc, String exp, String var) {
		// TODO Auto-generated method stub
		
	}
}