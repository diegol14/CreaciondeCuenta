import java.io.Serializable;

public class Ingreso extends Dinero implements Serializable {

    public static final long serialVersionUID=1L;

    public Ingreso(double ingreso,String description) {
        dinero= ingreso;
        this.description=description;
    }
    @Override
    public String getDescription(){
        return description;
    }
    @Override
    protected void setDescription(String description) { this.description=description; }
    @Override
    public double getDinero() {
        return dinero;
    }
    @Override
    public void setDinero(double dinero) {
        this.dinero=dinero;
    }
    @Override
    public String toString() {
        return  "Ingreso: "+getDescription()+" "+ getDinero()+"";
    }
}

