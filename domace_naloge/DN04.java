public class DN04 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Ni dovolj argumentov.");
            System.exit(0);
        }
        String niz = args[0];

        int offset = 8;
        String geslo = "";
        for (int i = 0; i < niz.length() / offset; i++) {
            String word = niz.substring(i * offset, i * offset + offset);
            int decimalValue = binaryToDecimal(word);
            geslo += (char) decimalValue;
        }

        System.out.println(geslo);

    }

    public static int binaryToDecimal(String binary) {
        int value = 0;
        for (int i = 0; i < binary.length(); i++) {
            int character = Character.getNumericValue(binary.charAt(i));
            value += character * Math.pow(2, binary.length() - i - 1);
        }
        return value;
    }
}