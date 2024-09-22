package todopc;

public abstract class Equipo {
    private final String fabricante;
    private final String modelo;
    private final String microprocesador;
    private String rutaImagen;

    public Equipo(String fabricante, String modelo, String microprocesador, String rutaImagen) {
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.microprocesador = microprocesador;
        this.rutaImagen = rutaImagen;
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
    
    public String getRutaImagen() {
        return rutaImagen;
    }
    
    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public String toString() {
        return "Fabricante: " + fabricante +
                "\nModelo: " + modelo +
                "\nMicroprocesador: " + microprocesador;
    }
    
    public abstract String getTipoEquipo();
}

