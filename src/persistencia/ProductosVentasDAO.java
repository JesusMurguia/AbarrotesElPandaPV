package persistencia;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import objetosNegocio.ProductoVenta;

public class ProductosVentasDAO {

    public void agregarProductoVenta(ProductoVenta productoVenta) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(productoVenta);
        entityManager.getTransaction().commit();
    }

    public boolean actualizarProductoVenta(ProductoVenta productoVenta) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        ProductoVenta productoVentaActualizado = entityManager.find(ProductoVenta.class, productoVenta.getId());
        if (productoVentaActualizado != null) {
            productoVentaActualizado.setProducto(productoVenta.getProducto());
            productoVentaActualizado.setVenta(productoVenta.getVenta());
            productoVentaActualizado.setPrecio(productoVenta.getPrecio());
            productoVentaActualizado.setCantidad(productoVenta.getCantidad());
            productoVentaActualizado.setMontoTotal(productoVenta.getMontoTotal());
            entityManager.persist(productoVentaActualizado);
            entityManager.getTransaction().commit();
            return true;
        }
        entityManager.getTransaction().commit();
        return false;
    }

    public boolean eliminarProductoVenta(Integer id) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        ProductoVenta productoVenta = entityManager.find(ProductoVenta.class, id);
        if (productoVenta != null) {
            entityManager.remove(productoVenta);
            entityManager.getTransaction().commit();
            return true;
        }
        entityManager.getTransaction().commit();
        return false;
    }

    public ProductoVenta obtenerProductoVentaPorId(Integer id) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        ProductoVenta productoVenta = entityManager.find(ProductoVenta.class, id);
        entityManager.getTransaction().commit();
        return productoVenta;
    }

    public List<ProductoVenta> obtenerProductosVentas(String nombre) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        //Crea el consructor de consultas
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        //Se construye el objeto de consulta en si
        criteria.select(criteria.from(ProductoVenta.class));
        //Creacion de la consulta lista para ejecutarse
        Query query = entityManager.createQuery(criteria);
        //Ejecucion del query y retorno de resultados.
        List<ProductoVenta> productosVentas = query.getResultList();

        entityManager.getTransaction().commit();
        return productosVentas;
    }
}
