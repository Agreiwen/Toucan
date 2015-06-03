package toucan.modele.algo;

import toucan.exceptions.ExecutionException;
import toucan.modele.LesCases;

/**
 * Iterface IAlgo.
 * 
 * @author ANDRE Aurelien.
 */
public interface IAlgo {
	
	/**
	 * Methode trier()
	 */
	public abstract void trier() throws ExecutionException;

	public abstract void setX(int i);

	public abstract int getX();
	
	public abstract void setLesCases(LesCases lc);

	public abstract void setTab(int[] tab);

	public abstract void setNbCases(int i);
	
}
