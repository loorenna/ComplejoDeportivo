import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
public class ReservaCancha implements CrudReserva{
    private HashSet<Cliente> clientes= new HashSet<>();
    private Map<String, Integer> mapaReservas = new HashMap<>();

    public ReservaCancha() {
    }

    @Override
    public void registrarCliente(Cliente cliente) {
        if (!clientes.add(cliente)){
            System.out.println("Cliente duplicado");
            return;
        }
        System.out.println("Cliente registrado correctamente");
    }

    @Override
    public void registrarReserva(String cedula,int horas) {
        for (Cliente c:clientes){
            if (c.getCédula().equals(cedula)){
                mapaReservas.put(cedula,horas);
                System.out.println("Reserva registrada correctamente");
                return;
            }
        }
        System.out.println("Cliente no encontrado");
    }

    @Override
    public void actualizarReserva(String cedula,int nuevasHoras) {
        if (mapaReservas.isEmpty()){
            System.out.println("No hay reservas registradas");
            return;
        }
        for (Cliente c:clientes){
            if (c.getCédula().equals(cedula)){
                if (!mapaReservas.containsKey(c.getCédula())){
                    System.out.println("La reserva no existe");
                    return;
                }
                mapaReservas.put(cedula,nuevasHoras);
                System.out.println("Reserva actualizada");
                return;
            }
        }
        System.out.println("Cliente no encontrado");
    }

    @Override
    public void mostrarReservas() {
        if (mapaReservas.isEmpty()){
            System.out.println("No hay resrvas registradas");
            return;
        }
        for (String ced:mapaReservas.keySet()){
            System.out.println("Cedula: "+ced+" | Horas: "+mapaReservas.get(ced));
            System.out.println("-----------------------------");
        }
    }
    @Override
    public void mostrarClientes(){
        if (clientes.isEmpty()){
            System.out.println("No hya clientes registrados");
            return;
        }
        for (Cliente c:clientes){
            System.out.println(c);
            System.out.println("________________________________");
        }
    }
    @Override
    public void eliminarReserva(String cedula) {
        if (mapaReservas.isEmpty()){
            System.out.println("No hay reservas registradas");
            return;
        }
        for (Cliente c:clientes){
            if (c.getCédula().equals(cedula)){
                if (!mapaReservas.containsKey(c.getCédula())){
                    System.out.println("La reserva no existe");
                    return;
                }
                mapaReservas.remove(c.getCédula());
                System.out.println("Reserva eliminada correctamente");
                return;
            }
        }
        System.out.println("Cliente no encontrado");

    }

    @Override
    public void calcularTotalDeHoras() {
        if (mapaReservas.isEmpty()){
            System.out.println("No hay reservas registradas");
            return;
        }
        double suma=0;
        for (int h:mapaReservas.values()){
            suma+=h;
        }
        System.out.println("Total de horas: "+suma);

    }

    @Override
    public void clienteConMayorReserva() {
        if (mapaReservas.isEmpty()){
            System.out.println("No hay reservas registradas");
            return;
        }
        String clienteMayor=null;
        int mayor=0;
        for (String cli: mapaReservas.keySet()){
            if (mapaReservas.get(cli)>mayor){
                mayor=mapaReservas.get(cli);
                clienteMayor=cli;
            }
        }
        for (Cliente c:clientes){
            if (c.getCédula().equals(clienteMayor)){
                System.out.println(c);
                System.out.println("Horas: "+mayor);
                return;
            }
        }
    }
    @Override
    public void buscarPorCedula(String cedula){
        for (Cliente c:clientes){
            if (c.getCédula().equals(cedula)){
                System.out.println(c);
                return;
            }
        }
        System.out.println("Cliente no encontrado");
    }
    @Override
    public void eliminarCliente(String cedula){
        if (clientes.isEmpty()){
            System.out.println("No hay clientes registrados");
            return;
        }
        Cliente eliminar=null;
        for (Cliente c:clientes){
            if (c.getCédula().equals(cedula)){
                eliminar=c;
                break;
            }
        }
        if (eliminar!=null){
            clientes.remove(eliminar);
            mapaReservas.remove(eliminar.getCédula());
            System.out.println("Cliente eliminado correctamente");
        }
    }
}
