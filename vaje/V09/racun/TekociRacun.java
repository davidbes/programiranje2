package racun;

public class TekociRacun extends Racun {
    private double limit;

    public TekociRacun(int st, double limit) {
        super(st);
        this.limit = limit;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    @Override
    public void polog(double znesek) {
        if (this.limit <= znesek) {
            super.polog(znesek);
        } else {
            System.out.println("NAPAKA: Presegli ste vaš limit.");
        }
    }

    @Override
    String opisRacuna() {
        return String.format("tekoči, limit: %.2f EUR", this.limit);
    }
}
