package todopc;

public class Desktop extends Equipo {
    private String tarjetaGrafica;
    private String tamañoTorre;
    private String capacidadDiscoDuro;

    // Constructor de la clase Desktop
    public Desktop(String fabricante, String modelo, String microprocesador, String tarjetaGrafica, String tamañoTorre, String capacidadDiscoDuro) {
        super(fabricante, modelo, microprocesador);
        this.tarjetaGrafica = tarjetaGrafica;
        this.tamañoTorre = tamañoTorre;
        this.capacidadDiscoDuro = capacidadDiscoDuro;
    }

    // Método estático de fábrica
    public static Desktop crearDesktop(String fabricante, String modelo, String microprocesador, String tarjetaGrafica, String tamañoTorre, String capacidadDiscoDuro) {
        return new Desktop(fabricante, modelo, microprocesador, tarjetaGrafica, tamañoTorre, capacidadDiscoDuro);
    }

    // Getters y setters
    public String getTarjetaGrafica() {
        return tarjetaGrafica;
    }

    public void setTarjetaGrafica(String tarjetaGrafica) {
        this.tarjetaGrafica = tarjetaGrafica;
    }

    public String getTamañoTorre() {
        return tamañoTorre;
    }

    public void setTamañoTorre(String tamañoTorre) {
        this.tamañoTorre = tamañoTorre;
    }

    public String getCapacidadDiscoDuro() {
        return capacidadDiscoDuro;
    }

    public void setCapacidadDiscoDuro(String capacidadDiscoDuro) {
        this.capacidadDiscoDuro = capacidadDiscoDuro;
    }
}
