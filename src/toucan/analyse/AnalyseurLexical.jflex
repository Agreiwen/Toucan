package toucan.analyse ;

import java_cup.runtime.*;
      
%%
   
%class AnalyseurLexical
%public

%line
%column
    
%type Symbol
%eofval{
        return symbol(CodesLexicaux.EOF) ;
%eofval}

%cup

%state commentaire
   
%{
  private Symbol symbol(int type) {
	return new Symbol(type, yyline, yycolumn) ;
  }

  private Symbol symbol(int type, Object value) {
	return new Symbol(type, yyline, yycolumn, value) ;
  }
%}

idf = [a-z]+
typePrimitif = "int" | "String" | "char" | "double" | "float" | "boolean"
croouv = "["
crofer = "]"
cste = [0-9]+
tab = "tab"
op = "+" | "-" | "*" | "/"
parouv = "("
parfer = ")"

commentaireSlashSlash = [/][/].*
commentaireSlashEtoile = [/][*]
commentaireEtoileSlash = [*][/]

%%

<YYINITIAL>{tab}  { return symbol(CodesLexicaux.TAB, yytext()); }
<YYINITIAL>{typePrimitif}  { return symbol(CodesLexicaux.TYPEPRIMITIF, yytext()); }

<YYINITIAL>{idf}  { return symbol(CodesLexicaux.IDF, yytext()) ; }

<YYINITIAL>";"  { return symbol(CodesLexicaux.POINTVIRGULE); }

<YYINITIAL>{croouv}	{ return symbol(CodesLexicaux.CROOUV) ; }

<YYINITIAL>{crofer} { return symbol(CodesLexicaux.CROFER) ; }

<YYINITIAL>"="  { return symbol(CodesLexicaux.EGAL) ; }

<YYINITIAL>{cste}  { return symbol(CodesLexicaux.CSTE, yytext()) ; }

<YYINITIAL>{op} { return symbol(CodesLexicaux.OP, yytext()); }

<YYINITIAL>{parouv} { return symbol(CodesLexicaux.PAROUV); }

<YYINITIAL>{parfer} { return symbol(CodesLexicaux.PARFER); }

<YYINITIAL> {commentaireSlashSlash} {}

<YYINITIAL> {commentaireSlashEtoile} {yybegin(commentaire) ;}

<commentaire> {commentaireEtoileSlash} {yybegin(YYINITIAL) ;}

.                       {}
\n                      {}