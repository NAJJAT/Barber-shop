import java.util.*;

public class Main {
    public static void main(String[] args) {

        Conducteur robin = new Conducteur("Robin", 30, 5);
        Conducteur klaas = new Conducteur("Klaas", 35, 8);
        Conducteur ahmad = new Conducteur("Ahmad", 40, 10);
        Vrachttrein vrachttrein = new Vrachttrein("EhB Express", robin, 50);
        vrachttrein.laden(40);
        //print de details van Vrachttrein
        vrachttrein.getDetails();
        System.out.println("------------------------------------------------------------------------------------");
        Passagierstrein ehBExpress = new Passagierstrein("EhB Express", klaas, 5);
        // Maak passagiers aan
        Collections.sort(ehBExpress.getPassagiers());
        Passagier passagier1 = new Passagier("Bz", 83, true);
        Passagier passagier2 = new Passagier("Cz", 33, true);
        Passagier passagier3 = new Passagier("Dl", 53, true);
        Passagier passagier4 = new Passagier("Eeod", 83, true);
        Passagier passagier = new Passagier("Ahmad", 13, true);
        ehBExpress.stapOp(passagier4);
        ehBExpress.stapOp(passagier2);
        ehBExpress.stapOp(passagier);
        ehBExpress.stapOp(passagier1);
        ehBExpress.stapOp(passagier3);
        ehBExpress.stapOp(passagier4);
        ehBExpress.stapOp(passagier);
        //print de details gesoteerd op naam
        Collections.sort(ehBExpress.getPassagiers());
        for (Passagier p : ehBExpress.getPassagiers()) {
            System.out.println(p);
        }
        System.out.println("------------------------------------------------------------------------------------");
        Collections.sort(ehBExpress.getPassagiers(), new geefPassagiersGesorteerdOpLeeftijd());
        //print de details gesoteerd op leeftijd
        for (Passagier p : ehBExpress.getPassagiers()) {
            System.out.println(p);
        }

        try {
            ehBExpress.stapAf(new Passagier("Ahmad", 43, false));
        } catch (PassagierNietGevondenException e) {
            e.printStackTrace();
        }
    }
}
