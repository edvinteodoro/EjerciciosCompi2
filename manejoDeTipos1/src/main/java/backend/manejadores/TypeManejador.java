package backend.manejadores;

import backend.tablas.TypeVar;

/**
 *
 * @author teo
 */
public class TypeManejador {
    
    //2.2+2 -> Double
    //Integer val=2+2*"abc";
    //        val=4*"abc"    
    public TypeVar getType(TypeVar type1,TypeVar type2){
        if(type1.isFatherOf(type2.getSymbol())){
            return type1;
        }else if(type2.isFatherOf(type1.getSymbol())){ 
            return type2;
        }else{ //No compatibles
            return null;
        } 
    }
}
