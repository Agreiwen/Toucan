package toucan.arbre;

public class InstructionAffectationVarCase extends InstructionAffectation{

	protected int i;
	protected int j;
	public InstructionAffectationVarCase(int i, int j) {
		super();
		this.i=i;
		this.j=0;
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getCodeDecore() {
		String s="varCase.executer(lc, "+i+", "+j+");\ntab["+i+"]=tab["+j+"];\n";
		return s;
	}

}
