package boda;

import java.util.*;

public class Boda {
    private static List<Person> invitados = new ArrayList<>();

    public static void participantes() {
        invitados.forEach(p -> System.out.println(p.presentarse()));
    }

    public static void registrar(Person p, Role... roles) {
        for (Role r : roles) {
            p.asignarRol(r);
        }
    }

    public static void registrar(Person... personas) {
        invitados.addAll(Arrays.asList(personas));
    }

    public static void registrar(List<Person> personas, Role... roles) {
        for (Role r : roles) {
            personas.forEach(p -> p.asignarRol(r));
        }
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

    public String presentarse() {
        return "Hola mi nombre es: " + name;
    }

    public String performRole(Evento e) {
        if (hats.isEmpty()) {
            return name + (Math.random() < 0.5 ? " llora\n" : " ríe\n");
        }

        StringBuilder result = new StringBuilder();
        for (Role r : hats) {
            if (r.when == e) {
                result.append(name).append(": ").append(r.action).append("\n");
            }
        }
        return result.toString();
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
    String action;
    Evento when;

    public Role(String action) {
        this.action = action;
        this.when = null;
    }

    public void setEvent(Evento when) {
        this.when = when;
    }
}

class FirmaComoTestigo extends Role {
    public FirmaComoTestigo(String action) {
        super(action);
        setEvent(Evento.FIRMA);
    }

    public FirmaComoTestigo() {
        super("firma como testigo ");
        setEvent(Evento.FIRMA);
    }
}

class DaDiscurso extends Role {
    public DaDiscurso(String action) {
        super(action);
        setEvent(Evento.BRINDIS);
    }

    public DaDiscurso() {
        super("Da un muy bonito discurso");
        setEvent(Evento.BRINDIS);
    }
}

class Pareja extends Role {
    public Pareja(String action) {
        super(action);
        setEvent(Evento.JURAMENTO);
    }

    public Pareja() {
        super("Da el Si");
        setEvent(Evento.JURAMENTO);
    }
}

class BailaVals extends Role {
    public BailaVals(String action) {
        super(action);
        setEvent(Evento.VALS);
    }

    public BailaVals() {
        super("baila su primer Balz");
        setEvent(Evento.VALS);
    }
}

enum Evento {
    JURAMENTO,
    FIRMA,
    BRINDIS,
    VALS
}
