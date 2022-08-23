package view;

import controller.userCreate;
import java.awt.HeadlessException;
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
import model.registro;

/**
 *
 * @author samir
 */
public class resetPass extends javax.swing.JPanel {

    private main main;
    private userCreate dt;
    registro mensajero = new registro();

    public resetPass(main main, userCreate dt) {
        this.main = main;
        this.dt = dt;
        initComponents();
    }

    private void verifyEmail() {
        try {
            int result = JOptionPane.showConfirmDialog(null, "¿Estas seguro de enviar la solicidud? Recuerda que si lo haces se cambiará tu contraseña", "¡Cambiando Contraseña!", JOptionPane.YES_NO_OPTION);
            String email = txtEmail.getText();
            if (result == 0) {
                //Validar campos vacios
                if (email.equals("")) {
                    JOptionPane.showMessageDialog(null, "¡Completa todos los capos!", "Intenta de nuevo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    //Mando el email para la busqueda
                    userCreate validar = mensajero.verificarEmail(email);
                    if (validar != null) {
                        //Recupero email para enviar el correo
                        recoveryEmail(validar);
                    } else {
                        JOptionPane.showMessageDialog(null, "¡Correo invalido!", "Recuperar contraseña", JOptionPane.INFORMATION_MESSAGE);
                        txtEmail.setText(null);
                    }
                }
            }
        } catch (HeadlessException | MessagingException e) {
            JOptionPane.showMessageDialog(null, "¡Error, estamos trabajando en ello!", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getLocalizedMessage());
        }
    }

    private void recoveryEmail(userCreate dato) throws MessagingException {
        String CodigoEnvio = UUID.randomUUID().toString().toUpperCase().substring(0, 8);
        Properties propiedad = new Properties();
        propiedad.setProperty("mail.smtp.host", "smtp.gmail.com");
        propiedad.setProperty("mail.smtp.starttls.enable", "true");
        propiedad.setProperty("mail.smtp.port", "25");//puerto utilizado si desea enviar mensajes utilizando SMTP de forma segura
        propiedad.setProperty("mail.smtp.auth", "true");

        Session sesion = Session.getDefaultInstance(propiedad);
        String sendEmail = "noreply.portalgames@gmail.com";
        String password = "@portalgames@";
        String destinatario = txtEmail.getText();
        String asunto = "Cambio contraseña Burnz Buttly Concecionaro";
        MimeMessage mail = new MimeMessage(sesion);

        try {
            mail.setFrom(new InternetAddress(sendEmail));
            mail.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
            mail.setSubject(asunto);
            String body = "<!DOCTYPE html PUBLIC font: 12px Arial, Helvetica, sans-serif;float: left;color: #666;margin-left: 10px;font-weight: bold;>\n"
                    + "<head>\n"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n"
                    + "    <title>Burnz-Buttly</title>\n"
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
                    + "                    <td> <label style=\"font-size:17px;color: #c6d4df;font-family:Arial,Helvetica,sans-serif;font-weight:bold;\">Este es el código de Burnz Buttly que necesitas para iniciar sesión en tu cuenta {Usuario}: </label></td>\n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                    <td> <label style=\"padding-top:16px;padding-bottom:16px;font-size:24px;color:#66c0f4;font-family:Arial,Helvetica,sans-serif;font-weight:bold\"> {CODIGO} </label></td>\n"
                    + "                    </tr>\n"
                    + "                 <tr bgcolor=\"#121a25\">\n"
                    + "                 <td style=\"padding:20px;font-size:12px;line-height:17px;color:#c6d4df;font-family:Arial,Helvetica,sans-serif\"> \n"
                    + "                	<p style=\"padding-bottom:10px;color:#c6d4df;\">Este email se ha generado debido a un intento de inicio sesión desde un equipo   .</a> El intento de inicio de sesión incluía tu nombre de cuenta y <span class='il'>Contraseña</span> correctos.</p>\n"
                    + "                	<p style=\"padding-bottom:10px;color:#c6d4df;\">Se necesita el código generado por Burnz-Buttly para completar el inicio de sesión. Nadie puede acceder a tu cuenta sin acceder también a este email. </p>\n"
                    + "                	<p style=\"padding-top:10px;color:#61696d;\">Si no puedes acceder a tu cuenta mediante este código contacta con los administradores de Burnz-Buttly.</p> \n"
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
                    + "               © 2019 Burnz-Buttly - All rights reserved.\n"
                    + "           </td>\n"
                    + "       </tr>\n"
                    + "    </table>\n"
                    + "  </table>\n"
                    + " </body>\n"
                    + " </html>"
                    + "";
            body = body.replace("{Usuario}", dato.getUser());
            body = body.replace("{CODIGO}", CodigoEnvio);
            mail.setContent(body, "text/html");
            Transport transporte = sesion.getTransport("smtp");
            transporte.connect(sendEmail, password);
            transporte.sendMessage(mail, mail.getRecipients(Message.RecipientType.TO));
            transporte.close();
            boolean modify = mensajero.recuperarPass(dato, CodigoEnvio);
            if (modify == true) {
                JOptionPane.showMessageDialog(null, "¡Se ha enviado un correo al email escrito!", "Recuperar contraseña", JOptionPane.INFORMATION_MESSAGE);
                //txtEmail.setText(null);
                main.irGetCodeRecovery(this, dt);
            } else {
                JOptionPane.showMessageDialog(null, "¡Contraseña no modificada!", "Recuperar contraseña", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (AddressException e) {
            java.util.logging.Logger.getLogger(resetPass.class.getName()).log(Level.SEVERE, null, e);
        } catch (MessagingException e) {
            java.util.logging.Logger.getLogger(resetPass.class.getName()).log(Level.SEVERE, null, e);
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
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        txtEmail = new javax.swing.JTextField();
        kButton1 = new keeptoo.KButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(27, 40, 56));

        jPanelTransparente1.setBackground(new java.awt.Color(22, 32, 45));
        jPanelTransparente1.setColorPrimario(new java.awt.Color(22, 32, 45));
        jPanelTransparente1.setColorSecundario(new java.awt.Color(22, 32, 45));
        jPanelTransparente1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_forgot_password_100px.png"))); // NOI18N
        jPanelTransparente1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 100));

        jSeparator1.setBackground(new java.awt.Color(255, 51, 51));
        jPanelTransparente1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 180, 10));

        jSeparator2.setBackground(new java.awt.Color(102, 102, 255));
        jPanelTransparente1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 240, 10));

        txtEmail.setBackground(new java.awt.Color(22, 32, 45));
        txtEmail.setForeground(new java.awt.Color(255, 255, 255));
        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 255, 204)));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jPanelTransparente1.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 430, 30));

        kButton1.setText("Enviar email");
        kButton1.setBorderPainted(false);
        kButton1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        kButton1.setkBackGroundColor(new java.awt.Color(22, 32, 45));
        kButton1.setkEndColor(new java.awt.Color(51, 153, 255));
        kButton1.setkHoverEndColor(new java.awt.Color(255, 0, 102));
        kButton1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton1.setkHoverStartColor(new java.awt.Color(22, 32, 45));
        kButton1.setkSelectedColor(new java.awt.Color(255, 102, 153));
        kButton1.setkStartColor(new java.awt.Color(38, 45, 61));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });
        jPanelTransparente1.add(kButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, -1, -1));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("¿Olvidó su contraseña?");
        jPanelTransparente1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, -1, -1));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Te enviaremos un email de recuperacion!!");
        jPanelTransparente1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 190, 520, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanelTransparente1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanelTransparente1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        verifyEmail();
    }//GEN-LAST:event_kButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private LIB.JPanelTransparente jPanelTransparente1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private keeptoo.KButton kButton1;
    private javax.swing.JTextField txtEmail;
    // End of variables declaration//GEN-END:variables
}
