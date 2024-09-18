import javax.swing.*;
import javax.swing.border.Border;
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
        frame.setSize(1000, 600); // Aumentar el tamaño del frame
        cardLayout = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);

        // Añadir paneles al CardLayout
        panelPrincipal.add(crearPanelMenu(), "Menu");
        panelPrincipal.add(crearPanelRegistro(), "RegistrarEquipo");
        panelPrincipal.add(crearPanelVerEquipos(), "VerEquipos");

        // Paneles específicos para el registro de Desktop, Laptop, y Tablet
        panelPrincipal.add(crearPanelRegistro("Desktop"), "RegistrarDesktop");
        panelPrincipal.add(crearPanelRegistro("Laptop"), "RegistrarLaptop");
        panelPrincipal.add(crearPanelRegistro("Tablet"), "RegistrarTablet");

        // Paneles específicos para ver Desktop, Laptop, y Tablet
        panelPrincipal.add(crearPanelVerEquipos("Desktop"), "VerDesktop");
        panelPrincipal.add(crearPanelVerEquipos("Laptop"), "VerLaptop");
        panelPrincipal.add(crearPanelVerEquipos("Tablet"), "VerTablet");

        frame.add(panelPrincipal);
        frame.setVisible(true);
    }

private JPanel crearPanelMenu() {
    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    
    // Configuración del título
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 3;
    gbc.weighty = 0.1;
    gbc.weightx = 1.0; // Asegura que el título ocupe el ancho completo del panel
    panel.add(Box.createRigidArea(new Dimension(0, 20)), gbc);
    
    JLabel titulo = new JLabel("Menú Principal", SwingConstants.CENTER);
    titulo.setFont(new Font("Arial", Font.BOLD, 20));
    gbc.gridy = 1;
    gbc.gridwidth = 3;
    gbc.weighty = 0.1;
    panel.add(titulo, gbc);
    
    // Crear un panel para los botones con GridLayout en una sola columna
    JPanel buttonPanel = new JPanel(new GridLayout(0, 1, 10, 10)); // 1 columna con 10px de espacio entre botones
    
    JButton btnRegistrarEquipo = new JButton("Registrar equipo");
    JButton btnVerEquipos = new JButton("Ver equipos");
    JButton btnSalir = new JButton("Salir");
    
    Dimension botonDimension = new Dimension(150, 40); // Ajustar el tamaño de los botones
    btnRegistrarEquipo.setPreferredSize(botonDimension);
    btnVerEquipos.setPreferredSize(botonDimension);
    btnSalir.setPreferredSize(botonDimension);
    
    // Configuración de los botones
    JButton[] botones = {btnRegistrarEquipo, btnVerEquipos, btnSalir};
    for (JButton boton : botones) {
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        boton.setBackground(new Color(70, 130, 180)); // Color de fondo para los botones
        boton.setForeground(Color.WHITE); // Color del texto
    }
    
    btnRegistrarEquipo.addActionListener(e -> cardLayout.show(panelPrincipal, "RegistrarEquipo"));
    btnVerEquipos.addActionListener(e -> cardLayout.show(panelPrincipal, "VerEquipos"));
    btnSalir.addActionListener(e -> System.exit(0));
    
    // Añadir los botones al panel de botones
    buttonPanel.add(btnRegistrarEquipo);
    buttonPanel.add(btnVerEquipos);
    buttonPanel.add(btnSalir);
    
    // Configurar restricciones para centrar el panel de botones y ajustar el tamaño de la columna central
    gbc.gridy = 2;
    gbc.gridwidth = 1; // Ocupa una columna
    gbc.weighty = 1.0;
    gbc.weightx = 1.0; // Asegura que el panel de botones ocupe el espacio central
    gbc.gridx = 1; // Columna central
    gbc.anchor = GridBagConstraints.CENTER; // Centra el panel de botones
    panel.add(buttonPanel, gbc);
    
    // Añadir espacios en las columnas laterales para que sean invisibles
    gbc.gridx = 0;
    gbc.gridwidth = 1;
    gbc.weightx = 0.2; // Espacio en la columna izquierda
    panel.add(new JPanel(), gbc);
    
    gbc.gridx = 2;
    gbc.gridwidth = 1;
    gbc.weightx = 0.2; // Espacio en la columna derecha
    panel.add(new JPanel(), gbc);

    return panel;
}



private JPanel crearPanelRegistro() {
    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.weightx = 1.0;

    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    gbc.weighty = 0.1;
    panel.add(Box.createRigidArea(new Dimension(0, 20)), gbc);

    JLabel titulo = new JLabel("Registrar Equipo", SwingConstants.CENTER);
    titulo.setFont(new Font("Arial", Font.BOLD, 20));
    gbc.gridy = 1;
    gbc.gridwidth = 2;
    gbc.weighty = 0.1;
    panel.add(titulo, gbc);

    // Crear un panel para los botones con GridLayout
    JPanel buttonPanel = new JPanel(new GridLayout(0, 2, 10, 10)); // 2 columnas con 10px de espacio entre botones

    JButton btnRegistrarDesktop = new JButton("Registrar Desktop");
    JButton btnRegistrarLaptop = new JButton("Registrar Laptop");
    JButton btnRegistrarTablet = new JButton("Registrar Tablet");
    JButton btnVolver = new JButton("Volver al Menú");

    Dimension botonDimension = new Dimension(200, 40); // Ajustar el tamaño de los botones
    btnRegistrarDesktop.setPreferredSize(botonDimension);
    btnRegistrarLaptop.setPreferredSize(botonDimension);
    btnRegistrarTablet.setPreferredSize(botonDimension);
    btnVolver.setPreferredSize(botonDimension);

    // Configuración de los botones
    btnRegistrarDesktop.setFont(new Font("Arial", Font.BOLD, 16));
    btnRegistrarLaptop.setFont(new Font("Arial", Font.BOLD, 16));
    btnRegistrarTablet.setFont(new Font("Arial", Font.BOLD, 16));
    btnVolver.setFont(new Font("Arial", Font.BOLD, 16));

    btnRegistrarDesktop.setBackground(new Color(70, 130, 180)); // Color de fondo para los botones
    btnRegistrarLaptop.setBackground(new Color(70, 130, 180));
    btnRegistrarTablet.setBackground(new Color(70, 130, 180));
    btnVolver.setBackground(new Color(70, 130, 180));

    btnRegistrarDesktop.setForeground(Color.WHITE); // Color del texto
    btnRegistrarLaptop.setForeground(Color.WHITE);
    btnRegistrarTablet.setForeground(Color.WHITE);
    btnVolver.setForeground(Color.BLACK); // Color del texto del botón "Volver al Menú"

    btnRegistrarDesktop.addActionListener(e -> cardLayout.show(panelPrincipal, "RegistrarDesktop"));
    btnRegistrarLaptop.addActionListener(e -> cardLayout.show(panelPrincipal, "RegistrarLaptop"));
    btnRegistrarTablet.addActionListener(e -> cardLayout.show(panelPrincipal, "RegistrarTablet"));
    btnVolver.addActionListener(e -> cardLayout.show(panelPrincipal, "Menu"));

    // Añadir los botones al panel de botones
    buttonPanel.add(btnRegistrarDesktop);
    buttonPanel.add(btnRegistrarLaptop);
    buttonPanel.add(btnRegistrarTablet);
    buttonPanel.add(btnVolver);

    gbc.gridy = 2;
    gbc.gridwidth = 2;
    gbc.weighty = 1.0;
    panel.add(buttonPanel, gbc);

    return panel;
}


private JPanel crearPanelVerEquipos() {
    JPanel panel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(10, 10, 10, 10);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.weightx = 1.0;

    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    gbc.weighty = 0.1;
    panel.add(Box.createRigidArea(new Dimension(0, 20)), gbc);

    JLabel titulo = new JLabel("Seleccionar Tipo de Equipo", SwingConstants.CENTER);
    titulo.setFont(new Font("Arial", Font.BOLD, 20));
    titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
    gbc.gridy = 1;
    gbc.gridwidth = 2;
    gbc.weighty = 0.1;
    panel.add(titulo, gbc);

    gbc.gridy = 2;
    gbc.gridwidth = 2;
    gbc.weighty = 0.1;
    panel.add(Box.createRigidArea(new Dimension(0, 20)), gbc);

    // Crear un panel para los botones con GridLayout (2 columnas)
    JPanel buttonPanel = new JPanel(new GridLayout(0, 2, 10, 10)); // 2 columnas con 10px de espacio entre botones

    JButton btnVerDesktop = new JButton("Ver Desktops");
    JButton btnVerLaptop = new JButton("Ver Laptops");
    JButton btnVerTablet = new JButton("Ver Tablets");
    JButton btnVolver = new JButton("Volver al Menú");

    Dimension botonDimension = new Dimension(150, 40); // Ajustar el tamaño de los botones

    // Configuración de los botones
    JButton[] botones = {btnVerDesktop, btnVerLaptop, btnVerTablet, btnVolver};
    for (JButton boton : botones) {
        boton.setPreferredSize(botonDimension);
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        boton.setBackground(new Color(70, 130, 180)); // Color de fondo para los botones
        boton.setForeground(Color.WHITE); // Color del texto
    }

    btnVerDesktop.addActionListener(e -> {
        JPanel panelVerDesktop = crearPanelVerEquipos("Desktop");
        panelPrincipal.add(panelVerDesktop, "VerDesktop");
        cardLayout.show(panelPrincipal, "VerDesktop");
    });
    btnVerLaptop.addActionListener(e -> {
        JPanel panelVerLaptop = crearPanelVerEquipos("Laptop");
        panelPrincipal.add(panelVerLaptop, "VerLaptop");
        cardLayout.show(panelPrincipal, "VerLaptop");
    });
    btnVerTablet.addActionListener(e -> {
        JPanel panelVerTablet = crearPanelVerEquipos("Tablet");
        panelPrincipal.add(panelVerTablet, "VerTablet");
        cardLayout.show(panelPrincipal, "VerTablet");
    });
    btnVolver.addActionListener(e -> cardLayout.show(panelPrincipal, "Menu"));

    // Añadir los botones al panel de botones
    buttonPanel.add(btnVerDesktop);
    buttonPanel.add(btnVerLaptop);
    buttonPanel.add(btnVerTablet);
    buttonPanel.add(btnVolver);

    gbc.gridy = 3;
    gbc.gridwidth = 2;
    gbc.weighty = 1.0;
    gbc.anchor = GridBagConstraints.CENTER; // Centra el panel de botones
    panel.add(buttonPanel, gbc);

    return panel;
}


private JPanel crearPanelVerEquipos(String tipoEquipo) {
    JPanel panel = new JPanel(new BorderLayout());
    panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    JLabel titulo = new JLabel("Ver " + tipoEquipo + "s", SwingConstants.CENTER);
    titulo.setFont(new Font("Arial", Font.BOLD, 20));
    panel.add(titulo, BorderLayout.NORTH);

    JTextArea textArea = new JTextArea();
    textArea.setEditable(false);
    JScrollPane scrollPane = new JScrollPane(textArea);
    panel.add(scrollPane, BorderLayout.CENTER);

    SwingUtilities.invokeLater(() -> {
        StringBuilder sb = new StringBuilder();
        for (Equipo equipo : equipos) {
            if (equipo.getClass().getSimpleName().equals(tipoEquipo)) {
                sb.append(equipo).append("\n\n");
            }
        }
        textArea.setText(sb.toString());
    });

    JButton btnVolver = crearBoton("Volver ");
    btnVolver.setPreferredSize(new Dimension(150, 40)); // Ajustar el tamaño del botón
    btnVolver.setFont(new Font("Arial", Font.BOLD, 16));
    btnVolver.setBackground(new Color(70, 130, 180)); // Color de fondo para el botón
    btnVolver.setForeground(Color.WHITE); // Color del texto

    btnVolver.addActionListener(e -> cardLayout.show(panelPrincipal, "VerEquipos"));

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(btnVolver);
    panel.add(buttonPanel, BorderLayout.SOUTH);

    return panel;
}


  
  
private JPanel crearPanelRegistro(String tipoEquipo) {
    // Definimos una seccion principal que se distribuye como una fila y dos columnas
    JPanel mainPanel = new JPanel(new BorderLayout());
    
    // Definimos la primera seccion
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    
    // Definimos la segunda seccion
    JPanel panel2 = new JPanel();
    panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
    panel2.add(Box.createVerticalGlue()); // Aqui creamos un espacio flex para centrar el boton verticalmente en la parte superior
    
    // Definimos una seccion para el titulo
    JPanel panelTitulo = new JPanel();

    JLabel titulo = new JLabel("Registrar " + tipoEquipo);
    titulo.setFont(new Font("Arial", Font.BOLD, 25));
    titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
    panel.add(Box.createRigidArea(new Dimension(0, 20)));
    
    panelTitulo.setBorder(BorderFactory.createEmptyBorder(30, 0 , 0, 0));
    panelTitulo.add(titulo);

    panel.add(Box.createRigidArea(new Dimension(0, 20)));

    JTextField txtFabricante = new JTextField();
    JTextField txtModelo = new JTextField();
    JTextField txtMicroprocesador = new JTextField();
    

    // Creamos el JLabel para mostrar la imagen
    JLabel labelImagen = new JLabel();
    labelImagen.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 

    // Establecemos un tamaño mínimo para el JLabel
    Dimension tamañoEtiqueta = new Dimension(200, 200); 
    labelImagen.setPreferredSize(tamañoEtiqueta);
    labelImagen.setMaximumSize(tamañoEtiqueta);

    // Creamos el botón para agregar una imagen
    JButton btnImagenDispositivo = crearBoton("Agregar Imagen");
    
    // Establecemos un tamaño mínimo para el botón
    btnImagenDispositivo.setPreferredSize(new Dimension(tamañoEtiqueta.width, 40)); 
    btnImagenDispositivo.setMaximumSize(new Dimension(tamañoEtiqueta.width, 40));
    
    // Definimos un panel que nos ayude a centrar el boton y el label para la imagen
    JPanel imagenContainer = new JPanel();
    imagenContainer.setLayout(new BoxLayout(imagenContainer, BoxLayout.Y_AXIS));
    imagenContainer.setAlignmentX(Component.CENTER_ALIGNMENT);

    imagenContainer.add(Box.createVerticalGlue()); // Definimos un espacio flexible arriba
    // Agregamos el botón y el JLabel al panel2, alineados verticalmente
    imagenContainer.add(labelImagen);
    imagenContainer.add(Box.createRigidArea(new Dimension(0, 10)));
    imagenContainer.add(btnImagenDispositivo);
    imagenContainer.add(Box.createVerticalGlue()); // Definimos un espacio flexible abajo
    
    panel2.add(imagenContainer);

    panel.add(createFieldPanel("Fabricante:", txtFabricante));
    panel.add(createFieldPanel("Modelo:", txtModelo));
    panel.add(createFieldPanel("Microprocesador:", txtMicroprocesador));


    JButton btnRegistrar;
    switch (tipoEquipo) {
        case "Desktop":
            JTextField txtTarjetaGrafica = new JTextField();
            JTextField txtTamañoTorre = new JTextField();
            JTextField txtCapacidadDiscoDuro = new JTextField();

            JComboBox<String> comboUnidadTorre = createComboBox(new String[]{"IN", "M"});
            JComboBox<String> comboUnidadDisco = createComboBox(new String[]{"GB", "TB"});

            panel.add(createFieldPanel("Tarjeta Gráfica:", txtTarjetaGrafica));
            panel.add(createFieldPanelWithCombo("Tamaño de Torre:", txtTamañoTorre, comboUnidadTorre));
            panel.add(createFieldPanelWithCombo("Capacidad de Disco Duro:", txtCapacidadDiscoDuro, comboUnidadDisco));
            
            btnRegistrar = crearBoton("Registrar Desktop");
            btnRegistrar.addActionListener(e -> registrarDesktop(
                    txtFabricante.getText(), txtModelo.getText(), txtMicroprocesador.getText(),
                    txtTarjetaGrafica.getText(), txtTamañoTorre.getText(), comboUnidadTorre.getSelectedItem().toString(),
                    txtCapacidadDiscoDuro.getText(), comboUnidadDisco.getSelectedItem().toString(),
                    txtFabricante, txtModelo, txtMicroprocesador, txtTarjetaGrafica, txtTamañoTorre, txtCapacidadDiscoDuro
            ));
            break;


        case "Laptop":
            JTextField txtMemoria = new JTextField();
            JTextField txtTamañoPantalla = new JTextField();
            JTextField txtCapacidadDiscoDuroLaptop = new JTextField();

            JComboBox<String> comboUnidadMemoria = createComboBox(new String[]{"GB", "TB"});
            JComboBox<String> comboUnidadPantalla = createComboBox(new String[]{"IN", "M"});
            JComboBox<String> comboUnidadDiscoLaptop = createComboBox(new String[]{"GB", "TB"});

            panel.add(createFieldPanelWithCombo("Memoria:", txtMemoria, comboUnidadMemoria));
            panel.add(createFieldPanelWithCombo("Tamaño de Pantalla:", txtTamañoPantalla, comboUnidadPantalla));
            panel.add(createFieldPanelWithCombo("Capacidad de Disco Duro:", txtCapacidadDiscoDuroLaptop, comboUnidadDiscoLaptop));

            btnRegistrar = crearBoton("Registrar Laptop");
            btnRegistrar.addActionListener(e -> registrarLaptop(
                    txtFabricante.getText(), txtModelo.getText(), txtMicroprocesador.getText(),
                    txtMemoria.getText(), txtTamañoPantalla.getText(), txtCapacidadDiscoDuroLaptop.getText(),
                    comboUnidadMemoria, comboUnidadPantalla, comboUnidadDiscoLaptop, // Pasar los JComboBox aquí
                    txtFabricante, txtModelo, txtMicroprocesador, txtMemoria, txtTamañoPantalla, txtCapacidadDiscoDuroLaptop
            ));
            break;

        case "Tablet":
            JTextField txtTamañoPantallaTablet = new JTextField();
            JComboBox<String> cbTipoPantalla = new JComboBox<>(new String[]{"Capacitiva", "Resistiva"});
            JTextField txtTamañoMemoriaNAND = new JTextField();
            JTextField txtSistemaOperativo = new JTextField();

            JComboBox<String> comboUnidadPantallaT = createComboBox(new String[]{"IN", "M"});
            JComboBox<String> comboUnidadMemoriaNAND = createComboBox(new String[]{"GB", "TB"});

            panel.add(createFieldPanelWithCombo("Tamaño de Pantalla:", txtTamañoPantallaTablet, comboUnidadPantallaT));
            panel.add(createFieldPanel("Tipo de Pantalla:", cbTipoPantalla));
            panel.add(createFieldPanelWithCombo("Tamaño de Memoria NAND:", txtTamañoMemoriaNAND, comboUnidadMemoriaNAND));
            panel.add(createFieldPanel("Sistema Operativo:", txtSistemaOperativo));

            btnRegistrar = crearBoton("Registrar Tablet");
            btnRegistrar.addActionListener(e -> registrarTablet(
                    txtFabricante.getText(), txtModelo.getText(), txtMicroprocesador.getText(),
                    txtTamañoPantallaTablet.getText(), cbTipoPantalla.getSelectedItem().toString(), comboUnidadPantallaT.getSelectedItem().toString(),
                    txtTamañoMemoriaNAND.getText(), comboUnidadMemoriaNAND.getSelectedItem().toString(),
                    txtSistemaOperativo.getText(),
                    txtFabricante, txtModelo, txtMicroprocesador, txtTamañoPantallaTablet, txtTamañoMemoriaNAND, txtSistemaOperativo
            ));
            break;


        default:
            throw new IllegalStateException("Unexpected value: " + tipoEquipo);
    }

    JButton btnVolverRegistro = crearBoton("Volver al Menú de Registro");
    btnVolverRegistro.addActionListener(e -> cardLayout.show(panelPrincipal, "RegistrarEquipo"));

    JButton btnVolverPrincipal = crearBoton("Volver al Menú Principal");
    btnVolverPrincipal.addActionListener(e -> cardLayout.show(panelPrincipal, "Menu"));

    // Agregar los botones en una cuadrícula de 3 columnas
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(1, 3, 10, 10)); // 1 fila y 3 columnas para los botones

    Dimension botonDimension = new Dimension(150, 40); // Ajustar el tamaño de los botones
    JButton[] botones = {btnRegistrar, btnVolverRegistro, btnVolverPrincipal};
    for (JButton boton : botones) {
        boton.setPreferredSize(botonDimension);
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        boton.setBackground(new Color(70, 130, 180)); // Color de fondo para los botones
        boton.setForeground(Color.WHITE); // Color del texto
    }

    btnVolverRegistro.setForeground(Color.BLACK); // Color del texto del botón "Volver al Menú de Registro"

    buttonPanel.add(btnRegistrar);
    buttonPanel.add(btnVolverRegistro);
    buttonPanel.add(btnVolverPrincipal);
    
    buttonPanel.setBorder(BorderFactory.createEmptyBorder(0 , 25, 30, 25));

    // Agregamos las secciones al panel principal
    mainPanel.add(panelTitulo, BorderLayout.NORTH);
    mainPanel.add(panel, BorderLayout.WEST);
    mainPanel.add(panel2, BorderLayout.EAST);
    mainPanel.add(buttonPanel, BorderLayout.SOUTH); // Ubicamos los botones en la parte inferior del panel principal

    
    return mainPanel;
}


    private JPanel createFieldPanel(String labelText, JComponent field) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setPreferredSize(new Dimension(600, 70)); // Ajusta el alto del panel
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(200, 40)); // Ajusta el ancho y alto del label
        field.setPreferredSize(new Dimension(350, 40)); // Ajusta el ancho y alto del campo
        panel.add(label);
        panel.add(field);
        return panel;
    }

    private JPanel createFieldPanelWithCombo(String labelText, JTextField textField, JComboBox<String> comboBox) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setPreferredSize(new Dimension(600, 70)); // Ajusta el alto del panel
        JLabel label = new JLabel(labelText);
        label.setPreferredSize(new Dimension(200, 40));
        textField.setPreferredSize(new Dimension(150, 40));
        comboBox.setPreferredSize(new Dimension(50, 40));
        panel.add(label);
        panel.add(textField);
        panel.add(comboBox);
        return panel;
    }

    private JComboBox<String> createComboBox(String[] opciones) {
        return new JComboBox<>(opciones);
    }

    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setPreferredSize(new Dimension(300, 40)); // Establece el alto a 40 píxeles
        boton.setFont(new Font("Arial", Font.PLAIN, 14));
        return boton;
    }

    private void registrarDesktop(String fabricante, String modelo, String microprocesador,
                                  String tarjetaGrafica, String tamañoTorre, String unidadTorre,
                                  String capacidadDiscoDuro, String unidadDisco, JTextField... campos) {
        if (validarCampos(fabricante, modelo, microprocesador, tarjetaGrafica, tamañoTorre, capacidadDiscoDuro)) {
            // Validar que los campos de tamaño de torre y capacidad del disco duro sean numéricos
            if (!esNumerico(tamañoTorre) || !esNumerico(capacidadDiscoDuro)) {
                JOptionPane.showMessageDialog(frame, "El tamaño de la torre y la capacidad del disco duro deben ser numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Combinar el valor ingresado con la unidad seleccionada
            tamañoTorre = tamañoTorre + " " + unidadTorre;
            capacidadDiscoDuro = capacidadDiscoDuro + " " + unidadDisco;

            if (!equipoYaRegistrado(fabricante, modelo)) {
                equipos.add(new Desktop(fabricante, modelo, microprocesador, tarjetaGrafica, tamañoTorre, capacidadDiscoDuro));
                JOptionPane.showMessageDialog(frame, "Desktop registrado exitosamente.");
                limpiarCampos(campos); // Limpiar campos después de registrar
            } else {
                JOptionPane.showMessageDialog(frame, "El equipo ya está registrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    private void registrarLaptop(String fabricante, String modelo, String microprocesador,
                                 String memoria, String tamañoPantalla, String capacidadDiscoDuro,
                                 JComboBox<String> comboUnidadMemoria, JComboBox<String> comboUnidadPantalla,
                                 JComboBox<String> comboUnidadDiscoLaptop, JTextField... campos) {
        if (validarCampos(fabricante, modelo, microprocesador, memoria, tamañoPantalla, capacidadDiscoDuro)) {
            // Validar que los campos de tamaño de pantalla, memoria y capacidad del disco duro sean numéricos
            if (!esNumerico(tamañoPantalla) || !esNumerico(capacidadDiscoDuro) || !esNumerico(memoria)) {
                JOptionPane.showMessageDialog(frame, "El tamaño de la pantalla, la memoria y la capacidad del disco duro deben ser numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Obtener la unidad seleccionada en el JComboBox
            String unidadDiscoDuro = comboUnidadDiscoLaptop.getSelectedItem().toString();
            String unidadMemoria = comboUnidadMemoria.getSelectedItem().toString();
            String unidadPantalla = comboUnidadPantalla.getSelectedItem().toString();

            // Combinar el valor ingresado con la unidad seleccionada
            capacidadDiscoDuro = capacidadDiscoDuro + " " + unidadDiscoDuro;
            memoria = memoria + " " + unidadMemoria;
            tamañoPantalla = tamañoPantalla + " " + unidadPantalla;

            if (!equipoYaRegistrado(fabricante, modelo)) {
                equipos.add(new Laptop(fabricante, modelo, microprocesador, memoria, tamañoPantalla, capacidadDiscoDuro));
                JOptionPane.showMessageDialog(frame, "Laptop registrada exitosamente.");
                limpiarCampos(campos); // Limpiar campos después de registrar
            } else {
                JOptionPane.showMessageDialog(frame, "El equipo ya está registrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void registrarTablet(String fabricante, String modelo, String microprocesador,
                                 String tamañoPantalla, String unidadPantalla, String tipoPantalla,
                                 String tamañoMemoriaNAND, String unidadMemoriaNAND,
                                 String sistemaOperativo, JTextField... campos) {
        if (validarCampos(fabricante, modelo, microprocesador, tamañoPantalla, unidadPantalla, tamañoMemoriaNAND, sistemaOperativo)) {
            // Validar que los campos de tamaño de pantalla y memoria NAND sean numéricos
            if (!esNumerico(tamañoPantalla) || !esNumerico(tamañoMemoriaNAND)) {
                JOptionPane.showMessageDialog(frame, "El tamaño de la pantalla y la memoria NAND deben ser numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Combinar el valor ingresado con la unidad seleccionada
            tamañoPantalla = tamañoPantalla + " " + unidadPantalla;
            tamañoMemoriaNAND = tamañoMemoriaNAND + " " + unidadMemoriaNAND;

            if (!equipoYaRegistrado(fabricante, modelo)) {
                equipos.add(new Tablet(fabricante, modelo, microprocesador, tamañoPantalla, tipoPantalla, tamañoMemoriaNAND, sistemaOperativo));
                JOptionPane.showMessageDialog(frame, "Tablet registrada exitosamente.");
                limpiarCampos(campos); // Limpiar campos después de registrar
            } else {
                JOptionPane.showMessageDialog(frame, "El equipo ya está registrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private boolean equipoYaRegistrado(String fabricante, String modelo) {
        for (Equipo equipo : equipos) {
            if (equipo.getFabricante().equalsIgnoreCase(fabricante) && equipo.getModelo().equalsIgnoreCase(modelo)) {
                return true; // Equipo ya registrado
            }
        }
        return false;
    }
    private boolean esNumerico(String texto) {
        try {
            Double.parseDouble(texto);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
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
