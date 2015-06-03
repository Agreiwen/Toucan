package toucan.arbre;

public class InstructionAffectationExpressionVar extends InstructionAffectation{
	
	protected int exp;
	protected int var;
	public InstructionAffectationExpressionVar(String exp, String var) {
		super();
		this.exp=Integer.parseInt(exp);
		this.var=Integer.parseInt(var);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getCodeDecore() {
		String s="expressionVar.executer(lc, "+exp+", "+var+");\n";
		return s;
	}
	
}
