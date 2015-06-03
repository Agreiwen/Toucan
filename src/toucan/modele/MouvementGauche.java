package toucan.modele;

/**
 * Classe MouvementGauche.
 * 
 * @author ANDRE Aurélien.
 */

public class MouvementGauche extends Mouvement{

	/**
	 * Constructeur de MouvementGauche.
	 *
	 * @param x, positionX.
	 * @param y, positionY.
	 * @param t, temps.
	 * @param d, duree.
	 * @param v, valeur.
	 */
	
	public MouvementGauche(int x, int y, int t, int d, String v) {
		super(x,y,t,d,v);
	}
	
	/*
	 * @see toucan.modele.Mouvement#getXarrive()
	 */
	@Override
	public int getXarrive() {
		return positionX-duree;
	}

	/*
	 * @see toucan.modele.Mouvement#getYarrive()
	 */
	@Override
	public int getYarrive() {
		return positionY;
	}

	/*
	 * @see toucan.modele.Mouvement#posXTemps(int)
	 */
	@Override
	public int posXTemps(int t) {
		return positionX-(t-temps);
	}

	/*
	 * @see toucan.modele.Mouvement#posYTemps(int)
	 */
	@Override
	public int posYTemps(int t) {
		return positionY;
	}
	
	/*
	 * @see toucan.modele.Mouvement#getValeur()
	 */
	public String getValeur(){
		return valeur;
	}
}
