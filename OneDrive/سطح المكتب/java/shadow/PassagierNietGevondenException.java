public class PassagierNietGevondenException extends Exception{

    public PassagierNietGevondenException(String message) {
        super("Passagier niet gevonden Niet op de trein.");
    }
}
