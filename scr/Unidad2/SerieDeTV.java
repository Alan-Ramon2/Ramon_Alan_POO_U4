package Unidad2;

import java.util.ArrayList;

public class SerieDeTV extends ContenidoAudiovisual {
    private int temporadas;
    private ArrayList<Temporada> listaTemporadas;

    public SerieDeTV(String titulo, int duracionEnMinutos, String genero, int temporadas) {
        super(titulo, duracionEnMinutos, genero);
        this.temporadas = temporadas;
        this.listaTemporadas = new ArrayList<>();
    }

    public void agregarTemporada(Temporada t) {
        listaTemporadas.add(t);
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("      SERIE       ");
        System.out.println("ID: " + getId());
        System.out.println("TItulo: " + getTitulo());
        System.out.println("DuraciOn: " + getDuracionEnMinutos());
        System.out.println("Genero: " + getGenero());
        System.out.println("Temporadas: " + temporadas);

        for (Temporada t : listaTemporadas) {
            System.out.println("Temporada " + t.getNumero() + " - Episodios: " + t.getEpisodios());
        }
        System.out.println();
    }
}
