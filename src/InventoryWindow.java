import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InventoryWindow {

    public InventoryWindow() {
        JFrame frame = new JFrame("Inventory Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        // Use GridBagLayout for flexible placement
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(20, 20, 20, 20)); // padding around edges
        frame.setContentPane(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // spacing around components
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        JLabel titleLabel = new JLabel("Welcome to Inventory System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(30, 144, 255)); // Dodger Blue
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        panel.add(titleLabel, gbc);

        // Reset gridwidth for other components
        gbc.gridwidth = 1;

        // Item Name Label + TextField
        gbc.gridy = 1;
        gbc.gridx = 0;
        panel.add(new JLabel("Item Name:"), gbc);

        JTextField nameField = new JTextField(20);
        nameField.setToolTipText("Enter the item name");
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        panel.add(nameField, gbc);
        gbc.gridwidth = 1;

        // Category Label + ComboBox
        gbc.gridy = 2;
        gbc.gridx = 0;
        panel.add(new JLabel("Category:"), gbc);

        String[] categories = {"Electronics", "Clothing", "Food", "Stationery", "Mussa"};
        JComboBox<String> categoryBox = new JComboBox<>(categories);
        categoryBox.setToolTipText("Select the category of the item");
        gbc.gridx = 1;
        gbc.gridwidth = 2;
        panel.add(categoryBox, gbc);
        gbc.gridwidth = 1;

        // Availability Checkbox
        JCheckBox availableCheck = new JCheckBox("Available");
        availableCheck.setToolTipText("Check if item is in stock");
        gbc.gridy = 3;
        gbc.gridx = 1;
        panel.add(availableCheck, gbc);

        // Buttons: Add Item & Clear
        JButton addButton = new JButton("Add Item");
        addButton.setBackground(new Color(60, 179, 113)); // Medium Sea Green
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);

        JButton clearButton = new JButton("Clear");
        clearButton.setBackground(new Color(220, 20, 60)); // Crimson
        clearButton.setForeground(Color.WHITE);
        clearButton.setFocusPainted(false);

        gbc.gridy = 4;
        gbc.gridx = 1;
        panel.add(addButton, gbc);
        gbc.gridx = 2;
        panel.add(clearButton, gbc);

        // Output Area inside ScrollPane
        JTextArea outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        outputArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        JScrollPane scrollPane = new JScrollPane(outputArea);
        gbc.gridy = 5;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(scrollPane, gbc);

        // Action listeners
        addButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter item name.", "Input Error", JOptionPane.ERROR_MESSAGE);
                nameField.requestFocus();
                return;
            }

            String category = (String) categoryBox.getSelectedItem();
            boolean isAvailable = availableCheck.isSelected();

            outputArea.append(String.format("Added: %-20s | Category: %-12s | Status: %s%n",
                    name, category, isAvailable ? "In Stock" : "Out of Stock"));

            // Clear inputs after adding
            nameField.setText("");
            availableCheck.setSelected(false);
            nameField.requestFocus();
        });

        clearButton.addActionListener(e -> {
            nameField.setText("");
            availableCheck.setSelected(false);
            outputArea.setText("");
            nameField.requestFocus();
        });

        frame.setVisible(true);
    }

}