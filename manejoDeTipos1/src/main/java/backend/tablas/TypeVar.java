/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend.tablas;

/**
 *
 * @author teo
 */

public class TypeVar {
    private String nombre;
    private int symbol;
    private TypeVar hijo;

    public TypeVar(String nombre, int symbol, TypeVar hijo) {
        this.nombre = nombre;
        this.symbol = symbol;
        this.hijo = hijo;
    }
    
    
    public Boolean isFatherOf(int symbol){
        if(this.symbol==symbol){
            return true;
        }else if(hijo!=null){
            return hijo.isFatherOf(symbol);
        }else{
            return false;
        }
    }

    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSymbol() {
        return symbol;
    }

    public void setSymbol(int symbol) {
        this.symbol = symbol;
    }

    public TypeVar getHijo() {
        return hijo;
    }
    
    

    public void setHijo(TypeVar hijo) {
        this.hijo = hijo;
    }
    
    
    
    
}
