public class main {
    public static void main(String[] args) {
        Grille g = new Grille();
        g.jouerCoup(0);
        g.jouerCoup(0);
        g.jouerCoup(2);
        g.jouerCoup(2);
        g.jouerCoup(2);
        g.jouerCoup(2);
        g.jouerCoup(2);
        g.jouerCoup(2);
        System.out.println(g.canPlay(1));
        System.out.println(g);
    }
}
