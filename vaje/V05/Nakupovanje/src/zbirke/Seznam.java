package zbirke;

public class Seznam {
    private static int dolzinaSeznama;
    private static String[] seznam;

    public static boolean narediSeznam(int n) {
        if (seznam != null || n <= 0) {
            return false;
        }
        seznam = new String[n];
        dolzinaSeznama = 0;
        return seznam.length == n;
    }

    public static boolean dodajNaKonecSeznama(String element) {
        if (seznam == null || dolzinaSeznama == seznam.length) {
            return false;
        }
        seznam[dolzinaSeznama++] = element;
        return true;
    }

    public static void izpisiSeznam() {
        if (seznam == null) {
            System.out.println("NAPAKA: Seznam ne obstaja.");
        } else if (seznam.length == 0) {
            System.out.println("Seznam je prazen (nima elementov).");
        } else {
            System.out.println("Na seznamu so naslednji elementi:");
            for (int i = 0; i < seznam.length; i++) {
                System.out.printf("%d: %s\n", i + 1, seznam[i]);
            }
        }
    }

    public static String odstraniIzSeznama(int mesto) {
        // Prevermo če smo out of range in če smo preko obstoječega seznama naenkrat.
        if (mesto > dolzinaSeznama || mesto == 0 || seznam == null) {
            return null;
        }
        // Spravimo element, ki ga brišemo v spremenljivko.
        String retString = seznam[mesto - 1];

        // Nastavimo ta element na null in zmanjšamo velikost seznama.
        seznam[mesto - 1] = null;
        dolzinaSeznama--; // To je prazvaprav index elementa, ki ga moramo odstraniti še na koncu.

        for (int i = mesto - 1; i < dolzinaSeznama; i++) {
            seznam[i] = seznam[i + 1];
        }
        seznam[dolzinaSeznama] = null;

        return retString;
    }

    public static boolean dodajVSeznam(String element, int mesto) {
        if (mesto >= seznam.length || mesto == 0 || seznam == null) {
            return false;
        }
        if (mesto >= dolzinaSeznama) {
            return dodajNaKonecSeznama(element);
        }

        for (int i = dolzinaSeznama; i >= mesto; i--) {
            seznam[i] = seznam[i - 1];
        }
        seznam[mesto - 1] = element;
        dolzinaSeznama++;

        return true;
    }

    public static int dolzinaSeznama() {
        return seznam == null ? -1 : seznam.length;
    }

    public static boolean uniciSeznam() {
        if (seznam == null) {
            return false;
        }
        dolzinaSeznama = 0;
        seznam = null;
        return true;
    }
}
