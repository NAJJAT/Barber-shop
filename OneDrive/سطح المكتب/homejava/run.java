git push -u origin main
import java.util.List;

public class run {
    public static void main(String[] args) {
        

    Conducteur robin = new Conducteur("Robin", 30, 5);
        Conducteur klaas = new Conducteur("Klaas", 35, 8);

        // Voeg passagiers toe
        Passagier lode = new Passagier("Lode", 25, true);
        Passagier ahmad = new Passagier("Ahmad", 28, true);
        Passagier erica = new Passagier("Erica", 23, true);
        Passagier josh = new Passagier("Josh", 22, false);
        Passagier zoe = new Passagier("Zoe", 27, false);
        Passagier chantal = new Passagier("Chantal", 26, true);

        // Voeg vrachttrein toe
        Vrachttrein robinExpress = new Vrachttrein("Robin Express", robin, 50);
        robinExpress.laden(40);

        // Print vrachttrein details voor en na afladen
        System.out.println("\nVrachttrein details voor afladen:");
        robinExpress.geefDetails();
        robinExpress.afladen();
        System.out.println("\nVrachttrein details na afladen:");
        robinExpress.geefDetails();

        // Voeg passagierstrein toe
        Passagierstrein ehBExpress = new Passagierstrein("EhB Express", klaas, 20);

        // Stap passagiers op de trein
        ehBExpress.stapOp(lode);
        ehBExpress.stapOp(ahmad);
        ehBExpress.stapOp(erica);
        ehBExpress.stapOp(josh);
        ehBExpress.stapOp(zoe);
        ehBExpress.stapOp(chantal);

        // Print passagiers gesorteerd op naam
        System.out.println("\nPassagiers gesorteerd op naam:");
        List<Passagier> passagiersSortedByName = ehBExpress.geefPassagiersGesorteerdOpNaam();
        for (Passagier passagier : passagiersSortedByName) {
            System.out.println(passagier.getNaam());
        }

        // Print passagiers gesorteerd op leeftijd
        System.out.println("\nPassagiers gesorteerd op leeftijd:");
        List<Passagier> passagiersSortedByLeeftijd = ehBExpress.geefPassagiersGesorteerdOpLeeftijd();
        for (Passagier passagier : passagiersSortedByLeeftijd) {
            System.out.println(passagier.getNaam() + " - Leeftijd: " + passagier.getLeeftijd());
        }

        // Laat Josh van de trein afstappen
        try {
            ehBExpress.stapAf(josh);
        } catch (PassagierNietGevondenException e) {
            System.out.println("\n" + e.getMessage());
        }

        // Print de passagierstrein details
        System.out.println("\nPassagierstrein details na afstappen van Josh:");
        ehBExpress.geefDetails();
    }
}
