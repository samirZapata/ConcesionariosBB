package view;

import controller.Cola;
import controller.Pila;
import controller.inventarioCarrosCr;
import controller.productoscreate;
import controller.userCreate;
import javax.swing.JOptionPane;
import model.registro;

/**
 *
 * @author samir
 */
public class modificarInventario extends javax.swing.JPanel {

    private main main;
    private userCreate dt;
    private inventarioCarrosCr ic;
    registro r;

    public modificarInventario(main main, userCreate dt, inventarioCarrosCr ic) {
        this.main = main;
        this.dt = dt;
        this.ic = ic;
        initComponents();
        r = new registro();
    }

    private String dato;

    private void mostrarDatos() {

        dato = txtBuscaa.getText();
        Pila<inventarioCarrosCr> pila = r.consultarInventario(dato);
        try {
            for (int i = 0; i < pila.size(); i++) {
                txtPlaca.setText(pila.get(i).getPlaca());
                txtModelo.setText(pila.get(i).getModelo());
                txtColor.setText(pila.get(i).getColor());
                txtMotor.setText(pila.get(i).getNoMotor());
                txtCiudad.setText(pila.get(i).getCiudad());
                txtMarca.setText(pila.get(i).getMarca());
                txtTipo.setText(pila.get(i).getTipoc());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Datos erroneos con exito!", "Modificados!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void modificarInventario() {
        try {
            String placa = txtPlaca.getText();
            String modelo = txtModelo.getText();
            String color = txtColor.getText();
            String motor = txtMotor.getText();
            String ciudad = txtCiudad.getText();
            String marca = txtMarca.getText();
            String tipo = txtTipo.getText();

            int confirm = JOptionPane.showConfirmDialog(null, "¿Estas seguro de modificar tus datos?", "Modificando", JOptionPane.INFORMATION_MESSAGE);
            if (confirm == 0) {
                boolean modificar = r.modificarInventario(placa, modelo, color, motor, ciudad, marca, tipo);
                if (modificar != false) {
                    JOptionPane.showMessageDialog(null, "¡Datos modificados con exito!", "Modificados!", JOptionPane.INFORMATION_MESSAGE);
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Actualizar los datos, estamos trabajando el ello...!", "¡Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Error desde la vista!  " + e.getMessage());
        }
    }

    private void limpiar() {
        txtPlaca.setText(null);
        txtModelo.setText(null);
        txtColor.setText(null);
        txtMotor.setText(null);
        txtCiudad.setText(null);
        txtMarca.setText(null);
        txtTipo.setText(null);

        txtPlaca.enable(false);
        txtModelo.enable(false);
        txtColor.enable(false);
        txtMotor.enable(false);
        txtCiudad.enable(false);
        txtMarca.enable(false);
        txtTipo.enable(false);
    }

    private void habilitar() {
        txtPlaca.enable(true);
        txtModelo.enable(true);
        txtColor.enable(true);
        txtMotor.enable(true);
        txtCiudad.enable(true);
        //txtCantidad.enable(true);
        //txtPrecio.enable(true);
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
        txtPlaca = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        txtMotor = new javax.swing.JTextField();
        txtCiudad = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtTipo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        buscaa = new keeptoo.KButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        delete = new javax.swing.JLabel();
        kButton2 = new keeptoo.KButton();
        txtBuscaa = new LIB.FSTexFieldMD();
        jLabel4 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(18, 30, 49));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtPlaca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtPlaca, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 170, 20));

        txtModelo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtModelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 160, 20));

        txtColor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 170, 20));

        txtMotor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtMotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 160, 20));

        txtCiudad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 170, 20));

        txtMarca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 160, 20));

        txtTipo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 170, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Modificar Inventario");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 20, 520, -1));

        buscaa.setText("Aceptar");
        buscaa.setBorderPainted(false);
        buscaa.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        buscaa.setkBackGroundColor(new java.awt.Color(51, 51, 255));
        buscaa.setkEndColor(new java.awt.Color(51, 153, 255));
        buscaa.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        buscaa.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        buscaa.setkHoverStartColor(new java.awt.Color(54, 38, 87));
        buscaa.setkSelectedColor(new java.awt.Color(255, 102, 153));
        buscaa.setkStartColor(new java.awt.Color(54, 38, 87));
        buscaa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscaaActionPerformed(evt);
            }
        });
        jPanel2.add(buscaa, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 410, 149, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("Placa");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Modelo");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 70, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Color");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Ciudad");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 70, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("Marca");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("N° Motor");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 90, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("Tipo");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 0, 480, 500));

        jPanel1.setBackground(new java.awt.Color(54, 38, 87));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Burnz Buttly");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, 77, 190, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 107, 130, 10));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_back_16px.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, -1, -1));

        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delet.png"))); // NOI18N
        delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });
        jPanel1.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, -1, 30));

        kButton2.setText("Buscar");
        kButton2.setBorderPainted(false);
        kButton2.setkBackGroundColor(new java.awt.Color(51, 51, 255));
        kButton2.setkEndColor(new java.awt.Color(51, 153, 255));
        kButton2.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        kButton2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton2.setkHoverStartColor(new java.awt.Color(54, 38, 87));
        kButton2.setkSelectedColor(new java.awt.Color(255, 102, 153));
        kButton2.setkStartColor(new java.awt.Color(54, 38, 87));
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(kButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 230, 149, -1));

        txtBuscaa.setBackground(new java.awt.Color(54, 38, 87));
        txtBuscaa.setForeground(new java.awt.Color(255, 255, 255));
        txtBuscaa.setBordeColorNoFocus(new java.awt.Color(153, 153, 255));
        txtBuscaa.setMaterialDesing(true);
        txtBuscaa.setPlaceholder("Buscar");
        txtBuscaa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscaaKeyTyped(evt);
            }
        });
        jPanel1.add(txtBuscaa, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 110, -1));

        jLabel4.setBackground(new java.awt.Color(54, 38, 87));
        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Buscar por placa");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.S_RESIZE_CURSOR));
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 190, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 500));
    }// </editor-fold>//GEN-END:initComponents

    private void buscaaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaaActionPerformed
        modificarInventario();
    }//GEN-LAST:event_buscaaActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        main.irmostrarInventario(this, dt);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        limpiar();
    }//GEN-LAST:event_deleteMouseClicked

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        mostrarDatos();
        habilitar();
    }//GEN-LAST:event_kButton2ActionPerformed

    private void txtBuscaaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaaKeyTyped
        //filtro();
    }//GEN-LAST:event_txtBuscaaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KButton buscaa;
    private javax.swing.JLabel delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private keeptoo.KButton kButton2;
    private LIB.FSTexFieldMD txtBuscaa;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtMotor;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtTipo;
    // End of variables declaration//GEN-END:variables
}
