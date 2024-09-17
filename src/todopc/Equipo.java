package todopc;

public abstract class Equipo {
    private final String fabricante;
    private final String modelo;
    private final String microprocesador;

    public Equipo(String fabricante, String modelo, String microprocesador) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.microprocesador = microprocesador;
    }

    public String getFabricante() {
        return fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMicroprocesador() {
        return microprocesador;
    }

    public String toString() {
        return "Fabricante: " + fabricante +
                "\nModelo: " + modelo +
                "\nMicroprocesador: " + microprocesador;
    }
    
    public abstract String getTipoEquipo();
}

