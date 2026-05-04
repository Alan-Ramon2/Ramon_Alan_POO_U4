package Unidad2;

import java.util.ArrayList;

public class Documental extends ContenidoAudiovisual {
    private String tema;
    private ArrayList<Investigador> investigadores;

    public Documental(String titulo, int duracionEnMinutos, String genero, String tema) {
        super(titulo, duracionEnMinutos, genero);
        this.tema = tema;
        this.investigadores = new ArrayList<>();
    }

    public void agregarInvestigador(Investigador i) {
        investigadores.add(i);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("    DOCUMENTAL   ");
        System.out.println("ID: " + getId());
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Duracion: " + getDuracionEnMinutos());
        System.out.println("Genero: " + getGenero());
        System.out.println("Tema: " + tema);

        System.out.println("Investigadores:");
        for (Investigador i : investigadores) {
            System.out.println("- " + i.getNombre());
        }
        System.out.println();
    }
}
