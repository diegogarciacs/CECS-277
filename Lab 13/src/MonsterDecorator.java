public abstract class MonsterDecorator extends Monster {
    // Monster to be decorated
    private Monster tempMonster;

    /**
     * Creates a monster decorated extended from Monster to be buffed/manipulated.
     * @param m the Monster object to be buffed/manipulated
     * @param extraName extra name to be added to the Monster.
     * @param extraHp additional HP to be added to the Monster.
     */
    public MonsterDecorator(Monster m, String extraName, int extraHp) {
        super(m.getName() + extraName,m.getHp() + extraHp);
        this.tempMonster = m;
    }

    /**
     * Returns attack points of newly decorated monster.
     * @return attack of the newly decorated monster.
     */
    @Override
    public int attack() {
        return tempMonster.attack();
    }
}
