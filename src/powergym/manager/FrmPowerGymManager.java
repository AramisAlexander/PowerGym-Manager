/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package powergym.manager;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.ArrayList;
/**
 *
 * @author ALEXANDER
 */
public class FrmPowerGymManager extends JFrame {

    // INSTANCIAS PRINCIPALES DEL SISTEMA
    private GestionSocios   gestion    = new GestionSocios();
    private InventarioPolos inventario = new InventarioPolos();
    
    // BARRA DE MENU Y SU SUB MENUS
    private JMenuBar  barraMenu;
    private JMenu     menuSocios;
    private JMenu     menuInventario;
    private JMenu     menuSuplementos;
    private JMenu     menuSistema;

    private JMenuItem itemRegistrar;
    private JMenuItem itemBuscar;
    private JMenuItem itemListar;
    private JMenuItem itemInventario;
    private JMenuItem itemComprar;
    private JMenuItem itemSalir;
    
    // PANEL PRINCIPAL DEL SISTEMA
    // CardLayout controla el cambio de pantallas.
    // panelPrincipal contiene todos los formularios.
    private CardLayout cardLayout;
    private JPanel panelPrincipal;
    
    // PANEL REEGISTRAR SOCIO
    private JPanel panelRegistrar;
    private JLabel lblTipoDoc, lblNroDoc, lblNombre;
    private JLabel lblApellidoPat, lblApellidoMat, lblEdad;
    private JLabel lblPeso, lblTalla, lblMembresia;
    private JLabel lblMeses, lblTallaPolo, lblInstructor;
    private JComboBox<String> cboTipoDoc, cboMembresia, cboTalla, cboInstructor;
    private JTextField txtNroDoc, txtNombre, txtApellidoPat;
    private JTextField txtApellidoMat, txtEdad, txtPeso, txtTalla, txtMeses;
    private JButton btnRegistrar, btnLimpiar;

    // PANEL BUSCAR SOCIO
    private JPanel     panelBuscar;
    private JLabel     lblBuscarDni;
    private JTextField txtBuscarDni;
    private JButton    btnBuscarSocio;
    private JTextArea  txtResultadoBusqueda;

    // PANEL LISTAR SOCIOS
    private JPanel            panelListar;
    private JTable            tablaSocios;
    private DefaultTableModel modeloTabla;

    // PANEL INVENTARIO
    private JPanel    panelInventario;
    private JTextArea txtInventario;

    // PANEL SUPLEMENTOS
    private JPanel            panelSuplementos;
    private JLabel            lblDniSup;
    private JTextField        txtDniSup;
    private JButton           btnBuscarSocioSup;
    private JTextArea         txtInfoSocio;
    private JList<String>     listaSuplementos;
    private JLabel            lblPrecioBase, lblDescuento, lblPrecioFinal;
    private JButton           btnComprar;
    private Socio socioActual = null;
    private ArrayList<Suplemento> catalogo = new ArrayList<>();

    // CONSTRUCTOR
    public FrmPowerGymManager() {

        setTitle("POWER GYM MANAGER");
        setSize(900, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Catálogo de suplementos
        catalogo.add(new Suplemento("Proteina Whey 1kg",  120.00));
        catalogo.add(new Suplemento("Creatina 500g",       80.00));
        catalogo.add(new Suplemento("BCAA 300g",           60.00));
        catalogo.add(new Suplemento("Pre-entreno 250g",    75.00));
        crearMenu();
        
        cardLayout      = new CardLayout();
        panelPrincipal  = new JPanel(cardLayout);
        crearPanelRegistrar();
        crearPanelBuscar();
        crearPanelListar();
        crearPanelInventario();
        crearPanelSuplementos();

        panelPrincipal.add(panelRegistrar,   "REGISTRAR");
        panelPrincipal.add(panelBuscar,      "BUSCAR");
        panelPrincipal.add(panelListar,      "LISTAR");
        panelPrincipal.add(panelInventario,  "INVENTARIO");
        panelPrincipal.add(panelSuplementos, "SUPLEMENTOS");

        add(panelPrincipal);
        cardLayout.show(panelPrincipal, "REGISTRAR");
    }

    // CREAR MENU
    private void crearMenu() {
        
        // Menus principales
        barraMenu = new JMenuBar();
        menuSocios = new JMenu("Socios");
        menuInventario = new JMenu("Inventario");
        menuSuplementos= new JMenu("Suplementos");
        menuSistema    = new JMenu("Sistema");

        // Sub menus
        itemRegistrar  = new JMenuItem("Registrar Socio");
        itemBuscar     = new JMenuItem("Buscar Socio");
        itemListar     = new JMenuItem("Listar Socios");
        itemInventario = new JMenuItem("Ver Inventario");
        itemComprar    = new JMenuItem("Comprar Suplemento");
        itemSalir      = new JMenuItem("Salir");

        menuSocios.add(itemRegistrar);
        menuSocios.add(itemBuscar);
        menuSocios.add(itemListar);

        menuInventario.add(itemInventario);
        menuSuplementos.add(itemComprar);
        menuSistema.add(itemSalir);

        barraMenu.add(menuSocios);
        barraMenu.add(menuInventario);
        barraMenu.add(menuSuplementos);
        barraMenu.add(menuSistema);

        // Eventos de los menús del sistema
        setJMenuBar(barraMenu);
        itemRegistrar .addActionListener(e -> cardLayout.show(panelPrincipal, "REGISTRAR"));
        itemBuscar    .addActionListener(e -> cardLayout.show(panelPrincipal, "BUSCAR"));
        itemListar    .addActionListener(e -> { cargarTabla(); cardLayout.show(panelPrincipal, "LISTAR"); });
        itemInventario.addActionListener(e -> { cargarInventario(); cardLayout.show(panelPrincipal, "INVENTARIO"); });
        itemComprar   .addActionListener(e -> cardLayout.show(panelPrincipal, "SUPLEMENTOS"));
        itemSalir     .addActionListener(e -> System.exit(0));
    }

    // PANEL REGISTRAR SOCIO
    private void crearPanelRegistrar() {

        panelRegistrar = new JPanel();
        panelRegistrar.setLayout(null);

        JLabel titulo = new JLabel("REGISTRO DE SOCIOS");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setBounds(300, 20, 300, 30);
        panelRegistrar.add(titulo);

        lblTipoDoc    = new JLabel("Tipo Documento");
        lblNroDoc     = new JLabel("Numero Documento");
        lblNombre     = new JLabel("Nombre");
        lblApellidoPat= new JLabel("Apellido Paterno");
        lblApellidoMat= new JLabel("Apellido Materno");
        lblEdad       = new JLabel("Edad");
        lblPeso       = new JLabel("Peso (Kg)");
        lblTalla      = new JLabel("Talla (Cm)");
        lblMembresia  = new JLabel("Membresia");
        lblMeses      = new JLabel("Meses");
        lblTallaPolo  = new JLabel("Talla Polo");
        lblInstructor = new JLabel("Instructor");

        lblTipoDoc.setBounds(50, 80, 150, 25);
        lblNroDoc.setBounds(50, 120, 150, 25);
        lblNombre.setBounds(50, 160, 150, 25);
        lblApellidoPat.setBounds(50, 200, 150, 25);
        lblApellidoMat.setBounds(50, 240, 150, 25);
        lblEdad.setBounds(50, 280, 150, 25);
        lblPeso.setBounds(450, 80, 150, 25);
        lblTalla.setBounds(450, 120, 150, 25);
        lblMembresia.setBounds(450, 160, 150, 25);
        lblMeses.setBounds(450, 200, 150, 25);
        lblTallaPolo.setBounds(450, 240, 150, 25);
        lblInstructor.setBounds(450, 280, 150, 25);

        panelRegistrar.add(lblTipoDoc);
        panelRegistrar.add(lblNroDoc);
        panelRegistrar.add(lblNombre);
        panelRegistrar.add(lblApellidoPat);
        panelRegistrar.add(lblApellidoMat);
        panelRegistrar.add(lblEdad);
        panelRegistrar.add(lblPeso);
        panelRegistrar.add(lblTalla);
        panelRegistrar.add(lblMembresia);
        panelRegistrar.add(lblMeses);
        panelRegistrar.add(lblTallaPolo);
        panelRegistrar.add(lblInstructor);

        // Campos
        cboTipoDoc = new JComboBox<>();
        cboTipoDoc.addItem("DNI");
        cboTipoDoc.addItem("CE");

        txtNroDoc      = new JTextField();
        txtNombre      = new JTextField();
        txtApellidoPat = new JTextField();
        txtApellidoMat = new JTextField();
        txtEdad        = new JTextField();
        txtPeso        = new JTextField();
        txtTalla       = new JTextField();

        cboMembresia = new JComboBox<>();
        cboMembresia.addItem("Basica");
        cboMembresia.addItem("VIP");

        txtMeses = new JTextField();

        cboTalla = new JComboBox<>();
        cboTalla.addItem("S");
        cboTalla.addItem("M");
        cboTalla.addItem("L");
        cboTalla.addItem("XL");

        cboInstructor = new JComboBox<>();
        cboInstructor.addItem("Carlos Perez");
        cboInstructor.addItem("Ana Torres");

        cboTipoDoc.setBounds(200, 80, 180, 25);
        txtNroDoc.setBounds(200, 120, 180, 25);
        txtNombre.setBounds(200, 160, 180, 25);
        txtApellidoPat.setBounds(200, 200, 180, 25);
        txtApellidoMat.setBounds(200, 240, 180, 25);
        txtEdad.setBounds(200, 280, 180, 25);

        txtPeso.setBounds(600, 80, 180, 25);
        txtTalla.setBounds(600, 120, 180, 25);
        cboMembresia.setBounds(600, 160, 180, 25);
        txtMeses.setBounds(600, 200, 180, 25);
        cboTalla.setBounds(600, 240, 180, 25);
        cboInstructor.setBounds(600, 280, 180, 25);

        panelRegistrar.add(cboTipoDoc);
        panelRegistrar.add(txtNroDoc);
        panelRegistrar.add(txtNombre);
        panelRegistrar.add(txtApellidoPat);
        panelRegistrar.add(txtApellidoMat);
        panelRegistrar.add(txtEdad);
        panelRegistrar.add(txtPeso);
        panelRegistrar.add(txtTalla);
        panelRegistrar.add(cboMembresia);
        panelRegistrar.add(txtMeses);
        panelRegistrar.add(cboTalla);
        panelRegistrar.add(cboInstructor);

        // Botones
        btnRegistrar = new JButton("Registrar");
        btnLimpiar   = new JButton("Limpiar");

        btnRegistrar.setBounds(280, 380, 150, 40);
        btnLimpiar.setBounds(450, 380, 150, 40);

        panelRegistrar.add(btnRegistrar);
        panelRegistrar.add(btnLimpiar);

        btnRegistrar.addActionListener(e -> registrarSocio());
        btnLimpiar  .addActionListener(e -> limpiarCampos());
    }

    // METODO REGISTRAR SOCIO

    private void registrarSocio() {
        try {
            String tipoDoc     = cboTipoDoc.getSelectedItem().toString();
            String nroDoc      = txtNroDoc.getText().trim();
            String nombre      = txtNombre.getText().trim();
            String apellidoPat = txtApellidoPat.getText().trim();
            String apellidoMat = txtApellidoMat.getText().trim();
            int    edad        = Integer.parseInt(txtEdad.getText().trim());
            double peso        = Double.parseDouble(txtPeso.getText().trim());
            double talla       = Double.parseDouble(txtTalla.getText().trim());
            String membresia   = cboMembresia.getSelectedItem().toString();
            int    meses       = Integer.parseInt(txtMeses.getText().trim());
            String tallaPolo   = cboTalla.getSelectedItem().toString();
            int    codIns      = cboInstructor.getSelectedIndex() + 1;
            Instructor instructor = gestion.obtenerInstructor(codIns);

            if (inventario.getStockDeTalla(tallaPolo) <= 0) {
                JOptionPane.showMessageDialog(this,
                        "No existe stock para la talla " + tallaPolo);
                return;
            }
            Socio socio = gestion.registrarSocio(tipoDoc, nroDoc, nombre,
                    apellidoPat, apellidoMat, edad, peso, talla,
                    membresia, meses, tallaPolo, instructor);

            inventario.entregarPolo(tallaPolo);
            JOptionPane.showMessageDialog(this,
                    "Socio registrado correctamente\n\n"
                    + "Codigo        : " + socio.getCodigoSocio()
                    + "\nIMC           : " + String.format("%.2f", socio.getEvaluacion().getImc())
                    + "\nClasificacion : " + socio.getEvaluacion().getClasificacion());

            limpiarCampos();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error: Edad, Peso, Talla y Meses deben ser numeros validos.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error en los datos ingresados.");
        }
    }

    // METODO LIMPIAR CAMPOS
    private void limpiarCampos() {
        txtNroDoc.setText("");
        txtNombre.setText("");
        txtApellidoPat.setText("");
        txtApellidoMat.setText("");
        txtEdad.setText("");
        txtPeso.setText("");
        txtTalla.setText("");
        txtMeses.setText("");
        cboTipoDoc.setSelectedIndex(0);
        cboMembresia.setSelectedIndex(0);
        cboTalla.setSelectedIndex(0);
        cboInstructor.setSelectedIndex(0);
    }

    // CREAR PANEL BUSCAR SOCIO
    private void crearPanelBuscar() {

        panelBuscar = new JPanel();
        panelBuscar.setLayout(null);

        JLabel titulo = new JLabel("BUSCAR SOCIO");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setBounds(320, 30, 250, 30);
        panelBuscar.add(titulo);

        lblBuscarDni = new JLabel("DNI:");
        lblBuscarDni.setBounds(150, 100, 80, 25);
        panelBuscar.add(lblBuscarDni);

        txtBuscarDni = new JTextField();
        txtBuscarDni.setBounds(220, 100, 200, 25);
        panelBuscar.add(txtBuscarDni);

        btnBuscarSocio = new JButton("Buscar");
        btnBuscarSocio.setBounds(450, 95, 120, 35);
        panelBuscar.add(btnBuscarSocio);

        txtResultadoBusqueda = new JTextArea();
        txtResultadoBusqueda.setEditable(false);
        JScrollPane scroll = new JScrollPane(txtResultadoBusqueda);
        scroll.setBounds(120, 170, 600, 350);
        panelBuscar.add(scroll);

        btnBuscarSocio.addActionListener(e -> buscarSocio());
        txtBuscarDni  .addActionListener(e -> buscarSocio());
    }

    // METODO BUSCAR SOCIO
    private void buscarSocio() {
        String dni  = txtBuscarDni.getText().trim();
        Socio  socio = gestion.buscarPorDni(dni);

        if (socio == null) {
            JOptionPane.showMessageDialog(this, "Socio no encontrado.");
            txtResultadoBusqueda.setText("");
            return;
        }

        String resultado =
                "====================================\n"
              + "FICHA DEL SOCIO\n"
              + "====================================\n"
              + "Codigo        : " + socio.getCodigoSocio()
              + "\nNombre        : " + socio.getNombre()
                        + " " + socio.getApellidPate()
                        + " " + socio.getApellidmate()
              + "\nDocumento     : " + socio.getTipoDoc()
                        + " " + socio.getNroDoc()
              + "\nEdad          : " + socio.getEdad()
              + "\n------------------------------------"
              + "\nPeso          : " + socio.getEvaluacion().getPesoKg() + " kg"
              + "\nTalla         : " + socio.getEvaluacion().getTallaCm() + " cm"
              + "\nIMC           : " + String.format("%.2f", socio.getEvaluacion().getImc())
              + "\nClasificacion : " + socio.getEvaluacion().getClasificacion()
              + "\nInstructor    : " + socio.getEvaluacion().getInstructor().getNombre()
                        + " " + socio.getEvaluacion().getInstructor().getApellidPate()
              + "\n------------------------------------"
              + "\nMembresia     : " + socio.getMembresia().getTipo()
              + "\nDuracion      : " + socio.getMembresia().getMesesDuracion() + " meses"
              + "\nBeneficio     : " + (socio.getMembresia().getTipo().equals("VIP") ? "15% descuento en suplementos" : "Sin descuento en suplementos")
              + "\nTalla Polo    : " + socio.getTallaPolo()
              + "\n====================================";

        txtResultadoBusqueda.setText(resultado);
    }

    // CREAR PANEL LISTAR SOCIOS
    private void crearPanelListar() {

        panelListar = new JPanel();
        panelListar.setLayout(null);

        JLabel titulo = new JLabel("LISTA DE SOCIOS");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setBounds(330, 20, 250, 30);
        panelListar.add(titulo);

        String[] columnas = {"Codigo", "Documento", "Nombre", "Edad",
                             "Membresia", "Meses", "IMC", "Clasificacion", "Polo"};
        modeloTabla = new DefaultTableModel(columnas, 0) {
            public boolean isCellEditable(int r, int c) { return false; }
        };

        tablaSocios = new JTable(modeloTabla);
        tablaSocios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scroll = new JScrollPane(tablaSocios);
        scroll.setBounds(30, 70, 820, 480);
        panelListar.add(scroll);
    }

    // METODO CARGAR TABLA SOCIOS
    private void cargarTabla() {
        modeloTabla.setRowCount(0);
        for (Socio s : gestion.getSocios()) {
            modeloTabla.addRow(new Object[]{
                s.getCodigoSocio(),
                s.getTipoDoc() + ": " + s.getNroDoc(),
                s.getNombre() + " " + s.getApellidPate() + " " + s.getApellidmate(),
                s.getEdad(),
                s.getMembresia().getTipo(),
                s.getMembresia().getMesesDuracion(),
                String.format("%.2f", s.getEvaluacion().getImc()),
                s.getEvaluacion().getClasificacion(),
                s.getTallaPolo()
            });
        }
    }

    // CREAR PANEL INVENTARIO
    private void crearPanelInventario() {

        panelInventario = new JPanel();
        panelInventario.setLayout(null);

        JLabel titulo = new JLabel("INVENTARIO DE POLOS");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setBounds(300, 20, 300, 30);
        panelInventario.add(titulo);

        txtInventario = new JTextArea();
        txtInventario.setEditable(false);
        txtInventario.setFont(new Font("Monospaced", Font.PLAIN, 14));

        JScrollPane scroll = new JScrollPane(txtInventario);
        scroll.setBounds(200, 80, 450, 300);
        panelInventario.add(scroll);
    }

    // METODO CARGAR INVENTARIO
    private void cargarInventario() {
        String[] tallas = {"S", "M", "L", "XL"};

        StringBuilder sb = new StringBuilder();
        sb.append("========================================\n");
        sb.append("       INVENTARIO DE POLOS KIT\n");
        sb.append("========================================\n");
        sb.append(String.format("  %-8s  %s%n", "Talla", "Stock disponible"));
        sb.append("  ------    ----------------\n");
        for (String talla : tallas) {
            int stock = inventario.getStockDeTalla(talla);
            sb.append(String.format("  %-8s  %d unidades%n", talla, stock));
        }
        sb.append("========================================");
        txtInventario.setText(sb.toString());
    }

    // CREAR PANEL SUPLEMENTOS
    private void crearPanelSuplementos() {

        panelSuplementos = new JPanel();
        panelSuplementos.setLayout(null);

        JLabel titulo = new JLabel("COMPRAR SUPLEMENTO");
        titulo.setFont(new Font("Arial", Font.BOLD, 22));
        titulo.setBounds(280, 20, 320, 30);
        panelSuplementos.add(titulo);

        // Buscar socio
        lblDniSup = new JLabel("DNI del Socio:");
        lblDniSup.setBounds(50, 80, 120, 25);
        panelSuplementos.add(lblDniSup);

        txtDniSup = new JTextField();
        txtDniSup.setBounds(175, 80, 180, 25);
        panelSuplementos.add(txtDniSup);

        btnBuscarSocioSup = new JButton("Buscar Socio");
        btnBuscarSocioSup.setBounds(370, 76, 130, 33);
        panelSuplementos.add(btnBuscarSocioSup);

        // Info socio
        txtInfoSocio = new JTextArea();
        txtInfoSocio.setEditable(false);
        txtInfoSocio.setBackground(new Color(240, 240, 240));
        JScrollPane scrollInfo = new JScrollPane(txtInfoSocio);
        scrollInfo.setBounds(50, 125, 450, 70);
        panelSuplementos.add(scrollInfo);

        // Lista suplementos
        JLabel lblCatalogo = new JLabel("Catalogo de Suplementos:");
        lblCatalogo.setFont(new Font("Arial", Font.BOLD, 13));
        lblCatalogo.setBounds(50, 215, 220, 25);
        panelSuplementos.add(lblCatalogo);

        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (Suplemento s : catalogo) {
            modelo.addElement(String.format("%-25s  S/ %.2f", s.getNombre(), s.getPrecioBase()));
        }
        listaSuplementos = new JList<>(modelo);
        listaSuplementos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaSuplementos.setFont(new Font("Monospaced", Font.PLAIN, 13));
        JScrollPane scrollLista = new JScrollPane(listaSuplementos);
        scrollLista.setBounds(50, 245, 450, 120);
        panelSuplementos.add(scrollLista);

        // Precios
        lblPrecioBase  = new JLabel("Precio base   : ---");
        lblDescuento   = new JLabel("Descuento     : ---");
        lblPrecioFinal = new JLabel("Precio final  : ---");
        lblPrecioBase .setFont(new Font("Arial", Font.PLAIN, 13));
        lblDescuento  .setFont(new Font("Arial", Font.PLAIN, 13));
        lblPrecioFinal.setFont(new Font("Arial", Font.BOLD,  14));

        lblPrecioBase .setBounds(550, 245, 280, 25);
        lblDescuento  .setBounds(550, 280, 280, 25);
        lblPrecioFinal.setBounds(550, 315, 280, 25);

        panelSuplementos.add(lblPrecioBase);
        panelSuplementos.add(lblDescuento);
        panelSuplementos.add(lblPrecioFinal);

        // Boton comprar
        btnComprar = new JButton("Confirmar Compra");
        btnComprar.setBounds(550, 365, 180, 35);
        panelSuplementos.add(btnComprar);

        // Eventos
        btnBuscarSocioSup.addActionListener(e -> buscarSocioParaCompra());
        txtDniSup        .addActionListener(e -> buscarSocioParaCompra());

        listaSuplementos.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) calcularPrecioSuplemento();
        });

        btnComprar.addActionListener(e -> confirmarCompra());
    }

    // METODO BUSCAR SOCIO PARA COMPRA
    private void buscarSocioParaCompra() {
        String dni = txtDniSup.getText().trim();
        socioActual = gestion.buscarPorDni(dni);

        if (socioActual == null) {
            JOptionPane.showMessageDialog(this, "Socio no encontrado.");
            txtInfoSocio.setText("");
            lblPrecioBase.setText("Precio base   : ---");
            lblDescuento.setText("Descuento     : ---");
            lblPrecioFinal.setText("Precio final  : ---");
            return;
        }

        txtInfoSocio.setText(
                "Socio : " + socioActual.getNombre()
                + " " + socioActual.getApellidPate()
                + "\nMembresia: " + socioActual.getMembresia().getTipo()
                + "  |  " + (socioActual.getMembresia().getTipo().equals("VIP") ? "15% descuento en suplementos" : "Sin descuento en suplementos"));

        calcularPrecioSuplemento();
    }

    // METODO CALCULAR PRECIO SUPLEMENTO
    private void calcularPrecioSuplemento() {
        int idx = listaSuplementos.getSelectedIndex();
        if (idx < 0 || socioActual == null) return;

        Suplemento sup    = catalogo.get(idx);
        double base       = sup.getPrecioBase();
        double precioFinal= socioActual.calcularPrecioSuplemento(base);
        double descuento  = base - precioFinal;

        lblPrecioBase .setText(String.format("Precio base   : S/ %.2f", base));
        lblDescuento  .setText(String.format("Descuento     : S/ %.2f", descuento));
        lblPrecioFinal.setText(String.format("Precio final  : S/ %.2f", precioFinal));
    }

    // METODO CONFIRMAR COMPRA
    private void confirmarCompra() {
        if (socioActual == null) {
            JOptionPane.showMessageDialog(this, "Primero busca un socio.");
            return;
        }
        int idx = listaSuplementos.getSelectedIndex();
        if (idx < 0) {
            JOptionPane.showMessageDialog(this, "Selecciona un suplemento.");
            return;
        }

        Suplemento sup    = catalogo.get(idx);
        double precioFinal= socioActual.calcularPrecioSuplemento(sup.getPrecioBase());

        JOptionPane.showMessageDialog(this,
                "Compra registrada exitosamente\n\n"
                + "Socio      : " + socioActual.getNombre()
                        + " " + socioActual.getApellidPate()
                + "\nSuplemento : " + sup.getNombre()
                + "\nPrecio     : S/ " + String.format("%.2f", precioFinal));
    }
}
