package toucan.modele.algo;

import toucan.modele.LesCases;
import toucan.modele.animation.AffectationCaseCase;
import toucan.modele.animation.AffectationCaseVar;
import toucan.modele.animation.AffectationVarCase;
import toucan.modele.animation.ComparaisonCaseCase;
import toucan.modele.animation.IAnimation;

/**
 * Classe AlgoBulle.
 * 
 * @author ANDRE Aurélien.
 */

public class AlgoBulle implements IAlgo{
	
	/** Attribut lc (LesCases). */
	protected LesCases lc;
	
	/** Attribut caseCase (IAnimation). */
	protected IAnimation caseCase;
	
	/** Attribut caseVar (IAnimation). */
	protected IAnimation caseVar;
	
	/** Attribut varCase (IAnimation). */
	protected IAnimation varCase;
	
	/** Attribut compCaseCase (IAnimation). */
	protected IAnimation compCaseCase;
	
	/** Attribut tab (Tableau de int). */
	protected int[] tab;
	
	/**
	 * Constructeur de AlgoBulle.
	 *
	 * @param lc, liste de case
	 * @param tab, tableau de case
	 */
	public AlgoBulle(LesCases lc, int[] tab){
		this.lc = lc;
		this.tab = tab;
		caseCase = new AffectationCaseCase();
		caseVar = new AffectationCaseVar();
		varCase = new AffectationVarCase();
		compCaseCase = new ComparaisonCaseCase();
	}
	
	/*
	 * @see toucan.modele.algo.IAlgo#trier()
	 */
	@Override
	public void trier() {
		
		boolean encore = true ;
		int n = tab.length ;
		while(encore){
			encore = false ;
			for (int j = 1 ; j < n - 1; j++) {
				compCaseCase.executer(lc, j, j+1);
				if(tab[j] > tab[j+1]){
					caseVar.executer(lc, 0, j);
					int var = tab[j];
					caseCase.executer(lc, j, j+1 );
					tab[j] = tab[j+1] ;
					varCase.executer(lc, 0, j+1);
					tab[j+1] = var;
					encore = true;
				}
			}
			n = n-1 ;
		}
	}

	@Override
	public void setX(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setLesCases(LesCases lc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTab(int[] tab) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNbCases(int i) {
		// TODO Auto-generated method stub
		
	}
}