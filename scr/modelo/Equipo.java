package modelo;

public class Equipo {
    private String nombre;
    private int id;
    private static int contadorId = 1;
    
    public Equipo(String nombre) {
        setNombre(nombre);
        this.id = contadorId++;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("el nombre del equipo no puede estar vacio");
        }
        this.nombre = nombre.trim();
    }
    
    public int getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return nombre;
    }
}
