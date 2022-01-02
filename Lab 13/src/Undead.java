public class Undead extends Monster{
    /**
     * Basic base monster to be decorated with a name and hp.
     * @param n name of monster.
     * @param h hp of monster.
     */
    public Undead(String n, int h) {
        super(n, h);
    }
    /**
     * Basic attack points of the undead monster.
     * @return attack points of undead.
     */
    @Override
    int attack() {
        return 3;
    }
}
