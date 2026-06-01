package persistencia;

import modelo.Torneo;
import java.util.List;

public interface ITorneoRepositorio {
    void guardar(Torneo torneo) throws Exception;
    List<Torneo> cargarTodos() throws Exception;
    Torneo buscarPorId(String id) throws Exception;
    void eliminar(String id) throws Exception;
}
