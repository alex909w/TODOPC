import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import todopc.Equipo;
import todopc.Desktop;
import todopc.Laptop;
import todopc.Tablet;

public class TodoPC {
    private final List<Equipo> equipos;
    private final JFrame frame;
    private final JPanel panelPrincipal;
    private final CardLayout cardLayout;

    public TodoPC() {
        equipos = new ArrayList<>();
        frame = new JFrame("Gestión de Equipos - TODOPC");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);

        panelPrincipal.add(crearPanelMenu(), "Menu");
        panelPrincipal.add(crearPanelRegistro("Desktop"), "RegistrarDesktop");
        panelPrincipal.add(crearPanelRegistro("Laptop"), "RegistrarLaptop");
        panelPrincipal.add(crearPanelRegistro("Tablet"), "RegistrarTablet");

        frame.add(panelPrincipal);
        frame.setVisible(true);
    }

private JPanel crearPanelMenu() {
         JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Márgenes de 10 píxeles alrededor de los botones
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        // Espacio adicional en la parte superior
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weighty = 0.1;
        panel.add(Box.createRigidArea(new Dimension(0, 20)), gbc);

        JLabel titulo = new JLabel("Menú Principal");
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weighty = 0.1;
        panel.add(titulo, gbc);

        // Botones
        JButton btnRegistrarDesktop = new JButton("Registrar Desktop");
        JButton btnRegistrarLaptop = new JButton("Registrar Laptop");
        JButton btnRegistrarTablet = new JButton("Registrar Tablet");
        JButton btnVerEquipos = new JButton("Ver Equipos");
        JButton btnSalir = new JButton("Salir");

        // Ajustar tamaño de botones
        Dimension botonDimension = new Dimension(30, 55); // Ajustar el tamaño de los botones
        btnRegistrarDesktop.setPreferredSize(botonDimension);
        btnRegistrarLaptop.setPreferredSize(botonDimension);
        btnRegistrarTablet.setPreferredSize(botonDimension);
        btnVerEquipos.setPreferredSize(botonDimension);
        btnSalir.setPreferredSize(new Dimension(300, 60)); // Botón de salir un poco más grande

        btnRegistrarDesktop.addActionListener(e -> cardLayout.show(panelPrincipal, "RegistrarDesktop"));
        btnRegistrarLaptop.addActionListener(e -> cardLayout.show(panelPrincipal, "RegistrarLaptop"));
        btnRegistrarTablet.addActionListener(e -> cardLayout.show(panelPrincipal, "RegistrarTablet"));
        btnVerEquipos.addActionListener(e -> mostrarEquipos());
        btnSalir.addActionListener(e -> System.exit(0));

        // Botones a la izquierda
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weightx = 0.5;
        gbc.weighty = 0;
        panel.add(btnRegistrarDesktop, gbc);

        gbc.gridy = 3;
        panel.add(btnRegistrarLaptop, gbc);

        // Botones a la derecha
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 0.5;
        panel.add(btnRegistrarTablet, gbc);

        gbc.gridy = 3;
        panel.add(btnVerEquipos, gbc);

        // Botón de salir centrado en la parte inferior
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        panel.add(btnSalir, gbc);

        return panel;
    }


   private JPanel crearPanelRegistro(String tipoEquipo) {
    JPanel panel = new JPanel(new GridLayout(0, 2, 10, 10));
    JLabel titulo = new JLabel("Registrar " + tipoEquipo, SwingConstants.CENTER);
    titulo.setFont(new Font("Arial", Font.BOLD, 20));
    panel.add(titulo);
    panel.add(new JLabel()); // Espacio para alinear el título

    // Campos comunes
    JLabel lblFabricante = new JLabel("Fabricante:");
    JTextField txtFabricante = new JTextField();
    JLabel lblModelo = new JLabel("Modelo:");
    JTextField txtModelo = new JTextField();
    JLabel lblMicroprocesador = new JLabel("Microprocesador:");
    JTextField txtMicroprocesador = new JTextField();

    // Agregar campos comunes al panel
    panel.add(lblFabricante);
    panel.add(txtFabricante);
    panel.add(lblModelo);
    panel.add(txtModelo);
    panel.add(lblMicroprocesador);
    panel.add(txtMicroprocesador);

    // Campos específicos según el tipo de equipo
    switch (tipoEquipo) {
        case "Desktop":
            JLabel lblTarjetaGrafica = new JLabel("Tarjeta Gráfica:");
            JTextField txtTarjetaGrafica = new JTextField();
            JLabel lblTamañoTorre = new JLabel("Tamaño de Torre:");
            JTextField txtTamañoTorre = new JTextField();
            JLabel lblCapacidadDiscoDuro = new JLabel("Capacidad de Disco Duro:");
            JTextField txtCapacidadDiscoDuro = new JTextField();

            // Agregar campos específicos para Desktop
            panel.add(lblTarjetaGrafica);
            panel.add(txtTarjetaGrafica);
            panel.add(lblTamañoTorre);
            panel.add(txtTamañoTorre);
            panel.add(lblCapacidadDiscoDuro);
            panel.add(txtCapacidadDiscoDuro);

            JButton btnRegistrarDesktop = new JButton("Registrar");
            btnRegistrarDesktop.addActionListener(e -> {
                if (validarCampos(txtFabricante.getText(), txtModelo.getText(), txtMicroprocesador.getText(), txtTarjetaGrafica.getText(), txtTamañoTorre.getText(), txtCapacidadDiscoDuro.getText())) {
                    equipos.add(Desktop.crearDesktop(txtFabricante.getText(), txtModelo.getText(), txtMicroprocesador.getText(), txtTarjetaGrafica.getText(), txtTamañoTorre.getText(), txtCapacidadDiscoDuro.getText()));
                    JOptionPane.showMessageDialog(frame, "Desktop registrado exitosamente.");
                    limpiarCampos(txtFabricante, txtModelo, txtMicroprocesador, txtTarjetaGrafica, txtTamañoTorre, txtCapacidadDiscoDuro);
                }
            });
            panel.add(new JLabel()); // Espacio para alinear el botón
            panel.add(btnRegistrarDesktop);
            break;

        case "Laptop":
            JLabel lblMemoria = new JLabel("Memoria:");
            JTextField txtMemoria = new JTextField();
            JLabel lblTamañoPantalla = new JLabel("Tamaño de Pantalla:");
            JTextField txtTamañoPantalla = new JTextField();
            JLabel lblCapacidadDiscoDuroLaptop = new JLabel("Capacidad de Disco Duro:");
            JTextField txtCapacidadDiscoDuroLaptop = new JTextField();

            // Agregar campos específicos para Laptop
            panel.add(lblMemoria);
            panel.add(txtMemoria);
            panel.add(lblTamañoPantalla);
            panel.add(txtTamañoPantalla);
            panel.add(lblCapacidadDiscoDuroLaptop);
            panel.add(txtCapacidadDiscoDuroLaptop);

            JButton btnRegistrarLaptop = new JButton("Registrar");
            btnRegistrarLaptop.addActionListener(e -> {
                if (validarCampos(txtFabricante.getText(), txtModelo.getText(), txtMicroprocesador.getText(), txtMemoria.getText(), txtTamañoPantalla.getText(), txtCapacidadDiscoDuroLaptop.getText())) {
                    equipos.add(new Laptop(txtFabricante.getText(), txtModelo.getText(), txtMicroprocesador.getText(), txtMemoria.getText(), txtTamañoPantalla.getText(), txtCapacidadDiscoDuroLaptop.getText()));
                    JOptionPane.showMessageDialog(frame, "Laptop registrada exitosamente.");
                    limpiarCampos(txtFabricante, txtModelo, txtMicroprocesador, txtMemoria, txtTamañoPantalla, txtCapacidadDiscoDuroLaptop);
                }
            });
            panel.add(new JLabel()); // Espacio para alinear el botón
            panel.add(btnRegistrarLaptop);
            break;

        case "Tablet":
            JLabel lblTamañoPantallaTablet = new JLabel("Tamaño de Pantalla:");
            JTextField txtTamañoPantallaTablet = new JTextField();
            JLabel lblTipoPantalla = new JLabel("Tipo de Pantalla:");
            JTextField txtTipoPantalla = new JTextField();
            JLabel lblTamañoMemoriaNAND = new JLabel("Tamaño de Memoria NAND:");
            JTextField txtTamañoMemoriaNAND = new JTextField();
            JLabel lblSistemaOperativo = new JLabel("Sistema Operativo:");
            JTextField txtSistemaOperativo = new JTextField();

            // Agregar campos específicos para Tablet
            panel.add(lblTamañoPantallaTablet);
            panel.add(txtTamañoPantallaTablet);
            panel.add(lblTipoPantalla);
            panel.add(txtTipoPantalla);
            panel.add(lblTamañoMemoriaNAND);
            panel.add(txtTamañoMemoriaNAND);
            panel.add(lblSistemaOperativo);
            panel.add(txtSistemaOperativo);

            JButton btnRegistrarTablet = new JButton("Registrar");
            btnRegistrarTablet.addActionListener(e -> {
                if (validarCampos(txtFabricante.getText(), txtModelo.getText(), txtMicroprocesador.getText(), txtTamañoPantallaTablet.getText(), txtTipoPantalla.getText(), txtTamañoMemoriaNAND.getText(), txtSistemaOperativo.getText())) {
                    equipos.add(new Tablet(txtFabricante.getText(), txtModelo.getText(), txtMicroprocesador.getText(), txtTamañoPantallaTablet.getText(), txtTipoPantalla.getText(), txtTamañoMemoriaNAND.getText(), txtSistemaOperativo.getText()));
                    JOptionPane.showMessageDialog(frame, "Tablet registrada exitosamente.");
                    limpiarCampos(txtFabricante, txtModelo, txtMicroprocesador, txtTamañoPantallaTablet, txtTipoPantalla, txtTamañoMemoriaNAND, txtSistemaOperativo);
                }
            });
            panel.add(new JLabel()); // Espacio para alinear el botón
            panel.add(btnRegistrarTablet);
            break;
    }

    JButton btnVolver = new JButton("Volver al Menú");
    btnVolver.addActionListener(e -> cardLayout.show(panelPrincipal, "Menu"));

    panel.add(new JLabel()); // Espacio para alinear el botón
    panel.add(btnVolver);

    return panel;
}


    private void mostrarEquipos() {
        StringBuilder sb = new StringBuilder();
        equipos.stream().forEach((equipo) -> {
            sb.append(equipo.getClass().getSimpleName()).append("\n").append(equipo.toString()).append("\n\n");
        });
        JOptionPane.showMessageDialog(frame, sb.toString(), "Equipos Registrados", JOptionPane.INFORMATION_MESSAGE);
    }

    private boolean validarCampos(String... campos) {
        for (String campo : campos) {
            if (campo == null || campo.trim().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Todos los campos deben ser completados.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        return true;
    }

    private void limpiarCampos(JTextField... campos) {
        for (JTextField campo : campos) {
            campo.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TodoPC::new);
    }
}
