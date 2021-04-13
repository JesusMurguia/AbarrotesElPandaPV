
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
@Table(name = "balances")
public class Balance implements Serializable {

  //  private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idbalance", length = 11)
    private Integer id;

    @Column(name = "efectivoRetirado", length = 100, nullable = true)
    private double efectivoRetirado;
    
    @Column(name = "vaucherRetirado", length = 100, nullable = true)
    private double vaucherRetirado;
    
    @Column(name = "efectivoIngresado", length = 100, nullable = true)
    private double efectivoIngresado;
    
    @Column(name = "vaucherIngresado", length = 100, nullable = true)
    private double vaucherIngresado;
    
    @Column(name = "credito", length = 100, nullable = true)
    private double credito;
    
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @Column(name = "diferencia", length = 100, nullable = true)
    private double diferencia;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idempleado", nullable = false)
    private Empleado empleado;

    public Balance() {
    }

    public Balance(Integer id, double efectivoRetirado, double vaucherRetirado, double efectivoIngresado, double vaucherIngresado, double credito, Date fecha, double diferencia, Empleado empleado) {
        this.id = id;
        this.efectivoRetirado = efectivoRetirado;
        this.vaucherRetirado = vaucherRetirado;
        this.efectivoIngresado = efectivoIngresado;
        this.vaucherIngresado = vaucherIngresado;
        this.credito = credito;
        this.fecha = fecha;
        this.diferencia = diferencia;
        this.empleado = empleado;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getEfectivoRetirado() {
        return efectivoRetirado;
    }

    public void setEfectivoRetirado(double efectivoRetirado) {
        this.efectivoRetirado = efectivoRetirado;
    }

    public double getVaucherRetirado() {
        return vaucherRetirado;
    }

    public void setVaucherRetirado(double vaucherRetirado) {
        this.vaucherRetirado = vaucherRetirado;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(double diferencia) {
        this.diferencia = diferencia;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public double getEfectivoIngresado() {
        return efectivoIngresado;
    }

    public void setEfectivoIngresado(double efectivoIngresado) {
        this.efectivoIngresado = efectivoIngresado;
    }

    public double getVaucherIngresado() {
        return vaucherIngresado;
    }

    public void setVaucherIngresado(double vaucherIngresado) {
        this.vaucherIngresado = vaucherIngresado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.efectivoRetirado) ^ (Double.doubleToLongBits(this.efectivoRetirado) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.vaucherRetirado) ^ (Double.doubleToLongBits(this.vaucherRetirado) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.credito) ^ (Double.doubleToLongBits(this.credito) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.fecha);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.diferencia) ^ (Double.doubleToLongBits(this.diferencia) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.empleado);
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
        final Balance other = (Balance) obj;
        if (Double.doubleToLongBits(this.efectivoRetirado) != Double.doubleToLongBits(other.efectivoRetirado)) {
            return false;
        }
        if (Double.doubleToLongBits(this.vaucherRetirado) != Double.doubleToLongBits(other.vaucherRetirado)) {
            return false;
        }
        if (Double.doubleToLongBits(this.credito) != Double.doubleToLongBits(other.credito)) {
            return false;
        }
        if (Double.doubleToLongBits(this.diferencia) != Double.doubleToLongBits(other.diferencia)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        if (!Objects.equals(this.empleado, other.empleado)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Balance{" + "id=" + id + ", efectivoRetirado=" + efectivoRetirado + ", vaucherRetirado=" + vaucherRetirado + ", credito=" + credito + ", fecha=" + fecha + ", diferencia=" + diferencia + ", empleado=" + empleado + '}';
    }

    
    public Object[] toArray() {
        return new Object[]{
            this.getId(),
            this.getEmpleado().getId(),
            this.getEfectivoIngresado(),
            this.getEfectivoRetirado(),
            this.getVaucherIngresado(),
            this.getVaucherRetirado(),
            this.getCredito(),
            this.getDiferencia()
        };
    }
}
