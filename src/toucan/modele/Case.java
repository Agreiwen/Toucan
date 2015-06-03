package toucan.modele;

/**
 * Classe Case.
 * 
 * @author ANDRE Aurélien.
 */

public class Case {
	
	/** Attribut listmouv (LesMouvements). */
	private LesMouvements listmouv;
	
	/** Attribut positionX (int). */
	private int positionX;
	
	/** Attribut positionY (int). */
	private int positionY;
	
	/** Attribut temps (int). */
	private int temps;
	
	/** Attribut valeur (String). */
	private String valeur;
	
	/**
	 * Constructeur de Case.
	 *
	 * @param x, la positionX.
	 * @param y, la positionY.
	 * @param t, le temps.
	 * @param s, la valeur.
	 */
	
	public Case(int x, int y, int t,String s){
		positionX=x;
		positionY=y;
		temps=t;
		this.valeur=s;
		listmouv = new LesMouvements();
	}
	
	/**
	 * Methode getValeur().
	 *
	 * @return valeur.
	 */
	
	public String getValeur(){
		return valeur;
	}
	
	/**
	 * Methode getTemps().
	 *
	 * @return temps
	 */
	
	public int getTemps(){
		return this.temps;
	}
	
	/**
	 * Methode getPositionX().
	 *
	 * @return positionX.
	 */
	
	public int getPositionX(){
		return this.positionX;
	}
	
	/**
	 * Methode getPositionY().
	 *
	 * @return positionY.
	 */
	
	public int getPositionY(){
		return this.positionY;
	}
	
	/**
	 * Methode getLesMouvements().
	 *
	 * @return listmouv.
	 */
	
	public LesMouvements getLesMouvements(){
		return this.listmouv;
	}
	
	/**
	 * Methode setPositionX(int a).
	 *
	 * @param a, la nouvelle positionX.
	 */
	
	public void setPositionX(int a){
		this.positionX = a;
	}
	
	/**
	 * Methode setPositionY(int b).
	 *
	 * @param b, la nouvelle positionY.
	 */
	
	public void setPositionY(int b){
		this.positionX = b;
	}
	
	/**
	 * Methode dernierMouvement().
	 *
	 * @return le dernier mouvement (de listmouv).
	 */
	
	public Mouvement dernierMouvement(){
		return listmouv.get(listmouv.getSize()-1);
	}
	
	/**
	 * Methode monter(int d).
	 *
	 * @param d, la durée.
	 */
	
	public void monter(int d){
		//System.out.println("--Case-- Demande à la case de monter de "+d);
		if(this.listmouv.getSize()==0){
			//System.out.println("--Case-- La case n'a pas déjà effectuée de mouvement antérieur");
			Mouvement m =new MouvementHaut(positionX, positionY, 0, d, valeur);
			//System.out.println("--Case-- Ajout du nouveau mouvement monter("+d+") à la liste des mouvements de cette case\n");
			listmouv.ajouterMouvement(m);
			//System.out.println(m.toString()+"\n");
		}
		else{
			//System.out.println("--Case-- La case a déjà effectuée de(s) mouvement(s) antérieur(s)");
			
			//System.out.println("--Case-- Récupération du dernier mouvement");
			Mouvement m = listmouv.get(listmouv.getSize()-1);
			
			//System.out.println("--Case-- Ajout du mouvement monter("+d+") à la case\n");
			Mouvement mb = new MouvementHaut(m.getXarrive(),m.getYarrive(),m.tempsArrive(),d,valeur);
			listmouv.ajouterMouvement(mb);
			//System.out.println(mb.toString()+"\n");
		}
	}
	
	/**
	 * Methode descendre(int d).
	 *
	 * @param d, la durée.
	 */
	
	public void descendre(int d){
		//System.out.println("--Case-- Demande à la case de descendre de "+d);
		if(this.listmouv.getSize()==0){
			//System.out.println("--Case-- La case n'a pas déjà effectuée de mouvement antérieur");
			Mouvement m =new MouvementBas(positionX, positionY, 0, d, valeur);
			//System.out.println("--Case-- Ajout du nouveau mouvement descendre("+d+") à la liste des mouvements de cette case\n");
			listmouv.ajouterMouvement(m);
			//System.out.println(m.toString()+"\n");
		}
		else{
			//System.out.println("--Case-- La case a déjà effectuée de(s) mouvement(s) antérieur(s)");
			
			//System.out.println("--Case-- Récupération du dernier mouvement");
			Mouvement m = listmouv.get(listmouv.getSize()-1);
			
			//System.out.println("--Case-- Ajout du mouvement descendre("+d+") à la case\n");
			Mouvement mb = new MouvementBas(m.getXarrive(),m.getYarrive(),m.tempsArrive(),d, valeur);
			listmouv.ajouterMouvement(mb);
			//System.out.println(mb.toString()+"\n");
		}
	}
	
	/**
	 * Methode gauche(int d).
	 *
	 * @param d, la durée.
	 */
	
	public void gauche(int d){
		//System.out.println("--Case-- Demande à la case d'aller à gauche de "+d);
		if(this.listmouv.getSize()==0){
			//System.out.println("--Case-- La case n'a pas déjà effectuée de mouvement antérieur");
			Mouvement m = new MouvementGauche(positionX, positionY, 0, d, valeur);
			//System.out.println("--Case-- Ajout du nouveau mouvement gauche("+d+") à la liste des mouvements de cette case\n");
			listmouv.ajouterMouvement(m);
			//System.out.println(m.toString()+"\n");
		}
		else{
			//System.out.println("--Case-- La case a déjà effectuée de(s) mouvement(s) antérieur(s)");
			
			//System.out.println("--Case-- Récupération du dernier mouvement");
			Mouvement m = listmouv.get(listmouv.getSize()-1);
			
			//System.out.println("--Case-- Ajout du mouvement gauche("+d+") à la case\n");
			Mouvement mb = new MouvementGauche(m.getXarrive(),m.getYarrive(),m.tempsArrive(),d, valeur);
			listmouv.ajouterMouvement(mb);
			//System.out.println(mb.toString()+"\n");
		}
	}
	
	/**
	 * Methode droite(int d).
	 *
	 * @param d, la durée.
	 */
	
	public void droite(int d){
		//System.out.println("--Case-- Demande à la case d'aller à droite de "+d);
		if(this.listmouv.getSize()==0){
			//System.out.println("--Case-- La case n'a pas déjà effectuée de mouvement antérieur");
			Mouvement m = new MouvementDroite(positionX, positionY, 0, d, valeur);
			//System.out.println("--Case-- Ajout du nouveau mouvement droite("+d+") à la liste des mouvements de cette case\n");
			listmouv.ajouterMouvement(m);
			//System.out.println(m.toString()+"\n");
		}
		else{
			//System.out.println("--Case-- La case a déjà effectuée de(s) mouvement(s) antérieur(s)");
			
			//System.out.println("--Case-- Récupération du dernier mouvement");
			Mouvement m = listmouv.get(listmouv.getSize()-1);
			
			//System.out.println("--Case-- Ajout du mouvement droite("+d+") à la case\n");
			Mouvement mb = new MouvementDroite(m.getXarrive(),m.getYarrive(),m.tempsArrive(),d, valeur);
			listmouv.ajouterMouvement(mb);
			//System.out.println(mb.toString()+"\n");
		}
	}
	
	/**
	 * Methode rester(int d).
	 *
	 * @param d, la durée.
	 */
	
	public void rester(int d){
		//System.out.println("--Case-- Demande à la case de rester de "+d);
		if(this.listmouv.getSize()==0){
			//System.out.println("--Case-- La case n'a pas déjà effectuée de mouvement antérieur");
			Mouvement m =new MouvementRester(positionX, positionY, 0, d, valeur);
			//System.out.println("--Case-- Ajout du nouveau mouvement rester("+d+") à la liste des mouvements de cette case\n");
			listmouv.ajouterMouvement(m);
			//System.out.println(m.toString()+"\n");
		}
		else{
			//System.out.println("--Case-- La case a déjà effectuée de(s) mouvement(s) antérieur(s)");
			
			//System.out.println("--Case-- Récupération du dernier mouvement");
			Mouvement m = listmouv.get(listmouv.getSize()-1);
			
			//System.out.println("--Case-- Ajout du mouvement monter("+d+") à la case\n");
			Mouvement mb = new MouvementRester(m.getXarrive(),m.getYarrive(),m.tempsArrive(),d, valeur);
			listmouv.ajouterMouvement(mb);
			//System.out.println(mb.toString()+"\n");
		}
	}

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "--Case-- Abscisse : "+positionX+" / Ordonnée : "+positionY+" / Temps : "+temps+" / Valeur : "+valeur+"\n";
	}
	
	/**
	 * Methode mouvementAuTempsT(int temps).
	 *
	 * @param temps, le temps.
	 * @return le mouvement au temps t.
	 */
	
	public Mouvement mouvementAuTempsT(int temps){
		Mouvement m=null;
		for(int i=0;i<listmouv.getSize();i++){
			if(temps>=listmouv.get(i).getTemps()){
				m=listmouv.get(i);
			}	
		}
		return m;
	}
	
	/**
	 * Methode existeEncorePosition().
	 *
	 * @return true, s'il en existe encore
	 */
	
	public boolean existeEncorePosition(){
		return !listmouv.isEmpty();
	}
	
	/**
	 * Methode setValeur(String s).
	 *
	 * @param s the new valeur
	 */
	
	public void setValeur(String s){
		valeur = s;
	}
	
	/**
	 * Methode valeurAuTempsT(int temps).
	 *
	 * @param temps, le temps.
	 * @return la valeur au temps t.
	 */
	
	public String valeurAuTempsT(int temps) {
		Mouvement m = mouvementAuTempsT(temps);
		if(m != null){
			return m.getValeur();
		}
		else{
			return "rien";
		}
	}
}