package toucan.arbre;

public class InstructionAffectationCaseCase extends InstructionAffectation{

	protected int i;
	protected int j;
	public InstructionAffectationCaseCase(String i1, String i2) {
		super();
		this.i=Integer.parseInt(i1);
		this.j=Integer.parseInt(i2);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getCodeDecore() {
		String s="caseCase.executer(lc, "+i+", "+j+");\ntab["+i+"]=tab["+j+"];\n";
		return s;
	}

}
