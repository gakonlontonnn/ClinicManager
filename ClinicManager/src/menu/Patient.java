
package menu;

import connect.MainConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Patient extends javax.swing.JFrame {

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        itemDelete = new javax.swing.JMenuItem();
        itemEdit = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        benhnhan = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        inputPatientID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        inputPatientName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        inputAddress = new javax.swing.JTextField();
        inputPhone = new javax.swing.JTextField();
        inputAge = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Submit = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        inputGender = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        itemDelete.setText("Delete");
        itemDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDeleteActionPerformed(evt);
            }
        });
        jPopupMenu1.add(itemDelete);

        itemEdit.setText("Edit");
        itemEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEditActionPerformed(evt);
            }
        });
        jPopupMenu1.add(itemEdit);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        benhnhan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient ID", "Patient Name", "Gender", "Age", "Address", "Phone"
            }
        ));
        jScrollPane1.setViewportView(benhnhan);
        if (benhnhan.getColumnModel().getColumnCount() > 0) {
            benhnhan.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setText("Patient ID:");

        inputPatientID.setEditable(false);
        inputPatientID.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        inputPatientID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPatientIDActionPerformed(evt);
            }
        });

        jLabel2.setText("Patient Name:");

        jLabel3.setText("Gender:");

        jLabel4.setText("Address:");

        jLabel5.setText("Phone:");

        inputPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputPhoneActionPerformed(evt);
            }
        });

        inputAge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputAgeActionPerformed(evt);
            }
        });

        jLabel6.setText("Age:");

        Submit.setText("Submit");
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });

        Reset.setText("Reset");
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 51, 51));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("X");
        jLabel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        inputGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setText("Patilents Manager");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(399, 399, 399)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 44, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Submit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Reset))
                            .addComponent(inputAddress, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputAge, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputPatientName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputPatientID, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(inputGender, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(73, 73, 73))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(inputPatientID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(inputPatientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(inputGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(inputAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(inputAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(inputPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Submit)
                    .addComponent(Reset))
                .addGap(59, 59, 59))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputPatientIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPatientIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputPatientIDActionPerformed

    private void inputPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputPhoneActionPerformed

    private void inputAgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputAgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputAgeActionPerformed

    private void itemDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDeleteActionPerformed
     int row = benhnhan.getSelectedRow();
    if (row >= 0) {
        String patientId = (String) benhnhan.getValueAt(row, 0);

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this patient?", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            deletePatient(patientId);

            // Refresh the table data
            DefaultTableModel model = (DefaultTableModel) benhnhan.getModel();
            model.setRowCount(0); // Clear existing data
            loadPatient(); // Reload data from database
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select a patient to delete.");
    }
    }//GEN-LAST:event_itemDeleteActionPerformed
public void deletePatient(String patientId) {
    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
        conn = MainConnection.getConnection();
        conn.setAutoCommit(false); // Start transaction

        // Delete from Appointments
        String deleteAppointmentsQuery = "DELETE FROM Appointments WHERE Patient_id = ?";
        pstmt = conn.prepareStatement(deleteAppointmentsQuery);
        pstmt.setString(1, patientId);
        pstmt.executeUpdate();
        pstmt.close();

        // Delete from InvoiceDetails
        String deleteInvoiceDetailsQuery = "DELETE FROM InvoiceDetails WHERE Invoice_id IN (SELECT Invoice_id FROM Invoices WHERE Patient_id = ?)";
        pstmt = conn.prepareStatement(deleteInvoiceDetailsQuery);
        pstmt.setString(1, patientId);
        pstmt.executeUpdate();
        pstmt.close();

        // Delete from Invoices
        String deleteInvoicesQuery = "DELETE FROM Invoices WHERE Patient_id = ?";
        pstmt = conn.prepareStatement(deleteInvoicesQuery);
        pstmt.setString(1, patientId);
        pstmt.executeUpdate();
        pstmt.close();

        // Finally, delete from Patients
        String deletePatientQuery = "DELETE FROM Patients WHERE Patient_id = ?";
        pstmt = conn.prepareStatement(deletePatientQuery);
        pstmt.setString(1, patientId);
        pstmt.executeUpdate();
        pstmt.close();

        conn.commit(); // Commit transaction
        JOptionPane.showMessageDialog(this, "Patient and related records deleted successfully");

    } catch (SQLException ex) {
        try {
            if (conn != null) {
                conn.rollback(); // Rollback transaction on error
            }
        } catch (SQLException e) {
            System.out.println("Rollback error: " + e.getMessage());
        }
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


    private void itemEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEditActionPerformed
int row = benhnhan.getSelectedRow();
        String patilentid = null;
        if (row >= 0) {
            patilentid = (String) benhnhan.getValueAt(row, 0);
        }

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = MainConnection.getConnection();
            String query = "select * from Patients where Patient_id=" + patilentid;
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                inputPatientID.setText(rs.getString("Patient_id"));
                inputPatientName.setText(rs.getString("Patient_name"));
                inputGender.setSelectedItem(rs.getString("Gender"));
                inputAge.setText(rs.getString("Age"));
                inputAddress.setText(rs.getString("Address"));
                inputPhone.setText(rs.getString("Phone"));
                

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
    }//GEN-LAST:event_itemEditActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
    // Retrieve input values from the text fields
    String patientID = inputPatientID.getText().trim();
    String patientName = inputPatientName.getText().trim();
    String gender = (String) inputGender.getSelectedItem();
    String age = inputAge.getText().trim();
    String address = inputAddress.getText().trim();
    String phone = inputPhone.getText().trim();

   // Validate inputs
    if (!isNameValid(patientName)) {
        JOptionPane.showMessageDialog(this, "Invalid name. The name contains only alphabetic characters.");
        return;
    }


    if (!isGenderValid(gender)) {
        JOptionPane.showMessageDialog(this, "Invalid gender. Gender must be 'Male' or 'Female'.");
        return;
    }

   if (!isNumberValid(age)) {
        JOptionPane.showMessageDialog(this, "Invalid age. Age contains only digits.");
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

    Connection conn = null;
    PreparedStatement pstmt = null;

    try {
        // Establish database connection
        conn = MainConnection.getConnection();

        if (patientID.isEmpty()) {
            // Insert new patient
            String insertQuery = "INSERT INTO Patients (Patient_name, Gender, Age, Address, Phone) VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertQuery);
            pstmt.setString(1, patientName);
            pstmt.setString(2, gender);
            pstmt.setString(3, age);
            pstmt.setString(4, address);
            pstmt.setString(5, phone);
        } else {
            // Update existing patient
            String updateQuery = "UPDATE Patients SET Patient_name = ?, Gender = ?, Age = ?, Address = ?, Phone = ? WHERE Patient_id = ?";
            pstmt = conn.prepareStatement(updateQuery);
            pstmt.setString(1, patientName);
            pstmt.setString(2, gender);
            pstmt.setString(3, age);
            pstmt.setString(4, address);
            pstmt.setString(5, phone);
            pstmt.setInt(6, Integer.parseInt(patientID));
        }

        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(this, "Operation successful");

            // Clear the input fields
            inputPatientID.setText("");
            inputPatientName.setText("");
            inputGender.setSelectedItem("");
            inputAge.setText("");
            inputAddress.setText("");
            inputPhone.setText("");

            // Reload the table data
            DefaultTableModel model = (DefaultTableModel) benhnhan.getModel();
            model.setRowCount(0); // Clear existing data
            loadPatient(); // Reload data from database
        } else {
            JOptionPane.showMessageDialog(this, "Operation failed");
        }

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
    }}
      // Các phương thức kiểm tra tính hợp lệ của dữ liệu
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

    




    }//GEN-LAST:event_SubmitActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
          inputPatientID.setText("");
       inputPatientName.setText("");
           inputPhone.setText("");
       inputGender.setSelectedItem("");
           inputAge.setText("");
            inputAddress.setText("");
    }//GEN-LAST:event_ResetActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Patient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Reset;
    private javax.swing.JButton Submit;
    private javax.swing.JTable benhnhan;
    private javax.swing.JTextField inputAddress;
    private javax.swing.JTextField inputAge;
    private javax.swing.JComboBox<String> inputGender;
    private javax.swing.JTextField inputPatientID;
    private javax.swing.JTextField inputPatientName;
    private javax.swing.JTextField inputPhone;
    private javax.swing.JMenuItem itemDelete;
    private javax.swing.JMenuItem itemEdit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
 public Patient() {
        initComponents();
        benhnhan.setComponentPopupMenu(jPopupMenu1);
        loadPatient();
    }

    private void loadPatient() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = MainConnection.getConnection();
            String query = "select * from Patients";
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            DefaultTableModel model = (DefaultTableModel) benhnhan.getModel();
            while (rs.next()) {
                Object[] row = new Object[6];
                row[0] = rs.getString("Patient_id");
                row[1] = rs.getString("Patient_name");
                row[2] = rs.getString("Gender");
                row[3] = rs.getString("Age");
                row[4] = rs.getString("Address");
                row[5] = rs.getString("Phone");
                model.addRow(row);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println("Error closing resources: " + ex.getMessage());
            }
        }
    }
}

