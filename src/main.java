import java.util.HashMap;
import java.util.HashSet;

public class main {
    public static void main(String[] args) {
        Grille g = new Grille();
        g.jouerCoup(0);
        g.jouerCoup(0);
        for(Chaine c : g.getAllmyChaines()){
            System.out.println("Point");
            System.out.println(c.eval());

            System.out.println("Chaine");
            System.out.println(c);

        }

        System.out.println(g);
//        HashMap<String,Boolean> h = new HashMap<>();
//        h.put("S" , true);
//        h.put("V" , false);
//        System.out.print((h.containsKey("B")&& h.get("B") || (h.containsKey("V") && h.get("V"))));
    }
}
