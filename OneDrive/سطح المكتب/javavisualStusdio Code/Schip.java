public abstract class Schip {

    private String naam;
    private int lengte;

    public Schip(String naam, int lengte2) {
        this.naam = naam;
        this.lengte = lengte2;
    }

    public String getNaam() {
        return naam;
    }

    public int getLengte() {
        return lengte;
    }

    
@Override
public String toString() {
    return "[" + getClass().getSimpleName() + ": " + "naam=" + naam + ", lengte=" + lengte + "]";

}


}