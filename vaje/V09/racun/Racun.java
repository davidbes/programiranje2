package racun;

public abstract class Racun {
    private double stanje;
    private final int stevilka;

    Racun(int stevilka) {
        this.stanje = 0.0;
        this.stevilka = stevilka;
    }

    /**
     * Položi znesek znesek na račun.
     * 
     * @param znesek položen znesek, nenegativno število
     */
    public void polog(double znesek) {
        if (znesek > 0) {
            this.stanje += znesek;
        } else {
            System.out.print("NAPAKA: Ne morete položiti/dvigniti negativnega zneska.");
        }
    }

    /**
     * Dvigne znesek znesek z računa. Stanje računa je lahko negativno.
     * 
     * @param znesek dvignjen znesek, nenegativno število
     */
    public void dvig(double znesek) {
        if (znesek > 0) {
            this.stanje -= znesek;
        } else {
            System.out.print("NAPAKA: Ne morete položiti/dvigniti negativnega zneska.");
        }
    }

    public double getStanje() {
        return stanje;
    }

    public int getStevilka() {
        return stevilka;
    }

    /**
     * Abstraktna metoda, ki vrne opis računa glede na njegov tip.
     * 
     * @return opis računa
     */
    abstract String opisRacuna();

    public String toString() {
        return String.format("Račun #%d (%s): %.2f EUR", this.stevilka, opisRacuna(), this.stanje);
    }
}
