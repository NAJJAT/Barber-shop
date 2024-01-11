public class trein  {

    private String naam;
    private Conducteur conducteure;

    public trein(String naam, Conducteur conducteure) {
        this.naam = naam;
        this.conducteure = conducteure;
    }


    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }


    public void getDetails() {
        System.out.println(this.toString());
    }

    public Conducteur getConducteure() {
        return conducteure;
    }

    public void setConducteure(Conducteur conducteure) {
        this.conducteure = conducteure;
    }

    @Override
    public String toString() {
        return "trein{" +
                "naam='" + naam + '\'' +
                ", Conducteur=" + conducteure +
                '}';
    }
}
