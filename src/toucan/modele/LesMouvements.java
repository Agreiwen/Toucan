package toucan.modele;

import java.util.ArrayList;

/**
 * Classe LesMouvements.
 * 
 * @author ANDRE Aurélien.
 */

public class LesMouvements {
	
	/** Attribut listmouv (liste de Mouvement). */
	protected ArrayList<Mouvement> listmouv;
	
	/**
	 * Constructeur de LesMouvements.
	 */
	
	public LesMouvements(){
		listmouv = new ArrayList<Mouvement>();
	}
	
	/**
	 * Methode ajouterMouvement(Mouvement m).
	 *
	 * @param m, le mouvement à ajouter a la liste de mouvement (listmouv).
	 */
	
	public void ajouterMouvement(Mouvement m){
		listmouv.add(m);
	}
	
	/**
	 * Methode get().
	 *
	 * @param i, l'indice.
	 * @return le mouvement à l'indice i.
	 */
	public Mouvement get(int i) {
		if (i < listmouv.size()){
			return listmouv.get(i);
		}else{
			return null; 
		}
	}
	
	/**
	 * Methode isEmpty().
	 *
	 * @return true, si listmouv est vide.
	 */
	public boolean isEmpty(){
		return listmouv.isEmpty();
	}

	/**
	 * Methode getSize().
	 *
	 * @return la taille de listmouv.
	 */
	
	public int getSize() {
		// TODO Auto-generated method stub
		return listmouv.size();
	}
	
}
