package view;

import controller.Listas;
import controller.userCreate;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import lib.TextPrompt;
import model.registro;
//import Utilidades.TextPrompt;

/**
 *
 * @author yonier
 */
public final class mostrarUser extends javax.swing.JPanel {

    private final main main;
    registro r = new registro();
    private final userCreate dt;
    
    registro mensajero = new registro();
    DefaultTableModel model = new DefaultTableModel();
    TableRowSorter trs; // Clasificar las filas de una tabla

    public mostrarUser(main main, userCreate dt) {
        this.main = main;
        this.dt = dt;
        initComponents();
        mostrar();
    }

    private void filtro() {
        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtSearch.getText(), 6));
            }
        });
        trs = new TableRowSorter(model);
        tabla.setRowSorter(trs);
    }

    //Metodo para mostrar los usuarios a la tabla
    private void mostrar() {
        String datoss = txtSearch.getText();
        this.model.addColumn("Nombre Y apellido");
        this.model.addColumn("Direccion");
        this.model.addColumn("Telefono");
        this.model.addColumn("Email");
        this.model.addColumn("Cedula");
        this.model.addColumn("Ciudad");
        this.model.addColumn("Usuario");
        this.model.addColumn("Contraseña");
        this.model.addColumn("Rol");
        tabla.setModel(model);
        Listas<userCreate> dato = mensajero.mostrar();
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
                    lblTamanio.setText(String.valueOf(i));
                    model.addRow(filas);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al consultar los datos!!");
                e.printStackTrace();
                e.getLocalizedMessage();
            }
        }

    }

    private void borrar() {
        try {
            String dato = txtSearch.getText();

            Listas<userCreate> borrar = mensajero.eliminarUser(dato);
            if (borrar != null) {
                int i = 0;
                for (; i < borrar.size(); i--) {
                    borrar.remove(i).getNombresYapellidos();
                    borrar.remove(i).getDireccion();
                    borrar.remove(i).getTelefono();
                    borrar.remove(i).getEmail();
                    borrar.remove(i).getCedula();
                    borrar.remove(i).getCiudad();
                    borrar.remove(i).getUser();
                    borrar.remove(i).getPass();
                    borrar.remove(i).getRol();

                    lblTamanio.setText(String.valueOf(i));

                    System.out.println("DATOS BORRADOS!");
                    System.out.println(borrar.remove(i).getNombresYapellidos());
                    System.out.println(borrar.remove(i).getDireccion());
                    System.out.println(borrar.remove(i).getTelefono());
                    System.out.println(borrar.get(i).getEmail());
                    System.out.println(borrar.get(i).getCedula());
                }

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error inesperado, estamos trabajando en ello!", "Error", JOptionPane.ERROR_MESSAGE);
            //System.out.println("Este error es de la vista " + ex.getMessage() + "  \n" + ex.getLocalizedMessage());
        }
    }

    void setColor(JPanel panel) {
        panel.setBackground(new Color(86, 70, 117));
    }

    void resetColor(JPanel panel) {
        panel.setBackground(new Color(65, 48, 100));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new LIB.FSTexFieldMD();
        lblTamanio = new javax.swing.JLabel();
        btn_eliminar = new keeptoo.KButton();
        btn_modificar = new keeptoo.KButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(54, 38, 87));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_back_16px.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtSearch.setBackground(new java.awt.Color(54, 38, 87));
        txtSearch.setForeground(new java.awt.Color(255, 255, 255));
        txtSearch.setBordeColorNoFocus(new java.awt.Color(153, 153, 255));
        txtSearch.setMaterialDesing(true);
        txtSearch.setPlaceholder("Buscar y eliminar");
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchKeyTyped(evt);
            }
        });
        jPanel1.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 150, -1));

        lblTamanio.setBackground(new java.awt.Color(54, 38, 87));
        lblTamanio.setFont(new java.awt.Font("DejaVu Serif", 0, 10)); // NOI18N
        lblTamanio.setForeground(new java.awt.Color(102, 102, 102));
        jPanel1.add(lblTamanio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 450, 20, 20));

        btn_eliminar.setText("Eliminar");
        btn_eliminar.setBorderPainted(false);
        btn_eliminar.setkBackGroundColor(new java.awt.Color(51, 51, 255));
        btn_eliminar.setkEndColor(new java.awt.Color(51, 153, 255));
        btn_eliminar.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn_eliminar.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_eliminar.setkHoverStartColor(new java.awt.Color(54, 38, 87));
        btn_eliminar.setkSelectedColor(new java.awt.Color(255, 102, 153));
        btn_eliminar.setkStartColor(new java.awt.Color(54, 38, 87));
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 170, 40));

        btn_modificar.setBackground(new java.awt.Color(86, 70, 117));
        btn_modificar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(54, 38, 87)));
        btn_modificar.setText("Modificar");
        btn_modificar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btn_modificar.setkBackGroundColor(new java.awt.Color(51, 51, 255));
        btn_modificar.setkEndColor(new java.awt.Color(51, 153, 255));
        btn_modificar.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        btn_modificar.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        btn_modificar.setkHoverStartColor(new java.awt.Color(54, 38, 87));
        btn_modificar.setkSelectedColor(new java.awt.Color(255, 102, 153));
        btn_modificar.setkStartColor(new java.awt.Color(54, 38, 87));
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 200, -1));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_database_backup_30px_1.png"))); // NOI18N
        jLabel3.setText(" Actualizar");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        jLabel4.setBackground(new java.awt.Color(54, 38, 87));
        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Eliminar por usuario");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.S_RESIZE_CURSOR));
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 190, -1));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sinFD.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 190, 100));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Burnz Buttly");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 190, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 140, 10));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 480));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabla);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 830, 480));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        main.irmenu(this, dt);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        filtro();
    }//GEN-LAST:event_txtSearchKeyTyped

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed

        borrar();
        //model.fireTableDataChanged();
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        main.irmodificarUser(this, dt);
    }//GEN-LAST:event_btn_modificarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KButton btn_eliminar;
    private keeptoo.KButton btn_modificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblTamanio;
    private javax.swing.JTable tabla;
    private LIB.FSTexFieldMD txtSearch;
    // End of variables declaration//GEN-END:variables
}
