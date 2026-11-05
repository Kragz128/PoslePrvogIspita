package aaaaa;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner unos = new Scanner(System.in);

        System.out.print("Unesi datum (mesec/dan/godina): ");
        String datum = unos.nextLine();

        int prvaKosaCrta = datum.indexOf("/");
        int drugaKosaCrta = datum.indexOf("/", prvaKosaCrta + 1);

        String mesec = datum.substring(0, prvaKosaCrta);
        String dan = datum.substring(prvaKosaCrta + 1, drugaKosaCrta);
        String godina = datum.substring(drugaKosaCrta + 1);

        System.out.println("Uneti datum: " + datum);
        System.out.println("Pretvoren datum: " + dan + "-" + mesec + "-" + godina);

        unos.close();
    }
}