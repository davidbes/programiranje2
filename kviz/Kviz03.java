public class Kviz03 {

    public static void main(String[] args) {

    }

    public static int[] sestejPolinoma(int[] a, int[] b) {
        int[] bigTable = Math.max(a.length, b.length) == a.length ? a : b;
        int[] smallTable = Math.min(a.length, b.length) == b.length ? b : a;

        int[] polySum = new int[bigTable.length];

        for (int i = 0; i < bigTable.length; i++) {
            if (i >= smallTable.length) {
                polySum[i] = bigTable[i];
            } else {
                polySum[i] = bigTable[i] + smallTable[i];
            }
        }

        return polySum;
    }

}
