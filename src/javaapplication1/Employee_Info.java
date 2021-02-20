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
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.text.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

public
        class Employee_Info extends javax.swing.JFrame {
//--  Déclarations

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;

    /**
     * Creates new form Employee_Info
     */
    public
            Employee_Info() {
        initComponents();
        conn = javaconnect.ConnectDb();
        Update_table();
        Fillcombo();
        CurrentDate();
    }

    public
            void comboselect() {

        if (ComboBox_name.getSelectedItem().toString().equals("Sakura")) {
            UserInfo_Frame s = new UserInfo_Frame();
            s.setVisible(true);
        }

        if (ComboBox_name.getSelectedItem().toString().equals("Naruto")) {
            Login_jframe l = new Login_jframe();
            l.setVisible(true);
        }
    }

    public
            void CurrentDate() {
        //--  Date
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        date_txt.setText("Date " + year + "/" + (month + 1) + "/" + day);

        //--  Time
        int second = cal.get(Calendar.SECOND);
        int minute = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR);
        time_txt.setText("Time " + hour + ":" + (minute) + ":" + second);
    }

    public
            void close() {
        WindowEvent winClosingEvent = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
    }

    private
            void Update_table() {
        //--  Déclarations
        String sql = "select * from EmployeeInfo";

        try {
            //--  Initialisations
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            Table_Employee.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally {
            try {
                rs.close();
                pst.close();
            }
            catch (Exception e) {

            }
        }
    }

    private
            void Fillcombo() {
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
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally {
            try {
                rs.close();
                pst.close();
            }
            catch (Exception e) {

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
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Cmd_save = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txt_update = new javax.swing.JButton();
        cmd_delete = new javax.swing.JButton();
        cmd_clear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Employeeid_jTextField = new javax.swing.JTextField();
        Age_jTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Name_jTextField = new javax.swing.JTextField();
        Surname_jTextField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        txt_search = new javax.swing.JTextField();
        cmd_print = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        date_txt = new javax.swing.JMenu();
        time_txt = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
        Table_Employee.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Table_EmployeeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Table_EmployeeKeyReleased(evt);
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

        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/Button-Close-icon.png"))); // NOI18N
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buttons", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Agency FB", 1, 14), new java.awt.Color(51, 51, 255))); // NOI18N

        Cmd_save.setBackground(new java.awt.Color(255, 51, 51));
        Cmd_save.setForeground(new java.awt.Color(0, 0, 102));
        Cmd_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/Save-icon.png"))); // NOI18N
        Cmd_save.setText("Save");
        Cmd_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cmd_saveActionPerformed(evt);
            }
        });

        jButton2.setText("New");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txt_update.setText("Update");
        txt_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_updateActionPerformed(evt);
            }
        });

        cmd_delete.setText("Delete");
        cmd_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_deleteActionPerformed(evt);
            }
        });

        cmd_clear.setText("Clear");
        cmd_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_clearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cmd_save)
                    .addComponent(jButton2)
                    .addComponent(cmd_delete)
                    .addComponent(txt_update)
                    .addComponent(cmd_clear))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Cmd_save)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(cmd_delete)
                .addGap(18, 18, 18)
                .addComponent(txt_update)
                .addGap(18, 18, 18)
                .addComponent(cmd_clear)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Employee Info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14), new java.awt.Color(255, 102, 102))); // NOI18N

        jLabel1.setText("Employeeid");

        jLabel2.setText("Name");

        jLabel4.setText("Age");

        jLabel3.setText("Surname");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Age_jTextField)
                    .addComponent(Surname_jTextField)
                    .addComponent(Name_jTextField)
                    .addComponent(Employeeid_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Employeeid_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Name_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Surname_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Age_jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Search"))));

        txt_search.setToolTipText("Search employee id,name,surname");
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        cmd_print.setText("Print");
        cmd_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd_printActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("New");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication1/Button-Close-icon.png"))); // NOI18N
        jMenuItem2.setText("Close");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Exit");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        date_txt.setText("Date");
        jMenuBar1.add(date_txt);

        time_txt.setText("Time");
        jMenuBar1.add(time_txt);

        jMenu3.setText("Help");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Help file");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboBox_name, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmd_print)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboBox_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmd_print))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
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

                int age = Integer.parseInt(add4);

                if (age >= 25) {
                    Age_jTextField.setBackground(Color.GREEN);
                    Age_jTextField.setForeground(Color.darkGray);
                }
                else {
                    Age_jTextField.setBackground(Color.red);
                    Age_jTextField.setForeground(Color.BLACK);
                }
            }
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally {
            try {
                rs.close();
                pst.close();
            }
            catch (Exception e) {

            }
        }
    }//GEN-LAST:event_Table_EmployeeMouseClicked

    private void ComboBox_namePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_ComboBox_namePopupMenuWillBecomeInvisible
        comboselect();

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
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally {
            try {
                rs.close();
                pst.close();
            }
            catch (Exception e) {

            }
        }
    }//GEN-LAST:event_ComboBox_namePopupMenuWillBecomeInvisible

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        close();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        close();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Cmd_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cmd_saveActionPerformed
        //--  Déclarations
        String sql = "Insert into EmployeeInfo(employeeid,name,surname,age) values(?,?,?,?)";

        try {
            //--  Initialisations
            pst = conn.prepareStatement(sql);
            pst.setString(1, Employeeid_jTextField.getText());
            pst.setString(2, Name_jTextField.getText());
            pst.setString(3, Surname_jTextField.getText());
            pst.setString(4, Age_jTextField.getText());
            pst.execute();

            JOptionPane.showMessageDialog(null, "Saved");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally {
            try {
                rs.close();
                pst.close();
            }
            catch (Exception e) {

            }
        }

        Update_table();
    }//GEN-LAST:event_Cmd_saveActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //--  Déclarations
        close();
        UserInfo_Frame s = new UserInfo_Frame();
        s.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cmd_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_deleteActionPerformed
        //--  Déclarations
        int p = JOptionPane.showConfirmDialog(null, "Do you really want to delete", "Delete", JOptionPane.YES_NO_OPTION);

        if (p == 0) {
            String sql = "delete from EmployeeInfo where employeeid =?";

            try {
                //--  Initialisations
                pst = conn.prepareStatement(sql);
                pst.setString(1, Employeeid_jTextField.getText());
                pst.execute();
                JOptionPane.showMessageDialog(null, "Deleted");
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
            finally {
                try {
                    rs.close();
                    pst.close();
                }
                catch (Exception e) {

                }
            }

            Update_table();
        }
    }//GEN-LAST:event_cmd_deleteActionPerformed

    private void txt_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_updateActionPerformed
        //--  Déclarations
        String value1 = Employeeid_jTextField.getText();
        String value2 = Name_jTextField.getText();
        String value3 = Surname_jTextField.getText();
        String value4 = Age_jTextField.getText();
        String sql = "update EmployeeInfo set employeeid='" + value1 + "' ,name = '" + value2 + "' ,surname = '" + value3 + "',age='" + value4 + "' where employeeid"
                + "='" + value1 + "'";

        try {
            //--  Initialisations
            pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Updated");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally {
            try {
                rs.close();
                pst.close();
            }
            catch (Exception e) {

            }
        }

        Update_table();
    }//GEN-LAST:event_txt_updateActionPerformed

    private void cmd_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_clearActionPerformed
        //--  Déclarations

        Employeeid_jTextField.setText("");
        Name_jTextField.setText("");
        Surname_jTextField.setText("");
        Age_jTextField.setText("");
    }//GEN-LAST:event_cmd_clearActionPerformed

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        //--  Déclarations

        try {
            //--  Initialisations
            String sql = "select * from EmployeeInfo where name =?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_search.getText());
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
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally {
            try {
                rs.close();
                pst.close();
            }
            catch (Exception e) {

            }
        }

        try {
            //--  Initialisations
            String sql = "select * from EmployeeInfo where employeeid =?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_search.getText());
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
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally {
            try {
                rs.close();
                pst.close();
            }
            catch (Exception e) {

            }
        }

        try {
            //--  Initialisations
            String sql = "select * from EmployeeInfo where surname =?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_search.getText());
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
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        finally {
            try {
                rs.close();
                pst.close();
            }
            catch (Exception e) {

            }
        }
    }//GEN-LAST:event_txt_searchKeyReleased

    private void Table_EmployeeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Table_EmployeeKeyPressed

    }//GEN-LAST:event_Table_EmployeeKeyPressed

    private void Table_EmployeeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Table_EmployeeKeyReleased
        //--  Déclarations

        try {
            //--  Initialisations

            if (evt.getKeyCode() == KeyEvent.VK_DOWN || evt.getKeyCode() == KeyEvent.VK_UP) {
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
                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
                finally {
                    try {
                        rs.close();
                        pst.close();
                    }
                    catch (Exception e) {

                    }
                }

            }
        }
        catch (Exception e) {
        }
    }//GEN-LAST:event_Table_EmployeeKeyReleased

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        //--  Déclarations

        try {
            //--  Initialisations

            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + "C:\\Users\\Shakill\\Desktop\\Discrete\\Discrete Maths\\soloution--kenneth-h-rosen.pdf");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        //--  Déclarations

        try {
            //--  Initialisations
            System.exit(0);
        }
        catch (Exception e) {
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void cmd_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd_printActionPerformed
        //--  Déclarations
        MessageFormat header = new MessageFormat("Report Print");
        MessageFormat footer = new MessageFormat("Page{0,number,integer}");

        try {
            //--  Initialisations

            Table_Employee.print(JTable.PrintMode.NORMAL, header, footer);
        }
        catch (java.awt.print.PrinterException e) {
            System.err.format("Cannot print %s%n", e.getMessage());
        }
    }//GEN-LAST:event_cmd_printActionPerformed

    /**
     * @param args the command line arguments
     */
    public static
            void main(String args[]) {
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
        }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Employee_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Employee_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Employee_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Employee_Info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public
                    void run() {
                new Employee_Info().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Age_jTextField;
    private javax.swing.JButton Cmd_save;
    private javax.swing.JComboBox<String> ComboBox_name;
    private javax.swing.JTextField Employeeid_jTextField;
    private javax.swing.JTextField Name_jTextField;
    private javax.swing.JTextField Surname_jTextField;
    private javax.swing.JTable Table_Employee;
    private javax.swing.JButton cmd_clear;
    private javax.swing.JButton cmd_delete;
    private javax.swing.JButton cmd_print;
    private javax.swing.JMenu date_txt;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu time_txt;
    private javax.swing.JTextField txt_search;
    private javax.swing.JButton txt_update;
    // End of variables declaration//GEN-END:variables
}
