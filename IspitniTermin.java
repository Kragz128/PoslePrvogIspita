package aaaa;

public class IspitniTermin {
    private String nazivPredmeta;
    private String sifraTermina;
    private String datum;
    private String oznakaSale;
    private int brojPrijavljenihStudenata;

    public IspitniTermin(String nazivPredmeta, String sifraTermina,
                         String datum, String oznakaSale,
                         int brojPrijavljenihStudenata) {
        this.nazivPredmeta = nazivPredmeta;
        this.sifraTermina = sifraTermina;
        this.datum = datum;
        this.oznakaSale = oznakaSale;
        this.brojPrijavljenihStudenata = brojPrijavljenihStudenata;
    }

    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    public String getSifraTermina() {
        return sifraTermina;
    }

    public String getDatum() {
        return datum;
    }

    public String getOznakaSale() {
        return oznakaSale;
    }

    public int getBrojPrijavljenihStudenata() {
        return brojPrijavljenihStudenata;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }

    public void setSifraTermina(String sifraTermina) {
        this.sifraTermina = sifraTermina;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public void setOznakaSale(String oznakaSale) {
        this.oznakaSale = oznakaSale;
    }

    public void setBrojPrijavljenihStudenata(int broj) {
        this.brojPrijavljenihStudenata = broj;
    }

    @Override
    public String toString() {
        return "Predmet: " + nazivPredmeta
                + ", šifra: " + sifraTermina
                + ", datum: " + datum
                + ", sala: " + oznakaSale
                + ", prijavljenih: " + brojPrijavljenihStudenata;
    }
}