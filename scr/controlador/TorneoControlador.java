package controlador;

import modelo.Torneo;
import vista.ConsolaVista;
import persistencia.ITorneoRepositorio;
import java.util.*;

public class TorneoControlador {
    private ITorneoRepositorio repositorio;
    private ConsolaVista vista;
    private boolean corriendo;
    
    public TorneoControlador(ITorneoRepositorio repositorio, ConsolaVista vista) {
        this.repositorio = repositorio;
        this.vista = vista;
        this.corriendo = true;
    }
    
    public void iniciar() {
        vista.mostrarBienvenida();
        
        while (corriendo) {
            vista.mostrarMenu();
            int opcion = vista.pedirNumero("> ");
            
            try {
                if (opcion == 1) crearTorneo();
                else if (opcion == 2) verTorneos();
                else if (opcion == 3) verDetalle();
                else if (opcion == 4) eliminarTorneo();
                else if (opcion == 5) salir();
                else vista.mostrarError("opcion no valida");
            } catch (Exception e) {
                vista.mostrarError(e.getMessage());
            }
        }
    }
    
    private void crearTorneo() throws Exception {
        vista.mostrarMensaje("creacion de nuevo torneo");
        String nombre = vista.pedirTexto("nombre del torneo: ");
        
        vista.mostrarEtapas();
        String etapa = vista.pedirTexto("ingrese la etapa: ").toLowerCase();
        
        int numEquipos = 0;
        if (etapa.equals("octavos")) numEquipos = 16;
        else if (etapa.equals("cuartos")) numEquipos = 8;
        else if (etapa.equals("semifinales")) numEquipos = 4;
        else if (etapa.equals("final")) numEquipos = 2;
        else throw new Exception("etapa no valida");
        
        List<String> nombresEquipos = new ArrayList<>();
        vista.mostrarMensaje("ingrese los " + numEquipos + " equipos:");
        for (int i = 1; i <= numEquipos; i++) {
            String nom = vista.pedirTexto("equipo #" + i + ": ");
            if (nombresEquipos.contains(nom)) {
                vista.mostrarError("equipo ya existe");
                i--;
            } else {
                nombresEquipos.add(nom);
            }
        }
        
        Torneo torneo = new Torneo(nombre, etapa, nombresEquipos);
        torneo.generarLlaves();
        repositorio.guardar(torneo);
        
        vista.mostrarSorteo(torneo);
        vista.mostrarExito("torneo guardado con id: " + torneo.getId());
        vista.pausar();
    }
    
    private void verTorneos() throws Exception {
        List<Torneo> torneos = repositorio.cargarTodos();
        vista.mostrarListaTorneos(torneos);
        vista.pausar();
    }
    
    private void verDetalle() throws Exception {
        String id = vista.pedirId();
        Torneo t = repositorio.buscarPorId(id);
        if (t != null) {
            vista.mostrarSorteo(t);
        } else {
            vista.mostrarError("no se encontro torneo con id " + id);
        }
        vista.pausar();
    }
    
    private void eliminarTorneo() throws Exception {
        String id = vista.pedirId();
        Torneo t = repositorio.buscarPorId(id);
        if (t != null) {
            String resp = vista.pedirTexto("eliminar '" + t.getNombre() + "'? (s/n): ");
            if (resp.equalsIgnoreCase("s")) {
                repositorio.eliminar(id);
                vista.mostrarExito("torneo eliminado");
            }
        } else {
            vista.mostrarError("no se encontro torneo");
        }
        vista.pausar();
    }
    
    private void salir() {
        vista.mostrarMensaje("gracias por usar el sistema");
        corriendo = false;
    }
}
