package vezba2;

import java.awt.EventQueue;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Prozor extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;
    private JTextField textField;      
    private JTextField textField_1;     
    private JTextField textField_2; 
    private JTextField textField_3;     

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Prozor frame = new Prozor();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Prozor() {
        setTitle("Konverter valuta");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 200);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblEur = new JLabel("EUR:");
        lblEur.setBounds(10, 26, 40, 20);
        contentPane.add(lblEur);

        JLabel lblUsd = new JLabel("USD:");
        lblUsd.setBounds(10, 48, 40, 20);
        contentPane.add(lblUsd);

        JLabel lblRsd = new JLabel("RSD:");
        lblRsd.setBounds(10, 70, 40, 20);
        contentPane.add(lblRsd);

        textField = new JTextField();
        textField.setBounds(50, 25, 90, 20);
        contentPane.add(textField);

        textField_1 = new JTextField();
        textField_1.setBounds(50, 48, 90, 20);
        contentPane.add(textField_1);

        textField_2 = new JTextField();
        textField_2.setBounds(50, 71, 90, 20);
        contentPane.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setEditable(false);
        textField_3.setBounds(165, 25, 250, 65);
        contentPane.add(textField_3);

        JButton btnIzracunaj = new JButton("Izračunaj");
        btnIzracunaj.setBounds(50, 110, 100, 25);
        btnIzracunaj.addActionListener(e -> izracunaj());
        contentPane.add(btnIzracunaj);

        JButton btnNoviUnos = new JButton("Novi unos");
        btnNoviUnos.setBounds(165, 110, 100, 25);
        btnNoviUnos.addActionListener(e -> ocistiPolja());
        contentPane.add(btnNoviUnos);
    }

    private void izracunaj() {
        String eurUnos = textField.getText().trim();
        String usdUnos = textField_1.getText().trim();
        String rsdUnos = textField_2.getText().trim();

        int brojUnosa = 0;
        if (!eurUnos.isEmpty()) brojUnosa++;
        if (!usdUnos.isEmpty()) brojUnosa++;
        if (!rsdUnos.isEmpty()) brojUnosa++;

        if (brojUnosa != 1) {
            JOptionPane.showMessageDialog(
                    this,
                    "Unesi iznos samo u jedno polje: EUR, USD ili RSD."
            );
            return;
        }

        try {
            double eur;

            if (!eurUnos.isEmpty()) {
                eur = procitajIznos(eurUnos);
            } else if (!usdUnos.isEmpty()) {
                eur = procitajIznos(usdUnos) / 1.09;
            } else {
                eur = procitajIznos(rsdUnos) / 117.0;
            }

            double usd = eur * 1.09;
            double rsd = eur * 117.0;

            textField.setText(String.format(Locale.US, "%.2f", eur));
            textField_1.setText(String.format(Locale.US, "%.2f", usd));
            textField_2.setText(String.format(Locale.US, "%.2f", rsd));

            textField_3.setText(String.format(
                    Locale.US,
                    "EUR: %.2f | USD: %.2f | RSD: %.2f",
                    eur, usd, rsd
            ));

            String json = String.format(
                    Locale.US,
                    "{\n  \"eur\": %.2f,\n  \"usd\": %.2f,\n  \"rsd\": %.2f\n}",
                    eur, usd, rsd
            );

            Files.write(
                    Paths.get("konverzija.json"),
                    json.getBytes(StandardCharsets.UTF_8)
            );

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Unesi ispravan nenegativan iznos."
            );
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Greška pri čuvanju JSON fajla: " + e.getMessage()
            );
        }
    }

    private double procitajIznos(String tekst) {
        double iznos = Double.parseDouble(tekst.replace(',', '.'));

        if (iznos < 0 || Double.isNaN(iznos) || Double.isInfinite(iznos)) {
            throw new NumberFormatException();
        }

        return iznos;
    }

    private void ocistiPolja() {
        textField.setText("");
        textField_1.setText("");
        textField_2.setText("");
        textField_3.setText("");
    }
}