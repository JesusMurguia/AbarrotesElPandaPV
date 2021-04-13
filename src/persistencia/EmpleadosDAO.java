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
import objetosNegocio.Empleado;

public class EmpleadosDAO {

    public void agregarEmpleado(Empleado empleado) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(empleado);
        entityManager.getTransaction().commit();
    }

    public List<Empleado> obtenerEmpleados() throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        //CREA EL CONSTRUCTOR DE CONSULTAS
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        //CONTRUYE EL OBJETO EN LA CONSULTA EN SI
        criteria.select(criteria.from(Empleado.class));
        //CREACION DE LA CONSULTA LISTA PARA EJECUTAR
        Query query = entityManager.createQuery(criteria);
        //EJECUCION DEL QUERY Y RETORNO DE RESULTADOS
        List<Empleado> empleados = query.getResultList();
        entityManager.getTransaction().commit();
        return empleados;
    }

    public Empleado obtenerEmpleadoPorId(Integer idEmpleado) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Empleado empleado = entityManager.find(Empleado.class, idEmpleado);
        entityManager.getTransaction().commit();
        return empleado;

    }

    public boolean eliminarEmpleado(Integer idCliente) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Empleado empleado = entityManager.find(Empleado.class, idCliente);
        if (empleado != null) {
            entityManager.remove(empleado);
            entityManager.getTransaction().commit();
            return true;

        } else {
            return false;
        }

    }

    public boolean actualizarEmpleado(Integer idCliente, Empleado empleado) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        Empleado empleado2 = entityManager.find(Empleado.class, idCliente);
        if (empleado != null) {
            empleado2.setNombre(empleado.getNombre());
            empleado2.setRfc(empleado.getRfc());
            empleado2.setDireccion(empleado.getDireccion());
            empleado2.setTelefono(empleado.getTelefono());
            empleado2.setFaltante(empleado.getFaltante());
            empleado2.setFechaIngreso(empleado.getFechaIngreso());
            empleado2.setFechaNac(empleado.getFechaNac());
            empleado2.setSexo(empleado.getSexo());
            empleado2.setTipo(empleado.getTipo());
            empleado2.setContrasenia(empleado.getContrasenia());
            entityManager.persist(empleado2);
            entityManager.getTransaction().commit();
            return true;
        } else {
            return false;
        }
    }

    public List<Empleado> obtenerEmpleadosComboBox() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        //CREA EL CONSTRUCTOR DE CONSULTAS
        CriteriaQuery criteria = entityManager.getCriteriaBuilder().createQuery();
        //CONTRUYE EL OBJETO EN LA CONSULTA EN SI
        criteria.select(criteria.from(Empleado.class));
        //CREACION DE LA CONSULTA LISTA PARA EJECUTAR
        Query query = entityManager.createQuery(criteria);
        //EJECUCION DEL QUERY Y RETORNO DE RESULTADOS
        List<Empleado> empleados = query.getResultList();
        entityManager.getTransaction().commit();
        return empleados;
    }

    public List obtenerEmpleadosNombre(String nombre) throws SQLException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("AbarrotesElPandaPU");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        //CREA EL CONSTRUCTOR DE CONSULTAS
        CriteriaQuery<Empleado> criteria = builder.createQuery(Empleado.class);
        Root<Empleado> root = criteria.from(Empleado.class);
        criteria = criteria.select(root).where(builder.like(root.get("nombre"), nombre + "%"));
        TypedQuery<Empleado> query = entityManager.createQuery(criteria);

        List<Empleado> empleados = query.getResultList();
        entityManager.getTransaction().commit();
        return empleados;
    }
}
