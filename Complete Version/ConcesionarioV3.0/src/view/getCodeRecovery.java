package view;

import controller.userCreate;
import java.util.Properties;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import lib.TextPrompt;
import model.registro;

/**
 *
 * @author samir
 */
public class getCodeRecovery extends javax.swing.JPanel {

    private main main;
    private userCreate dt;
    registro mensajero = new registro();

    public getCodeRecovery(main main, userCreate dt) {
        this.main = main;
        this.dt = dt;
        initComponents();
        lleno();
    }

    private void lleno() {
        TextPrompt codigo = new TextPrompt("  Código de recuperación", txtCode);
        lbEmail.setText(dt.getEmail());
    }

    private void sendCode() {
        String codigo = txtCode.getText();
        if (codigo.equals("")) {
            JOptionPane.showMessageDialog(null, "¡Llena todos los campos!", "Codigo de recuperacion", JOptionPane.INFORMATION_MESSAGE);
        } else {
            userCreate consulta = mensajero.codigoPass(codigo);
            if (consulta != null) {
                String codigoConsulta = consulta.getPass();
                if (codigoConsulta.equals(codigo)) {
                    JOptionPane.showMessageDialog(null, "¡El codigo es correcto!", "Codigo de recuperacion", JOptionPane.INFORMATION_MESSAGE);
                    main.irAccountRecovery(this, dt);
                }
            } else {
                JOptionPane.showMessageDialog(null, "¡El codigo es correcto!", "Codigo de recuperacion", JOptionPane.INFORMATION_MESSAGE);
                txtCode.setText(null);
            }
        }
    }

    private void reSendCode(userCreate dato) {
        try {
            String CodigoEnvio = UUID.randomUUID().toString().toUpperCase().substring(0, 8);
            Properties propiedad = new Properties();
            propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
            propiedad.setProperty("mail.smtp.starttls.enable", "true");
            propiedad.setProperty("mail.smtp.port", "587");
            propiedad.setProperty("mail.smtp.auth", "true");

            Session sesion = Session.getDefaultInstance(propiedad);
            String correoEnvia = "noreply.portalgames@gmail.com";
            String contrasena = "@portalgames@";
            String destinatario = dato.getEmail();
            String asunto = "Cuenta de Burnz Buttly - Solicitud de cambio de contraseña";
            MimeMessage mail = new MimeMessage(sesion);

            mail.setFrom(new InternetAddress(correoEnvia));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            mail.setSubject(asunto);
            String body = "<!DOCTYPE html PUBLIC font: 12px Arial, Helvetica, sans-serif;float: left;color: #666;margin-left: 10px;font-weight: bold;>\n"
                    + "<head>\n"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n"
                    + "    <title>Burnz Buttly</title>\n"
                    + "   <style type=\"text/css\"></style>\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "   <table width=\"538\" border=\"0\" align=\"center\" cellspacing=\"0\" bgcolor=\"#17212E\" style=\"padding-left:5px;padding-right:5px;\">\n"
                    + "       <tr>\n"
                    + "       	<td bgcolor=\"#171a21\">\n"
                    + "                <center><img src=\"https://lh3.googleusercontent.com/O6Vi8H9gXzM2CKBlZyuoZFRZpIsboehCYJRV7T1BFlCKaeo5_Ay556odJpE-_OU112yV6WEq2hUdndWW-qfX-R3eqbFrWbtM1JbuIgLrFqSoxfZ0jWx327aPr8IZ0RhPav-SVJwHstVffimCES5tmOeNg3YF-y7DcgwB9UsMJItDciC-f2fIUNdLEAxrmFdUGoena9VEuYwEFctuw8zsKL6CDK1v8MINJoE_iwhz5q-aX6cig1ZnvngTki-i-T1MUecaKI5BmvSErdk2J6a9u8Vb4u9U6f2DtdygC9r57iG0gk3LblMaFf4tmAga3XnGcjh2rCFR7Ts53ykZTx7Q1phsHa9USY3sd7IrixfiidIzWYahUB82aJu0vXU0AHG89qqOaUtMndsXoto2soPpTtqAwhXdQRK0DC9PywVvUppIET0yKifv2Atk4f6GOpdlkInmgbG4PjZdehb3LEg-Jw5ZJgYiiffHS0TwHp1EHgUsdJnQ9FQJ-FdP-E4vqpSGhd-9e1qIobCob0OeX17eoFK6cfc3Lh53l82QYB1rwfbYPpLCXt0kHeAc_YzwoLjuK9b6GtG1sS8IydcMIymvRUaY01_WGU8_IYhW0VNDuPrsTGqAS87tZ_BeALS0u0Z2s1gr1cXTsItbkb-_twjxGbo57r2XCmWnNCBMv0EfPIl0Rm1lRTUs78k=w130-h171-no\"/></center>\n"
                    + "       	</td>\n"
                    + "            \n"
                    + "        </tr>\n"
                    + "        <tr>\n"
                    + "        	<td>\n"
                    + "                <table  border=\"0\" cellspacing=\"0\" width=\"495\" style=\"float: left;margin-left: 21px;\">\n"
                    + "                    <tr>\n"
                    + "                    <td> <label style=\"padding-top:16px;padding-bottom:16px;font-size:24px;color:#66c0f4;font-family:Arial,Helvetica,sans-serif;font-weight:bold\">Hola, {NICKNAME} </label></td><br>\n"
                    + "                    </tr>\n"
                    + "                    <td> <label style=\"padding-top:16px;padding-bottom:16px;font-size:24px;color:#66c0f4;font-family:Arial,Helvetica,sans-serif;font-weight:bold\"></label></td>\n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                    <td> <label style=\"font-size:17px;color: #c6d4df;font-family:Arial,Helvetica,sans-serif;font-weight:bold;\">Este es el código de Burnz Buttly que necesitas para iniciar sesión en tu cuenta {NICKNAME}: </label></td>\n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                    <td> <label style=\"padding-top:16px;padding-bottom:16px;font-size:24px;color:#66c0f4;font-family:Arial,Helvetica,sans-serif;font-weight:bold\"> {CODIGO} </label></td>\n"
                    + "                    </tr>\n"
                    + "                 <tr bgcolor=\"#121a25\">\n"
                    + "                 <td style=\"padding:20px;font-size:12px;line-height:17px;color:#c6d4df;font-family:Arial,Helvetica,sans-serif\"> \n"
                    + "                	<p style=\"padding-bottom:10px;color:#c6d4df;\">Este email se ha generado debido a un intento de inicio sesión desde un equipo   .</a> El intento de inicio de sesión incluía tu nombre de cuenta y <span class='il'>contraseña</span> correctos.</p>\n"
                    + "                	<p style=\"padding-bottom:10px;color:#c6d4df;\">Se necesita el código generado por Burnz Buttly para completar el inicio de sesión. Nadie puede acceder a tu cuenta sin acceder también a este email. </p>\n"
                    + "                	<p style=\"padding-top:10px;color:#61696d;\">Si no puedes acceder a tu cuenta mediante este código contacta con los administradores de Burnz Buttly.</p> \n"
                    + "                </td> \n"
                    + "                 </tr> \n"
                    + "                   <tr>\n"
                    + "                          <td><center> <label style=\"color:gray; font-size: 12px;\"><br>Los datos adicionales de registro los puedes encontrar en los ajustes de tu cuenta.</label><br><br><center></td>\n"
                    + "                   </tr>\n"
                    + "           </td>\n"
                    + "        </tr>\n"
                    + "         <table width=\"538\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#17212E\">\n"
                    + "       <tr align=\"center\">\n"
                    + "           <td align=\"center\" width=\"200\" height=\"35\" style=\"background: #000000; font-family: helvetica; font-size: 11px; color: #fff; margin-top: 64px; max:550px; \">\n"
                    + "               © 2019 Burnz Buttly - All rights reserved.\n"
                    + "           </td>\n"
                    + "       </tr>\n"
                    + "    </table>\n"
                    + "  </table>\n"
                    + " </body>\n"
                    + " </html>"
                    + "";
            body = body.replace("{User}", dato.getUser());
            body = body.replace("{CODIGO}", CodigoEnvio);
            mail.setContent(body, "text/html");

            Transport transporte = sesion.getTransport("smtp");
            transporte.connect(correoEnvia, contrasena);
            transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transporte.close();

            boolean modify = mensajero.modifyPass(dato, CodigoEnvio);
            if (modify == true) {
                JOptionPane.showMessageDialog(null, "¡Tu código ha sido reenviado!", "Reenviando codigo", JOptionPane.INFORMATION_MESSAGE);
                txtCode.setText(null);
            } else {
                JOptionPane.showMessageDialog(null, "¡Contraseña modificada!", "Modify", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (AddressException ex) {
            java.util.logging.Logger.getLogger(getCodeRecovery.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("OTRA PISTA!...\n");
            Logger.getLogger(getCodeRecovery.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            java.util.logging.Logger.getLogger(getCodeRecovery.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanelTransparente1 = new LIB.JPanelTransparente();
        kButton1 = new keeptoo.KButton();
        jLabel1 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        lbEmail = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        reSend = new javax.swing.JLabel();

        setBackground(new java.awt.Color(27, 40, 56));

        jPanelTransparente1.setBackground(new java.awt.Color(22, 32, 45));
        jPanelTransparente1.setColorPrimario(new java.awt.Color(22, 32, 45));
        jPanelTransparente1.setColorSecundario(new java.awt.Color(22, 32, 45));
        jPanelTransparente1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kButton1.setText("Enviar");
        kButton1.setBorderPainted(false);
        kButton1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        kButton1.setkBackGroundColor(new java.awt.Color(22, 32, 45));
        kButton1.setkEndColor(new java.awt.Color(102, 102, 255));
        kButton1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton1.setkHoverStartColor(new java.awt.Color(255, 0, 102));
        kButton1.setkStartColor(new java.awt.Color(22, 32, 45));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });
        jPanelTransparente1.add(kButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, -1, -1));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei", 1, 14)); // NOI18N
        jLabel1.setText("Por favor ingresa el codigo que enviamos a:");
        jPanelTransparente1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        txtCode.setBackground(new java.awt.Color(22, 32, 45));
        txtCode.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        txtCode.setForeground(new java.awt.Color(255, 255, 255));
        txtCode.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 255)));
        jPanelTransparente1.add(txtCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 480, 40));

        lbEmail.setForeground(new java.awt.Color(102, 192, 244));
        jPanelTransparente1.add(lbEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 230, 30));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("¿Aun no lo recibes?");
        jPanelTransparente1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 170, 530, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_back_16px.png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelTransparente1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        reSend.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        reSend.setForeground(new java.awt.Color(102, 192, 244));
        reSend.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reSend.setText("Reenviamelo");
        reSend.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        reSend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reSendMouseClicked(evt);
            }
        });
        jPanelTransparente1.add(reSend, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 540, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanelTransparente1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanelTransparente1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
       sendCode();
    }//GEN-LAST:event_kButton1ActionPerformed

    private void reSendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reSendMouseClicked
        reSendCode(this.dt);
    }//GEN-LAST:event_reSendMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private LIB.JPanelTransparente jPanelTransparente1;
    private keeptoo.KButton kButton1;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel reSend;
    private javax.swing.JTextField txtCode;
    // End of variables declaration//GEN-END:variables
}
