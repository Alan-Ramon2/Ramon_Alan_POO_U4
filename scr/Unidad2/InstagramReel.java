package Unidad2;

public class InstagramReel extends ContenidoAudiovisual {

    private int vistas;

    public InstagramReel(String titulo, int duracion, String genero, int vistas) {
        super(titulo, duracion, genero);
        this.vistas = vistas;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("     INSTAGRAM     ");
        System.out.println("ID: " + getId());
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Duracion: " + getDuracionEnMinutos());
        System.out.println("Categoria: " + getGenero());
        System.out.println("Vistas: " + vistas);
        System.out.println();
    }
}
