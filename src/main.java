import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;

public class main {

    public static void main(String[] args) throws IOException {
		Grille gr =Grille.fileToGrille(new File(args[0]));
		gr.jouerCoup(gr.coupOptiv2());
		Grille opp = gr.getReverse();
		PrintWriter writer = new PrintWriter(new File(args[0]), "UTF-8");
		writer.println(opp.toString());
		writer.close();

    }
}
