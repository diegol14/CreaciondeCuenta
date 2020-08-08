import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cuenta implements Serializable {

    public static final long serialVersionUID = 1L;

    private double saldo;
    private Usuario usuario;
    private List<Gasto> gastos = new ArrayList<>();
    private List<Ingreso> ingresos = new ArrayList<>();


    public Cuenta(Usuario usuario) {
        this.saldo = 0;
        this.usuario = usuario;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    //Método que crea un ingreso, lo agrega a ingresos y ajusta el saldo
    public double addIngresos(String description, double cantidad) {
        Ingreso ingreso = new Ingreso(cantidad, description);
        ingresos.add(ingreso);
        saldo += cantidad;
        return saldo;
    }
    //Método que comprueba si se puede realizar el gasto, si no no lo hace y avisa.
    // Crea un gasto, lo agrega a gastos y ajusta el saldo
    public double addGastos(String description, double cantidad) throws GastoException {
        if ((saldo - cantidad) < 0) {
            GastoException e = new GastoException();
            throw e;
        } else {
            Gasto gasto = new Gasto(cantidad, description);
            gastos.add(gasto);
            saldo -= cantidad;
        }
        return saldo;
    }

    public List<Ingreso> getIngresos() {
        return ingresos;
    }

    public List<Gasto> getGastos() {
        return gastos;
    }
    //Método que imprime las listas con un formato
    public void imprimirList(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
    }

    @Override
    public String toString() {
        return "Usuario: " + usuario.getNombre() + "saldo: " + getSaldo() + "€";
    }

}
