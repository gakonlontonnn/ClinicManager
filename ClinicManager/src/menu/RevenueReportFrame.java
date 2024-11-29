/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package menu;

import connect.MainConnection;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RevenueReportFrame extends JFrame {

    private JTable revenueTable;
    private DefaultTableModel tableModel;

    public RevenueReportFrame() {
        setTitle("Revenue Report");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        tableModel = new DefaultTableModel(new Object[]{"Product", "Weekly Revenue", "Monthly Revenue", "Total Revenue"}, 0);
        revenueTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(revenueTable);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Create the close button
        JButton closeButton = new JButton("Đóng");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the frame
            }
        });

        // Add the close button to a panel and place it at the bottom of the main panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(closeButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        loadRevenueData();

        add(mainPanel);
    }
    private void loadRevenueData() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = MainConnection.getConnection();
            String query = "SELECT m.Medicine_name, "
                    + "SUM(CASE WHEN DATEPART(WEEK, i.DateTime) = DATEPART(WEEK, GETDATE()) THEN id.TotalPrice ELSE 0 END) AS WeeklyRevenue, "
                    + "SUM(CASE WHEN MONTH(i.DateTime) = MONTH(GETDATE()) THEN id.TotalPrice ELSE 0 END) AS MonthlyRevenue, "
                    + "SUM(id.TotalPrice) AS TotalRevenue "
                    + "FROM InvoiceDetails id "
                    + "INNER JOIN Invoices i ON id.Invoice_id = i.Invoice_id "
                    + "INNER JOIN Medicine m ON id.Medicine_id = m.Medicine_id "
                    + "GROUP BY m.Medicine_name WITH ROLLUP";
            pstmt = conn.prepareStatement(query);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Object[] rowData = new Object[4];
                rowData[0] = rs.getString("Medicine_name");
                rowData[1] = rs.getDouble("WeeklyRevenue");
                rowData[2] = rs.getDouble("MonthlyRevenue");
                rowData[3] = rs.getDouble("TotalRevenue");
                tableModel.addRow(rowData);
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

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new RevenueReportFrame().setVisible(true);
        });
    }
}