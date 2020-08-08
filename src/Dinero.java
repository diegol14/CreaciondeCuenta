import java.io.Serializable;

public abstract class Dinero implements Serializable {

    public static final long serialVersionUID=1L;

    protected double dinero;
    protected String description;

    //Metodos
    abstract double getDinero();

    abstract void setDinero(double Dinero);

    abstract String getDescription();

    abstract void setDescription(String description);

}

