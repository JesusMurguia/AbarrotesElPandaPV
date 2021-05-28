package objetosNegocio;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import objetosNegocio.Balance;
import objetosNegocio.Retiro;
import objetosNegocio.Venta;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-05-28T15:56:33")
@StaticMetamodel(Empleado.class)
public class Empleado_ { 

    public static volatile SingularAttribute<Empleado, String> tipo;
    public static volatile SingularAttribute<Empleado, String> direccion;
    public static volatile SingularAttribute<Empleado, String> nombre;
    public static volatile SingularAttribute<Empleado, String> rfc;
    public static volatile SingularAttribute<Empleado, Date> fechaNac;
    public static volatile SingularAttribute<Empleado, Double> faltante;
    public static volatile SingularAttribute<Empleado, Date> fechaIngreso;
    public static volatile ListAttribute<Empleado, Balance> balances;
    public static volatile ListAttribute<Empleado, Venta> ventas;
    public static volatile SingularAttribute<Empleado, String> contrasenia;
    public static volatile SingularAttribute<Empleado, Integer> id;
    public static volatile SingularAttribute<Empleado, String> telefono;
    public static volatile SingularAttribute<Empleado, String> sexo;
    public static volatile ListAttribute<Empleado, Retiro> retiros;

}