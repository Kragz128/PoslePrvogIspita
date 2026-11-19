package vezba1;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
    public static void main(String[] args) {
        ArrayList<Osoba> osobe = new ArrayList<>();

        while (true) {
            JTextField poljeIme = new JTextField();
            JTextField poljePrezime = new JTextField();
            JTextField poljeGodine = new JTextField();

            JPanel forma = new JPanel(new GridLayout(3, 2, 5, 5));
            forma.add(new JLabel("Ime:"));
            forma.add(poljeIme);
            forma.add(new JLabel("Prezime:"));
            forma.add(poljePrezime);
            forma.add(new JLabel("Godine:"));
            forma.add(poljeGodine);

            int izbor = JOptionPane.showConfirmDialog(
                    null,
                    forma,
                    "Unesi osobu",
                    JOptionPane.OK_CANCEL_OPTION
            );

            if (izbor != JOptionPane.OK_OPTION) {
                int izlaz = JOptionPane.showConfirmDialog(
                        null,
                        "Da li si siguran da želiš da zatvoriš program?",
                        "Potvrda izlaska",
                        JOptionPane.YES_NO_OPTION
                );

                if (izlaz == JOptionPane.YES_OPTION) {
                    break;
                }

                continue;
            }

            String ime = poljeIme.getText().trim();
            String prezime = poljePrezime.getText().trim();
            String godineTekst = poljeGodine.getText().trim();

            if (!ValidacijaPodataka.validnoImeIPrezime(ime)
                    || !ValidacijaPodataka.validnoImeIPrezime(prezime)
                    || !ValidacijaPodataka.validneGodine(godineTekst)) {

                JOptionPane.showMessageDialog(
                        null,
                        "Podaci nisu ispravni.\n"
                                + "Za pomoć se javite profesoru: "
                                + "stevan.cakic@udg.edu.me",
                        "Greška",
                        JOptionPane.ERROR_MESSAGE
                );
                continue;
            }

            int godine = Integer.parseInt(godineTekst);
            osobe.add(new Osoba(ime, prezime, godine));

            String prikaz = "";
            for (Osoba osoba : osobe) {
                prikaz += osoba + "\n";
            }

            JOptionPane.showMessageDialog(
                    null,
                    "Saved podaci:\n\n" + prikaz
            );
        }
    }
}