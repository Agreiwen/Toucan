package toucan.modele;

import java.util.ArrayList;

/**
 * Classe LesCases.
 * 
 * @author ANDRE Aurélien.
 */

public class LesCases {
	
	/** Attribut listeCase (liste de Case). */
	protected ArrayList<Case> listeCase;
	
	/**
	 * Constructeur de LesCases.
	 */
	public LesCases(){
		listeCase = new ArrayList<Case>();
	}
	
	/**
	 * Methode getCase(int i).
	 *
	 * @param i, l'indice.
	 * @return la Case à l'indice i.
	 */
	
	public Case getCase(int i){
		//System.out.println("--LesCases-- Récupération de la case à l'indice "+i);
		return listeCase.get(i);
	}
	
	/**
	 * Methode addCase(Case c).
	 *
	 * @param c, ajoute la Case c à la liste de Case (listeCase).
	 */
	
	public void addCase(Case c){
		listeCase.add(c);
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder ("");
		for(int i=0; i<listeCase.size(); i++){
			sb.append(listeCase.get(i).toString());
		}
		return sb.toString();
	}
	
	/**
	 * Methode size().
	 *
	 * @return la taille de la liste de Case (listCase).
	 */
	
	public int size(){
		return listeCase.size();
	}
	
	/**
	 * Methode existeEncorePosition().
	 *
	 * @return true, s'il en existe encore.
	 */
	
	public boolean existeEncorePosition(){

		boolean rep = false;
    	int i = 0;
    	while(!rep && i < listeCase.size()){
    		Case c = listeCase.get(i);
    		if(c.existeEncorePosition())
    			rep = true;
    		else
    			i++;
    	}
    	return rep;
	}
}
