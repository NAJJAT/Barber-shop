import java.util.Set;
import java.util.TreeSet;

public abstract class Persoon implements Comparable<Persoon> {



    private String naam;
    private int leeftijd ;

     private Set<Persoon> personen = new TreeSet<>();
    public Persoon(String naam, int leeftijd) {
        this.naam = naam;
        this.leeftijd = leeftijd;
        personen.add(this);
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(int leeftijd) {
        this.leeftijd = leeftijd;
    }

    @Override
    public int compareTo(Persoon o) {
        return this.naam.compareTo(o.naam);
    }
   public abstract void getDetails();


    @Override
    public String toString() {
        return "Persoon{" +
                "naam='" + naam + '\'' +
                " leeftijd=" + leeftijd +
                '}';
    }
}



