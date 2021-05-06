package banka;

import java.util.ArrayList;

import racun.Racun;
import racun.TekociRacun;
import racun.VarcevalniRacun;

public class Banka {
    ArrayList<Racun> racuni;

    public Banka() {
        this.racuni = new ArrayList<Racun>();
    }

    public void dodajTekociRacun(int stevilka, double limit) {
        if (!obstajaRacun(stevilka)) {
            racuni.add(new TekociRacun(stevilka, limit));
        } else {
            System.out.println("NAPAKA: Račun s to številko že obstaja.");
        }
    }

    public void dodajVarcevalniRacun(int stevilka, double obresti) {
        if (!obstajaRacun(stevilka)) {
            racuni.add(new VarcevalniRacun(stevilka, obresti));
        } else {
            System.out.println("NAPAKA: Račun s to številko že obstaja.");
        }
    }

    private boolean obstajaRacun(int stevilka) {
        for (Racun rac : this.racuni) {
            if (rac.getStevilka() == stevilka) {
                return true;
            }
        }
        return false;
    }

    public void izpisiTekoceRacune() {
        for (Racun rac : this.racuni) {
            if (rac instanceof TekociRacun) {
                System.out.println(rac.toString());
            }
        }
    }

    public void izpisiVarcevalneRacune() {
        for (Racun rac : this.racuni) {
            if (rac instanceof VarcevalniRacun) {
                System.out.println(rac.toString());
            }
        }
    }

    public void sortirajRacune(String vnos1, boolean equals) {
    }

    public void dodajObresti() {
        for (Racun rac : this.racuni) {
            if (rac instanceof VarcevalniRacun) {
                ((VarcevalniRacun) rac).dodajObresti();
            }
        }
    }

    public void dvig(int stevilka, double znesek) {
        for (Racun rac : this.racuni) {
            if (rac.getStevilka() == stevilka) {
                rac.dvig(znesek);
                return;
            }
        }
        System.out.println("NAPAKA: Računa s to številko ni v banki.");

    }

    public void polog(int stevilka, double znesek) {
        for (Racun rac : this.racuni) {
            if (rac.getStevilka() == stevilka) {
                rac.polog(znesek);
                return;
            }
        }
        System.out.println("NAPAKA: Računa s to številko ni v banki.");
    }

}
