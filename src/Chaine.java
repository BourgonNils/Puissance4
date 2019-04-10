import java.util.HashMap;

public class Chaine {

    private HashMap<Coord , Boolean> chaine;
    
    public Chaine(){
        this.chaine = new HashMap<>();
    }

    public void addCoord(Coord c, boolean estOccupe) {
        this.chaine.put(c, estOccupe);
    }

    public int eval() {
        if (this.chaine.size() < 4) {
            return 0;
        } else {
            int cpt = 0;
            for (Coord c : this.chaine.keySet()) {
                if (!this.chaine.get(c)) {
                    cpt++;
                } else {
                    int nbVoisins = numberVoisins(c);
                    if (nbVoisins == 1) {
                        cpt += 6;
                    }
                    if (nbVoisins == 2) {
                        cpt += 25;
                    }
                    if (nbVoisins == 0){
                        cpt += 3;
                    }
                }
            }
            //chaque case vide = 1
            //chaque jeton = 3
            // chaque jeton 'aligné' = 6
            return cpt;
        }
    }

    private int numberVoisins(Coord c) {
        int res = 0;
        int[][] coord = {{1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}, {-1, 0}, {-1, +1}, {0, +1}};
        for (int[] i : coord) {
            if (this.chaine.containsKey(new Coord(c.getX() + i[0], c.getY() + i[1])) && this.chaine.get(new Coord(c.getX() + i[0], c.getY() + i[1]))) {
                res++;
            }
        }
        return res;

    }

    @Override
    public String toString() {
        String ret = "";
        for (Coord c : this.chaine.keySet()) {
            ret += c.toString() + " " + this.chaine.get(c) + "\n";
        }
        return ret;
    }

    @Override
    public int hashCode() {
        int ret = 0;
        for (Coord c : this.chaine.keySet()) {
            ret += c.hashCode();
        }
        return ret;
    }

    @Override
    public boolean equals(Object c) {
        Chaine chaine = (Chaine) c;
        int cpt = 0;
        for (Coord coord : this.chaine.keySet()) {
            if (!chaine.chaine.containsKey(coord)) {
                return false;
            }
            cpt++;
            if (cpt >= 2) {
                return true;
            }
        }
        return true;
    }


}
