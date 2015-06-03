package toucan.arbre;

import java.util.ArrayList;

public class BlocDInstructions extends ArbreAbstrait{

	protected ArrayList<ArbreAbstrait> list;
	
	public BlocDInstructions(){
		super();
		this.list = new ArrayList<ArbreAbstrait>();
	}
	
	@Override
	public String getCodeDecore() {
		String var = "";
		for(int i = 0;i<list.size();i++){
			var += list.get(i).getCodeDecore();
		}
		return var;
	}
	
	public void ajouter(ArbreAbstrait a){
		list.add(a);
	}

	public static void main(String[] args){
		
	}
}
