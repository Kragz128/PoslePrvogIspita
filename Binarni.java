package aaaaa;
import java.util.Scanner;

public class Binarni {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Unesite neki ranodm broj: ");
		int broj = sc.nextInt();
		
		String binarni ="" ;
		
		while (broj > 0) {
			int ostatak = broj % 2;
			binarni = ostatak + binarni;
			
			broj = broj / 2 ; 
		}
		
		System.out.println("Binarni zapis je : " + binarni );
	}
}
