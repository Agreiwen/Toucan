package toucan.modele.algo;

import toucan.modele.Case;
import toucan.modele.LesCases;
import toucan.modele.algo.IAlgo;import toucan.modele.animation.AffectationCaseCase;
import toucan.modele.animation.AffectationCaseVar;
import toucan.modele.animation.AffectationVarCase;
import toucan.modele.animation.ComparaisonCaseCase;
import toucan.modele.animation.AffectationExpressionVar;
import toucan.modele.animation.IAnimation;

public class AlgoPerso implements IAlgo{
protected LesCases lc;
protected int nbCases;
protected int[] tab;
protected IAnimation caseCase;
protected IAnimation caseVar;
protected IAnimation varCase;
protected IAnimation compCaseCase;
protected IAnimation expressionVar;
protected int positionX=100;
protected int x;

public AlgoPerso(){
}

public void trier() {
this.caseCase = new AffectationCaseCase();
this.expressionVar = new AffectationExpressionVar();
this.caseVar = new AffectationCaseVar();
this.varCase = new AffectationVarCase();
this.compCaseCase = new ComparaisonCaseCase();
int i;
lc.addCase(new Case(positionX, 150, 10, " "));
this.positionX+=50;
}
public void setX(int i) {
x = i ;
}
public void setTab(int[] tab)
{this.tab=tab;
}
public void setNbCases(int i)
{this.nbCases=i;
}
public int getX() {
 return x ;
}
public void setLesCases(LesCases lc){
this.lc=lc;
}
}
