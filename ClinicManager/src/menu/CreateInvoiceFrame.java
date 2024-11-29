package menu;

import connect.MainConnection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

public class CreateInvoiceFrame extends JFrame {

    private final Map<String, String> patientMap = new HashMap<>();
    private JTextField quantityField;
    private JComboBox<String> doctorComboBox;
    private JComboBox<String> patientComboBox;
    private JComboBox<String> medicineComboBox;
    private JComboBox<String> paymentMethodComboBox;
    private DefaultTableModel invoiceTableModel;
    private JTable invoiceTable;
    private JLabel totalAmountLabel;

    public CreateInvoiceFrame() {
        setTitle("Create new invoice");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(6, 2, 8, 4));

        JLabel phoneLabel = new JLabel("Select patient:");
        patientComboBox = new JComboBox<>();
        loadPatients();
        topPanel.add(phoneLabel);
        topPanel.add(patientComboBox);

        JLabel doctorLabel = new JLabel("Choose a doctor:");
        doctorComboBox = new JComboBox<>();
        loadDoctors();
        topPanel.add(doctorLabel);
        topPanel.add(doctorComboBox);

        JLabel medicineLabel = new JLabel("Choose medicine:");
        medicineComboBox = new JComboBox<>();
        topPanel.add(medicineLabel);
        topPanel.add(medicineComboBox);
        loadMedicine();

        JLabel quantityLabel = new JLabel("Enter quantity:");
        quantityField = new JTextField();
        topPanel.add(quantityLabel);
        topPanel.add(quantityField);

        JLabel paymentMethodLabel = new JLabel("Payment method:");
        paymentMethodComboBox = new JComboBox<>(new String[]{"Payment in cash", "Online payment"});
        topPanel.add(paymentMethodLabel);
        topPanel.add(paymentMethodComboBox);

        JButton addButton = new JButton("Add to invoice");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMedicineToInvoice();
            }
        });
        topPanel.add(addButton);

        JButton deleteButton = new JButton("Remove from invoice");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteMedicineFromInvoice();
            }
        });
        topPanel.add(deleteButton);

        mainPanel.add(topPanel, BorderLayout.NORTH);

        invoiceTableModel = new DefaultTableModel(new Object[]{"Medicine", "Quantity"}, 0);
        invoiceTable = new JTable(invoiceTableModel);
        JScrollPane scrollPane = new JScrollPane(invoiceTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());

        totalAmountLabel = new JLabel("Total Amount: $0.00");
        bottomPanel.add(totalAmountLabel, BorderLayout.WEST);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

        JButton paymentButton = new JButton("Pay");
        paymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createOrder();
            }
        });
        buttonPanel.add(paymentButton);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonPanel.add(closeButton);

        bottomPanel.add(buttonPanel, BorderLayout.EAST);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void loadPatients() {
        try (Connection conn = MainConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT Patient_name, Phone FROM Patients");
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String patientName = rs.getString("Patient_name");
                String phone = rs.getString("Phone");
                String displayString = patientName + " - " + phone;
                patientComboBox.addItem(displayString);
                patientMap.put(displayString, phone);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private void loadDoctors() {
        try (Connection conn = MainConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT Name FROM DoctorManager");
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                doctorComboBox.addItem(rs.getString("Name"));
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private void loadMedicine() {
        try (Connection conn = MainConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT Medicine_name FROM Medicine");
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                medicineComboBox.addItem(rs.getString("Medicine_name"));
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    private void addMedicineToInvoice() {
        String medicine = (String) medicineComboBox.getSelectedItem();
        String quantityText = quantityField.getText();
        int quantity;

        try {
            quantity = Integer.parseInt(quantityText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid quantity.");
            return;
        }

        boolean found = false;
        for (int i = 0; i < invoiceTableModel.getRowCount(); i++) {
            if (medicine.equals(invoiceTableModel.getValueAt(i, 0))) {
                int currentQuantity = (int) invoiceTableModel.getValueAt(i, 1);
                invoiceTableModel.setValueAt(currentQuantity + quantity, i, 1);
                found = true;
                break;
            }
        }

        if (!found) {
            invoiceTableModel.addRow(new Object[]{medicine, quantity});
        }

        updateTotalAmount();
        JOptionPane.showMessageDialog(this, "Added " + quantity + " " + medicine + " to the invoice.");
    }

    private void deleteMedicineFromInvoice() {
        int selectedRow = invoiceTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a product to delete.");
            return;
        }

        invoiceTableModel.removeRow(selectedRow);
        updateTotalAmount();
        JOptionPane.showMessageDialog(this, "The product has been removed from the cart.");
    }

    private void createOrder() {
        String insertOrderQuery = "INSERT INTO Invoices (Doctor_id, Patient_id, DateTime, TotalAmount, PaymentMethod, Status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = MainConnection.getConnection();
             PreparedStatement pstmtOrder = conn.prepareStatement(insertOrderQuery, Statement.RETURN_GENERATED_KEYS)) {

            conn.setAutoCommit(false);

            int patientId = getPatientIdFromComboBox();
            int doctorId = getDoctorIdFromComboBox();

            if (patientId == -1 || doctorId == -1) {
                JOptionPane.showMessageDialog(this, "Please select or add patients and doctors.");
                return;
            }

            pstmtOrder.setInt(1, doctorId);
            pstmtOrder.setInt(2, patientId);
            pstmtOrder.setTimestamp(3, new Timestamp(System.currentTimeMillis()));

            BigDecimal totalAmount = calculateTotalAmount();
            pstmtOrder.setBigDecimal(4, totalAmount);
            pstmtOrder.setString(5, (String) paymentMethodComboBox.getSelectedItem());
            pstmtOrder.setString(6, "Paid");

            pstmtOrder.executeUpdate();

            try (ResultSet rs = pstmtOrder.getGeneratedKeys()) {
                if (rs.next()) {
                    int orderId = rs.getInt(1);
                    insertOrderDetails(conn, orderId);
                }
            }

            conn.commit();
            JOptionPane.showMessageDialog(this, "The order has been created successfully.");
            invoiceTableModel.setRowCount(0);
            updateTotalAmount();

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while creating the order.");
        }
    }

    private void insertOrderDetails(Connection conn, int orderId) throws SQLException {
        String insertOrderDetailQuery = "INSERT INTO InvoiceDetails (Invoice_id, Medicine_id, Quantity, UnitPrice, TotalPrice) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement pstmtOrderDetail = conn.prepareStatement(insertOrderDetailQuery)) {
            for (int i = 0; i < invoiceTableModel.getRowCount(); i++) {
                String medicine = (String) invoiceTableModel.getValueAt(i, 0);
                int quantity = (int) invoiceTableModel.getValueAt(i, 1);
                double unitPrice = getPriceOfMedicine(medicine);
                double totalPrice = quantity * unitPrice;

                pstmtOrderDetail.setInt(1, orderId);
                pstmtOrderDetail.setInt(2, getMedicineId(medicine));
                pstmtOrderDetail.setInt(3, quantity);
                pstmtOrderDetail.setDouble(4, unitPrice);
                pstmtOrderDetail.setDouble(5, totalPrice);
                pstmtOrderDetail.executeUpdate();
            }
        }
    }

    private BigDecimal calculateTotalAmount() {
        BigDecimal totalAmount = BigDecimal.ZERO;

        for (int i = 0; i < invoiceTableModel.getRowCount(); i++) {
            String medicine = (String) invoiceTableModel.getValueAt(i, 0);
            int quantity = (int) invoiceTableModel.getValueAt(i, 1);
            double unitPrice = getPriceOfMedicine(medicine);
            totalAmount = totalAmount.add(BigDecimal.valueOf(quantity * unitPrice));
        }

        return totalAmount;
    }

    private void updateTotalAmount() {
        BigDecimal totalAmount = calculateTotalAmount();
        totalAmountLabel.setText("Total Amount: $" + totalAmount.toString());
    }

    private int getPatientIdFromComboBox() {
        String selectedPatient = (String) patientComboBox.getSelectedItem();
        String phone = patientMap.get(selectedPatient);

        try (Connection conn = MainConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT Patient_id FROM Patients WHERE Phone = ?")) {

            pstmt.setString(1, phone);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("Patient_id");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    private int getDoctorIdFromComboBox() {
        String selectedDoctor = (String) doctorComboBox.getSelectedItem();

        try (Connection conn = MainConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT Doctor_id FROM DoctorManager WHERE Name = ?")) {

            pstmt.setString(1, selectedDoctor);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("Doctor_id");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    private int getMedicineId(String medicineName) {
        try (Connection conn = MainConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT Medicine_id FROM Medicine WHERE Medicine_name = ?")) {

            pstmt.setString(1, medicineName);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("Medicine_id");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    private double getPriceOfMedicine(String medicineName) {
        try (Connection conn = MainConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT Price FROM Medicine WHERE Medicine_name = ?")) {

            pstmt.setString(1, medicineName);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getDouble("Price");
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0.0;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CreateInvoiceFrame().setVisible(true));
    }
}
