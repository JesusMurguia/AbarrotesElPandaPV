package negocio;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import objetosNegocio.Categoria;
import persistencia.CategoriasDAO;
import vistas.FrmCategorias;

public class ControlCategorias {

    private final CategoriasDAO categoriasDAO = new CategoriasDAO();

    public void agregarCategoria(Categoria categoria) throws SQLException {
        this.categoriasDAO.agregarCategoria(categoria);
    }

    public boolean actualizarCategoria(Categoria categoria) throws SQLException {
        return this.categoriasDAO.actualizarCategoria(categoria);
    }

    public boolean eliminarCategoria(Integer id) throws SQLException {
        return this.categoriasDAO.eliminarCategoria(id);
    }

    public Categoria obtenerCategoriaPorId(Integer id) throws SQLException {
        return this.categoriasDAO.obtenerCategoriaPorId(id);
    }

    public List<Categoria> obtenerCategorias() throws SQLException {
        return this.categoriasDAO.obtenerCategorias();
    }

    public List obtenerCategoriasNombre(String nombre) throws SQLException {
        return categoriasDAO.obtenerCategoriaNombre(nombre);
    }

    public boolean agregarCategoriaBD(Categoria categoria) throws SQLException {
        int resp = JOptionPane.showConfirmDialog(null, "¿Los datos del la categoria son correctos?");
        if (resp == 0) {
            this.agregarCategoria(categoria);
            JOptionPane.showMessageDialog(null, "Se guardo la categoria correctamente ☺ ", "Información", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Operación Cancelada ", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    public boolean actualizarCategoriaBD(Categoria categoria) throws SQLException {
        int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea actualizar la categoria?");
        if (resp == 0) {
            this.actualizarCategoria(categoria);
            JOptionPane.showMessageDialog(null, "Categoria actualizada correctamente ☺", "Información", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Operacion Cancelada ", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    public void eliminarCategoriaBD(Integer id) throws SQLException {
        int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar la categoria?");
        if (resp == 0) {
            this.eliminarCategoria(id);
            JOptionPane.showMessageDialog(null, "Categoria eliminada correctamente ☺", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Operación Cancelada ", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void despliegaAdministrarCategorias() throws SQLException {
        FrmCategorias frmCategorias = new FrmCategorias();
        frmCategorias.setVisible(true);
    }
}
