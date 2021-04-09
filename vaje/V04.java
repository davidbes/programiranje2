
import java.util.Random;
import java.util.Scanner;

public class V04 {
    // dovoljeno število ugibanj
    private static final int MAX_NAPAK = 10;

    // seznama besed za uganjevanje: iskan stavek sestavimo iz dveh delov,
    // prvega iz seznama 'osebek' in drugega iz seznama 'povedek'
    private static final String[] osebek = { "SONCE", "TRAVA", "KOLESAR", "ZIDAR", "METLA", "VRTNICA", "ULICA",
            "SABLJA", "NETOPIR", "KOLOVRAT", "OTROK", "BABICA", "PROGRAMER", "ZVEZEK", "RACUNALNIK", "ZEMLJA" };
    private static final String[] povedek = { "SIJE", "RASTE", "DRVI", "ZIDA", "POMETA", "CVETI", "SMUCA", "SKACE",
            "SE ZOGA", "LIKA", "PROGRAMIRA", "RAZGRAJA", "MIRNO SPI", "NE POCIVA", "NIMA SRECE", "SE VRTI", "KIHA",
            "KUHA", "RAZPRAVLJA", "ZAVZETO STUDIRA" };

    // stavek, ki ga uganjujemo
    private static String stavek;

    // katere crke smo ze uganili
    private static boolean uganil[];

    // koliko napak smo že naredili pri uganjevanju
    private static int steviloNapak;

    private static void novaIgra() {
        Random rnd = new Random();
        stavek = osebek[rnd.nextInt(osebek.length)] + " " + povedek[rnd.nextInt(povedek.length)];
        uganil = new boolean[stavek.length()];
        for (int i = 0; i < stavek.length(); i++) {
            uganil[i] = stavek.charAt(i) == ' ';
        }
        steviloNapak = 0;
    }

    private static boolean jeUganil() {
        for (boolean b : uganil) {
            if (!b)
                return false;
        }
        return true;
    }

    private static void izpisiUganko() {
        for (int i = 0; i < uganil.length; i++) {
            System.out.print(uganil[i] ? stavek.charAt(i) : ".");
        }
        System.out.println();
    }

    private static void postaviVprasanje() {
        Scanner sc = new Scanner(System.in);
        System.out.printf("Imate še %d poskusov: ", MAX_NAPAK - steviloNapak);
        String input = sc.nextLine();

        if (input.length() >= stavek.length()) {
            if (input.toUpperCase().equals(stavek.toUpperCase())) {
                for (int i = 0; i < uganil.length; i++) {
                    uganil[i] = true;
                }
            } else {
                steviloNapak = MAX_NAPAK;
            }
        }

        if (input.length() != 0) {
            boolean smoNasliVsajEno = false;
            char c = input.toUpperCase().charAt(0);
            for (int i = 0; i < stavek.length(); i++) {
                if (c == stavek.charAt(i)) {
                    uganil[i] = (smoNasliVsajEno = true);
                }
            }
            if (!smoNasliVsajEno) {
                steviloNapak++;
            }
        }
    }

    public static void main(String[] args) {
        novaIgra();
        while ((steviloNapak < MAX_NAPAK) && !jeUganil()) {
            izpisiUganko();
            postaviVprasanje();
        }
        System.out.println();
        if (jeUganil()) {
            System.out.println("Bravo");
        } else {
            System.out.printf("Pravilen odgovor: %s\n", stavek);
        }
        System.exit(0);
    }
}
