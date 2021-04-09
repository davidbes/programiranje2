public class DN02 {
    public static String zvezdice(int message) {
        String nizZvezdic = "";
        for (int i = 0; i < message; i++) {
            nizZvezdic += "*";
        }
        return nizZvezdic;
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            if (args[0].equals("1")) {
                for (int i = 1; i < args.length; i++) {
                    if (i != 1) {
                        System.out.print(", ");
                    }
                    System.out.print(args[i]);
                }
                System.out.println();

            } else if (args[0].equals("2")) {
                String message = "";
                for (int i = 1; i < args.length; i++) {
                    message += " " + args[i];
                }
                message = message.trim();
                String steviloZvezdic = zvezdice(message.length() + 4);
                System.out.println(steviloZvezdic);
                System.out.println("* " + message + " *");
                System.out.println(steviloZvezdic);
            }
        }
    }
}