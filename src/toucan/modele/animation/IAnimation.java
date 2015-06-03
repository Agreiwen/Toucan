package toucan.modele.animation;

import toucan.modele.LesCases;

/**
 * Interface IAnimation.
 * 
 * @author ANDRE Aurélien.
 */
public interface IAnimation {
	
	/**
	 * Methode executer(LesCase lc, Case a, Case b).
	 *
	 * @param lc, la liste de case.
	 * @param a, la case a
	 * @param b, la case b
	 */
	public abstract void executer(LesCases lc, int a, int b);

	public abstract void executer(LesCases lc, String exp, String var);

}
