
import javax.swing.*;
import java.awt.event.*;

public class CurrencyConverter extends JFrame implements ActionListener {
    private JComboBox<String> fromCurrency;
    private JComboBox<String> toCurrency;
    private JTextField inputField;
    private JButton convertButton;
    private JLabel resultLabel;

    public CurrencyConverter() {
        // Configura la ventana
        setTitle("Conversor de Monedas");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Añade los componentes
        fromCurrency = new JComboBox<>(new String[]{"USD", "EUR", "GBP"});
        toCurrency = new JComboBox<>(new String[]{"USD", "EUR", "GBP"});
        inputField = new JTextField(10);
        convertButton = new JButton("Convertir");
        resultLabel = new JLabel("Resultado");

        add(fromCurrency);
        add(toCurrency);
        add(inputField);
        add(convertButton);
        add(resultLabel);

        convertButton.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Obtén los valores seleccionados y la cantidad a convertir
        String from = (String) fromCurrency.getSelectedItem();
        String to = (String) toCurrency.getSelectedItem();
        double amount = Double.parseDouble(inputField.getText());
        double result = convertCurrency(amount, from, to);
        
        // Muestra el resultado
        resultLabel.setText(String.format("%.2f %s", result, to));
    }

    private double convertCurrency(double amount, String from, String to) {
        // Tasas de cambio simplificadas
        double rate = 1.0;
        if (from.equals("USD") && to.equals("EUR")) rate = 0.95;
        if (from.equals("EUR") && to.equals("USD")) rate = 1.05;
        if (from.equals("GBP") && to.equals("EUR")) rate = 1.10;
        if (from.equals("EUR") && to.equals("GBP")) rate = 0.91;
        // Agrega más tasas según sea necesario

        return amount * rate;
    }

    public static void main(String[] args) {
        new CurrencyConverter();
    }
}
