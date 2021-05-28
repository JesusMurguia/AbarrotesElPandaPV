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
import javax.persistence.criteria.CriteriaQuery;
import objetosNegocio.Cliente;
import objetosNegocio.Venta;

public class VentasDAO {

    public void agregarVenta(Venta venta) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(venta);
        entityManager.getTransaction().commit();
    }

    public boolean actualizarVenta(Venta venta) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Venta ventaActualizado = entityManager.find(Venta.class, venta.getId());
        if (ventaActualizado != null) {
            ventaActualizado.setFecha(venta.getFecha());
            ventaActualizado.setCliente(venta.getCliente());
            ventaActualizado.setEmpleado(venta.getEmpleado());
            ventaActualizado.setTotal(venta.getTotal());
            ventaActualizado.setFormaDePago(venta.getFormaDePago());
            entityManager.persist(ventaActualizado);
            entityManager.getTransaction().commit();
            return true;
        }
        entityManager.getTransaction().commit();
        return false;
    }

    public boolean eliminarVenta(Integer id) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Venta venta = entityManager.find(Venta.class, id);
        if (venta != null) {
            entityManager.remove(venta);
            entityManager.getTransaction().commit();
            return true;
        }
        entityManager.getTransaction().commit();
        return false;
    }

    public Venta obtenerVentaPorId(Integer id) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Venta venta = entityManager.find(Venta.class, id);
        entityManager.getTransaction().commit();
        return venta;
    }

    public List<Venta> obtenerVentas(Date inicio, Date fin) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        //Crea el consructor de consultas
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        //Se construye el objeto de consulta en si
        criteria.select(criteria.from(Venta.class));
        //Creacion de la consulta lista para ejecutarse
        Query query = entityManager.createQuery(criteria);
        //Ejecucion del query y retorno de resultados.
        List<Venta> ventas = query.getResultList();

        entityManager.getTransaction().commit();
        return ventas;
    }

    public List<Venta> obtenerVentasPorCliente(Date inicio, Date fin, Cliente cliente) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Venta> ventas;
        if (cliente == null) {
            String jpqlQuery = "SELECT v FROM Venta v WHERE v.fecha BETWEEN :inicio AND :fin";
            TypedQuery<Venta> query = entityManager.createQuery(jpqlQuery, Venta.class);
            query.setParameter("inicio", inicio, TemporalType.TIMESTAMP);
            query.setParameter("fin", fin, TemporalType.TIMESTAMP);
            ventas = query.getResultList();
            for (Venta venta: ventas) {
                System.out.println(venta.toString());
            }
        } else {
            String jpqlQuery = "SELECT v FROM Venta v WHERE v.fecha BETWEEN :inicio AND :fin AND v.cliente = :cliente";
            TypedQuery<Venta> query = entityManager.createQuery(jpqlQuery, Venta.class);
            query.setParameter("inicio", inicio, TemporalType.TIMESTAMP);
            query.setParameter("fin", fin, TemporalType.TIMESTAMP);
            query.setParameter("cliente", cliente);
            ventas = query.getResultList();
        }
        return ventas;
    }
}
