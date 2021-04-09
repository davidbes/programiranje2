public class V02 {
    public static void main(String[] args) {

        System.out.println("  n              n!            Stirling(n)      napaka (%)");
        System.out.println("----------------------------------------------------------");

        int steviloRacunovL = 20;
        for (int i = 1; i <= steviloRacunovL; i++) {
            long fakulteta = fakultetaL(i);
            long stir = stirlingL(i);
            double relativnaNapaka = Math.abs(1 - ((double) stir / (double) fakulteta)) * 100;
            System.out.printf("%3d %19d %19d     %9.7f\n", i, fakulteta, stir, relativnaNapaka);
        }

        System.out.println("  n         n!            Stirling(n)     napaka (%)");
        System.out.println("----------------------------------------------------");
        int steviloRacunovD = 100;
        for (int i = 1; i <= steviloRacunovD; i++) {
            double fakulteta = fakultetaD(i);
            double stir = stirlingD(i);
            double relativnaNapaka = Math.abs(1 - (stir / fakulteta)) * 100;
            System.out.printf("%3d %17.9E %17.9E %11.7f\n", i, fakulteta, stir, relativnaNapaka);

        }

    }

    static long fakultetaL(int n) {
        long num = 1;
        for (int i = 2; i <= n; i++)
            num *= i;
        return num;
    };

    static long stirlingL(int n) {
        return (long) Math.round((Math.sqrt(2 * Math.PI * n) * Math.pow(n / Math.E, n)));
    };

    static double fakultetaD(int n) {
        double num = 1;
        for (int i = 2; i <= n; i++)
            num *= i;
        return num;
    };

    static double stirlingD(int n) {
        return Math.sqrt(2 * Math.PI * n) * Math.pow(n / Math.E, n);
    };
}
