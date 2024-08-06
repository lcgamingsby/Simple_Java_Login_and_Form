package com.formlogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewPage extends JFrame {
    private JTextField namaField;
    private JTextField alamatField;
    private JComboBox<String> provinsiComboBox;
    private JRadioButton lakiLakiRadioButton;
    private JRadioButton perempuanRadioButton;
    private JCheckBox sepakBolaCheckBox;
    private JCheckBox basketCheckBox;
    private JCheckBox pingPongCheckBox;

    public NewPage() {
        setTitle("Form Data");
        setSize(600, 300);
        setLayout(new GridLayout(0, 2, 10, 10)); // Grid layout with 2 columns and gaps

        JLabel namaLabel = new JLabel("Name:");
        namaField = new JTextField();

        JLabel alamatLabel = new JLabel("Address:");
        alamatField = new JTextField();

        JLabel provinsiLabel = new JLabel("Province:");
        String[] provinsiOptions = {"East Java", "West Java", "Central Java"};
        provinsiComboBox = new JComboBox<>(provinsiOptions);
        provinsiComboBox.setSelectedIndex(-1);

        JLabel sexLabel = new JLabel("Gender:");
        lakiLakiRadioButton = new JRadioButton("Male");
        perempuanRadioButton = new JRadioButton("Female");

        JLabel hobiLabel = new JLabel("Hobby:");
        sepakBolaCheckBox = new JCheckBox("Football");
        basketCheckBox = new JCheckBox("Basketball");
        pingPongCheckBox = new JCheckBox("Ping Pong");

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = namaField.getText();
                String alamat = alamatField.getText();
                String provinsi = (String) provinsiComboBox.getSelectedItem();
                String jenisKelamin = lakiLakiRadioButton.isSelected() ? "Male" : "Female";
                String hobi = "";
                if (sepakBolaCheckBox.isSelected()) {
                    hobi += "Football";
                }
                if (basketCheckBox.isSelected()) {
                    hobi += "Basketball";
                }
                if (pingPongCheckBox.isSelected()) {
                    hobi += "Ping Pong";
                }

                JOptionPane.showMessageDialog(null, "Name: " + nama + "\nAddress: " + alamat + "\nProvince: " + provinsi + "\nGender: " + jenisKelamin + "\nHobby: " + hobi);
            }
        });

        // Add components to the frame
        add(namaLabel);
        add(namaField);
        add(alamatLabel);
        add(alamatField);
        add(provinsiLabel);
        add(provinsiComboBox);
        add(sexLabel);
        JPanel genderPanel = new JPanel(); // Panel for radio buttons
        genderPanel.add(lakiLakiRadioButton);
        genderPanel.add(perempuanRadioButton);
        add(genderPanel);
        add(hobiLabel);
        JPanel hobiPanel = new JPanel(); // Panel for checkboxes
        hobiPanel.add(sepakBolaCheckBox);
        hobiPanel.add(basketCheckBox);
        hobiPanel.add(pingPongCheckBox);
        add(hobiPanel);
        add(new JLabel()); // Empty label for spacing
        add(submitButton);

        ButtonGroup sexGroup = new ButtonGroup();
        sexGroup.add(lakiLakiRadioButton);
        sexGroup.add(perempuanRadioButton);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                NewPage newPage = new NewPage();
                newPage.setVisible(true);
            }
        });
    }
}
