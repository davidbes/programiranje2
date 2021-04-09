
public class Kviz02 {
    public static void main(String[] args) {
        izpisKoledarja(2021, 4);
    }

    public static int[] unija(int[] tabela1, int[] tabela2) {
        int[] unija = new int[tabela1.length + tabela2.length];
        for (int i = 0; i < tabela1.length; i++) {
            unija[i] = tabela1[i];
        }
        for (int i = 0; i < tabela2.length; i++) {
            unija[i + tabela1.length] = tabela2[i];
        }
        return unija;
    }

    public static int[] presek(int[] tabela1, int[] tabela2) {
        int[] presekec = new int[10];
        return presekec;
    }

    public static int[] range(int a, int b, int c) {
        int x = 0;
        while ((a + x * c) < b) {
            x++;
        }
        int[] size = new int[x];
        for (int i = 0; i < x; i++) {
            size[i] = a + i * c;
        }
        return size;
    }

    public static void rotiraj(int[] tabela, int k) {
        while (k-- > 0) {
            int[] copy = tabela.clone();
            tabela[copy.length - 1] = copy[0];
            for (int i = 0; i < copy.length - 1; i++) {
                tabela[i] = copy[i + 1];
            }
        }
    }

    public static int[] duplikati(int[] tabela) {
        int stUnikatov = 0;
        int[] novaTabela = new int[tabela.length];
        boolean duplicated = false;
        for (int i = 0; i < tabela.length; i++) {
            // Check the same array up to this element.
            for (int j = 0; j < i; j++) {
                if (tabela[i] == tabela[j]) {
                    duplicated = true;
                    break;
                }
            }
            // If we haven't found a duplicate incremenet and add the elemenet to empty
            // int[]
            if (!duplicated) {
                novaTabela[stUnikatov++] = tabela[i];
            }
            duplicated = false;
        }
        // Generate new int[] with the size of amount of uniques.
        int[] ret = new int[stUnikatov];
        for (int i = 0; i < stUnikatov; i++) {
            ret[i] = novaTabela[i];
        }
        return ret;
    }

    public static double koren(int x, int d) {
        double koren = 1;
        // Celi del korena.
        while (koren * koren < x) {
            double cKoren = koren + 1;
            if (koren * koren == x) {
                return koren;
            }
            if ((cKoren) * (cKoren) > x) {
                break;
            }
            koren++;
        }

        // Decimalke korena. aka Natančnost.
        for (int i = 1; i <= d; i++) {
            int idx = 0;
            while ((koren + idx / Math.pow(10, i)) * (koren + idx / Math.pow(10, i)) < x) {
                double cKoren = (koren + idx / Math.pow(10, i)) + 1 / Math.pow(10, i);
                if (cKoren * cKoren > x) {
                    break;
                }
                idx++;
            }
            koren = (koren + idx / Math.pow(10, i));
        }

        return koren;
    }

    public static String binarnoSestej(String s, String b) {
        int len1 = s.length();
        int len2 = b.length();
        int carry = 0;
        String res = "";
        int maxLen = Math.max(len1, len2);
        for (int i = 0; i < maxLen; i++) {
            int p = i < len1 ? s.charAt(len1 - 1 - i) - '0' : 0;
            int q = i < len2 ? b.charAt(len2 - 1 - i) - '0' : 0;
            int tmp = p + q + carry;
            carry = tmp / 2;
            res = tmp % 2 + res;

        }
        return (carry == 0) ? res : "1" + res;
    }

    public static String vMorse(String sporocilo) {
        char[] sequence = sporocilo.toUpperCase().toCharArray();
        String output = "";
        for (char n : sequence) {
            switch (n) {
            case 'A':
                output += ".- ";
                break;
            case 'B':
                output += "-... ";
                break;
            case 'C':
                output += "-.-. ";
                break;
            case 'D':
                output += "-.. ";
                break;
            case 'E':
                output += ". ";
                break;
            case 'F':
                output += "..-. ";
                break;
            case 'G':
                output += "--. ";
                break;
            case 'H':
                output += ".... ";
                break;
            case 'I':
                output += ".. ";
                break;
            case 'J':
                output += ".--- ";
                break;
            case 'K':
                output += "-.- ";
                break;
            case 'L':
                output += ".-.. ";
                break;
            case 'M':
                output += "-- ";
                break;
            case 'N':
                output += "-. ";
                break;
            case 'O':
                output += "--- ";
                break;
            case 'P':
                output += ".--. ";
                break;
            case 'Q':
                output += "--.- ";
                break;
            case 'R':
                output += ".-. ";
                break;
            case 'S':
                output += "... ";
                break;
            case 'T':
                output += "- ";
                break;
            case 'U':
                output += "..- ";
                break;
            case 'V':
                output += "...- ";
                break;
            case 'W':
                output += ".-- ";
                break;
            case 'X':
                output += "-..- ";
                break;
            case 'Y':
                output += "-.-- ";
                break;
            case 'Z':
                output += "--.. ";
                break;
            case '1':
                output += ".---- ";
                break;
            case '2':
                output += "..--- ";
                break;
            case '3':
                output += "...-- ";
                break;
            case '4':
                output += "....- ";
                break;
            case '5':
                output += "..... ";
                break;
            case '6':
                output += "-.... ";
                break;
            case '7':
                output += "--... ";
                break;
            case '8':
                output += "---.. ";
                break;
            case '9':
                output += "----. ";
                break;
            case '0':
                output += "----- ";
                break;
            case ' ':
                output += " ";
                break;
            case '.':
                output += ".-.-.- ";
                break;
            case '-':
                output += "-....- ";
                break;
            case '?':
                output += "..--.. ";
                break;
            case ',':
                output += "--..-- ";
                break;
            case '\'':
                output += ".----. ";
                break;
            case '"':
                output += ".--..--. ";
                break;
            case ':':
                output += "---... ";
                break;
            case '(':
                output += " -.--.- ";
                break;
            case '@':
                output += ".--.-. ";
                break;
            default:
                output += "";
                break;
            }
        }
        return output.trim();
    }

    public static int vsotaSkupnihCifer(int a, int b) {
        int[] numbers = { a, b };
        boolean[] cifre = new boolean[10]; // Vse mozne cifre.

        // Gremo cez vse digite.
        for (int i = 0; i < 10; i++) {
            // Števec, ki preverja koliko digitov take količine smo našli v vseh st. tabele.
            int digitFound = 0;

            // Gremo cez stevila tabele.
            for (int j = 0; j < numbers.length; j++) {
                // To moramo preverjati, saj je lahko več kot ena ista cifra v eni stevilki.
                int currentDigit = digitFound;
                String str = Integer.toString(numbers[j]);
                for (int k = 0; k < str.length(); k++) {
                    // Če smo najdli cifro iteracije, in v tem številu še ni bilo te cifre.
                    if (i == Character.getNumericValue(str.charAt(k)) && currentDigit == digitFound) {
                        digitFound++;
                    }
                }
            }
            if (digitFound == numbers.length) {
                cifre[i] = true;
            }

        }
        int rez = 0;
        for (int i = 0; i < cifre.length; i++) {
            if (cifre[i]) {
                rez += i;
            }
        }
        return rez;
    }

    public static String prepleti(String niz1, String niz2) {
        String rezultat = "";
        int len1 = niz1.length();
        int len2 = niz2.length();
        for (int i = 0; i < Math.max(len1, len2); i++) {
            rezultat += i < len1 ? niz1.charAt(i) : ' ';
            rezultat += i < len2 ? niz2.charAt(i) : ' ';
        }
        return rezultat;
    }

    public static void odpleti(String niz) {
        String[] outputs = { "", "" };
        ;
        for (int i = 0; i < niz.length(); i++) {
            outputs[i % 2] += niz.charAt(i);
        }
        for (String e : outputs) {
            System.out.println(e.trim());
        }
    }

    public static int fibo(int n) {
        int[][] tab = new int[n][n];

        int st1 = 1;
        int st2 = 1;
        int tempNum;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j < 2) {
                    tab[i][j] = st1;
                } else {
                    tempNum = st1;
                    st1 = st2;
                    st2 += tempNum;
                    tab[i][j] = st2;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.println(tab[i][i] + " " + tab[n - i - 1][n - i - 1]);
            sum += tab[i][i];
            sum += tab[n][n - i - 1];
        }
        return sum;
    }

    public static int factorial(int n) {
        int r = 1;
        for (int i = 2; i <= n; i++) {
            r *= i;
        }
        return r;
    }

    public static int[] pascal(int n) {
        int[] zap = new int[n];
        int factorN = factorial(n - 1);
        for (int i = 0; i <= n - 1; i++) {
            zap[i] = factorN / (factorial(i) * factorial(n - 1 - i));
        }
        return zap;
    }

    public static void izpisKoledarja(int leto, int mesec) {
        int steviloDni = java.time.YearMonth.of(leto, mesec).lengthOfMonth();
        int prviDan = java.time.LocalDate.of(leto, mesec, 1).getDayOfWeek().getValue();
        String[] dneviHeader = { "PO", "TO", "SR", "ČE", "PE", "SO", "NE" };

        for (String header : dneviHeader) {
            System.out.printf("%2s  ", header);
        }
        System.out.println("");
        for (int i = 0; i < prviDan - 1; i++) {
            System.out.print("    ");
        }
        for (int i = 1; i <= steviloDni; i++) {
            int dan = java.time.LocalDate.of(leto, mesec, i).getDayOfWeek().getValue();
            if (dan == 1 && i > 1) {
                System.out.print("\n");
            }
            System.out.printf("%2d  ", i);

        }
        System.out.println();
    }

}
