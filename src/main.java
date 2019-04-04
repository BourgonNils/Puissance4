public class main {
    public static void main(String[] args) {
        Grille g = new Grille();
        g.addPion(new Coord(4,5) , 'O');
        g.addPion(new Coord(2,5) , 'X');
        System.out.println(g);
    }
}
