import java.util.ArrayList;
import java.util.List;

public class Haven {
    //heeft een maximum lengte
    private double MAX_HAVEN_LENGTE ;
    private double huidigeLengte;
    private List<Schip> schepen;
    public Haven(double huidigeLengte, double MAX_HAVEN_LENGTE){
        this.huidigeLengte = huidigeLengte;
        this.MAX_HAVEN_LENGTE = MAX_HAVEN_LENGTE;
        this.schepen = new ArrayList<>();
    }
    public Haven() {
        this.MAX_HAVEN_LENGTE = 1000.0;
        this.huidigeLengte = 0.0;
        this.schepen = new ArrayList<>();
    }

    public void voegSchipToe(Schip schip) {
        if (huidigeLengte+ schip.getLengte() <= MAX_HAVEN_LENGTE) {
            schepen.add(schip);
            huidigeLengte += schip.getLengte();
            System.out.println("Schip " + schip.getNaam() + " is aangemeerd in de haven.");
        } else {
            System.out.println("Haven is vol. Schip " + schip.getNaam() + " kan niet aanmeren.");
        }
    }
    public boolean aanmeren(Schip schip) {
        System.out.println("Aanmeren van " + schip);
        if (huidigeLengte + schip.getLengte() <= MAX_HAVEN_LENGTE) {
            schepen.add(schip);
            huidigeLengte += schip.getLengte();
            System.out.println("Schip " + schip.getNaam() + " is aangemeerd in de haven.");
            return true;
        } else {
            System.out.println("Haven is vol. Schip " + schip.getNaam() + " kan niet aanmeren.");
            return false;
        }
    }

    // Voeg eventueel andere methoden toe afhankelijk van je vereisten

    public List<Schip> getSchepen() {
        return schepen;
    }
    private boolean isPlaatsVrij (Schip schip) {
        return MAX_HAVEN_LENGTE + schip.getLengte() <= MAX_HAVEN_LENGTE;
    }
    public void afmeren(String schipNaam) throws SchipNietGevondenException {
        for (Schip schip : schepen) {
            if (schip.getNaam().equals(schipNaam)) {
                schepen.remove(schip);
                MAX_HAVEN_LENGTE -= schip.getLengte();
                System.out.println("Afmeren van " + schip);
                return;
            }
        }
        throw new SchipNietGevondenException(schipNaam+" niet gevonden");
}
    @Override
    public String toString() {
        return "Haven [MAX_HAVEN_LENGTE=" + MAX_HAVEN_LENGTE + ", huidigeLengte=" + huidigeLengte + ", schepen="
                + schepen + "]";
    }

}