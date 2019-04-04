public class Coord{
	private int x;
	private int y;
	
	public Coord( int x, int y){
		if(x > 7 || y > 7){
			throw new IllegalArgumentException();
		}
	}
	
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){
		return this.y;
	}
	
	public boolean estAdjacente(Coord c2){
		if (c2.x == this.x && c2.y == this.y){
			throw new IllegalArgumentException();
		}
		boolean nearX = (c2.x >= this.x -1) && c2.x <= this.x+1;
		bool nearY = (c2.y >= this.y -1) && c2.y <= this.y+1;
		return nearX && nearY;
	}
	
	public static boolean estLigne(ArrayList<Coord> coords){
		for(Coord coord : coords){
			
		}
	}

	public static void main(String[] args) {
		System.out.print("Test");
	}
	
}
