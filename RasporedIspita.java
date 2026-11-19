package aaaa;

import java.util.ArrayList;

public class RasporedIspita {
    private ArrayList<IspitniTermin> termini;

    public RasporedIspita() {
        termini = new ArrayList<>();
    }

    public void dodajTermin(IspitniTermin termin) {
        termini.add(termin);
    }

    public IspitniTermin nadjiTermin(String sifra) {
        for (IspitniTermin termin : termini) {
            if (termin.getSifraTermina().equals(sifra)) {
                return termin;
            }
        }

        return null; 
    }
    public ArrayList<IspitniTermin> getTermini() {
        return termini;
    }

    public void ispisiSveTermine() {
        for (IspitniTermin termin : termini) {
            System.out.println(termin);
        }
    }
}