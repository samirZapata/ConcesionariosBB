package view;

import controller.Listas;
import controller.userCreate;
import javax.swing.JOptionPane;
import javax.swing.event.EventListenerList;
import lib.TextPrompt;
import model.registro;

/**
 *
 * @author yonier
 */
public class modificarUser extends javax.swing.JPanel {

    registro mensajero = new registro();
    private main main;
    private userCreate dt;

    public modificarUser(main main, userCreate dt) {
        this.main = main;
        this.dt = dt;
        initComponents();
        limpiar();
    }

    /**
     * @param user
     *
     */
    private String dato;

    private void mostrarEnCampos() {

        dato = txtBuscaa.getText();
        Listas<userCreate> lista = mensajero.consultarUsuarios(dato);
        Listas l = new Listas();
        if (lista != null) {
            try {
                for (int i = 0; i < lista.size(); i++) {
                    /*
                    System.out.println("DATOS DE LA LISTA POR USUARIO CONSULTADO");
                    System.out.println("Nombre " + lista.get(i).getNombresYapellidos());
                    System.out.println("Direccion " + lista.get(i).getDireccion());
                    System.out.println("Telefono " + lista.get(i).getTelefono());
                    System.out.println("Email " + lista.get(i).getEmail());
                    System.out.println("Cedula " + String.valueOf(lista.get(i).getCedula()));
                    System.out.println("Rol " + String.valueOf(lista.get(i).getRol()));
                    System.out.println("END DATOS CONSULTADOS POR USUARIO\n\n");
                     */
                    txtNombreYapellido.setText(lista.get(i).getNombresYapellidos());
                    txtDireccion.setText(lista.get(i).getDireccion());
                    txtTelefono.setText(lista.get(i).getTelefono());
                    txtEmail.setText(lista.get(i).getEmail());
                    txtCedula.setText(String.valueOf(lista.get(i).getCedula()));
                    txtCiudad.setText(lista.get(i).getCiudad());
                    txtUser.setText(lista.get(i).getUser());
                    txtPass.setText(lista.get(i).getPass());
                    txtRol.setText(String.valueOf(lista.get(i).getRol()));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        txtUser.disable();
        txtPass.disable();
        txtCedula.disable();
    }

    private void modificarUser() {
        try {
            String NombreyApellido = txtNombreYapellido.getText();
            String direccion = txtDireccion.getText();
            String telefono = txtTelefono.getText();
            String email = txtEmail.getText();
            int cedula = Integer.parseInt(txtCedula.getText());
            String ciudad = txtCiudad.getText();
            String user = txtUser.getText();
            String pass = txtPass.getText();
            int rol = Integer.parseInt(txtRol.getText());

            int confirm = JOptionPane.showConfirmDialog(null, "¿Estas seguro de modificar tus datos?", "Modificando", JOptionPane.INFORMATION_MESSAGE);
            if (confirm == 0) {
                boolean modificar = mensajero.modificarUser(NombreyApellido, direccion, telefono, email, cedula, ciudad, user, pass, rol);
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

    /**
     * Metodo para limpiar las cajas de txt
     */
    protected final void limpiar() {
        txtNombreYapellido.setText(null);
        txtDireccion.setText(null);
        txtTelefono.setText(null);
        txtEmail.setText(null);
        txtCedula.setText(null);
        txtCiudad.setText(null);
        txtUser.setText(null);
        txtPass.setText(null);
        txtRol.setText(null);
        txtBuscaa.setText(null);

        txtNombreYapellido.enable(false);
        txtDireccion.enable(false);
        txtTelefono.enable(false);
        txtEmail.enable(false);
        txtCedula.enable(false);
        txtCiudad.enable(false);
        //txtUser.enable(false);
        txtPass.enable(false);
        txtRol.enable(false);
        //txtTipo.enable(false);
    }

    /**
     * Metodo para limpiar las cajas de txt
     */
    protected void habilitar() {

        txtNombreYapellido.enable(true);
        txtDireccion.enable(true);
        txtTelefono.enable(true);
        txtEmail.enable(true);
        //txtCedula.enable(true);
        txtCiudad.enable(true);
        //txtUser.enable(true);
        //txtPass.enable(true);
        txtRol.enable(true);
        //txtTipo.enable(true);
    }

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
        jPanel2 = new javax.swing.JPanel();
        txtNombreYapellido = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        txtCiudad = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        txtRol = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        buscaa = new keeptoo.KButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

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

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 500));

        jPanel2.setBackground(new java.awt.Color(18, 30, 49));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombreYapellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtNombreYapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 170, 20));

        txtDireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 160, 20));

        txtTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 170, 20));

        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 160, 20));

        txtCedula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 170, 20));

        txtCiudad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 160, 20));

        txtUser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 170, 20));

        txtPass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 300, 160, 20));

        txtRol.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(txtRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 60, 20));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Modificar Usuario");
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
        jLabel5.setText("Nombres y apellidos");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 153, 153));
        jLabel6.setText("Direccion");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 70, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 153, 153));
        jLabel7.setText("Telefono");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 153, 153));
        jLabel8.setText("Cedula");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 50, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("Ciudad");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, -1, -1));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 153, 153));
        jLabel10.setText("Email");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 50, -1));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 153, 153));
        jLabel11.setText("Usuario");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 153, 153));
        jLabel12.setText("Contraseña");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 100, -1));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 153, 153));
        jLabel13.setText("Rol");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 49, -1));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 0, 490, 500));
    }// </editor-fold>//GEN-END:initComponents

    private void buscaaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscaaActionPerformed
        modificarUser();

    }//GEN-LAST:event_buscaaActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        main.irmostrarUser(this, dt);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed
        mostrarEnCampos();
        habilitar();
    }//GEN-LAST:event_kButton2ActionPerformed

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        limpiar();
    }//GEN-LAST:event_deleteMouseClicked

    private void txtBuscaaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscaaKeyTyped
        //filtro();
    }//GEN-LAST:event_txtBuscaaKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KButton buscaa;
    private javax.swing.JLabel delete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
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
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCiudad;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombreYapellido;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtRol;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
