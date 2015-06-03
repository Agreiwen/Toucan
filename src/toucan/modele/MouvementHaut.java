package toucan.modele;

/**
 * Classe MouvementHaut.
 * 
 * @author ANDRE Aurélien.
 */

public class MouvementHaut extends Mouvement{

	/**
	 * Constructeur de MouvementHaut.
	 *
	 * @param x, positionX.
	 * @param y, positionY.
	 * @param t, temps.
	 * @param d, duree.
	 * @param v, valeur.
	 */
	
	public MouvementHaut(int x, int y, int t, int d, String v) {
		super(x,y,t,d,v);
		// TODO Auto-generated constructor stub
	}

	/*
	 * @see toucan.modele.Mouvement#getXarrive()
	 */
	@Override
	public int getXarrive() {
		return positionX;
	}

	/*
	 * @see toucan.modele.Mouvement#getYarrive()
	 */
	@Override
	public int getYarrive() {
		return positionY-duree;
	}

	/*
	 * @see toucan.modele.Mouvement#posXTemps(int)
	 */
	@Override
	public int posXTemps(int t) {
		return positionX;
	}

	/*
	 * @see toucan.modele.Mouvement#posYTemps(int)
	 */
	@Override
	public int posYTemps(int t) {
		return positionY-(t-temps);
	}
	
	/*
	 * @see toucan.modele.Mouvement#getValeur()
	 */
	public String getValeur(){
		return valeur;
	}
}
