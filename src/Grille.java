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
		
	}
	
	public void addPion(Coord c,Character opponent2){
		this.pions.put(c,opponent2);
	}
	
	public int eval(Pions types){
		return 0;
	}
	
	public static Grille readGrille(File path) throws IOException{
		Character[] charPossibles = {opponent, ally,emptyCell};
		Grille ret =new Grille();
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line;
		for(int x = 0; x<7; x++) {
			line=br.readLine();
			for (int y =0; y<6;y++) {
				Character current = line.charAt(y);
				if(current == opponent || current == ally) {
					ret.addPion(new Coord(x, y),current);
				}
			}
		}
		return ret;

	}

}
