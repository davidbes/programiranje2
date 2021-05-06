
public class Kviz03 {

    public static void main(String[] args) {
        int he = izracunajRPN("1 2 3 4 + * +");
        System.out.println(he);
    }

    public static int[] sestejPolinoma(int[] a, int[] b) {
        int[] bigTable = Math.max(a.length, b.length) == a.length ? a : b;
        int[] smallTable = Math.min(a.length, b.length) == b.length ? b : a;

        int[] polySum = new int[bigTable.length];

        for (int i = 0; i < bigTable.length; i++) {
            if (i >= smallTable.length) {
                polySum[i] = bigTable[i];
            } else {
                polySum[i] = bigTable[i] + smallTable[i];
            }
        }
        return polySum;
    }

    public static int[] zmnoziPolinoma(int[] a, int[] b) {
        int[] polyMult = new int[a.length + b.length - 1];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                polyMult[i + j] += a[i] * b[j];
            }
        }
        return polyMult;
    }

    private static String sortString(String str) {
        char[] charArray = str.toCharArray();
        java.util.Arrays.sort(charArray);
        return new String(charArray);
    }

    public static boolean jeAnagram(String prvaBeseda, String drugaBeseda, boolean zanemariVelikost) {
        if (prvaBeseda.length() != drugaBeseda.length() || prvaBeseda.equals(drugaBeseda)) {
            return false;
        }
        String str1 = sortString(zanemariVelikost ? prvaBeseda.toLowerCase() : prvaBeseda);
        String str2 = sortString(zanemariVelikost ? drugaBeseda.toLowerCase() : drugaBeseda);
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static String najdaljsiPalindrom(String niz, boolean presledki) {
        String currBest = "";
        for (int i = 0; i < niz.length(); i++) {
            char c = niz.charAt(i);
            for (int sodoLiho = 0; sodoLiho < 2; sodoLiho++) {
                String word = sodoLiho == 0 ? "" : Character.toString(c);
                int back = i - 1;
                int front = i + sodoLiho;
                while (back >= 0 && front < niz.length()) {
                    char bChar = niz.charAt(back);
                    char fChar = niz.charAt(front);
                    if (!presledki) {
                        if (bChar == ' ') {
                            word = bChar + word;
                            back--;
                            continue;
                        }
                        if (fChar == ' ') {
                            word += fChar;
                            front++;
                            continue;
                        }
                    }
                    if (bChar == fChar) {
                        word = bChar + word + fChar;
                        back--;
                        front++;
                    } else {
                        break;
                    }
                }
                currBest = word.length() > currBest.length() ? word : currBest;
            }
        }
        return currBest;
    }

    public static int izracunajRPN(String niz) {
        String[] signs = niz.split(" ");
        int[] stevila = new int[signs.length / 2 + 1];
        String[] operators = new String[signs.length / 2];
        for (int i = 0; i < signs.length; i++) {
            if (i < stevila.length) {
                stevila[i] = Integer.parseInt(signs[i]);
            } else {
                operators[i - stevila.length] = signs[i];
            }
        }

        int current_vrednost = stevila[stevila.length - 1];
        for (int i = stevila.length - 2; i >= 0; i--) {
            String operator = operators[operators.length - i - 1];
            switch (operator) {
                case "+":
                    current_vrednost = stevila[i] + current_vrednost;
                    break;
                case "-":
                    current_vrednost = stevila[i] + current_vrednost;
                    break;
                case "*":
                    current_vrednost = stevila[i] + current_vrednost;
                    break;
                case "/":
                    current_vrednost = stevila[i] + current_vrednost;
                    break;

                default:
                    break;
            }
        }
        return current_vrednost;
    }
}

class Tocka {
    private final int x;
    private final int y;

    Tocka(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Tocka[] preberiTocke(String imeDatoteke) {
        java.util.List<Tocka> listek = new java.util.ArrayList<Tocka>();
        try {
            java.util.Scanner sc = new java.util.Scanner(new java.io.File(imeDatoteke));
            while (sc.hasNext()) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                Tocka tocka = new Tocka(x, y);
                listek.add(tocka);
            }
            sc.close();
        } catch (Exception e) {
            System.exit(0);
        }
        return listek.toArray(new Tocka[0]);
    }

    public static String tabelaToString(Tocka[] tocke) {
        String returnStr = "[";
        for (int i = 0; i < tocke.length; i++) {
            Tocka tocka = tocke[i];
            returnStr += "(" + tocka.getX() + "," + tocka.getY() + ")" + (i == (tocke.length - 1) ? "" : ",");
        }
        returnStr += "]";
        return returnStr;
    }

    static double razdalja(Tocka t1, Tocka t2) {
        return Math.sqrt(Math.pow(t1.getX() - t2.getX(), 2) + Math.pow(t1.getY() - t2.getY(), 2));
    }

    public static void najblizji(Tocka[] t1, Tocka[] t2) {
        if (t1.length == 0) {
            System.out.println("Prva tabela ne vsebuje točk");
            return;
        }
        if (t2.length == 0) {
            System.out.println("Druga tabela ne vsebuje točk");
            return;
        }
        int iT1 = 0;
        int iT2 = 0;
        double currMinRazdalja = razdalja(t1[0], t2[0]);

        for (int i = 0; i < t1.length; i++) {
            for (int j = 0; j < t2.length; j++) {
                double razdalja = razdalja(t1[i], t2[j]);
                if (razdalja < currMinRazdalja) {
                    iT1 = i;
                    iT2 = j;
                    currMinRazdalja = razdalja;
                }
            }
        }
        Tocka tocka1 = t1[iT1];
        Tocka tocka2 = t2[iT2];

        System.out.printf("Najbližji točki sta Tocka (%d, %d) in Tocka (%d, %d), razdalja med njima je %.2f",
                tocka1.getX(), tocka1.getY(), tocka2.getX(), tocka2.getY(), currMinRazdalja);

    }
}

class Matrika {
    final int velikostMatrike;
    final int[][] koeficienti;

    Matrika(int velikost, int[][] koeficienti) {
        this.velikostMatrike = velikost;
        this.koeficienti = koeficienti;
    }

    static Matrika preberiMartiko(String imeDatotake) {
        try {
            java.util.Scanner sc = new java.util.Scanner(new java.io.File(imeDatotake));
            int size = sc.nextInt();
            int idx = 0;
            int idy = 0;
            int[][] table = new int[size][size];
            while (sc.hasNextInt()) {
                table[idy][idx] = sc.nextInt();
                idx++;
                if (idx == size) {
                    idx = 0;
                    idy++;
                }
            }
            sc.close();
            return new Matrika(size, table);
        } catch (Exception e) {
            System.out.println("Napaka pri branju datoteke");
        }
        return new Matrika(0, new int[0][0]);
    }

    public Matrika zmnozi(Matrika m2) {
        int[][] a = this.koeficienti;
        int[][] b = m2.koeficienti;

        if (this.velikostMatrike != m2.velikostMatrike) {
            System.out.println("Matriki nista enakih dimenzij");
        }
        int[][] c = new int[this.velikostMatrike][this.velikostMatrike];
        for (int i = 0; i < this.velikostMatrike; i++) {
            for (int j = 0; j < this.velikostMatrike; j++) {
                c[i][j] = 0;
                for (int k = 0; k < this.velikostMatrike; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return new Matrika(this.velikostMatrike, c);
    }

    public void izpisi() {
        for (int[] vrsta : this.koeficienti) {
            for (int x : vrsta) {
                System.out.printf(" %2d", x);
            }
            System.out.println();
        }
    }
}

class Kompleksno {
    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    private String ime;
    private double a;
    private double b;

    Kompleksno(String ime, double a, double b) {
        this.ime = ime;
        this.a = a;
        this.b = b;
    }

    Kompleksno(double a, double b) {
        this("xx", a, b);
    }

    public double velikost() {
        return Math.sqrt(Math.pow(getA(), 2) + Math.pow(getB(), 2));
    }

    public void pristej(Kompleksno drugoSt) {
        setA(getA() + drugoSt.getA());
        setB(getB() + drugoSt.getB());
    }

    public void pomnozi(Kompleksno drugoSt) {
        double a = getA() * drugoSt.getA() - getB() * drugoSt.getB();
        double b = getA() * drugoSt.getB() + getB() * drugoSt.getA();
        setA(a);
        setB(b);
    }

    @Override
    public String toString() {
        return String.format("%s = (%.3f + %.3f*i)", this.ime, this.a, this.b);
    }
}