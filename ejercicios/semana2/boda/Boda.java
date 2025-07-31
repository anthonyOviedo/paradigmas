package boda;

import java.util.*;

class Boda {
    private static List<Person> invitados = new ArrayList<>();

    public static void participantes() {
        invitados.forEach( x -> x.presentarse());
    }

    public static void registrar(Person p, Role... roles) {
        for (Role r : roles) {
            p.asignarRol(r);
        }
    } 

    public static void registrar(Person... persons) {
            invitados.addAll(Arrays.asList(persons));
    } 

    public static void registrar(List<Person> invitados,Role... roles){
        for (Role r : roles )
            invitados.forEach(x->x.asignarRol(r));
    }

    public static void atencion(String anuncio,Evento e){
        System.err.println("***"+ anuncio+"***");
        for (Person p : invitados)
            p.performRole(e);
    }
}

class Person {
    private static List<Role> hats = new ArrayList<>();
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public String performRole(Evento e){
        String result = "";
        if (hats.isEmpty())
            return "No tiene asignado ningun role";
        else  {
            for (Role h : hats){
                if (h.when == e)
                    result = result+h.action+"\n";
            }
        }    
        return result;
    }
    
    public void asignarRol(Role role){
        hats.add(role);
    }

    public String presentarse(){
        return "Hola mi nombre es: " + name ; 
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
    public Role (String action){
        this.action = action;
        this.when = null;
    }
    public void setEvent(Evento when){
        this.when = when ;
    }
}

class FirmaComoTestigo extends Role{

    public FirmaComoTestigo (String action){
        super(action);
        this.setEvent(Evento.FIRMA);
    }
    
    public FirmaComoTestigo(){
        super("firma como testigo ");
        this.setEvent(Evento.FIRMA);
    }
}

class DaDiscurso extends Role {
    public DaDiscurso(String action){
        super(action);
        this.setEvent(Evento.BRINDIS);
    }
    public DaDiscurso(){
        super("Da un muy bonito discurso");
        this.setEvent(Evento.BRINDIS);
    }
}

class Pareja extends Role{
    public Pareja(){
        super("Da el Si");
        this.setEvent(Evento.JURAMENTO);
    }

    public Pareja(String action){
        super(action);
        this.setEvent(Evento.JURAMENTO);
    }
}

class BailaVals extends Role{
    public BailaVals(String action){
        super(action);
        this.setEvent(Evento.VALS);
    }
    public BailaVals(){
        super("baila su primer Balz");
        this.setEvent(Evento.VALS);
    }
}

enum Evento {
    JURAMENTO(),
    FIRMA(),
    BRINDIS(),
    VALS();
}
