import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public abstract class Persoon implements Comparable<Persoon> {
    private static List<Persoon> personenLijst = new ArrayList<>();
    
    private String naam;
    private int leeftijd;

    public Persoon(String naam, int leeftijd) {
        this.naam = naam;
        this.leeftijd = leeftijd;
        personenLijst.add(this);
        personenLijst.sort(Comparator.comparing(Persoon::getNaam));
    }

    public String getNaam() {
        return naam;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public static List<Persoon> getPersonenLijst() {
        return personenLijst;
    }

    @Override
    public int compareTo(Persoon o) {
        return this.naam.compareTo(o.getNaam());
    }

    public abstract void geefDetails();
    
    @Override
    public String toString() {
        return "Persoon " + naam + " leeftijd " + leeftijd;
    }
}
