package pl.temperatureconversion.bartek.gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

public class TemperatureConversion extends JFrame {
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JRadioButton celsiusToFahr;
    private JRadioButton fahrToCelsius;
    private JLabel temperatureLabel;
    private JTextField temperatureTextField;
    private JButton calculateButton;

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

        temperatureTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyPressed = e.getKeyCode();
                if (KeyEvent.VK_ENTER == keyPressed) {
                    calculateTemperature();
                }
            }
        });

        calculateButton.addActionListener(new ActionListener() {

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
            JOptionPane.showMessageDialog(mainPanel, "Wpisano błędną temperaturę!", "Błąd!", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (celsiusToFahr.isSelected()) {
            double result = temperature * 1.8 + 32;
            String message = String.format("%.2f °C = %.2f °F", temperature, result);
            JOptionPane.showMessageDialog(mainPanel, message);
        } else if (fahrToCelsius.isSelected()) {
            double result = (temperature - 32) / 1.8;
            String message = String.format("%.2f °F = %.2f °C", temperature, result);
            JOptionPane.showMessageDialog(mainPanel, message);
        } else {
            String message = "Nie zaznaczono opcji przeliczania.";
            JOptionPane.showMessageDialog(mainPanel, message, "Błąd!", JOptionPane.ERROR_MESSAGE);
        }
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TemperatureConversion().setVisible(true));
    }
}
