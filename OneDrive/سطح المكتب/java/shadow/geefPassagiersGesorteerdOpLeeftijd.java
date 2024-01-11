import java.util.Comparator;

public class geefPassagiersGesorteerdOpLeeftijd  implements Comparator<Persoon> {

    @Override
    public int compare(Persoon o1, Persoon o2) {
        if (o1.getLeeftijd() > o2.getLeeftijd()){
            return 1;
        }else if (o1.getLeeftijd() < o2.getLeeftijd()){
            return -1;
        }else {
            return 0;
        }
    }
}
