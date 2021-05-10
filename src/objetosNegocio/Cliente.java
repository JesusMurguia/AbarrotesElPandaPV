
package objetosNegocio;

import java.io.Serializable;
import java.util.ArrayList;
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

/**
 *
 * @author GPE
 */
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    //private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcliente")
    private Integer id;
    
    @Column(name = "direccion", length = 100, nullable = false)
    private String direccion;
    
    @Column(name = "nombre", length = 45, nullable = false)
    private String nombre;

    @Column(name = "rfc", length = 15, nullable = false)
    private String rfc;

    @Column(name = "telefono1", length = 15, nullable = true)
    private String telefono1;

    @Column(name = "adeudo", length = 15, nullable = true)
    private double adeudo;
    
    @Column(name = "limiteCredito", length = 15, nullable = true)
    private double limiteCredito;
    
    @Column(name = "NIP", length = 15, nullable = true)
    private String nip;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Venta> ventas;

    public Cliente() {
        this.ventas = new ArrayList<>();
    }

    public Cliente( String direccion, String nombre, String rfc, String telefono1, double adeudo, double limiteCredito) {
        this.direccion = direccion;
        this.nombre = nombre;
        this.rfc = rfc;
        this.telefono1 = telefono1;
        this.adeudo = adeudo;
        this.limiteCredito = limiteCredito;
    }

    public Integer getId() {
        return id;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
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

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public double getAdeudo() {
        return adeudo;
    }

    public void setAdeudo(double adeudo) {
        this.adeudo = adeudo;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(double limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.direccion);
        hash = 59 * hash + Objects.hashCode(this.nombre);
        hash = 59 * hash + Objects.hashCode(this.rfc);
        hash = 59 * hash + Objects.hashCode(this.telefono1);
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.adeudo) ^ (Double.doubleToLongBits(this.adeudo) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.limiteCredito) ^ (Double.doubleToLongBits(this.limiteCredito) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.ventas);
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
        final Cliente other = (Cliente) obj;
        if (Double.doubleToLongBits(this.adeudo) != Double.doubleToLongBits(other.adeudo)) {
            return false;
        }
        if (Double.doubleToLongBits(this.limiteCredito) != Double.doubleToLongBits(other.limiteCredito)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.rfc, other.rfc)) {
            return false;
        }
        if (!Objects.equals(this.telefono1, other.telefono1)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
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
    
    public Object[] toArray(){
        return new Object[]{
            this.getId(),
            this.getNombre(),
            this.getRfc(),
            this.getDireccion(),
            this.getTelefono1(),
            this.getAdeudo()
        };
    }
    
}
