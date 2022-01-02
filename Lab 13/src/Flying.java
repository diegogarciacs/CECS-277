public class Flying extends MonsterDecorator{
    /**
     * Creates a decorator to give a flying name and health increase to our monster.
     * @param m the monster to be decorated.
     */
    public Flying(Monster m) {
        super(m, " Flying Raijin", 1);
    }
    /**
     * Buffs our monsters attack points.
     * @return the prior attack points + the buff.
     */
    public int attack(){
        return 1 + super.attack();
    }
}
