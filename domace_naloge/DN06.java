public class DN06 {

    public static void main(String[] args) {
        double rowColSize = Math.sqrt(args.length);
        if (rowColSize - Math.floor(rowColSize) != 0 || args.length == 0) {
            System.out.println("Napacno stevilo argumentov.");
            System.exit(0);
        }
        int tabSize = (int) rowColSize;
        int[][] table = new int[tabSize][tabSize];
        int sumOfTableSize = tabSize * (tabSize + 1) / 2;

        int xToFill = 0, yToFill = 0;
        for (int i = 0; i < tabSize; i++) {
            for (int j = 0; j < tabSize; j++) {
                int el = Integer.parseInt(args[i * tabSize + j]);
                if (el == 0) {
                    yToFill = i;
                    xToFill = j;
                }
                table[i][j] = Integer.parseInt(args[i * tabSize + j]);
            }
        }

        int needed = sumOfTableSize;
        for (int i = yToFill - 1; i < tabSize; i--) {
            needed -= table[i][xToFill];
        }
        if (0 != needed && needed <= tabSize) {
            table[yToFill][xToFill] = needed;
        }

        boolean validated = true;
        for (int i = 0; i < tabSize; i++) {
            int sumRow = 0;
            int sumCol = 0;
            for (int j = 0; j < tabSize; j++) {
                sumRow += table[i][j];
                sumCol += table[j][i];
            }
            if (sumRow != sumCol || sumCol != sumOfTableSize) {
                validated = false;
                break;
            }

        }
        System.out.println(validated ? needed : "Naloge se ne da resiti.");
    }

}
