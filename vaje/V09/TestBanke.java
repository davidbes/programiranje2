import banka.Banka;

import java.util.Random;
import java.util.Scanner;

public class TestBanke {
    private static Banka banka;

    /**
     * Izpis navodil za interaktivno uporabo banke.
     */
    public static void izpisiNavodila() {
        System.out.println("Navodila:");
        System.out.println(
                "1: dodaj tekoči račun, 2: dodaj varčevalni račun, 3: izpis tekočih računov, 4: izpis varčevalnih računov, 5: polog, 6: dvig, 7: obračun obresti, 8: urejanje");
        System.out.println("t: generiraj testne podatke, q: izhod, h: pomoč");
    }

    public static void generirajPodatke() {
        Random rnd = new Random();

        // Tekoči računi
        for (int i = 0; i < 3; i++) {
            int st = rnd.nextInt(900) + 100; // [100 - 999]
            double limit = (rnd.nextInt(3) + 1) * 100; // [100,200,300]
            banka.dodajTekociRacun(st, limit);

            double znesek = (rnd.nextInt(40) + 10) * 100; // [1000 - 5000]
            banka.polog(st, znesek);
        }

        // Varčevalni računi
        for (int i = 0; i < 5; i++) {
            int st = rnd.nextInt(900) + 100; // [100 - 999]
            double obresti = (rnd.nextInt(20) + 2) * 0.005; // [0.01 - 0.1]
            banka.dodajVarcevalniRacun(st, obresti);

            double znesek = (rnd.nextInt(40) + 10) * 100; // [1000 - 5000]
            banka.polog(st, znesek);
        }

    }

    public static void main(String[] args) {
        banka = new Banka();
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\\n");
        System.out.println("Banka");
        System.out.println("h: pomoč, q: izhod");
        char ukaz;
        String vnos1, vnos2;
        int stevilka;
        double vrednost;
        do {
            System.out.print(">> ");
            ukaz = sc.next().toLowerCase().charAt(0);
            switch (ukaz) {
                case 'q':
                    System.out.println("Izhod.");
                    break;
                case 'h':
                    izpisiNavodila();
                    break;
                case '1':
                    System.out.print("Dodaj tekoči račun.\nŠtevilka računa: ");
                    stevilka = sc.nextInt();
                    System.out.print("Limit: ");
                    vrednost = sc.nextDouble();
                    banka.dodajTekociRacun(stevilka, vrednost);
                    break;
                case '2':
                    System.out.print("Dodaj varčevalni račun.\nŠtevilka računa: ");
                    stevilka = sc.nextInt();
                    System.out.print("Obrestna mera (%): ");
                    vrednost = sc.nextDouble() / 100.;
                    banka.dodajVarcevalniRacun(stevilka, vrednost);
                    break;
                case '3':
                    System.out.println("Tekoči računi:");
                    banka.izpisiTekoceRacune();
                    break;
                case '4':
                    System.out.println("Varčevalni računi:");
                    banka.izpisiVarcevalneRacune();
                    break;
                case '5':
                    System.out.print("Polog na račun.\nŠtevilka računa: ");
                    stevilka = sc.nextInt();
                    System.out.print("Znesek: ");
                    vrednost = sc.nextDouble();
                    banka.polog(stevilka, vrednost);
                    break;
                case '6':
                    System.out.print("Dvig z računa.\nŠtevilka računa: ");
                    stevilka = sc.nextInt();
                    System.out.print("Znesek: ");
                    vrednost = sc.nextDouble();
                    banka.dvig(stevilka, vrednost);
                    break;
                case '7':
                    banka.dodajObresti();
                    System.out.println("Novo stanje varčevalnih računov:");
                    banka.izpisiVarcevalneRacune();
                    break;
                case '8':
                    System.out.print("Urejanje računov.\nPolje: ");
                    vnos1 = sc.next();
                    System.out.print("Padajoče (DA/NE): ");
                    vnos2 = sc.next();
                    banka.sortirajRacune(vnos1, vnos2.toUpperCase().equals("DA"));
                    break;
                case 't':
                    generirajPodatke();
                    System.out.println("Testni podatki generirani.");
                    break;
                default:
                    System.out.println("Ukaz ni veljaven. Za navodila izberite h. Za izhod izberite q.");
            }
        } while (ukaz != 'q');
    }
}