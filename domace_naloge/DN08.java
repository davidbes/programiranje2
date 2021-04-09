import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public class DN08 {
    private static final String[] tipiParcel = { "TRAVNATA POVRSINA", "GOZDNA POVRSINA", "OBDELOVALNA POVRSINA",
            "BIVALNO POSLOPJE", "INDUSTRIJSKO POSLOPJE" };
    private static final double[] vrednostiTipovParcel = { 500.0, 750.0, 1000.0, 10000.0, 50000.0 };
    private static final int idxBivPoslopja = 3;
    private static final char[] visinskiZnaki = { ' ', '.', ':', '-', '=', '+', '*', '#', '%', '@' };
    public static final int[][] smeri = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // S V J Z

    public static void main(String[] args) {

        Locale.setDefault(Locale.ITALY); // Da uporabimo podobno lokalnost, ki jo uporablja Slovenija.
        if (args.length >= 1) {
            switch (args[0]) {
            case "analiza":
                if (args.length == 2) {
                    String fileName = args[1];

                    int[][] teren = preberiTeren(fileName);
                    int[] visine = prestejVisine(teren);

                    // Output
                    izrisTerena(teren);
                    for (int i = 0; i < visine.length; i++) {
                        System.out.printf("Visina %d: %dx\n", i, visine[i]);
                    }
                    System.out.printf("Povprecna visina: %.2f\n", povprecnaVisina(teren));
                }
                break;
            case "izrisi_poplavo":
                if (args.length == 4) {
                    String tipPoplave = args[1];
                    String datotekaTerena = args[2];
                    int[][] teren = preberiTeren(datotekaTerena);
                    double velikostPoplave = Double.parseDouble(args[3]);
                    izrisiPoplavo(teren, poplavljenTeren(teren, tipPoplave, velikostPoplave));
                }
                break;
            case "porocilo_skode":
                if (args.length == 5) {
                    String tipPoplave = args[1];
                    String datotekaTerena = args[2];
                    String datotekaParcel = args[3];
                    int[][] teren = preberiTeren(datotekaTerena);
                    int[][] tipParcele = preberiTipParcel(datotekaParcel);
                    double velikostPoplave = Double.parseDouble(args[4]);
                    porociloSkode(teren, tipParcele, poplavljenTeren(teren, tipPoplave, velikostPoplave));
                }
                break;
            case "nacrt_pobega":
                if (args.length == 5) {
                    String tipPoplave = args[1];
                    String datotekaTerena = args[2];
                    String datotekaParcel = args[3];
                    int[][] teren = preberiTeren(datotekaTerena);
                    int[][] tipParcele = preberiTipParcel(datotekaParcel);
                    double velikostPoplave = Double.parseDouble(args[4]);
                    nacrtPobega(teren, tipParcele, poplavljenTeren(teren, tipPoplave, velikostPoplave));
                }
                break;
            }

        }
    }

    public static boolean[][] poplavljenTeren(int[][] teren, String tipPoplave, double velikostPoplave) {
        switch (tipPoplave) {
        case "visinska":
            return visinskaPoplava(teren, velikostPoplave);
        case "kolicinska":
            return kolicinskaPoplava(teren, velikostPoplave);
        default:
            return visinskaPoplava(teren, velikostPoplave);
        }
    }

    public static int[][] preberiTeren(String datoteka) {
        int[][] teren = new int[0][0];
        int height;
        int width;
        try {
            Scanner sc = new Scanner(new File(datoteka));

            height = sc.nextInt();
            width = sc.nextInt();
            teren = new int[height][width];

            int i = 0, j = 0;
            while (sc.hasNext()) {
                teren[j][i++] = sc.nextInt();
                if (i == width) {
                    j++;
                    i = 0;
                }
            }
            sc.close();

        } catch (Exception e) {
            System.out.println("Napaka pri branju datoteke!");
            System.exit(0);
        }

        return teren;
    }

    public static void izrisTerena(int[][] teren) {
        for (int i = 0; i < teren.length; i++) {
            for (int j = 0; j < teren[i].length; j++) {
                System.out.print(visinskiZnaki[teren[i][j]]);
            }
            System.out.println("");
        }
    }

    public static double povprecnaVisina(int[][] teren) {
        int[] visine = prestejVisine(teren);
        int sum = 0;
        for (int i = 0; i < visine.length; i++) {
            sum += i * visine[i];
        }
        return (double) sum / (teren.length * teren[0].length);
    }

    public static int[] prestejVisine(int[][] teren) {
        int[] visine = new int[10];
        for (int i = 0; i < teren.length; i++) {
            for (int j = 0; j < teren[i].length; j++) {
                visine[teren[i][j]]++;
            }
        }
        return visine;
    }

    public static int[][] preberiTipParcel(String datoteka) {
        int[][] tipParcele = new int[0][0];
        int height;
        int width;
        try {
            Scanner sc = new Scanner(new File(datoteka));

            height = Integer.parseInt(sc.next());
            width = Integer.parseInt(sc.next());
            tipParcele = new int[height][width];

            sc.nextLine(); // Dokonca preberi prvo vrstico.

            int idx = 0;
            while (sc.hasNextLine()) {
                char[] znakci = sc.nextLine().toCharArray();
                int[] stevila = new int[height];
                for (int i = 0; i < stevila.length; i++) {
                    for (int j = 0; j < tipiParcel.length; j++) {
                        if (tipiParcel[j].startsWith(Character.toString(znakci[i]))) {
                            stevila[i] = j;
                        }
                    }
                }
                tipParcele[idx++] = stevila;
            }
            sc.close();
        } catch (Exception e) {
            System.out.println("Napaka pri branju datoteke!" + e);
            System.exit(0);
        }

        return tipParcele;
    }

    public static boolean[][] visinskaPoplava(int[][] teren, double visinaPoplave) {
        boolean[][] poplava = new boolean[teren.length][teren[0].length];
        for (int i = 0; i < teren.length; i++) {
            for (int j = 0; j < teren[i].length; j++) {
                poplava[i][j] = visinaPoplave > teren[i][j];
            }
        }
        return poplava;
    }

    public static boolean[][] kolicinskaPoplava(int[][] teren, double kolicina) {
        int[] presteteVisine = prestejVisine(teren);
        int prekritoObmocje = 0;
        for (int i = 0; i < presteteVisine.length; i++) {
            if (prekritoObmocje >= kolicina) {
                return visinskaPoplava(teren, i);
            }
            prekritoObmocje += prekritoObmocje + presteteVisine[i];
        }
        return visinskaPoplava(teren, presteteVisine.length);
    }

    public static void izrisiPoplavo(int[][] teren, boolean[][] poplava) {
        for (int i = 0; i < teren.length; i++) {
            for (int j = 0; j < teren[i].length; j++) {
                System.out.print(poplava[i][j] ? '~' : visinskiZnaki[teren[i][j]]);
            }
            System.out.println("");
        }
    }

    private static String repeatCharacterString(char znakec, int length) {
        String retString = "";
        for (int i = 0; i < length; i++) {
            retString += znakec;
        }
        return retString;
    }

    public static void porociloSkode(int[][] teren, int[][] tipParcele, boolean[][] poplava) {
        String divider = repeatCharacterString('-', 53);

        int[] poplavljeneParceleCounter = new int[tipiParcel.length];

        int vsePoplavljene = 0;
        double skupnaCena = 0;
        for (int i = 0; i < tipParcele.length; i++) {
            for (int j = 0; j < tipParcele[i].length; j++) {
                if (poplava[i][j]) {
                    poplavljeneParceleCounter[tipParcele[i][j]]++;
                    vsePoplavljene++;
                }
            }
        }
        System.out.printf("%21s%11s%21s\n", "Tip parcele", "Stevilo", "Ocenjena skoda");
        System.out.println(divider);
        for (int i = 0; i < poplavljeneParceleCounter.length; i++) {
            int steviloPoplav = poplavljeneParceleCounter[i];
            double cena = steviloPoplav * vrednostiTipovParcel[i];
            skupnaCena += cena;
            System.out.printf("%21s%11d%,17.2f EUR\n", tipiParcel[i], steviloPoplav, cena);
        }
        System.out.println(divider);
        System.out.printf("%21s%11d%,17.2f EUR\n", "SKUPAJ", vsePoplavljene, skupnaCena);
    }

    public static boolean lahkoPobegne(int[][] teren, boolean[][] poplava, int x, int y) {
        int pozX = x, pozY = y;
        int[] sosednjeVisine = new int[smeri.length];
        for (int i = 0; i < sosednjeVisine.length; i++) {
            int tempX = x + smeri[i][0];
            int tempY = y + smeri[i][1];
            try {
                if (teren[tempX][tempY] > teren[pozX][pozY]) {
                    pozX = tempX;
                    pozY = tempY;
                }
            } catch (IndexOutOfBoundsException e) {
                continue;
            }
        }
        if (pozX == x && pozY == y) {
            return !poplava[x][y];
        }
        return lahkoPobegne(teren, poplava, pozX, pozY);
    }

    public static void nacrtPobega(int[][] teren, int[][] tipParcele, boolean[][] poplava) {
        int varneHise = 0, lahkoPobegnejo = 0, potrebujejoPomoc = 0;
        for (int i = 0; i < tipParcele.length; i++) {
            for (int j = 0; j < tipParcele[i].length; j++) {
                if (tipParcele[i][j] == idxBivPoslopja) {
                    if (poplava[i][j]) {
                        if (lahkoPobegne(teren, poplava, i, j)) {
                            lahkoPobegnejo++;
                        } else {
                            potrebujejoPomoc++;
                        }
                    } else {
                        varneHise++;
                    }
                }
            }
        }
        System.out.printf("Varne hise: %d\n", varneHise);
        System.out.printf("Lahko pobegnejo: %d\n", lahkoPobegnejo);
        System.out.printf("Potrebujejo pomoc: %d\n", potrebujejoPomoc);
    }
}
