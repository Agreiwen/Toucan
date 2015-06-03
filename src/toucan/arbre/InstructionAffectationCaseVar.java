package toucan.arbre;

public class InstructionAffectationCaseVar extends InstructionAffectation{

	protected int i;
	protected int j;
	public InstructionAffectationCaseVar(String if1, String i3) {
		super();
		this.i=0;
		this.j=Integer.parseInt(i3);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getCodeDecore() {
		String s="caseVar.executer(lc, "+i+", "+j+");\ntab["+i+"]=tab["+j+"];\n";
		return s;
	}

}
