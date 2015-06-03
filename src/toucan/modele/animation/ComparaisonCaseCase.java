package toucan.modele.animation;

import toucan.modele.Case;
import toucan.modele.LesCases;

/**
 * Classe ComparaisonCaseCase.
 * 
 * @author ANDRE Aurélien.
 */
public class ComparaisonCaseCase implements IAnimation{

	/*
	 * @see toucan.modele.animation.IAnimation#executer(toucan.modele.LesCases, int, int)
	 */
	@Override
	public void executer(LesCases lc, int a, int b) {
		
		Case c1 = lc.getCase(a);
		Case c2 = lc.getCase(b);
		
		int vertical = 50;
		
		for(int i=0; i<lc.size();i++){
			if(lc.getCase(i) != c1 && lc.getCase(i) != c2){
				lc.getCase(i).rester((vertical)*2);
			}
		}
		
		c1.descendre(vertical);
		c2.descendre(vertical);
		c1.monter(vertical);
		c2.monter(vertical);
		
	}

	@Override
	public void executer(LesCases lc, String exp, String var) {
		// TODO Auto-generated method stub
		
	}

}
