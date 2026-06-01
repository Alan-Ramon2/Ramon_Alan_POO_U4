package principal;

import controlador.TorneoControlador;
import persistencia.TorneoRepositorioArchivo;
import persistencia.ITorneoRepositorio;
import vista.ConsolaVista;

public class Main {
    public static void main(String[] args) {
        ITorneoRepositorio repositorio = new TorneoRepositorioArchivo();
        ConsolaVista vista = new ConsolaVista();
        TorneoControlador controlador = new TorneoControlador(repositorio, vista);
        
        controlador.iniciar();
        
        vista.cerrarScanner();
    }
}
