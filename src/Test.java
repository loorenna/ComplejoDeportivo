import java.util.Scanner;
public class Test {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        ReservaCancha reserva=new ReservaCancha();
        int op=0;
        do {
            try {
                System.out.println("====COMPLEJO DEPORTIVO====");
                System.out.println("1.Registrar cliente");
                System.out.println("2.Registrar pedido");
                System.out.println("3.Mostrar clientes");
                System.out.println("4.Buscar por cedula de cliente");
                System.out.println("5.Eliminar cliente");
                System.out.println("6.Mostrar pedidos");
                System.out.println("7.Actualizar pedido");
                System.out.println("8.Eliminar pedido");
                System.out.println("9.Calcular total de horas");
                System.out.println("10.Cliente con mayor reserva");
                System.out.println("11.Salir");
                System.out.println("Elije una opcion (1-11):");
                op=Integer.parseInt(sc.nextLine());
            }catch(NumberFormatException e){
                System.out.println("Debe ingresar solo numeros");
            }
            switch (op){
                case 1:{
                    Cliente c=new Cliente();
                    System.out.println("Nombre: ");
                    String nombre=sc.nextLine();
                    c.setNombre(nombre);
                    try{
                        System.out.println("Cedula: ");
                        String cedula=sc.nextLine();
                        c.setCédula(cedula);
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    try {
                        System.out.println("Edad: ");
                        int edad=Integer.parseInt(sc.nextLine());
                        c.setEdad(edad);
                    }catch (NumberFormatException e){
                        System.out.println("Debe ingresar solo numeros");
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    try {
                        System.out.println("Telefono: ");
                        String telefono=sc.nextLine();
                        c.setTeléfono(telefono);
                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    reserva.registrarCliente(c);
                    break;
                }
                case 2:{
                    System.out.println("Ingrese su cedula: ");
                    String cedula=sc.nextLine();
                    System.out.println("Ingrese las horas de reserva: ");
                    int horas=Integer.parseInt(sc.nextLine());
                    reserva.registrarReserva(cedula,horas);
                    break;
                }
                case 3:{
                    reserva.mostrarClientes();
                    break;
                }
                case 4:{
                    System.out.println("Ingrese la cedula: ");
                    String cedula=sc.nextLine();
                    reserva.buscarPorCedula(cedula);
                    break;
                }
                case 5:{
                    System.out.println("Ingrese la cedula: ");
                    String cedula= sc.nextLine();
                    System.out.println("Esta seguro de eliminar? (s/n): ");
                    String opcion=sc.nextLine();
                    if (opcion.equals("s")){
                        reserva.eliminarCliente(cedula);
                    }
                    break;
                }
                case 6:{
                    reserva.mostrarReservas();
                    break;
                }
                case 7: {
                    System.out.println("Ingrese la cedula: ");
                    String cedula = sc.nextLine();
                    System.out.println("Ingrese las nuevas horas: ");
                    int nuevasHoras=Integer.parseInt(sc.nextLine());
                    reserva.actualizarReserva(cedula,nuevasHoras);
                    break;
                }
                case 8:{
                    System.out.println("Ingrese la cedula: ");
                    String cedula=sc.nextLine();
                    reserva.eliminarReserva(cedula);
                    break;
                }
                case 9:{
                    reserva.calcularTotalDeHoras();
                    break;
                }
                case 10:{
                    reserva.clienteConMayorReserva();
                    break;
                }
                case 11:{
                    System.out.println("Saliendo del programa......");
                    break;
                }
            }

        }while (op!=11);
    }
}
