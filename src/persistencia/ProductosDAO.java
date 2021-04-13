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
import objetosNegocio.Producto;

public class ProductosDAO {

    public void agregarProducto(Producto producto) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(producto);
        entityManager.getTransaction().commit();
    }

    public List obtenerProductos() throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        //CREA EL CONSTRUCTOR DE CONSULTAS
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        //CONTRUYE EL OBJETO EN LA CONSULTA EN SI
        criteria.select(criteria.from(Producto.class));
        //CREACION DE LA CONSULTA LISTA PARA EJECUTAR
        Query query = entityManager.createQuery(criteria);
        //EJECUCION DEL QUERY Y RETORNO DE RESULTADOS
        List<Producto> productos = query.getResultList();
        entityManager.getTransaction().commit();
        return productos;

    }

    public List obtenerProductosNombre(String nombre) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        //CREA EL CONSTRUCTOR DE CONSULTAS
        CriteriaQuery<Producto> criteria = builder.createQuery(Producto.class);
        Root<Producto> root = criteria.from(Producto.class);
        criteria = criteria.select(root).where(builder.like(root.get("nombre"), "%" + nombre + "%"));
        TypedQuery<Producto> query = entityManager.createQuery(criteria);

        List<Producto> productos = query.getResultList();
        entityManager.getTransaction().commit();
        return productos;

    }

    public Producto obtenerProductosCodBarras(String codBarras) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        //CREA EL CONSTRUCTOR DE CONSULTAS
        CriteriaQuery<Producto> criteria = builder.createQuery(Producto.class);
        Root<Producto> root = criteria.from(Producto.class);
        criteria = criteria.select(root).where(builder.like(root.get("codBarras"), codBarras));
        TypedQuery<Producto> query = entityManager.createQuery(criteria);

        List<Producto> productos = query.getResultList();
        entityManager.getTransaction().commit();
        Producto producto;
        if (productos.size() > 0) {
            producto = productos.get(0);
            return producto;
        } else {
            return null;
        }

    }

    public boolean eliminarProducto(Integer idProducto) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Producto producto = entityManager.find(Producto.class, idProducto);
        if (producto != null) {
            entityManager.remove(producto);
            entityManager.getTransaction().commit();
            return true;

        } else {
            return false;
        }

    }

    public Producto obtenerPorId(Integer idProducto) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Producto producto = entityManager.find(Producto.class, idProducto);
        entityManager.getTransaction().commit();
        return producto;
    }

    public boolean actualizarProducto(Integer idProducto, Producto producto) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Producto producto2 = entityManager.find(Producto.class, idProducto);
        if (producto != null) {
            producto2.setNombre(producto.getNombre());
            producto2.setPrecioActual(producto.getPrecioActual());
            producto2.setStock(producto.getStock());
            producto2.setCategoria(producto.getCategoria());
            producto2.setProveedor(producto.getProveedor());
            producto2.setCodBarras(producto.getCodBarras());
            entityManager.persist(producto2);
            entityManager.getTransaction().commit();
            return true;
        } else {
            return false;
        }

    }

    public void actualizarStock(Integer idProducto, Producto producto) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Producto producto2 = entityManager.find(Producto.class, idProducto);
        if (producto != null) {
            producto2.setStock(producto.getStock());
            entityManager.persist(producto2);
            entityManager.getTransaction().commit();
        }

    }

}
