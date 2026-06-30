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
 * Formulario principal del sistema PowerGym Manager.
 * Contiene todos los paneles del sistema usando CardLayout para la navegación.
 * Incluye: Socios, Inventario de Polos, Suplementos, Ventas y Sistema.
 *
 * @author ALEXANDER
 */
public class FrmPowerGymManager extends JFrame {

   //COLORES TEMÁTICA GYM 
    private static final Color C_FONDO      = new Color(18, 18, 18);
    private static final Color C_PANEL      = new Color(30, 30, 30);
    private static final Color C_PANEL2     = new Color(38, 38, 38);
    private static final Color C_ROJO       = new Color(220, 30, 30);
    private static final Color C_ROJO2      = new Color(170, 15, 15);
    private static final Color C_TEXTO      = new Color(240, 240, 240);
    private static final Color C_TEXTO2     = new Color(170, 170, 170);
    private static final Color C_BORDE      = new Color(60, 60, 60);
    private static final Color C_CAMPO      = new Color(48, 48, 48);
    private static final Color C_TH         = new Color(42, 42, 42);
    private static final Color C_ROW1       = new Color(34, 34, 34);
    private static final Color C_ROW2       = new Color(27, 27, 27);
    private static final Color C_SEL        = new Color(180, 30, 30);
    private static final Color C_ALERTA     = new Color(255, 193, 7);
    private static final Font  F_TITULO     = new Font("Arial", Font.BOLD, 22);
    private static final Font  F_LBL        = new Font("Arial", Font.PLAIN, 13);
    private static final Font  F_BOLD       = new Font("Arial", Font.BOLD, 13);
    private static final Font  F_BTN        = new Font("Arial", Font.BOLD, 13);
    private static final Font  F_MONO       = new Font("Monospaced", Font.PLAIN, 13);

    //INSTANCIAS PRINCIPALES 
    private GestionSocios   gestion    = new GestionSocios();
    private InventarioPolos inventario = new InventarioPolos();

    //Lista de suplementos registrados.
    private ArrayList<Suplemento> listaSupl = new ArrayList<>();

    //Contador para generar códigos de suplemento automáticamente.
    private int contadorSupl = 1;

    //Lista de ventas realizadas.
    private ArrayList<Venta> listaVentas = new ArrayList<>();

    //Contador autoincrementable para código de venta. 
    private int contadorVenta = 1;

    //MENU
    private JMenuBar  barraMenu;
    private JMenu     menuSocios;
    private JMenu     menuInventario;
    private JMenu     menuSuplementos;
    private JMenu     menuVentas;
    private JMenu     menuSistema;

    private JMenuItem itemRegistrar;
    private JMenuItem itemBuscar;
    private JMenuItem itemListar;
    private JMenuItem itemInventario;
    private JMenuItem itemRegPolos;
    private JMenuItem itemAgregarStockPolos;   
    private JMenuItem itemComprar;
    private JMenuItem itemRegSupl;
    private JMenuItem itemAgregarStockSupl;    
    private JMenuItem itemRegVenta;
    private JMenuItem itemSalir;

    //CARD LAYOUT 
    private CardLayout cardLayout;
    private JPanel     panelPrincipal;

    //PANEL REGISTRAR SOCIO
    private JPanel panelRegistrar;
    private JLabel lblTipoDoc, lblNroDoc, lblNombre;
    private JLabel lblApellidoPat, lblApellidoMat, lblEdad;
    private JLabel lblPeso, lblTalla, lblMembresia;
    private JLabel lblMeses, lblTallaPolo, lblInstructor;
    private JLabel lblCelular, lblCorreo;
    private JComboBox<String> cboTipoDoc, cboMembresia, cboTalla, cboInstructor;
    private JTextField txtNroDoc, txtNombre, txtApellidoPat;
    private JTextField txtApellidoMat, txtEdad, txtPeso, txtTalla, txtMeses;
    private JTextField txtCelular, txtCorreo;
    private JButton btnRegistrar, btnLimpiar;

    //PANEL BUSCAR SOCIO 
    private JPanel     panelBuscar;
    private JLabel     lblBuscarDni;
    private JTextField txtBuscarDni;
    private JButton    btnBuscarSocio;
    private JTextArea  txtResultadoBusqueda;

    //PANEL LISTAR SOCIOS 
    private JPanel            panelListar;
    private JTable            tablaSocios;
    private DefaultTableModel modeloTabla;

    //PANEL INVENTARIO DE POLOS
    private JPanel            panelInventario;
    private JTable            tablaInventarioPolos;
    private DefaultTableModel modeloTablaInventarioPolos;

    //PANEL REGISTRAR POLO 
    private JPanel            panelRegPolos;
    private JTextField        txtNomPolo, txtStockPolo;
    private JComboBox<String> cboTallaPolo;
    private JTable            tablaPolos;
    private DefaultTableModel modeloTablaPolos;

    //PANEL AGREGAR STOCK DE POLOS 
    private JPanel            panelAgregarStockPolos;
    private JComboBox<String> cboPoloStock;
    private JTextField        txtCantAgregarPolo;
    private JLabel            lblInfoPoloStock;
    private JTable            tablaPolosStock;
    private DefaultTableModel modeloTablaPolosStock;

    //PANEL REGISTRAR SUPLEMENTO
    private JPanel            panelRegSupl;
    private JTextField        txtNomSupl, txtPrecioSupl, txtStockSupl;
    private JTable            tablaSupl;
    private DefaultTableModel modeloTablaSupl;

    //PANEL AGREGAR STOCK DE SUPLEMENTOS 
    private JPanel            panelAgregarStockSupl;
    private JComboBox<String> cboSuplStock;
    private JTextField        txtCantAgregarSupl;
    private JLabel            lblInfoSuplStock;
    private JTable            tablaSuplStock;
    private DefaultTableModel modeloTablaSuplStock;

    //PANEL COMPRAR SUPLEMENTO 
    private JPanel            panelSuplementos;
    private JLabel            lblDniSup;
    private JTextField        txtDniSup;
    private JButton           btnBuscarSocioSup;
    private JTextArea         txtInfoSocio;
    private JList<String>     listaSuplementos;
    private JLabel            lblPrecioBase, lblDescuento, lblPrecioFinal;
    private JButton           btnComprar;
    private Socio             socioActual = null;

    //PANEL REGISTRAR VENTA 
    private JPanel            panelVenta;
    private JComboBox<String> cboVentaSupl;
    private JTextField        txtVentaCantidad;
    private JLabel            lblVentaNomSupl, lblVentaPrecioUnit;
    private JLabel            lblVentaCantidad2, lblVentaTotal;
    private JButton           btnRegistrarVenta, btnLimpiarVenta;
    private JTable            tablaVentas;
    private DefaultTableModel modeloTablaVentas;

    //CONSTRUCTOR PRINCIPAL DEL FORMULARIO
    public FrmPowerGymManager() {
        setTitle("POWER GYM MANAGER");
        setSize(980, 720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        aplicarTemaGlobal();

        // Catálogo inicial de suplementos.
        listaSupl.add(new Suplemento(generarCodigoSupl(), "Proteina Whey 1kg", 120.00, 50));
        listaSupl.add(new Suplemento(generarCodigoSupl(), "Creatina 500g",      80.00, 30));
        listaSupl.add(new Suplemento(generarCodigoSupl(), "BCAA 300g",          60.00,  3));
        listaSupl.add(new Suplemento(generarCodigoSupl(), "Pre-entreno 250g",   75.00, 25));

        crearMenu();

        cardLayout     = new CardLayout();
        panelPrincipal = new JPanel(cardLayout);
        panelPrincipal.setBackground(C_FONDO);

        crearPanelRegistrar();
        crearPanelBuscar();
        crearPanelListar();
        crearPanelInventario();
        crearPanelRegPolos();
        crearPanelAgregarStockPolos();
        crearPanelRegSupl();
        crearPanelAgregarStockSupl();
        crearPanelSuplementos();
        crearPanelVenta();

        panelPrincipal.add(panelRegistrar, "REGISTRAR");
        panelPrincipal.add(panelBuscar, "BUSCAR");
        panelPrincipal.add(panelListar, "LISTAR");
        panelPrincipal.add(panelInventario, "INVENTARIO");
        panelPrincipal.add(panelRegPolos, "REG_POLOS");
        panelPrincipal.add(panelAgregarStockPolos, "STOCK_POLOS");
        panelPrincipal.add(panelRegSupl, "REG_SUPL");
        panelPrincipal.add(panelAgregarStockSupl, "STOCK_SUPL");
        panelPrincipal.add(panelSuplementos, "SUPLEMENTOS");
        panelPrincipal.add(panelVenta, "VENTA");

        add(panelPrincipal);
        cardLayout.show(panelPrincipal, "REGISTRAR");
    }

    //GENERADOR DE CÓDIGOS CORRELATIVOS
    private String generarCodigoSupl() {
        return String.format("S%03d", contadorSupl++);
    }

    //TEMA GLOBAL APLICA EL TEMA OSCURO AL APP GYM
    private void aplicarTemaGlobal() {
        UIManager.put("Panel.background",            C_FONDO);
        UIManager.put("Label.foreground",            C_TEXTO);
        UIManager.put("TextField.background",        C_CAMPO);
        UIManager.put("TextField.foreground",        C_TEXTO);
        UIManager.put("TextField.caretForeground",   C_ROJO);
        UIManager.put("TextField.border",            BorderFactory.createLineBorder(C_BORDE));
        UIManager.put("PasswordField.background",    C_CAMPO);
        UIManager.put("PasswordField.foreground",    C_TEXTO);
        UIManager.put("TextArea.background",         C_CAMPO);
        UIManager.put("TextArea.foreground",         C_TEXTO);
        UIManager.put("ComboBox.background",         C_CAMPO);
        UIManager.put("ComboBox.foreground",         C_TEXTO);
        UIManager.put("ComboBox.selectionBackground",C_ROJO);
        UIManager.put("ComboBox.selectionForeground",Color.WHITE);
        UIManager.put("List.background",             C_CAMPO);
        UIManager.put("List.foreground",             C_TEXTO);
        UIManager.put("List.selectionBackground",    C_ROJO);
        UIManager.put("List.selectionForeground",    Color.WHITE);
        UIManager.put("ScrollPane.background",       C_FONDO);
        UIManager.put("ScrollBar.background",        C_PANEL);
        UIManager.put("ScrollBar.thumb",             C_BORDE);
        UIManager.put("Table.background",            C_ROW1);
        UIManager.put("Table.foreground",            C_TEXTO);
        UIManager.put("Table.selectionBackground",   C_SEL);
        UIManager.put("Table.selectionForeground",   Color.WHITE);
        UIManager.put("Table.gridColor",             C_BORDE);
        UIManager.put("TableHeader.background",      C_TH);
        UIManager.put("TableHeader.foreground",      C_ROJO);
        UIManager.put("MenuBar.background",          C_PANEL);
        UIManager.put("MenuBar.foreground",          C_TEXTO);
        UIManager.put("Menu.background",             C_PANEL);
        UIManager.put("Menu.foreground",             C_TEXTO);
        UIManager.put("Menu.selectionBackground",    C_ROJO);
        UIManager.put("Menu.selectionForeground",    Color.WHITE);
        UIManager.put("MenuItem.background",         C_PANEL2);
        UIManager.put("MenuItem.foreground",         C_TEXTO);
        UIManager.put("MenuItem.selectionBackground",C_ROJO);
        UIManager.put("MenuItem.selectionForeground",Color.WHITE);
        UIManager.put("OptionPane.background",       C_PANEL);
        UIManager.put("OptionPane.messageForeground",C_TEXTO);
    }

    //COMPONENTES CON ESTILO
    private JPanel crearPanelConFondo(LayoutManager layout) {
        JPanel panel = new JPanel(layout) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                int w = getWidth(), h = getHeight();

                // Fondo degradado oscuro
                GradientPaint bg = new GradientPaint(
                        0, 0, new Color(12, 12, 12),
                        w, h, new Color(26, 26, 26));
                g2.setPaint(bg);
                g2.fillRect(0, 0, w, h);

                // Líneas diagonales decorativas
                g2.setStroke(new BasicStroke(0.7f));
                g2.setColor(new Color(38, 38, 38));
                for (int x = -h; x < w + h; x += 55) {
                    g2.drawLine(x, 0, x + h, h);
                }

                // Franja roja superior
                GradientPaint stripe = new GradientPaint(
                        0, 0, new Color(200, 25, 25, 180),
                        w, 0, new Color(130, 10, 10, 30));
                g2.setPaint(stripe);
                g2.fillRect(0, 0, w, 5);

                // Círculos decorativos tipo platos de pesa
                g2.setColor(new Color(200, 25, 25, 22));
                g2.fillOval(w - 240, h - 240, 310, 310);
                g2.setColor(new Color(200, 25, 25, 14));
                g2.fillOval(-70, h - 180, 230, 230);
                g2.setColor(new Color(200, 25, 25, 10));
                g2.fillOval(w - 120, 10, 160, 160);

                // Texto decorativo de fondo
                g2.setFont(new Font("Arial", Font.BOLD, 115));
                g2.setColor(new Color(255, 255, 255, 6));
                g2.drawString("POWER GYM", w / 2 - 320, h / 2 + 58);

                g2.dispose();
            }
        };
        panel.setOpaque(true);
        return panel;
    }

    //Aplica estilo oscuro a un JTextField. 
    private void estiloTxt(JTextField f) {
        f.setBackground(C_CAMPO);
        f.setForeground(C_TEXTO);
        f.setCaretColor(C_ROJO);
        f.setFont(F_LBL);
        f.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(C_BORDE),
                BorderFactory.createEmptyBorder(2, 7, 2, 7)));
    }

    //Aplica estilo oscuro a un JComboBox.
    private void estiloCombo(JComboBox<String> c) {
        c.setBackground(C_CAMPO);
        c.setForeground(C_TEXTO);
        c.setFont(F_LBL);
        c.setBorder(BorderFactory.createLineBorder(C_BORDE));
    }

    //Crea un JButton rojo de acción principal.
    private JButton crearBtn(String texto) {
        JButton b = new JButton(texto);
        b.setBackground(C_ROJO);
        b.setForeground(Color.WHITE);
        b.setFont(F_BTN);
        b.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        b.setFocusPainted(false);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e){ b.setBackground(C_ROJO2); }
            public void mouseExited (java.awt.event.MouseEvent e){ b.setBackground(C_ROJO); }
        });
        return b;
    }

    //Crea un JButton gris de acción secundaria. 
    private JButton crearBtn2(String texto) {
        JButton b = new JButton(texto);
        b.setBackground(C_BORDE);
        b.setForeground(C_TEXTO);
        b.setFont(F_BTN);
        b.setBorder(BorderFactory.createEmptyBorder(8, 16, 8, 16));
        b.setFocusPainted(false);
        b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        b.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent e){ b.setBackground(new Color(80,80,80)); }
            public void mouseExited (java.awt.event.MouseEvent e){ b.setBackground(C_BORDE); }
        });
        return b;
    }

    //Crea un JLabel de título con estilo de encabezado blanco. 
    private JLabel crearTitulo(String t) {
        JLabel l = new JLabel(t);
        l.setFont(F_TITULO);
        l.setForeground(Color.WHITE);
        return l;
    }

    //Crea un JLabel de etiqueta gris claro.
    private JLabel crearLbl(String t) {
        JLabel l = new JLabel(t);
        l.setFont(F_LBL);
        l.setForeground(C_TEXTO2);
        return l;
    }

    //Crea un separador rojo horizontal. 
    private JSeparator crearSep(int x, int y, int w) {
        JSeparator s = new JSeparator();
        s.setBounds(x, y, w, 2);
        s.setForeground(C_ROJO);
        s.setBackground(C_ROJO);
        return s;
    }

    //Crea un JScrollPane con borde oscuro. 
    private JScrollPane crearScroll(Component v) {
        JScrollPane s = new JScrollPane(v);
        s.setBackground(C_FONDO);
        s.setBorder(BorderFactory.createLineBorder(C_BORDE));
        s.getViewport().setBackground(C_FONDO);
        return s;
    }

    //Aplica estilo oscuro moderno a una JTable con filas alternadas. 
    private void estiloTabla(JTable t) {
        t.setBackground(C_ROW1);
        t.setForeground(C_TEXTO);
        t.setFont(F_LBL);
        t.setRowHeight(26);
        t.setGridColor(C_BORDE);
        t.setSelectionBackground(C_SEL);
        t.setSelectionForeground(Color.WHITE);
        t.setShowHorizontalLines(true);
        t.setShowVerticalLines(false);
        t.setIntercellSpacing(new Dimension(0, 1));
        JTableHeader h = t.getTableHeader();
        h.setBackground(C_TH);
        h.setForeground(C_ROJO);
        h.setFont(F_BOLD);
        h.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, C_ROJO));
        t.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable tbl, Object val, boolean sel, boolean foc, int row, int col) {
                Component c = super.getTableCellRendererComponent(tbl, val, sel, foc, row, col);
                if (!sel) {
                    c.setBackground(row % 2 == 0 ? C_ROW1 : C_ROW2);
                    c.setForeground(C_TEXTO);
                }
                return c;
            }
        });
    }

    // Agrega un JLabel y un JTextField al panel con estilo y posiciones definidas
    private JTextField ultimoTxt;
    private void addLblTxt(JPanel p, String lbl, int xl, int y, int xc, int w) {
        JLabel l = crearLbl(lbl);
        l.setBounds(xl, y, 150, 25);
        p.add(l);
        ultimoTxt = new JTextField();
        estiloTxt(ultimoTxt);
        ultimoTxt.setBounds(xc, y, w, 28);
        p.add(ultimoTxt);
    }

    //MENU
    private void crearMenu() {
        barraMenu       = new JMenuBar();
        barraMenu.setBackground(C_PANEL);
        barraMenu.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, C_ROJO));

        menuSocios      = new JMenu("Socios");
        menuInventario  = new JMenu("Inventario");
        menuSuplementos = new JMenu("Suplementos");
        menuVentas      = new JMenu("Ventas");
        menuSistema     = new JMenu("Sistema");

        for (JMenu m : new JMenu[]{menuSocios, menuInventario,
                menuSuplementos, menuVentas, menuSistema}) {
            m.setForeground(C_TEXTO);
            m.setFont(F_BOLD);
            m.setBackground(C_PANEL);
        }

        itemRegistrar          = new JMenuItem("Registrar Socio");
        itemBuscar             = new JMenuItem("Buscar Socio");
        itemListar             = new JMenuItem("Listar Socios");
        itemInventario         = new JMenuItem("Ver Inventario de Polos");
        itemRegPolos           = new JMenuItem("Registrar Polo");
        itemAgregarStockPolos  = new JMenuItem("Agregar Stock de Polos");
        itemRegSupl            = new JMenuItem("Registrar Suplemento");
        // Esto se arregló: Nueva opción en el menú Suplementos para reponer stock de suplementos.
        itemAgregarStockSupl   = new JMenuItem("Agregar Stock de Suplementos");
        itemComprar            = new JMenuItem("Comprar Suplemento");
        itemRegVenta           = new JMenuItem("Registrar Venta");
        itemSalir              = new JMenuItem("Salir");

        menuSocios.add(itemRegistrar);
        menuSocios.add(itemBuscar);
        menuSocios.add(itemListar);

        menuInventario.add(itemInventario);
        menuInventario.add(itemRegPolos);
        menuInventario.add(itemAgregarStockPolos);

        menuSuplementos.add(itemRegSupl);
        menuSuplementos.add(itemAgregarStockSupl);
        menuSuplementos.add(itemComprar);

        menuVentas.add(itemRegVenta);

        menuSistema.add(itemSalir);

        barraMenu.add(menuSocios);
        barraMenu.add(menuInventario);
        barraMenu.add(menuSuplementos);
        barraMenu.add(menuVentas);
        barraMenu.add(menuSistema);

        setJMenuBar(barraMenu);

        itemRegistrar.addActionListener(e ->
                cardLayout.show(panelPrincipal, "REGISTRAR"));
        itemBuscar.addActionListener(e ->
                cardLayout.show(panelPrincipal, "BUSCAR"));
        itemListar.addActionListener(e -> {
            cargarTabla();
            cardLayout.show(panelPrincipal, "LISTAR");
        });
        itemInventario.addActionListener(e -> {
            cargarInventario();
            cardLayout.show(panelPrincipal, "INVENTARIO");
        });
        itemRegPolos.addActionListener(e -> {
            cargarTablaPolos();
            cardLayout.show(panelPrincipal, "REG_POLOS");
        });

        itemAgregarStockPolos.addActionListener(e -> {
            cargarComboPolosStock();
            cargarTablaPolosStock();
            cardLayout.show(panelPrincipal, "STOCK_POLOS");
        });
        itemRegSupl.addActionListener(e -> {
            cargarTablaSupl();
            cardLayout.show(panelPrincipal, "REG_SUPL");
        });

        itemAgregarStockSupl.addActionListener(e -> {
            cargarComboSuplStock();
            cargarTablaSuplStock();
            cardLayout.show(panelPrincipal, "STOCK_SUPL");
        });
        itemComprar.addActionListener(e -> {
            actualizarListaSupl();
            cardLayout.show(panelPrincipal, "SUPLEMENTOS");
        });
        itemRegVenta.addActionListener(e -> {
            actualizarComboVentaSupl();
            cargarTablaVentas();
            cardLayout.show(panelPrincipal, "VENTA");
        });
        itemSalir.addActionListener(e -> System.exit(0));
    }

    //PANEL REGISTRAR SOCIO
    private void crearPanelRegistrar() {
        panelRegistrar = crearPanelConFondo(null);

        JLabel titulo = crearTitulo("REGISTRO DE SOCIOS");
        titulo.setBounds(295, 12, 360, 30);
        panelRegistrar.add(titulo);
        panelRegistrar.add(crearSep(20, 48, 920));

        lblTipoDoc     = crearLbl("Tipo Documento");
        lblNroDoc      = crearLbl("Numero Documento");
        lblNombre      = crearLbl("Nombre");
        lblApellidoPat = crearLbl("Apellido Paterno");
        lblApellidoMat = crearLbl("Apellido Materno");
        lblEdad        = crearLbl("Edad");
        lblCelular     = crearLbl("Celular");
        lblCorreo      = crearLbl("Correo");
        lblPeso        = crearLbl("Peso (Kg)");
        lblTalla       = crearLbl("Talla (Cm)");
        lblMembresia   = crearLbl("Membresia");
        lblMeses       = crearLbl("Meses");
        lblTallaPolo   = crearLbl("Talla Polo");
        lblInstructor  = crearLbl("Instructor");

        int xl1 = 30, xc1 = 185, xl2 = 480, xc2 = 635;

        lblTipoDoc    .setBounds(xl1, 65,  150, 25);
        lblNroDoc     .setBounds(xl1, 100, 150, 25);
        lblNombre     .setBounds(xl1, 135, 150, 25);
        lblApellidoPat.setBounds(xl1, 170, 150, 25);
        lblApellidoMat.setBounds(xl1, 205, 150, 25);
        lblEdad       .setBounds(xl1, 240, 150, 25);
        lblCelular    .setBounds(xl1, 275, 150, 25);
        lblCorreo     .setBounds(xl1, 310, 150, 25);
        lblPeso       .setBounds(xl2, 65,  150, 25);
        lblTalla      .setBounds(xl2, 100, 150, 25);
        lblMembresia  .setBounds(xl2, 135, 150, 25);
        lblMeses      .setBounds(xl2, 170, 150, 25);
        lblTallaPolo  .setBounds(xl2, 205, 150, 25);
        lblInstructor .setBounds(xl2, 240, 150, 25);

        for (JLabel l : new JLabel[]{lblTipoDoc,lblNroDoc,lblNombre,lblApellidoPat,
                lblApellidoMat,lblEdad,lblCelular,lblCorreo,
                lblPeso,lblTalla,lblMembresia,lblMeses,lblTallaPolo,lblInstructor})
            panelRegistrar.add(l);

        cboTipoDoc    = new JComboBox<>(new String[]{"DNI","CE"});    estiloCombo(cboTipoDoc);
        txtNroDoc     = new JTextField();  estiloTxt(txtNroDoc);
        txtNombre     = new JTextField();  estiloTxt(txtNombre);
        txtApellidoPat= new JTextField();  estiloTxt(txtApellidoPat);
        txtApellidoMat= new JTextField();  estiloTxt(txtApellidoMat);
        txtEdad       = new JTextField();  estiloTxt(txtEdad);
        txtCelular    = new JTextField();  estiloTxt(txtCelular);
        txtCorreo     = new JTextField();  estiloTxt(txtCorreo);

        cboTipoDoc    .setBounds(xc1, 65,  215, 28);
        txtNroDoc     .setBounds(xc1, 100, 215, 28);
        txtNombre     .setBounds(xc1, 135, 215, 28);
        txtApellidoPat.setBounds(xc1, 170, 215, 28);
        txtApellidoMat.setBounds(xc1, 205, 215, 28);
        txtEdad       .setBounds(xc1, 240, 215, 28);
        txtCelular    .setBounds(xc1, 275, 215, 28);
        txtCorreo     .setBounds(xc1, 310, 215, 28);

        for (JComponent c : new JComponent[]{cboTipoDoc,txtNroDoc,txtNombre,
                txtApellidoPat,txtApellidoMat,txtEdad,txtCelular,txtCorreo})
            panelRegistrar.add(c);

        txtPeso       = new JTextField();  estiloTxt(txtPeso);
        txtTalla      = new JTextField();  estiloTxt(txtTalla);
        cboMembresia  = new JComboBox<>(new String[]{"Basica","VIP"}); estiloCombo(cboMembresia);
        txtMeses      = new JTextField();  estiloTxt(txtMeses);
        cboTalla      = new JComboBox<>(new String[]{"S","M","L","XL"}); estiloCombo(cboTalla);
        cboInstructor = new JComboBox<>(new String[]{"Carlos Perez","Ana Torres"}); estiloCombo(cboInstructor);

        txtPeso      .setBounds(xc2, 65,  215, 28);
        txtTalla     .setBounds(xc2, 100, 215, 28);
        cboMembresia .setBounds(xc2, 135, 215, 28);
        txtMeses     .setBounds(xc2, 170, 215, 28);
        cboTalla     .setBounds(xc2, 205, 215, 28);
        cboInstructor.setBounds(xc2, 240, 215, 28);

        for (JComponent c : new JComponent[]{txtPeso,txtTalla,cboMembresia,
                txtMeses,cboTalla,cboInstructor})
            panelRegistrar.add(c);

        btnRegistrar = crearBtn("Registrar");
        btnLimpiar   = crearBtn2("Limpiar");
        btnRegistrar.setBounds(290, 380, 155, 40);
        btnLimpiar  .setBounds(460, 380, 140, 40);
        panelRegistrar.add(btnRegistrar);
        panelRegistrar.add(btnLimpiar);

        btnRegistrar.addActionListener(e -> registrarSocio());
        btnLimpiar  .addActionListener(e -> limpiarCampos());
    }

    private void registrarSocio() {
        try {
            String tipoDoc     = cboTipoDoc.getSelectedItem().toString();
            String nroDoc      = txtNroDoc.getText().trim();
            String nombre      = txtNombre.getText().trim();
            String apellidoPat = txtApellidoPat.getText().trim();
            String apellidoMat = txtApellidoMat.getText().trim();
            String edadStr     = txtEdad.getText().trim();
            String pesoStr     = txtPeso.getText().trim();
            String tallaStr    = txtTalla.getText().trim();
            String membresia   = cboMembresia.getSelectedItem().toString();
            String mesesStr    = txtMeses.getText().trim();
            String tallaPolo   = cboTalla.getSelectedItem().toString();
            int    codIns      = cboInstructor.getSelectedIndex() + 1;
            String celular     = txtCelular.getText().trim();
            String correo      = txtCorreo.getText().trim();

            if (nroDoc.isEmpty() || nombre.isEmpty() || apellidoPat.isEmpty()
                    || apellidoMat.isEmpty() || edadStr.isEmpty()
                    || pesoStr.isEmpty() || tallaStr.isEmpty()
                    || mesesStr.isEmpty() || celular.isEmpty() || correo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos.");
                return;
            }

            if (tipoDoc.equals("DNI")) {
                if (!nroDoc.matches("\\d{8}")) {
                    JOptionPane.showMessageDialog(this,
                            "El DNI debe contener exactamente 8 dígitos numéricos.");
                    return;
                }
            } else if (tipoDoc.equals("CE")) {
                if (!nroDoc.matches("\\d{9}")) {
                    JOptionPane.showMessageDialog(this,
                            "El Carné de Extranjería debe contener exactamente 9 dígitos numéricos.");
                    return;
                }
            }

            if (!celular.matches("\\d{9}")) {
                JOptionPane.showMessageDialog(this,
                        "El celular debe tener exactamente 9 dígitos.\nEjemplo: 987654321");
                return;
            }
            if (!validarCorreo(correo)) {
                JOptionPane.showMessageDialog(this,
                        "El correo ingresado no es válido.\nEjemplo: usuario@gmail.com");
                return;
            }
            if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                JOptionPane.showMessageDialog(this, "El nombre solo debe contener letras.");
                return;
            }
            if (!apellidoPat.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                JOptionPane.showMessageDialog(this, "El apellido paterno solo debe contener letras.");
                return;
            }
            if (!apellidoMat.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                JOptionPane.showMessageDialog(this, "El apellido materno solo debe contener letras.");
                return;
            }
            if (!edadStr.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "La edad debe ser un número entero positivo.");
                return;
            }
            if (!mesesStr.matches("\\d+")) {
                JOptionPane.showMessageDialog(this, "Los meses deben ser un número entero positivo.");
                return;
            }
            int    edad  = Integer.parseInt(edadStr);
            double peso  = Double.parseDouble(pesoStr);
            double talla = Double.parseDouble(tallaStr);
            int    meses = Integer.parseInt(mesesStr);
            if (edad < 18 || edad > 75) {
                JOptionPane.showMessageDialog(this, "La edad debe estar entre 18 y 75.");
                return;
            }
            if (peso <= 0) { JOptionPane.showMessageDialog(this, "El peso debe ser positivo."); return; }
            if (talla <= 0){ JOptionPane.showMessageDialog(this, "La talla debe ser positiva."); return; }
            if (meses <= 0){ JOptionPane.showMessageDialog(this, "Los meses deben ser mayor a cero."); return; }
            if (gestion.documentoExiste(nroDoc)) {
                JOptionPane.showMessageDialog(this, "El número de documento ya está registrado.");
                return;
            }
            if (inventario.getStockDeTalla(tallaPolo) <= 0) {
                JOptionPane.showMessageDialog(this,
                        "Stock insuficiente para la talla " + tallaPolo + ".");
                return;
            }
            Instructor instructor = gestion.obtenerInstructor(codIns);
            Socio socio = gestion.registrarSocio(tipoDoc, nroDoc, nombre,
                    apellidoPat, apellidoMat, edad, peso, talla,
                    membresia, meses, tallaPolo, instructor, celular, correo);
            inventario.entregarPolo(tallaPolo);
            JOptionPane.showMessageDialog(this,
                    "Socio registrado correctamente\n\n"
                    + "Codigo        : " + socio.getCodigoSocio()
                    + "\nIMC           : " + String.format("%.2f", socio.getEvaluacion().getImc())
                    + "\nClasificacion : " + socio.getEvaluacion().getClasificacion());
            limpiarCampos();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error: Peso y Talla deben ser números válidos.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error en los datos ingresados.");
        }
    }

    private boolean validarCorreo(String correo) {
        if (correo.contains(" ") || !correo.contains("@")) return false;
        int at = correo.indexOf("@");
        if (at == 0) return false;
        String dom = correo.substring(at + 1);
        return dom.contains(".") && !dom.startsWith(".") && !dom.endsWith(".") && dom.length() >= 3;
    }

    private void limpiarCampos() {
        txtNroDoc.setText(""); txtNombre.setText("");
        txtApellidoPat.setText(""); txtApellidoMat.setText("");
        txtEdad.setText(""); txtPeso.setText("");
        txtTalla.setText(""); txtMeses.setText("");
        txtCelular.setText(""); txtCorreo.setText("");
        cboTipoDoc.setSelectedIndex(0); cboMembresia.setSelectedIndex(0);
        cboTalla.setSelectedIndex(0);   cboInstructor.setSelectedIndex(0);
    }

    //PANEL BUSCAR SOCIO
    private void crearPanelBuscar() {
        panelBuscar = crearPanelConFondo(null);

        JLabel titulo = crearTitulo("BUSCAR SOCIO");
        titulo.setBounds(370, 12, 250, 30);
        panelBuscar.add(titulo);
        panelBuscar.add(crearSep(20, 48, 920));

        lblBuscarDni = crearLbl("DNI:");
        lblBuscarDni.setBounds(150, 85, 80, 25);
        panelBuscar.add(lblBuscarDni);

        txtBuscarDni = new JTextField(); estiloTxt(txtBuscarDni);
        txtBuscarDni.setBounds(225, 85, 200, 28);
        panelBuscar.add(txtBuscarDni);

        btnBuscarSocio = crearBtn("Buscar");
        btnBuscarSocio.setBounds(445, 82, 130, 34);
        panelBuscar.add(btnBuscarSocio);

        txtResultadoBusqueda = new JTextArea();
        txtResultadoBusqueda.setEditable(false);
        txtResultadoBusqueda.setFont(F_MONO);
        txtResultadoBusqueda.setBackground(C_CAMPO);
        txtResultadoBusqueda.setForeground(C_TEXTO);
        txtResultadoBusqueda.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
        JScrollPane scroll = crearScroll(txtResultadoBusqueda);
        scroll.setBounds(120, 148, 700, 420);
        panelBuscar.add(scroll);

        btnBuscarSocio.addActionListener(e -> buscarSocio());
        txtBuscarDni  .addActionListener(e -> buscarSocio());
    }

    private void buscarSocio() {
        String dni  = txtBuscarDni.getText().trim();
        Socio  socio = gestion.buscarPorDni(dni);
        
        // Validar que no esté vacío
        if (dni.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el DNI: El campo esta vacio.");
            txtBuscarDni.requestFocus();
            return;
        }

        // Validar que tenga exactamente 8 dígitos
        if (!dni.matches("\\d{8}")) {
            JOptionPane.showMessageDialog(this, "El DNI debe tener exactamente 8 dígitos.");
            txtBuscarDni.requestFocus();
            return;
        }

        if (socio == null) {
            JOptionPane.showMessageDialog(this, "Socio no encontrado.");
            txtResultadoBusqueda.setText("");
            return;
        }
        
        txtResultadoBusqueda.setText(
                "====================================\nFICHA DEL SOCIO\n====================================\n"
              + "Codigo        : " + socio.getCodigoSocio()
              + "\nNombre        : " + socio.getNombre()+" "+socio.getApellidPate()+" "+socio.getApellidmate()
              + "\nDocumento     : " + socio.getTipoDoc()+" "+socio.getNroDoc()
              + "\nEdad          : " + socio.getEdad()
              + "\nCelular       : " + socio.getCelular()
              + "\nCorreo        : " + socio.getCorreo()
              + "\n------------------------------------"
              + "\nPeso          : " + socio.getEvaluacion().getPesoKg()+" kg"
              + "\nTalla         : " + socio.getEvaluacion().getTallaCm()+" cm"
              + "\nIMC           : " + String.format("%.2f", socio.getEvaluacion().getImc())
              + "\nClasificacion : " + socio.getEvaluacion().getClasificacion()
              + "\nInstructor    : " + socio.getEvaluacion().getInstructor().getNombre()
                        +" "+socio.getEvaluacion().getInstructor().getApellidPate()
              + "\n------------------------------------"
              + "\nMembresia     : " + socio.getMembresia().getTipo()
              + "\nDuracion      : " + socio.getMembresia().getMesesDuracion()+" meses"
              + "\nBeneficio     : " + (socio.getMembresia().getTipo().equals("VIP")
                        ? "15% descuento en suplementos" : "Sin descuento en suplementos")
              + "\nTalla Polo    : " + socio.getTallaPolo()
              + "\n====================================");
    }

    //PANEL LISTAR SOCIOS
    private void crearPanelListar() {
        panelListar = crearPanelConFondo(null);

        JLabel titulo = crearTitulo("LISTA DE SOCIOS");
        titulo.setBounds(370, 12, 250, 30);
        panelListar.add(titulo);
        panelListar.add(crearSep(20, 48, 920));

        String[] cols = {"Cod","Documento","Nombre","Edad","Celular","Correo",
                         "Membresia","Meses","IMC","Clasificacion","Polo"};
        modeloTabla = new DefaultTableModel(cols, 0) {
            public boolean isCellEditable(int r, int c){ return false; }
        };
        tablaSocios = new JTable(modeloTabla);
        tablaSocios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        estiloTabla(tablaSocios);
        JScrollPane scroll = crearScroll(tablaSocios);
        scroll.setBounds(20, 60, 920, 550);
        panelListar.add(scroll);
    }

    private void cargarTabla() {
        modeloTabla.setRowCount(0);
        for (Socio s : gestion.getSocios()) {
            modeloTabla.addRow(new Object[]{
                s.getCodigoSocio(),
                s.getTipoDoc()+": "+s.getNroDoc(),
                s.getNombre()+" "+s.getApellidPate()+" "+s.getApellidmate(),
                s.getEdad(), s.getCelular(), s.getCorreo(),
                s.getMembresia().getTipo(), s.getMembresia().getMesesDuracion(),
                String.format("%.2f", s.getEvaluacion().getImc()),
                s.getEvaluacion().getClasificacion(), s.getTallaPolo()
            });
        }
    }

    //PANEL INVENTARIO DE POLOS 
    private void crearPanelInventario() {
        panelInventario = crearPanelConFondo(null);

        JLabel titulo = crearTitulo("INVENTARIO DE POLOS");
        titulo.setBounds(340, 12, 380, 30);
        panelInventario.add(titulo);
        panelInventario.add(crearSep(20, 48, 920));

        // Esto se arregló: Columnas: Código, Nombre, Talla, Stock. Sin Precio ni Color.
        String[] cols = {"Código","Nombre","Talla","Stock"};
        modeloTablaInventarioPolos = new DefaultTableModel(cols, 0) {
            public boolean isCellEditable(int r, int c){ return false; }
        };
        tablaInventarioPolos = new JTable(modeloTablaInventarioPolos);
        estiloTabla(tablaInventarioPolos);

        // Esto se arregló: Renderer especial que pinta en amarillo filas con stock bajo.
        tablaInventarioPolos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable t, Object v, boolean sel, boolean foc, int row, int col) {
                Component c = super.getTableCellRendererComponent(t, v, sel, foc, row, col);
                if (!sel) {
                    // Esto se arregló: Alerta visual de stock bajo en el inventario de polos.
                    Object stockVal = t.getModel().getValueAt(row, 3);
                    int stock = 0;
                    try { stock = Integer.parseInt(stockVal.toString()); } catch (Exception ex) {}
                    if (stock <= 5) {
                        c.setBackground(new Color(60, 50, 10));
                        c.setForeground(C_ALERTA);
                    } else {
                        c.setBackground(row % 2 == 0 ? C_ROW1 : C_ROW2);
                        c.setForeground(C_TEXTO);
                    }
                }
                return c;
            }
        });

        JScrollPane scroll = crearScroll(tablaInventarioPolos);
        scroll.setBounds(80, 65, 800, 460);
        panelInventario.add(scroll);

        JLabel leyenda = new JLabel("⚠  Filas en amarillo = stock bajo (≤ 5 unidades). Se recomienda reabastecer.");
        leyenda.setFont(F_LBL);
        leyenda.setForeground(C_ALERTA);
        leyenda.setBounds(80, 535, 700, 22);
        panelInventario.add(leyenda);
    }

    private void cargarInventario() {
        modeloTablaInventarioPolos.setRowCount(0);
        for (Polo p : inventario.getListaPolos()) {
            modeloTablaInventarioPolos.addRow(new Object[]{
                p.getCodigo(), p.getNombre(), p.getTalla(), p.getStock()
            });
        }
    }

    //PANEL REGISTRAR POLO 
    private void crearPanelRegPolos() {
        panelRegPolos = crearPanelConFondo(null);

        JLabel titulo = crearTitulo("REGISTRAR POLO");
        titulo.setBounds(370, 12, 300, 30);
        panelRegPolos.add(titulo);
        panelRegPolos.add(crearSep(20, 48, 920));

        int xl = 40, xc = 210;

        JLabel lblNom = crearLbl("Nombre del Polo:");
        lblNom.setBounds(xl, 72, 160, 25);
        panelRegPolos.add(lblNom);
        txtNomPolo = new JTextField(); estiloTxt(txtNomPolo);
        txtNomPolo.setBounds(xc, 72, 250, 28);
        panelRegPolos.add(txtNomPolo);

        JLabel lblTallaP = crearLbl("Talla:");
        lblTallaP.setBounds(xl, 110, 160, 25);
        panelRegPolos.add(lblTallaP);
        cboTallaPolo = new JComboBox<>(new String[]{"S","M","L","XL"});
        estiloCombo(cboTallaPolo);
        cboTallaPolo.setBounds(xc, 110, 250, 28);
        panelRegPolos.add(cboTallaPolo);

        JLabel lblStockP = crearLbl("Cantidad inicial:");
        lblStockP.setBounds(xl, 148, 160, 25);
        panelRegPolos.add(lblStockP);
        txtStockPolo = new JTextField(); estiloTxt(txtStockPolo);
        txtStockPolo.setBounds(xc, 148, 250, 28);
        panelRegPolos.add(txtStockPolo);

        JLabel lblInfo = new JLabel("El código se generará automáticamente (P005, P006...)");
        lblInfo.setFont(F_LBL);
        lblInfo.setForeground(C_ROJO);
        lblInfo.setBounds(xl, 186, 500, 22);
        panelRegPolos.add(lblInfo);

        JButton btnReg  = crearBtn("Registrar Polo");
        JButton btnLimp = crearBtn2("Limpiar");
        btnReg .setBounds(xl, 222, 160, 38);
        btnLimp.setBounds(xl + 175, 222, 120, 38);
        panelRegPolos.add(btnReg);
        panelRegPolos.add(btnLimp);

        String[] cols = {"Código","Nombre","Talla","Stock"};
        modeloTablaPolos = new DefaultTableModel(cols, 0) {
            public boolean isCellEditable(int r, int c){ return false; }
        };
        tablaPolos = new JTable(modeloTablaPolos);
        estiloTabla(tablaPolos);
        JScrollPane scroll = crearScroll(tablaPolos);
        scroll.setBounds(40, 275, 880, 330);
        panelRegPolos.add(scroll);

        btnReg .addActionListener(e -> registrarPolo());
        btnLimp.addActionListener(e -> { txtNomPolo.setText(""); txtStockPolo.setText(""); cboTallaPolo.setSelectedIndex(0); });
    }

    //Valida y registra un nuevo polo.
    private void registrarPolo() {
        String nombre   = txtNomPolo.getText().trim();
        String talla    = cboTallaPolo.getSelectedItem().toString();
        String stockStr = txtStockPolo.getText().trim();

        if (nombre.isEmpty() || stockStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            JOptionPane.showMessageDialog(this,
                    "El nombre del polo solo debe contener letras.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int stock;
        try {
            stock = Integer.parseInt(stockStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "La cantidad debe ser un número entero.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (stock < 0) {
            JOptionPane.showMessageDialog(this,
                    "No se permiten cantidades negativas.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String codigo = inventario.generarCodigo();
        Polo polo = new Polo(codigo, nombre, talla, stock);
        inventario.agregarPolo(polo);

        cargarTablaPolos();
        txtNomPolo.setText(""); txtStockPolo.setText(""); cboTallaPolo.setSelectedIndex(0);

        String msg = "Polo registrado correctamente.\n\n"
                + "Código: " + codigo + "  |  Talla: " + talla
                + "  |  Stock: " + stock;

        //Se muestra alerta de stock bajo al registrar un polo con stock <= 5.
        if (stock <= 5) {
            msg += "\n\n⚠ Stock bajo. Se recomienda reabastecer este polo.";
            JOptionPane.showMessageDialog(this, msg, "Registro Exitoso - Stock Bajo",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, msg, "Registro Exitoso",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /** Carga los polos en la tabla del panel de registro (Código, Nombre, Talla, Stock). */
    private void cargarTablaPolos() {
        modeloTablaPolos.setRowCount(0);
        for (Polo p : inventario.getListaPolos()) {
            modeloTablaPolos.addRow(new Object[]{
                p.getCodigo(), p.getNombre(), p.getTalla(), p.getStock()
            });
        }
    }

    //PANEL AGREGAR STOCK DE POLOS 
    private void crearPanelAgregarStockPolos() {
        panelAgregarStockPolos = crearPanelConFondo(null);

        JLabel titulo = crearTitulo("AGREGAR STOCK DE POLOS");
        titulo.setBounds(290, 12, 420, 30);
        panelAgregarStockPolos.add(titulo);
        panelAgregarStockPolos.add(crearSep(20, 48, 920));

        JLabel lblSel = crearLbl("Seleccionar Polo:");
        lblSel.setBounds(40, 75, 160, 25);
        panelAgregarStockPolos.add(lblSel);

        cboPoloStock = new JComboBox<>();
        estiloCombo(cboPoloStock);
        cboPoloStock.setBounds(210, 75, 360, 28);
        panelAgregarStockPolos.add(cboPoloStock);

        lblInfoPoloStock = new JLabel("Seleccione un polo para ver su información.");
        lblInfoPoloStock.setFont(F_LBL);
        lblInfoPoloStock.setForeground(C_TEXTO2);
        lblInfoPoloStock.setBounds(40, 115, 600, 25);
        panelAgregarStockPolos.add(lblInfoPoloStock);

        JLabel lblCant = crearLbl("Cantidad a agregar:");
        lblCant.setBounds(40, 153, 160, 25);
        panelAgregarStockPolos.add(lblCant);

        txtCantAgregarPolo = new JTextField(); estiloTxt(txtCantAgregarPolo);
        txtCantAgregarPolo.setBounds(210, 153, 180, 28);
        panelAgregarStockPolos.add(txtCantAgregarPolo);

        JButton btnAgregar = crearBtn("Agregar Stock");
        JButton btnLimp    = crearBtn2("Limpiar");
        btnAgregar.setBounds(40, 196, 155, 38);
        btnLimp   .setBounds(210, 196, 120, 38);
        panelAgregarStockPolos.add(btnAgregar);
        panelAgregarStockPolos.add(btnLimp);

        // Tabla que refleja el inventario actual de polos
        String[] cols = {"Código","Nombre","Talla","Stock Actual"};
        modeloTablaPolosStock = new DefaultTableModel(cols, 0) {
            public boolean isCellEditable(int r, int c){ return false; }
        };
        tablaPolosStock = new JTable(modeloTablaPolosStock);
        estiloTabla(tablaPolosStock);

        //Alerta visual de stock bajo en esta tabla también.
        tablaPolosStock.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable t, Object v, boolean sel, boolean foc, int row, int col) {
                Component c = super.getTableCellRendererComponent(t, v, sel, foc, row, col);
                if (!sel) {
                    Object sv = t.getModel().getValueAt(row, 3);
                    int stk = 0;
                    try { stk = Integer.parseInt(sv.toString()); } catch (Exception ex){}
                    if (stk <= 5) {
                        c.setBackground(new Color(60, 50, 10));
                        c.setForeground(C_ALERTA);
                    } else {
                        c.setBackground(row % 2 == 0 ? C_ROW1 : C_ROW2);
                        c.setForeground(C_TEXTO);
                    }
                }
                return c;
            }
        });

        JScrollPane scroll = crearScroll(tablaPolosStock);
        scroll.setBounds(40, 250, 880, 340);
        panelAgregarStockPolos.add(scroll);

        JLabel leyenda = new JLabel("   Filas en amarillo = stock bajo (≤ 5 unidades).");
        leyenda.setFont(F_LBL);
        leyenda.setForeground(C_ALERTA);
        leyenda.setBounds(40, 600, 500, 22);
        panelAgregarStockPolos.add(leyenda);

        //Al seleccionar un polo en el combo se muestra su información actual.
        cboPoloStock.addActionListener(e -> actualizarInfoPoloStock());

        btnAgregar.addActionListener(e -> ejecutarAgregarStockPolo());
        btnLimp   .addActionListener(e -> {
            txtCantAgregarPolo.setText("");
            actualizarInfoPoloStock();
        });
    }

    //Carga el combo de polos para reposición de stock. 
    private void cargarComboPolosStock() {
        cboPoloStock.removeAllItems();
        for (Polo p : inventario.getListaPolos()) {
            cboPoloStock.addItem("[" + p.getCodigo() + "] " + p.getNombre()
                    + " - Talla: " + p.getTalla()
                    + " | Stock actual: " + p.getStock());
        }
        actualizarInfoPoloStock();
        cargarTablaPolosStock();
    }

    //Actualiza la etiqueta con la info del polo seleccionado en el combo. 
    private void actualizarInfoPoloStock() {
        int idx = cboPoloStock.getSelectedIndex();
        if (idx < 0 || idx >= inventario.getListaPolos().size()) {
            lblInfoPoloStock.setText("Seleccione un polo para ver su información.");
            lblInfoPoloStock.setForeground(C_TEXTO2);
            return;
        }
        Polo p = inventario.getListaPolos().get(idx);
        //Se muestra el stock actual del polo seleccionado antes de agregar.
        String info = "  Código: " + p.getCodigo() + "  |  Nombre: " + p.getNombre()
                + "  |  Talla: " + p.getTalla() + "  |  Stock actual: " + p.getStock();
        lblInfoPoloStock.setText(info);
        if (p.getStock() <= 5) {
            lblInfoPoloStock.setForeground(C_ALERTA);
        } else {
            lblInfoPoloStock.setForeground(C_TEXTO2);
        }
    }

    /** Carga la tabla de polos en el panel de agregar stock. */
    private void cargarTablaPolosStock() {
        modeloTablaPolosStock.setRowCount(0);
        for (Polo p : inventario.getListaPolos()) {
            modeloTablaPolosStock.addRow(new Object[]{
                p.getCodigo(), p.getNombre(), p.getTalla(), p.getStock()
            });
        }
    }

    /**
     * Ejecuta la reposición de stock de un polo existente.
     * Esto se arregló: Se suma la cantidad al stock actual sin crear un nuevo registro.
     * Se valida que la cantidad sea positiva.
     * Se muestra el nuevo stock total después de la operación.
     * Se actualiza el inventario automáticamente.
     */
    private void ejecutarAgregarStockPolo() {
        int idx = cboPoloStock.getSelectedIndex();
        if (idx < 0 || idx >= inventario.getListaPolos().size()) {
            JOptionPane.showMessageDialog(this, "Seleccione un polo.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String cantStr = txtCantAgregarPolo.getText().trim();
        if (cantStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese la cantidad a agregar.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int cantidad;
        try {
            cantidad = Integer.parseInt(cantStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "La cantidad debe ser un número entero.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Esto se arregló: Se valida que la cantidad a agregar sea positiva.
        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(this,
                    "No se permiten cantidades negativas o cero.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Polo p = inventario.getListaPolos().get(idx);
        int stockAntes = p.getStock();

        // Esto se arregló: Se suma la cantidad al stock actual sin crear un nuevo polo.
        inventario.agregarStock(p.getCodigo(), cantidad);

        int stockDespues = p.getStock();

        // Esto se arregló: Se actualiza automáticamente la tabla y el combo después de reponer.
        cargarComboPolosStock();
        txtCantAgregarPolo.setText("");

        String msg = "Stock actualizado correctamente.\n\n"
                + "Polo          : " + p.getNombre() + " (Talla: " + p.getTalla() + ")\n"
                + "Código        : " + p.getCodigo() + "\n"
                + "Stock anterior: " + stockAntes + "\n"
                + "Cantidad add. : +" + cantidad + "\n"
                + "Nuevo stock   : " + stockDespues;

        // Esto se arregló: Se muestra alerta si el nuevo stock sigue siendo bajo.
        if (stockDespues <= 5) {
            msg += "\n\n⚠ Stock bajo. Se recomienda reabastecer este polo.";
            JOptionPane.showMessageDialog(this, msg, "Stock Actualizado - Stock Bajo",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, msg, "Stock Actualizado",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //PANEL REGISTRAR SUPLEMENTOS
    private void crearPanelRegSupl() {
        panelRegSupl = crearPanelConFondo(null);

        JLabel titulo = crearTitulo("REGISTRAR SUPLEMENTO");
        titulo.setBounds(300, 12, 400, 30);
        panelRegSupl.add(titulo);
        panelRegSupl.add(crearSep(20, 48, 920));

        int xl = 40, xc = 210;

        JLabel lblNom = crearLbl("Nombre del Suplemento:");
        lblNom.setBounds(xl, 72, 190, 25);
        panelRegSupl.add(lblNom);
        txtNomSupl = new JTextField(); estiloTxt(txtNomSupl);
        txtNomSupl.setBounds(xc, 72, 260, 28);
        panelRegSupl.add(txtNomSupl);

        JLabel lblPrecio = crearLbl("Precio (S/):");
        lblPrecio.setBounds(xl, 110, 190, 25);
        panelRegSupl.add(lblPrecio);
        txtPrecioSupl = new JTextField(); estiloTxt(txtPrecioSupl);
        txtPrecioSupl.setBounds(xc, 110, 260, 28);
        panelRegSupl.add(txtPrecioSupl);

        JLabel lblStock = crearLbl("Cantidad inicial:");
        lblStock.setBounds(xl, 148, 190, 25);
        panelRegSupl.add(lblStock);
        txtStockSupl = new JTextField(); estiloTxt(txtStockSupl);
        txtStockSupl.setBounds(xc, 148, 260, 28);
        panelRegSupl.add(txtStockSupl);

        JLabel lblInfo = new JLabel("El código se generará automáticamente (S005, S006...)");
        lblInfo.setFont(F_LBL);
        lblInfo.setForeground(C_ROJO);
        lblInfo.setBounds(xl, 186, 500, 22);
        panelRegSupl.add(lblInfo);

        JButton btnReg  = crearBtn("Registrar Suplemento");
        JButton btnLimp = crearBtn2("Limpiar");
        btnReg .setBounds(xl, 222, 200, 38);
        btnLimp.setBounds(xl + 215, 222, 120, 38);
        panelRegSupl.add(btnReg);
        panelRegSupl.add(btnLimp);

        //La tabla muestra solo Código, Nombre, Precio, Stock. Sin Marca.
        String[] cols = {"Código","Nombre","Precio","Stock"};
        modeloTablaSupl = new DefaultTableModel(cols, 0) {
            public boolean isCellEditable(int r, int c){ return false; }
        };
        tablaSupl = new JTable(modeloTablaSupl);
        estiloTabla(tablaSupl);
        JScrollPane scroll = crearScroll(tablaSupl);
        scroll.setBounds(40, 278, 880, 330);
        panelRegSupl.add(scroll);

        btnReg .addActionListener(e -> registrarSuplemento());
        btnLimp.addActionListener(e -> { txtNomSupl.setText(""); txtPrecioSupl.setText(""); txtStockSupl.setText(""); });
    }

    //Valida y registra un nuevo suplemento.

    private void registrarSuplemento() {
        String nombre    = txtNomSupl.getText().trim();
        String precioStr = txtPrecioSupl.getText().trim();
        String stockStr  = txtStockSupl.getText().trim();

        //Validación de campos vacíos.
        if (nombre.isEmpty() || precioStr.isEmpty() || stockStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        double precio;
        int    stock;
        try {
            precio = Double.parseDouble(precioStr);
            stock  = Integer.parseInt(stockStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Precio y Stock deben ser valores numéricos válidos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (precio <= 0) {
            JOptionPane.showMessageDialog(this,
                    "No se permiten valores negativos o cero en el precio.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Se valida que el stock no sea negativo.
        if (stock < 0) {
            JOptionPane.showMessageDialog(this,
                    "No se permiten cantidades negativas.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        //El código se genera automáticamente con generarCodigoSupl().
        String codigo = generarCodigoSupl();
        listaSupl.add(new Suplemento(codigo, nombre, precio, stock));

        //El inventario de suplementos se actualiza automáticamente al registrar.
        cargarTablaSupl();
        txtNomSupl.setText(""); txtPrecioSupl.setText(""); txtStockSupl.setText("");

        String msg = "Suplemento registrado correctamente.\n\n"
                + "Código: " + codigo
                + "  |  Precio: S/ " + String.format("%.2f", precio)
                + "  |  Stock: " + stock;

        //Se muestra alerta de stock bajo si la cantidad inicial es <= 5.
        if (stock <= 5) {
            msg += "\n\n  Stock bajo. Se recomienda reabastecer este suplemento.";
            JOptionPane.showMessageDialog(this, msg, "Registro Exitoso - Stock Bajo",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, msg, "Registro Exitoso",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //Carga los suplementos en la tabla del panel.
    private void cargarTablaSupl() {
        modeloTablaSupl.setRowCount(0);
        for (Suplemento s : listaSupl) {
            modeloTablaSupl.addRow(new Object[]{
                s.getCodigo(), s.getNombre(),
                String.format("S/ %.2f", s.getPrecioBase()), s.getStock()
            });
        }
    }

    //PANEL AGREGAR STOCK DE SUPLEMENTOS
    private void crearPanelAgregarStockSupl() {
        panelAgregarStockSupl = crearPanelConFondo(null);

        JLabel titulo = crearTitulo("AGREGAR STOCK DE SUPLEMENTOS");
        titulo.setBounds(230, 12, 500, 30);
        panelAgregarStockSupl.add(titulo);
        panelAgregarStockSupl.add(crearSep(20, 48, 920));

        JLabel lblSel = crearLbl("Seleccionar Suplemento:");
        lblSel.setBounds(40, 75, 190, 25);
        panelAgregarStockSupl.add(lblSel);

        //Combo que lista todos los suplementos para seleccionar el que se repone.
        cboSuplStock = new JComboBox<>();
        estiloCombo(cboSuplStock);
        cboSuplStock.setBounds(240, 75, 400, 28);
        panelAgregarStockSupl.add(cboSuplStock);

        //Label que muestra información actual del suplemento seleccionado.
        lblInfoSuplStock = new JLabel("Seleccione un suplemento para ver su información.");
        lblInfoSuplStock.setFont(F_LBL);
        lblInfoSuplStock.setForeground(C_TEXTO2);
        lblInfoSuplStock.setBounds(40, 115, 650, 25);
        panelAgregarStockSupl.add(lblInfoSuplStock);

        JLabel lblCant = crearLbl("Cantidad a agregar:");
        lblCant.setBounds(40, 153, 190, 25);
        panelAgregarStockSupl.add(lblCant);

        txtCantAgregarSupl = new JTextField(); estiloTxt(txtCantAgregarSupl);
        txtCantAgregarSupl.setBounds(240, 153, 180, 28);
        panelAgregarStockSupl.add(txtCantAgregarSupl);

        JButton btnAgregar = crearBtn("Agregar Stock");
        JButton btnLimp    = crearBtn2("Limpiar");
        btnAgregar.setBounds(40, 196, 155, 38);
        btnLimp   .setBounds(210, 196, 120, 38);
        panelAgregarStockSupl.add(btnAgregar);
        panelAgregarStockSupl.add(btnLimp);

        //Tabla que refleja el inventario actual de suplementos
        String[] cols = {"Código","Nombre","Precio","Stock Actual"};
        modeloTablaSuplStock = new DefaultTableModel(cols, 0) {
            public boolean isCellEditable(int r, int c){ return false; }
        };
        tablaSuplStock = new JTable(modeloTablaSuplStock);
        estiloTabla(tablaSuplStock);

        //Alerta visual de stock bajo en suplementos.
        tablaSuplStock.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(
                    JTable t, Object v, boolean sel, boolean foc, int row, int col) {
                Component c = super.getTableCellRendererComponent(t, v, sel, foc, row, col);
                if (!sel) {
                    Object sv = t.getModel().getValueAt(row, 3);
                    int stk = 0;
                    try { stk = Integer.parseInt(sv.toString()); } catch (Exception ex){}
                    if (stk <= 5) {
                        c.setBackground(new Color(60, 50, 10));
                        c.setForeground(C_ALERTA);
                    } else {
                        c.setBackground(row % 2 == 0 ? C_ROW1 : C_ROW2);
                        c.setForeground(C_TEXTO);
                    }
                }
                return c;
            }
        });

        JScrollPane scroll = crearScroll(tablaSuplStock);
        scroll.setBounds(40, 250, 880, 340);
        panelAgregarStockSupl.add(scroll);

        JLabel leyenda = new JLabel("⚠  Filas en amarillo = stock bajo (≤ 5 unidades).");
        leyenda.setFont(F_LBL);
        leyenda.setForeground(C_ALERTA);
        leyenda.setBounds(40, 600, 500, 22);
        panelAgregarStockSupl.add(leyenda);

        //Al seleccionar un suplemento se muestra su información actual.
        cboSuplStock.addActionListener(e -> actualizarInfoSuplStock());

        btnAgregar.addActionListener(e -> ejecutarAgregarStockSupl());
        btnLimp   .addActionListener(e -> {
            txtCantAgregarSupl.setText("");
            actualizarInfoSuplStock();
        });
    }

    //Carga el combo de suplementos para reposición de stock.
    private void cargarComboSuplStock() {
        cboSuplStock.removeAllItems();
        for (Suplemento s : listaSupl) {
            cboSuplStock.addItem("[" + s.getCodigo() + "] " + s.getNombre()
                    + " | Precio: S/ " + String.format("%.2f", s.getPrecioBase())
                    + " | Stock: " + s.getStock());
        }
        actualizarInfoSuplStock();
        cargarTablaSuplStock();
    }

    //Actualiza la etiqueta con la info del suplemento seleccionado.
    private void actualizarInfoSuplStock() {
        int idx = cboSuplStock.getSelectedIndex();
        if (idx < 0 || idx >= listaSupl.size()) {
            lblInfoSuplStock.setText("Seleccione un suplemento para ver su información.");
            lblInfoSuplStock.setForeground(C_TEXTO2);
            return;
        }
        Suplemento s = listaSupl.get(idx);
        //Se muestra el stock actual antes de agregar, sin mostrar marca.
        String info = "  Código: " + s.getCodigo() + "  |  Nombre: " + s.getNombre()
                + "  |  Precio: S/ " + String.format("%.2f", s.getPrecioBase())
                + "  |  Stock actual: " + s.getStock();
        lblInfoSuplStock.setText(info);
        if (s.getStock() <= 5) {
            lblInfoSuplStock.setForeground(C_ALERTA);
        } else {
            lblInfoSuplStock.setForeground(C_TEXTO2);
        }
    }

    //Carga la tabla de suplementos en el panel de agregar stock.
    private void cargarTablaSuplStock() {
        modeloTablaSuplStock.setRowCount(0);
        for (Suplemento s : listaSupl) {
            modeloTablaSuplStock.addRow(new Object[]{
                s.getCodigo(), s.getNombre(),
                String.format("S/ %.2f", s.getPrecioBase()), s.getStock()
            });
        }
    }

    //Ejecuta la reposición de stock de un suplemento existente.
    private void ejecutarAgregarStockSupl() {
        int idx = cboSuplStock.getSelectedIndex();
        if (idx < 0 || idx >= listaSupl.size()) {
            JOptionPane.showMessageDialog(this, "Seleccione un suplemento.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String cantStr = txtCantAgregarSupl.getText().trim();
        if (cantStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese la cantidad a agregar.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int cantidad;
        try {
            cantidad = Integer.parseInt(cantStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "La cantidad debe ser un número entero.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        //Se valida que la cantidad a agregar sea positiva.
        if (cantidad <= 0) {
            JOptionPane.showMessageDialog(this,
                    "No se permiten cantidades negativas o cero.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Suplemento s = listaSupl.get(idx);
        int stockAntes = s.getStock();

        //Se suma al stock existente usando agregarStock() sin crear nuevo registro.
        s.agregarStock(cantidad);

        int stockDespues = s.getStock();

        //Se actualiza automáticamente la tabla y el combo después de reponer.
        cargarComboSuplStock();
        txtCantAgregarSupl.setText("");

        String msg = "Stock actualizado correctamente.\n\n"
                + "Suplemento    : " + s.getNombre() + "\n"
                + "Código        : " + s.getCodigo() + "\n"
                + "Stock anterior: " + stockAntes + "\n"
                + "Cantidad add. : +" + cantidad + "\n"
                + "Nuevo stock   : " + stockDespues;

        //Se muestra alerta si el nuevo stock sigue siendo bajo.
        if (stockDespues <= 5) {
            msg += "\n\n  Stock bajo. Se recomienda reabastecer este suplemento.";
            JOptionPane.showMessageDialog(this, msg, "Stock Actualizado - Stock Bajo",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, msg, "Stock Actualizado",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //PANEL COMPRAR SUPLEMENTO 
    private void crearPanelSuplementos() {
        panelSuplementos = crearPanelConFondo(null);

        JLabel titulo = crearTitulo("COMPRAR SUPLEMENTO");
        titulo.setBounds(305, 12, 360, 30);
        panelSuplementos.add(titulo);
        panelSuplementos.add(crearSep(20, 48, 920));

        lblDniSup = crearLbl("DNI del Socio:");
        lblDniSup.setBounds(50, 72, 130, 25);
        panelSuplementos.add(lblDniSup);

        txtDniSup = new JTextField(); estiloTxt(txtDniSup);
        txtDniSup.setBounds(190, 72, 190, 28);
        panelSuplementos.add(txtDniSup);

        btnBuscarSocioSup = crearBtn("Buscar Socio");
        btnBuscarSocioSup.setBounds(395, 69, 140, 34);
        panelSuplementos.add(btnBuscarSocioSup);

        txtInfoSocio = new JTextArea();
        txtInfoSocio.setEditable(false);
        txtInfoSocio.setBackground(C_CAMPO);
        txtInfoSocio.setForeground(C_TEXTO);
        txtInfoSocio.setFont(F_LBL);
        txtInfoSocio.setBorder(BorderFactory.createEmptyBorder(5, 8, 5, 8));
        JScrollPane scrollInfo = crearScroll(txtInfoSocio);
        scrollInfo.setBounds(50, 115, 530, 65);
        panelSuplementos.add(scrollInfo);

        JLabel lblCat = new JLabel("Catálogo de Suplementos:");
        lblCat.setFont(F_BOLD);
        lblCat.setForeground(C_ROJO);
        lblCat.setBounds(50, 196, 260, 25);
        panelSuplementos.add(lblCat);

        DefaultListModel<String> modelo = new DefaultListModel<>();
        listaSuplementos = new JList<>(modelo);
        listaSuplementos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listaSuplementos.setFont(F_MONO);
        listaSuplementos.setBackground(C_CAMPO);
        listaSuplementos.setForeground(C_TEXTO);
        JScrollPane scrollLista = crearScroll(listaSuplementos);
        scrollLista.setBounds(50, 225, 530, 150);
        panelSuplementos.add(scrollLista);

        lblPrecioBase  = new JLabel("Precio base   : ---");
        lblDescuento   = new JLabel("Descuento     : ---");
        lblPrecioFinal = new JLabel("Precio final  : ---");
        lblPrecioBase .setFont(F_LBL);  lblPrecioBase.setForeground(C_TEXTO);
        lblDescuento  .setFont(F_LBL);  lblDescuento.setForeground(C_TEXTO2);
        lblPrecioFinal.setFont(F_BOLD); lblPrecioFinal.setForeground(C_ROJO);

        lblPrecioBase .setBounds(620, 225, 290, 25);
        lblDescuento  .setBounds(620, 260, 290, 25);
        lblPrecioFinal.setBounds(620, 295, 290, 25);
        panelSuplementos.add(lblPrecioBase);
        panelSuplementos.add(lblDescuento);
        panelSuplementos.add(lblPrecioFinal);

        btnComprar = crearBtn("Confirmar Compra");
        btnComprar.setBounds(620, 345, 195, 38);
        panelSuplementos.add(btnComprar);

        btnBuscarSocioSup.addActionListener(e -> buscarSocioParaCompra());
        txtDniSup        .addActionListener(e -> buscarSocioParaCompra());
        listaSuplementos .addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) calcularPrecioSuplemento();
        });
        btnComprar.addActionListener(e -> confirmarCompra());
    }

    private void actualizarListaSupl() {
        DefaultListModel<String> modelo = new DefaultListModel<>();
        for (Suplemento s : listaSupl) {
            modelo.addElement(String.format("[%s] %-22s  S/ %.2f  (Stock: %d)",
                    s.getCodigo(), s.getNombre(), s.getPrecioBase(), s.getStock()));
        }
        listaSuplementos.setModel(modelo);
    }

    private void buscarSocioParaCompra() {
        String dni = txtDniSup.getText().trim();
        socioActual = gestion.buscarPorDni(dni);
        if (socioActual == null) {
            JOptionPane.showMessageDialog(this, "Socio no encontrado.");
            txtInfoSocio.setText("");
            lblPrecioBase .setText("Precio base   : ---");
            lblDescuento  .setText("Descuento     : ---");
            lblPrecioFinal.setText("Precio final  : ---");
            return;
        }
        txtInfoSocio.setText(
                "Socio : " + socioActual.getNombre() + " " + socioActual.getApellidPate()
                + "\nMembresia: " + socioActual.getMembresia().getTipo()
                + "  |  " + (socioActual.getMembresia().getTipo().equals("VIP")
                        ? "15% descuento en suplementos" : "Sin descuento en suplementos"));
        calcularPrecioSuplemento();
    }

    private void calcularPrecioSuplemento() {
        int idx = listaSuplementos.getSelectedIndex();
        if (idx < 0 || socioActual == null) return;
        Suplemento sup = listaSupl.get(idx);
        double base = sup.getPrecioBase();
        double pf   = socioActual.calcularPrecioSuplemento(base);
        double desc = base - pf;
        lblPrecioBase .setText(String.format("Precio base   : S/ %.2f", base));
        lblDescuento  .setText(String.format("Descuento     : S/ %.2f", desc));
        lblPrecioFinal.setText(String.format("Precio final  : S/ %.2f", pf));
    }

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
        Suplemento sup = listaSupl.get(idx);
        double pf = socioActual.calcularPrecioSuplemento(sup.getPrecioBase());
        JOptionPane.showMessageDialog(this,
                "Compra registrada exitosamente\n\n"
                + "Socio      : " + socioActual.getNombre() + " " + socioActual.getApellidPate()
                + "\nSuplemento : " + sup.getNombre()
                + "\nPrecio     : S/ " + String.format("%.2f", pf));
    }

    //PANEL REGISTRAR VENTA 
    private void crearPanelVenta() {
        panelVenta = crearPanelConFondo(null);

        JLabel titulo = crearTitulo("REGISTRAR VENTA");
        titulo.setBounds(365, 12, 300, 30);
        panelVenta.add(titulo);
        panelVenta.add(crearSep(20, 48, 920));

        JLabel lblSel = crearLbl("Suplemento:");
        lblSel.setBounds(40, 65, 130, 25);
        panelVenta.add(lblSel);

        cboVentaSupl = new JComboBox<>(); estiloCombo(cboVentaSupl);
        cboVentaSupl.setBounds(185, 65, 360, 28);
        panelVenta.add(cboVentaSupl);

        JLabel lblCant = crearLbl("Cantidad:");
        lblCant.setBounds(40, 100, 130, 25);
        panelVenta.add(lblCant);

        txtVentaCantidad = new JTextField(); estiloTxt(txtVentaCantidad);
        txtVentaCantidad.setBounds(185, 100, 165, 28);
        panelVenta.add(txtVentaCantidad);

        lblVentaNomSupl    = new JLabel("Suplemento  : ---");
        lblVentaPrecioUnit = new JLabel("Precio unit.: ---");
        lblVentaCantidad2  = new JLabel("Cantidad    : ---");
        lblVentaTotal      = new JLabel("TOTAL       : ---");

        lblVentaNomSupl   .setFont(F_LBL);  lblVentaNomSupl.setForeground(C_TEXTO);
        lblVentaPrecioUnit.setFont(F_LBL);  lblVentaPrecioUnit.setForeground(C_TEXTO);
        lblVentaCantidad2 .setFont(F_LBL);  lblVentaCantidad2.setForeground(C_TEXTO);
        lblVentaTotal     .setFont(F_BOLD); lblVentaTotal.setForeground(C_ROJO);

        lblVentaNomSupl   .setBounds(600, 65,  310, 25);
        lblVentaPrecioUnit.setBounds(600, 95,  310, 25);
        lblVentaCantidad2 .setBounds(600, 125, 310, 25);
        lblVentaTotal     .setBounds(600, 155, 310, 25);

        panelVenta.add(lblVentaNomSupl);
        panelVenta.add(lblVentaPrecioUnit);
        panelVenta.add(lblVentaCantidad2);
        panelVenta.add(lblVentaTotal);

        btnRegistrarVenta = crearBtn("Registrar Venta");
        btnLimpiarVenta   = crearBtn2("Limpiar");
        btnRegistrarVenta.setBounds(40, 142, 165, 38);
        btnLimpiarVenta  .setBounds(220, 142, 120, 38);
        panelVenta.add(btnRegistrarVenta);
        panelVenta.add(btnLimpiarVenta);

        JLabel lblHist = new JLabel("Historial de Ventas:");
        lblHist.setFont(F_BOLD); lblHist.setForeground(C_ROJO);
        lblHist.setBounds(40, 192, 220, 25);
        panelVenta.add(lblHist);

        String[] cols = {"Código Venta","Suplemento","Cantidad","Precio Unit.","Total"};
        modeloTablaVentas = new DefaultTableModel(cols, 0) {
            public boolean isCellEditable(int r, int c){ return false; }
        };
        tablaVentas = new JTable(modeloTablaVentas);
        estiloTabla(tablaVentas);
        JScrollPane scroll = crearScroll(tablaVentas);
        scroll.setBounds(40, 222, 880, 380);
        panelVenta.add(scroll);

        cboVentaSupl    .addActionListener(e -> calcularTotalVenta());
        txtVentaCantidad.addActionListener(e -> calcularTotalVenta());
        btnRegistrarVenta.addActionListener(e -> registrarVenta());
        btnLimpiarVenta  .addActionListener(e -> limpiarCamposVenta());
    }

    private void actualizarComboVentaSupl() {
        cboVentaSupl.removeAllItems();
        for (Suplemento s : listaSupl) {
            cboVentaSupl.addItem("[" + s.getCodigo() + "] " + s.getNombre()
                    + "  S/ " + String.format("%.2f", s.getPrecioBase()));
        }
    }

    private void calcularTotalVenta() {
        int idx = cboVentaSupl.getSelectedIndex();
        if (idx < 0 || idx >= listaSupl.size()) return;
        Suplemento s = listaSupl.get(idx);
        String cantStr = txtVentaCantidad.getText().trim();
        lblVentaNomSupl   .setText("Suplemento  : " + s.getNombre());
        lblVentaPrecioUnit.setText(String.format("Precio unit.: S/ %.2f", s.getPrecioBase()));
        if (!cantStr.isEmpty() && cantStr.matches("\\d+")) {
            int cant = Integer.parseInt(cantStr);
            lblVentaCantidad2.setText("Cantidad    : " + cant);
            lblVentaTotal    .setText(String.format("TOTAL       : S/ %.2f", s.getPrecioBase() * cant));
        } else {
            lblVentaCantidad2.setText("Cantidad    : ---");
            lblVentaTotal    .setText("TOTAL       : ---");
        }
    }

    private void registrarVenta() {
        int idx = cboVentaSupl.getSelectedIndex();
        if (idx < 0) { JOptionPane.showMessageDialog(this, "Seleccionar suplemento."); return; }
        String cantStr = txtVentaCantidad.getText().trim();
        if (cantStr.isEmpty()) { JOptionPane.showMessageDialog(this, "Complete todos los campos."); return; }
        if (!cantStr.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser un número entero positivo."); return;
        }
        int cant = Integer.parseInt(cantStr);
        if (cant <= 0) {
            JOptionPane.showMessageDialog(this, "No se permiten valores negativos o cero."); return;
        }
        Suplemento supl = listaSupl.get(idx);
        if (supl.getStock() < cant) {
            JOptionPane.showMessageDialog(this,
                    "Stock insuficiente.\nStock disponible: " + supl.getStock()
                    + "  |  Cantidad solicitada: " + cant); return;
        }
        String codigoVenta = "V" + String.format("%03d", contadorVenta++);
        Venta venta = new Venta(codigoVenta, java.time.LocalDate.now().toString(),
                supl, cant, supl.getPrecioBase());
        venta.registrarVenta();
        listaVentas.add(venta);
        cargarTablaVentas();
        limpiarCamposVenta();
        actualizarComboVentaSupl();
        JOptionPane.showMessageDialog(this, venta.mostrarVenta());
    }

    private void cargarTablaVentas() {
        modeloTablaVentas.setRowCount(0);
        for (Venta v : listaVentas) {
            modeloTablaVentas.addRow(new Object[]{
                v.getCodigoVenta(), v.getSuplemento().getNombre(),
                v.getCantidad(),
                String.format("S/ %.2f", v.getPrecioUnitario()),
                String.format("S/ %.2f", v.getTotalVenta())
            });
        }
    }

    private void limpiarCamposVenta() {
        txtVentaCantidad.setText("");
        lblVentaNomSupl   .setText("Suplemento  : ---");
        lblVentaPrecioUnit.setText("Precio unit.: ---");
        lblVentaCantidad2 .setText("Cantidad    : ---");
        lblVentaTotal     .setText("TOTAL       : ---");
    }
}
