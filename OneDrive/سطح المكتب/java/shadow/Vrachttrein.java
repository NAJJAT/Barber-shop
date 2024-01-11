public class Vrachttrein  extends trein implements Aflaatbaar{

    private int laadVermogen ;
    private int geladen;

    public Vrachttrein(String naam,Conducteur conducteur, int laadVermogen) {
        super(naam, conducteur);
        this.laadVermogen = 60;
    }

    public int getLaadVermogen() {
        return laadVermogen;
    }

    public void setLaadVermogen(int laadVermogen) {
        this.laadVermogen = laadVermogen;
    }

    public int getGeladen() {
        return geladen;
    }

    public void setGeladen(int geladen) {
        this.geladen = geladen;
    }
    public void laden(int geladen) {
        if (this.geladen + geladen <= this.getLaadVermogen()) {
            this.geladen += geladen;
            System.out.println("Vrachttrein is geladen met " + geladen + " ton.");
            if (this.geladen == this.getLaadVermogen()) {
                System.out.println( this.geladen+ " ton geladen. Totaal geladen gewicht: " + this.getLaadVermogen() + " ton");
            }
        } else {
            System.out.println("Ongeldig gewicht voor het laden van de vrachttrein.");
        }



    }
    @Override
    public String toString() {
        return "Vrachttrein{" +
                "laadVermogen=" + laadVermogen +
                ", geladen=" + geladen +
                '}';
    }

    @Override
    public void Afladen() {
            System.out.println("Vrachttrein wordt gelost.");
            this.geladen = 0;
        }

    }

