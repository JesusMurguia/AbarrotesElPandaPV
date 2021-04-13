package vistas;

import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import negocio.ControlBalances;
import negocio.ControlEmpleados;
import negocio.ControlVistas;
import objetosNegocio.Balance;
import objetosNegocio.Empleado;

public class FrmLogin extends javax.swing.JFrame {

    private final ControlVistas controlVistas;
    private final ControlEmpleados controlEmpleados;
    private final ControlBalances controlBalances;

    /**
     * Creates new form Login
     */
    public FrmLogin() {
        initComponents();
        controlBalances = new ControlBalances();
        controlEmpleados = new ControlEmpleados();
        controlVistas = new ControlVistas();
        this.getContentPane().setBackground(Color.white);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogin = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Faceboot");
        setFocusTraversalPolicyProvider(true);
        setLocationByPlatform(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario.jpg"))); // NOI18N
        lblLogin.setText("jLabel2");
        getContentPane().add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(89, 13, 85, 88));

        lblUser.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user.png"))); // NOI18N
        lblUser.setText("Numero de Empleado:");
        getContentPane().add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 119, -1, -1));

        lblPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/password.png"))); // NOI18N
        lblPassword.setText("Contraseña:");
        getContentPane().add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 152, -1, -1));

        txtUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserActionPerformed(evt);
            }
        });
        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUserKeyTyped(evt);
            }
        });
        getContentPane().add(txtUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 121, 87, -1));

        btnLogin.setBackground(new java.awt.Color(0, 51, 204));
        btnLogin.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("LOGIN");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 198, 121, 34));

        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordKeyTyped(evt);
            }
        });
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 157, 138, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoPantallaLogin.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyTyped
        if (txtUser.getText().length() >= 10) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Exedio el numero maximo de caracteres", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Solo puedes ingresar numeros  ", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtUserKeyTyped

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        try {
            try {
                this.acceder();
            } catch (ParseException ex) {
                Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyTyped
        if (txtPassword.getText().length() > 12) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Exedio el numero maximo de caracteres", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_txtPasswordKeyTyped

    private void txtUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    public boolean verificacionDeCampos() {
        if (txtUser.getText().equalsIgnoreCase("")
                || txtPassword.getText().equalsIgnoreCase("") || !isNumeric(txtUser.getText())) {
            return false;
        } else {
            return true;
        }
    }

    public void acceder() throws SQLException, ParseException {
        if (verificacionDeCampos() == true) {
            Empleado empleado = new Empleado();
            empleado = this.controlEmpleados.obtenerEmpleadoPorId(Integer.parseInt(txtUser.getText()));
            boolean resp = controlVistas.accederAlSistema(empleado, txtPassword.getText());
            if (resp) {
                this.dispose();
                Balance balance = new Balance();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = new Date();
                Date date1 = dateFormat.parse(date.getYear() + "-" + date.getMonth() + "-" + date.getDay());
                balance.setFecha(date1);
                balance.setEmpleado(empleado);
                controlBalances.agregarBalanceBD(balance);
            }
        } else {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Campo de usuario o contrasña sin valor", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}