package pruebas;

import modelo.Equipo;
import modelo.Torneo;
import java.util.*;

public class TorneoTest {
    
    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println("     pruebas unitarias del sistema       ");
        System.out.println("==========================================");
        
        int pasaron = 0;
        int total = 0;
        
        // prueba 1: crear torneo cuartos
        total++;
        try {
            java.util.List<String> equipos = java.util.Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H");
            Torneo t = new Torneo("copa", "cuartos", equipos);
            t.generarLlaves();
            if (t.getPartidos().size() == 4) {
                System.out.println("  [ok] prueba 1: torneo cuartos genera 4 partidos");
                pasaron++;
            } else {
                System.out.println("  [fallo] prueba 1: se esperaban 4 partidos");
            }
        } catch (Exception e) {
            System.out.println("  [fallo] prueba 1: " + e.getMessage());
        }
        
        // prueba 2: torneo semifinales
        total++;
        try {
            java.util.List<String> equipos = java.util.Arrays.asList("A", "B", "C", "D");
            Torneo t = new Torneo("copa", "semifinales", equipos);
            t.generarLlaves();
            if (t.getPartidos().size() == 2) {
                System.out.println("  [ok] prueba 2: torneo semifinales genera 2 partidos");
                pasaron++;
            } else {
                System.out.println("  [fallo] prueba 2: se esperaban 2 partidos");
            }
        } catch (Exception e) {
            System.out.println("  [fallo] prueba 2: " + e.getMessage());
        }
        
        // prueba 3: torneo final
        total++;
        try {
            java.util.List<String> equipos = java.util.Arrays.asList("FinalistaA", "FinalistaB");
            Torneo t = new Torneo("copa", "final", equipos);
            t.generarLlaves();
            if (t.getPartidos().size() == 1) {
                System.out.println("  [ok] prueba 3: torneo final genera 1 partido");
                pasaron++;
            } else {
                System.out.println("  [fallo] prueba 3: se esperaba 1 partido");
            }
        } catch (Exception e) {
            System.out.println("  [fallo] prueba 3: " + e.getMessage());
        }
        
        // prueba 4: equipo nombre vacio
        total++;
        try {
            new Equipo("");
            System.out.println("  [fallo] prueba 4: equipo vacio debio lanzar excepcion");
        } catch (IllegalArgumentException e) {
            System.out.println("  [ok] prueba 4: equipo vacio lanza excepcion");
            pasaran++;
        } catch (Exception e) {
            System.out.println("  [fallo] prueba 4: " + e.getMessage());
        }
        
        // prueba 5: equipo null
        total++;
        try {
            new Equipo(null);
            System.out.println("  [fallo] prueba 5: equipo null debio lanzar excepcion");
        } catch (IllegalArgumentException e) {
            System.out.println("  [ok] prueba 5: equipo null lanza excepcion");
            pasaron++;
        } catch (Exception e) {
            System.out.println("  [fallo] prueba 5: " + e.getMessage());
        }
        
        // prueba 6: cantidad incorrecta de equipos
        total++;
        try {
            java.util.List<String> equipos = java.util.Arrays.asList("A", "B", "C");
            Torneo t = new Torneo("copa", "cuartos", equipos);
            t.generarLlaves();
            System.out.println("  [fallo] prueba 6: cantidad incorrecta debio lanzar excepcion");
        } catch (Exception e) {
            System.out.println("  [ok] prueba 6: cantidad incorrecta lanza excepcion");
            pasaron++;
        }
        
        System.out.println("==========================================");
        System.out.println("resultado final: " + pasaron + " de " + total + " pruebas pasaron");
        System.out.println("==========================================");
        
        if (pasaron == total) {
            System.out.println("estado: todas las pruebas pasaron correctamente");
        } else {
            System.out.println("estado: algunas pruebas fallaron");
        }
    }
}
