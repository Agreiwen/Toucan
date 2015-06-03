package toucan.modele.animation;

import toucan.modele.LesCases;

public class AffectationExpressionVar implements IAnimation{

	@Override
	public void executer(LesCases lc, String exp, String var) {
		// TODO Auto-generated method stub
			 lc.getCase(lc.size()-1).setValeur(exp);
	}

	@Override
	public void executer(LesCases lc, int a, int b) {
		// TODO Auto-generated method stub
		
	}
}
