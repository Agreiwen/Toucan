package toucan.outils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;

import toucan.exceptions.ExecutionException;
import toucan.modele.LesCases;
import toucan.modele.algo.IAlgo;
import toucan.modele.animation.IAnimation;


public class KitJava {
	
	private static String laClasse;
	protected int[] tab;
	protected LesCases lc;
	protected static String nomClasse = "AlgoPerso" ;
	protected static String nomPackage = "toucan.outils" ;
	protected JavaCompiler compiler ;
	protected ClassFileManager fileManager ;
		
	private static KitJava instance = new KitJava() ;
	
	
	
	private KitJava(){
		 compiler = ToolProvider.getSystemJavaCompiler();
	     fileManager = new ClassFileManager(compiler.getStandardFileManager(null, null, null));
	}
	
	/**
	* Retourne l’instance unique de cette classe (Singleton).
	* @return l’unique instance de la classe.
	*/
	public static KitJava getInstance() {
	return instance ;
	}
	
	public static void construireCode(String s){
		StringBuilder sb = new StringBuilder();
		sb.append("package toucan.outils;\n\n");
		sb.append("import toucan.modele.Case;\n");
		sb.append("import toucan.modele.LesCases;\n");
		sb.append("import toucan.modele.algo.IAlgo;");
		sb.append("import toucan.modele.animation.AffectationCaseCase;\n");
		sb.append("import toucan.modele.animation.AffectationCaseVar;\n");
		sb.append("import toucan.modele.animation.AffectationVarCase;\n");
		sb.append("import toucan.modele.animation.ComparaisonCaseCase;\n");
		sb.append("import toucan.modele.animation.AffectationExpressionVar;\n");
		sb.append("import toucan.modele.animation.IAnimation;\n\n");
		sb.append("public class AlgoPerso implements IAlgo{\n");
		sb.append("protected LesCases lc;\n");
		sb.append("protected int nbCases;\n");
		sb.append("protected int[] tab;\n");
		sb.append("protected IAnimation caseCase;\n");
		sb.append("protected IAnimation caseVar;\n");
		sb.append("protected IAnimation varCase;\n");
		sb.append("protected IAnimation compCaseCase;\n");
		sb.append("protected IAnimation expressionVar;\n");
		sb.append("protected int positionX=100;\n");
		sb.append("protected int x;\n\n");
		sb.append("public AlgoPerso(){\n");;
		sb.append("}\n\n");
		sb.append("public void trier() {\n");
		sb.append("this.caseCase = new AffectationCaseCase();\n");
		sb.append("this.expressionVar = new AffectationExpressionVar();\n");
		sb.append("this.caseVar = new AffectationCaseVar();\n");
		sb.append("this.varCase = new AffectationVarCase();\n");
		sb.append("this.compCaseCase = new ComparaisonCaseCase();\n");
		sb.append(s+"\n");
		sb.append("}\n");
		sb.append("public void setX(int i) {\n");
		sb.append("x = i ;\n");
		sb.append("}\n");
		sb.append("public void setTab(int[] tab)\n{");
		sb.append("this.tab=tab;\n");
		sb.append("}\n");
		sb.append("public void setNbCases(int i)\n{");
		sb.append("this.nbCases=i;\n");
		sb.append("}\n");
		sb.append("public int getX() {\n");
		sb.append(" return x ;\n");
		sb.append("}\n");
		sb.append("public void setLesCases(LesCases lc){\n");
		sb.append("this.lc=lc;\n");
		sb.append("}\n");
		sb.append("}\n");
		laClasse=sb.toString();
	}
	
   
	public void compiler() {
        // writer pour ecrire les erreurs de compilation
        StringWriter sortieErreur = new StringWriter();

        Iterable<? extends JavaFileObject> fileObjects = getJavaSourceFromString(nomClasse, laClasse);

        compiler.getTask(sortieErreur, fileManager, null, null, null, fileObjects).call();
        try {
            sortieErreur.close() ;
        } catch (IOException ex) {
            Logger.getLogger(TestOutils.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //System.out.println("compilation du code : ");
        System.out.println(laClasse);
        /*System.out.println("-------------------------------------");
        System.out.println("sortie d'erreur de la compilation : ") ;
        System.out.println(sortieErreur);
        System.out.println("-------------------------------------");
        */
    }

    private Iterable<JavaSource> getJavaSourceFromString(String fileName, String code) {
	return Collections.singletonList(new JavaSource(fileName, code));
    }
    
    public void executer() throws ExecutionException{
        try {
            String nomExecutable = nomPackage + "." + nomClasse ;
           //System.out.println("nom executable : " + nomExecutable);
            
            Object instance = fileManager.getClassLoader(javax.tools.StandardLocation.CLASS_PATH).loadClass("toucan.outils.AlgoPerso").newInstance();
            int res = ((IAlgo)instance).getX() ;
            ((IAlgo)instance).setLesCases(lc);
            ((IAlgo)instance).setTab(tab);
            ((IAlgo)instance).setNbCases(tab.length-1);
            try {
				((IAlgo)instance).trier();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				throw new ExecutionException();
			}
            
            //System.out.println("Resultat de l'execution : ");
            //System.out.println(res);
            //System.out.println("-------------------------------------");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestOutils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TestOutils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TestOutils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
	
	public String getLaClasse(){
		return laClasse.toString();
	}
	
	public void setTab(int[] tab){
		this.tab=tab;
	}
	
	public void setListe(LesCases lc){
		this.lc=lc;
	}
	
	public static void main(String[] args) {
		
    }
}
