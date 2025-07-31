// Nat.java (Interfaz común para los números naturales)
public interface Nat {
    Nat succ(); // sucesor
    boolean isZero(); // para distinguir Zero de Succ
    Nat add(Nat other); // suma recursiva
    int toInt(); // conversión a int
    String toString(); // representación decimal
}
