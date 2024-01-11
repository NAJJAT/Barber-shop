public class Vrachtschip  extends Schip implements Loodsbaar{

    private int laadvermogen;


    public Vrachtschip(String naam, int lengte, int laadvermogen) {
        super(naam, lengte);
        this.laadvermogen = laadvermogen;
    }


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return '['+ getClass().getSimpleName() + ": " + "naam=" + getNaam() + ", lengte=" + getLengte()+ ", laadvermogen=" + laadvermogen + "]";
    }


    @Override
    public void loods() {
        System.out.println("Vrachtschip " + getNaam() + ": Ant loodsen....");
    }

}
