import java.io.Serializable;

public class Gasto extends Dinero implements Serializable {

    public static final long serialVersionUID=1L;

    public Gasto(double gasto,String description) {
        dinero=gasto;
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
        return  "Gasto: "+getDescription()+" "+ getDinero()+"";
    }
}

