import java.io.Serializable;
import java.util.Scanner;

public class Main implements Serializable {

    public static final long serialVersionUID = 1L;

    public static void main(String[] args) {

        Usuario usuario = new Usuario();
        Scanner dataIn = new Scanner(System.in);
        String nom;
        do {
            System.out.println("Introduzca el nombre del usuario");
            nom = dataIn.nextLine();
            usuario.setNombre(nom);
        } while (nom.isEmpty());
        boolean edadOk = false;
        do {
            System.out.println("Introduzca la edad del usuario");
            try {
                int edad1 = Integer.parseInt(dataIn.nextLine());
                usuario.setEdad(edad1);
                edadOk = true;
            } catch (Exception e) {
                System.out.println("La edad no es correcta");
            }
        } while (!edadOk);

        String dni;
        do {
            System.out.println("Introduzca el DNI del usuario");
            dni = dataIn.nextLine();
            if (usuario.setDNI(dni)) System.out.println("Usuario creado correctamente");
            else {

                while (!usuario.setDNI(dni)) {
                    System.out.println("DNI introducido incorrecto\nIntroduzca el DNI del usuario válido");
                    dni = dataIn.nextLine();
                    if (usuario.setDNI(dni)) System.out.println("Usuario creado correctamente");
                    break;
                }
            }
        } while (!usuario.setDNI(dni));
        //System.out.println(usuario.toString());
        Cuenta cuenta01 = new Cuenta(usuario);

        int accion = 100;
        String description1 = "";
        double dinero1 = 0;
        do {
            boolean eleccion = false;
            do {    //Menu
                System.out.println("Realiza una nueva acción\n1 Introduce un nuevo gasto\n2 Introduce un nuevo ingreso" +
                        "\n3 Mostrar gastos\n4 Mostrar ingresos\n5 Mostrar saldo\n0 Salir");
                try {   //Comprobar case correcto
                    String decision = dataIn.nextLine();
                    accion = Integer.parseInt(decision);
                    if (accion >= 0 && accion < 6) eleccion = true;
                } catch (Exception e) {
                    System.out.println("Elige un número entre el 0 y el 5");
                }
            } while (!eleccion);
            switch (accion) {
                case 1: //Nuevo gasto
                    try {
                        do {
                            System.out.println("Introduce la descripción");
                            description1 = dataIn.nextLine();
                        } while (description1.isEmpty());
                        System.out.println("Introduce la cantidad");
                        dinero1 = Double.parseDouble(dataIn.nextLine());
                        cuenta01.addGastos(description1, dinero1);
                        System.out.println("Saldo restante: " + cuenta01.getSaldo());
                    } catch (GastoException e) {
                        System.out.println(e.getMessage());
                    } catch (NumberFormatException e) {
                        System.out.println("No has ingresado una cantidad correcta");
                    }
                    break;
                case 2:  //Nuevo ingreso
                    try {
                        do {
                            System.out.println("Introduce la descripción");
                            description1 = dataIn.nextLine();
                        } while (description1.isEmpty());
                        System.out.println("Introduce la cantidad");
                        dinero1 = Double.parseDouble(dataIn.nextLine());
                        cuenta01.addIngresos(description1, dinero1);
                        System.out.println("Saldo restante: " + cuenta01.getSaldo());
                    } catch (NumberFormatException e) {
                        System.out.println("No has ingresado una cantidad correcta");
                    }
                    break;
                case 3:
                    System.out.println("Lista de gastos: ");
                    cuenta01.imprimirList(cuenta01.getGastos());
                    break;
                case 4:
                    System.out.println("Lista de ingresos: ");
                    cuenta01.imprimirList(cuenta01.getIngresos());
                    break;
                case 5:
                    System.out.println("El saldo de la cuenta es: " + cuenta01.getSaldo());
                    break;
                case 0:
                    System.out.println("Fin del programa.\nGracias por utilizar la aplicación");
                    dataIn.close();
                    System.exit(0);
                    break;
            }
        } while (accion != 0);

    }
}
