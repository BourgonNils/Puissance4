import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class main {
    public static void main(String[] args) throws IOException {
        Grille g = new Grille();
		Grille gr =Grille.fileToGrille(new File("/home/etu/Documents/P4/P4/Puissance4/src/testGrille.txt"));
        for(Chaine c : g.getAllmyChaines()){
            System.out.println(c.eval());
            System.out.println(c);

        }

        System.out.println(g);
//        HashMap<String,Boolean> h = new HashMap<>();
//        h.put("S" , true);
//        h.put("V" , false);
//        System.out.print((h.containsKey("B")&& h.get("B") || (h.containsKey("V") && h.get("V"))));
    }
}
