package objetosNegocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author GPE
 */
@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idempleado")
    private Integer id;

    @Column(name = "nombre", length = 45, nullable = false)
    private String nombre;

    @Column(name = "fechaNac", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaNac;

    @Column(name = "direccion", length = 100, nullable = true)
    private String direccion;

    @Column(name = "contrasenia", length = 100, nullable = false)
    private String contrasenia;

    @Column(name = "rfc", length = 15, nullable = true)
    private String rfc;

    @Column(name = "faltante", length = 15, nullable = true)
    private double faltante;

    @Column(name = "telefono", length = 15, nullable = true)
    private String telefono;

    @Column(name = "sexo", length = 15, nullable = true)
    private String sexo;

    @Column(name = "tipo", length = 15, nullable = false)
    private String tipo;

    @Column(name = "fechaIngreso", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaIngreso;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<Venta> ventas;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<Retiro> retiros;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<Balance> balances;

    public Empleado() {
        this.ventas = new ArrayList<>();
        this.retiros = new ArrayList<>();
        this.balances = new ArrayList<>();
    }

    public Empleado(Integer id, String nombre, Date fechaNac, String direccion, String contrasenia, String rfc, double faltante, String telefono, String sexo, String tipo, Date fechaIngreso, List<Venta> ventas, List<Retiro> retiros, List<Balance> balances) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.direccion = direccion;
        this.contrasenia = contrasenia;
        this.rfc = rfc;
        this.faltante = faltante;
        this.telefono = telefono;
        this.sexo = sexo;
        this.tipo = tipo;
        this.fechaIngreso = fechaIngreso;
        this.ventas = ventas;
        this.retiros = retiros;
        this.balances = balances;
    }


    public void addVenta(Venta venta) {
        venta.setEmpleado(this);
        this.ventas.add(venta);
    }

    public void addRetiro(Retiro retiro) {
        retiro.setEmpleado(this);
        this.retiros.add(retiro);
    }

    public void addBalance(Balance balance) {
        balance.setEmpleado(this);
        this.balances.add(balance);
    }

    public Integer getId() {
        return id;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public List<Retiro> getRetiros() {
        return retiros;
    }

    public void setRetiros(List<Retiro> retiros) {
        this.retiros = retiros;
    }

    public List<Balance> getBalances() {
        return balances;
    }

    public void setBalances(List<Balance> balances) {
        this.balances = balances;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public double getFaltante() {
        return faltante;
    }

    public void setFaltante(double faltante) {
        this.faltante = faltante;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        hash = 41 * hash + Objects.hashCode(this.nombre);
        hash = 41 * hash + Objects.hashCode(this.fechaNac);
        hash = 41 * hash + Objects.hashCode(this.direccion);
        hash = 41 * hash + Objects.hashCode(this.rfc);
        hash = 41 * hash + (int) (Double.doubleToLongBits(this.faltante) ^ (Double.doubleToLongBits(this.faltante) >>> 32));
        hash = 41 * hash + Objects.hashCode(this.telefono);
        hash = 41 * hash + Objects.hashCode(this.sexo);
        hash = 41 * hash + Objects.hashCode(this.tipo);
        hash = 41 * hash + Objects.hashCode(this.fechaIngreso);
        hash = 41 * hash + Objects.hashCode(this.ventas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        if (Double.doubleToLongBits(this.faltante) != Double.doubleToLongBits(other.faltante)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.rfc, other.rfc)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fechaNac, other.fechaNac)) {
            return false;
        }
        if (!Objects.equals(this.fechaIngreso, other.fechaIngreso)) {
            return false;
        }
        if (!Objects.equals(this.ventas, other.ventas)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public Object[] toArray() {
        return new Object[]{
            this.getId(),
            this.getTipo(),
            this.getNombre(),
            this.getFechaIngreso(),
            this.getFaltante(),
            this.getTelefono()
        };
    }

}
