//import java.io.IOException;
import java.io.Serializable;

public class GastoException extends  Exception implements Serializable
//RuntimeException La prob� como Runtime para no estar obligado a capturarla y que se disparara la excepci�n
{

   public static final long serialVersionUID=1L;
    private String message;

    // @Override
    public String getMessage() {
        return message;
    }

    public GastoException() {
        super();
        this.message="No se puede realizar la operaci�n por saldo insuficiente";
    }


}



