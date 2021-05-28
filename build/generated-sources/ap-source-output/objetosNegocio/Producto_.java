package objetosNegocio;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import objetosNegocio.Categoria;
import objetosNegocio.ProductoVenta;
import objetosNegocio.Proveedor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-28T15:56:33")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, Float> precioActual;
    public static volatile SingularAttribute<Producto, Categoria> categoria;
    public static volatile ListAttribute<Producto, ProductoVenta> ventas;
    public static volatile SingularAttribute<Producto, Proveedor> proveedor;
    public static volatile SingularAttribute<Producto, Integer> id;
    public static volatile SingularAttribute<Producto, Float> stock;
    public static volatile SingularAttribute<Producto, String> nombre;
    public static volatile SingularAttribute<Producto, String> codBarras;

}