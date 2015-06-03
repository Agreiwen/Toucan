package toucan.outils;

import java.io.ByteArrayInputStream;

import toucan.analyse.AnalyseurLexical;
import toucan.analyse.AnalyseurSyntaxique;
import toucan.arbre.ArbreAbstrait;
import toucan.exceptions.ExecutionException;
import toucan.modele.LesCases;
import toucan.modele.Modele;
import toucan.modele.algo.IAlgo;
import toucan.outils.KitJava;

public class AlgoFacade implements IAlgo{

	protected Modele m;
	protected String s;
	protected int[] tab;
	protected LesCases lc;

	public AlgoFacade(LesCases lc, int[] tab, Modele m) {
		// TODO Auto-generated constructor stub
		super();
		this.m=m;
		this.tab=tab;
		this.lc=lc;
	}

	@SuppressWarnings("static-access")
	@Override
	public void trier() throws ExecutionException {
		// TODO Auto-generated method stub
		String codeArbre = m.getTexte();
		//System.out.println(codeArbre);
		KitJava.getInstance().setTab(tab);
		KitJava.getInstance().setListe(lc);
		ArbreAbstrait arbre = null;
		try {
			AnalyseurSyntaxique analyseur = new AnalyseurSyntaxique(
				new AnalyseurLexical(
						new ByteArrayInputStream(codeArbre.getBytes())));
		
			arbre = (ArbreAbstrait)analyseur.parse().value;
			codeArbre = arbre.getCodeDecore();
			KitJava.getInstance().construireCode(codeArbre);
			KitJava.getInstance().compiler();
			KitJava.getInstance().executer();
		} catch (Exception e) {
			//e.printStackTrace();
			// TODO Auto-generated catch block
			throw new ExecutionException();
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
