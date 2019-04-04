public class Grille {
	
	private HashMap<Coord,Pions> pions;
	
	public Grille(){
		this.pions = new HashMap();
	}
	
	public Grille(Grille gr){
		...
	}
	
	public void addPion(Coord c,Pions p){
		this.pions.add(c,p);
	}
	
	public int eval(Pions types){

	}

}
