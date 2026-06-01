package modelo;

public class Partido {
    private Equipo local;
    private Equipo visitante;
    private int numero;
    
    public Partido(Equipo local, Equipo visitante, int numero) {
        if (local == null || visitante == null) {
            throw new IllegalArgumentException("los equipos no pueden ser nulos");
        }
        if (local.getNombre().equals(visitante.getNombre())) {
            throw new IllegalArgumentException("un equipo no puede enfrentarse a si mismo");
        }
        this.local = local;
        this.visitante = visitante;
        this.numero = numero;
    }
    
    public Equipo getLocal() {
        return local;
    }
    
    public Equipo getVisitante() {
        return visitante;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public String getEnfrentamiento() {
        return local.getNombre() + " vs " + visitante.getNombre();
    }
    
    @Override
    public String toString() {
        return "partido " + numero + ": " + getEnfrentamiento();
    }
}
