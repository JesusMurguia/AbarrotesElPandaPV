package negocio;

import java.sql.SQLException;
import java.util.List;
import objetosNegocio.ProductoVenta;
import persistencia.ProductosVentasDAO;

public class ControlProductosVentas {

    private final ProductosVentasDAO productosVentasDAO = new ProductosVentasDAO();

    public void agregarProductoVenta(ProductoVenta productoVenta) throws SQLException {
        this.productosVentasDAO.agregarProductoVenta(productoVenta);
    }

    public boolean actualizarProductoVenta(ProductoVenta productoVenta) throws SQLException {
        return this.productosVentasDAO.actualizarProductoVenta(productoVenta);
    }

    public boolean eliminarProductoVenta(Integer id) throws SQLException {
        return this.productosVentasDAO.eliminarProductoVenta(id);
    }

    public ProductoVenta obtenerProductoVentaPorId(Integer id) throws SQLException {
        return this.productosVentasDAO.obtenerProductoVentaPorId(id);
    }

    public List<ProductoVenta> obtenerProductosVentas(String nombre) throws SQLException {
        return this.productosVentasDAO.obtenerProductosVentas(nombre);
    }
}
