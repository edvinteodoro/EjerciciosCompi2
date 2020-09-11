package backend.tablas;

import java_cup.runtime.Symbol;

/**
 *
 * @author teo
 */
public class Simbolo {

    TypeVar tipo;
    Symbol simbol;

    public Simbolo(TypeVar tipo, Symbol simbol) {
        this.tipo = tipo;
        this.simbol = simbol;
    }

    public TypeVar getTipo() {
        return tipo;
    }

    public void setTipo(TypeVar tipo) {
        this.tipo = tipo;
    }

    public Symbol getSimbol() {
        return simbol;
    }

    public void setSimbol(Symbol simbol) {
        this.simbol = simbol;
    }

    
}
