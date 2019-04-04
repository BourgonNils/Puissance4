import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Grille {
	
	static public final Character opponent ='X';
	static public final Character ally = 'O';
	static public final Character emptyCell ='_';
	
	private HashMap<Coord,Character> pions;
	
	public Grille(){
		this.pions = new HashMap();
	}
	
	public Grille(Grille gr){
		this.pions = gr.pions;
	}
	
	public void addPion(Coord c,Character p){
		this.pions.put(c,p);
	}
	//Need to raise exception if wrong char
	public static Grille fileToGrille(File path) throws IOException {
		Character[] charPossibles = {opponent, ally, emptyCell};
		Grille ret = new Grille();
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line;
		for (int y = 0; y < 6; y++) {
			line = br.readLine();
			for (int x = 0; x < 7; x++) {
				Character current = line.charAt(x);
				if (current == opponent || current == ally) {
					ret.addPion(new Coord(x, y), current);
				}
			}
		}
		return ret;
	}

	public String toString(){
		String result = "";
		for (int i = 0 ; i < 6 ; i++){
			for (int j = 0 ; j < 7 ; j++){
				boolean added = false;
				for (Coord c : this.pions.keySet()){
					if (c.isEq(j,i)) {
						added = true;
						result += this.pions.get(c);
					}
				}
				if (!added){
					result += "-";
				}
			}
			result += "\n";
		}
		return result;
	}
	
//	public int eval(Pions types){
//
//	}

}
