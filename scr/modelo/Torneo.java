package modelo;

import java.util.*;

public class Torneo {
    private String id;
    private String nombre;
    private String etapa;
    private List<Equipo> equipos;
    private List<Partido> partidos;
    private Date fechaCreacion;
    
    public Torneo(String nombre, String etapa, List<String> nombresEquipos) throws Exception {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.nombre = nombre;
        this.etapa = etapa.toLowerCase();
        this.equipos = new ArrayList<>();
        this.partidos = new ArrayList<>();
        this.fechaCreacion = new Date();
        
        for (String nombreEquipo : nombresEquipos) {
            this.equipos.add(new Equipo(nombreEquipo));
        }
        
        validarCantidadEquipos();
    }
    
    private void validarCantidadEquipos() throws Exception {
        int esperados = 0;
        if (etapa.equals("octavos")) esperados = 16;
        else if (etapa.equals("cuartos")) esperados = 8;
        else if (etapa.equals("semifinales")) esperados = 4;
        else if (etapa.equals("final")) esperados = 2;
        else throw new Exception("etapa invalida: " + etapa);
        
        if (equipos.size() != esperados) {
            throw new Exception("la etapa " + etapa + " requiere " + esperados + " equipos");
        }
    }
    
    public void generarLlaves() throws Exception {
        partidos.clear();
        List<Equipo> copia = new ArrayList<>(equipos);
        Random random = new Random();
        generarLlavesRecursivo(copia, random, 1);
    }
    
    private void generarLlavesRecursivo(List<Equipo> restantes, Random random, int numPartido) throws Exception {
        if (restantes.size() == 2) {
            partidos.add(new Partido(restantes.get(0), restantes.get(1), numPartido));
            return;
        }
        
        if (restantes.size() % 2 != 0) {
            throw new Exception("cantidad impar de equipos");
        }
        
        int i1 = random.nextInt(restantes.size());
        Equipo e1 = restantes.get(i1);
        
        int i2;
        do {
            i2 = random.nextInt(restantes.size());
        } while (i1 == i2);
        Equipo e2 = restantes.get(i2);
        
        partidos.add(new Partido(e1, e2, numPartido));
        
        if (i1 > i2) {
            restantes.remove(i1);
            restantes.remove(i2);
        } else {
            restantes.remove(i2);
            restantes.remove(i1);
        }
        
        generarLlavesRecursivo(restantes, random, numPartido + 1);
    }
    
    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEtapa() { return etapa; }
    public List<Equipo> getEquipos() { return new ArrayList<>(equipos); }
    public List<Partido> getPartidos() { return new ArrayList<>(partidos); }
    public Date getFechaCreacion() { return fechaCreacion; }
    
    public String aCSV() {
        StringBuilder equiposStr = new StringBuilder();
        for (Equipo e : equipos) {
            equiposStr.append(e.getNombre()).append(";");
        }
        return id + "," + nombre + "," + etapa + "," + fechaCreacion.getTime() + "," + equiposStr.toString();
    }
}
