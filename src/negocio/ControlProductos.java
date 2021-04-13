package negocio;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import objetosNegocio.Producto;
import persistencia.ProductosDAO;
import vistas.FrmProductos;

public class ControlProductos {

    private final ProductosDAO productosDAO = new ProductosDAO();

    public List obtenerProductos() throws SQLException {
        return this.productosDAO.obtenerProductos();
    }

    public void agregarProducto(Producto producto) throws SQLException {
        this.productosDAO.agregarProducto(producto);
    }

    public boolean eliminarProducto(Integer idProducto) throws SQLException {
        return this.productosDAO.eliminarProducto(idProducto);
    }

    public Producto obtenerPorId(Integer idProducto) throws SQLException {
        return this.productosDAO.obtenerPorId(idProducto);
    }

    public boolean actualizarProducto(Integer idProducto, Producto producto) throws SQLException {
        return this.productosDAO.actualizarProducto(idProducto, producto);
    }

    public List obtenerProductosNombre(String nombre) throws SQLException {
        return productosDAO.obtenerProductosNombre(nombre);
    }

    public Producto obtenerProductoCodBarras(String codBarras) throws SQLException {

        Producto producto = productosDAO.obtenerProductosCodBarras(codBarras);
        if (producto != null) {
            return producto;
        } else {
            return null;
        }
    }

    public void actualizarStock(Integer idProducto, Producto producto) throws SQLException {
        this.productosDAO.actualizarStock(idProducto, producto);
    }

    public boolean agregarProductoBD(Producto producto) throws SQLException {
        int resp = JOptionPane.showConfirmDialog(null, "¿Los datos del producto son correctos?");
        if (resp == 0) {
            this.agregarProducto(producto);
            JOptionPane.showMessageDialog(null, "Se guardo el producto correctamente ☺ ", "Información", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Operación Cancelada ", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    public void eliminarProductoBD(Integer idProducto) throws SQLException {
        int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el producto?");
        if (resp == 0) {
            this.eliminarProducto(idProducto);
            JOptionPane.showMessageDialog(null, "Producto eliminado correctamente ☺", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Operación Cancelada ", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public boolean actualizarProductoBD(Integer idProducto, Producto producto) throws SQLException {
        int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea actualizar el producto?");
        if (resp == 0) {
            this.actualizarProducto(idProducto, producto);
            JOptionPane.showMessageDialog(null, "Producto actualizado correctamente ☺", "Información", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Operacion Cancelada ", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    public void despliegaAdministrarProductos() throws SQLException {
        FrmProductos frmProductos = new FrmProductos();
        frmProductos.setVisible(true);
    }
}
