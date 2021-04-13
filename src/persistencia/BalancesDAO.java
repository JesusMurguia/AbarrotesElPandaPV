package persistencia;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import objetosNegocio.Balance;
import objetosNegocio.Empleado;

public class BalancesDAO {

    public void agregarBalance(Balance balance) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(balance);
        entityManager.getTransaction().commit();
    }

    public boolean actualizarBalance(Balance balance) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Balance balance2 = entityManager.find(Balance.class, balance.getId());
        if (balance2 != null) {
            balance2.setCredito(balance.getCredito());
            balance2.setDiferencia(balance.getDiferencia());
            balance2.setEfectivoIngresado(balance.getEfectivoIngresado());
            balance2.setEfectivoRetirado(balance.getEfectivoRetirado());
            balance2.setVaucherIngresado(balance.getVaucherIngresado());
            balance2.setVaucherRetirado(balance.getVaucherRetirado());
            balance2.setFecha(balance.getFecha());
            entityManager.persist(balance2);
            entityManager.getTransaction().commit();
            return true;
        }
        entityManager.getTransaction().commit();
        return false;
    }

    public boolean eliminarBalance(Integer id) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Balance balance = entityManager.find(Balance.class, id);
        if (balance != null) {
            entityManager.remove(balance);
            entityManager.getTransaction().commit();
            return true;
        }
        entityManager.getTransaction().commit();
        return false;
    }

    public Balance obtenerBalancePorId(Integer id) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Balance balance = entityManager.find(Balance.class, id);
        entityManager.getTransaction().commit();
        return balance;
    }

    public List<Balance> obtenerBalances() throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        //Crea el consructor de consultas
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        //Se construye el objeto de consulta en si
        criteria.select(criteria.from(Balance.class));
        //Creacion de la consulta lista para ejecutarse
        Query query = entityManager.createQuery(criteria);
        //Ejecucion del query y retorno de resultados.
        List<Balance> balances = query.getResultList();

        entityManager.getTransaction().commit();
        return balances;
    }

    public Balance obtenerBalanceFecha(Date date) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        //CREA EL CONSTRUCTOR DE CONSULTAS
        CriteriaQuery<Balance> criteria = builder.createQuery(Balance.class);
        Root<Balance> root = criteria.from(Balance.class);
        criteria = criteria.select(root).where(builder.like(root.get("fecha"), date + ""));
        TypedQuery<Balance> query = entityManager.createQuery(criteria);

        List<Balance> balances = query.getResultList();
        entityManager.getTransaction().commit();
        return balances.get(0);
    }

    public Balance obtenerBalancePorEmpleado(Date inicio, Date fin, Empleado empleado) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Balance> balances = null;
        if (empleado != null) {
            String jpqlQuery = "SELECT b FROM Balance b WHERE b.fecha BETWEEN :inicio AND :fin AND b.empleado = :empleado";
            TypedQuery<Balance> query = entityManager.createQuery(jpqlQuery, Balance.class);
            query.setParameter("inicio", inicio, TemporalType.TIMESTAMP);
            query.setParameter("fin", fin, TemporalType.TIMESTAMP);
            query.setParameter("empleado", empleado);
            balances = query.getResultList();
        }
        entityManager.getTransaction().commit();
        Balance balance;
        if (balances.size()>0) {
            balance= balances.get(0);
            return balance;
        } else {
            return null;
        }
    }

}
