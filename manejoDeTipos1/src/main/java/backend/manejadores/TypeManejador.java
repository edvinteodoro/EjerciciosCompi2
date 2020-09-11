package backend.manejadores;

import backend.tablas.Simbolo;
import backend.tablas.TypeVar;
import java_cup.runtime.Symbol;

/**
 *
 * @author teo
 */
public class TypeManejador {

    //2.2+2 -> Double
    //Integer val=2+2*"abc";
    //        val=4*"abc"    
    public TypeVar getType(TypeVar type1, TypeVar type2) {
        if (type1.isFatherOf(type2.getSymbol())) {
            return type1;
        } else if (type2.isFatherOf(type1.getSymbol())) {
            return type2;
        } else { //No compatibles   String - double  -> doube
            return null;
        }
    }

    public Simbolo operar(Simbolo simbolo1, String op, Simbolo simbolo2) { //2+2 =
        TypeVar typeResult = this.getType(simbolo1.getTipo(), simbolo2.getTipo());
        Simbolo resultado = null;
        if (typeResult != null) {
            resultado = new Simbolo(typeResult, new Symbol(typeResult.getSymbol(), simbolo1.getSimbol().left, simbolo2.getSimbol().right));
            Double operacion;
            switch (op) {
                case "+":
                    operacion = Double.parseDouble(simbolo1.getSimbol().value.toString()) + Double.parseDouble(simbolo2.getSimbol().value.toString());
                    resultado.getSimbol().value = operacion;
                    break;
                case "-":
                    operacion = Double.parseDouble(simbolo1.getSimbol().value.toString()) - Double.parseDouble(simbolo2.getSimbol().value.toString());
                    resultado.getSimbol().value = operacion;
                    break;
                case "*":
                    operacion = Double.parseDouble(simbolo1.getSimbol().value.toString()) * Double.parseDouble(simbolo2.getSimbol().value.toString());
                    resultado.getSimbol().value = operacion;
                    break;
                case "/":
                    operacion = Double.parseDouble(simbolo1.getSimbol().value.toString()) / Double.parseDouble(simbolo2.getSimbol().value.toString());
                    resultado.getSimbol().value = operacion;
                    break;
                default:
                    throw new AssertionError();
            }
        }

        return resultado;
    }
    
    public TypeVar agregarVariable(String id, Simbolo simbolo,TypeVar tipo) { //3.5-Double, Integer
        if (simbolo != null&&tipo.isFatherOf(simbolo.getTipo().getSymbol())){ 
            System.out.println("Agregar a: " + id + " valor: " + simbolo.getSimbol().value.toString() + "tipo: " + simbolo.getTipo().getNombre());
        }else{
            System.out.println("Error al agregar variable: "+id);
        }
        return tipo;
    }
    
    public TypeVar agregarVariable(String id,TypeVar tipo){
        System.out.println("se crea variable: "+id);
        return tipo;
    }
}
