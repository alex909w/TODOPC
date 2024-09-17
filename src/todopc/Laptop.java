package todopc;

public class Laptop extends Equipo {
    private String memoria;
    private String tamañoPantalla;
    private String capacidadDiscoDuro;

    public Laptop(String fabricante, String modelo, String microprocesador, String memoria, String tamañoPantalla, String capacidadDiscoDuro) {
        super(fabricante, modelo, microprocesador);
        this.memoria = memoria;
        this.tamañoPantalla = tamañoPantalla;
        this.capacidadDiscoDuro = capacidadDiscoDuro;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nMemoria: " + memoria +
                "\nTamaño de pantalla: " + tamañoPantalla +
                "\nCapacidad de disco duro: " + capacidadDiscoDuro;
    }
}
