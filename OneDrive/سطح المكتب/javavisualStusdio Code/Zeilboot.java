public class Zeilboot extends Schip {

    private int aantalMasten;

    // Constructor met parameters
    public Zeilboot(String naam, int lengte, int aantalMasten) {
        super(naam, lengte);
        this.aantalMasten = aantalMasten;
    }

    // toString methode
    @Override
    public String toString() {
        return super.toString() + ", aantal masten=" + aantalMasten + "]";
    }
}
    

