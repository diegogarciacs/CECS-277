/**
 * Entity is an abstract representation of an Entity
 *
 * @author Diego Garcia 2021
 */
public abstract class Entity {
    /**
     * The name of the Entity
     */
    private String name;

    /**
     * The health points of the Entity
     */
    private int hp;

    /**
     * The maximum health points of the Entity
     */
    private int maxHp;

    /**
     * Constructs an Entity object that initializes name, max hp, and hp of the Entity.
     *
     * @param n   name of the Entity.
     * @param mHp maximum hp of the Entity.
     */
    public Entity(String n, int mHp) {
        this.name = n;
        this.hp = mHp;
        this.maxHp = mHp;
    }

    /**
     * Returns the hp of the Entity.
     *
     * @return the current hp of the Entity.
     */
    public int getHp() {
        return this.hp;
    }

    /**
     * Returns the max hp of the Entity.
     *
     * @return the max hp of the Entity.
     */
    public int getMaxHp() {
        return this.maxHp;
    }

    /**
     * Accepts damage and afflicts it to the Entity.
     * If the damage is greater than the current hp, the Entity's hp is set to 0.
     *
     * @param d damage to inflict on Entity.
     */
    public void takeDamage(int d) {
        if (d <= this.hp) {
            this.hp -= d;
        } else {
            this.hp = 0;
        }
    }

    /**
     * Restores Entity's hp to maxHp.
     */
    public void heal() {
        this.hp = this.maxHp;
    }

    /**
     * When called returns the name of the entity.
     *
     * @return the name of the entity.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Returns a string of name, hp, and maxHp.
     *
     * @return name, hp, and maxHp in string format.
     */
    @Override
    public String toString() {
        return this.name + " HP: " + this.hp + "/" + this.maxHp;
    }
}
