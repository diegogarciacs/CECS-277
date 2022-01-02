

public class Enemy
{
    private String name;
    private int maxHp;
    private int hp;
    /**
     Constructor that creates Enemy with name and mHP.
     @param n the name of the Enemy.
     @param h takes the Enemies max HP to be affected.
     */
    public Enemy(String n, int h)
    {
        name = n;
        maxHp = hp = h;
    }

    /**
     *Copy constructor
     *@param passes in the ememy object
     */
    public Enemy(Enemy e)
    {
        name = e.name;
        maxHp = e.maxHp;
        hp = e.hp;
    }

    /**
     *Gets the name of the enemy.
     *@return the name of the enemy.
     */
    public String getName()
    {
        return name;
    }

    /**
     *Gets the Hp of the enemy.
     *@return the current HP.
     */
    public int getHp()
    {
        return hp;
    }

    /**
     * Calculates the total damage taken accoringly, and updates the hp.
     * @param the damage taken.
     */
    public void takeDamage(int h)
    {
        hp -= h;
    }

    /**
     *Generates a random number for dammage (between 1-5).
     *@return the int value of randomly generated number .
     */

    public int attack()
    {
        return (int)(Math.random() * 5) + 1;
    }

    /**
     *creates a String containing the enemy's hp / mHp
     *@returns: a string that displays the hp and maxhp in * the specific format for e.g. "Hp: 10/10".
     */

    public String toString()
    {
        return "Hp: " + hp + '/' + maxHp;
    }
    /**
     *Creates a clone of the enemy
     *@return: an Enemy from the template enemy list.
     */
    public Enemy clone()
    {
        return new Enemy(this);
    }
}