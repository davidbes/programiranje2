
public class Kviz01 {
    public static void main(String[] args) {
        veckratnikDelitelj(4, 9);
        veckratnikDelitelj(2, 8);
        veckratnikDelitelj(13, 7);
        veckratnikDelitelj(21, 7);
        veckratnikDelitelj(144, 12);
        veckratnikDelitelj(5, 7);
    }

    public static void java() {
        System.out.println("   J    a   v     v  a     ");
        System.out.println("   J   a a   v   v  a a    ");
        System.out.println("J  J  aaaaa   V V  aaaaa   ");
        System.out.println(" JJ  a     a   V  a     a  ");
    }

    public static void kalkulator(int a, int b) {
        if (b == 0) {
            System.out.println("Napaka: deljenje z 0");
            return;
        }
        System.out.println(a + " + " + b + " = " + (a + b));
        System.out.println(a + " - " + b + " = " + (a - b));
        System.out.println(a + " x " + b + " = " + (a * b));
        System.out.println(a + " / " + b + " = " + (a / b));
        System.out.println(a + " % " + b + " = " + (a % b));
    }

    public static void nicli(int a, int b, int c) {
        double discr = b * b - 4 * a * c;
        if (discr < 0) {
            System.out.println("Napaka: nicli enacbe ne obstajata.");
            return;
        }
        double x1 = (-b + Math.sqrt(discr)) / 2 / a;
        double x2 = (-b - Math.sqrt(discr)) / 2 / a;

        System.out.printf("x1=%.2f, x2=%.2f", x1, x2);
    }

    public static void krog(double r, int d) {
        if (r < 0) {
            System.out.println("Napaka: negativen polmer");
            return;
        } else if (d < 0) {
            System.out.println("Napaka: negativen d");
            return;
        }
        double obseg = 2 * r * Math.PI;
        double ploscina = r * r * Math.PI;
        System.out.printf("Obseg kroga s polmerom r=%.2f je %." + d + "f \n", r, obseg);
        System.out.printf("Ploscina kroga s polmerom r=%.2f je %." + d + "f \n", r, ploscina);
    }

    public static String pretvoriSekunde(int sekunde) {
        if (sekunde < 0) {
            return "Število sekund ne more biti negativno";
        }
        int hours = sekunde / 3600;
        int minutes = (sekunde % 3600) / 60;
        int seconds = sekunde % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    public static void javaJavaJava(int n) {
        if (n < 0) {
            System.out.println("Napaka: negativen n");
            return;
        }
        String[] lines = { "     J    a   v     v  a   ", "     J   a a   v   v  a a  ", "  J  J  aaaaa   V V  aaaaa ",
                "   JJ  a     a   V  a     a"

        };
        for (int i = 0; i < lines.length; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(lines[i]);
            }
            System.out.println();
        }
    }

    public static boolean jeFibonaccijevo(int n) {
        int curr_num = 1;
        int prev_num = 1;
        int temp_num;
        do {
            temp_num = prev_num;
            prev_num = curr_num;
            curr_num += temp_num;
            if (curr_num == n) {
                return true;
            }
        } while (curr_num + prev_num <= n);
        return false;
    }

    public static boolean jePrastevilo(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= (n + 1) / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;

    }

    public static void izrisiZastavo(int n) {
        String star = "* ";
        char space = ' ';
        char line = '=';
        int line_length = 16 * n - (n - 1);
        int line_height = 5 * n;
        for (int i = 0; i < line_height; i++) {
            if (i < line_height - 2 * n) {
                if (i % 2 == 0)
                    for (int j = 0; j < n * 2; j++) {
                        System.out.print(star);
                    }
                else {
                    System.out.print(space);
                    for (int j = 0; j < (n * 2) - 1; j++) {
                        System.out.print(star);
                    }
                    System.out.print(space);
                }
                for (int j = 0; j < line_length - 4 * n; j++) {
                    System.out.print(line);
                }

            } else {
                for (int j = 0; j < line_length; j++) {
                    System.out.print(line);
                }
            }
            System.out.println(); // Line we are printing on.

        }
    }

    public static void vDesetisko(int n) {
        char[] digits = (n + "").toCharArray();
        int rezultat = 0;
        int exponent = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int numeric_char = Character.getNumericValue(digits[i]);
            if (numeric_char >= 8) {
                System.out.printf("Število %s ni število v osmiškem sistemu (števka %s)\n", n, numeric_char);
                return;
            }
            rezultat += numeric_char * Math.pow(8, exponent++);
        }
        System.out.printf("%s(8) = %s(10) \n", n, rezultat);
    }

    public static String pretvoriVDesetisko(String n, int b) {
        char[] digits = n.toCharArray();
        int rezultat = 0;
        int exponent = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int numeric_char = Character.getNumericValue(digits[i]);
            if (numeric_char >= b) {
                return String.format("Napaka pri pretvorbi sistema - števka %s\n", numeric_char);
            }
            rezultat += numeric_char * Math.pow(b, exponent++);
        }
        return String.format("%s(%s)=%s(%s) \n", n, b, rezultat, 10);
    }

    public static int vsotaPrvih(int n) {
        int vsota = 0;
        int counter = 1;
        int i = 0;
        while (counter <= n) {
            if (jePrastevilo(i)) {
                System.out.println(i);
                vsota += i;
                counter++;
            }
            i++;
        }
        return vsota;
    }

    public static void pitagoroviTrojcki(int x) {
        for (int a = 1; a <= x; a++) {
            int a_squared = a * a;
            for (int b = a; b <= x; b++) {
                int left_eq = a_squared + b * b;
                for (int c = b; c <= x; c++) {
                    if (left_eq == c * c) {
                        System.out.printf("%s %s %s \n", a, b, c);
                    }
                }
            }
        }
    }

    public static void narisiDrevo(int n) {
        if (n == 0) {
            System.out.println(" . ");
        } else {
            for (int i = n; i > 0; i--) {

                if (i <= 2) {
                    System.out.println(" | ");
                } else {
                    if (i == n && i % 2 == 1) {
                        System.out.println(" * ");
                    } else {
                        System.out.println("* *");
                        i--;
                    }
                }
            }

        }
    }

    public static int vSekunde(String time) {
        String[] splittedTime = time.split(":");
        return Integer.parseInt(splittedTime[0]) * 3600 + Integer.parseInt(splittedTime[1]) * 60
                + Integer.parseInt(splittedTime[2]);
    }

    public static String izracunajRazliko(String prviCas, String drugiCas) {
        int prveSekunde = vSekunde(prviCas);
        int drugeSekunde = vSekunde(drugiCas);
        int razlika;
        if (prveSekunde >= drugeSekunde) {
            razlika = prveSekunde - drugeSekunde;
        } else {
            razlika = drugeSekunde - prveSekunde;
        }
        return pretvoriSekunde(razlika);

    }

    public static String pretvoriVMorse(String sporocilo) {
        char[] sequence = sporocilo.toLowerCase().toCharArray();
        String output = "";
        for (char n : sequence) {
            switch (n) {
            case 'a':
                output += ".- ";
                break;
            case 'b':
                output += "-... ";
                break;
            case 'c':
                output += "-.-. ";
                break;
            case 'd':
                output += "-.. ";
                break;
            case 'e':
                output += ". ";
                break;
            case 'f':
                output += "..-. ";
                break;
            case 'g':
                output += "--. ";
                break;
            case 'h':
                output += ".... ";
                break;
            case 'i':
                output += ".. ";
                break;
            case 'j':
                output += ".--- ";
                break;
            case 'k':
                output += "-.- ";
                break;
            case 'l':
                output += ".-.. ";
                break;
            case 'm':
                output += "-- ";
                break;
            case 'n':
                output += "-. ";
                break;
            case 'o':
                output += "--- ";
                break;
            case 'p':
                output += ".--. ";
                break;
            case 'q':
                output += "--.- ";
                break;
            case 'r':
                output += ".-. ";
                break;
            case 's':
                output += "... ";
                break;
            case 't':
                output += "- ";
                break;
            case 'u':
                output += "..- ";
                break;
            case 'v':
                output += "...- ";
                break;
            case 'w':
                output += ".-- ";
                break;
            case 'x':
                output += "-..- ";
                break;
            case 'y':
                output += "-.-- ";
                break;
            case 'z':
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
                output += "  ";
                break;
            default:
                output += "? ";
                break;
            }
        }
        return output.trim();
    }

    public static void praDvojcek(int n) {
        for (int i = 0; i < n; i++) {
            if (jePrastevilo(i) && jePrastevilo(i + 2)) {
                System.out.printf("(%s, %s)\n", i, i + 2);
            }
        }
    }

    public static void trikotnik(int n, int tip) {
        switch (tip) {
        case 1:
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print(j % 10 + " ");
                }
                System.out.println();
            }
            break;

        case 2:
            for (int i = 0; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print("  ");
                }
                for (int j = 1; j <= n - i; j++) {
                    System.out.print(j % 10 + " ");
                }
                System.out.println();
            }
            break;

        case 3:
            for (int i = 1; i <= n; i++) {
                for (int j = n - i; j >= 1; j--) {
                    System.out.print("  ");
                }
                for (int j = i; j > 0; j--) {
                    System.out.print(j % 10 + " ");
                }
                System.out.println();
            }
            break;

        case 4:
            for (int i = 0; i <= n; i++) {
                for (int j = n - i; j >= 1; j--) {
                    System.out.print(j % 10 + " ");
                }
                System.out.println();
            }
            break;

        case 5:
            for (int i = 1; i <= n; i++) {
                for (int j = n - i; j > 0; j--) {
                    System.out.print("  ");
                }
                for (int j = 1; j <= i; j++) {
                    System.out.print(j % 10 + " ");
                }
                for (int j = i - 1; j > 0; j--) {
                    System.out.print(j % 10 + " ");
                }
                System.out.println();
            }
            break;

        case 6:
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j < i; j++) {
                    System.out.print("  ");
                }
                for (int j = 1; j <= n - i + 1; j++) {
                    System.out.print(j % 10 + " ");
                }
                for (int j = n - i; j > 0; j--) {
                    System.out.print(j % 10 + " ");
                }
                System.out.println();
            }
            break;
        case 7:
            for (int i = 1; i <= n; i++) {
                for (int j = n - i; j > 0; j--) {
                    System.out.print("  ");
                }
                int temp_j = i;
                for (int j = i; j <= i + i - 1; j++) {
                    System.out.print(j % 10 + " ");
                }
                for (int j = temp_j - 1; j > temp_j - i; j--) {
                    System.out.print(j % 10 + " ");
                }
                System.out.println();
            }
            break;
        default:
            break;
        }
    }

    public static void metulj(int n, int tip) {
        switch (tip) {
        case 1:
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print(j % 10 + " ");
                }
                for (int j = 2 * n - 2 * i - 1; j > 0; j--) {
                    System.out.print("  ");
                }
                for (int j = i; j > 0; j--) {
                    if (j != n) {
                        System.out.print(j % 10 + " ");
                    }
                }
                System.out.println();
            }
            break;
        case 2:
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n - i + 1; j++) {
                    System.out.print(j % 10 + " ");
                }
                for (int j = 1; j < 2 * i - 2; j++) {
                    System.out.print("  ");
                }
                for (int j = n - i + 1; j > 0; j--) {
                    if (j != n) {
                        System.out.print(j % 10 + " ");
                    }
                }
                System.out.println();
            }

            break;
        case 3:
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= i; j++) {
                    System.out.print(j % 10 + " ");
                }
                for (int j = 2 * n - 2 * i - 1; j > 0; j--) {
                    System.out.print("  ");
                }
                for (int j = i; j > 0; j--) {
                    if (j != n) {
                        System.out.print(j % 10 + " ");
                    }
                }
                if (i != n) {
                    System.out.println();

                }
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n - i + 1; j++) {
                    if (i != 1) {
                        System.out.print(j % 10 + " ");
                    }
                }
                for (int j = 1; j < 2 * i - 2; j++) {
                    System.out.print("  ");
                }
                for (int j = n - i + 1; j > 0; j--) {
                    if (j != n && i != 1) {
                        System.out.print(j % 10 + " ");
                    }
                }
                System.out.println();
            }
            break;
        default:
            break;
        }

    }

    public static void veckratnikDelitelj(int a, int b) {
        if (a == 0 || b == 0) {
            System.out.println("Napaka: obe števili morata biti različni od nič.");
            System.exit(0);
        }
        int x = Math.abs(a);
        int y = Math.abs(b);

        while (y != 0) {
            if (x > y) {
                x = x - y;
            } else {
                y = y - x;
            }
        }
        System.out.printf("Največji skupni delitelj je %d.\nNajmanjši skupni večkratnik je %d.\n", x,
                Math.abs(a * b) / Math.abs(x));
    }
}
