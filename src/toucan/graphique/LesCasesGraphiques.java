package toucan.graphique;

import java.util.ArrayList;

/**
 * Classe LesCasesGraphiques.
 * 
 * @author ANDRE Aurélien.
 */

public class LesCasesGraphiques {

	/** Attribut listeCaseGraphique de CaseGraphique (listeCaseGraphique). */
	private ArrayList<CaseGraphique> listeCaseGraphique;
	
	/**
	 * Instantiation de LesCasesGraphiques.
	 */
	public LesCasesGraphiques(){
		listeCaseGraphique = new ArrayList<CaseGraphique>();
	}
	
	/**
	 * Methode size().
	 *
	 * @return la taille de la liste de CaseGraphique (listeCaseGraphique).
	 */
	
	public int size(){
		return listeCaseGraphique.size();
	}
	
	/**
	 * Methode getCaseGraphique().
	 *
	 * @param i, l'indice.
	 * @return la CaseGraphique à l'indice i.
	 */
	
	public CaseGraphique getCaseGraphique(int i){
		//System.out.println("--LesCasesGraphiques-- Récupération de la CaseGraphique à l'indice "+i);
		return listeCaseGraphique.get(i);
	}
	
	/**
	 * Methode addCaseGraphique().
	 *
	 * @param c, la CaseGraphique à ajouter à la liste de CaseGraphique (listeCaseGraphique).
	 */
	
	public void addCaseGraphique(CaseGraphique c){
		listeCaseGraphique.add(c);
	}
}
