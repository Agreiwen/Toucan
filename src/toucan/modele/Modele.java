package toucan.modele;

import java.util.Observable;
import java.util.Random;

import toucan.arbre.ArbreAbstrait;
import toucan.arbre.BlocDInstructions;
import toucan.arbre.InstructionAffectationCaseCase;
import toucan.exceptions.ExecutionException;
import toucan.modele.algo.AlgoBulle;
import toucan.modele.algo.AlgoTest;
import toucan.modele.algo.IAlgo;
import toucan.outils.AlgoFacade;

/**
 * Classe Modele.
 * 
 * @author ANDRE Aurélien.
 */

public class Modele extends Observable implements Runnable{
	
	/** Attribut lc (LesCases). */
	protected LesCases lc;
	
	/** Attribut algoTest (IAlgo). */
	protected IAlgo algoTest;
	
	/** Attribut algoBulle (IAlgo). */
	protected IAlgo algoBulle;
	
	/** Attribut temps (int). */
	protected int temps = 0;
	
	/** Attribut temporisation (int). */
	protected int temporisation = 50;
	
	/** Attribut tab (Tableau de int). */
	protected int tab[];
	
	/** Attribut taille (int). */
	protected int taille = 7;
	
	/** Attribut numAlgo (int). */
	protected int numAlgo = 0;
	
	/** Attribut demarrer (int). */
	protected int demarrer = 0;
	
	protected String texte;
	
	protected IAlgo algoFacade;
	
	protected boolean erreur = false;
	
	/**
	 * Constructeur du Modele.
	 */
	public Modele(){
		
		lc = new LesCases();
		this.tab = new int[taille];
		
		//System.out.println("--Modele-- Création des cases");
		
		for(int i=0; i<taille; i++){
			if(i==0){
				Case c = new Case(50+(i*50),150,10, "0");
				lc.addCase(c);
				tab[i] = 0;
			}
			else{
				Case c = new Case(50+(i*50),50,10, valeurCaseAleatoire());
				lc.addCase(c);
				tab[i] = Integer.parseInt(c.getValeur());
			}
		}
		//System.out.println("--Modele-- Ajout des cases à la liste des cases");
		//System.out.println("--Modele-- Taille de la liste des cases : "+lc.size()+"\n");	
	}
	
	/**
	 * Methode valeurCaseAleatoire().
	 *
	 * @return une valeur aléatoire comprise entre -10 et 10.
	 */
	
	public String valeurCaseAleatoire(){
		Random r1 = new Random();
		Random r2 = new Random();
		  
		if(r2.nextInt(2) == 0){
			return ""+(r1.nextInt(11));
			}else{
				return ""+(-r1.nextInt(11));
				}
		}
	
	/**
	 * Methode getCase(int i).
	 *
	 * @param i, l'indice i.
	 * @return la Case à l'indice i.
	 */
	
	public Case getCase(int i){
		return lc.getCase(i);
	}
	
	/**
	 * Methode getTemps().
	 *
	 * @return le temps.
	 */
	
	public int getTemps(){
		return temps;
	}
	
	/**
	 * Methode setTemps(int t).
	 *
	 * @param t, le nouveau temps.
	 */
	
	public void setTemps(int t){
		temps = t;
	}
	
	/**
	 * Methode getSize().
	 *
	 * @return la taille de lc.
	 */
	
	public int getSize(){
		return lc.size();
	}
	
	/**
	 * Methode affichageStatique().
	 * Effecte un mouvement rester() à toutes les cases de lc.
	 */
	
	public void affichageStatique(){
		for(int i=0; i<lc.size(); i++){
			lc.getCase(i).rester(1);
		}
	}
	
	/**
	 * Methode setDemarrerPause()
	 * Passage du bouton en pause
	 */
	
	public void setDemarrer(int i){
		this.demarrer=i;
	}
	
	public void setDemarrerPause(){
		this.demarrer = 1;
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Methode setDeerouille()
	 * Passage du bouton en reprendre
	 */
	
	public void setDemarrerReprendre(){
		this.demarrer = 2;
		affichageStatique();
		setChanged();
		notifyObservers();
	}
	
	public void setDemarrerRedemarrer(){
		this.demarrer = 1;
		setChanged();
		notifyObservers();
	}
	
	public void setDemarrer(){
		this.demarrer = 0;
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Methode estVerrouille().
	 *
	 * @return true, si le bouton est verouillé.
	 */
	
	public int getDemarrer(){
		return demarrer;
	}
	
	/**
	 * Methode creerLesMouvements().
	 * Créer les mouvements en fonction de l'algo.
	 */
	
	public void run(){
		switch(numAlgo){
		case 1: this.algoTest = new AlgoTest(lc); 
			try {
				algoTest.trier();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
		case 0: this.algoBulle = new AlgoBulle(lc, tab);
			try {
				algoBulle.trier();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				break;
		case 3: this.algoFacade = new AlgoFacade(lc, tab, this);
			try {
				algoFacade.trier();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				setErreur();
			}
		}
		
		affichageStatique();
		miseAJour();
	}
	
	public boolean getErreur(){
		return erreur;
	}
	
	public void setErreur(){
		this.erreur = true;
	}
	
	/**
	 * Methode setNumAlgo(int i).
	 *
	 * @param i, l'indice de l'algo.
	 */
	
	public void setNumAlgo(int i){
		numAlgo=i;
	}
	
	/**
	 * Methode miseAJour();
	 */
	
	public void miseAJour(){
		setChanged();
		notifyObservers();
	}
	
	/**
	 * Methode existeEncorePosition().
	 *
	 * @return true, s'il en existe encore.
	 */
	
	public boolean existeEncorePosition(){
		//System.out.println("--Modele-- Existe-il encore des positions ? "+lc.existeEncorePosition()+"\n");
    	return lc.existeEncorePosition();
	}

	/**
	 * Methode avancerTemps().
	 * Incrémentation du temps.
	 */
	
	public void avancerTemps() {
		temps+=1;
	}

	/**
	 * Methode generercases().
	 * Genere de nouvelles cases.
	 */
	
	public void genererCases() {
		//System.out.println("--Modele-- Demande génération cases");
		
		lc = new LesCases();
		this.tab = new int[taille];
		
		//System.out.println("--Modele-- Création des cases");
		
		for(int i=0; i<taille; i++){
			if(i==0){
				Case c = new Case(50+(i*50),150,10, "0");
				lc.addCase(c);
				tab[i] = 0;
			}
			else{
				Case c = new Case(50+(i*50),50,10, valeurCaseAleatoire());
				lc.addCase(c);
				tab[i] = Integer.parseInt(c.getValeur());
			}
		}
		//System.out.println("Demande génération"+lc.toString());	
		miseAJour();
		affichageStatique();
	}

	/**
	 * Methode getTemporisation().
	 *
	 * @return la temporisation.
	 */
	
	public int getTemporisation() {
		return temporisation;
	}
	
	/**
	 * Methode setTemporisation(int t).
	 *
	 * @param t, la nouvelle temporisation.
	 */
	
	public void setTemporisation(int t) {
		temporisation = t;
	}
	
	public void setTexte(String s){
		texte=s;
		setChanged();
		notifyObservers();
	}
	
	public String getTexte(){
		return texte;
	}
	
}
