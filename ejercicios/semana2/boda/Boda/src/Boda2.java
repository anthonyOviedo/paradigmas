// EIF400-II-2025 Quiz 1 31-julio Boda HORARIO: [Coloca tu horario aquí]
// Autores: [Tu nombre completo y cédula aquí]
/*

C:\Users\j11ga\OneDrive\Desktop\QuizBoda\src>javac boda/Boda.java
C:\Users\j11ga\OneDrive\Desktop\QuizBoda\src>java boda.Boda

*/
package boda.model;

import java.util.*;

public class Boda {

    public enum Evento { JURAMENTO, BRINDIS, VALS, FIRMA }

    public static List<Persona> invitados = new ArrayList<>();

    // Métodos de registro
    public void registrar(Persona p) {
        invitados.add(p);
    }

    public static void registrar(Persona... personas) {
        invitados.addAll(Arrays.asList(personas));
    }

    public static void registrar(Persona p, Rol... roles) {
        for (Rol r : roles) {
            p.agregarRol(r);
        }
        if (!invitados.contains(p)) {
            invitados.add(p);
        }
    }

    public static void registrar(List<Persona> personas, Rol... roles) {
        for (Persona p : personas) {
            for (Rol r : roles) {
                p.agregarRol(r);
            }
            if (!invitados.contains(p)) {
                invitados.add(p);
            }
        }
    }

    public static void participantes() {
        for (Persona p : invitados) {
            System.out.print(p + " roles: ");
            if (p.roles.isEmpty()) {
                System.out.println("None");
            } else {
                for (Rol r : p.roles) {
                    System.out.print(r + " ");
                }
                System.out.println();
            }
        }
    }

    public static void atencion(String atencion, Evento evento) {
        System.out.println(atencion + evento + "\n");
        for (Persona p : invitados) {
            p.reaccionar(evento);
        }
    }

    // Clase abstracta Persona
    public static abstract class Persona {
        protected String nombre;
        protected List<Rol> roles = new ArrayList<>();
        private Random rand = new Random();

        public Persona(String nombre) {
            this.nombre = nombre;
        }

        public void agregarRol(Rol r) {
            roles.add(r);
        }

        public void reaccionar(Evento evento) {
            boolean reacciono = false;
            for (Rol r : roles) {
                if (r.reacciona(evento, this)) {
                    reacciono = true;
                }
            }
            if (!reacciono && roles.isEmpty()) {
                if (rand.nextBoolean()) {
                    System.out.println(nombre + " se ríe");
                } else {
                    System.out.println(nombre + " llora");
                }
            }
        }

        public String toString() {
            return nombre;
        }
    }

    // Subclases Mujer y Varon
    public static class Mujer extends Persona {
        public Mujer(String nombre) {
            super(nombre);
        }
    }

    public static class Varon extends Persona {
        public Varon(String nombre) {
            super(nombre);
        }
    }

    // Interface Rol
    public interface Rol {
        boolean reacciona(Evento evento, Persona p);
    }

    // Roles
    public static class Pareja implements Rol {
        public boolean reacciona(Evento evento, Persona p) {
            if (evento == Evento.JURAMENTO) {
                System.out.println(p + " dice Sí, acepto");
                return true;
            }
            return false;
        }
        public String toString() { return "Pareja"; }
    }

    public static class DaDiscurso implements Rol {
        public boolean reacciona(Evento evento, Persona p) {
            if (evento == Evento.BRINDIS) {
                System.out.println(p + " da un discurso emotivo");
                return true;
            }
            return false;
        }
        public String toString() { return "DaDiscurso"; }
    }

    public static class BailaVals implements Rol {
        public boolean reacciona(Evento evento, Persona p) {
            if (evento == Evento.VALS) {
                System.out.println(p + " baila un vals");
                return true;
            }
            return false;
        }
        public String toString() { return "BailaVals"; }
    }

    public static class FirmaComoTestigo implements Rol {
        public boolean reacciona(Evento evento, Persona p) {
            if (evento == Evento.FIRMA) {
                System.out.println(p + " firma como testigo");
                return true;
            }
            return false;
        }
        public String toString() { return "FirmaComoTestigo"; }
    }
}