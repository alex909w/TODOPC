package todopc;

public class Tablet extends Equipo {
    private final String tamañoPantalla;
    private final String tipoPantalla;
    private final String tamañoMemoriaNAND;
    private final String sistemaOperativo;

    public Tablet(String fabricante, String modelo, String microprocesador, String tamañoPantalla, String tipoPantalla, String tamañoMemoriaNAND, String sistemaOperativo) {
        super(fabricante, modelo, microprocesador);

        if (tamañoPantalla == null || tamañoPantalla.trim().isEmpty()) {
            throw new IllegalArgumentException("El tamaño de pantalla no puede estar vacío");
        }
        if (tipoPantalla == null || tipoPantalla.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de pantalla no puede estar vacío");
        }
        
        if (tamañoMemoriaNAND == null || tamañoMemoriaNAND.trim().isEmpty()) {
            throw new IllegalArgumentException("El tamaño de la memoria NAND no puede estar vacío");
        }
        if (sistemaOperativo == null || sistemaOperativo.trim().isEmpty()) {
            throw new IllegalArgumentException("El sistema operativo no puede estar vacío");
        }

        this.tamañoPantalla = tamañoPantalla;
        this.tipoPantalla = tipoPantalla;
        this.tamañoMemoriaNAND = tamañoMemoriaNAND;
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getTamañoPantalla() {
        return tamañoPantalla;
    }

    public String getTipoPantalla() {
        return tipoPantalla;
    }

    public String getTamañoMemoriaNAND() {
        return tamañoMemoriaNAND;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    @Override
    public String getTipoEquipo() {
        return "Tablet";
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nTamaño de pantalla: " + tamañoPantalla +
               "\nTipo de pantalla: " + tipoPantalla +
               "\nTamaño de memoria NAND: " + tamañoMemoriaNAND +
               "\nSistema Operativo: " + sistemaOperativo;
    }
}
