import java.io.Serializable;

public class Usuario  implements Serializable {

    public static final long serialVersionUID=1L;

    private String nombre;
    private int edad;
    private String DNI;

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {

        this.edad = edad;
    }

    public String getDNI() {
        return DNI;
    }

    public boolean setDNI(String DNI) {

        if (DNI.length() > 8 && DNI.length() < 11) { //Longitud adecuada con y sin gui�n
            String numeros = DNI.substring(0, 7);//Para controlar solo los n�meros
            int letraDni = '0';
            try {
                char letra = (DNI.charAt(DNI.length() - 1));
                char mayusc = Character.toUpperCase(letra);
                letraDni = mayusc; //Convierte el caracter a su c�digo ASCCII
            } catch (Exception e) {
                System.out.println("El �ltimo s�mbolo debe ser una letra de la A a la Z, tal cual aparece en tu documento");
                return false;
            }
            if (letraDni < 91 && letraDni > 64) { //C�digo para letra de la A a la Z en may�sculas
                try {
                    Integer.parseInt(numeros);
                    if (DNI.length()==10 && DNI.charAt(8)=='-'){ //El caso de DNI introducido con gui�n
                        this.DNI = DNI;
                        return true;
                    }
                    else if (DNI.length()==9){ //El caso del DNI introducido sin gui�n
                        this.DNI = DNI;
                        return true;
                    }
                    else return  false;
                } catch (Exception e) {
                    return false;
                }
            }
            return false;
        } else return false;
    }

    public void setDni(String dni) {
        DNI = dni;
    }

    @Override
    public String toString() {
        return "Usuario nombre=" + nombre + '\'' +
                ", edad: " + edad +
                ", DNI: " + DNI ;
    }
}

