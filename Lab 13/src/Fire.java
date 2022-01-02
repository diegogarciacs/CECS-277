public class Fire extends MonsterDecorator {
    /**
     * Creates a decorator to give a fire name and health increase to our monster.
     * @param m the monster to be decorated.
     */
    public Fire(Monster m){
        super(m, " Hotboi", 2);
    }

    /**
     * Buffs our monsters attack points.
     * @return the prior attack points + the buff.
     */
    public int attack(){
        return 3 + super.attack();
    }
}
