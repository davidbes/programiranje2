package si.fri.kodiranje.io;

import java.io.File;
import java.util.Scanner;

public class BeriPisi {

    /**
     * Vsebino zapise v datoteko.
     * 
     * @param imeDatoteke ime datoteke
     * @param vsebina     vsebina datoteke
     * 
     */
    static void zapisiDatoteko(String imeDatoteke, String vsebina) {
    }

    /**
     * Prebere in vrne vsebino datoteke
     * 
     * @param imeDatoteke
     */
    static String preberiDatoteko(String imeDatoteke) {
        String vsebina = "";

        try {
            Scanner sc = new Scanner(new File(imeDatoteke));
            while (sc.hasNextLine())
                vsebina += (vsebina.isEmpty() ? "" : "\n") + sc.nextLine();
            sc.close();
        } catch (Exception e) {
            System.out.println("Napaka pri branju datoteke!");
        }
        return vsebina;
    }

}
