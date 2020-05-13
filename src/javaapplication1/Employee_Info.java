package javaapplication1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Shakill
 */
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Employee_Info extends javax.swing.JFrame {
//--  Déclarations

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    /**
     * Creates new form Employee_Info
     */
    public Employee_Info() {
        initComponents();
        conn = javaconnect.ConnectDb();
        Update_table();
        Fillcombo();
    }

    private void Update_table() {
        //--  Déclarations
        String sql = "select * from EmployeeInfo";

        try {
            //--  Initialisations
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            Table_Employee.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {

            }
        }
    }

    private void Fillcombo() {
        //--  Déclarations
        String sql = "select * from EmployeeInfo";

        try {
            //--  Initialisations
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            ComboBox_name.removeAllItems();

            while (rs.next()) {
                String name = rs.getString("name");
                ComboBox_name.addItem(name);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();
            } catch (Exception e) {

            }
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

        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Employee = new javax.swing.JTable();
        ComboBox_name = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        Employeeid_jTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Name_jTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Surname_jTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Age_jTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Table_Employee.setModel(new javax.swing.table.DefaultTableModel(
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
        Table_Employee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_EmployeeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_Employee);

        ComboBox_name.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBox_name.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                ComboBox_namePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel1.setText("Employeeid");

        jLabel2.setText("Name");

        jLabel3.setText("Surname");

        jLabel4.setText("Age");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Employeeid_jTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(Name_jTextField)
                            .addComponent(Surname_jTextField)
                            .addComponent(Age_jTextField))
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ComboBox_name, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ComboBox_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Employeeid_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(Name_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(Surname_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(Age_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Table_EmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_EmployeeMouseClicked
        //--  Déclarations

        try {
            //--  Initialisations
            int row = Table_Employee.getSelectedRow();
            String Table_click = (Table_Employee.getModel().getValueAt(row, 0).toString());
            String sql = "select * from EmployeeInfo where employeeid='" + Table_click + "' ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                String add1 = rs.getString("employeeid");
                Employeeid_jTextField.setText(add1);

                String add2 = rs.getString("name");
                Name_jTextField.setText(add2);

                String add3 = rs.getString("surname");
                Surname_jTextField.setText(add3);

                String add4 = rs.getString("age");
                Age_jTextField.setText(add4);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_Table_EmployeeMouseClicked

    private void ComboBox_namePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_ComboBox_namePopupMenuWillBecomeInvisible
        //--  Déclarations
        String tmp = (String) ComboBox_name.getSelectedItem();
        String sql = "select * from EmployeeInfo where name=?";

        try {
            //--  Initialisations
            pst = conn.prepareStatement(sql);
            pst.setString(1, tmp);
            rs = pst.executeQuery();

            if (rs.next()) {
                String add1 = rs.getString("employeeid");
                Employeeid_jTextField.setText(add1);

                String add2 = rs.getString("name");
                Name_jTextField.setText(add2);

                String add3 = rs.getString("surname");
                Surname_jTextField.setText(add3);

                String add4 = rs.getString("age");
                Age_jTextField.setText(add4);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_ComboBox_namePopupMenuWillBecomeInvisible

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
            java.util.logging.Logger.getLogger(Employee_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employee_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employee_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employee_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Employee_Info().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Age_jTextField;
    private javax.swing.JComboBox<String> ComboBox_name;
    private javax.swing.JTextField Employeeid_jTextField;
    private javax.swing.JTextField Name_jTextField;
    private javax.swing.JTextField Surname_jTextField;
    private javax.swing.JTable Table_Employee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
