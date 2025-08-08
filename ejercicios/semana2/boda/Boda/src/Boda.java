//Antony Oviedo alfaro Grupo 10am 

package boda.model;

import java.util.*;

public class Boda {
    private static List<Persona> invitados = new ArrayList<>();

    public static void participantes() {
        System.err.println("*** Casting ***");
        invitados.forEach(p -> System.out.println(p.presentarse()));
    }

    public static void registrar(Persona... personas) {
        invitados.addAll(Arrays.asList(personas));
    }

    public static void registrar(Persona p, Rol... roles) {
        invitados.add(p);
        p.asignarRols(roles);
    }

    public static void registrar(List<Persona> personas, Rol... roles) {
        for (Rol r : roles) {
            personas.forEach(p -> p.asignarRol(r));
        }
        invitados.addAll(personas);
    }

    public static void atencion(String anuncio, Evento e) {
        System.err.println("\n***" + anuncio + "***");
        for (Persona p : invitados) {
            System.out.print(p.performRol(e));
        }
    }

    public static class Persona {
        private List<Rol> hats = new ArrayList<>();
        protected String name;

        public Persona(String name) {
            this.name = name;
        }

        public void asignarRol(Rol role) {
            hats.add(role);
        }

        public void asignarRols(Rol... roles) {
            hats.addAll(Arrays.asList(roles));
        }

        public String presentarse() {
            String result = "";
            result += name + ":\n";
            if (hats.isEmpty())
                    result += "\t" + ".sin Rol"; 
            else 
                for (Rol r : hats)
                    result += "\t"+".como "+r.getName()+"\n"; 

            return result;
        }

        public String performRol(Evento e){
            String result = "";
            if (hats.isEmpty())
                return name + (Math.random() < 0.5 ? " llora\n" : " ríe\n");

            else  {
                for (Rol h : hats){
                    if (h.when == e)
                        result = name + " " +result+h.action+"\n";
                }
            }    
            return result;
        }

    }

    public static class Mujer extends Persona {
        public Mujer(String name) {
            super(name);
        }
    }

    public static class Varon extends Persona {
        public Varon(String name) {
            super(name);
        }
    }

    public static class Rol {
        String name;
        String action;
        Evento when;

        public Rol(String action,String name,Evento e) {
            this.name = name;
            this.action = action;
            this.when = e;
        }
        public String getName(){return this.name;}

    }

    public static class FirmaComoTestigo extends Rol {
        public FirmaComoTestigo() {
            super("firma como testigo ","Testificante",Evento.FIRMA);
        }
    }

    public static class DaDiscurso extends Rol {
        public DaDiscurso(String action) {
            super(action, "Discursante",Evento.BRINDIS);
        }

        public DaDiscurso() {
            super("Da un muy bonito discurso","Discursante",Evento.BRINDIS);
        }
    }

    public static class Pareja extends Rol {
        public Pareja() {
            super("Da el Si","Pareja",Evento.JURAMENTO);
        }
    }

    public static class BailaVals extends Rol {

        public BailaVals(String action) {
            super(action,"Bailante",Evento.VALS);
        }

        public BailaVals() {
            super("baila su primer Balz","Bailante",Evento.VALS);
        }
    }

    public enum Evento {
        JURAMENTO,
        FIRMA,
        BRINDIS,
        VALS
    }

}