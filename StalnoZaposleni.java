package mmm;

public class StalnoZaposleni extends Zaposleni { 
	  
	 private float koeficijent; 
	  
	 
	 public float getKoeficijent() { 
	  return koeficijent; 
	 } 
	 
	 public void setKoeficijent(float koeficijent) { 
	  this.koeficijent = koeficijent; 
	 } 
	   
	 public StalnoZaposleni() { 
	  this(null, null, 0, 0); 
	 } 
	  
	 public StalnoZaposleni(String ime, String prezime, int brojGodinaStaza, float 
	koeficijent) { 
	  super(ime, prezime, brojGodinaStaza); 
	  this.setKoeficijent(koeficijent); 
	 } 
	 
	 @Override 
	 public float iznosTroska() { 
	  return this.obracunPlate(); 
	 } 
	 
	 @Override 
	 public float obracunPlate() { 
	 // Razmisliti o uvodjenju statickog atributa za osnovicu 
	  return this.getKoeficijent() * 600 + this.getBrojGodinaStaza() * 10; 
	 } 
	 
	 @Override 
	 public String toString() { 
	  return "StalnoZaposleni [koeficijent=" + koeficijent + ", ime=" + getIme() + 
	", prezime=" 
	    + getPrezime() + ", gbrojGodinaStaza=" + getBrojGodinaStaza() + "]"; 
	 } 
	  
	} 