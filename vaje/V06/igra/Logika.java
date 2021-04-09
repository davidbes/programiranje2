package igra;

import java.util.Random;

public class Logika {
    private static final int ZACETNO_STEVILO_PLOSCIC = 2;
    private static final int ZMAGOVALNI_POGOJ = 2048;

    private static int[][] polja;
    private static int velikostPolja;
    private static int tocke;
    private static boolean konec;

    /**
     * Pričnemo novo igro. Naredimo velikost tabele, nastavimo točke na 0 in
     * pričnemo igro
     * 
     * @param velikost - določa velikost polja velikost x velikost
     */
    public static void zacniNovoIgro(int velikost) {
        polja = new int[velikost][velikost];
        tocke = 0;
        konec = false;
        velikostPolja = velikost;

        for (int i = 0; i < ZACETNO_STEVILO_PLOSCIC; i++) {
            dodajPloscico();
        }
    }

    private static void dodajPloscico() {
        Random rnd = new Random();
        double moznostiZaPloscico = rnd.nextInt(10);
        int iPolje = rnd.nextInt(velikostPolja);
        int jPolje = rnd.nextInt(velikostPolja);
        if (polja[iPolje][jPolje] == 0) {
            polja[iPolje][jPolje] = moznostiZaPloscico < 9 ? 2 : 4;
        } else {
            dodajPloscico();
        }

    }

    public static void koncajIgro() {
        if (konec) {
            System.exit(0);
        }
        konec = true;
    }

    /**
     * Vrnemo velikost ploščice na polja[i][j] polju.
     * 
     * @param i
     * @param j
     * @return
     */
    public static int vrniPloscico(int i, int j) {
        if (i < velikostPolja && j < velikostPolja && i >= 0 && j >= 0) {
            return polja[i][j];
        }
        return 0;
    }

    public static int vrniTocke() {
        return tocke;
    }

    public static boolean jeZmagal() {
        if (tocke >= ZMAGOVALNI_POGOJ) {
            return true;
        }
        return false;
    }

    public static boolean jeKonec() {
        return konec;
    }

    public static void naslednjaPoteza(int smer) {

        switch (smer) {
        case 1:

            break;
        case 2:

            break;

        case 3:

            break;

        case 4:

            break;

        default:
            break;
        }
    }

    // private static boolean premikLevo() {
    // for (int i = 0; i < polja.length; i++) {
    // // Za vsako vrstico naredi ločeno premik v levo;
    // int j = 0;
    // while (j < polja.length) {
    // if()
    // }
    // }
    // }

}
