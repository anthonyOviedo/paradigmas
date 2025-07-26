import java.util.*;
import java.util.stream.*;

public class ejercicio1 {
    public static void main(String[] args) {
        // Crear instancias singleton
        Esposo esposo = Esposo.getInstance("Luis", 30, "Ver feliz a Ana");
        Esposa esposa = Esposa.getInstance("Ana", 28, "Casarse con Luis");

        // Crear invitados
        Invitado[] invitados = {
                new Invitado("Carlos", 25, "Primo", true, "hombre"),
                new Invitado("Pedro", 22, "Amigo", true, "hombre"),
                new Invitado("Juan", 31, "companero", false, "hombre"),
                new Invitado("Andrés", 17, "Sobrino", true, "hombre"),
                new Invitado("María", 27, "Hermana", false, "mujer"),
                new Invitado("Juana", 24, "Amiga", false, "mujer"),
                new Invitado("Cristina", 34, "Amiga", true, "mujer")
        };

        // Crear empleados
        Empleado[] empleados = {
                new Empleado("Laura", 40, "mujer", "Chef"),
                new Empleado("Miguel", 35, "hombre", "Músico")
        };

        System.out.println(" --- los invitados se presentan --- ");
        for (Invitado i : invitados)
            i.presentarse();

        // Escena
        System.out.println("--- Evento en la fiesta ---");
        esposo.quitarLiga(esposa);

        System.out.println("\n--- Lanzamiento del buquet ---");
        esposa.lanzarBuquet(invitados);

        System.out.println("\n--- Estado de invitados ---");
        for (Invitado i : invitados) {
            System.out.println(i.nombre + ": " + i.observarEstado());
        }

        System.out.println("\n--- Estado de empleados ---");
        for (Empleado e : empleados) {
            System.out.println(e.nombre + ": " + e.observarEstado());
        }
    }
}

class Person {
    protected String nombre;
    protected int edad;
    protected String action;
    public String genero;

    public Person(String nombre, int edad, String genero) {
        this.nombre = nombre;
        this.edad = edad;
        this.action = "respirando";
        this.genero = genero;
    }

    public void set_action(String s) {
        this.action = s;
    }

    public String observarEstado() {
        return this.action;
    }
}

class Empleado extends Person {
    protected String rol;

    public Empleado(String nombre, int edad, String genero, String rol) {
        super(nombre, edad, genero);
        this.rol = rol;
        super.action = "atendiendo invitados";
    }

    @Override
    public void set_action(String s) {
        super.set_action(s);
    }

    public String observarEstado() {
        return "El empleado esta " + super.observarEstado();
    }
}

class Invitado extends Person {
    protected Boolean soltero;
    protected String parentesco;

    public Invitado(String nombre, int edad, String parentesco, Boolean soltero, String genero) {
        super(nombre, edad, genero);
        this.parentesco = parentesco;
        super.action = "Esperando en la entrada";
        this.soltero = soltero;
    }

    public String observarEstado() {
        return "El invitado esta " + this.action;
    }

    public void presentarse() {
        String ademas;
        if (soltero)
            ademas = "estoy soltero";
        else
            ademas = "estoy comprometido";

        if (genero == "mujer")
            ademas = ademas.substring(0, ademas.length() - 1) + "a";

        System.out.println(
                "hola me llamo " + nombre + " soy " + parentesco + " de los novios " + ademas + " arriba " + genero);
    }

}

class Esposa extends Person {
    private static Esposa instancia = null;
    protected String deseo;
    protected Boolean liga;
    protected Boolean buquet;

    private Esposa(String nombre, int edad, String deseo) {
        super(nombre, edad, "mujer");
        this.deseo = deseo;
        this.buquet = true;
        this.liga = true;
    }

    public static Esposa getInstance(String nombre, int edad, String deseo) {
        if (instancia == null) {
            instancia = new Esposa(nombre, edad, deseo);
        }
        return instancia;
    }

    public void bailarBalz() {
        System.out.println("Estoy balando Balz");
    }

    public void lanzarBuquet(Invitado invitados[]) {
        if (!buquet) {
            System.out.println("ya lo tiré... no hay más.");
            return;
        }

        List<Invitado> candidatos = Arrays.stream(invitados)
                .filter(i -> i.edad > 18)
                .filter(i -> i.soltero)
                .filter(i -> "hombre".equals(i.genero))
                .collect(Collectors.toList());

        if (candidatos.isEmpty()) {
            System.out.println("Ningún invitado cumple las condiciones para recibir la liga.");
        } else {

            System.out.println("Atras esperando estan...");
            for (Invitado i : candidatos)
                System.out.println(i.nombre);

            Random rand = new Random();
            Invitado elegido = candidatos.get(rand.nextInt(candidatos.size()));

            System.out.println("¡Tiré la liga y la atrapó " + elegido.nombre + "!");
        }

        this.buquet = false;
    }

    void quitarLiga() {
        this.liga = false;
    }
}

class Esposo extends Person {
    private static Esposo instancia = null;
    private String deseo;

    public static Esposo getInstance(String nombre, int edad, String deseo) {
        if (instancia == null) {
            instancia = new Esposo(nombre, edad);
        }
        return instancia;
    }

    public void quitarLiga(Esposa esposa) {
        System.out.println(nombre + " le quita la liga a " + esposa.nombre + " en la fiesta.");
        esposa.quitarLiga();
    }

    public Esposo(String nombre, int edad) {
        super(nombre, edad, "hombre");
        this.deseo = "hacer feliz a la esposa.";
    }

}