package view;

import controller.Cola;
import controller.productoscreate;
import controller.userCreate;
import javax.swing.JOptionPane;
import model.registro;

/**
 *
 * @author samir
 */
public class modificarProducto extends javax.swing.JPanel {

    registro r;
    private main main;
    private userCreate dt;
    private productoscreate pc;

    public modificarProducto(main main, userCreate dt, productoscreate pc) {
        this.main = main;
        this.dt = dt;
        r = new registro();
        initComponents();
    }

    private String dato;

    private void mostrarDatos() {

        dato = txtBuscaa.getText();
        Cola<productoscreate> cola = r.consultarProduct(dato);
        Cola c = new Cola();
        try {
            for (int i = 0; i < cola.size(); i++) {
                txtRef.setText(String.valueOf(cola.obtener(i).getReferencia()));
                txtNombre.setText(cola.obtener(i).getNombre());
                txtMarca.setText(cola.obtener(i).getMarca());
                txtTipoProd.setText(cola.obtener(i).getTipoprod());
                txtAplicacion.setText(cola.obtener(i).getAplicacion());
                txtCantidad.setText(String.valueOf(cola.obtener(i).getCantidadprod()));
                txtPrecio.setText(String.valueOf(cola.obtener(i).getPrecio()));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Datos erroneos con exito!", "Modificados!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void modificarProduct() {
        try {

            int ref = Integer.parseInt(txtRef.getText());
            String nombre = txtNombre.getText();
            String marca = txtMarca.getText();
            String tipo = txtTipoProd.getText();
            String aplicacion = txtAplicacion.getText();
            int cantidad = Integer.parseInt(txtCantidad.getText());
            double precio = Double.parseDouble(txtPrecio.getText());

            int confirm = JOptionPane.showConfirmDialog(null, "¿Estas seguro de modificar tus datos?", "Modificando", JOptionPane.INFORMATION_MESSAGE);
            if (confirm == 0) {
                boolean modify = r.modificarproduct(ref, nombre, marca, tipo, aplicacion, cantidad, precio);
                if (modify != false) {
                    JOptionPane.showMessageDialog(null, "¡Datos modificados con exito!", "Modificados!", JOptionPane.INFORMATION_MESSAGE);
                    limpiar();
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar los datos, estamos trabajando el ello...!", "¡Error de la vista!", JOptionPane.ERROR_MESSAGE);
            System.out.println("Error desde la vista!  " + e.getMessage());
        }
    }

    private void limpiar() {
        txtRef.setText(null);
        txtNombre.setText(null);
        txtMarca.setText(null);
        txtTipoProd.setText(null);
        txtAplicacion.setText(null);
        txtCantidad.setText(null);
        txtPrecio.setText(null);

        txtRef.enable(false);
        txtNombre.enable(false);
        txtMarca.enable(false);
        txtTipoProd.enable(false);
        txtAplicacion.enable(false);
        txtCantidad.enable(false);
        txtPrecio.enable(false);
    }

    private void habilitar() {
        txtRef.enable(true);
        txtNombre.enable(true);
        txtMarca.enable(true);
        txtTipoProd.enable(true);
        txtAplicacion.enable(true);
        //txtCantidad.enable(true);
        //txtPrecio.enable(true);
    }

    ;
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        delete = new javax.swing.JLabel();
        kButton2 = new keeptoo.KButton();
        txtBuscaa = new LIB.FSTexFieldMD();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtRef = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        txtTipoProd = new javax.swing.JTextField();
        txtAplicacion = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        buscaa = new keeptoo.KButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(677, 497));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jLabel4.setText("Buscar por referencia");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.S_RESIZE_CURSOR));
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 190, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 500));

        jPanel2.setBackground(new java.awt.Color(18, 30, 49));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtRef.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtRef, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 170, 20));

        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 160, 20));

        txtMarca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 170, 20));

        txtTipoProd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtTipoProd, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 160, 20));

        txtAplicacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtAplicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 170, 40));

        txtCantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 160, 20));

        txtPrecio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 170, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Modificar Producto");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 20, 466, -1));

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
        jLabel5.setText("Referencia");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Nombre");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 70, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Marca");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Aplicacion");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 70, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("Cantidad");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("Tipo producto");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 90, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("Precio");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 0, 490, 500));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        main.irmostrarproductos(this, dt);
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

    private void buscaaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaaActionPerformed
        modificarProduct();
    }//GEN-LAST:event_buscaaActionPerformed


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
    private javax.swing.JTextField txtAplicacion;
    private LIB.FSTexFieldMD txtBuscaa;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtRef;
    private javax.swing.JTextField txtTipoProd;
    // End of variables declaration//GEN-END:variables
}