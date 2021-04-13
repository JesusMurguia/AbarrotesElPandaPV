package negocio;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import objetosNegocio.Balance;
import objetosNegocio.Empleado;
import persistencia.BalancesDAO;

public class ControlBalances {

    private final BalancesDAO balancesDAO = new BalancesDAO();

    public void agregarBalance(Balance balance) throws SQLException {
        this.balancesDAO.agregarBalance(balance);
    }

    public boolean actualizarBalance(Balance balance) throws SQLException {
        return this.balancesDAO.actualizarBalance(balance);
    }

    public boolean eliminarBalance(Integer id) throws SQLException {
        return this.balancesDAO.eliminarBalance(id);
    }

    public Balance obtenerBalancePorId(Integer id) throws SQLException {
        return this.balancesDAO.obtenerBalancePorId(id);
    }

    public List<Balance> obtenerBalances() throws SQLException {
        return this.balancesDAO.obtenerBalances();
    }

    public Balance obtenerBalanceFecha(Date date) throws SQLException {
        return this.balancesDAO.obtenerBalanceFecha(date);
    }

    public Balance obtenerBalancePorEmpleado(Date inicio, Date fin, Empleado empleado) throws SQLException {
        return this.balancesDAO.obtenerBalancePorEmpleado(inicio, fin, empleado);
    }

    public void agregarBalanceBD(Balance balance) throws SQLException {
        Balance balance2 = this.obtenerBalancePorEmpleado(balance.getFecha(), balance.getFecha(), balance.getEmpleado());
        if (balance2 == null) {
            this.balancesDAO.agregarBalance(balance);
        }
    }

}
