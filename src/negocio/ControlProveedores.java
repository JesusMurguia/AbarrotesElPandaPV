package negocio;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import objetosNegocio.Proveedor;
import persistencia.ProveedoresDAO;
import vistas.FrmProveedores;

public class ControlProveedores {

    private final ProveedoresDAO proveedoresDAO = new ProveedoresDAO();

    public void guardarProveedor(Proveedor proveedor) throws SQLException {
        this.proveedoresDAO.guardarProveedor(proveedor);
    }

    public boolean actualizarProveedor(Proveedor proveedor) throws SQLException {
        return this.proveedoresDAO.actualizarProveedor(proveedor);
    }

    public boolean eliminarProveedor(Integer id) throws SQLException {
        return this.proveedoresDAO.eliminarProveedor(id);
    }

    public Proveedor obtenerProveedorPorId(Integer id) throws SQLException {
        return this.proveedoresDAO.obtenerProveedorPorId(id);
    }

    public List<Proveedor> obtenerProveedores() throws SQLException {
        return this.proveedoresDAO.obtenerProveedores();
    }

    public List obtenerProveedoresNombre(String nombre) throws SQLException {
        return proveedoresDAO.obtenerProveedoresNombre(nombre);
    }

    public boolean guardarProveedorBD(Proveedor proveedor) throws SQLException {
        int resp = JOptionPane.showConfirmDialog(null, "¿Los datos del proveedor son correctos?");
        if (resp == 0) {
            this.guardarProveedor(proveedor);
            JOptionPane.showMessageDialog(null, "Se guardo el proveedor correctamente ☺ ", "Información", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Operación Cancelada ", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    public boolean actualizarProveedorBD(Proveedor proveedor) throws SQLException {
        int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea actualizar el Proveedor?");
        if (resp == 0) {
            this.actualizarProveedor(proveedor);
            JOptionPane.showMessageDialog(null, "Proveedor actualizado correctamente ☺", "Información", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Operacion Cancelada ", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    public void eliminarProveedorBD(Integer id) throws SQLException {
        int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar el proveedor?");
        if (resp == 0) {
            this.eliminarProveedor(id);
            JOptionPane.showMessageDialog(null, "Proveedor eliminada correctamente ☺", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Operación Cancelada ", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void despliegaAdministrarProveedores() throws SQLException {
        FrmProveedores frmProveedores = new FrmProveedores();
        frmProveedores.setVisible(true);
    }
}
