public class Conducteur extends Persoon {
    private int ervaring;

    public Conducteur(String naam, int leeftijd, int ervaring) {
        super(naam, leeftijd);
        this.ervaring = ervaring;
    }

    @Override
    public void geefDetails() {
        System.out.println("Conducteur " + getNaam() + " met " + ervaring + " jaar ervaring.");
    }

    @Override
    public String toString() {
        return "Conducteur " + super.toString() + " ervaring " + ervaring;
    }
}
