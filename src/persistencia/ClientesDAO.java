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
import objetosNegocio.Cliente;

public class ClientesDAO {

    public void agregarCliente(Cliente cliente) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
//        Cliente cliente2 = new Cliente();
//        cliente2.setNombre(cliente.getNombre());
//        cliente2.setRfc(cliente.getRfc());
//        cliente2.setDireccion(cliente.getDireccion());
//        cliente2.setTelefono1(cliente.getTelefono1());
//        cliente2.setTelefono2(cliente.getTelefono2());
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
    }

    public List obtenerClientes() throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        //CREA EL CONSTRUCTOR DE CONSULTAS
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        //CONTRUYE EL OBJETO EN LA CONSULTA EN SI
        criteria.select(criteria.from(Cliente.class));
        //CREACION DE LA CONSULTA LISTA PARA EJECUTAR
        Query query = entityManager.createQuery(criteria);
        //EJECUCION DEL QUERY Y RETORNO DE RESULTADOS
        List<Cliente> clientes = query.getResultList();
        entityManager.getTransaction().commit();
        return clientes;
    }

    public Cliente obtenerClientePorId(Integer idCliente) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Cliente cliente = entityManager.find(Cliente.class, idCliente);
        entityManager.getTransaction().commit();
        return cliente;

    }

    public boolean eliminarCliente(Integer idCliente) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Cliente cliente = entityManager.find(Cliente.class, idCliente);
        if (cliente != null) {
            entityManager.remove(cliente);
            entityManager.getTransaction().commit();
            return true;

        } else {
            return false;
        }

    }

    public boolean actualizarCliente(Integer idCliente, Cliente cliente) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Cliente cliente2 = entityManager.find(Cliente.class, idCliente);
        if (cliente != null) {
            cliente2.setNombre(cliente.getNombre());
            cliente2.setRfc(cliente.getRfc());
            cliente2.setDireccion(cliente.getDireccion());
            cliente2.setTelefono1(cliente.getTelefono1());
            cliente2.setAdeudo(cliente.getAdeudo());
            cliente2.setLimiteCredito(cliente.getLimiteCredito());
            entityManager.persist(cliente2);
            entityManager.getTransaction().commit();
            return true;
        } else {
            return false;
        }
    }

    public List<Cliente> obtenerClientesComboBox() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        //CREA EL CONSTRUCTOR DE CONSULTAS
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        //CONTRUYE EL OBJETO EN LA CONSULTA EN SI
        criteria.select(criteria.from(Cliente.class));
        //CREACION DE LA CONSULTA LISTA PARA EJECUTAR
        Query query = entityManager.createQuery(criteria);
        //EJECUCION DEL QUERY Y RETORNO DE RESULTADOS
        List<Cliente> clientes = query.getResultList();
        entityManager.getTransaction().commit();
        return clientes;
    }

    public List obtenerClientesNombre(String nombre) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        //CREA EL CONSTRUCTOR DE CONSULTAS
        CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
        Root<Cliente> root = criteria.from(Cliente.class);
        criteria = criteria.select(root).where(builder.like(root.get("nombre"), nombre + "%"));
        TypedQuery<Cliente> query = entityManager.createQuery(criteria);

        List<Cliente> clientes = query.getResultList();
        entityManager.getTransaction().commit();
        return clientes;
    }
}
