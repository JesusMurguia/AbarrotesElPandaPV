package objetosNegocio;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author GPE
 */
@Entity
@Table(name = "retiros")
public class Retiro implements Serializable {

    //private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idretiro", length = 11)
    private Integer id;

    @Column(name = "tipo", length = 45, nullable = true)
    private String tipo;

    @Column(name = "cantidad", length = 100, nullable = true)
    private double cantidad;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idempleado", nullable = false)
    private Empleado empleado;

    @Column(name = "fecha", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    public Retiro() {
    }

    public Retiro(Integer id, String tipo, double cantidad, Empleado empleado, Date fecha) {
        this.id = id;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.empleado = empleado;
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.tipo);
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.cantidad) ^ (Double.doubleToLongBits(this.cantidad) >>> 32));
        hash = 79 * hash + Objects.hashCode(this.empleado);
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
        final Retiro other = (Retiro) obj;
        if (Double.doubleToLongBits(this.cantidad) != Double.doubleToLongBits(other.cantidad)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.empleado, other.empleado)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Retiro{" + "id=" + id + ", tipo=" + tipo + ", cantidad=" + cantidad + ", empleado=" + empleado + '}';
    }

    public Object[] toArray() {
        return new Object[]{
            this.getId(),
            this.getEmpleado().getId(),
            this.getTipo(),
            this.getCantidad(),
            this.getFecha()
        };
    }
}
