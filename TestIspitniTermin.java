package aaaaa;

import java.util.ArrayList;

public class TestIspitniTermin {

    public static void main(String[] args) {
        IspitniTermin termin1 = new IspitniTermin(
                "Matematika", "MAT101", "10.06.2026. 09:00", "A1", 25
        );

        ArrayList<IspitniTermin> termini = new ArrayList<>();
        termini.add(termin1);
        termini.add(new IspitniTermin(
                "Baze podataka", "BP101", "15.06.2026. 10:00", "C3", 18
        ));

        System.out.println("=== ISPITNI TERMINI ===");
        for (IspitniTermin termin : termini) {
            System.out.println("------------------------------");
            System.out.printf("Predmet:        %s%n", termin.getNazivPredmeta());
            System.out.printf("Šifra termina:  %s%n", termin.getSifraTermina());
            System.out.printf("Datum i vreme:  %s%n", termin.getDatumVremeTermina());
            System.out.printf("Sala:           %s%n", termin.getOznakaSale());
            System.out.printf("Prijavljenih:   %d%n",
                    termin.getBrojPrijavljenihStudenata());
        }

        String sifra = "BP101";
        System.out.println("\n=== PRETRAGA TERMINA: " + sifra + " ===");
        System.out.printf("Sala: %s%n", IspitniTermin.nadjiSalu(termini, sifra));
        System.out.printf("Broj prijavljenih studenata: %d%n",
                IspitniTermin.nadjiBrojPrijavljenihStudenata(termini, sifra));

        String nepostojecaSifra = "NEPOSTOJECA";
        System.out.println("\n=== PRETRAGA TERMINA: " + nepostojecaSifra + " ===");

        int broj = IspitniTermin.nadjiBrojPrijavljenihStudenata(
                termini, nepostojecaSifra
        );

        if (broj == -1) {
            System.out.println("Termin nije pronađen.");
        } else {
            System.out.printf("Sala: %s%n",
                    IspitniTermin.nadjiSalu(termini, nepostojecaSifra));
            System.out.printf("Broj prijavljenih studenata: %d%n", broj);
        }
    }
}