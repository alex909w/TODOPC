package todopc;

public class Laptop extends Equipo {
    private final String memoria;
    private final String tamañoPantalla;
    private final String capacidadDiscoDuro;
    private final String rutaImagen;

    public Laptop(String fabricante, String modelo, String microprocesador, String memoria, String tamañoPantalla, String capacidadDiscoDuro, String rutaImagen) {
        super(fabricante, modelo, microprocesador, rutaImagen);
        this.memoria = memoria;
        this.tamañoPantalla = tamañoPantalla;
        this.capacidadDiscoDuro = capacidadDiscoDuro;
        this.rutaImagen = rutaImagen;
    }
    
    public String getRutaImagen() {
        return rutaImagen;
    }

    @Override
    public String getTipoEquipo() {
        return "Laptop";
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nMemoria: " + memoria +
               "\nTamaño de pantalla: " + tamañoPantalla +
               "\nCapacidad de Disco Duro: " + capacidadDiscoDuro;
    }
}
