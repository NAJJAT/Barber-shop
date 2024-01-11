public class mian {

    public static void main(String[] args) {
        

        Vrachtschip S = new Vrachtschip("SuperMaramiu", 10, 7500);
        System.out.println(S.toString());
        S.loods();
        Haven H = new Haven(0,150);
        H.voegSchipToe(S);
        
        System.out.println("______________________________________________________________");
        Haven haven = new Haven();
        Schip zeilboot = new Zeilboot("smalleSally", 15, 1);
        Schip vrachtschip = new Vrachtschip("SuperMaramiu", 300, 7500);
        System.out.println("______________________________________________________________");
        System.out.println(haven.aanmeren(zeilboot));
        System.out.println("______________________________________________________________");
        System.out.println(haven.aanmeren(vrachtschip));
        Vrachtschip groteFrans = new Vrachtschip("GroteFrans", 100, 2500);
        Vrachtschip superMaramiu = new Vrachtschip("SuperMaramiu", 400, 7500);
        Zeilboot smalleSally = new Zeilboot("SmalleSally", 15, 1);
System.out.println("================================================");
        // 2. Maak een Haven "Wally-Kiwi"
        Haven wallyKiwi = new Haven();
        System.out.println("================================================");

        // Laat GroteFrans en SmalleSally aanmeren in de haven
        wallyKiwi.aanmeren(groteFrans);
        wallyKiwi.aanmeren(smalleSally);
        System.out.println("================================================");
        System.out.println("================================================");
        // 3. Laat SuperMaramiu aanmeren, dit mag niet lukken omdat er geen plaats meer is.
        wallyKiwi.aanmeren(superMaramiu);
        System.out.println("================================================");
    
    
    }
       
    
  
 }
 