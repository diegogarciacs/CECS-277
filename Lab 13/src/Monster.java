public abstract class Monster {
    // hp initialization
    private int hp;
    // name initialization
    private String name;

    /**
     * Creates a monster with name and hp.
     * @param n the name of the monster.
     * @param h hp of the monster.
     */
    public Monster(String n, int h){
        this.name = n;
        this.hp = h;
    }

    /**
     * Grabs name of the monster.
     * @return the name of the monster object.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Grabs the hp of the monster and returns it.
     * @return the hp of the monster object.
     */
    public int getHp(){
        return this.hp;
    }

    /**
     * Abstract attack method to be overridden.
     * @return returns an integer of the attack points.
     */
    abstract int attack();

}
