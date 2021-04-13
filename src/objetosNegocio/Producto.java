package objetosNegocio;

import java.io.Serializable;
import java.util.ArrayList;
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

/**
 *
 * @author GPE
 */
@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    //private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproducto", length = 11, nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "precio_actual", nullable = false)
    private Float precioActual;

    @Column(name = "stock", length = 11, nullable = false)
    private Float stock;

    @ManyToOne(optional = false, targetEntity = Proveedor.class)
    @JoinColumn(name = "idproveedor")
    private Proveedor proveedor;

    @ManyToOne(optional = false, targetEntity = Categoria.class)
    @JoinColumn(name = "idcategoria")
    private Categoria categoria;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<ProductoVenta> ventas;

    @Column(name = "codBarras", length = 100, nullable = false)
    private String codBarras;

    public Producto() {
        this.ventas = new ArrayList<>();
    }

    public Producto(String nombre, Float precioActual, float stock, Proveedor proveedor, Categoria categoria, String codBarras) {
        this.nombre = nombre;
        this.precioActual = precioActual;
        this.stock = stock;
        this.proveedor = proveedor;
        this.categoria = categoria;
        this.codBarras = codBarras;
    }

    public void addVenta(ProductoVenta venta) {
        venta.setProducto(this);
        this.ventas.add(venta);
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public List<ProductoVenta> getProductos() {
        return ventas;
    }

    public void setProductos(List<ProductoVenta> productos) {
        this.ventas = productos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(Float precioActual) {
        this.precioActual = precioActual;
    }

    public Float getStock() {
        return stock;
    }

    public void setStock(Float stock) {
        this.stock = stock;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "objetosNegocio.Producto[ id=" + id + " ]";
    }

    public Object[] toArray() {
        return new Object[]{
            this.getId(),
            this.getCodBarras(),
            this.getNombre(),
            this.getPrecioActual(),
            this.getStock()
        };
    }

    public Object[] toArrayProductosExistentes() {
        return new Object[]{
            this.getId(),
            this.getCodBarras(),
            this.getNombre(),
            this.getPrecioActual(),
            this.getStock()
        };
    }

}
