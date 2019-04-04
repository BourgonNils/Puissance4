import java.util.HashMap;

public class Chaine {
    private HashMap<Coord , Boolean> chaine;

    public Chaine(){
        this.chaine = new HashMap<>();
    }
    public void addCoord(Coord c , boolean estOccupe){
        this.chaine.put(c,estOccupe);
    }
    public int eval(){
        if(this.chaine.size() < 4){
            return 0;
        }
        else {
            return 3;
        }
    }
}
