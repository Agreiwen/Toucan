package toucan.graphique;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import toucan.modele.Modele;

/**
 * Classe MainClass.
 * 
 * @author ANDRE Aurélien.
 */

public class MainClass extends JFrame {
    
    /**
     * Instantiation de MainClass.
     */
    public MainClass() {
        super("Projet Toucan - animation des algorithmes de tris");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //System.out.println("--MainClass-- Création du modèle \n");
        Modele m = new Modele();
        
        //System.out.println("--MainClass-- Affichage statique");
        m.affichageStatique();
        
        //System.out.println("--MainClass-- Création et ajout de la VueGraphique au modèle\n");
        VueGraphique vg = new VueGraphique(m);
        
        //System.out.println("--MainClass-- Création et ajout de la VueBoutons au modèle\n");
        VueBoutons vb = new VueBoutons(m);
        
        VueTexte vt = new VueTexte(m);
        
        this.add(vt, BorderLayout.EAST);
        this.add(vg, BorderLayout.CENTER);
        this.add(vb, BorderLayout.SOUTH);
        this.setJMenuBar(new VueMenu(m));

        pack() ;
        setVisible(true);
    }

    /**
     * Methode main().
     *
     * @param args, les arguments.
     */
    public static void main(String[] args) {
        new MainClass() ;
    }
}