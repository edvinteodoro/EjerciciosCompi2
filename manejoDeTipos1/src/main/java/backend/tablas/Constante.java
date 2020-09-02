package backend.tablas;

import backend.analyzers.sym;

/**
 *
 * @author teo
 */
public class Constante {

    public static TypeVar shortVar = new TypeVar("Short", sym.SHORT, null);
    public static TypeVar intVar = new TypeVar("Integer", sym.INTEGER, shortVar);
    public static TypeVar doubleVar = new TypeVar("Double", sym.DOUBLE, intVar);
    public static TypeVar stringVar = new TypeVar("String", sym.STRING, null);
    public static TypeVar boolenaVar = new TypeVar("Boolean", sym.BOOLEAN, null);
}
