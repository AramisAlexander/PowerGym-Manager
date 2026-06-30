/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package powergym.manager;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author ALEXANDER
 */
public class FrmLogin extends JFrame{
    //COLORES TEMATICA GYM 
    private static final Color COLOR_FONDO   = new Color(18, 18, 18);
    private static final Color COLOR_PANEL   = new Color(30, 30, 30);
    private static final Color COLOR_CAMPO   = new Color(50, 50, 50);
    private static final Color COLOR_ACENTO  = new Color(220, 30, 30);
    private static final Color COLOR_TEXTO   = new Color(240, 240, 240);
    private static final Color COLOR_TEXTO2  = new Color(160, 160, 160);
    private static final Color COLOR_BORDE   = new Color(60, 60, 60);

    //COMPONENTES
    private JLabel         lblTitulo;
    private JLabel         lblUsuario;
    private JLabel         lblContrasena;
    private JTextField     txtUsuario;
    private JPasswordField txtContrasena;
    private JButton        btnIngresar;
    private JButton        btnCancelar;

    //CREDENCIALES
    private static final String USUARIO_VALIDO    = "admin";
    private static final String CONTRASENA_VALIDA = "1234";

    //Constructor de la ventana Login.
    public FrmLogin() {
        setTitle("PowerGym Manager - Inicio de Sesión");
        setSize(420, 320);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setBackground(COLOR_FONDO);
        construirFormulario();
    }

    //Construye y posiciona todos los componentes del formulario de login con el tema oscuro de gimnasio.
    private void construirFormulario() {
        JPanel panel = new JPanel(null) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                int w = getWidth(); int h = getHeight();
                //Fondo degradado oscuro
                GradientPaint bg = new GradientPaint(0, 0, new Color(12,12,12), w, h, new Color(28,28,28));
                g2.setPaint(bg);
                g2.fillRect(0, 0, w, h);
                //Franja roja superior
                g2.setColor(new Color(220, 30, 30));
                g2.fillRect(0, 0, w, 4);
                //Círculo decorativo
                g2.setColor(new Color(200, 30, 30, 20));
                g2.fillOval(w - 130, h - 130, 180, 180);
                g2.dispose();
            }
        };
        add(panel);

        //Título
        lblTitulo = new JLabel("    POWER GYM MANAGER");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setBounds(55, 22, 320, 30);
        panel.add(lblTitulo);

        JLabel lblSub = new JLabel("Ingrese sus credenciales para continuar");
        lblSub.setFont(new Font("Arial", Font.PLAIN, 11));
        lblSub.setForeground(COLOR_TEXTO2);
        lblSub.setBounds(75, 54, 300, 18);
        panel.add(lblSub);

        // Separador rojo
        JSeparator sep = new JSeparator();
        sep.setBounds(20, 76, 370, 2);
        sep.setForeground(COLOR_ACENTO);
        sep.setBackground(COLOR_ACENTO);
        panel.add(sep);

        // Usuario
        lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("Arial", Font.PLAIN, 13));
        lblUsuario.setForeground(COLOR_TEXTO2);
        lblUsuario.setBounds(50, 100, 100, 25);
        panel.add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBackground(COLOR_CAMPO);
        txtUsuario.setForeground(COLOR_TEXTO);
        txtUsuario.setCaretColor(COLOR_ACENTO);
        txtUsuario.setFont(new Font("Arial", Font.PLAIN, 13));
        txtUsuario.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(COLOR_BORDE),
                BorderFactory.createEmptyBorder(3, 8, 3, 8)));
        txtUsuario.setBounds(170, 100, 200, 30);
        panel.add(txtUsuario);

        // Contraseña
        lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setFont(new Font("Arial", Font.PLAIN, 13));
        lblContrasena.setForeground(COLOR_TEXTO2);
        lblContrasena.setBounds(50, 145, 110, 25);
        panel.add(lblContrasena);

        txtContrasena = new JPasswordField();
        txtContrasena.setBackground(COLOR_CAMPO);
        txtContrasena.setForeground(COLOR_TEXTO);
        txtContrasena.setCaretColor(COLOR_ACENTO);
        txtContrasena.setFont(new Font("Arial", Font.PLAIN, 13));
        txtContrasena.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(COLOR_BORDE),
                BorderFactory.createEmptyBorder(3, 8, 3, 8)));
        txtContrasena.setBounds(170, 145, 200, 30);
        panel.add(txtContrasena);

        // Botón Ingresar (rojo)
        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBackground(COLOR_ACENTO);
        btnIngresar.setForeground(Color.WHITE);
        btnIngresar.setFont(new Font("Arial", Font.BOLD, 13));
        btnIngresar.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
        btnIngresar.setFocusPainted(false);
        btnIngresar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnIngresar.setBounds(70, 205, 130, 40);
        panel.add(btnIngresar);

        // Botón Cancelar
        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(COLOR_BORDE);
        btnCancelar.setForeground(COLOR_TEXTO);
        btnCancelar.setFont(new Font("Arial", Font.BOLD, 13));
        btnCancelar.setBorder(BorderFactory.createEmptyBorder(8, 20, 8, 20));
        btnCancelar.setFocusPainted(false);
        btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnCancelar.setBounds(220, 205, 130, 40);
        panel.add(btnCancelar);

        // Eventos
        btnIngresar  .addActionListener(e -> validarLogin());
        btnCancelar  .addActionListener(e -> System.exit(0));
        txtContrasena.addActionListener(e -> validarLogin());
    }

    //Metodo que valida las credenciales ingresadas por el usuario.
    private void validarLogin() {
        String usuario    = txtUsuario.getText().trim();
        String contrasena = new String(txtContrasena.getPassword()).trim();

        if (usuario.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Complete todos los campos.\nEl usuario es obligatorio.",
                    "Campo requerido", JOptionPane.WARNING_MESSAGE);
            limpiarCampos();
            txtUsuario.requestFocus();
            return;
        }

        if (contrasena.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Complete todos los campos.\nLa contraseña es obligatoria.",
                    "Campo requerido", JOptionPane.WARNING_MESSAGE);
            limpiarCampos();
            txtContrasena.requestFocus();
            return;
        }

        if (usuario.equals(USUARIO_VALIDO) && contrasena.equals(CONTRASENA_VALIDA)) {
            FrmPowerGymManager ventanaPrincipal = new FrmPowerGymManager();
            ventanaPrincipal.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Usuario o contraseña incorrectos.\nIntente nuevamente.",
                    "Acceso denegado", JOptionPane.ERROR_MESSAGE);
            limpiarCampos();
            txtUsuario.requestFocus();
        }
    }

    // Metodo que limpia ambos campos del formulario de login
    private void limpiarCampos() {
        txtUsuario.setText("");
        txtContrasena.setText("");
    }

}
