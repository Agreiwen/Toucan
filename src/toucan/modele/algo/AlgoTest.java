package toucan.modele.algo;

import toucan.modele.LesCases;
import toucan.modele.animation.AffectationCaseCase;
import toucan.modele.animation.AffectationCaseVar;
import toucan.modele.animation.AffectationVarCase;
import toucan.modele.animation.ComparaisonCaseCase;
import toucan.modele.animation.IAnimation;

/**
 * Classe AlgoTest.
 * 
 * @author ANDRE Aurélien.
 */

public class AlgoTest implements IAlgo{
	
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
	
	/**
	 * Constructeur de AlgoTest.
	 *
	 * @param lc, la liste de case.
	 */
	public AlgoTest(LesCases lc){
		this.lc = lc;
	}

	/*
	 * @see toucan.modele.algo.IAlgo#trier()
	 */
	@Override
	public void trier() {
		
		this.caseCase = new AffectationCaseCase();
		this.caseVar = new AffectationCaseVar();
		this.varCase = new AffectationVarCase();
		this.compCaseCase = new ComparaisonCaseCase();
		
		caseCase.executer(lc,3,4);
		caseVar.executer(lc,5,6);
		varCase.executer(lc,3,5);
		compCaseCase.executer(lc, 2, 3);
		
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
