public class Poison extends MonsterDecorator {
    /**
     * Creates a decorator to give a poison name and health increase to our monster.
     * @param m the monster to be decorated.
     */
    public Poison(Monster m) {
        super(m, " Toxic Avenger", 1);
    }
    /**
     * Basic attack points of the undead monster.
     * @return attack points of undead.
     */
    public int attack(){
        return 3 + super.attack();
    }
}
