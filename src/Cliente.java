import java.util.Objects;

public class Cliente {
    private String nombre;
    private String cédula;
    private int edad;
    private String teléfono;
    Cliente(){}

    public String getNombre() {
        return nombre;
    }

    public String getCédula() {
        return cédula;
    }

    public int getEdad() {
        return edad;
    }

    public String getTeléfono() {
        return teléfono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCédula(String cédula) {
        if (cédula.length()!=10){
            throw new IllegalArgumentException("La cedula debe tener 10 dijitos");
        }
        this.cédula = cédula;
    }

    public void setEdad(int edad) {
        if (edad<15 || edad>60){
            throw new IllegalArgumentException("Edad invalida");
        }
        this.edad = edad;
    }

    public void setTeléfono(String teléfono) {
        if (!teléfono.matches("\\d+")){
            throw new IllegalArgumentException("El telefono debe tener solo numeros");
        }
        this.teléfono = teléfono;
    }
    //el \\d{5} es para validar numeros de longitud exacta
    //el \\d+ validar q tenga digitos numericos
    //el \\d+(\\.\\d+)? para validar q el digito sea un numero decimal
    //el -?\\d+ para validar q el digito sea un numero negativo


    @Override
    public String toString() {
        return "-------DATOS------\n" +
                "nombre=" + nombre + "\n" +
                "cédula=" + cédula + "\n" +
                "edad=" + edad +"\n"+
                "teléfono=" + teléfono;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cédula, cliente.cédula);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cédula);
    }
}
