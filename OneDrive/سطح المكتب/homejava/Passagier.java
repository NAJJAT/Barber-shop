public class Passagier extends Persoon {
    private boolean ticket;

    public Passagier(String naam, int leeftijd, boolean ticket) {
        super(naam, leeftijd);
        this.ticket = ticket;
    }

    @Override
    public void geefDetails() {
        System.out.println("Passagier " + getNaam() + " leeftijd " + getLeeftijd() + " ticket=" + ticket);
    }

    @Override
    public String toString() {
        return "Passagier " + super.toString() + " ticket " + ticket;
    }

    public boolean isTicket() {
        return ticket;
    }

    public void setTicket(boolean ticket) {
        this.ticket = ticket;
    }

}
