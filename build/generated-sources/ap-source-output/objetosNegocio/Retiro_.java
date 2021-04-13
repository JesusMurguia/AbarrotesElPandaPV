package objetosNegocio;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import objetosNegocio.Empleado;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-22T21:46:02")
@StaticMetamodel(Retiro.class)
public class Retiro_ { 

    public static volatile SingularAttribute<Retiro, String> tipo;
    public static volatile SingularAttribute<Retiro, Empleado> empleado;
    public static volatile SingularAttribute<Retiro, Integer> id;
    public static volatile SingularAttribute<Retiro, Double> cantidad;

}