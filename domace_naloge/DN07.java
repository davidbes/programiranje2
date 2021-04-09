import java.util.Scanner;
import java.io.File;

public class DN07 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.exit(0);
        }
        String fileName = args[0];
        int[] maxi = new int[Integer.parseInt(args[1])];
        int[] stevila = new int[100];

        try {
            Scanner sc = new Scanner(new File(fileName));
            int index = 0;
            while (sc.hasNextLine()) {
                stevila[index++] = Integer.parseInt(sc.next());
            }
            sc.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }

        int indexOfMax = 0;
        for (int m = 0; m < maxi.length; m++) {
            for (int i = 0; i < stevila.length; i++) {
                if (stevila[i] > stevila[indexOfMax]) {
                    indexOfMax = i;
                }
            }
            maxi[m] = stevila[indexOfMax];
            stevila[indexOfMax] = 0;
        }
        for (int e : maxi) {
            System.out.println(e);
        }

    }
}
