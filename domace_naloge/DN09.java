import java.io.File;
import java.util.Scanner;

public class DN09 {
    public static void main(String[] args) {

        if (args.length == 2) {
            Planet[] planeti = preberiPlanete(args[0]);
            String formula = args[1];

            String[] planetsToFind = formula.split("\\+");

            float currSurface = 0;
            for (int i = 0; i < planetsToFind.length; i++) {
                for (int j = 0; j < planeti.length; j++) {
                    if (planeti[j].getIme().equals(planetsToFind[i].toLowerCase())) {
                        currSurface += planeti[j].povrsina();
                        break;
                    }
                }
            }
            System.out.printf("Povrsina planetov \"%s\" je %.0f milijonov km2\n", formula, currSurface);
        }

    }

    private static Planet[] preberiPlanete(String fileName) {
        Planet[] planeti = new Planet[8];
        try {
            Scanner sc = new Scanner(new File(fileName));
            int idx = 0;
            while (sc.hasNextLine()) {
                String[] attributes = sc.nextLine().split(":");
                planeti[idx++] = new Planet(attributes[0].toLowerCase(), Integer.parseInt(attributes[1]));
            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
        return planeti;
    }
}

class Planet {
    private String ime;
    private int radij;

    Planet(String ime, int radij) {
        this.ime = ime;
        this.radij = radij;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    // In km
    public int getRadij() {
        return radij;
    }

    public void setRadij(int radij) {
        this.radij = radij;
    }

    // In millions km2
    public double povrsina() {
        return ((double) this.radij / 1000) * ((double) this.radij / 1000) * 4 * Math.PI;
    }

}
