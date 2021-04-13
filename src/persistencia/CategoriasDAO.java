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
import objetosNegocio.Categoria;

public class CategoriasDAO {

    public void agregarCategoria(Categoria categoria) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(categoria);
        entityManager.getTransaction().commit();
    }

    public boolean actualizarCategoria(Categoria categoria) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Categoria categoriaActualizado = entityManager.find(Categoria.class, categoria.getId());
        if (categoriaActualizado != null) {
            categoriaActualizado.setNombre(categoria.getNombre());
            categoriaActualizado.setDescripcion(categoria.getDescripcion());
            entityManager.persist(categoriaActualizado);
            entityManager.getTransaction().commit();
            return true;
        }
        entityManager.getTransaction().commit();
        return false;
    }

    public boolean eliminarCategoria(Integer id) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Categoria categoria = entityManager.find(Categoria.class, id);
        if (categoria != null) {
            entityManager.remove(categoria);
            entityManager.getTransaction().commit();
            return true;
        }
        entityManager.getTransaction().commit();
        return false;
    }

    public Categoria obtenerCategoriaPorId(Integer id) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Categoria categoria = entityManager.find(Categoria.class, id);
        entityManager.getTransaction().commit();
        return categoria;
    }

    public List<Categoria> obtenerCategorias() throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        //Crea el consructor de consultas
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        //Se construye el objeto de consulta en si
        criteria.select(criteria.from(Categoria.class));
        //Creacion de la consulta lista para ejecutarse
        Query query = entityManager.createQuery(criteria);
        //Ejecucion del query y retorno de resultados.
        List<Categoria> categorias = query.getResultList();

        entityManager.getTransaction().commit();
        return categorias;
    }

    public List obtenerCategoriaNombre(String nombre) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        //CREA EL CONSTRUCTOR DE CONSULTAS
        CriteriaQuery<Categoria> criteria = builder.createQuery(Categoria.class);
        Root<Categoria> root = criteria.from(Categoria.class);
        criteria = criteria.select(root).where(builder.like(root.get("nombre"), nombre + "%"));
        TypedQuery<Categoria> query = entityManager.createQuery(criteria);

        List<Categoria> categorias = query.getResultList();
        entityManager.getTransaction().commit();
        return categorias;

    }
}
