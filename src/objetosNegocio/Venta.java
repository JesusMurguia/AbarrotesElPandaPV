
package objetosNegocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author GPE
 */
@Entity
@Table(name = "ventas")
public class Venta implements Serializable {

   //private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idventa", length = 11)
    private Integer id;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @ManyToOne(optional = true)
    @JoinColumn(name = "idcliente")
    private Cliente cliente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idempleado")
    private Empleado empleado;

    @Column(name = "total", nullable = false)
    private Float total;

    @Column(name = "formaDePago", nullable = true)
    private String formaDePago;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta")
    private List<ProductoVenta> productos;

    public Venta() {
        this.productos = new ArrayList<>();
    }

    public Venta(Date fecha, Cliente cliente, Float total, String formaDePago) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.total = total;
        this.formaDePago = formaDePago;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void addProducto(ProductoVenta producto) {
        producto.setVenta(this);
        this.productos.add(producto);
    }

    public List<ProductoVenta> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoVenta> productos) {
        this.productos = productos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getFormaDePago() {
        return formaDePago;
    }

    public void setFormaDePago(String formaDePago) {
        this.formaDePago = formaDePago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "objetosNegocio.Venta[ id=" + id + " ]";
    }

    public Object[] toArray() {
        Float subtotal = 0F;
        for (ProductoVenta producto : productos) {
            subtotal += producto.getMontoTotal();
        }
        return new Object[]{
            this.getId(),
            this.getCliente(),
            this.getFecha().toLocaleString(),
            subtotal,
            this.getTotal()
        };
    }
}
