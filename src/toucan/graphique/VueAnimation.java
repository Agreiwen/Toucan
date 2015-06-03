package toucan.graphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;

import toucan.modele.Modele;

/**
 * Classe VueAnimation.
 * 
 * @author ANDRE Aurélien.
 */

public class VueAnimation extends JPanel {
    
    /** Attribut cellule1 (CaseGraphique). */
    protected CaseGraphique cellule1 ;
    
    /** Attribut cellule2 (CaseGraphique). */
    protected CaseGraphique cellule2 ;
    
    /** Attribut cellule3 (CaseGraphique). */
    protected CaseGraphique cellule3 ;
    
    /** Attribut temporisation (int). */
    protected static int temporisation;
   
    /** Attribut m (Modele). */
    protected Modele m;
    
    /** Attribut listeCaseGraphique (Liste de CaseGraphiques). */
    protected LesCasesGraphiques listeCaseGraphique;
    
    /**
     * Instantiation d'une VueAnimation.
     *
     * @param mod, Le modele.
     */
    public VueAnimation(Modele mod) {
        super();
        this.m = mod;
        this.setPreferredSize(new Dimension(500, 500)) ;
        this.listeCaseGraphique = new LesCasesGraphiques();
     
        creerlescasesgraphiques();
        repaint();
    }
    
    /**
     * Methode Creerlescasesgraphiques().
     */
    
    public void creerlescasesgraphiques() {
    	listeCaseGraphique = new LesCasesGraphiques();
    	for(int i=0; i<m.getSize(); i++){
        	CaseGraphique cellule = new CaseGraphique(m.getCase(i), Color.blue, m.getTemps());
        	listeCaseGraphique.addCaseGraphique(cellule);
        	//System.out.println("--VueAnimation-- Création de la case graphique "+cellule.getValeur()+"\n");
        }
		
	}

	/**
	 * Methode ExisteEncorePosition().
	 *
	 * @return true, s'l en existe encore.
	 */
    
	public boolean existeEncorePosition(){
    	//System.out.println("--VueAnimation-- Demande l'existeEncorePosition au Modele");
    	return m.existeEncorePosition();
    }
    
    /*
     * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
     */
    @Override
    public void paintComponent(Graphics g) { 
        //System.out.println("--Vue Animation-- Je repaint");
    	super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        int w = getWidth() ;
        int h = getHeight() ;

        GradientPaint gp = new GradientPaint(-w, -h, Color.LIGHT_GRAY, w, h, Color.WHITE);
        g2.setPaint(gp);
        g2.fillRect(0, 0, w, h);

        for(int i=0; i<listeCaseGraphique.size(); i++){
        	listeCaseGraphique.getCaseGraphique(i).dessiner(g2,m.getTemps());
        	//System.out.println("--VueAnimation-- Demande le dessin de la case graphique "+listeCaseGraphique.getCaseGraphique(i).getValeur()+"\n");
        }
        
        try {
            Thread.sleep(m.getTemporisation()) ;
        } catch (InterruptedException ex) {
            Logger.getLogger(VueAnimation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        m.avancerTemps();
        
      //System.out.println("--VueAnimation-- Il existe encore des positions, Repaint !!\n");
        if (existeEncorePosition()){
        	if(m.getDemarrer()==2){
        		
        	}
        	else repaint();
        }
        else{
        	//System.out.println("--VueAnimation-- Il n'existe plus de position, pas de repaint !!\n");
        }
        //System.out.println("--VueAnimation-- Fin de la fonction paintComponent\n");
    }
}
