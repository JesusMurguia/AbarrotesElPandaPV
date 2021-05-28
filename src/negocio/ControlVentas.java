package negocio;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import objetosNegocio.Cliente;
import objetosNegocio.Venta;
import persistencia.VentasDAO;

public class ControlVentas {

    private final VentasDAO ventasDAO = new VentasDAO();

    public void agregarVenta(Venta venta) throws SQLException {
        this.ventasDAO.agregarVenta(venta);
    }

    public boolean actualizarVenta(Venta venta) throws SQLException {
        return this.ventasDAO.actualizarVenta(venta);
    }

    public boolean eliminarVenta(Integer id) throws SQLException {
        return this.ventasDAO.eliminarVenta(id);
    }

    public Venta obtenerVentaPorId(Integer id) throws SQLException {
        return this.ventasDAO.obtenerVentaPorId(id);
    }

    public List<Venta> obtenerVentasFechas(Date inicio, Date fin) throws SQLException {
        return this.ventasDAO.obtenerVentas(inicio, fin);
    }

    public List<Venta> obtenerVentas(Date inicio, Date fin, Cliente cliente) throws SQLException {
        return this.ventasDAO.obtenerVentas(inicio, fin);
    }
}
