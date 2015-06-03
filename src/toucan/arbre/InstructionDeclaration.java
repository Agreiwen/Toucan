package toucan.arbre;

public class InstructionDeclaration extends InstructionAffectation{


	protected String t;
	protected String i;
	public InstructionDeclaration(String t, String i) {
		super();
		this.t=t;
		this.i=i;
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getCodeDecore(){
		StringBuilder jb = new StringBuilder();
		 jb.append(t+" "+i+";\n");
		 jb.append("lc.addCase(new Case(positionX, 150, 10, \" \"));\n");
		 jb.append("this.positionX+=50;");
		 String code = jb.toString();
		 return code;
	}

}