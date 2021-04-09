
public class DN05 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Ni argumentov, po katerih bi šteli.");
            System.exit(0);
        }

        // Zapakiramo vse argumente v niz in nadomestimo vse NE male znake abecede z
        // praznim nizom. Simple regex.
        String stringToCount = argsToString(args);
        String strippedString = stringToCount.replaceAll("[^a-z]", "");

        // To pomen, da nas string ni vseboval malih abecednih crk. Vrnemo
        if (strippedString.equals("")) {
            System.out.printf("V nizu '%s' ni malih crk angleske abecede.\n", stringToCount);
            System.exit(0);
        }

        // Pricetek izpisa.
        System.out.printf("V nizu '%s' se pojavijo crke", stringToCount);

        // Naredimo tabelo "crk" katere vrednosti bodo stevila ponovitev.
        int[] ponovitve = new int[26];
        for (int i = 0; i < strippedString.length(); i++) {
            int charInd = (int) strippedString.charAt(i) - 'a';
            ponovitve[charInd]++;
        }

        // Gremo cez vse te crke in pogledamo ce se je crka kdaj ponovila in jo
        // izpisemo.
        for (int i = 0; i < ponovitve.length; i++) {
            int occurences = ponovitve[i];
            if (occurences != 0) {
                char intToChar = (char) (i + 'a');
                System.out.printf("%s %s(%d)", i == 0 ? "" : ",", intToChar, occurences); // Conditional vejica.
            }
        }

        // Koncamo s piko in \n
        System.out.println(".");

    }

    public static String argsToString(String[] args) {
        String str = "";
        for (int i = 0; i < args.length; i++) {
            str += args[i];
        }
        return str;
    }
}
