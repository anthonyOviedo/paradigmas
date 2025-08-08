package semana3;

public class ejerecicios1 {
    public int foo(){
        public int x = 777;
        return x;
    }
    
}

//respuesta del IDE Illegal modifier for parameter x; only final is permittedJava(67109220)
// El modificador final no controla visibilidad, sino mutabilidad


// Regla en Java:
// Los modificadores de acceso (public, private, protected) solo se permiten en miembros de clase, como:
// - atributos.
// - Métodos.
// - Clases internas.
// Variables locales (dentro de un método):
// - Solo pueden usar los modificadores final y var (a partir de Java 10).
// - No pueden ser public, private, ni protected, porque su visibilidad ya está limitada al bloque donde se declaran.

