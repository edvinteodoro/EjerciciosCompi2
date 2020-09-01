package backend.analyzers;
import java_cup.runtime.Symbol;
%%//Separador de area

%class AnalizadorLexico
%cup
%cupdebug
%line
%column

/*Identifiers*/
Numero = [0123456789]
Letra=[a-zA-Z]
WHITE_SPACE_CHAR=[\ \n\r\t\f]

%{
    private Symbol symbol(int type) {
        return new Symbol(type, yyline+1, yycolumn+1);
    }
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline+1, yycolumn+1, value);
    }

%}
%%//Separdar de area

<YYINITIAL> {
        ({Numero})+(".")({Numero})+                {return symbol(sym.DOUBLEVAL,Double.parseDouble(yytext()));}
	({Numero})+                                {return symbol(sym.INTEGERVAL,Integer.parseInt(yytext()));}
        "VAR"                             {return symbol(sym.VAR);}
        "BEGIN"                             {return symbol(sym.VAR);}
        "END"                             {return symbol(sym.VAR);}
        "Integer"                             {return symbol(sym.INTEGER);}
        "Short"                             {return symbol(sym.SHORT);}
        "Boolean"                             {return symbol(sym.BOOLEAN);}
        "String"                             {return symbol(sym.STRING);}
        "Double"                             {return symbol(sym.DOUBLE);}
        ":"                             {return symbol(sym.DPUNTO);}
        ";"                             {return symbol(sym.PUNTOYCOMA);}
        "="                             {return symbol(sym.IGUAL);}
        ","                             {return symbol(sym.COMA);}
        "+"                             {return symbol(sym.MAS);}
	"-"                                {return symbol(sym.MENOS);}
        "*"                             {return symbol(sym.POR);}
        "/"                                {return symbol(sym.DIV);}
        "("                             {return symbol(sym.PARA);}
        ")"                             {return symbol(sym.PARC);}
        ({Letra}|"_")({Letra}|"_"|{Numero})*                    {return new Symbol(sym.ID,new String(yytext()));}
        (\")({Letra}|"_")({Letra}|"_"|{Numero})*(\")            {return symbol(sym.STRINGVAL,new String(yytext()));}
        {WHITE_SPACE_CHAR}               {}//ignoramos
        .               {System.out.println("Error Lexico: "+yytext());}  
}