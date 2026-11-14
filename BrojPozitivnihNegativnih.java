package vezbaPredIspit;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BrojPozitivnihNegativnih {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = ucitajBroj(sc, "a");
        int b = ucitajBroj(sc, "b");
        int c = ucitajBroj(sc, "c");

        int brojPozitivnih = 0;
        int brojNegativnih = 0;

        if (a > 0) brojPozitivnih++;
        else if (a < 0) brojNegativnih++;

        if (b > 0) brojPozitivnih++;
        else if (b < 0) brojNegativnih++;

        if (c > 0) brojPozitivnih++;
        else if (c < 0) brojNegativnih++;

        System.out.println("Broj pozitivnih brojeva: " + brojPozitivnih);
        System.out.println("Broj negativnih brojeva: " + brojNegativnih);

        sc.close();
    }

    public static int ucitajBroj(Scanner sc, String naziv) {
        while (true) {
            System.out.print("Unesite broj " + naziv + ": ");

            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ne možete uneti slovo. Unesite ceo broj.");
                sc.next(); 
            }
        }
    }
}