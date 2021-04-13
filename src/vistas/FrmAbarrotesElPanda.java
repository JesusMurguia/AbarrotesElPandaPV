package vistas;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import negocio.ControlCategorias;
import negocio.ControlEmpleados;
import negocio.ControlProductos;
import negocio.ControlProveedores;
import objetosNegocio.Empleado;

/**
 *
 * @author JMJR-Solutions
 */
public class FrmAbarrotesElPanda extends javax.swing.JFrame {

    Empleado empleado;

    /**
     * Creates new form FrmAbarrotesElPanda
     *
     * @param empleado
     */
    public FrmAbarrotesElPanda(Empleado empleado) {
        this.empleado = empleado;
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private FrmAbarrotesElPanda() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        lblPanda = new javax.swing.JLabel();
        lblBievenido1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCatalagos = new javax.swing.JMenu();
        menuCatalagosCategorias = new javax.swing.JMenuItem();
        menuCatalagosClientes = new javax.swing.JMenuItem();
        menuCatalagosEmpleados = new javax.swing.JMenuItem();
        menuCatalagosProductos = new javax.swing.JMenuItem();
        menuCatalagosProveedores = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        opcionMenuSalir = new javax.swing.JMenuItem();
        menuAdeudos = new javax.swing.JMenu();
        menuAdeudosClientes = new javax.swing.JMenuItem();
        menuAdeudosEmpleados = new javax.swing.JMenuItem();
        menuVentas = new javax.swing.JMenu();
        menuVentasPunto = new javax.swing.JMenuItem();
        menuVentasReportes = new javax.swing.JMenuItem();
        menuInventarios = new javax.swing.JMenu();
        menuInventariosConsulta = new javax.swing.JMenuItem();
        menuFinanzas = new javax.swing.JMenu();
        menuFinanzasRetiro = new javax.swing.JMenuItem();
        menuFinanzasBalances = new javax.swing.JMenuItem();
        menuSoporte = new javax.swing.JMenu();
        menuJMJR = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenu7.setText("jMenu7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Abarrotes el \"Panda\"");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPanda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/panda.jpg"))); // NOI18N
        getContentPane().add(lblPanda, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, -1));

        lblBievenido1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bienvenido.png"))); // NOI18N
        getContentPane().add(lblBievenido1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Viner Hand ITC", 2, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Abarrotes \"El Panda\"");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, -1, -1));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoPantalla.jpg"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 410));

        jMenuBar1.setBackground(new java.awt.Color(0, 51, 102));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        menuCatalagos.setText("Catalogos");

        menuCatalagosCategorias.setText("Categorias");
        menuCatalagosCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCatalagosCategoriasActionPerformed(evt);
            }
        });
        menuCatalagos.add(menuCatalagosCategorias);

        menuCatalagosClientes.setText("Clientes");
        menuCatalagosClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCatalagosClientesActionPerformed(evt);
            }
        });
        menuCatalagos.add(menuCatalagosClientes);

        menuCatalagosEmpleados.setText("Empleados");
        menuCatalagosEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCatalagosEmpleadosActionPerformed(evt);
            }
        });
        menuCatalagos.add(menuCatalagosEmpleados);

        menuCatalagosProductos.setText("Productos");
        menuCatalagosProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCatalagosProductosActionPerformed(evt);
            }
        });
        menuCatalagos.add(menuCatalagosProductos);

        menuCatalagosProveedores.setText("Proveedores");
        menuCatalagosProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCatalagosProveedoresActionPerformed(evt);
            }
        });
        menuCatalagos.add(menuCatalagosProveedores);
        menuCatalagos.add(jSeparator1);

        opcionMenuSalir.setText("Salir");
        opcionMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionMenuSalirActionPerformed(evt);
            }
        });
        menuCatalagos.add(opcionMenuSalir);

        jMenuBar1.add(menuCatalagos);

        menuAdeudos.setText("Adeudos");

        menuAdeudosClientes.setText("Clientes");
        menuAdeudos.add(menuAdeudosClientes);

        menuAdeudosEmpleados.setText("Empleados");
        menuAdeudosEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAdeudosEmpleadosActionPerformed(evt);
            }
        });
        menuAdeudos.add(menuAdeudosEmpleados);

        jMenuBar1.add(menuAdeudos);

        menuVentas.setText("Ventas");

        menuVentasPunto.setText("Punto de Venta");
        menuVentasPunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuVentasPuntoActionPerformed(evt);
            }
        });
        menuVentas.add(menuVentasPunto);

        menuVentasReportes.setText("Reportes");
        menuVentas.add(menuVentasReportes);

        jMenuBar1.add(menuVentas);

        menuInventarios.setText("Inventarios");

        menuInventariosConsulta.setText("Consulta Inventarios");
        menuInventarios.add(menuInventariosConsulta);

        jMenuBar1.add(menuInventarios);

        menuFinanzas.setText("Finanzas");

        menuFinanzasRetiro.setText("Retiros");
        menuFinanzas.add(menuFinanzasRetiro);

        menuFinanzasBalances.setText("Balances");
        menuFinanzas.add(menuFinanzasBalances);

        jMenuBar1.add(menuFinanzas);

        menuSoporte.setText("Soporte");

        menuJMJR.setText("JMJR-Solutions");
        menuSoporte.add(menuJMJR);

        jMenuBar1.add(menuSoporte);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuAdeudosEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAdeudosEmpleadosActionPerformed

    }//GEN-LAST:event_menuAdeudosEmpleadosActionPerformed

    private void menuCatalagosProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCatalagosProductosActionPerformed
        try {
            controlProductos.despliegaAdministrarProductos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al desplegar la vista de empleados: " + ex, "Error Vistas", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuCatalagosProductosActionPerformed

    private void menuCatalagosClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCatalagosClientesActionPerformed

    }//GEN-LAST:event_menuCatalagosClientesActionPerformed

    private void opcionMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionMenuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_opcionMenuSalirActionPerformed

    private void menuCatalagosEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCatalagosEmpleadosActionPerformed
        try {
            controlEmpleados.despliegaAdministrarEmpleados();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al desplegar la vista de empleados: " + ex, "Error Vistas", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuCatalagosEmpleadosActionPerformed

    private void menuCatalagosCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCatalagosCategoriasActionPerformed
        try {
            controlCategorias.despliegaAdministrarCategorias();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al desplegar la vista de empleados: " + ex, "Error Vistas", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuCatalagosCategoriasActionPerformed

    private void menuCatalagosProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCatalagosProveedoresActionPerformed
        try {
            controlProveedores.despliegaAdministrarProveedores();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al desplegar la vista de empleados: " + ex, "Error Vistas", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuCatalagosProveedoresActionPerformed

    private void menuVentasPuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuVentasPuntoActionPerformed
        FrmPuntoDeVenta frmPuntoDeVenta;
        try {
            frmPuntoDeVenta = new FrmPuntoDeVenta(this.empleado);
            frmPuntoDeVenta.setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(FrmAbarrotesElPanda.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.dispose();
    }//GEN-LAST:event_menuVentasPuntoActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAbarrotesElPanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAbarrotesElPanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAbarrotesElPanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAbarrotesElPanda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAbarrotesElPanda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lblBievenido1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblPanda;
    private javax.swing.JMenu menuAdeudos;
    private javax.swing.JMenuItem menuAdeudosClientes;
    private javax.swing.JMenuItem menuAdeudosEmpleados;
    private javax.swing.JMenu menuCatalagos;
    private javax.swing.JMenuItem menuCatalagosCategorias;
    private javax.swing.JMenuItem menuCatalagosClientes;
    private javax.swing.JMenuItem menuCatalagosEmpleados;
    private javax.swing.JMenuItem menuCatalagosProductos;
    private javax.swing.JMenuItem menuCatalagosProveedores;
    private javax.swing.JMenu menuFinanzas;
    private javax.swing.JMenuItem menuFinanzasBalances;
    private javax.swing.JMenuItem menuFinanzasRetiro;
    private javax.swing.JMenu menuInventarios;
    private javax.swing.JMenuItem menuInventariosConsulta;
    private javax.swing.JMenuItem menuJMJR;
    private javax.swing.JMenu menuSoporte;
    private javax.swing.JMenu menuVentas;
    private javax.swing.JMenuItem menuVentasPunto;
    private javax.swing.JMenuItem menuVentasReportes;
    private javax.swing.JMenuItem opcionMenuSalir;
    // End of variables declaration//GEN-END:variables
    private final ControlEmpleados controlEmpleados = new ControlEmpleados();
    private final ControlCategorias controlCategorias = new ControlCategorias();
    private final ControlProductos controlProductos = new ControlProductos();
    private final ControlProveedores controlProveedores = new ControlProveedores();

}
