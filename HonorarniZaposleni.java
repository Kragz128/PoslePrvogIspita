package mmm;

public class HonorarniZaposleni extends Zaposleni { 
	  
	 public int brojSati; 
	 public float cijenaSata; 
	  
	  
	 public int getBrojSati() { 
	  return brojSati; 
	 } 
	 
	 public void setBrojSati(int brojSati) { 
	  this.brojSati = brojSati; 
	 } 
	 
	 public float getCijenaSata() { 
	  return cijenaSata; 
	 } 
	 
	 public void setCijenaSata(float cijenaSata) { 
	  this.cijenaSata = cijenaSata; 
	 } 
	  
	  
	 public HonorarniZaposleni(String ime, String prezime, int brojGodinaStaza, int 
	brojSati, float cijenaSata) { 
	  super(ime, prezime, brojGodinaStaza); 
	  this.setBrojSati(brojSati); 
	  this.setCijenaSata(cijenaSata); 
	 } 
	  
	 public HonorarniZaposleni() { 
	  this(null, null, 0, 0, 0); 
	 } 
	 
	 @Override 
	 public float iznosTroska() { 
	  return this.obracunPlate(); 
	 } 
	 
	 @Override 
	 public float obracunPlate() { 
	  return this.getBrojSati() * this.getCijenaSata(); 
	 } 
	 
	 @Override 
	 public String toString() { 
	  return "HonorarniZaposleni [brojSati=" + brojSati + ", cijenaSata=" + 
	cijenaSata + ", ime=" + getIme() 
	    + ", prezime=" + getPrezime() + ", brojGodinaStaza=" + 
	getBrojGodinaStaza() + "]"; 
	 } 
	} 