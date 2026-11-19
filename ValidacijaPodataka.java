package vezba1;

public class ValidacijaPodataka {

    public static boolean validnoImeIPrezime(String tekst) {
        return tekst.matches("[\\p{L}]+([ '-][\\p{L}]+)*");
    }

    public static boolean validneGodine(String tekst) {
        try {
            return Integer.parseInt(tekst) >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}