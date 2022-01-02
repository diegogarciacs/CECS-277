public class Lasers extends MonsterDecorator {
    /**
     * Creates a decorator to give a laser name and health increase to our monster.
     * @param m the monster to be decorated.
     */
    public Lasers(Monster m) {
        super(m, " with Laser Beams", 2);
    }
    /**
     * Buffs our monsters attack points.
     * @return the prior attack points + the buff.
     */
    public int attack(){
        return 2 + super.attack();
    }
}
