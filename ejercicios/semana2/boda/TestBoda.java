package boda.test;

import boda.*;
import static boda.Boda.*;

import java.util.*;

public class TestBoda {
    public static void main(String[] args) {
        testAll();
    }

    static void testAll() {
        var ana = new Mujer("Ana");
        var luis = new Varon("Luis");
        var maria = new Mujer("María");
        var pedro = new Varon("Pedro");
        var refugios = new Varon("Refugios");

        registrar(pedro, refugios);
        registrar(ana, new DaDiscurso(), new FirmaComoTestigo());
        registrar(Arrays.asList(luis, maria),
                  new Pareja(), new BailaVals());

        participantes();

        atencion("Probando Evento: Casamiento", Evento.JURAMENTO);
        atencion("Probando Evento: Firma", Evento.FIRMA);
        atencion("Probando Evento: Brindis", Evento.BRINDIS);
        atencion("Probando Evento: Vals", Evento.VALS);
    }
}
