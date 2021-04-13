/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author GPE
 */
@Entity
@Table(name = "proveedores")
public class Proveedor implements Serializable {

    //private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproveedor", length = 11)
    private Integer id;

    @Column(name = "rfc", length = 15, nullable = false)
    private String rfc;

    @Column(name = "nombre", length = 45, nullable = false)
    private String nombre;

    @Column(name = "telefono", length = 20, nullable = true)
    private String telefono;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedor")
    private List<Producto> productos;

    public Proveedor() {
        this.productos = new ArrayList<>();
    }

    public Proveedor(String rfc, String nombre, String direccion, String telefono, String paginaweb) {
        this.rfc = rfc;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + " (" + nombre + ")";
    }

    public Object[] toArray() {
        return new Object[]{
            this.getId(),
            this.getRfc(),
            this.getNombre(),
            this.getTelefono(),
        };
    }

}
