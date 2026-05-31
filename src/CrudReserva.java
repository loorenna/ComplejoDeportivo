public interface CrudReserva {
    public  void registrarCliente(Cliente cliente);
    public  void registrarReserva(String cedula,int horas);
    public  void actualizarReserva(String cedula,int nuevasHoras);
    public void mostrarReservas();
    public void eliminarReserva(String cedula);
    public void calcularTotalDeHoras();
    public void clienteConMayorReserva();
    public void  buscarPorCedula(String cedula);
    public void mostrarClientes();
    public void eliminarCliente(String cedula);
}
