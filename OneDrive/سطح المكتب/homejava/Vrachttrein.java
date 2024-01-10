public class Vrachttrein extends Trein implements Aflaatbaar {
    private int laadVermogen;
    private int geladen;

    public Vrachttrein(String naam, Conducteur conducteur, int laadVermogen) {
        super(naam, conducteur);
        this.laadVermogen = laadVermogen;
    }

    public void laden(int gewicht) {
        if (geladen + gewicht <= laadVermogen) {
            geladen += gewicht;
            System.out.println("Vrachttrein is geladen met " + gewicht + " ton.");
        } else {
            System.out.println("Ongeldig gewicht voor laden van de vrachttrein.");
        }
    }

    @Override
    public void afladen() {
        System.out.println("Vrachttrein is afgeladen.");
        geladen = 0;
    }

    @Override
    public void geefDetails() {
        System.out.println("Vrachttrein " + getNaam() + " met " + geladen + " ton geladen.");
    }
}
