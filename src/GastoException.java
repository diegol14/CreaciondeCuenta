//import java.io.IOException;
import java.io.Serializable;

public class GastoException extends  Exception implements Serializable
//RuntimeException La probé como Runtime para no estar obligado a capturarla y que se disparara la excepción
{

   public static final long serialVersionUID=1L;
    private String message;

    // @Override
    public String getMessage() {
        return message;
    }

    public GastoException() {
        super();
        this.message="No se puede realizar la operación por saldo insuficiente";
    }


}



