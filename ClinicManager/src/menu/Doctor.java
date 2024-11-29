/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package menu;

import connect.MainConnection;
import java.awt.Component;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Doctor extends javax.swing.JFrame {

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        doctorPopupMenu = new javax.swing.JPopupMenu();
        EditPopupitem = new javax.swing.JMenuItem();
        DeletePopupmenuitem = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        doctor = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        inputdoctorID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        inputdoctorname = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        inputphone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        inputage = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        inputaddress = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        inputemail = new javax.swing.JTextField();
        inputsubmit = new javax.swing.JButton();
        inputreset = new javax.swing.JButton();
        inputgender = new javax.swing.JComboBox<>();

        EditPopupitem.setText("Edit");
        EditPopupitem.setToolTipText("");
        EditPopupitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditPopupitemActionPerformed(evt);
            }
        });
        doctorPopupMenu.add(EditPopupitem);

        DeletePopupmenuitem.setText("Delete");
        DeletePopupmenuitem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeletePopupmenuitemActionPerformed(evt);
            }
        });
        doctorPopupMenu.add(DeletePopupmenuitem);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        doctor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Doctor ID", "Doctor Name", "Phone", "Age", "Gender", "Address", "Email"
            }
        ));
        jScrollPane1.setViewportView(doctor);

        jLabel2.setBackground(new java.awt.Color(255, 51, 51));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("X");
        jLabel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        jLabel1.setText("Doctor ID");

        inputdoctorID.setEditable(false);

        jLabel3.setText("Doctor Name");

        inputdoctorname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputdoctornameActionPerformed(evt);
            }
        });

        jLabel4.setText("Phone");

        jLabel5.setText("Age");

        jLabel6.setText("Gender");

        jLabel7.setText("Address");

        jLabel8.setText("Email");

        inputsubmit.setText("Submit");
        inputsubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputsubmitActionPerformed(evt);
            }
        });

        inputreset.setText("Reset");
        inputreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputresetActionPerformed(evt);
            }
        });

        inputgender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(inputsubmit)
                                .addGap(33, 33, 33)
                                .addComponent(inputreset)
                                .addGap(62, 62, 62))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(inputdoctorID, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
                            .addComponent(inputdoctorname)
                            .addComponent(inputphone)
                            .addComponent(inputage)
                            .addComponent(inputaddress)
                            .addComponent(inputemail)
                            .addComponent(inputgender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputdoctorID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(inputdoctorname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(inputphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(inputgender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(inputaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(inputemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputsubmit)
                    .addComponent(inputreset))
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public Doctor() {
        initComponents();
        loadDoctor();
        doctor.setComponentPopupMenu(doctorPopupMenu);
    }
    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void EditPopupitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditPopupitemActionPerformed

        int row = doctor.getSelectedRow();
        String medicalid = null;
        if (row >= 0) {
            medicalid = (String) doctor.getValueAt(row, 0);
        }

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = MainConnection.getConnection();
            String query = "Select * from DoctorManager   where  Doctor_id= " + medicalid;
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                inputdoctorID.setText(rs.getString("Doctor_id"));
                inputdoctorname.setText(rs.getString("Name"));
                int age = rs.getInt("age");
                String ageStr = String.valueOf(age);
                inputage.setText(ageStr);
                inputphone.setText(rs.getString("Phone"));
                inputgender.setSelectedItem(rs.getString("Gender"));
                inputaddress.setText(rs.getString("Address"));
                inputemail.setText(rs.getString("Email"));
             
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error closing resources: " + ex.getMessage());
            }
        }


    }//GEN-LAST:event_EditPopupitemActionPerformed

    private void DeletePopupmenuitemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeletePopupmenuitemActionPerformed
        int row = doctor.getSelectedRow();
        String medicalid = null;
        if (row >= 0) {
            medicalid = (String) doctor.getValueAt(row, 0);
        }
        DeleteMedicine(medicalid);

    }

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {
        this.dispose();
    }

  public void DeleteMedicine(String medicine_id) {
       Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = MainConnection.getConnection();

            // Thông báo trước khi xóa
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Doctor?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                // Lấy ID của bác sĩ "N/A"
                String getNAIdQuery = "SELECT Doctor_id FROM DoctorManager WHERE Name = 'N/A'";
                pstmt = conn.prepareStatement(getNAIdQuery);
                ResultSet rs = pstmt.executeQuery();
                int naDoctorId = 0;
                if (rs.next()) {
                    naDoctorId = rs.getInt("Doctor_id");
                } else {
                    JOptionPane.showMessageDialog(null, "N/A Doctor not found. Please add it first.");
                    return;
                }
                rs.close();
                pstmt.close();

                // Lấy ID của bác sĩ cần xóa
                String doctorId = medicine_id;

                // Cập nhật các bản ghi liên quan trong bảng Appointments
                String updateAppointmentsQuery = "UPDATE Appointments SET Doctor_id = ? WHERE Doctor_id = ?";
                pstmt = conn.prepareStatement(updateAppointmentsQuery);
                pstmt.setInt(1, naDoctorId);
                pstmt.setString(2, doctorId);
                pstmt.executeUpdate();
                pstmt.close();

                // Cập nhật các bản ghi liên quan trong bảng Invoices
                String updateInvoicesQuery = "UPDATE Invoices SET Doctor_id = ? WHERE Doctor_id = ?";
                pstmt = conn.prepareStatement(updateInvoicesQuery);
                pstmt.setInt(1, naDoctorId);
                pstmt.setString(2, doctorId);
                pstmt.executeUpdate();
                pstmt.close();

                // Xóa bác sĩ từ bảng DoctorManager
                String deleteDoctorQuery = "DELETE FROM DoctorManager WHERE Doctor_id = ?";
                pstmt = conn.prepareStatement(deleteDoctorQuery);
                pstmt.setString(1, doctorId);
                pstmt.executeUpdate();

                // Thông báo khi xóa thành công
                JOptionPane.showMessageDialog(null, "Doctor successfully deleted and related records updated.");
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error closing resources: " + ex.getMessage());
                }
        }
loadDoctor();
    

    }//GEN-LAST:event_DeletePopupmenuitemActionPerformed

    private void inputdoctornameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputdoctornameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputdoctornameActionPerformed

    private void inputresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputresetActionPerformed
        inputaddress.setText("");
        inputage.setText("");
        inputdoctorID.setText("");
        inputdoctorname.setText("");
        inputemail.setText("");
        inputgender.setSelectedItem("");
       
        inputphone.setText("");
     
    }//GEN-LAST:event_inputresetActionPerformed

    private void inputsubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputsubmitActionPerformed
        String doctorid = inputdoctorID.getText();
        String doctorname = inputdoctorname.getText();
        String age = inputage.getText();
        String gender = (String) inputgender.getSelectedItem();
        String email = inputemail.getText();
      
        String phone = inputphone.getText();
        String address = inputaddress.getText();
 if (!isNameValid(doctorname)) {
        JOptionPane.showMessageDialog(this, "Invalid name. The name contains only alphabetic characters.");
        return;
    }

    if (!isPhoneValid(phone)) {
        JOptionPane.showMessageDialog(this, "Invalid phone number. The phone number must contain exactly 10 digits.");
        return;
    }
 if (address.trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Address cannot be empty.");
        return;
    }
    if (!isNumberValid(age)) {
        JOptionPane.showMessageDialog(this, "Invalid age. Age contains only digits.");
        return;
    }
  if (!isGenderValid(gender)) {
        JOptionPane.showMessageDialog(this, "Invalid gender. Gender must be 'Male' or 'Female'.");
        return;
    
    }
    if (!isEmailValid(email)) {
        JOptionPane.showMessageDialog(this, "Invalid email.");
        return;
    }

   
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = MainConnection.getConnection();
            if (doctorid == null || doctorid.trim().isEmpty()) {
                // Insert new record
    String insertQuery = "INSERT INTO DoctorManager (Name, Phone, Age, Gender, Address, Email) VALUES (?, ?, ?, ?, ?, ?);";
                pstmt = conn.prepareStatement(insertQuery);
                pstmt.setString(1, doctorname);
                pstmt.setString(2, phone);
                pstmt.setInt(3, Integer.parseInt(age));
                pstmt.setString(4, gender);
                pstmt.setString(5, address);
                pstmt.setString(6, email);
              
            } else {
                // Update existing record
                String updateQuery = "UPDATE DoctorManager SET Name = ?, Phone = ?, Age = ?, Gender = ?, Address = ?, Email = ? WHERE Doctor_id = ?";
                pstmt = conn.prepareStatement(updateQuery);
                pstmt.setString(1, doctorname);
                pstmt.setString(2, phone);
                pstmt.setInt(3, Integer.parseInt(age));
                pstmt.setString(4, gender);
                pstmt.setString(5, address);
                pstmt.setString(6, email);
                pstmt.setInt(7, Integer.parseInt(doctorid));
            }

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Operation successful");
            } else {
                JOptionPane.showMessageDialog(this, "Operation failed");
            }

            // Reload the table data
            DefaultTableModel model = (DefaultTableModel) doctor.getModel();
            model.setRowCount(0); // Clear existing data
            loadDoctor(); // Reload data from database

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Error closing resources: " + ex.getMessage());
            }
        }
    }
        private boolean isNameValid(String name) {
    return name.matches("[a-zA-Z ]+");
}
private boolean isPhoneValid(String phone) {
    return phone.matches("\\d{10}");
}
private boolean isNumberValid(String number) {
    return number.matches("\\d+");
}

private boolean isGenderValid(String gender) {
    return gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female");
}
private boolean isEmailValid(String email) {
    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    Pattern pat = Pattern.compile(emailRegex);
    if (email == null)
        return false;
    return pat.matcher(email).matches();

    }//GEN-LAST:event_inputsubmitActionPerformed

   private void loadDoctor() {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        conn = MainConnection.getConnection();
        String query = "SELECT * FROM DoctorManager WHERE Name != 'N/A'";
        pstmt = conn.prepareStatement(query);
        rs = pstmt.executeQuery();

        DefaultTableModel model = (DefaultTableModel) doctor.getModel();
        model.setRowCount(0); // Clear existing data

        while (rs.next()) {
            Object[] row = new Object[7];
            row[0] = rs.getString("Doctor_id");
            row[1] = rs.getString("Name");
            row[2] = rs.getString("Phone");
            row[3] = rs.getInt("Age");
            row[4] = rs.getString("Gender");
            row[5] = rs.getString("Address");
            row[6] = rs.getString("Email");
            model.addRow(row);
        }
    } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error closing resources: " + ex.getMessage());
        }
    }
}

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Doctor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem DeletePopupmenuitem;
    private javax.swing.JMenuItem EditPopupitem;
    private javax.swing.JTable doctor;
    private javax.swing.JPopupMenu doctorPopupMenu;
    private javax.swing.JTextField inputaddress;
    private javax.swing.JTextField inputage;
    private javax.swing.JTextField inputdoctorID;
    private javax.swing.JTextField inputdoctorname;
    private javax.swing.JTextField inputemail;
    private javax.swing.JComboBox<String> inputgender;
    private javax.swing.JTextField inputphone;
    private javax.swing.JButton inputreset;
    private javax.swing.JButton inputsubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
