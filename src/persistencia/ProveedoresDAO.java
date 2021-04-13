package persistencia;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import objetosNegocio.Proveedor;

public class ProveedoresDAO {

    public void guardarProveedor(Proveedor proveedor) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(proveedor);
        entityManager.getTransaction().commit();
    }

    public boolean actualizarProveedor(Proveedor proveedor) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Proveedor proveedorActualizado = entityManager.find(Proveedor.class, proveedor.getId());
        if (proveedorActualizado != null) {
            proveedorActualizado.setRfc(proveedor.getRfc());
            proveedorActualizado.setNombre(proveedor.getNombre());
            proveedorActualizado.setTelefono(proveedor.getTelefono());
            entityManager.persist(proveedorActualizado);
            entityManager.getTransaction().commit();
            return true;
        }
        entityManager.getTransaction().commit();
        return false;
    }

    public boolean eliminarProveedor(Integer id) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Proveedor proveedor = entityManager.find(Proveedor.class, id);
        if (proveedor != null) {
            entityManager.remove(proveedor);
            entityManager.getTransaction().commit();
            return true;
        }
        return false;
    }

    public Proveedor obtenerProveedorPorId(Integer id) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Proveedor proveedor = entityManager.find(Proveedor.class, id);
        entityManager.getTransaction().commit();
        return proveedor;
    }

    public List<Proveedor> obtenerProveedores() throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        //Crea el consructor de consultas
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        //Se construye el objeto de consulta en si
        criteria.select(criteria.from(Proveedor.class));
        //Creacion de la consulta lista para ejecutarse
        Query query = entityManager.createQuery(criteria);
        //Ejecucion del query y retorno de resultados.
        List<Proveedor> proveedores = query.getResultList();

        entityManager.getTransaction().commit();
        return proveedores;
    }

    public List obtenerProveedoresNombre(String nombre) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        //CREA EL CONSTRUCTOR DE CONSULTAS
        CriteriaQuery<Proveedor> criteria = builder.createQuery(Proveedor.class);
        Root<Proveedor> root = criteria.from(Proveedor.class);
        criteria = criteria.select(root).where(builder.like(root.get("nombre"), "%" + nombre + "%"));
        TypedQuery<Proveedor> query = entityManager.createQuery(criteria);

        List<Proveedor> proveedores = query.getResultList();
        entityManager.getTransaction().commit();
        return proveedores;

    }
}
