import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;
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
    btnRegistrarEquipo.setFocusPainted(false);
    JButton btnVerEquipos = new JButton("Ver equipos");
    JButton btnSalir = new JButton("Salir");
    
    Dimension botonDimension = new Dimension(150, 40); // Ajustar el tamaño de los botones
    btnRegistrarEquipo.setPreferredSize(botonDimension);
    btnVerEquipos.setPreferredSize(botonDimension);
    btnSalir.setPreferredSize(botonDimension);
    
           // Configuración del botón Registrar Equipo
btnRegistrarEquipo.setFont(new Font("Arial", Font.BOLD, 16));
btnRegistrarEquipo.setBackground(new Color(70, 130, 180)); // Color de fondo para el botón Salir (rojo)
btnRegistrarEquipo.setForeground(Color.WHITE); // Color del texto
    
       // Configuración del botón Ver Equipos
btnVerEquipos.setFont(new Font("Arial", Font.BOLD, 16));
btnVerEquipos.setBackground(new Color(70, 130, 180)); // Color de fondo para el botón Salir (rojo)
btnVerEquipos.setForeground(Color.WHITE); // Color del texto
    
   // Configuración del botón Salir
btnSalir.setFont(new Font("Arial", Font.BOLD, 16));
btnSalir.setBackground(new Color(70, 130, 180)); // Color de fondo para el botón Salir (rojo)
btnSalir.setForeground(Color.BLACK); // Color del texto

    
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
        
        // Configuración de color específico para un botón
    if (boton == btnVolver) {
        boton.setForeground(Color.BLACK); // Color del texto
    }
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

    // Creamos un panel para contener las tarjetas de cada equipo
    JPanel panelEquipos = new JPanel(new GridLayout(0, 4, 30, 30)); // GridLayout de 4 columnas
    panelEquipos.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

    // Iteramos sobre los equipos y crear una tarjeta para cada uno
    for (Equipo equipo : equipos) {
        if (equipo.getClass().getSimpleName().equals(tipoEquipo)) {
            // Creamos una tarjeta para el equipo
            JPanel card = new JPanel(new BorderLayout());
            card.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            card.setBackground(Color.WHITE);
            card.setPreferredSize(new Dimension(200, 330)); // Aumentamos la altura de la tarjeta

            // Panel para la imagen
            JPanel panelImagen = new JPanel(new BorderLayout());
            panelImagen.setBackground(Color.LIGHT_GRAY);
            panelImagen.setPreferredSize(new Dimension(200, 200)); // Asegura que la imagen ocupe un área fija

            JLabel labelImagen = new JLabel();
            labelImagen.setHorizontalAlignment(SwingConstants.CENTER);
            labelImagen.setVerticalAlignment(SwingConstants.CENTER);

            if (equipo.getRutaImagen() != null && !equipo.getRutaImagen().isEmpty()) {
                ImageIcon icono = new ImageIcon(equipo.getRutaImagen());
                Image imagen = icono.getImage().getScaledInstance(panelImagen.getPreferredSize().width, 
                                                                   panelImagen.getPreferredSize().height, 
                                                                   Image.SCALE_SMOOTH);
                labelImagen.setIcon(new ImageIcon(imagen));
            } else {
                labelImagen.setText("Sin imagen");
            }

            panelImagen.add(labelImagen, BorderLayout.CENTER);

            // Panel para la descripción
            JPanel panelDescripcion = new JPanel(new BorderLayout());
            JTextArea textArea = new JTextArea(equipo.toString());
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            textArea.setOpaque(false);  // Para que coincida con el fondo del panel
            textArea.setFont(new Font("Arial", Font.PLAIN, 12));
            textArea.setPreferredSize(new Dimension(180, 150));  // Aumentamos la altura para dar más espacio al texto

            panelDescripcion.add(textArea, BorderLayout.CENTER);

            // Agregamos la imagen y descripción a la tarjeta
            card.add(panelImagen, BorderLayout.NORTH);
            card.add(panelDescripcion, BorderLayout.CENTER);

            // Agregamos tarjeta al panel principal de equipos
            panelEquipos.add(card);
        }
    }

    // Scroll pane para el panel de equipos (contiene todas las tarjetas)
    JScrollPane scrollPane = new JScrollPane(panelEquipos);
    scrollPane.setPreferredSize(new Dimension(800, 650)); // Aumentamos el tamaño preferido para dar más espacio
    panel.add(scrollPane, BorderLayout.CENTER);

    // Botón para volver
    JButton btnVolver = crearBoton("Volver");
    btnVolver.setPreferredSize(new Dimension(150, 40));
    btnVolver.setFont(new Font("Arial", Font.BOLD, 16));
    btnVolver.setBackground(new Color(70, 130, 180));
    btnVolver.setForeground(Color.BLACK);

    btnVolver.addActionListener(e -> cardLayout.show(panelPrincipal, "VerEquipos"));

    JPanel buttonPanel = new JPanel();
    buttonPanel.add(btnVolver);
    panel.add(buttonPanel, BorderLayout.SOUTH);

    return panel;
}

// Almacenamos la ruta de la imagen en una variable String
private String rutaImagenSeleccionadaString;
private JPanel crearPanelRegistro(String tipoEquipo) {
    // Definimos un panel principal con BorderLayout
    JPanel mainPanel = new JPanel(new BorderLayout());
    
    // Panel izquierda: Contiene los campos de entrada
    JPanel panelIzquierda = new JPanel();
    panelIzquierda.setLayout(new BoxLayout(panelIzquierda, BoxLayout.Y_AXIS));
    panelIzquierda.setBorder(BorderFactory.createEmptyBorder(50, 50, 0, 50));
    
    // Panel derecha: Vacío (para margen)
    JPanel panelDerecha = new JPanel(); // Se mantendrá vacío
    
    // Panel central: Contiene la imagen y el botón
    JPanel panelCentro = new JPanel();
    panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
    panelCentro.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 50)); // Añadir margen izquierdo y derecho

    // Añadimos un panel de título en la parte superior
    JPanel panelTitulo = new JPanel();
    JLabel titulo = new JLabel("Registrar " + tipoEquipo);
    titulo.setFont(new Font("Arial", Font.BOLD, 25));
    titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
    panelTitulo.setBorder(BorderFactory.createEmptyBorder(30, 0 , 0, 0));
    panelTitulo.add(titulo);

    // Creamos los JTextField comunes
    JTextField txtFabricante = new JTextField();
    JTextField txtModelo = new JTextField();
    JTextField txtMicroprocesador = new JTextField();

    // Creamos el JLabel para mostrar la imagen
    JLabel labelImagen = new JLabel();
    labelImagen.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    labelImagen.setPreferredSize(new Dimension(200, 200));
    labelImagen.setMaximumSize(new Dimension(200, 200));

    // Creamos el botón para agregar una imagen
    JButton btnImagenDispositivo = crearBoton("Agregar Imagen");
    btnImagenDispositivo.setPreferredSize(new Dimension(200, 40));
    btnImagenDispositivo.setMaximumSize(new Dimension(200, 40));

    // Definimos un panel que nos ayude a centrar la imagen y el botón en el panelCentro
    JPanel imagenContainer = new JPanel();
    imagenContainer.setLayout(new BoxLayout(imagenContainer, BoxLayout.Y_AXIS));
    imagenContainer.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    imagenContainer.add(Box.createVerticalGlue()); // Espacio flexible arriba
    imagenContainer.add(labelImagen);
    imagenContainer.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre imagen y botón
    imagenContainer.add(btnImagenDispositivo);
    imagenContainer.add(Box.createVerticalGlue()); // Espacio flexible abajo
    
    // Agregamos el contenedor al panel central
    panelCentro.add(imagenContainer);

    // Añadimos los campos comunes al panel izquierdo
    panelIzquierda.add(createFieldPanel("Fabricante:", txtFabricante));
    panelIzquierda.add(createFieldPanel("Modelo:", txtModelo));
    panelIzquierda.add(createFieldPanel("Microprocesador:", txtMicroprocesador));

    JButton btnRegistrar;
    switch (tipoEquipo) {
        case "Desktop":
            JTextField txtTarjetaGrafica = new JTextField();
            JTextField txtTamañoTorre = new JTextField();
            JTextField txtCapacidadDiscoDuro = new JTextField();
            JComboBox<String> comboUnidadTorre = createComboBox(new String[]{"IN", "M"});
            JComboBox<String> comboUnidadDisco = createComboBox(new String[]{"GB", "TB"});

            panelIzquierda.add(createFieldPanel("Tarjeta Gráfica:", txtTarjetaGrafica));
            panelIzquierda.add(createFieldPanelWithCombo("Tamaño de Torre:", txtTamañoTorre, comboUnidadTorre));
            panelIzquierda.add(createFieldPanelWithCombo("Capacidad de Disco Duro:", txtCapacidadDiscoDuro, comboUnidadDisco));

            btnRegistrar = crearBoton("Registrar Desktop");
            btnRegistrar.addActionListener(e -> {
    registrarDesktop(
            txtFabricante.getText(), txtModelo.getText(), txtMicroprocesador.getText(),
            txtTarjetaGrafica.getText(), txtTamañoTorre.getText(), comboUnidadTorre.getSelectedItem().toString(),
            txtCapacidadDiscoDuro.getText(), comboUnidadDisco.getSelectedItem().toString(), rutaImagenSeleccionadaString,
            txtFabricante, txtModelo, txtMicroprocesador, txtTarjetaGrafica, txtTamañoTorre, txtCapacidadDiscoDuro
    );
    // Limpiar imagen
    labelImagen.setIcon(null);
    rutaImagenSeleccionadaString = ""; // Asegúrate de que esta variable esté definida en el contexto correcto
    // Limpiar campos de texto
    txtFabricante.setText("");
    txtModelo.setText("");
    txtMicroprocesador.setText("");
    txtTarjetaGrafica.setText("");
    txtTamañoTorre.setText("");
    txtCapacidadDiscoDuro.setText("");
});
            break;

        case "Laptop":
    JTextField txtMemoria = new JTextField();
    JTextField txtTamañoPantalla = new JTextField();
    JTextField txtCapacidadDiscoDuroLaptop = new JTextField();
    JComboBox<String> comboUnidadMemoria = createComboBox(new String[]{"GB", "TB"});
    JComboBox<String> comboUnidadPantalla = createComboBox(new String[]{"IN", "M"});
    JComboBox<String> comboUnidadDiscoLaptop = createComboBox(new String[]{"GB", "TB"});

    panelIzquierda.add(createFieldPanelWithCombo("Memoria:", txtMemoria, comboUnidadMemoria));
    panelIzquierda.add(createFieldPanelWithCombo("Tamaño de Pantalla:", txtTamañoPantalla, comboUnidadPantalla));
    panelIzquierda.add(createFieldPanelWithCombo("Capacidad de Disco Duro:", txtCapacidadDiscoDuroLaptop, comboUnidadDiscoLaptop));

    btnRegistrar = crearBoton("Registrar Laptop");
    btnRegistrar.addActionListener(e -> {
        // Registrar el laptop
        registrarLaptop(
                txtFabricante.getText(), 
                txtModelo.getText(),
                txtMicroprocesador.getText(),
                txtMemoria.getText(), 
                txtTamañoPantalla.getText(), 
                txtCapacidadDiscoDuroLaptop.getText(),
                comboUnidadMemoria, 
                comboUnidadPantalla, 
                comboUnidadDiscoLaptop, 
                rutaImagenSeleccionadaString,
                txtFabricante, 
                txtModelo, 
                txtMicroprocesador, 
                txtMemoria, 
                txtTamañoPantalla, 
                txtCapacidadDiscoDuroLaptop
        );

        // Limpiar imagen
        labelImagen.setIcon(null);

        // Limpiar campos de texto
        txtFabricante.setText("");
        txtModelo.setText("");
        txtMicroprocesador.setText("");
        txtMemoria.setText("");
        txtTamañoPantalla.setText("");
        txtCapacidadDiscoDuroLaptop.setText("");

        // Limpiar ruta de imagen
        rutaImagenSeleccionadaString = "";
    });
    break;


        case "Tablet":
            JTextField txtTamañoPantallaTablet = new JTextField();
            JComboBox<String> cbTipoPantalla = new JComboBox<>(new String[]{"Capacitiva", "Resistiva"});
            JTextField txtTamañoMemoriaNAND = new JTextField();
            JTextField txtSistemaOperativo = new JTextField();
            JComboBox<String> comboUnidadPantallaT = createComboBox(new String[]{"IN", "M"});
            JComboBox<String> comboUnidadMemoriaNAND = createComboBox(new String[]{"GB", "TB"});

            panelIzquierda.add(createFieldPanelWithCombo("Tamaño de Pantalla:", txtTamañoPantallaTablet, comboUnidadPantallaT));
            panelIzquierda.add(createFieldPanel("Tipo de Pantalla:", cbTipoPantalla));
            panelIzquierda.add(createFieldPanelWithCombo("Tamaño de Memoria NAND:", txtTamañoMemoriaNAND, comboUnidadMemoriaNAND));
            panelIzquierda.add(createFieldPanel("Sistema Operativo:", txtSistemaOperativo));

            btnRegistrar = crearBoton("Registrar Tablet");
            btnRegistrar.addActionListener(e -> {
            registrarTablet(
            txtFabricante.getText(), txtModelo.getText(), txtMicroprocesador.getText(),
            txtTamañoPantallaTablet.getText(), cbTipoPantalla.getSelectedItem().toString(), comboUnidadPantallaT.getSelectedItem().toString(),
            txtTamañoMemoriaNAND.getText(), comboUnidadMemoriaNAND.getSelectedItem().toString(),
            txtSistemaOperativo.getText(), rutaImagenSeleccionadaString,
            txtFabricante, txtModelo, txtMicroprocesador, txtTamañoPantallaTablet, txtTamañoMemoriaNAND, txtSistemaOperativo
         );
            // Limpiar imagen
             labelImagen.setIcon(null);
            rutaImagenSeleccionadaString = ""; // Asegúrate de que esta variable esté definida en el contexto correcto
            // Limpiar campos de texto
            txtFabricante.setText("");
            txtModelo.setText("");
            txtMicroprocesador.setText("");
            txtTamañoPantallaTablet.setText("");
            txtTamañoMemoriaNAND.setText("");
            txtSistemaOperativo.setText("");
            });
            break;

        default:
            throw new IllegalStateException("Unexpected value: " + tipoEquipo);
    }

    JButton btnVolverRegistro = crearBoton("Volver al Menú de Registro");
    btnVolverRegistro.addActionListener(e -> cardLayout.show(panelPrincipal, "RegistrarEquipo"));

    JButton btnVolverPrincipal = crearBoton("Volver al Menú Principal");
    btnVolverPrincipal.addActionListener(e -> cardLayout.show(panelPrincipal, "Menu"));

    // Panel de botones
    JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 10)); // 1 fila y 3 columnas
    buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 25, 30, 25));

    JButton[] botones = {btnRegistrar, btnVolverRegistro, btnVolverPrincipal};
    for (JButton boton : botones) {
        boton.setPreferredSize(new Dimension(150, 40));
        boton.setFont(new Font("Arial", Font.BOLD, 16));
        boton.setBackground(new Color(70, 130, 180));
        boton.setForeground(Color.WHITE);
    }
    btnVolverRegistro.setForeground(Color.BLACK);

    buttonPanel.add(btnRegistrar);
    buttonPanel.add(btnVolverRegistro);
    buttonPanel.add(btnVolverPrincipal);
    
    btnImagenDispositivo.addActionListener(e -> seleccionarImagen(labelImagen));

    // Agregamos las secciones al panel principal
    mainPanel.add(panelTitulo, BorderLayout.NORTH);
    mainPanel.add(panelIzquierda, BorderLayout.WEST);
    mainPanel.add(panelCentro, BorderLayout.CENTER);
    mainPanel.add(panelDerecha, BorderLayout.EAST); // Invisible, pero proporciona margen
    mainPanel.add(buttonPanel, BorderLayout.SOUTH); // Los botones en la parte inferior

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
    
private void seleccionarImagen(JLabel label) {
        JFileChooser explorador = new JFileChooser();
        int resultado = explorador.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivo = explorador.getSelectedFile();
            rutaImagenSeleccionadaString = archivo.getAbsolutePath();
            
            // Mostramos la imagen en el JLabel
            ImageIcon icono = new ImageIcon(rutaImagenSeleccionadaString);
            // Escalamos la imagen al tamanio del JLabel
            Image imagenSeleccionada = icono.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
            label.setIcon(new ImageIcon(imagenSeleccionada));
        }
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
                                  String capacidadDiscoDuro, String unidadDisco, String imagenRuta, JTextField... campos) {
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
                equipos.add(new Desktop(fabricante, modelo, microprocesador, tarjetaGrafica, tamañoTorre, capacidadDiscoDuro, imagenRuta));
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
                                 JComboBox<String> comboUnidadDiscoLaptop, String rutaImagen, JTextField... campos) {
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
                equipos.add(new Laptop(fabricante, modelo, microprocesador, memoria, tamañoPantalla, capacidadDiscoDuro, rutaImagen));
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
                                 String sistemaOperativo, String rutaImagen, JTextField... campos) {
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
                equipos.add(new Tablet(fabricante, modelo, microprocesador, tamañoPantalla, tipoPantalla, tamañoMemoriaNAND, sistemaOperativo, rutaImagen));
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
