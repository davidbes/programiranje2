public class Sah {
    static int beliKralj = 0x2654;
    static int crniKralj = 0x265A;

    static char[] vrniTabelo(int odKje, int koliko) {
        char[] rezultat = new char[koliko];

        for (int i = 0; i < koliko; i++)
            rezultat[i] = (char) (odKje + i);

        return rezultat;
    }

    static void napolniSahovnico(char[][] sahovnica, char[] beleFigure, char[] crneFigure) {

    }

    static void igraj() {
        char[][] sahovnica = new char[8][8];

        char[] beleFigure = vrniTabelo(beliKralj, 6);
        char[] crneFigure = vrniTabelo(crniKralj, 6);

        napolniSahovnico(sahovnica, beleFigure, crneFigure);

    }

    public static void main(String[] args) {
        igraj();

    }
}