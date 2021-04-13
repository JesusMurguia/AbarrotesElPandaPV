package negocio;

import java.awt.Frame;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import javax.swing.JOptionPane;
import objetosNegocio.Empleado;
import persistencia.EmpleadosDAO;
import vistas.FrmAbarrotesElPanda;
import vistas.FrmEmpleados;
import vistas.FrmPuntoDeVenta;

public class ControlEmpleados {

    private final EmpleadosDAO empleadosDAO = new EmpleadosDAO();

    public void agregarEmpleado(Empleado empleado) throws SQLException {
        this.empleadosDAO.agregarEmpleado(empleado);
    }

    public List obtenerEmpleado() throws SQLException {
        return this.empleadosDAO.obtenerEmpleados();
    }

    public boolean eliminarEmpleado(Integer idEmpleado) throws SQLException {
        return this.empleadosDAO.eliminarEmpleado(idEmpleado);
    }

    public boolean actualizarEmpleado(Integer idEmpleado, Empleado empleado) throws SQLException {
        return this.empleadosDAO.actualizarEmpleado(idEmpleado, empleado);
    }

    public Empleado obtenerEmpleadoPorId(Integer idEmpleado) throws SQLException {
        return this.empleadosDAO.obtenerEmpleadoPorId(idEmpleado);
    }

    public List<Empleado> obtenerEmpleados() throws SQLException {
        return this.empleadosDAO.obtenerEmpleados();
    }

    public List<Empleado> obtenerEmpleadosComboBox() {
        return this.empleadosDAO.obtenerEmpleadosComboBox();
    }

    public List obtenerEmpleadosNombre(String nombre) throws SQLException {
        return empleadosDAO.obtenerEmpleadosNombre(nombre);
    }

    public boolean agregarEmpleadoBD(Empleado empleado) throws SQLException {
        int resp = JOptionPane.showConfirmDialog(null, "¿Los datos del empleado son correctos?");
        if (resp == 0) {
            this.agregarEmpleado(empleado);
            JOptionPane.showMessageDialog(null, "Se guardo el empleado correctamente ☺ ", "Información", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Operación Cancelada ", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    public void eliminarEmpleadoBD(int idEmpleado) throws SQLException {
        int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar al empleado?");
        if (resp == 0) {
            this.eliminarEmpleado(idEmpleado);
            JOptionPane.showMessageDialog(null, "Empleado eliminado correctamente ☺", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Operación Cancelada ", "Informacion", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public boolean actualizarEmpleadoBD(int numEmpleado, Empleado empleado) throws SQLException {
        int resp = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea actualizar al empleado?");
        if (resp == 0) {
            this.actualizarEmpleado(numEmpleado, empleado);
            JOptionPane.showMessageDialog(null, "Empleado actualizado correctamente ☺", "Información", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Operacion Cancelada ", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
    }

    public void despliegaAdministrarEmpleados() throws SQLException {
        FrmEmpleados frmEmpleados = new FrmEmpleados();
        frmEmpleados.setVisible(true);
    }

    public boolean accederAlSistema(Empleado empleado, String contraseña) throws ParseException {
        if (empleado != null) {
            if (empleado.getContrasenia().equals(contraseña)) {
                if (empleado.getTipo().equalsIgnoreCase("Administrador") || empleado.getTipo().equalsIgnoreCase("supervisor")) {
                    FrmAbarrotesElPanda frmAbarrotesElPanda = new FrmAbarrotesElPanda(empleado);
                    frmAbarrotesElPanda.setVisible(true);
                    return true;
                } else {
                    FrmPuntoDeVenta frmPuntoDeVenta = new FrmPuntoDeVenta(empleado);
                    frmPuntoDeVenta.setVisible(true);
                    return true;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña Incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "El empleado no existe", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }
}
