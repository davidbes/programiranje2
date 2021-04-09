import java.util.Random;
import java.util.Scanner;
import java.io.File;

public class DN03 {
    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.out.println(
                    "Potrebujemo 3 argumente: 'jrun DN03.java <ime_datoteke> <dolzina_gesla> <seme_nakljucnih_stevil>'");
            System.exit(0);
        }
        // Spravimo argumente v dodeljene spremenljivke.
        String fileName = args[0];
        int dolzinaGesla = Integer.parseInt(args[1]);
        int randomSeed = Integer.parseInt(args[2]);

        // Naredi tabelo besede iz text fila-a velikosti prve vrstice.
        Scanner sc = new Scanner(new File(fileName));
        int stBesed = Integer.parseInt(sc.next());
        String[] besede = new String[stBesed];
        for (int i = 0; i < stBesed; i++)
            besede[i] = sc.next();
        sc.close();

        // Naredi seme za nakljucna stevila.
        Random rnd = new Random(randomSeed);

        // Za vsak znak poiscemo nakljucno besedo in potem nakljucno crko te besede in
        // jo dodamo k geslu.
        String geslo = "";
        for (int i = 0; i < dolzinaGesla; i++) {
            String nakljucnaBeseda = besede[rnd.nextInt(stBesed)];
            geslo += nakljucnaBeseda.charAt(rnd.nextInt(nakljucnaBeseda.length()));
        }

        // Izpis
        System.out.println(geslo);

    }

}
