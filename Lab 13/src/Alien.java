public class Alien extends Monster {
    /**
     * Basic base monster to be decorated with a name and hp.
     * @param n name of monster.
     * @param h hp of monster.
     */
    public Alien(String n, int h) {
        super(n, h);
    }

    /**
     * Basic attack points of the alien monster.
     * @return attack points of alien.
     */
    @Override
    int attack() {
        return 3;
    }
}
