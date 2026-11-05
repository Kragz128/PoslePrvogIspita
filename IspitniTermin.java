package aaaaa;

import java.util.ArrayList;

public class IspitniTermin {
	public String nazivPredmeta;
	public String sifraTermina;
	public String datumVremeTermina;
	public String oznakaSale;
	public int brojPrijavljenihStudenata;
	
	
	

	@Override
	public String toString() {
		return "IspitniTermin [nazivPredmeta=" + nazivPredmeta + ", sifraTermina=" + sifraTermina
				+ ", datumVremeTermina=" + datumVremeTermina + ", oznakaSale=" + oznakaSale
				+ ", brojPrijavljenihStudenata=" + brojPrijavljenihStudenata + "]";
	}




	public IspitniTermin(String nazivPredmeta, String sifraTermina, String datumVremeTermina, String oznakaSale,
			int brojPrijavljenihStudenata) {
		super();
		this.nazivPredmeta = nazivPredmeta;
		this.sifraTermina = sifraTermina;
		this.datumVremeTermina = datumVremeTermina;
		this.oznakaSale = oznakaSale;
		this.brojPrijavljenihStudenata = brojPrijavljenihStudenata;
	}




	public String getNazivPredmeta() {
		return nazivPredmeta;
	}




	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}




	public String getSifraTermina() {
		return sifraTermina;
	}




	public void setSifraTermina(String sifraTermina) {
		this.sifraTermina = sifraTermina;
	}




	public String getDatumVremeTermina() {
		return datumVremeTermina;
	}




	public void setDatumVremeTermina(String datumVremeTermina) {
		this.datumVremeTermina = datumVremeTermina;
	}




	public String getOznakaSale() {
		return oznakaSale;
	}




	public void setOznakaSale(String oznakaSale) {
		this.oznakaSale = oznakaSale;
	}




	public int getBrojPrijavljenihStudenata() {
		return brojPrijavljenihStudenata;
	}




	public void setBrojPrijavljenihStudenata(int brojPrijavljenihStudenata) {
		this.brojPrijavljenihStudenata = brojPrijavljenihStudenata;
	}

	public static String nadjiSalu(ArrayList<IspitniTermin> termini, String sifraTermina) {
		for (IspitniTermin termin : termini) {
			if (termin.getSifraTermina().equals(sifraTermina)) {
				return termin.getOznakaSale();
			}
		}
		return null; 
	}
	
	public static int nadjiBrojPrijavljenihStudenata(ArrayList<IspitniTermin> termini, String sifraTermina) {
		for (IspitniTermin termin : termini) {
			if (termin.getSifraTermina().equals(sifraTermina)) {
				return termin.getBrojPrijavljenihStudenata();
			}
		}
		return -1;
	}
}
