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
    
    @Override
    public String toString() {
    	String ret = "";
    	for (Coord c : this.chaine.keySet()) {
    		ret+= c.toString() + " "+this.chaine.get(c)+ "\n";
    	}
    	return ret;
    }
    
    @Override
    public int hashCode() {
    	int ret=0;
    	for (Coord c : this.chaine.keySet()) {
    		ret+= c.hashCode();
    	}
    	return ret;
    }
    
    @Override
    public boolean equals (Object c){
        Chaine chaine = (Chaine)c;
        int cpt = 0;
        for (Coord coord : this.chaine.keySet()){
            if (!chaine.chaine.containsKey(coord)){
                return false;
            }
            cpt ++;
            if (cpt>=2){
                return  true;
            }
        }
        return true;
    }
    
}
