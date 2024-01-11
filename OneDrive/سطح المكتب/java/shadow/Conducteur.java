public class Conducteur   extends Persoon{
    private int ervaring;



    public Conducteur(String naam, int leeftijd, int ervaring) {
        super(naam, leeftijd);
        this.ervaring = ervaring;
    }

    public int getErvaring() {
        return ervaring;
    }

    public void setErvaring(int ervaring) {
        this.ervaring = ervaring;
    }

    @Override
    public void getDetails() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Conducteur{" + "ervaring=" + ervaring + '}';
    }
}