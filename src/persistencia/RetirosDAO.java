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
import objetosNegocio.Retiro;

public class RetirosDAO {

    public void agregarRetiro(Retiro retiro) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(retiro);
        entityManager.getTransaction().commit();
    }

    public boolean actualizarRetiro(Retiro retiro) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Retiro retiro2 = entityManager.find(Retiro.class, retiro.getId());
        if (retiro2 != null) {
            retiro2.setCantidad(retiro.getCantidad());
            retiro2.setTipo(retiro.getTipo());
            entityManager.persist(retiro2);
            entityManager.getTransaction().commit();
            return true;
        }
        entityManager.getTransaction().commit();
        return false;
    }

    public boolean eliminarRetiro(Integer id) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Retiro retiro = entityManager.find(Retiro.class, id);
        if (retiro != null) {
            entityManager.remove(retiro);
            entityManager.getTransaction().commit();
            return true;
        }
        entityManager.getTransaction().commit();
        return false;
    }

    public Retiro obtenerRetiroPorId(Integer id) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Retiro retiro = entityManager.find(Retiro.class, id);
        entityManager.getTransaction().commit();
        return retiro;
    }

    public List<Retiro> obtenerRetiros() throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        //Crea el consructor de consultas
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        //Se construye el objeto de consulta en si
        criteria.select(criteria.from(Retiro.class));
        //Creacion de la consulta lista para ejecutarse
        Query query = entityManager.createQuery(criteria);
        //Ejecucion del query y retorno de resultados.
        List<Retiro> retiros = query.getResultList();

        entityManager.getTransaction().commit();
        return retiros;
    }

    public List obtenerRetirosTipo(String tipo) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        //CREA EL CONSTRUCTOR DE CONSULTAS
        CriteriaQuery<Retiro> criteria = builder.createQuery(Retiro.class);
        Root<Retiro> root = criteria.from(Retiro.class);
        criteria = criteria.select(root).where(builder.like(root.get("tipo"), tipo + "%"));
        TypedQuery<Retiro> query = entityManager.createQuery(criteria);

        List<Retiro> retiros = query.getResultList();
        entityManager.getTransaction().commit();
        return retiros;

    }
}
