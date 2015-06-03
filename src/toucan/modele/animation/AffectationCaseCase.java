package toucan.modele.animation;

import toucan.modele.Case;
import toucan.modele.LesCases;

/**
 * Classe AffectationCaseCase.
 * 
 * @author ANDRE Aurélien.
 */

public class AffectationCaseCase implements IAnimation{

	/*
	 * @see toucan.modele.animation.IAnimation#executer(toucan.modele.LesCases, int, int)
	 */
	@Override
	public void executer(LesCases lc, int a, int b) {
		
		Case c1 = lc.getCase(a);
		Case c2 = lc.getCase(b);
		
		
		int horizontal = horizontal(c1,c2);
		int vertical = 75;
		
		for(int i=0; i<lc.size();i++){
			if(lc.getCase(i) != c1 && lc.getCase(i) != c2){
				lc.getCase(i).rester((vertical+horizontal)*2);
			}
		}
		
		c1.descendre(vertical);
		c2.descendre(vertical);
		
		c1.droite(horizontal);
		c2.gauche(horizontal);
		
		c1.setValeur(c2.getValeur());
		
		c1.gauche(horizontal);
		c2.droite(horizontal);
		
		c1.monter(vertical);
		c2.monter(vertical);
	}
	
	/**
	 * Methode horizontal(Case c1, Case c2).
	 *
	 * @param c1, la Case c1.
	 * @param c2,  la Case c2.
	 * @return un entier.
	 */
	public int horizontal(Case c1, Case c2){
		int aux;
		if(c1.getPositionX() <= c2.getPositionX()){
			aux = (c2.getPositionX() - c1.getPositionX())/2;
			return aux;
		}
		else{
			aux = (c1.getPositionX() - c2.getPositionX())/2;
			return aux;
		}
	}

	@Override
	public void executer(LesCases lc, String exp, String var) {
		// TODO Auto-generated method stub
		
	}
}
