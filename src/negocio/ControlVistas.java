package negocio;

import java.awt.Frame;
import java.sql.SQLException;
import java.text.ParseException;
import javax.swing.JOptionPane;
import objetosNegocio.Cliente;
import objetosNegocio.Empleado;
import vistas.DlgAyuda;
import vistas.DlgBuscarProducto;
import vistas.DlgPago;
import vistas.FrmAbarrotesElPanda;
import vistas.FrmEmpleados;
import vistas.FrmMenuSupervisor;
import vistas.FrmPuntoDeVenta;

/**
 *
 * @author GPE
 */
public class ControlVistas {

    public void despliegaAdministrarEmpleados() throws SQLException {
        FrmEmpleados frmEmpleados = new FrmEmpleados();
        frmEmpleados.setVisible(true);
    }

    public void despliegaMenuSupervisor() {
        FrmMenuSupervisor frmMenuSupervisor = new FrmMenuSupervisor();
        frmMenuSupervisor.setVisible(true);
    }

    public void despliegaBuscadorDeProductos(Frame frame) {
        DlgBuscarProducto dlgBuscarProducto = new DlgBuscarProducto(frame, true);
        dlgBuscarProducto.setVisible(true);
    }

    public void despliegaVistaDePago(Frame frame, String total, Empleado empleado) throws ParseException {
        DlgPago dlgPago = new DlgPago(frame, true, total, empleado);
        dlgPago.setVisible(true);
    }

    public void despliegaVistaDeayuda(Frame frame) {
        DlgAyuda dlgAyuda = new DlgAyuda(frame, true);
        dlgAyuda.setVisible(true);
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

    public boolean AutorizarPagoACredito(Cliente cliente, String contraseña) throws ParseException {
        if (cliente != null) {
            if (cliente.getNip().equals(contraseña)) {
                JOptionPane.showMessageDialog(null, "Contraseña Correcta, transaccion aceptada", "Exito", JOptionPane.INFORMATION_MESSAGE);
                return true;
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
