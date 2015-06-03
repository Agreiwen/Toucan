package toucan.modele;

/**
 * Classe Mouvement.
 * 
 * @author ANDRE Aurélien.
 */

public abstract class Mouvement {
	
	/** Attribut positionX (int). */
	protected int positionX;
	
	/** Attribut positionY (int). */
	protected int positionY;
	
	/** Attribut temps (int). */
	protected int temps;
	
	/** Attribut duree (int). */
	protected int duree;
	
	/** Attribut valeur (String). */
	protected String valeur;
	
	/**
	 * Constructeur de Mouvement.
	 *
	 * @param x, positionX.
	 * @param y, positionY.
	 * @param t, temps.
	 * @param d, duree.
	 * @param v, valeur.
	 */
	
	public Mouvement(int x, int y, int t, int d, String v){
		positionX=x;
		positionY=y;
		temps=t;
		duree=d;
		valeur = v;
	}

	/**
	 * Methode getPositionX().
	 *
	 * @return la positionX.
	 */
	
	public int getPositionX() {
		return positionX;
	}

	/**
	 * Methode getValeur().
	 *
	 * @return la valeur.
	 */
	
	public String getValeur(){
		return valeur;
	}

	/**
	 * Methode getPositionY().
	 *
	 * @return la positionY.
	 */
	
	public int getPositionY() {
		return positionY;
	}

	/**
	 * Methode getTemps().
	 *
	 * @return le temps.
	 */
	
	public int getTemps() {
		return temps;
	}

	/**
	 * Methode setTemps(int t).
	 *
	 * @param temps, le nouveau temps.
	 */
	
	public void setTemps(int temps) {
		this.temps = temps;
	}

	/**
	 * Methode getDuree().
	 *
	 * @return la duree.
	 */
	
	public int getDuree() {
		return duree;
	}

	/**
	 * Methode setDuree(int duree).
	 *
	 * @param duree, la nouvelle duree.
	 */
	
	public void setDuree(int duree) {
		this.duree = duree;
	}
	
	/**
	 * Methode getXarrive().
	 *
	 * @return la postion X d'arrivée.
	 */
	
	public abstract int getXarrive();
	
	/**
	 * Methode getYarrive().
	 *
	 * @return la postion Y d'arrivée.
	 */
	
	public abstract int getYarrive();
	
	/**
	 * Methode posXTemps(int t).
	 *
	 * @param t, le temps.
	 * @return la position X au temps t.
	 */
	
	public abstract int posXTemps(int t);
	
	/**
	 * Methode posYTemps(int t).
	 *
	 * @param t, le temps.
	 * @return la position Y au temps t.
	 */
	
	public abstract int posYTemps(int t);

	/**
	 * Methode tempsArrive().
	 *
	 * @return le temps d'arrivé.
	 */
	
	public int tempsArrive() {
		return temps+duree;
	}
	
	/*
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return "--Mouvement-- Position au cours du temps :\n--Mouvement-- Abscisse : "+getPositionX()+"\n--Mouvement-- Ordonée : "+getPositionY()+"\n--Mouvement-- Temps : "+getTemps();
	}
}
