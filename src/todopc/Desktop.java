package todopc;

public class Desktop extends Equipo {
    private final String tarjetaGrafica;
    private final String tamañoTorre;
    private final String capacidadDiscoDuro;

    public Desktop(String fabricante, String modelo, String microprocesador, String tarjetaGrafica, String tamañoTorre, String capacidadDiscoDuro) {
        super(fabricante, modelo, microprocesador);
        this.tarjetaGrafica = tarjetaGrafica;
        this.tamañoTorre = tamañoTorre;
        this.capacidadDiscoDuro = capacidadDiscoDuro;
    }

    public static Desktop crearDesktop(String fabricante, String modelo, String microprocesador, String tarjetaGrafica, String tamañoTorre, String capacidadDiscoDuro) {
        return new Desktop(fabricante, modelo, microprocesador, tarjetaGrafica, tamañoTorre, capacidadDiscoDuro);
    }

    public String getTarjetaGrafica() {
        return tarjetaGrafica;
    }

    public String getTamañoTorre() {
        return tamañoTorre;
    }

    public String getCapacidadDiscoDuro() {
        return capacidadDiscoDuro;
    }

    @Override
    public String getTipoEquipo() {
        return "Desktop";
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nTarjeta Gráfica: " + tarjetaGrafica +
               "\nTamaño de Torre: " + tamañoTorre +
               "\nCapacidad de Disco Duro: " + capacidadDiscoDuro;
    }
}
