package view;

import controller.inventarioCarrosCr;
import controller.productoscreate;
import controller.userCreate;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author yonier
 */
public class main extends javax.swing.JFrame {

    private SplashCreen principal;
    private Registrarse registro;
    private login login;
    private mostrarUser mostrar;
    private userCreate dt;
    private menu menu;
    private modificarUser mod;
    private Inventario inventario;
    private mostrarInventario min;
    private Registrarproducto rp;
    private mostrarproductos mp;
    private menuUsuarios mur;
    private modificarProducto MP;
    private modificarInventario mi;
    private SplahsCreen2 sp;
    private accountRecovery ac;
    private getCodeRecovery cr;
    private resetPass rs;
    private showUser mu;
    private showProduct ps;
    private showInventory si;
    private Registrarse1 r1;
    private Inventario1 i1;
    private Registrarproducto1 p1;
    private Gui g;
    //private estadistica es;

    public main() {
        setUndecorated(true);
        setName("Principal");
        setResizable(true);
        pack();
        setIconImage(getIconImage());
        setLocationRelativeTo(null);
        iniciar(dt);
    }

    private void iniciar(userCreate dt) {
        login = new login(this, dt);
        login.setVisible(true);
        add(login);
        pack();
        setLocationRelativeTo(null);
    }

    protected void irSplashCreen(JPanel jPanel, userCreate dt) {
        remove(jPanel);
        principal = new SplashCreen(this, dt);
        principal.setVisible(true);
        add(principal);
        pack();
        setLocationRelativeTo(null);
    }

    protected void irlogin(JPanel jPanel, userCreate dt) {
        remove(jPanel);
        login = new login(this, dt);
        login.setVisible(true);
        add(login);
        pack();
        setLocationRelativeTo(null);
    }

    protected void redirectSplashCreen(JPanel jPanel, userCreate dt) {
        remove(jPanel);
        principal = new SplashCreen(this, dt);
        principal.setVisible(true);
        add(principal);
        pack();
        setLocationRelativeTo(null);
    }

    protected void irSplashCreen2(JPanel jPanel, userCreate dt) {
        remove(jPanel);
        sp = new SplahsCreen2(this, dt);
        sp.setVisible(true);
        add(sp);
        pack();
        setLocationRelativeTo(null);
    }

    protected void redirectSplashCreen2(JPanel jPanel, userCreate dt) {
        remove(jPanel);
        sp = new SplahsCreen2(this, dt);
        sp.setVisible(true);
        add(sp);
        pack();
        setLocationRelativeTo(null);
    }

    protected void irRegistrarse(JPanel jPanel, userCreate dt) {
        remove(jPanel);
        registro = new Registrarse(this, dt);
        registro.setVisible(true);
        add(registro);
        pack();
        setLocationRelativeTo(null);
        jPanel.setBackground(new Color(0, 0, 0, 0));
    }

//    protected void irlogin(JPanel jPanel, userCreate dt) {
//        remove(jPanel);
//        login = new login(this, dt);
//        login.setVisible(true);
//        add(login);
//        pack();
//        setLocationRelativeTo(null);
//    }
    protected void irmostrarUser(JPanel jPanel, userCreate dt) {
        remove(jPanel);
        mostrar = new mostrarUser(this, dt);
        mostrar.setVisible(true);
        add(mostrar);
        pack();
        setLocationRelativeTo(null);
    }

    protected void irmenu(JPanel jPanel, userCreate dt) {
        remove(jPanel);
        menu = new menu(this, dt);
        menu.setVisible(true);
        add(menu);
        pack();
        setLocationRelativeTo(null);
    }

    protected void irmodificarUser(JPanel jPanel, userCreate dt) {
        remove(jPanel);
        mod = new modificarUser(this, dt);
        mod.setVisible(true);
        add(mod);
        pack();
        setLocationRelativeTo(null);
    }

    protected void irInventario(JPanel jPanel, userCreate dt) {
        remove(jPanel);
        inventario = new Inventario(this, dt);
        inventario.setVisible(true);
        add(inventario);
        pack();
        setLocationRelativeTo(null);
    }

    protected void irmostrarInventario(JPanel jPanel, userCreate dt) {
        remove(jPanel);
        min = new mostrarInventario(this, dt);
        min.setVisible(true);
        add(min);
        pack();
        setLocationRelativeTo(null);
    }

    protected void irRegistrarproducto(JPanel jPanel, userCreate dt) {
        remove(jPanel);
        rp = new Registrarproducto(this, dt);
        rp.setVisible(true);
        add(rp);
        pack();
        setLocationRelativeTo(null);
    }

    protected void irmostrarproductos(JPanel jPanel, userCreate dt) {
        remove(jPanel);
        mp = new mostrarproductos(this, dt);
        mp.setVisible(true);
        add(mp);
        pack();
        setLocationRelativeTo(null);
    }

    protected void irmenuUsers(JPanel jPanel, userCreate dt) {
        remove(jPanel);
        mur = new menuUsuarios(this, dt);
        mur.setVisible(true);
        add(mur);
        pack();
        setLocationRelativeTo(null);
    }

    protected void irModificarProduct(JPanel jPanel, userCreate dt, productoscreate pc) {
        remove(jPanel);
        MP = new modificarProducto(this, dt, pc);
        MP.setVisible(true);
        add(MP);
        pack();
        setLocationRelativeTo(null);
    }

    protected void irModificarInventario(JPanel jPanel, userCreate dt, inventarioCarrosCr ic) {
        remove(jPanel);
        mi = new modificarInventario(this, dt, ic);
        mi.setVisible(true);
        add(mi);
        pack();
        setLocationRelativeTo(null);
    }

    protected void irAccountRecovery(JPanel jPanel, userCreate dt) {
        remove(jPanel);
        ac = new accountRecovery(this, dt);
        ac.setVisible(true);
        add(ac);
        pack();
        setLocationRelativeTo(null);
    }

    protected void irGetCodeRecovery(JPanel jPanel, userCreate dt) {
        remove(jPanel);
        cr = new getCodeRecovery(this, dt);
        cr.setVisible(true);
        add(cr);
        pack();
        setLocationRelativeTo(null);
    }

    protected void irResetPass(JPanel jPanel, userCreate dt) {
        remove(jPanel);
        rs = new resetPass(this, dt);
        rs.setVisible(true);
        add(rs);
        pack();
        setLocationRelativeTo(null);
    }

    protected void irShowUser(JPanel jPanel, userCreate dt) {
        remove(jPanel);
        mu = new showUser(this, dt);
        mu.setVisible(true);
        add(mu);
        pack();
        setLocationRelativeTo(null);
    }

    protected void irShowProduct(JPanel jPanel, userCreate dt) {
        remove(jPanel);
        ps = new showProduct(this, dt);
        ps.setVisible(true);
        add(ps);
        pack();
        setLocationRelativeTo(null);
    }

    protected void irShowInventory(JPanel jPanel, userCreate dt) {
        remove(jPanel);
        si = new showInventory(this, dt);
        si.setVisible(true);
        add(si);
        pack();
        setLocationRelativeTo(null);
    }

    protected void irRegister(JPanel jPanel, userCreate dt) {
        remove(jPanel);
        r1 = new Registrarse1(this, dt);
        r1.setVisible(true);
        add(r1);
        pack();
        setLocationRelativeTo(null);
    }

    protected void irInventario1(JPanel jPanel, userCreate dt) {
        remove(jPanel);
        i1 = new Inventario1(this, dt);
        i1.setVisible(true);
        add(i1);
        pack();
        setLocationRelativeTo(null);
    }

    protected void irProductos1(JPanel jPanel, userCreate dt) {
        remove(jPanel);
        p1 = new Registrarproducto1(this, dt);
        p1.setVisible(true);
        add(p1);
        pack();
        setLocationRelativeTo(null);
    }

    protected void irGui() {
        new Gui().setVisible(true);
//        remove(jPanel);
//        g = new Gui(this, dt);
//        g.setVisible(true);
//        add(g);
//        pack();
//        setLocationRelativeTo(null);
    }

//    protected void irEstadistica() {
//        new estadistica().setVisible(true);
////        remove(jPanel);
////        es = new estadistica(this, dt);
////        es.setVisible(true);
////        add(es);
////        pack();
////        setLocationRelativeTo(null);
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
