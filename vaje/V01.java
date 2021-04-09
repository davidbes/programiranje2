
public class V01 {
    public static void main(String[] args) {
        // smreka(3);
        // trikotnik(4, 10);
        trikotnikV(0, 10);
        // romb(4, 5);
        smreka(4);
    }

    static void pravokotnik(int odmik, int sirina, int visina) {
        for (int i = 0; i < visina; i++) {
            // Loop za pisanje znakov v vrstico.
            for (int j = 0; j < odmik; j++) {
                System.out.print(".");
            }

            // Loop za pisanje lojtrc v vrstico.
            for (int j = 0; j < sirina; j++) {
                System.out.print("#");
            }
            // Print new line, da bo vsaka vrstica v svoj stolpec.
            System.out.println();
        }
    }

    static void trikotnik(int odmik, int visina) {
        for (int i = 0; i < visina; i++) {
            // Odmik
            for (int j = 1; j < odmik + visina - i; j++) {
                System.out.print(".");
            }

            // Narisemo zvezdic
            for (int j = 0; j < i * 2 + 1; j++) {
                System.out.print("#");
            }

            System.out.println();

        }
    }

    static void trikotnikV(int odmik, int visina) {
        for (int i = 0; i < visina; i++) {
            for (int j = 0; j < odmik + i; j++) {
                System.out.print(".");
            }
            for (int j = visina * 2 - i * 2 - 1; j > 0; j--) {
                System.out.print("#");
            }
            System.out.println();
        }
    };

    static void romb(int odmik, int velikost) {
        trikotnik(odmik, velikost);
        trikotnikV(odmik + 1, velikost - 1);
    }

    static void smreka(int velikost) {
        for (int i = 0; i < velikost; i++) {
            trikotnik(velikost - i - 1, 2 + i);
        }
        pravokotnik(velikost / 2 + 1, velikost % 2 == 1 ? velikost : velikost - 1, 2 * velikost);
    }

    // TODO dodatno
}