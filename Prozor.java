package mrnjaooo;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Prozor extends JPanel {

    private static final long serialVersionUID = 1L;

    private JTextField polje1 = new JTextField("0");
    private JTextField polje2 = new JTextField("0");
    private JTextField polje3 = new JTextField("0");
    private JTextField polje4 = new JTextField("0");
    private JTextField poljeRezultat = new JTextField("0");

    private JLabel lblOperacija = new JLabel("+");

    private JCheckBox cbSaberi = new JCheckBox("Saberi");
    private JCheckBox cbOduzmi = new JCheckBox("Oduzmi");
    private JCheckBox cbPomnozi = new JCheckBox("Pomnozi");
    private JCheckBox cbPodeli = new JCheckBox("Podeli");

    public Prozor() {
        setLayout(null);
        setPreferredSize(new Dimension(565, 360));

        JLabel naslov = new JLabel("Kalkulator");
        naslov.setBounds(260, 15, 100, 25);
        add(naslov);

        polje1.setBounds(110, 50, 38, 24);
        polje2.setBounds(202, 50, 38, 24);
        polje3.setBounds(298, 50, 38, 24);
        polje4.setBounds(386, 50, 38, 24);

        add(polje1);
        add(polje2);
        add(polje3);
        add(polje4);

        JLabel deljenje1 = new JLabel("/");
        deljenje1.setBounds(174, 50, 15, 24);
        add(deljenje1);

        lblOperacija.setBounds(266, 50, 15, 24);
        add(lblOperacija);

        JLabel deljenje2 = new JLabel("/");
        deljenje2.setBounds(357, 50, 15, 24);
        add(deljenje2);

        cbSaberi.setBounds(35, 105, 120, 25);
        cbOduzmi.setBounds(35, 150, 120, 25);
        cbPomnozi.setBounds(35, 195, 120, 25);
        cbPodeli.setBounds(35, 240, 120, 25);

        add(cbSaberi);
        add(cbOduzmi);
        add(cbPomnozi);
        add(cbPodeli);

        cbSaberi.addActionListener(e -> izaberiOperaciju(cbSaberi, "+"));
        cbOduzmi.addActionListener(e -> izaberiOperaciju(cbOduzmi, "-"));
        cbPomnozi.addActionListener(e -> izaberiOperaciju(cbPomnozi, "*"));
        cbPodeli.addActionListener(e -> izaberiOperaciju(cbPodeli, "/"));

        JButton btnIzracunaj = new JButton("Izračunaj");
        btnIzracunaj.setBounds(310, 105, 120, 35);
        btnIzracunaj.addActionListener(e -> izracunaj());
        add(btnIzracunaj);

        JButton btnZatvori = new JButton("Zatvori");
        btnZatvori.setBounds(310, 155, 120, 35);
        btnZatvori.addActionListener(e -> System.exit(0));
        add(btnZatvori);

        JButton btnObrisi = new JButton("Obriši");
        btnObrisi.setBounds(310, 205, 120, 35);
        btnObrisi.addActionListener(e -> obrisi());
        add(btnObrisi);

        JLabel lblRezultat = new JLabel("Rezultat:");
        lblRezultat.setBounds(180, 270, 75, 25);
        add(lblRezultat);

        poljeRezultat.setEditable(false);
        poljeRezultat.setBounds(255, 270, 120, 25);
        add(poljeRezultat);

        cbSaberi.setSelected(true);
    }

    private void izaberiOperaciju(JCheckBox izabrani, String znak) {
        cbSaberi.setSelected(izabrani == cbSaberi);
        cbOduzmi.setSelected(izabrani == cbOduzmi);
        cbPomnozi.setSelected(izabrani == cbPomnozi);
        cbPodeli.setSelected(izabrani == cbPodeli);

        lblOperacija.setText(znak);
    }

    private void izracunaj() {
        try {
            double broj1 = procitajBroj(polje1);
            double broj2 = procitajBroj(polje2);
            double broj3 = procitajBroj(polje3);
            double broj4 = procitajBroj(polje4);

            if (broj2 == 0 || broj4 == 0) {
                JOptionPane.showMessageDialog(this, "Ne može se deliti nulom.");
                return;
            }

            double levaStrana = broj1 / broj2;
            double desnaStrana = broj3 / broj4;
            double rezultat;

            if (cbSaberi.isSelected()) {
                rezultat = levaStrana + desnaStrana;
            } else if (cbOduzmi.isSelected()) {
                rezultat = levaStrana - desnaStrana;
            } else if (cbPomnozi.isSelected()) {
                rezultat = levaStrana * desnaStrana;
            } else {
                if (desnaStrana == 0) {
                    JOptionPane.showMessageDialog(this, "Ne može se deliti nulom.");
                    return;
                }
                rezultat = levaStrana / desnaStrana;
            }

            poljeRezultat.setText(String.format(Locale.US, "%.2f", rezultat));

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Unesi ispravne brojeve u sva četiri polja.");
        }
    }

    private double procitajBroj(JTextField polje) {
        return Double.parseDouble(polje.getText().trim().replace(',', '.'));
    }

    private void obrisi() {
        polje1.setText("0");
        polje2.setText("0");
        polje3.setText("0");
        polje4.setText("0");
        poljeRezultat.setText("0");

        cbSaberi.setSelected(true);
        cbOduzmi.setSelected(false);
        cbPomnozi.setSelected(false);
        cbPodeli.setSelected(false);

        lblOperacija.setText("+");
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame prozor = new JFrame("Kalkulator");
            prozor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            prozor.setContentPane(new Prozor());
            prozor.pack();
            prozor.setLocationRelativeTo(null);
            prozor.setVisible(true);
        });
    }
}