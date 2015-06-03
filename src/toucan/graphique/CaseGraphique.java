package toucan.graphique;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import toucan.modele.Case;
import toucan.modele.Mouvement;

/**
 * Classe CaseGraphique.
 * 
 * @author ANDRE Aurélien.
 */

public class CaseGraphique extends BufferedImage {
		    
	/** Attribut carre (Graphics2D). */
    protected Graphics2D carre ;
		    
    /** Attribut cote (int). */
    protected int cote = 50 ;
		    
    /** Attribut couleur (Color). */
    protected Color couleur ;
		    
    /** Attribut valeur (String). */
    protected String valeur ;
		    
    /** Attribut c (Case). */
    protected Case c;
		    
    /**
     * Instanciation d'un élément graphique à dessiner (ici un carré).
     *
     * @param c, la Case.
     * @param coul, la couleur.
     * @param temps, le temps.
     */
		    
	  public CaseGraphique( Case c, Color coul, int temps) {
		  super(150, 150, BufferedImage.TYPE_INT_ARGB);
		  carre = createGraphics();
		  valeur = c.getValeur() ;
		  couleur = coul ;
		  this.c=c;
		  
		  dessinerCase(temps) ;
	  }
		    
	  /**
	   * Dessin de l'élément graphique (l'élément graphique est redessiné, car sa couleur et son contenu peuvent.
	   * changer au cours de l'animation.
	   *
	   * @param temps, le temps.
	   */
		  
	  private void dessinerCase(int temps) {
		  carre.setPaint(Color.white) ;
		  carre.fillRect(0, 0, cote, cote) ;
		  carre.setColor(couleur) ;
		  carre.drawRect(0, 0, cote, cote); 
		  carre.setFont(new Font("Arial", Font.BOLD, 16));
		  
		  dessinerChaineAuCentre(c.valeurAuTempsT(temps), 0, 0, cote, carre); 
	  }
		    
	  /**
	   * Methode getValeur().
	   *
	   * @return valeur.
	   */

	  public String getValeur(){
		  return c.getValeur();
	  }

	  /**
	   * Fonction pour centrer la chaîne de caractères dans l'élément graphique.
	   *
	   * @param s, chaîne de caractère à écrire au centre de d'élément graphique.
	   * @param w, abscisse initiale relative de la chaîne par rapport à l'élément graphique.
	   * @param h, ordonnée initiale relative de la chaîne par rapport à l'élément graphique.
	   * @param c, largeur de l'élément dans lequel on centre la chaîne.
	   * @param g, élément graphique.
	   */
	  
	  private void dessinerChaineAuCentre(String s, int w, int h, int c, Graphics2D g) {
		  // Find the size of string s in the font of the Graphics context 
		  FontMetrics fm = g.getFontMetrics();
		  int xC = (c - fm.stringWidth(s)) / 2;
		  int yC = (fm.getAscent() + (c - (fm.getAscent() + fm.getDescent())) / 2);
		  
		  // Center text horizontally and vertically within provided rectangular bounds
		  g.drawString(s, xC + w, yC + h);
	  } 
		    
	  /**
	   * Dessin de l'élément graphique et positionnement dans la fenêtre graphique.
	   *
	   * @param g, fenêtre graphique dans laquelle on dessine.
	   * @param temps, le temps.
	   */

	  public void dessiner(Graphics g, int temps) {   
		  dessinerCase(temps) ;
		  //System.out.println("--CaseGraphique-- Dessine la case graphique\n--CaseGraphique-- Taille de la liste de mouvement de la case correspondant à cette case graphique : "+c.getLesMouvements().getListmouv().size());
		  //System.out.println("--CaseGraphique-- Récupération du dernier mouvement de cette case\n");
		  Mouvement mouvEnCours = c.mouvementAuTempsT(temps);
		  //System.out.println(mouvEnCours.toString()+"\n");
		  //System.out.println("--CaseGraphique-- Position X : "+c.getPositionX()+" // DernierePositionX : "+mouvEnCours.getPositionX());
		  int x=(mouvEnCours.posXTemps(temps));
		  //System.out.println("--CaseGraphique-- PositionX en fonction du temps : "+x+"\n");
		  //System.out.println("--CaseGraphique-- Position Y : "+c.getPositionY()+" // DernierePositionY : "+mouvEnCours.getPositionY());
		  int y=(mouvEnCours.posYTemps(temps));
		  //System.out.println("--CaseGraphique-- PositionY en fonction du temps : "+y+"\n");
		  g.drawImage(this, x, y, null);
	  }
}
