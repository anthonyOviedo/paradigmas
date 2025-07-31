package boda;

import java.util.*;

public class Boda {
    private static List<Person> invitados = new ArrayList<>();

    public static void participantes() {
        System.err.println("*** Casting ***");
        invitados.forEach(p -> System.out.println(p.presentarse()));
    }

    public static void registrar(Person... personas) {
        invitados.addAll(Arrays.asList(personas));
    }

    public static void registrar(Person p, Role... roles) {
        invitados.add(p);
        p.asignarRoles(roles);
    }

    public static void registrar(List<Person> personas, Role... roles) {
        for (Role r : roles) {
            personas.forEach(p -> p.asignarRol(r));
        }
        invitados.addAll(personas);
    }

    public static void atencion(String anuncio, Evento e) {
        System.err.println("***" + anuncio + "***");
        for (Person p : invitados) {
            System.out.print(p.performRole(e));
        }
    }
}

class Person {
    private List<Role> hats = new ArrayList<>();
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public void asignarRol(Role role) {
        hats.add(role);
    }

    public void asignarRoles(Role... roles) {
        hats.addAll(Arrays.asList(roles));
    }

    public String presentarse() {
        String result = "";
        result += name + ":\n";
        if (hats.isEmpty())
            	result += "\t" + ".sin Rol"; 
        else 
            for (Role r : hats)
                result += "\t"+".como "+r.getName()+"\n"; 

        return result;
    }

    public String performRole(Evento e){
        String result = "";
        if (hats.isEmpty())
            return name + (Math.random() < 0.5 ? " llora\n" : " ríe\n");

        else  {
            for (Role h : hats){
                if (h.when == e)
                    result = name + " " +result+h.action+"\n";
            }
        }    
        return result;
    }

}

class Mujer extends Person {
    public Mujer(String name) {
        super(name);
    }
}

class Varon extends Person {
    public Varon(String name) {
        super(name);
    }
}

class Role {
    String name;
    String action;
    Evento when;

    public Role(String action,String name,Evento e) {
        this.name = name;
        this.action = action;
        this.when = e;
    }
    
    public String getName(){return this.name;}

}

class FirmaComoTestigo extends Role {
    public FirmaComoTestigo() {
        super("firma como testigo ","Testificante",Evento.FIRMA);
    }
}

class DaDiscurso extends Role {
    public DaDiscurso(String action) {
        super(action, "Discursante",Evento.BRINDIS);
    }

    public DaDiscurso() {
        super("Da un muy bonito discurso","Discursante",Evento.BRINDIS);
    }
}

class Pareja extends Role {
    public Pareja() {
        super("Da el Si","Pareja",Evento.JURAMENTO);
    }
}

class BailaVals extends Role {

    public BailaVals(String action) {
        super(action,"Bailante",Evento.VALS);
    }

    public BailaVals() {
        super("baila su primer Balz","Bailante",Evento.VALS);
    }
}

enum Evento {
    JURAMENTO,
    FIRMA,
    BRINDIS,
    VALS
}
