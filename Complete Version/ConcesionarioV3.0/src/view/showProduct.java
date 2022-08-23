package view;

import controller.Cola;
import controller.productoscreate;
import controller.userCreate;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.registro;

/**
 *
 * @author samir
 */
public class showProduct extends javax.swing.JPanel {

    private main main;
    private userCreate dt;
    DefaultTableModel model = new DefaultTableModel();
    TableRowSorter trs; // Clasificar las filas de una tabla
    registro r = new registro();

    public showProduct(main main, userCreate dt) {
        this.main = main;
        this.dt = dt;
        initComponents();
        mostrar();
    }

    private void mostrar() {
        this.model.addColumn("Referencia");
        this.model.addColumn("Nombre");
        this.model.addColumn("Marca");
        this.model.addColumn("Tipo producto");
        this.model.addColumn("APlicación");
        this.model.addColumn("Cantidad");
        this.model.addColumn("Precio");
        //this.model.addColumn("Imagen");
        tablaInventario.setModel(model);
        //Creo el objeto de tipo inventarioCarrosCr
        Cola<productoscreate> datos = r.mostrarproducto();

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
                    model.addRow(filas);
                    lblTamanio.setText(String.valueOf(datos.obtener(i)));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al consultar los datos!!");
                e.printStackTrace();
                e.getLocalizedMessage();
            }
        }
    }

    private void filtro() {
        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ke) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtSearch.getText(), 0));
            }
        });
        trs = new TableRowSorter(model);
        tablaInventario.setRowSorter(trs);
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
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new LIB.FSTexFieldMD();
        jLabel4 = new javax.swing.JLabel();
        lblTamanio = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaInventario = new javax.swing.JTable();

        jPanel2.setBackground(new java.awt.Color(54, 38, 87));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_back_16px.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

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
        jPanel2.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 150, -1));

        jLabel4.setBackground(new java.awt.Color(54, 38, 87));
        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Eliminar por referencia");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.S_RESIZE_CURSOR));
        jLabel4.setOpaque(true);
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 200, -1));

        lblTamanio.setForeground(new java.awt.Color(102, 102, 102));
        jPanel2.add(lblTamanio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 20, 20));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/sinFD.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 190, 100));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Burnz Buttly");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 190, -1));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 140, 10));

        tablaInventario.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(tablaInventario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1090, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        main.irmenuUsers(this, dt);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txtSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyTyped
        filtro();
    }//GEN-LAST:event_txtSearchKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblTamanio;
    private javax.swing.JTable tablaInventario;
    private LIB.FSTexFieldMD txtSearch;
    // End of variables declaration//GEN-END:variables
}
