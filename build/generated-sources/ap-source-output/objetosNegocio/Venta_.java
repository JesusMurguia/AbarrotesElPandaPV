package objetosNegocio;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import objetosNegocio.Cliente;
import objetosNegocio.Empleado;
import objetosNegocio.ProductoVenta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-28T15:56:33")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Date> fecha;
    public static volatile SingularAttribute<Venta, Cliente> cliente;
    public static volatile SingularAttribute<Venta, Float> total;
    public static volatile SingularAttribute<Venta, Empleado> empleado;
    public static volatile SingularAttribute<Venta, Integer> id;
    public static volatile SingularAttribute<Venta, String> formaDePago;
    public static volatile ListAttribute<Venta, ProductoVenta> productos;

}