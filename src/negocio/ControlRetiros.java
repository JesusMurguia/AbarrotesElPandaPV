package negocio;

import java.sql.SQLException;
import java.util.List;
import objetosNegocio.Retiro;
import persistencia.RetirosDAO;

public class ControlRetiros {

    private final RetirosDAO retirosDAO = new RetirosDAO();

    public void agregarRetiro(Retiro retiro) throws SQLException {
        this.retirosDAO.agregarRetiro(retiro);
    }

    public boolean actualizarRetiro(Retiro retiro) throws SQLException {
        return this.retirosDAO.actualizarRetiro(retiro);
    }

    public boolean eliminarRetiro(Integer id) throws SQLException {
        return this.retirosDAO.eliminarRetiro(id);
    }

    public Retiro obtenerRetiroPorId(Integer id) throws SQLException {
        return this.retirosDAO.obtenerRetiroPorId(id);
    }

    public List<Retiro> obtenerRetiros() throws SQLException {
        return this.retirosDAO.obtenerRetiros();
    }

    public List obtenerRetirosTipo(String tipo) throws SQLException {
        return this.retirosDAO.obtenerRetirosTipo(tipo);
    }
}
