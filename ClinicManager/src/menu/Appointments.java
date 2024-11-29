
package menu;

import connect.MainConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PC
 */
public class Appointments extends javax.swing.JFrame {

    /**
     * Creates new form User
     */
 public Appointments() {
    initComponents();
    cuochen_tb.setComponentPopupMenu(editpopupmenu);
    loadAppointments();
    loadPatientNames();
    loadDoctorNames();// Add this line
}
private void loadPatientNames() {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        conn = MainConnection.getConnection();
        String query = "SELECT Patient_name FROM Patients";
        pstmt = conn.prepareStatement(query);
        rs = pstmt.executeQuery();

        while (rs.next()) {
            String patientName = rs.getString("Patient_name");
            jComboBox1.addItem(patientName);
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
private void loadDoctorNames() {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        conn = MainConnection.getConnection();
        String query = "SELECT Name FROM DoctorManager";
        pstmt = conn.prepareStatement(query);
        rs = pstmt.executeQuery();

        while (rs.next()) {
            String doctorName = rs.getString("Name");
            jboxdoctor.addItem(doctorName);
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


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        editpopupmenu = new javax.swing.JPopupMenu();
        edit = new javax.swing.JMenuItem();
        delete = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        cuochen_tb = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        edittime = new javax.swing.JTextField();
        jsave = new javax.swing.JButton();
        jreset = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jid = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jboxdoctor = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        editdate = new com.toedter.calendar.JDateChooser();

        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        editpopupmenu.add(edit);

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        editpopupmenu.add(delete);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        cuochen_tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Palitent", "Doctor", "Date", "Time"
            }
        ));
        jScrollPane1.setViewportView(cuochen_tb);

        jLabel1.setText("Palitent:");

        jLabel2.setText("Doctor");

        jLabel3.setText("Date:");

        jLabel4.setText("Time:");

        jsave.setText("Save");
        jsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jsaveActionPerformed(evt);
            }
        });

        jreset.setText("Reset");
        jreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jresetActionPerformed(evt);
            }
        });

        jLabel5.setText("ID");

        jid.setEditable(false);
        jid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jidActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 51, 51));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("X");
        jLabel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jboxdoctor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        jboxdoctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jboxdoctorActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Appointments Manager");

        editdate.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(333, 333, 333)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(jsave)
                        .addGap(18, 18, 18)
                        .addComponent(jreset))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jid, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox1, 0, 311, Short.MAX_VALUE)
                                    .addComponent(jboxdoctor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(edittime)
                                    .addComponent(editdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel7))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jboxdoctor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edittime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jsave)
                            .addComponent(jreset))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(41, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(editdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jsaveActionPerformed
 
    String patientName = (String) jComboBox1.getSelectedItem();
    String doctorName = (String) jboxdoctor.getSelectedItem();
    Date appointmentDate = editdate.getDate();
    String appointmentTime = edittime.getText();
    String appointmentId = jid.getText();

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    Integer patientId = null;
    Integer doctorId = null;
 
    try {
        conn = MainConnection.getConnection();

        // Fetch the patient ID
        String patientQuery = "SELECT Patient_id FROM Patients WHERE Patient_name = ?";
        pstmt = conn.prepareStatement(patientQuery);
        pstmt.setString(1, patientName);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            patientId = rs.getInt("Patient_id");
        } else {
            JOptionPane.showMessageDialog(null, "Patient not found");
            return;
        }
        rs.close();
        pstmt.close();

        // Fetch the doctor ID
        String doctorQuery = "SELECT Doctor_id FROM DoctorManager WHERE Name = ?";
        pstmt = conn.prepareStatement(doctorQuery);
        pstmt.setString(1, doctorName);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            doctorId = rs.getInt("Doctor_id");
        } else {
            JOptionPane.showMessageDialog(null, "Doctor not found");
            return;
        }
        rs.close();
        pstmt.close();

        if (appointmentId == null || appointmentId.trim().isEmpty()) {
            // Insert new appointment
            String insertQuery = "INSERT INTO Appointments (Patient_id, Doctor_id, Appointment_date, Appointment_time) "
                    + "VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertQuery);
            pstmt.setInt(1, patientId);
            pstmt.setInt(2, doctorId);
             SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String date = dateFormat.format(editdate.getDate());
                pstmt.setString(3, date);
            pstmt.setString(4, appointmentTime);
        } else {
            // Update existing appointment
            String updateQuery = "UPDATE Appointments SET Appointment_date = ?, Appointment_time = ?, "
                    + "Patient_id = ?, Doctor_id = ? WHERE Appointment_id = ?";
            pstmt = conn.prepareStatement(updateQuery);
             SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String date = dateFormat.format(editdate.getDate());
                pstmt.setString(1, date);
            pstmt.setString(2, appointmentTime);
            pstmt.setInt(3, patientId);
            pstmt.setInt(4, doctorId);
            pstmt.setInt(5, Integer.parseInt(appointmentId));
        }

        int rowsAffected = pstmt.executeUpdate();
        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Operation successful");

            // Clear the input fields
            jid.setText("");
            jComboBox1.setSelectedIndex(-1);
            jboxdoctor.setSelectedIndex(-1);
            editdate.setDate(null);
            edittime.setText("");

            // Reload the table data
            DefaultTableModel model = (DefaultTableModel) cuochen_tb.getModel();
            model.setRowCount(0); // Clear existing data
            loadAppointments(); // Reload data from database
        } else {
            JOptionPane.showMessageDialog(null, "Operation failed");
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


    }//GEN-LAST:event_jsaveActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
  int row = cuochen_tb.getSelectedRow();
if (row >= 0) {
    String appointmentid = cuochen_tb.getValueAt(row, 0).toString();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        conn = MainConnection.getConnection();
        String query = "SELECT p.Patient_name, d.Name AS Doctor, a.Appointment_id, a.Appointment_date, a.Appointment_time "
                + "FROM Appointments a "
                + "INNER JOIN Patients p ON a.Patient_id = p.Patient_id "
                + "INNER JOIN DoctorManager d ON a.Doctor_id = d.Doctor_id "
                + "WHERE a.Appointment_id = ?";
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, appointmentid);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            jid.setText(rs.getString("Appointment_id"));
            jComboBox1.setSelectedItem(rs.getString("Patient_name"));
            jboxdoctor.setSelectedItem(rs.getString("Doctor"));
            
            // Định dạng ngày thành "dd-MM-yyyy"
          
                 java.sql.Date sqlDate = rs.getDate("Appointment_date");
                        editdate.setDate(new java.util.Date(sqlDate.getTime()));
            
           // Định dạng giờ phút từ cột "Appointment_time"
            SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
            java.sql.Time sqlTime = rs.getTime("Appointment_time");
            String formattedTime = timeFormat.format(sqlTime);
            edittime.setText(formattedTime);
        
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


    }//GEN-LAST:event_editActionPerformed

    private void jidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jidActionPerformed
       
    }//GEN-LAST:event_jidActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
                              
    int row = cuochen_tb.getSelectedRow();
    if (row >= 0) {
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this appointment?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String appointmentId = cuochen_tb.getValueAt(row, 0).toString();

            Connection conn = null;
            PreparedStatement pstmt = null;

            try {
                conn = MainConnection.getConnection();
                String deleteQuery = "DELETE FROM Appointments WHERE Appointment_id = ?";
                pstmt = conn.prepareStatement(deleteQuery);
                pstmt.setString(1, appointmentId);

                int rowsAffected = pstmt.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Appointment deleted successfully");

                    // Reload the table data
                    DefaultTableModel model = (DefaultTableModel) cuochen_tb.getModel();
                    model.setRowCount(0); // Clear existing data
                    loadAppointments(); // Reload data from database
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to delete the appointment");
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
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Please select an appointment to delete");
    }


    }//GEN-LAST:event_deleteActionPerformed

    private void jresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jresetActionPerformed
        jid.setText("");
    jComboBox1.setSelectedIndex(-1);  // Reset patient selection
    jboxdoctor.setSelectedIndex(-1);
    editdate.setDate(null);
    edittime.setText("");
    }//GEN-LAST:event_jresetActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
                                         
    String selectedPatient = (String) jComboBox1.getSelectedItem();
    System.out.println("Selected Patient: " + selectedPatient);  // Handle the selected patient name if needed
                                     
  
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jboxdoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jboxdoctorActionPerformed
     // This method is triggered when a selection is made in jboxdoctor.
    String selectedDoctor = (String) jboxdoctor.getSelectedItem();
    System.out.println("Selected Doctor: " + selectedDoctor);  // Handle the selected doctor name if needed
    }//GEN-LAST:event_jboxdoctorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable cuochen_tb;
    private javax.swing.JMenuItem delete;
    private javax.swing.JMenuItem edit;
    private com.toedter.calendar.JDateChooser editdate;
    private javax.swing.JPopupMenu editpopupmenu;
    private javax.swing.JTextField edittime;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jboxdoctor;
    private javax.swing.JTextField jid;
    private javax.swing.JButton jreset;
    private javax.swing.JButton jsave;
    // End of variables declaration//GEN-END:variables

      private void loadAppointments() {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");

    try {
        conn = MainConnection.getConnection();
        String query = "SELECT p.Patient_name, d.Name AS Doctor, a.Appointment_id, a.Appointment_date, a.Appointment_time "
                + "FROM Appointments a "
                + "INNER JOIN Patients p ON a.Patient_id = p.Patient_id "
                + "INNER JOIN DoctorManager d ON a.Doctor_id = d.Doctor_id";
        pstmt = conn.prepareStatement(query);
        rs = pstmt.executeQuery();

        DefaultTableModel model = (DefaultTableModel) cuochen_tb.getModel();
        while (rs.next()) {
            Object[] row = new Object[5];
            row[0] = rs.getString("Appointment_id");
            row[1] = rs.getString("Patient_name");
            row[2] = rs.getString("Doctor");
            // Convert SQL Date to String in the specified format
            java.sql.Date sqlDate = rs.getDate("Appointment_date");
            String formattedDate = dateFormat.format(sqlDate);
            row[3] = formattedDate;
            row[4] = rs.getTime("Appointment_time");
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


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Appointments().setVisible(true);
            }
        });
    }
}
                          
      
