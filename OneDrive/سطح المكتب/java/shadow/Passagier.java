public class Passagier extends Persoon {


    private boolean ticket;

    public Passagier(String naam, int leeftijd, boolean ticket) {
        super(naam, leeftijd);
        this.ticket = ticket;
    }

    public boolean isTicket() {
        return ticket;
    }

    public void setTicket(boolean ticket) {
        this.ticket = ticket;
    }

    @Override
    public void getDetails() {
        System.out.println(this.toString());
    }


    @Override
    public String toString() {
        return "Passagier{" +"naam='"+getNaam() +" leeftijd=" + getLeeftijd() + " " + "ticket=" + ticket + '}';
    }
}
