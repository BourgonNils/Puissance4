import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;

public class main {
    public static void main(String[] args) throws IOException {
		Grille gr =Grille.fileToGrille(new File(args[0]));
		System.out.println(gr.toString());
		gr.jouerCoup(gr.coupOptiv2());
		System.out.println(gr.toString());
		Grille opp = gr.getReverse();
		System.out.println(opp.toString());

		PrintWriter writer = new PrintWriter(new File(args[0]), "UTF-8");
		writer.println(opp.toString());
		writer.close();

    }
}
