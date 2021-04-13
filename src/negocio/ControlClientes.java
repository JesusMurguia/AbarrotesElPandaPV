package negocio;

import java.sql.SQLException;
import java.util.List;
import objetosNegocio.Cliente;
import persistencia.ClientesDAO;

public class ControlClientes {

    private final ClientesDAO clientesDAO = new ClientesDAO();

    public void agregarCliente(Cliente cliente) throws SQLException {
        this.clientesDAO.agregarCliente(cliente);
    }

    public List guardarCliente() throws SQLException {
        return this.clientesDAO.obtenerClientes();
    }

    public boolean eliminarCliente(Integer idCliente) throws SQLException {
        return this.clientesDAO.eliminarCliente(idCliente);
    }

    public boolean actualizarCliente(Integer idCliente, Cliente cliente) throws SQLException {
        return this.clientesDAO.actualizarCliente(idCliente, cliente);
    }

    public Cliente obtenerClientePorId(Integer idCliente) throws SQLException {
        return this.clientesDAO.obtenerClientePorId(idCliente);
    }

    public List<Cliente> obtenerClientes() throws SQLException {
        return this.clientesDAO.obtenerClientes();
    }

    public List<Cliente> obtenerClientesComboBox() {
        return this.clientesDAO.obtenerClientesComboBox();
    }

    public List obtenerClientesNombre(String nombre) throws SQLException {
        return clientesDAO.obtenerClientesNombre(nombre);
    }
}
