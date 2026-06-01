package vista;

import modelo.Torneo;
import modelo.Partido;
import java.util.*;

public class ConsolaVista {
    private final Scanner scanner;
    
    public ConsolaVista() {
        this.scanner = new Scanner(System.in);
    }
    
    public void mostrarBienvenida() {
        System.out.println("--------------------------------------------------");
        System.out.println("     sistema de sorteo de torneos                ");
        System.out.println("--------------------------------------------------");
    }
    
    public void mostrarMenu() {
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println("                 menu principal                   ");
        System.out.println("--------------------------------------------------");
        System.out.println("1. crear nuevo torneo");
        System.out.println("2. ver torneos guardados");
        System.out.println("3. ver detalles de un torneo");
        System.out.println("4. eliminar torneo");
        System.out.println("5. salir");
        System.out.println("--------------------------------------------------");
        System.out.print("seleccione una opcion: ");
    }
    
    public void mostrarEtapas() {
        System.out.println();
        System.out.println("etapas disponibles:");
        System.out.println("  * octavos       -> 16 equipos");
        System.out.println("  * cuartos       -> 8 equipos");
        System.out.println("  * semifinales   -> 4 equipos");
        System.out.println("  * final         -> 2 equipos");
    }
    
    public String pedirTexto(String mensaje) {
        System.out.print(mensaje);
        String input = scanner.nextLine().trim();
        while (input.isEmpty()) {
            System.out.print("el valor no puede estar vacio. " + mensaje);
            input = scanner.nextLine().trim();
        }
        return input;
    }
    
    public int pedirNumero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("error: debe ingresar un numero entero valido.");
            }
        }
    }
    
    public void mostrarSorteo(Torneo torneo) {
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println("              resultado del sorteo               ");
        System.out.println("--------------------------------------------------");
        System.out.println("torneo: " + torneo.getNombre());
        System.out.println("etapa: " + torneo.getEtapa().toUpperCase());
        System.out.println("id: " + torneo.getId());
        System.out.println("--------------------------------------------------");
        System.out.println("equipos participantes:");
        for (int i = 0; i < torneo.getEquipos().size(); i++) {
            System.out.println("   " + (i + 1) + ". " + torneo.getEquipos().get(i).getNombre());
        }
        System.out.println();
        System.out.println("emparejamientos:");
        for (Partido p : torneo.getPartidos()) {
            System.out.println("   " + p);
        }
        System.out.println("--------------------------------------------------");
    }
    
    public void mostrarListaTorneos(List<Torneo> torneos) {
        if (torneos.isEmpty()) {
            System.out.println("no hay torneos guardados.");
            return;
        }
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println("              torneos guardados                  ");
        System.out.println("--------------------------------------------------");
        for (Torneo t : torneos) {
            System.out.println("id: " + t.getId() + " | " + t.getNombre() + " | etapa: " + t.getEtapa());
        }
        System.out.println("--------------------------------------------------");
    }
    
    public void mostrarMensaje(String mensaje) {
        System.out.println("[info] " + mensaje);
    }
    
    public void mostrarExito(String mensaje) {
        System.out.println("[ok] " + mensaje);
    }
    
    public void mostrarError(String error) {
        System.err.println("[error] " + error);
    }
    
    public void pausar() {
        System.out.print("presione enter para continuar...");
        scanner.nextLine();
    }
    
    public String pedirId() {
        System.out.print("ingrese el id del torneo: ");
        return scanner.nextLine().trim();
    }
    
    public void cerrarScanner() {
        scanner.close();
    }
}
