import java.util.HashMap;

public class Grille {

	static public final Character opponent = 'X';
	static public final Character ally = 'O';

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
