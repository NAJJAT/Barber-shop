import java.util.ArrayList;
import java.util.List;

public class Passagierstrein extends trein {

      private   int maximumCapaciteit ;
        private    int huidigeCapaciteit ;
        private List<Passagier> passagiers  ;

    public Passagierstrein(String naam, Conducteur conducteur, int maximumCapaciteit ) {
        super(naam, conducteur);
        this.maximumCapaciteit = maximumCapaciteit;
        this.huidigeCapaciteit = huidigeCapaciteit;

        this.passagiers = new ArrayList<>();
    }

    public void stapOp(Passagier passagier) {
        if (huidigeCapaciteit < maximumCapaciteit) {
            System.out.println("Passagier " + passagier.getNaam() + " is ingestapt");
            passagiers.add(passagier);
            huidigeCapaciteit++;
        } else if (!passagier.isTicket()) {
            System.out.println("Passagier " + passagier.getNaam() + " heeft geen ticket");
        } else if (passagiers.size() >= maximumCapaciteit) {
            System.out.println("De trein is vol");
        }
    }

    public List<Passagier> getPassagiers() {
        return passagiers;
    }

    //passagier via de stapAf() functie de trein
            public void stapAf(Passagier passagier) throws  PassagierNietGevondenException{
                if (passagiers.contains(passagier)){
                    passagiers.remove(passagier);
                    System.out.println("Passagier " + passagier.getNaam() + " is uitgestapt");
                }else {
                  throw new PassagierNietGevondenException(passagier.getNaam() + " is niet aanwezig in de trein");
                }
            }

    public int getMaximumCapaciteit() {
        return maximumCapaciteit;
    }

    public int getHuidigeCapaciteit() {
        return huidigeCapaciteit;
    }

    @Override
    public String toString() {
        return "Passagierstrein{" +
                "maximumCapaciteit=" + maximumCapaciteit +
                ", huidigeCapaciteit=" + huidigeCapaciteit +
                '}';

   }
}
