package persistencia;

import modelo.Torneo;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class TorneoRepositorioArchivo implements ITorneoRepositorio {
    
    private static final String CARPETA = "datos/";
    private static final String ARCHIVO = "torneos.csv";
    
    public TorneoRepositorioArchivo() {
        try {
            Files.createDirectories(Paths.get(CARPETA));
        } catch (IOException e) {
            System.err.println("no se pudo crear la carpeta: " + e.getMessage());
        }
    }
    
    @Override
    public void guardar(Torneo torneo) throws Exception {
        List<Torneo> todos = cargarTodos();
        
        boolean existe = false;
        for (int i = 0; i < todos.size(); i++) {
            if (todos.get(i).getId().equals(torneo.getId())) {
                todos.set(i, torneo);
                existe = true;
                break;
            }
        }
        if (!existe) {
            todos.add(torneo);
        }
        
        escribirTodos(todos);
    }
    
    @Override
    public List<Torneo> cargarTodos() throws Exception {
        List<Torneo> torneos = new ArrayList<>();
        Path path = Paths.get(CARPETA + ARCHIVO);
        
        if (!Files.exists(path)) {
            return torneos;
        }
        
        try (BufferedReader lector = Files.newBufferedReader(path)) {
            String linea;
            boolean primera = true;
            while ((linea = lector.readLine()) != null) {
                if (primera) {
                    primera = false;
                    continue;
                }
                if (linea.trim().isEmpty()) continue;
                
                String[] partes = linea.split(",");
                if (partes.length >= 5) {
                    String[] nombresEquipos = partes[4].split(";");
                    List<String> listaNombres = new ArrayList<>();
                    for (String ne : nombresEquipos) {
                        if (!ne.trim().isEmpty()) listaNombres.add(ne.trim());
                    }
                    Torneo t = new Torneo(partes[1], partes[2], listaNombres);
                    t.generarLlaves();
                    torneos.add(t);
                }
            }
        }
        return torneos;
    }
    
    @Override
    public Torneo buscarPorId(String id) throws Exception {
        List<Torneo> todos = cargarTodos();
        for (Torneo t : todos) {
            if (t.getId().equals(id)) {
                return t;
            }
        }
        return null;
    }
    
    @Override
    public void eliminar(String id) throws Exception {
        List<Torneo> todos = cargarTodos();
        List<Torneo> nuevos = new ArrayList<>();
        for (Torneo t : todos) {
            if (!t.getId().equals(id)) {
                nuevos.add(t);
            }
        }
        escribirTodos(nuevos);
    }
    
    private void escribirTodos(List<Torneo> torneos) throws Exception {
        Path path = Paths.get(CARPETA + ARCHIVO);
        try (BufferedWriter escritor = Files.newBufferedWriter(path)) {
            escritor.write("id,nombre,etapa,fecha,equipos");
            escritor.newLine();
            for (Torneo t : torneos) {
                escritor.write(t.aCSV());
                escritor.newLine();
            }
        }
    }
}
