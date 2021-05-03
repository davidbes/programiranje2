import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class DN10 {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Ni argumenta za datoteko z liki.");
            System.exit(0);
        }
        ArrayList<Lik> prebraniLiki = preberi(args[0]);
        System.out.printf("%.2f", izracunaj(prebraniLiki));
    }

    private static ArrayList<Lik> preberi(String filename) {
        ArrayList<Lik> liki = new ArrayList<Lik>();
        try {
            Scanner sc = new Scanner(new File(filename));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] splitLine = line.split(":");
                switch (splitLine[0]) {
                    case "kvadrat":
                        liki.add(new Kvadrat(Integer.parseInt(splitLine[1])));
                        break;
                    case "pravokotnik":
                        liki.add(new Pravokotnik(Integer.parseInt(splitLine[1]), Integer.parseInt(splitLine[2])));
                        break;
                    case "krog":
                        liki.add(new Krog(Integer.parseInt(splitLine[1])));
                        break;
                }
            }
        } catch (Exception e) {
            System.out.print(e);
        }
        return liki;
    }

    private static double izracunaj(ArrayList<Lik> liki) {
        double ploscina = 0;
        for (Lik lik : liki) {
            ploscina += lik.ploscina();
        }
        return ploscina;
    }
}

interface Lik {
    public double ploscina();

    public String toString();
}

class Krog implements Lik {
    private final int radij;

    Krog(int radij) {
        this.radij = radij;
    }

    @Override
    public double ploscina() {
        return Math.PI * this.radij * this.radij;
    }

    @Override
    public String toString() {
        return "Krog " + radij;
    }
}

class Pravokotnik implements Lik {
    private final int a;
    private final int b;

    Pravokotnik(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double ploscina() {
        return a * b;
    }

    @Override
    public String toString() {
        return "Pravokotnik " + a + " " + b;
    }
}

class Kvadrat implements Lik {
    private final int a;

    Kvadrat(int a) {
        this.a = a;
    }

    @Override
    public double ploscina() {
        return a * a;
    }

    @Override
    public String toString() {
        return "Kvadrat " + a;
    }
}