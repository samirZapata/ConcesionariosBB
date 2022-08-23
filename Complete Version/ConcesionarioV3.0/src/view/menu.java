package view;

import controller.Cola;
import controller.Listas;
import controller.Pila;
import controller.inventarioCarrosCr;
import controller.productoscreate;
import controller.userCreate;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Conexion;
import model.registro;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author yonier
 */
public class menu extends javax.swing.JPanel {

    private main main;
    private userCreate dt;
    private productoscreate pc;
    private inventarioCarrosCr ic;

    registro mensajero = new registro();
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel MDInventario = new DefaultTableModel();
    DefaultTableModel MDProduct = new DefaultTableModel();
    TableRowSorter trs; // Clasificar las filas de una tabla

    registro rg = new registro();
    Conexion c = new Conexion();
    Statement sta;
    String sql;
    Connection cn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    private Inventario In;

    public menu(main main, userCreate dt) {
        this.main = main;
        this.dt = dt;
        initComponents();
        mostrarAdmin();
        mostrar();
        mostrarP();
        traercitycar();
        traerclasico();
        traerpickup();
        traertodoterreno();
        traerdeportivos();
        ver();
    }

    void setColor(JPanel panel) { //51,51,55
        panel.setBackground(new Color(86, 70, 117));
    }

    void resetColor(JPanel panel) {
        panel.setBackground(new Color(65, 48, 100));
    }

    private void mostrarAdmin() {
        this.model.addColumn("Nombre Y apellido");
        this.model.addColumn("Direccion");
        this.model.addColumn("Telefono");
        this.model.addColumn("Email");
        this.model.addColumn("Cedula");
        this.model.addColumn("Ciudad");
        this.model.addColumn("Usuario");
        this.model.addColumn("Contraseña");
        this.model.addColumn("Rol");
        TBAdmin.setModel(model);
        Listas<userCreate> dato = mensajero.mostrarAdmin();
        if (dato != null) {
            Object[] filas = new Object[10];
            try {
                for (int i = 0; i < dato.size(); i++) {
                    filas[0] = (dato.get(i).getNombresYapellidos());
                    filas[1] = (dato.get(i).getDireccion());
                    filas[2] = (dato.get(i).getTelefono());
                    filas[3] = (dato.get(i).getEmail());
                    filas[4] = (dato.get(i).getCedula());
                    filas[5] = (dato.get(i).getCiudad());
                    filas[6] = (dato.get(i).getUser());
                    filas[7] = (dato.get(i).getPass());
                    filas[8] = (dato.get(i).getRol());
                    //int tama = dato.tamanio();
                    model.fireTableDataChanged();
                    //lblTamanio.setText(String.valueOf(i));
                    model.addRow(filas);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al consultar los datos!!");
                e.printStackTrace();
                e.getLocalizedMessage();
            }
        }
    }

    private void mostrar() {
        this.MDInventario.addColumn("Placa");
        this.MDInventario.addColumn("Modelo");
        this.MDInventario.addColumn("Color");
        this.MDInventario.addColumn("NoMotor");
        this.MDInventario.addColumn("Ciudad");
        this.MDInventario.addColumn("Marca");
        this.MDInventario.addColumn("Tipo");
        //this.model.addColumn("Imagen");
        TBInventario.setModel(MDInventario);
        //Creo el objeto de tipo inventarioCarrosCr
        Pila<inventarioCarrosCr> datos = mensajero.mostrarinventario();

        if (datos != null) {
            //Creo las filas de la tabla
            Object[] filas = new Object[8];
            try {
                //Recorro el tamaño de la pila
                for (int i = 0; i < datos.size(); i++) {
                    //Asigno el valor de la pila en cada variable a 
                    //cada pocision de la tabla
                    filas[0] = (datos.get(i).getPlaca());
                    filas[1] = (datos.get(i).getModelo());
                    filas[2] = (datos.get(i).getColor());
                    filas[3] = (datos.get(i).getNoMotor());
                    filas[4] = (datos.get(i).getCiudad());
                    filas[5] = (datos.get(i).getMarca());
                    filas[6] = (datos.get(i).getTipoc());
                    //filas[7] = (datos.get(i).getImagen());
                    MDInventario.addRow(filas);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al consultar los datos!!");
                e.printStackTrace();
                e.getLocalizedMessage();
            }
        }
    }

    private void mostrarP() {
        this.MDProduct.addColumn("Referencia");
        this.MDProduct.addColumn("Nombre");
        this.MDProduct.addColumn("Marca");
        this.MDProduct.addColumn("Tipo producto");
        this.MDProduct.addColumn("APlicación");
        this.MDProduct.addColumn("Cantidad");
        this.MDProduct.addColumn("Precio");
        //this.model.addColumn("Imagen");
        TBProductos.setModel(MDProduct);
        //Creo el objeto de tipo inventarioCarrosCr
        Cola<productoscreate> datos = mensajero.mostrarproducto();

        if (datos != null) {
            //Creo las filas de la tabla
            Object[] filas = new Object[8];
            try {
                //Recorro el tamaño de la pila
                for (int i = 0; i < datos.size(); i++) {
                    //Asigno el valor de la pila en cada variable a 
                    //cada pocision de la tabla
                    filas[0] = (datos.obtener(i).getReferencia());
                    filas[1] = (datos.obtener(i).getNombre());
                    filas[2] = (datos.obtener(i).getMarca());
                    filas[3] = (datos.obtener(i).getTipoprod());
                    filas[4] = (datos.obtener(i).getAplicacion());
                    filas[5] = (datos.obtener(i).getCantidadprod());
                    filas[6] = (datos.obtener(i).getPrecio());
                    //filas[7] = (datos.obtener(i).getImagenprod());
                    MDProduct.addRow(filas);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al consultar los datos!!");
                e.printStackTrace();
                e.getLocalizedMessage();
            }
        }
    }

    private void ver() {
        int C1 = Integer.parseInt(txtdeportivo.getText());
        int C2 = Integer.parseInt(txtClasico.getText());
        int C3 = Integer.parseInt(txtTodoterreno.getText());
        int C4 = Integer.parseInt(txtPickup.getText());
        int C5 = Integer.parseInt(txtCitycar.getText());
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(C1, "deportivo", "deportivo");
        dataset.setValue(C2, "clasico", "Clasico");
        dataset.setValue(C3, "Todoterreno", "Todoterreno");
        dataset.setValue(C4, "Pickup", "Pickup");
        dataset.setValue(C5, "Citycar", "Citycar");
        JFreeChart chart = ChartFactory.createBarChart3D("Tipos de carros mas concurrentes", "tipo carro", "cantidad carro", dataset, PlotOrientation.VERTICAL, true, true, true);
        //JFreeChart chart = ChartFactory.createBarChart3D("Tipo de carro", "tipo carro", "cantidad carro", dataset, PlotOrientation.VERTICAL, true, true, true);
       /*
        DefaultPieDataset d = new DefaultPieDataset();
        d.setValue("Deportivos", C1);
        d.setValue("Clasico", C2);
        d.setValue("Todoterreno", C3);
        d.setValue("Pickup", C4);
        d.setValue("Citycar", C5);
        JFreeChart c = ChartFactory.createPieChart3D("Carros concurrentes", d, true, true, true);
        */
        CategoryPlot catPlot = chart.getCategoryPlot();
        catPlot.setRangeGridlinePaint(Color.BLACK);
        ChartPanel chartPanel = new ChartPanel(chart);
        PanelEstadistica.setLayout(new java.awt.BorderLayout());
        PanelEstadistica.add(chartPanel, BorderLayout.CENTER);
        PanelEstadistica.validate();
        
        //ChartUtilities.applyCurrentTheme(chart);
    }

    public void traerdeportivos() {
        try {
            cn = c.getConnection();
            // sql = "SELECT * FROM Registrar WHERE NombresyApellidos=?";
            ps = cn.prepareStatement("select count(Tipoc) from registroinventario where Tipoc='deportivo'");
            //ps.setString(1, dato);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int c6 = rs.getInt(1);
                    System.out.println(c6);
                    txtdeportivo.setText(String.valueOf(c6));
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error inesperado, estamos trabajando en ello!");
            //System.err.format("SQL State: %s\n%s ", e.getSQLState(), e.getMessage());
        }
    }

    public void traerclasico() {
        try {
            cn = c.getConnection();
            // sql = "SELECT * FROM Registrar WHERE NombresyApellidos=?";
            ps = cn.prepareStatement("select count(Tipoc) from registroinventario where Tipoc='clasico'");
            //ps.setString(1, dato);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int c6 = rs.getInt(1);
                    System.out.println(c6);
                    txtClasico.setText(String.valueOf(c6));
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error inesperado, estamos trabajando en ello!");
            //System.err.format("SQL State: %s\n%s ", e.getSQLState(), e.getMessage());
        }
    }

    public void traertodoterreno() {
        try {
            cn = c.getConnection();
            // sql = "SELECT * FROM Registrar WHERE NombresyApellidos=?";
            ps = cn.prepareStatement("select count(Tipoc) from registroinventario where Tipoc='todoterreno'");
            //ps.setString(1, dato);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int c6 = rs.getInt(1);
                    System.out.println(c6);
                    txtTodoterreno.setText(String.valueOf(c6));
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error inesperado, estamos trabajando en ello!");
            //System.err.format("SQL State: %s\n%s ", e.getSQLState(), e.getMessage());
        }
    }

    public void traerpickup() {
        try {
            cn = c.getConnection();
            // sql = "SELECT * FROM Registrar WHERE NombresyApellidos=?";
            ps = cn.prepareStatement("select count(Tipoc) from registroinventario where Tipoc='pickup'");
            //ps.setString(1, dato);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int c6 = rs.getInt(1);
                    System.out.println(c6);
                    txtPickup.setText(String.valueOf(c6));
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error inesperado, estamos trabajando en ello!");
            //System.err.format("SQL State: %s\n%s ", e.getSQLState(), e.getMessage());
        }
    }

    public void traercitycar() {
        try {
            cn = c.getConnection();
            // sql = "SELECT * FROM Registrar WHERE NombresyApellidos=?";
            ps = cn.prepareStatement("select count(Tipoc) from registroinventario where Tipoc='city car'");
            //ps.setString(1, dato);
            rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    int c6 = rs.getInt(1);
                    System.out.println(c6);
                    txtCitycar.setText(String.valueOf(c6));
                }
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error inesperado, estamos trabajando en ello!");
            //System.err.format("SQL State: %s\n%s ", e.getSQLState(), e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        pnlPrincipal = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        PanelEstadistica = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        rSLabelHora7 = new rojeru_san.RSLabelHora();
        rSLabelFecha7 = new rojeru_san.RSLabelFecha();
        jPanel14 = new javax.swing.JPanel();
        txtCitycar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtPickup = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTodoterreno = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtClasico = new javax.swing.JTextField();
        txtdeportivo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pnlUsers = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TBAdmin = new javax.swing.JTable();
        jLabel45 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        rSLabelFecha1 = new rojeru_san.RSLabelFecha();
        rSLabelHora1 = new rojeru_san.RSLabelHora();
        btn1User = new keeptoo.KButton();
        btn2User = new keeptoo.KButton();
        btn3User = new keeptoo.KButton();
        btn3User2 = new keeptoo.KButton();
        pnlInventario = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        rSLabelFecha2 = new rojeru_san.RSLabelFecha();
        rSLabelHora2 = new rojeru_san.RSLabelHora();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBInventario = new javax.swing.JTable();
        jLabel46 = new javax.swing.JLabel();
        btn5Inventario = new keeptoo.KButton();
        btn6Inventario = new keeptoo.KButton();
        btn7Inventario = new keeptoo.KButton();
        btn8Inventario = new keeptoo.KButton();
        pnlProductos = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        rSLabelFecha3 = new rojeru_san.RSLabelFecha();
        rSLabelHora3 = new rojeru_san.RSLabelHora();
        jLabel47 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        btn12Product = new keeptoo.KButton();
        jLabel48 = new javax.swing.JLabel();
        btn11Product = new keeptoo.KButton();
        btn10Product = new keeptoo.KButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TBProductos = new javax.swing.JTable();
        btn9Product2 = new keeptoo.KButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        btn1 = new keeptoo.KButton();
        btn3 = new keeptoo.KButton();
        btn4 = new keeptoo.KButton();
        btn5 = new keeptoo.KButton();
        btn6 = new keeptoo.KButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        pnliniciose1 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        pnlPrincipal1 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        PanelEstadistica1 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        rSLabelHora8 = new rojeru_san.RSLabelHora();
        rSLabelFecha8 = new rojeru_san.RSLabelFecha();
        jPanel17 = new javax.swing.JPanel();
        txtCitycar1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtPickup1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtTodoterreno1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtClasico1 = new javax.swing.JTextField();
        txtdeportivo1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        pnlUsers1 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TBAdmin1 = new javax.swing.JTable();
        jLabel55 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        rSLabelFecha4 = new rojeru_san.RSLabelFecha();
        rSLabelHora4 = new rojeru_san.RSLabelHora();
        btn1User1 = new keeptoo.KButton();
        btn2User1 = new keeptoo.KButton();
        btn3User1 = new keeptoo.KButton();
        btn3User3 = new keeptoo.KButton();
        pnlInventario1 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        rSLabelFecha5 = new rojeru_san.RSLabelFecha();
        rSLabelHora5 = new rojeru_san.RSLabelHora();
        jScrollPane4 = new javax.swing.JScrollPane();
        TBInventario1 = new javax.swing.JTable();
        jLabel56 = new javax.swing.JLabel();
        btn5Inventario1 = new keeptoo.KButton();
        btn6Inventario1 = new keeptoo.KButton();
        btn7Inventario1 = new keeptoo.KButton();
        btn8Inventario1 = new keeptoo.KButton();
        pnlProductos1 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        rSLabelFecha6 = new rojeru_san.RSLabelFecha();
        rSLabelHora6 = new rojeru_san.RSLabelHora();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        btn12Product1 = new keeptoo.KButton();
        jLabel59 = new javax.swing.JLabel();
        btn11Product1 = new keeptoo.KButton();
        btn10Product1 = new keeptoo.KButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        TBProductos1 = new javax.swing.JTable();
        btn9Product3 = new keeptoo.KButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel28 = new javax.swing.JLabel();
        lblUser1 = new javax.swing.JLabel();
        btn2 = new keeptoo.KButton();
        btn7 = new keeptoo.KButton();
        btn8 = new keeptoo.KButton();
        btn9 = new keeptoo.KButton();
        btn10 = new keeptoo.KButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setMaximumSize(new java.awt.Dimension(820, 720));
        jPanel2.setLayout(new java.awt.CardLayout());

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlPrincipal.setMaximumSize(new java.awt.Dimension(820, 720));
        pnlPrincipal.setMinimumSize(new java.awt.Dimension(820, 720));
        pnlPrincipal.setPreferredSize(new java.awt.Dimension(980, 720));
        pnlPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelEstadistica.setBackground(new java.awt.Color(18, 30, 49));
        PanelEstadistica.setLayout(new java.awt.BorderLayout());
        jPanel12.add(PanelEstadistica, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 980, 350));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSLabelHora7.setForeground(new java.awt.Color(18, 30, 49));
        rSLabelHora7.setFont(new java.awt.Font("Roboto Bold", 1, 60)); // NOI18N
        jPanel13.add(rSLabelHora7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 350, 70));

        rSLabelFecha7.setForeground(new java.awt.Color(18, 30, 49));
        rSLabelFecha7.setFont(new java.awt.Font("Roboto Bold", 1, 24)); // NOI18N
        jPanel13.add(rSLabelFecha7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 210, -1));

        jPanel12.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 430, 210));

        jPanel14.setBackground(new java.awt.Color(204, 204, 204));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCitycar.setEnabled(false);
        jPanel14.add(txtCitycar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 50, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Citycar");
        jLabel8.setEnabled(false);
        jPanel14.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Pickup");
        jLabel7.setEnabled(false);
        jPanel14.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, -1, -1));

        txtPickup.setEnabled(false);
        txtPickup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPickupActionPerformed(evt);
            }
        });
        jPanel14.add(txtPickup, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 50, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Todoterrreno");
        jLabel5.setEnabled(false);
        jPanel14.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));

        txtTodoterreno.setEnabled(false);
        txtTodoterreno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTodoterrenoActionPerformed(evt);
            }
        });
        jPanel14.add(txtTodoterreno, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 50, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Clasico");
        jLabel4.setEnabled(false);
        jPanel14.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, 30));

        txtClasico.setEnabled(false);
        txtClasico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClasicoActionPerformed(evt);
            }
        });
        jPanel14.add(txtClasico, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 50, -1));

        txtdeportivo.setEnabled(false);
        txtdeportivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdeportivoActionPerformed(evt);
            }
        });
        jPanel14.add(txtdeportivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 50, -1));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Deportivo");
        jLabel2.setEnabled(false);
        jPanel14.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        jPanel12.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 980, 70));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/marginalia-car-rental2.png"))); // NOI18N
        jPanel12.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 510, 290));

        pnlPrincipal.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 720));

        jPanel2.add(pnlPrincipal, "card2");

        pnlUsers.setBackground(new java.awt.Color(242, 243, 235));
        pnlUsers.setMaximumSize(new java.awt.Dimension(820, 720));
        pnlUsers.setMinimumSize(new java.awt.Dimension(820, 720));
        pnlUsers.setPreferredSize(new java.awt.Dimension(980, 720));
        pnlUsers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel43.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(0, 10, 56));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("Gestionar usuario");
        pnlUsers.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 500, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fdUsers.jpg"))); // NOI18N
        pnlUsers.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, 330, 290));

        TBAdmin.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(TBAdmin);

        pnlUsers.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 530, 350));

        jLabel45.setBackground(new java.awt.Color(51, 51, 51));
        jLabel45.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(102, 0, 153));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Administradores");
        pnlUsers.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 520, 30));

        jPanel3.setBackground(new java.awt.Color(242, 243, 235));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSLabelFecha1.setForeground(new java.awt.Color(102, 0, 153));
        rSLabelFecha1.setFont(new java.awt.Font("Roboto Bold", 1, 24)); // NOI18N
        jPanel3.add(rSLabelFecha1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 210, 40));

        rSLabelHora1.setForeground(new java.awt.Color(102, 0, 153));
        rSLabelHora1.setFont(new java.awt.Font("Roboto Bold", 1, 48)); // NOI18N
        jPanel3.add(rSLabelHora1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 290, 70));

        pnlUsers.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, 400, 150));

        btn1User.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_administrator_30px.png"))); // NOI18N
        btn1User.setText("    Nuevo Usuario");
        btn1User.setAlignmentY(0.2F);
        btn1User.setBorderPainted(false);
        btn1User.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn1User.setIconTextGap(15);
        btn1User.setkBackGroundColor(new java.awt.Color(22, 32, 45));
        btn1User.setkEndColor(new java.awt.Color(102, 102, 255));
        btn1User.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn1User.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn1User.setkHoverStartColor(new java.awt.Color(51, 0, 51));
        btn1User.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn1User.setkSelectedColor(new java.awt.Color(51, 0, 51));
        btn1User.setkStartColor(new java.awt.Color(22, 32, 45));
        btn1User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1UserActionPerformed(evt);
            }
        });
        pnlUsers.add(btn1User, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 190, 120));

        btn2User.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_account_30px_1.png"))); // NOI18N
        btn2User.setText("           Modificar Usuario");
        btn2User.setAlignmentY(0.2F);
        btn2User.setBorderPainted(false);
        btn2User.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn2User.setIconTextGap(15);
        btn2User.setkBackGroundColor(new java.awt.Color(51, 51, 255));
        btn2User.setkEndColor(new java.awt.Color(255, 0, 51));
        btn2User.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn2User.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn2User.setkHoverStartColor(new java.awt.Color(51, 0, 51));
        btn2User.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn2User.setkSelectedColor(new java.awt.Color(51, 0, 51));
        btn2User.setkStartColor(new java.awt.Color(22, 32, 45));
        btn2User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2UserActionPerformed(evt);
            }
        });
        pnlUsers.add(btn2User, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 190, 120));

        btn3User.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_full_trash_30px.png"))); // NOI18N
        btn3User.setText("           Eliminar Usuario");
        btn3User.setAlignmentY(0.2F);
        btn3User.setBorderPainted(false);
        btn3User.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn3User.setIconTextGap(15);
        btn3User.setkBackGroundColor(new java.awt.Color(255, 255, 51));
        btn3User.setkEndColor(new java.awt.Color(255, 0, 102));
        btn3User.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn3User.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn3User.setkHoverStartColor(new java.awt.Color(51, 0, 51));
        btn3User.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn3User.setkSelectedColor(new java.awt.Color(51, 0, 51));
        btn3User.setkStartColor(new java.awt.Color(22, 32, 45));
        btn3User.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3UserActionPerformed(evt);
            }
        });
        pnlUsers.add(btn3User, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 190, 120));

        btn3User2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_search_client_30px.png"))); // NOI18N
        btn3User2.setText("           Visualizar Usuarios");
        btn3User2.setAlignmentY(0.2F);
        btn3User2.setBorderPainted(false);
        btn3User2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn3User2.setIconTextGap(15);
        btn3User2.setkBackGroundColor(new java.awt.Color(255, 255, 153));
        btn3User2.setkEndColor(new java.awt.Color(102, 0, 153));
        btn3User2.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn3User2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn3User2.setkHoverStartColor(new java.awt.Color(51, 0, 51));
        btn3User2.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn3User2.setkSelectedColor(new java.awt.Color(51, 0, 51));
        btn3User2.setkStartColor(new java.awt.Color(22, 32, 45));
        btn3User2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3User2ActionPerformed(evt);
            }
        });
        pnlUsers.add(btn3User2, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, 190, 120));

        jPanel2.add(pnlUsers, "card3");

        pnlInventario.setBackground(new java.awt.Color(242, 243, 235));
        pnlInventario.setMaximumSize(new java.awt.Dimension(820, 720));
        pnlInventario.setMinimumSize(new java.awt.Dimension(820, 720));
        pnlInventario.setPreferredSize(new java.awt.Dimension(980, 720));
        pnlInventario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fdInvent.jpg"))); // NOI18N
        jLabel11.setMaximumSize(new java.awt.Dimension(350, 233));
        jLabel11.setMinimumSize(new java.awt.Dimension(350, 233));
        jLabel11.setPreferredSize(new java.awt.Dimension(350, 233));
        pnlInventario.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 400, 300));

        jLabel15.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Gestionar inventario");
        pnlInventario.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, -1));

        jPanel4.setBackground(new java.awt.Color(242, 243, 235));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSLabelFecha2.setForeground(new java.awt.Color(102, 0, 153));
        rSLabelFecha2.setFont(new java.awt.Font("Roboto Bold", 1, 24)); // NOI18N
        jPanel4.add(rSLabelFecha2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        rSLabelHora2.setForeground(new java.awt.Color(102, 0, 153));
        rSLabelHora2.setFont(new java.awt.Font("Roboto Bold", 1, 48)); // NOI18N
        jPanel4.add(rSLabelHora2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 290, 70));

        pnlInventario.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, 400, 150));

        TBInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TBInventario);

        pnlInventario.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 352, 480, 370));

        jLabel46.setBackground(new java.awt.Color(51, 51, 51));
        jLabel46.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(102, 0, 153));
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel46.setText("Vista Previa Inventario");
        pnlInventario.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 480, 30));

        btn5Inventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_open_box_30px.png"))); // NOI18N
        btn5Inventario.setText("           Nuevo Inventario");
        btn5Inventario.setAlignmentY(0.2F);
        btn5Inventario.setBorderPainted(false);
        btn5Inventario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn5Inventario.setIconTextGap(15);
        btn5Inventario.setkBackGroundColor(new java.awt.Color(22, 32, 45));
        btn5Inventario.setkEndColor(new java.awt.Color(102, 102, 255));
        btn5Inventario.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn5Inventario.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn5Inventario.setkHoverStartColor(new java.awt.Color(51, 0, 51));
        btn5Inventario.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn5Inventario.setkSelectedColor(new java.awt.Color(51, 0, 51));
        btn5Inventario.setkStartColor(new java.awt.Color(22, 32, 45));
        btn5Inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5InventarioActionPerformed(evt);
            }
        });
        pnlInventario.add(btn5Inventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 190, 120));

        btn6Inventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/inventory.png"))); // NOI18N
        btn6Inventario.setText("           Modificar Inventario");
        btn6Inventario.setAlignmentY(0.2F);
        btn6Inventario.setBorderPainted(false);
        btn6Inventario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn6Inventario.setIconTextGap(5);
        btn6Inventario.setkBackGroundColor(new java.awt.Color(51, 51, 255));
        btn6Inventario.setkEndColor(new java.awt.Color(255, 0, 51));
        btn6Inventario.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn6Inventario.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn6Inventario.setkHoverStartColor(new java.awt.Color(51, 0, 51));
        btn6Inventario.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn6Inventario.setkSelectedColor(new java.awt.Color(51, 0, 51));
        btn6Inventario.setkStartColor(new java.awt.Color(22, 32, 45));
        btn6Inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6InventarioActionPerformed(evt);
            }
        });
        pnlInventario.add(btn6Inventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 190, 120));

        btn7Inventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_full_trash_30px.png"))); // NOI18N
        btn7Inventario.setText("           Eliminar Inventario");
        btn7Inventario.setAlignmentY(0.2F);
        btn7Inventario.setBorderPainted(false);
        btn7Inventario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn7Inventario.setIconTextGap(15);
        btn7Inventario.setkBackGroundColor(new java.awt.Color(255, 255, 51));
        btn7Inventario.setkEndColor(new java.awt.Color(255, 0, 102));
        btn7Inventario.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn7Inventario.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn7Inventario.setkHoverStartColor(new java.awt.Color(51, 0, 51));
        btn7Inventario.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn7Inventario.setkSelectedColor(new java.awt.Color(51, 0, 51));
        btn7Inventario.setkStartColor(new java.awt.Color(22, 32, 45));
        btn7Inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7InventarioActionPerformed(evt);
            }
        });
        pnlInventario.add(btn7Inventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 200, 120));

        btn8Inventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ver.png"))); // NOI18N
        btn8Inventario.setText("           Visualizar Inventario");
        btn8Inventario.setAlignmentY(0.2F);
        btn8Inventario.setBorderPainted(false);
        btn8Inventario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn8Inventario.setIconTextGap(10);
        btn8Inventario.setkBackGroundColor(new java.awt.Color(255, 255, 153));
        btn8Inventario.setkEndColor(new java.awt.Color(102, 0, 153));
        btn8Inventario.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn8Inventario.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn8Inventario.setkHoverStartColor(new java.awt.Color(51, 0, 51));
        btn8Inventario.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn8Inventario.setkSelectedColor(new java.awt.Color(51, 0, 51));
        btn8Inventario.setkStartColor(new java.awt.Color(22, 32, 45));
        btn8Inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8InventarioActionPerformed(evt);
            }
        });
        pnlInventario.add(btn8Inventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, 200, 120));

        jPanel2.add(pnlInventario, "card4");

        pnlProductos.setBackground(new java.awt.Color(245, 243, 235));
        pnlProductos.setMaximumSize(new java.awt.Dimension(820, 720));
        pnlProductos.setMinimumSize(new java.awt.Dimension(820, 720));
        pnlProductos.setPreferredSize(new java.awt.Dimension(820, 720));
        pnlProductos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(3, 18, 59));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Gestionar productos");
        pnlProductos.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 410, 60));

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fproduct.jpg"))); // NOI18N
        jLabel23.setMaximumSize(new java.awt.Dimension(350, 233));
        jLabel23.setMinimumSize(new java.awt.Dimension(350, 233));
        jLabel23.setPreferredSize(new java.awt.Dimension(350, 233));
        pnlProductos.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 430, -1, 290));

        jPanel5.setBackground(new java.awt.Color(242, 243, 235));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSLabelFecha3.setForeground(new java.awt.Color(102, 0, 153));
        rSLabelFecha3.setFont(new java.awt.Font("Roboto Bold", 1, 24)); // NOI18N
        jPanel5.add(rSLabelFecha3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        rSLabelHora3.setForeground(new java.awt.Color(102, 0, 153));
        rSLabelHora3.setFont(new java.awt.Font("Roboto Bold", 1, 48)); // NOI18N
        jPanel5.add(rSLabelHora3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 290, 70));

        pnlProductos.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, 400, 150));

        jLabel47.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(102, 0, 153));
        jLabel47.setText("Productos recientes");
        pnlProductos.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 160, 30));
        pnlProductos.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 160, 110));

        btn12Product.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ver.png"))); // NOI18N
        btn12Product.setText("           Visualizar Productos");
        btn12Product.setAlignmentY(0.2F);
        btn12Product.setBorderPainted(false);
        btn12Product.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn12Product.setIconTextGap(5);
        btn12Product.setkBackGroundColor(new java.awt.Color(255, 255, 153));
        btn12Product.setkEndColor(new java.awt.Color(102, 0, 153));
        btn12Product.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn12Product.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn12Product.setkHoverStartColor(new java.awt.Color(51, 0, 51));
        btn12Product.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn12Product.setkSelectedColor(new java.awt.Color(51, 0, 51));
        btn12Product.setkStartColor(new java.awt.Color(22, 32, 45));
        btn12Product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn12ProductActionPerformed(evt);
            }
        });
        pnlProductos.add(btn12Product, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 120, 190, 120));
        pnlProductos.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 160, 100));

        btn11Product.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_full_trash_30px.png"))); // NOI18N
        btn11Product.setText("           Eliminar Producto");
        btn11Product.setAlignmentY(0.2F);
        btn11Product.setBorderPainted(false);
        btn11Product.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn11Product.setIconTextGap(15);
        btn11Product.setkBackGroundColor(new java.awt.Color(255, 255, 51));
        btn11Product.setkEndColor(new java.awt.Color(255, 0, 102));
        btn11Product.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn11Product.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn11Product.setkHoverStartColor(new java.awt.Color(51, 0, 51));
        btn11Product.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn11Product.setkSelectedColor(new java.awt.Color(51, 0, 51));
        btn11Product.setkStartColor(new java.awt.Color(22, 32, 45));
        btn11Product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn11ProductActionPerformed(evt);
            }
        });
        pnlProductos.add(btn11Product, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 190, 120));

        btn10Product.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_robot_30px.png"))); // NOI18N
        btn10Product.setText("           Modificar Producto");
        btn10Product.setAlignmentY(0.2F);
        btn10Product.setBorderPainted(false);
        btn10Product.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn10Product.setIconTextGap(15);
        btn10Product.setkBackGroundColor(new java.awt.Color(51, 51, 255));
        btn10Product.setkEndColor(new java.awt.Color(255, 0, 51));
        btn10Product.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn10Product.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn10Product.setkHoverStartColor(new java.awt.Color(51, 0, 51));
        btn10Product.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn10Product.setkSelectedColor(new java.awt.Color(51, 0, 51));
        btn10Product.setkStartColor(new java.awt.Color(22, 32, 45));
        btn10Product.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn10ProductActionPerformed(evt);
            }
        });
        pnlProductos.add(btn10Product, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 190, 120));

        TBProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(TBProductos);

        pnlProductos.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 520, 350));

        btn9Product2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_trolley_30px.png"))); // NOI18N
        btn9Product2.setText("           Nuevo Producto");
        btn9Product2.setAlignmentY(0.2F);
        btn9Product2.setBorderPainted(false);
        btn9Product2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn9Product2.setIconTextGap(15);
        btn9Product2.setkBackGroundColor(new java.awt.Color(22, 32, 45));
        btn9Product2.setkEndColor(new java.awt.Color(102, 102, 255));
        btn9Product2.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn9Product2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn9Product2.setkHoverStartColor(new java.awt.Color(51, 0, 51));
        btn9Product2.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn9Product2.setkSelectedColor(new java.awt.Color(51, 0, 51));
        btn9Product2.setkStartColor(new java.awt.Color(22, 32, 45));
        btn9Product2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9Product2ActionPerformed(evt);
            }
        });
        pnlProductos.add(btn9Product2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 190, 120));

        jPanel2.add(pnlProductos, "card5");

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 980, 720));

        jPanel1.setBackground(new java.awt.Color(54, 38, 87));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 720));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo blanco.png"))); // NOI18N
        jPanel1.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 110));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/salida.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 692, 40, 20));

        jLabel20.setFont(new java.awt.Font("Agency FB", 1, 40)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Burnz Buttly");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 170, 60));

        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 160, 10));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_male_user_30px.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, -1));

        lblUser.setForeground(new java.awt.Color(102, 102, 102));
        lblUser.setText("Admin");
        jPanel1.add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 50, 20));

        btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_staff_30px.png"))); // NOI18N
        btn1.setText("Gestionar Usuarios");
        btn1.setBorderPainted(false);
        btn1.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        btn1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn1.setIconTextGap(16);
        btn1.setkBackGroundColor(new java.awt.Color(22, 32, 45));
        btn1.setkEndColor(new java.awt.Color(102, 102, 255));
        btn1.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn1.setkHoverStartColor(new java.awt.Color(22, 32, 45));
        btn1.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn1.setkSelectedColor(new java.awt.Color(255, 102, 153));
        btn1.setkStartColor(new java.awt.Color(54, 38, 87));
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        jPanel1.add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 280, 40));

        btn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_handcart_30px.png"))); // NOI18N
        btn3.setText("Gestionar Inventario");
        btn3.setBorderPainted(false);
        btn3.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        btn3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn3.setIconTextGap(16);
        btn3.setkBackGroundColor(new java.awt.Color(22, 32, 45));
        btn3.setkEndColor(new java.awt.Color(102, 102, 255));
        btn3.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn3.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn3.setkHoverStartColor(new java.awt.Color(22, 32, 45));
        btn3.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn3.setkSelectedColor(new java.awt.Color(255, 102, 153));
        btn3.setkStartColor(new java.awt.Color(54, 38, 87));
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        jPanel1.add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 280, 40));

        btn4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/product.png"))); // NOI18N
        btn4.setText("Gestionar Productos");
        btn4.setBorderPainted(false);
        btn4.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        btn4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn4.setIconTextGap(16);
        btn4.setkBackGroundColor(new java.awt.Color(22, 32, 45));
        btn4.setkEndColor(new java.awt.Color(102, 102, 255));
        btn4.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn4.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn4.setkHoverStartColor(new java.awt.Color(22, 32, 45));
        btn4.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn4.setkSelectedColor(new java.awt.Color(255, 102, 153));
        btn4.setkStartColor(new java.awt.Color(54, 38, 87));
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        jPanel1.add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 280, 40));

        btn5.setText("Integracion de ordenamientos");
        btn5.setBorderPainted(false);
        btn5.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        btn5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn5.setIconTextGap(16);
        btn5.setkBackGroundColor(new java.awt.Color(22, 32, 45));
        btn5.setkEndColor(new java.awt.Color(102, 102, 255));
        btn5.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn5.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn5.setkHoverStartColor(new java.awt.Color(22, 32, 45));
        btn5.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn5.setkSelectedColor(new java.awt.Color(255, 102, 153));
        btn5.setkStartColor(new java.awt.Color(54, 38, 87));
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        jPanel1.add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 280, 40));

        btn6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_combo_chart_32px.png"))); // NOI18N
        btn6.setText("Ver estadisticas");
        btn6.setBorderPainted(false);
        btn6.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        btn6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn6.setIconTextGap(16);
        btn6.setkBackGroundColor(new java.awt.Color(22, 32, 45));
        btn6.setkEndColor(new java.awt.Color(102, 102, 255));
        btn6.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn6.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn6.setkHoverStartColor(new java.awt.Color(22, 32, 45));
        btn6.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn6.setkSelectedColor(new java.awt.Color(255, 102, 153));
        btn6.setkStartColor(new java.awt.Color(54, 38, 87));
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        jPanel1.add(btn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 280, 40));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 720));

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setMaximumSize(new java.awt.Dimension(820, 720));
        jPanel7.setLayout(new java.awt.CardLayout());

        pnliniciose1.setBackground(new java.awt.Color(255, 255, 255));
        pnliniciose1.setMaximumSize(new java.awt.Dimension(820, 720));
        pnliniciose1.setMinimumSize(new java.awt.Dimension(820, 720));
        pnliniciose1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setFont(new java.awt.Font("Segoe UI Light", 1, 48)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("¡Bienvenido!");
        pnliniciose1.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, -1, -1));

        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bienvenido.png"))); // NOI18N
        jLabel53.setName(""); // NOI18N
        pnliniciose1.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, -1));

        jPanel7.add(pnliniciose1, "card2");

        pnlPrincipal1.setBackground(new java.awt.Color(255, 255, 255));
        pnlPrincipal1.setMaximumSize(new java.awt.Dimension(820, 720));
        pnlPrincipal1.setMinimumSize(new java.awt.Dimension(820, 720));
        pnlPrincipal1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelEstadistica1.setBackground(new java.awt.Color(18, 30, 49));
        PanelEstadistica1.setLayout(new java.awt.BorderLayout());
        jPanel15.add(PanelEstadistica1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 980, 350));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSLabelHora8.setForeground(new java.awt.Color(18, 30, 49));
        rSLabelHora8.setFont(new java.awt.Font("Roboto Bold", 1, 60)); // NOI18N
        jPanel16.add(rSLabelHora8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 350, 70));

        rSLabelFecha8.setForeground(new java.awt.Color(18, 30, 49));
        rSLabelFecha8.setFont(new java.awt.Font("Roboto Bold", 1, 24)); // NOI18N
        jPanel16.add(rSLabelFecha8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 210, -1));

        jPanel15.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 430, 210));

        jPanel17.setBackground(new java.awt.Color(204, 204, 204));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtCitycar1.setEnabled(false);
        jPanel17.add(txtCitycar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 40, 50, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Citycar");
        jLabel10.setEnabled(false);
        jPanel17.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, -1, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Pickup");
        jLabel12.setEnabled(false);
        jPanel17.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, -1, -1));

        txtPickup1.setEnabled(false);
        txtPickup1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPickup1ActionPerformed(evt);
            }
        });
        jPanel17.add(txtPickup1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 50, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Todoterrreno");
        jLabel13.setEnabled(false);
        jPanel17.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));

        txtTodoterreno1.setEnabled(false);
        txtTodoterreno1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTodoterreno1ActionPerformed(evt);
            }
        });
        jPanel17.add(txtTodoterreno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 50, -1));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Clasico");
        jLabel14.setEnabled(false);
        jPanel17.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, -1, 30));

        txtClasico1.setEnabled(false);
        txtClasico1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClasico1ActionPerformed(evt);
            }
        });
        jPanel17.add(txtClasico1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 50, -1));

        txtdeportivo1.setEnabled(false);
        txtdeportivo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdeportivo1ActionPerformed(evt);
            }
        });
        jPanel17.add(txtdeportivo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 50, -1));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Deportivo");
        jLabel16.setEnabled(false);
        jPanel17.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        jPanel15.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 650, 980, 70));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/marginalia-car-rental2.png"))); // NOI18N
        jPanel15.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 510, 290));

        pnlPrincipal1.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 720));

        jPanel7.add(pnlPrincipal1, "card2");

        pnlUsers1.setBackground(new java.awt.Color(242, 243, 235));
        pnlUsers1.setMaximumSize(new java.awt.Dimension(820, 720));
        pnlUsers1.setMinimumSize(new java.awt.Dimension(820, 720));
        pnlUsers1.setPreferredSize(new java.awt.Dimension(980, 720));
        pnlUsers1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel54.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(0, 10, 56));
        jLabel54.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel54.setText("Gestionar usuario");
        pnlUsers1.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 500, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fdUsers.jpg"))); // NOI18N
        pnlUsers1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, 330, 290));

        TBAdmin1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(TBAdmin1);

        pnlUsers1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 530, 350));

        jLabel55.setBackground(new java.awt.Color(51, 51, 51));
        jLabel55.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(102, 0, 153));
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel55.setText("Administradores");
        pnlUsers1.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 520, 30));

        jPanel8.setBackground(new java.awt.Color(242, 243, 235));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSLabelFecha4.setForeground(new java.awt.Color(102, 0, 153));
        rSLabelFecha4.setFont(new java.awt.Font("Roboto Bold", 1, 24)); // NOI18N
        jPanel8.add(rSLabelFecha4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 210, 40));

        rSLabelHora4.setForeground(new java.awt.Color(102, 0, 153));
        rSLabelHora4.setFont(new java.awt.Font("Roboto Bold", 1, 48)); // NOI18N
        jPanel8.add(rSLabelHora4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 290, 70));

        pnlUsers1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, 400, 150));

        btn1User1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_administrator_30px.png"))); // NOI18N
        btn1User1.setText("    Nuevo Usuario");
        btn1User1.setAlignmentY(0.2F);
        btn1User1.setBorderPainted(false);
        btn1User1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn1User1.setIconTextGap(15);
        btn1User1.setkBackGroundColor(new java.awt.Color(22, 32, 45));
        btn1User1.setkEndColor(new java.awt.Color(102, 102, 255));
        btn1User1.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn1User1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn1User1.setkHoverStartColor(new java.awt.Color(51, 0, 51));
        btn1User1.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn1User1.setkSelectedColor(new java.awt.Color(51, 0, 51));
        btn1User1.setkStartColor(new java.awt.Color(22, 32, 45));
        btn1User1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1User1ActionPerformed(evt);
            }
        });
        pnlUsers1.add(btn1User1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 190, 120));

        btn2User1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_account_30px_1.png"))); // NOI18N
        btn2User1.setText("           Modificar Usuario");
        btn2User1.setAlignmentY(0.2F);
        btn2User1.setBorderPainted(false);
        btn2User1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn2User1.setIconTextGap(15);
        btn2User1.setkBackGroundColor(new java.awt.Color(51, 51, 255));
        btn2User1.setkEndColor(new java.awt.Color(255, 0, 51));
        btn2User1.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn2User1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn2User1.setkHoverStartColor(new java.awt.Color(51, 0, 51));
        btn2User1.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn2User1.setkSelectedColor(new java.awt.Color(51, 0, 51));
        btn2User1.setkStartColor(new java.awt.Color(22, 32, 45));
        btn2User1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2User1ActionPerformed(evt);
            }
        });
        pnlUsers1.add(btn2User1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 190, 120));

        btn3User1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_full_trash_30px.png"))); // NOI18N
        btn3User1.setText("           Eliminar Usuario");
        btn3User1.setAlignmentY(0.2F);
        btn3User1.setBorderPainted(false);
        btn3User1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn3User1.setIconTextGap(15);
        btn3User1.setkBackGroundColor(new java.awt.Color(255, 255, 51));
        btn3User1.setkEndColor(new java.awt.Color(255, 0, 102));
        btn3User1.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn3User1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn3User1.setkHoverStartColor(new java.awt.Color(51, 0, 51));
        btn3User1.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn3User1.setkSelectedColor(new java.awt.Color(51, 0, 51));
        btn3User1.setkStartColor(new java.awt.Color(22, 32, 45));
        btn3User1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3User1ActionPerformed(evt);
            }
        });
        pnlUsers1.add(btn3User1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 190, 120));

        btn3User3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_search_client_30px.png"))); // NOI18N
        btn3User3.setText("           Visualizar Usuarios");
        btn3User3.setAlignmentY(0.2F);
        btn3User3.setBorderPainted(false);
        btn3User3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn3User3.setIconTextGap(15);
        btn3User3.setkBackGroundColor(new java.awt.Color(255, 255, 153));
        btn3User3.setkEndColor(new java.awt.Color(102, 0, 153));
        btn3User3.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn3User3.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn3User3.setkHoverStartColor(new java.awt.Color(51, 0, 51));
        btn3User3.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn3User3.setkSelectedColor(new java.awt.Color(51, 0, 51));
        btn3User3.setkStartColor(new java.awt.Color(22, 32, 45));
        btn3User3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3User3ActionPerformed(evt);
            }
        });
        pnlUsers1.add(btn3User3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, 190, 120));

        jPanel7.add(pnlUsers1, "card3");

        pnlInventario1.setBackground(new java.awt.Color(242, 243, 235));
        pnlInventario1.setMaximumSize(new java.awt.Dimension(820, 720));
        pnlInventario1.setMinimumSize(new java.awt.Dimension(820, 720));
        pnlInventario1.setPreferredSize(new java.awt.Dimension(980, 720));
        pnlInventario1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fdInvent.jpg"))); // NOI18N
        jLabel19.setMaximumSize(new java.awt.Dimension(350, 233));
        jLabel19.setMinimumSize(new java.awt.Dimension(350, 233));
        jLabel19.setPreferredSize(new java.awt.Dimension(350, 233));
        pnlInventario1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, 400, 300));

        jLabel21.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setText("Gestionar inventario");
        pnlInventario1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, -1));

        jPanel9.setBackground(new java.awt.Color(242, 243, 235));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSLabelFecha5.setForeground(new java.awt.Color(102, 0, 153));
        rSLabelFecha5.setFont(new java.awt.Font("Roboto Bold", 1, 24)); // NOI18N
        jPanel9.add(rSLabelFecha5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        rSLabelHora5.setForeground(new java.awt.Color(102, 0, 153));
        rSLabelHora5.setFont(new java.awt.Font("Roboto Bold", 1, 48)); // NOI18N
        jPanel9.add(rSLabelHora5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 290, 70));

        pnlInventario1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, 400, 150));

        TBInventario1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(TBInventario1);

        pnlInventario1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 352, 480, 370));

        jLabel56.setBackground(new java.awt.Color(51, 51, 51));
        jLabel56.setFont(new java.awt.Font("Segoe UI Light", 1, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(102, 0, 153));
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("Vista Previa Inventario");
        pnlInventario1.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 480, 30));

        btn5Inventario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_open_box_30px.png"))); // NOI18N
        btn5Inventario1.setText("           Nuevo Inventario");
        btn5Inventario1.setAlignmentY(0.2F);
        btn5Inventario1.setBorderPainted(false);
        btn5Inventario1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn5Inventario1.setIconTextGap(15);
        btn5Inventario1.setkBackGroundColor(new java.awt.Color(22, 32, 45));
        btn5Inventario1.setkEndColor(new java.awt.Color(102, 102, 255));
        btn5Inventario1.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn5Inventario1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn5Inventario1.setkHoverStartColor(new java.awt.Color(51, 0, 51));
        btn5Inventario1.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn5Inventario1.setkSelectedColor(new java.awt.Color(51, 0, 51));
        btn5Inventario1.setkStartColor(new java.awt.Color(22, 32, 45));
        btn5Inventario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5Inventario1ActionPerformed(evt);
            }
        });
        pnlInventario1.add(btn5Inventario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 190, 120));

        btn6Inventario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/inventory.png"))); // NOI18N
        btn6Inventario1.setText("           Modificar Inventario");
        btn6Inventario1.setAlignmentY(0.2F);
        btn6Inventario1.setBorderPainted(false);
        btn6Inventario1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn6Inventario1.setIconTextGap(5);
        btn6Inventario1.setkBackGroundColor(new java.awt.Color(51, 51, 255));
        btn6Inventario1.setkEndColor(new java.awt.Color(255, 0, 51));
        btn6Inventario1.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn6Inventario1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn6Inventario1.setkHoverStartColor(new java.awt.Color(51, 0, 51));
        btn6Inventario1.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn6Inventario1.setkSelectedColor(new java.awt.Color(51, 0, 51));
        btn6Inventario1.setkStartColor(new java.awt.Color(22, 32, 45));
        btn6Inventario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6Inventario1ActionPerformed(evt);
            }
        });
        pnlInventario1.add(btn6Inventario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 190, 120));

        btn7Inventario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_full_trash_30px.png"))); // NOI18N
        btn7Inventario1.setText("           Eliminar Inventario");
        btn7Inventario1.setAlignmentY(0.2F);
        btn7Inventario1.setBorderPainted(false);
        btn7Inventario1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn7Inventario1.setIconTextGap(15);
        btn7Inventario1.setkBackGroundColor(new java.awt.Color(255, 255, 51));
        btn7Inventario1.setkEndColor(new java.awt.Color(255, 0, 102));
        btn7Inventario1.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn7Inventario1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn7Inventario1.setkHoverStartColor(new java.awt.Color(51, 0, 51));
        btn7Inventario1.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn7Inventario1.setkSelectedColor(new java.awt.Color(51, 0, 51));
        btn7Inventario1.setkStartColor(new java.awt.Color(22, 32, 45));
        btn7Inventario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7Inventario1ActionPerformed(evt);
            }
        });
        pnlInventario1.add(btn7Inventario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 200, 120));

        btn8Inventario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ver.png"))); // NOI18N
        btn8Inventario1.setText("           Visualizar Inventario");
        btn8Inventario1.setAlignmentY(0.2F);
        btn8Inventario1.setBorderPainted(false);
        btn8Inventario1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn8Inventario1.setIconTextGap(10);
        btn8Inventario1.setkBackGroundColor(new java.awt.Color(255, 255, 153));
        btn8Inventario1.setkEndColor(new java.awt.Color(102, 0, 153));
        btn8Inventario1.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn8Inventario1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn8Inventario1.setkHoverStartColor(new java.awt.Color(51, 0, 51));
        btn8Inventario1.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn8Inventario1.setkSelectedColor(new java.awt.Color(51, 0, 51));
        btn8Inventario1.setkStartColor(new java.awt.Color(22, 32, 45));
        btn8Inventario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8Inventario1ActionPerformed(evt);
            }
        });
        pnlInventario1.add(btn8Inventario1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, 200, 120));

        jPanel7.add(pnlInventario1, "card4");

        pnlProductos1.setBackground(new java.awt.Color(245, 243, 235));
        pnlProductos1.setMaximumSize(new java.awt.Dimension(820, 720));
        pnlProductos1.setMinimumSize(new java.awt.Dimension(820, 720));
        pnlProductos1.setPreferredSize(new java.awt.Dimension(820, 720));
        pnlProductos1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(3, 18, 59));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Gestionar productos");
        pnlProductos1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 410, 60));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fproduct.jpg"))); // NOI18N
        jLabel25.setMaximumSize(new java.awt.Dimension(350, 233));
        jLabel25.setMinimumSize(new java.awt.Dimension(350, 233));
        jLabel25.setPreferredSize(new java.awt.Dimension(350, 233));
        pnlProductos1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 430, -1, 290));

        jPanel10.setBackground(new java.awt.Color(242, 243, 235));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSLabelFecha6.setForeground(new java.awt.Color(102, 0, 153));
        rSLabelFecha6.setFont(new java.awt.Font("Roboto Bold", 1, 24)); // NOI18N
        jPanel10.add(rSLabelFecha6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        rSLabelHora6.setForeground(new java.awt.Color(102, 0, 153));
        rSLabelHora6.setFont(new java.awt.Font("Roboto Bold", 1, 48)); // NOI18N
        jPanel10.add(rSLabelHora6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 290, 70));

        pnlProductos1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, 400, 150));

        jLabel57.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(102, 0, 153));
        jLabel57.setText("Productos recientes");
        pnlProductos1.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 160, 30));
        pnlProductos1.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 160, 110));

        btn12Product1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ver.png"))); // NOI18N
        btn12Product1.setText("           Visualizar Productos");
        btn12Product1.setAlignmentY(0.2F);
        btn12Product1.setBorderPainted(false);
        btn12Product1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn12Product1.setIconTextGap(5);
        btn12Product1.setkBackGroundColor(new java.awt.Color(255, 255, 153));
        btn12Product1.setkEndColor(new java.awt.Color(102, 0, 153));
        btn12Product1.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn12Product1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn12Product1.setkHoverStartColor(new java.awt.Color(51, 0, 51));
        btn12Product1.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn12Product1.setkSelectedColor(new java.awt.Color(51, 0, 51));
        btn12Product1.setkStartColor(new java.awt.Color(22, 32, 45));
        btn12Product1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn12Product1ActionPerformed(evt);
            }
        });
        pnlProductos1.add(btn12Product1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 120, 190, 120));
        pnlProductos1.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 160, 100));

        btn11Product1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_full_trash_30px.png"))); // NOI18N
        btn11Product1.setText("           Eliminar Producto");
        btn11Product1.setAlignmentY(0.2F);
        btn11Product1.setBorderPainted(false);
        btn11Product1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn11Product1.setIconTextGap(15);
        btn11Product1.setkBackGroundColor(new java.awt.Color(255, 255, 51));
        btn11Product1.setkEndColor(new java.awt.Color(255, 0, 102));
        btn11Product1.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn11Product1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn11Product1.setkHoverStartColor(new java.awt.Color(51, 0, 51));
        btn11Product1.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn11Product1.setkSelectedColor(new java.awt.Color(51, 0, 51));
        btn11Product1.setkStartColor(new java.awt.Color(22, 32, 45));
        btn11Product1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn11Product1ActionPerformed(evt);
            }
        });
        pnlProductos1.add(btn11Product1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 190, 120));

        btn10Product1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_robot_30px.png"))); // NOI18N
        btn10Product1.setText("           Modificar Producto");
        btn10Product1.setAlignmentY(0.2F);
        btn10Product1.setBorderPainted(false);
        btn10Product1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn10Product1.setIconTextGap(15);
        btn10Product1.setkBackGroundColor(new java.awt.Color(51, 51, 255));
        btn10Product1.setkEndColor(new java.awt.Color(255, 0, 51));
        btn10Product1.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn10Product1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn10Product1.setkHoverStartColor(new java.awt.Color(51, 0, 51));
        btn10Product1.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn10Product1.setkSelectedColor(new java.awt.Color(51, 0, 51));
        btn10Product1.setkStartColor(new java.awt.Color(22, 32, 45));
        btn10Product1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn10Product1ActionPerformed(evt);
            }
        });
        pnlProductos1.add(btn10Product1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 190, 120));

        TBProductos1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(TBProductos1);

        pnlProductos1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 520, 350));

        btn9Product3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_trolley_30px.png"))); // NOI18N
        btn9Product3.setText("           Nuevo Producto");
        btn9Product3.setAlignmentY(0.2F);
        btn9Product3.setBorderPainted(false);
        btn9Product3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn9Product3.setIconTextGap(15);
        btn9Product3.setkBackGroundColor(new java.awt.Color(22, 32, 45));
        btn9Product3.setkEndColor(new java.awt.Color(102, 102, 255));
        btn9Product3.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn9Product3.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn9Product3.setkHoverStartColor(new java.awt.Color(51, 0, 51));
        btn9Product3.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn9Product3.setkSelectedColor(new java.awt.Color(51, 0, 51));
        btn9Product3.setkStartColor(new java.awt.Color(22, 32, 45));
        btn9Product3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9Product3ActionPerformed(evt);
            }
        });
        pnlProductos1.add(btn9Product3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 190, 120));

        jPanel7.add(pnlProductos1, "card5");

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 980, 720));

        jPanel11.setBackground(new java.awt.Color(54, 38, 87));
        jPanel11.setPreferredSize(new java.awt.Dimension(300, 720));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo blanco.png"))); // NOI18N
        jPanel11.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 110));

        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/salida.png"))); // NOI18N
        jLabel26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel26.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel26MouseClicked(evt);
            }
        });
        jPanel11.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 692, 40, 20));

        jLabel27.setFont(new java.awt.Font("Agency FB", 1, 40)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Burnz Buttly");
        jLabel27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
        });
        jPanel11.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 170, 60));

        jSeparator3.setPreferredSize(new java.awt.Dimension(50, 5));
        jPanel11.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 160, 10));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_male_user_30px.png"))); // NOI18N
        jLabel28.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        jPanel11.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, -1));

        lblUser1.setForeground(new java.awt.Color(102, 102, 102));
        lblUser1.setText("Admin");
        jPanel11.add(lblUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 50, 20));

        btn2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_staff_30px.png"))); // NOI18N
        btn2.setText("Gestionar Usuarios");
        btn2.setBorderPainted(false);
        btn2.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        btn2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn2.setIconTextGap(16);
        btn2.setkBackGroundColor(new java.awt.Color(22, 32, 45));
        btn2.setkEndColor(new java.awt.Color(102, 102, 255));
        btn2.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn2.setkHoverStartColor(new java.awt.Color(22, 32, 45));
        btn2.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn2.setkSelectedColor(new java.awt.Color(255, 102, 153));
        btn2.setkStartColor(new java.awt.Color(54, 38, 87));
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        jPanel11.add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 280, 40));

        btn7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_handcart_30px.png"))); // NOI18N
        btn7.setText("Gestionar Inventario");
        btn7.setBorderPainted(false);
        btn7.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        btn7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn7.setIconTextGap(16);
        btn7.setkBackGroundColor(new java.awt.Color(22, 32, 45));
        btn7.setkEndColor(new java.awt.Color(102, 102, 255));
        btn7.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn7.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn7.setkHoverStartColor(new java.awt.Color(22, 32, 45));
        btn7.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn7.setkSelectedColor(new java.awt.Color(255, 102, 153));
        btn7.setkStartColor(new java.awt.Color(54, 38, 87));
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        jPanel11.add(btn7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 280, 40));

        btn8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/product.png"))); // NOI18N
        btn8.setText("Gestionar Productos");
        btn8.setBorderPainted(false);
        btn8.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        btn8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn8.setIconTextGap(16);
        btn8.setkBackGroundColor(new java.awt.Color(22, 32, 45));
        btn8.setkEndColor(new java.awt.Color(102, 102, 255));
        btn8.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn8.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn8.setkHoverStartColor(new java.awt.Color(22, 32, 45));
        btn8.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn8.setkSelectedColor(new java.awt.Color(255, 102, 153));
        btn8.setkStartColor(new java.awt.Color(54, 38, 87));
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        jPanel11.add(btn8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 280, 40));

        btn9.setText("Integracion de ordenamientos");
        btn9.setBorderPainted(false);
        btn9.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        btn9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn9.setIconTextGap(16);
        btn9.setkBackGroundColor(new java.awt.Color(22, 32, 45));
        btn9.setkEndColor(new java.awt.Color(102, 102, 255));
        btn9.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn9.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn9.setkHoverStartColor(new java.awt.Color(22, 32, 45));
        btn9.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn9.setkSelectedColor(new java.awt.Color(255, 102, 153));
        btn9.setkStartColor(new java.awt.Color(54, 38, 87));
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });
        jPanel11.add(btn9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 280, 40));

        btn10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_combo_chart_32px.png"))); // NOI18N
        btn10.setText("Ver estadisticas");
        btn10.setBorderPainted(false);
        btn10.setFont(new java.awt.Font("Agency FB", 0, 24)); // NOI18N
        btn10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btn10.setIconTextGap(16);
        btn10.setkBackGroundColor(new java.awt.Color(22, 32, 45));
        btn10.setkEndColor(new java.awt.Color(102, 102, 255));
        btn10.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn10.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn10.setkHoverStartColor(new java.awt.Color(22, 32, 45));
        btn10.setkPressedColor(new java.awt.Color(51, 0, 51));
        btn10.setkSelectedColor(new java.awt.Color(255, 102, 153));
        btn10.setkStartColor(new java.awt.Color(54, 38, 87));
        btn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn10ActionPerformed(evt);
            }
        });
        jPanel11.add(btn10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 280, 40));

        jPanel6.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 720));

        add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        int confirm = JOptionPane.showConfirmDialog(null, "¿Estas seguro de modificar tus datos?", "Modificando", JOptionPane.INFORMATION_MESSAGE);
        if (confirm == 0) {
            System.exit(0);
        }

    }//GEN-LAST:event_jLabel1MouseClicked

    private void btn1UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1UserActionPerformed
        main.irRegistrarse(this, dt);
    }//GEN-LAST:event_btn1UserActionPerformed

    private void btn2UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2UserActionPerformed
        main.irmodificarUser(this, dt);
    }//GEN-LAST:event_btn2UserActionPerformed

    private void btn3UserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3UserActionPerformed
        main.irmostrarUser(this, dt);
    }//GEN-LAST:event_btn3UserActionPerformed

    private void btn3User2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3User2ActionPerformed
        main.irmostrarUser(this, dt);
    }//GEN-LAST:event_btn3User2ActionPerformed

    private void btn5InventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5InventarioActionPerformed
        main.irInventario(this, dt);
    }//GEN-LAST:event_btn5InventarioActionPerformed

    private void btn6InventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6InventarioActionPerformed
        main.irModificarInventario(this, dt, ic);
    }//GEN-LAST:event_btn6InventarioActionPerformed

    private void btn7InventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7InventarioActionPerformed
        main.irmostrarInventario(this, dt);
    }//GEN-LAST:event_btn7InventarioActionPerformed

    private void btn8InventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8InventarioActionPerformed
        main.irmostrarInventario(this, dt);
    }//GEN-LAST:event_btn8InventarioActionPerformed

    private void btn12ProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn12ProductActionPerformed
        main.irmostrarproductos(this, dt);
    }//GEN-LAST:event_btn12ProductActionPerformed

    private void btn11ProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn11ProductActionPerformed
        main.irmostrarproductos(this, dt);
    }//GEN-LAST:event_btn11ProductActionPerformed

    private void btn10ProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn10ProductActionPerformed
        main.irModificarProduct(this, dt, pc);
    }//GEN-LAST:event_btn10ProductActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        //setColor(btn1);
        //resetColor(btn7);
        //resetColor(btn5);
        pnlUsers.setVisible(true);
        pnlInventario.setVisible(false);
        pnlPrincipal.setVisible(false);
        pnlProductos.setVisible(false);
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        pnlInventario.setVisible(true);
        pnlPrincipal.setVisible(false);
        pnlProductos.setVisible(false);
        pnlUsers.setVisible(false);
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        pnlProductos.setVisible(true);
        pnlInventario.setVisible(false);
        pnlPrincipal.setVisible(false);
        pnlUsers.setVisible(false);
    }//GEN-LAST:event_btn4ActionPerformed

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        pnlPrincipal.setVisible(true);
        pnlProductos.setVisible(false);
        pnlInventario.setVisible(false);
        pnlUsers.setVisible(false);
    }//GEN-LAST:event_jLabel20MouseClicked

    private void btn9Product2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9Product2ActionPerformed
       main.irRegistrarproducto(this, dt);
    }//GEN-LAST:event_btn9Product2ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        main.irGui();
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        pnlPrincipal.setVisible(true);
        pnlProductos.setVisible(false);
        pnlInventario.setVisible(false);
        pnlUsers.setVisible(false);
    }//GEN-LAST:event_btn6ActionPerformed

    private void txtdeportivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdeportivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdeportivoActionPerformed

    private void txtClasicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClasicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClasicoActionPerformed

    private void txtTodoterrenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTodoterrenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTodoterrenoActionPerformed

    private void txtPickupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPickupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPickupActionPerformed

    private void txtPickup1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPickup1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPickup1ActionPerformed

    private void txtTodoterreno1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTodoterreno1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTodoterreno1ActionPerformed

    private void txtClasico1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClasico1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClasico1ActionPerformed

    private void txtdeportivo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdeportivo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdeportivo1ActionPerformed

    private void btn1User1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1User1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn1User1ActionPerformed

    private void btn2User1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2User1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn2User1ActionPerformed

    private void btn3User1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3User1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn3User1ActionPerformed

    private void btn3User3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3User3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn3User3ActionPerformed

    private void btn5Inventario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5Inventario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn5Inventario1ActionPerformed

    private void btn6Inventario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6Inventario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn6Inventario1ActionPerformed

    private void btn7Inventario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7Inventario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn7Inventario1ActionPerformed

    private void btn8Inventario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8Inventario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn8Inventario1ActionPerformed

    private void btn12Product1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn12Product1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn12Product1ActionPerformed

    private void btn11Product1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn11Product1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn11Product1ActionPerformed

    private void btn10Product1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn10Product1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn10Product1ActionPerformed

    private void btn9Product3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9Product3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn9Product3ActionPerformed

    private void jLabel26MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel26MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel26MouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel27MouseClicked

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn10ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelEstadistica;
    private javax.swing.JPanel PanelEstadistica1;
    private javax.swing.JTable TBAdmin;
    private javax.swing.JTable TBAdmin1;
    private javax.swing.JTable TBInventario;
    private javax.swing.JTable TBInventario1;
    private javax.swing.JTable TBProductos;
    private javax.swing.JTable TBProductos1;
    private keeptoo.KButton btn1;
    private keeptoo.KButton btn10;
    private keeptoo.KButton btn10Product;
    private keeptoo.KButton btn10Product1;
    private keeptoo.KButton btn11Product;
    private keeptoo.KButton btn11Product1;
    private keeptoo.KButton btn12Product;
    private keeptoo.KButton btn12Product1;
    private keeptoo.KButton btn1User;
    private keeptoo.KButton btn1User1;
    private keeptoo.KButton btn2;
    private keeptoo.KButton btn2User;
    private keeptoo.KButton btn2User1;
    private keeptoo.KButton btn3;
    private keeptoo.KButton btn3User;
    private keeptoo.KButton btn3User1;
    private keeptoo.KButton btn3User2;
    private keeptoo.KButton btn3User3;
    private keeptoo.KButton btn4;
    private keeptoo.KButton btn5;
    private keeptoo.KButton btn5Inventario;
    private keeptoo.KButton btn5Inventario1;
    private keeptoo.KButton btn6;
    private keeptoo.KButton btn6Inventario;
    private keeptoo.KButton btn6Inventario1;
    private keeptoo.KButton btn7;
    private keeptoo.KButton btn7Inventario;
    private keeptoo.KButton btn7Inventario1;
    private keeptoo.KButton btn8;
    private keeptoo.KButton btn8Inventario;
    private keeptoo.KButton btn8Inventario1;
    private keeptoo.KButton btn9;
    private keeptoo.KButton btn9Product2;
    private keeptoo.KButton btn9Product3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel lblUser1;
    private javax.swing.JPanel pnlInventario;
    private javax.swing.JPanel pnlInventario1;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlPrincipal1;
    private javax.swing.JPanel pnlProductos;
    private javax.swing.JPanel pnlProductos1;
    private javax.swing.JPanel pnlUsers;
    private javax.swing.JPanel pnlUsers1;
    private javax.swing.JPanel pnliniciose1;
    private rojeru_san.RSLabelFecha rSLabelFecha1;
    private rojeru_san.RSLabelFecha rSLabelFecha2;
    private rojeru_san.RSLabelFecha rSLabelFecha3;
    private rojeru_san.RSLabelFecha rSLabelFecha4;
    private rojeru_san.RSLabelFecha rSLabelFecha5;
    private rojeru_san.RSLabelFecha rSLabelFecha6;
    private rojeru_san.RSLabelFecha rSLabelFecha7;
    private rojeru_san.RSLabelFecha rSLabelFecha8;
    private rojeru_san.RSLabelHora rSLabelHora1;
    private rojeru_san.RSLabelHora rSLabelHora2;
    private rojeru_san.RSLabelHora rSLabelHora3;
    private rojeru_san.RSLabelHora rSLabelHora4;
    private rojeru_san.RSLabelHora rSLabelHora5;
    private rojeru_san.RSLabelHora rSLabelHora6;
    private rojeru_san.RSLabelHora rSLabelHora7;
    private rojeru_san.RSLabelHora rSLabelHora8;
    private javax.swing.JTextField txtCitycar;
    private javax.swing.JTextField txtCitycar1;
    private javax.swing.JTextField txtClasico;
    private javax.swing.JTextField txtClasico1;
    private javax.swing.JTextField txtPickup;
    private javax.swing.JTextField txtPickup1;
    private javax.swing.JTextField txtTodoterreno;
    private javax.swing.JTextField txtTodoterreno1;
    private javax.swing.JTextField txtdeportivo;
    private javax.swing.JTextField txtdeportivo1;
    // End of variables declaration//GEN-END:variables
}
