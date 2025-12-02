package pl.temperatureconversion.bartek.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TemperatureConversion extends JFrame {
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JRadioButton celsiusToFahr;
    private JRadioButton fahrToCelsius;
    private JLabel temperatureLabel;
    private JTextField temperatureTextField;
    private JButton calculateButton;
    private JRadioButton celsiusToKelv;
    private JRadioButton kelvToCelsius;
    private JRadioButton kelvToFahr;
    private JRadioButton fahrToKelv;
    private JLabel temperatureResultLabel;

    public TemperatureConversion() throws HeadlessException {
        setTitle("Temperature conversion");
        setSize(600, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(mainPanel);

        ButtonGroup group = new ButtonGroup();
        group.add(celsiusToFahr);
        group.add(fahrToCelsius);
        group.add(celsiusToKelv);
        group.add(kelvToCelsius);
        group.add(kelvToFahr);
        group.add(fahrToKelv);

        createListeners();
    }

    private void createListeners() {
        temperatureTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyPressed = e.getKeyCode();
                if (KeyEvent.VK_ENTER == keyPressed) {
                    calculateTemperature();
                }
            }
        });

        calculateButton.addActionListener(e -> calculateTemperature()); // przykładowe użycie lambdy zamiast Override.
        celsiusToFahr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTemperature();
            }
        });
        fahrToCelsius.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTemperature();
            }
        });
        kelvToFahr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTemperature();
            }
        });
        fahrToKelv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTemperature();
            }
        });
        celsiusToKelv.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTemperature();
            }
        });
        kelvToCelsius.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTemperature();
            }
        });
    }

    private void calculateTemperature() {
        double temperature = 0;
        try {
            temperature = Double.parseDouble(temperatureTextField.getText());
        } catch (NumberFormatException e){
            temperatureResultLabel.setText("Wpisano błędną temperaturę!");
//            JOptionPane.showMessageDialog(mainPanel, "Wpisano błędną temperaturę!", "Błąd!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String message = "";
        if (celsiusToFahr.isSelected()) {
            double result = temperature * 1.8 + 32;
            message = String.format("%.2f °C = %.2f °F", temperature, result);
//            JOptionPane.showMessageDialog(mainPanel, message);
        } else if (fahrToCelsius.isSelected()) {
            double result = (temperature - 32) / 1.8;
            message = String.format("%.2f °F = %.2f °C", temperature, result);
//            JOptionPane.showMessageDialog(mainPanel, message);
        } else if (celsiusToKelv.isSelected()) {
            double result = temperature + 273.15;
            message = String.format("%.2f °C = %.2f K", temperature, result);
//            JOptionPane.showMessageDialog(mainPanel, message);
        } else if (kelvToCelsius.isSelected()) {
            double result = temperature - 273.15;
            message = String.format("%.2f K = %.2f °C", temperature, result);
//            JOptionPane.showMessageDialog(mainPanel, message);
        } else if (kelvToFahr.isSelected()) {
            double result = (temperature - 273.15) * 1.8 + 32;
            message = String.format("%.2f K = %.2f °F", temperature, result);
//            JOptionPane.showMessageDialog(mainPanel, message);
        } else if (fahrToKelv.isSelected()){
            double result = ((temperature - 32) / 1.8) + 273.15;
            message = String.format("%.2f °F = %.2f K", temperature, result);
//            JOptionPane.showMessageDialog(mainPanel, message);
        } else {
            message = "Nie zaznaczono opcji przeliczania.";
//            JOptionPane.showMessageDialog(mainPanel, message, "Błąd!", JOptionPane.ERROR_MESSAGE);
        }
        temperatureResultLabel.setText(message);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TemperatureConversion().setVisible(true));
    }
}

//package pl.temperatureconversion.bartek.gui;
//
//import javax.swing.*;
//import javax.swing.border.EmptyBorder;
//import java.awt.*;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
//import java.awt.event.ActionListener;
//
//public class TemperatureConversion extends JFrame {
//    private JPanel mainPanel;
//    private JLabel titleLabel;
//    private JRadioButton celsiusToFahr;
//    private JRadioButton fahrToCelsius;
//    private JRadioButton celsiusToKelv;
//    private JRadioButton kelvToCelsius;
//    private JRadioButton kelvToFahr;
//    private JRadioButton fahrToKelv;
//    private JLabel temperatureLabel;
//    private JTextField temperatureTextField;
//    private JLabel resultLabel;
//
//    public TemperatureConversion() {
//        setTitle("Temperature conversion");
//        setSize(600, 350);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//
//        mainPanel = new JPanel();
//        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
//        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
//        setContentPane(mainPanel);
//
//        titleLabel = new JLabel("Temperature Conversion");
//        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
//        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//        mainPanel.add(titleLabel);
//        mainPanel.add(Box.createVerticalStrut(10));
//
//        temperatureLabel = new JLabel("Enter temperature:");
//        mainPanel.add(temperatureLabel);
//
//        temperatureTextField = new JTextField();
//        mainPanel.add(temperatureTextField);
//
//        // Radio buttons
//        celsiusToFahr = new JRadioButton("°C → °F");
//        fahrToCelsius = new JRadioButton("°F → °C");
//        celsiusToKelv = new JRadioButton("°C → K");
//        kelvToCelsius = new JRadioButton("K → °C");
//        kelvToFahr = new JRadioButton("K → °F");
//        fahrToKelv = new JRadioButton("°F → K");
//
//        ButtonGroup group = new ButtonGroup();
//        group.add(celsiusToFahr);
//        group.add(fahrToCelsius);
//        group.add(celsiusToKelv);
//        group.add(kelvToCelsius);
//        group.add(kelvToFahr);
//        group.add(fahrToKelv);
//
//        JPanel radioPanel = new JPanel();
//        radioPanel.setLayout(new GridLayout(3, 2));
//        radioPanel.add(celsiusToFahr);
//        radioPanel.add(fahrToCelsius);
//        radioPanel.add(celsiusToKelv);
//        radioPanel.add(kelvToCelsius);
//        radioPanel.add(kelvToFahr);
//        radioPanel.add(fahrToKelv);
//        mainPanel.add(radioPanel);
//
//        // Label do wyświetlania wyniku
//        resultLabel = new JLabel("Wynik: ");
//        resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
//        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
//        mainPanel.add(Box.createVerticalStrut(10));
//        mainPanel.add(resultLabel);
//
//        // Listener na zmiany wartości i radio buttonów
//        ActionListener updateResultListener = e -> updateResult();
//        temperatureTextField.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyReleased(KeyEvent e) {
//                updateResult();
//            }
//        });
//
//        celsiusToFahr.addActionListener(updateResultListener);
//        fahrToCelsius.addActionListener(updateResultListener);
//        celsiusToKelv.addActionListener(updateResultListener);
//        kelvToCelsius.addActionListener(updateResultListener);
//        kelvToFahr.addActionListener(updateResultListener);
//        fahrToKelv.addActionListener(updateResultListener);
//    }
//
//    private void updateResult() {
//        double temperature;
//        try {
//            temperature = Double.parseDouble(temperatureTextField.getText());
//        } catch (NumberFormatException e) {
//            resultLabel.setText("Wpisano błędną temperaturę!");
//            return;
//        }
//
//        String message = "";
//        if (celsiusToFahr.isSelected()) {
//            double result = temperature * 1.8 + 32;
//            message = String.format("%.2f °C = %.2f °F", temperature, result);
//        } else if (fahrToCelsius.isSelected()) {
//            double result = (temperature - 32) / 1.8;
//            message = String.format("%.2f °F = %.2f °C", temperature, result);
//        } else if (celsiusToKelv.isSelected()) {
//            double result = temperature + 273.15;
//            message = String.format("%.2f °C = %.2f K", temperature, result);
//        } else if (kelvToCelsius.isSelected()) {
//            double result = temperature - 273.15;
//            message = String.format("%.2f K = %.2f °C", temperature, result);
//        } else if (kelvToFahr.isSelected()) {
//            double result = (temperature - 273.15) * 1.8 + 32;
//            message = String.format("%.2f K = %.2f °F", temperature, result);
//        } else if (fahrToKelv.isSelected()) {
//            double result = ((temperature - 32) / 1.8) + 273.15;
//            message = String.format("%.2f °F = %.2f K", temperature, result);
//        } else {
//            message = "Nie zaznaczono opcji przeliczania.";
//        }
//
//        resultLabel.setText("Wynik: " + message);
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> new TemperatureConversion().setVisible(true));
//    }
//}

