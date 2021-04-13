package objetosNegocio;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import objetosNegocio.Empleado;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-22T21:46:02")
@StaticMetamodel(Balance.class)
public class Balance_ { 

    public static volatile SingularAttribute<Balance, Date> fecha;
    public static volatile SingularAttribute<Balance, Double> efectivoRetirado;
    public static volatile SingularAttribute<Balance, Double> vaucherIngresado;
    public static volatile SingularAttribute<Balance, Empleado> empleado;
    public static volatile SingularAttribute<Balance, Double> credito;
    public static volatile SingularAttribute<Balance, Double> efectivoIngresado;
    public static volatile SingularAttribute<Balance, Integer> id;
    public static volatile SingularAttribute<Balance, Double> diferencia;
    public static volatile SingularAttribute<Balance, Double> vaucherRetirado;

}