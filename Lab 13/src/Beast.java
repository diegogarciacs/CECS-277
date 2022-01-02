public class Beast extends Monster{
    /**
     * Basic base monster to be decorated with a name and hp.
     * @param n name of monster.
     * @param h hp of monster.
     */
    public Beast(String n, int h) {
        super(n, h);
    }
    /**
     * Basic attack points of the beast monster.
     * @return attack points of beast monster.
     */
    @Override
    int attack() {
        return 3;
    }
}
