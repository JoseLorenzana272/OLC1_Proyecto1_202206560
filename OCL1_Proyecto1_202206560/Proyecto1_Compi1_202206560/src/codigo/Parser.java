
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package codigo;

import java_cup.runtime.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class Parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public Parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public Parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\024\000\002\002\004\000\002\002\005\000\002\005" +
    "\004\000\002\005\003\000\002\003\003\000\002\003\003" +
    "\000\002\003\003\000\002\003\003\000\002\004\007\000" +
    "\002\006\005\000\002\006\005\000\002\006\003\000\002" +
    "\006\003\000\002\006\003\000\002\006\003\000\002\007" +
    "\007\000\002\007\007\000\002\010\006\000\002\011\007" +
    "\000\002\011\007" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\061\000\004\013\004\001\002\000\016\011\020\015" +
    "\016\016\015\023\021\024\011\025\014\001\002\000\004" +
    "\002\006\001\002\000\004\002\001\001\002\000\020\011" +
    "\020\014\063\015\016\016\015\023\021\024\011\025\014" +
    "\001\002\000\020\011\ufffe\014\ufffe\015\ufffe\016\ufffe\023" +
    "\ufffe\024\ufffe\025\ufffe\001\002\000\004\027\056\001\002" +
    "\000\020\011\ufffb\014\ufffb\015\ufffb\016\ufffb\023\ufffb\024" +
    "\ufffb\025\ufffb\001\002\000\020\011\ufffa\014\ufffa\015\ufffa" +
    "\016\ufffa\023\ufffa\024\ufffa\025\ufffa\001\002\000\004\027" +
    "\052\001\002\000\004\023\046\001\002\000\004\023\042" +
    "\001\002\000\020\011\ufffc\014\ufffc\015\ufffc\016\ufffc\023" +
    "\ufffc\024\ufffc\025\ufffc\001\002\000\004\004\036\001\002" +
    "\000\004\017\023\001\002\000\020\011\ufffd\014\ufffd\015" +
    "\ufffd\016\ufffd\023\ufffd\024\ufffd\025\ufffd\001\002\000\012" +
    "\012\026\021\030\022\025\023\024\001\002\000\012\005" +
    "\ufff3\007\ufff3\010\ufff3\020\ufff3\001\002\000\012\005\ufff5" +
    "\007\ufff5\010\ufff5\020\ufff5\001\002\000\012\005\ufff6\007" +
    "\ufff6\010\ufff6\020\ufff6\001\002\000\010\007\033\010\031" +
    "\020\032\001\002\000\012\005\ufff4\007\ufff4\010\ufff4\020" +
    "\ufff4\001\002\000\012\012\026\021\030\022\025\023\024" +
    "\001\002\000\020\011\ufff0\014\ufff0\015\ufff0\016\ufff0\023" +
    "\ufff0\024\ufff0\025\ufff0\001\002\000\012\012\026\021\030" +
    "\022\025\023\024\001\002\000\012\005\ufff7\007\ufff7\010" +
    "\ufff7\020\ufff7\001\002\000\012\005\ufff8\007\033\010\ufff8" +
    "\020\ufff8\001\002\000\012\012\026\021\030\022\025\023" +
    "\024\001\002\000\010\005\040\007\033\010\031\001\002" +
    "\000\004\006\041\001\002\000\020\011\ufff9\014\ufff9\015" +
    "\ufff9\016\ufff9\023\ufff9\024\ufff9\025\ufff9\001\002\000\004" +
    "\017\043\001\002\000\012\012\026\021\030\022\025\023" +
    "\024\001\002\000\010\007\033\010\031\020\045\001\002" +
    "\000\020\011\ufff2\014\ufff2\015\ufff2\016\ufff2\023\ufff2\024" +
    "\ufff2\025\ufff2\001\002\000\004\017\047\001\002\000\004" +
    "\021\050\001\002\000\004\020\051\001\002\000\020\011" +
    "\ufff1\014\ufff1\015\ufff1\016\ufff1\023\ufff1\024\ufff1\025\ufff1" +
    "\001\002\000\004\017\053\001\002\000\004\026\054\001" +
    "\002\000\004\020\055\001\002\000\020\011\uffee\014\uffee" +
    "\015\uffee\016\uffee\023\uffee\024\uffee\025\uffee\001\002\000" +
    "\004\017\057\001\002\000\004\026\060\001\002\000\004" +
    "\020\061\001\002\000\020\011\uffef\014\uffef\015\uffef\016" +
    "\uffef\023\uffef\024\uffef\025\uffef\001\002\000\020\011\uffff" +
    "\014\uffff\015\uffff\016\uffff\023\uffff\024\uffff\025\uffff\001" +
    "\002\000\004\002\000\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\061\000\004\002\004\001\001\000\016\003\007\004" +
    "\021\005\006\007\016\010\011\011\012\001\001\000\002" +
    "\001\001\000\002\001\001\000\014\003\061\004\021\007" +
    "\016\010\011\011\012\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\006\026\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\006\034\001\001\000\002\001\001\000\004\006\033" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\006" +
    "\036\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\004\006\043\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    public static String resultado = ""; 

    public void syntax_error(Symbol s)
    {
            System.err.println("Error Sintactico: "+ s.value + " - Fila: " + s.right + " - Columna: " + s.left + ". Recuperado" );
    }

    public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception
    {
            System.err.println("Error Sintactico: "+ s.value + " - Fila: " + s.right + " - Columna: " + s.left + ". Sin recuperacion." );
    }



/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$Parser$actions {

  
  private final Parser parser;

  /** Constructor */
  CUP$Parser$actions(Parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action_part00000000(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Parser$result;

      /* select the action based on the action number */
      switch (CUP$Parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= inicio EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		RESULT = start_val;
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Parser$parser.done_parsing();
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // inicio ::= R_PROGRAM lista_instr R_ENDPROGRAM 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("inicio",0, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // lista_instr ::= lista_instr instruccion 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("lista_instr",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // lista_instr ::= instruccion 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("lista_instr",3, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // instruccion ::= mostrar 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("instruccion",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // instruccion ::= declaracion 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("instruccion",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // instruccion ::= asignacion 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("instruccion",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // instruccion ::= declaracion_arreglo 
            {
              Object RESULT =null;

              CUP$Parser$result = parser.getSymbolFactory().newSymbol("instruccion",1, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // mostrar ::= R_MOSTRAR PARENTESIS_A expresion PARENTESIS_C PUNTOYCOMA 
            {
              Object RESULT =null;
		int valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Object val = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		 codigo.Parser.resultado = codigo.Parser.resultado + func.Funcion.mostrar(val.toString()); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("mostrar",2, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // expresion ::= expresion MAS expresion 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object b = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = (Double)a + (Double)b; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // expresion ::= expresion POR expresion 
            {
              Object RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)).right;
		Object a = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		Object b = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = (Double)a * (Double)b; 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-2)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // expresion ::= ENTERO 
            {
              Object RESULT =null;
		int valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String val = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = Double.parseDouble(val.toString()); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // expresion ::= DECIMAL 
            {
              Object RESULT =null;
		int valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String val = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = Double.parseDouble(val.toString()); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // expresion ::= CADENA 
            {
              Object RESULT =null;
		int valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String val = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = val.toString(); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // expresion ::= IDENTIFICADOR 
            {
              Object RESULT =null;
		int valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).left;
		int valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()).right;
		String val = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.peek()).value;
		 RESULT = func.Funcion.obtenerValor(val.toString()); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("expresion",4, ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // declaracion ::= R_VAR_DOUBLE IDENTIFICADOR ASIGNACION expresion FIN_DECLARACION 
            {
              Object RESULT =null;
		int valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object val = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 codigo.Parser.resultado = codigo.Parser.resultado + func.Funcion.declararDouble(val.toString()); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("declaracion",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // declaracion ::= R_VAR_CHAR IDENTIFICADOR ASIGNACION CADENA FIN_DECLARACION 
            {
              Object RESULT =null;
		int valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String val = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 codigo.Parser.resultado = codigo.Parser.resultado + func.Funcion.declararCadena(val.toString()); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("declaracion",5, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // asignacion ::= IDENTIFICADOR ASIGNACION expresion FIN_DECLARACION 
            {
              Object RESULT =null;
		int nombreVariableleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).left;
		int nombreVariableright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)).right;
		String nombreVariable = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-3)).value;
		int valorleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int valorright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		Object valor = (Object)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 codigo.Parser.resultado = codigo.Parser.resultado + func.Funcion.asignarValor(nombreVariable.toString(), valor.toString()); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("asignacion",6, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-3)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // declaracion_arreglo ::= R_ARR_DOUBLE IDENTIFICADOR_ARREGLO ASIGNACION LISTA_VALORES FIN_DECLARACION 
            {
              Object RESULT =null;
		int valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String val = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 codigo.Parser.resultado = codigo.Parser.resultado + func.Funcion.declararArregloDouble(val.toString()); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("declaracion_arreglo",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // declaracion_arreglo ::= R_ARR_CHAR IDENTIFICADOR_ARREGLO ASIGNACION LISTA_VALORES FIN_DECLARACION 
            {
              Object RESULT =null;
		int valleft = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).left;
		int valright = ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-1)).right;
		String val = (String)((java_cup.runtime.Symbol) CUP$Parser$stack.elementAt(CUP$Parser$top-1)).value;
		 codigo.Parser.resultado = codigo.Parser.resultado + func.Funcion.declararArregloChar(val.toString()); 
              CUP$Parser$result = parser.getSymbolFactory().newSymbol("declaracion_arreglo",7, ((java_cup.runtime.Symbol)CUP$Parser$stack.elementAt(CUP$Parser$top-4)), ((java_cup.runtime.Symbol)CUP$Parser$stack.peek()), RESULT);
            }
          return CUP$Parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$Parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$Parser$do_action(
    int                        CUP$Parser$act_num,
    java_cup.runtime.lr_parser CUP$Parser$parser,
    java.util.Stack            CUP$Parser$stack,
    int                        CUP$Parser$top)
    throws java.lang.Exception
    {
              return CUP$Parser$do_action_part00000000(
                               CUP$Parser$act_num,
                               CUP$Parser$parser,
                               CUP$Parser$stack,
                               CUP$Parser$top);
    }
}

}
