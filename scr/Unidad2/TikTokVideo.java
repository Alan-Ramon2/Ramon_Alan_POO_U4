package Unidad2;

public class TikTokVideo extends ContenidoAudiovisual {

    private int likes;

    public TikTokVideo(String titulo, int duracion, String genero, int likes) {
        super(titulo, duracion, genero);
        this.likes = likes;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("      TIKTOK     ");
        System.out.println("ID: " + getId());
        System.out.println("Titulo: " + getTitulo());
        System.out.println("Duracion: " + getDuracionEnMinutos());
        System.out.println("Categoria: " + getGenero());
        System.out.println("Likes: " + likes);
        System.out.println();
    }
}
