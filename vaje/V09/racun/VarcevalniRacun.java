package racun;

public class VarcevalniRacun extends Racun {
    private double obresti;

    public VarcevalniRacun(int stevilka, double obresti) {
        super(stevilka);
        this.obresti = obresti;
    }

    public double getObresti() {
        return obresti;
    }

    public void setObresti(double obresti) {
        this.obresti = obresti;
    }

    public void dodajObresti() {
        super.polog(super.getStanje() * this.obresti);
    }

    @Override
    String opisRacuna() {
        return String.format("varčevalni, obrestna mera: %.2f%%", this.obresti * 100);
    };
}
