
public class Stetje {
  public static void main(String[] args) {
    String[] besede = new String[] { "prva", "druge", "FRI", "zimazimabela", "Cetrta", "Lasjaisj" };
    char c = 'p';

    // Koliko besed v tabeli besede se zacne na crko c?
    int koliko = 0;
    for (int i = 0; i < besede.length; i++) {
      if (besede[i].charAt(0) == c) {
        koliko++;
      }
    }
    System.out.printf("Stevilo besed na crko %c je %d\n", c, koliko);
  }
}