package todopc;

public class Desktop extends Equipo {
    private final String tarjetaGrafica;
    private final String tamañoTorre;
    private final String capacidadDiscoDuro;
    private String imagenRuta;
    
    public Desktop(String fabricante, String modelo, String microprocesador, String tarjetaGrafica, String tamañoTorre, String capacidadDiscoDuro, String imagenRuta) {
        super(fabricante, modelo, microprocesador, imagenRuta);
        this.tarjetaGrafica = tarjetaGrafica;
        this.tamañoTorre = tamañoTorre;
        this.capacidadDiscoDuro = capacidadDiscoDuro;
        this.imagenRuta = imagenRuta;
    }

    public static Desktop crearDesktop(String fabricante, String modelo, String microprocesador, String tarjetaGrafica, String tamañoTorre, String capacidadDiscoDuro, String imagenRuta) {
        return new Desktop(fabricante, modelo, microprocesador, tarjetaGrafica, tamañoTorre, capacidadDiscoDuro, imagenRuta);
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
    
    public String getImagenRuta() {
        return imagenRuta;
    }
    
    public void setImagenRuta(String imagenRuta) {
        this.imagenRuta = imagenRuta;
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
