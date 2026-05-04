package P.O.O;

import Unidad2.*;

public class PruebaAV {
    public static void main(String[] args) {

        System.out.println("|   Tarea Unidad 2   | ");
        System.out.println("|     Alan Ramon     |");
        System.out.println("");

        ContenidoAudiovisual[] contenidos = new ContenidoAudiovisual[5];

        //Película
        Pelicula peli = new Pelicula("Interstellar", 169, "Ciencia Ficcion", "Paramount");
        peli.agregarActor(new Actor("Matthew McConaughey"));
        peli.agregarActor(new Actor("Anne Hathaway"));

        //Serie
        SerieDeTV serie = new SerieDeTV("Breaking Bad", 50, "Drama", 5);
        serie.agregarTemporada(new Temporada(1, 7));
        serie.agregarTemporada(new Temporada(2, 13));

        //Documental
        Documental doc = new Documental("Planeta Tierra", 60, "Naturaleza", "Ecosistemas");
        doc.agregarInvestigador(new Investigador("David Attenborough"));

        //TikTok
        TikTokVideo tiktok = new TikTokVideo("Baile Viral", 1, "Entretenimiento", 500000);

        //Instagram
        InstagramReel reel = new InstagramReel("Receta rapida", 2, "Cocina", 120000);

        contenidos[0] = peli;
        contenidos[1] = serie;
        contenidos[2] = doc;
        contenidos[3] = tiktok;
        contenidos[4] = reel;

        for (ContenidoAudiovisual c : contenidos) {
            c.mostrarDetalles();
        }
    }
}
