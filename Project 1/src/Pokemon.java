/**
 * Pokemon is an abstract representation of a Pokemon, subclass of Entity
 *
 * @author Daniel Jo 2021
 */
public abstract class Pokemon extends Entity {
    /**
     * A table of the elemental advantages and disadvantages to calculate the damage multiplier for special attacks
     */
    public static final double[][] battleTable = {{1, .5, 2}, {2, 1, .5}, {.5, 2, 1}};

    /**
     * Initializes the Pokemon with its name and a random hp between 20 and 25
     *
     * @param n name of the Pokemon
     */
    public Pokemon(String n) {
        super(n, (int) Math.floor(Math.random() * 6) + 20);
    }

    /**
     * Returns the menu of the Pokemon's special attacks
     *
     * @return the menu of the Pokemon's special attacks
     */
    public abstract String getSpecialMenu();

    /**
     * Returns the number of the Pokemon's special attacks in the menu
     *
     * @return the number of the Pokemon's special attacks in the menu
     */
    public abstract int getNumSpecialMenuItems();

    /**
     * Attacks the Pokemon p based on the corresponding special attack move selected as an int
     *
     * @param p    Pokemon that is being attacked
     * @param move the number of the corresponding special attack
     * @return the description of the special attack the other Pokemon was attacked with by this Pokemon
     * based on the corresponding move and how much damage was taken
     */
    public abstract String specialAttack(Pokemon p, int move);

    /**
     * Returns the menu of the Pokemon's basic attacks
     *
     * @return the menu of the Pokemon's basic attacks
     */
    public String getBasicMenu() {
        return "1. Slam\n2. Tackle\n3. Punch";
    }

    /**
     * Returns the number of the Pokemon's basic attacks in the menu
     *
     * @return the number of the Pokemon's basic attacks in the menu
     */
    public int getNumBasicMenuItems() {
        return 3;
    }

    /**
     * Attacks the Pokemon p based on the corresponding basic attack move selected as an int
     *
     * @param p    Pokemon that is being attacked
     * @param move the number of the corresponding basic attack
     * @return the description of the basic attack the other Pokemon was attacked with by this Pokemon
     * based on the corresponding move and how much damage was taken
     */
    public String basicAttack(Pokemon p, int move) {
        switch (move) {
            case 1:
                return this.slam(p);
            case 2:
                return this.tackle(p);
            case 3:
                return this.punch(p);
            default:
                return "Invalid move";
        }
    }

    /**
     * Returns the menu of the Pokemon's attack options (basic or special)
     *
     * @return the menu of the Pokemon's attack options (basic or special)
     */
    public String getAttackMenu() {
        return "1. Basic Attack\n2. Special Attack";
    }

    /**
     * Returns the number of the Pokemon's attack options (basic or special) in the menu
     *
     * @return the number of the Pokemon's attack options (basic or special) in the menu
     */
    public int getNumAttackMenuItems() {
        return 2;
    }

    /**
     * Attacks the Pokemon p with slam.
     * The damage is determined randomly between a range of numbers.
     *
     * @param p Pokemon that is being attacked with slam
     * @return a description of the other Pokemon being attacked with slam by this Pokemon and how much damage was taken.
     */
    public String slam(Pokemon p) {
        int damage = (int) Math.floor(Math.random() * 6);

        p.takeDamage(damage);

        return p.getName() + " is SLAMMED by " + this.getName() + " and takes " + damage + " damage.";
    }

    /**
     * Attacks the Pokemon p with tackle.
     * The damage is determined randomly between a range of numbers.
     *
     * @param p Pokemon that is being attacked with tackle
     * @return a description of the other Pokemon being attacked with tackle by this Pokemon and how much damage was taken.
     */
    public String tackle(Pokemon p) {
        int damage = (int) Math.floor(Math.random() * 2) + 2;

        p.takeDamage(damage);

        return p.getName() + " is TACKLED by " + this.getName() + " and takes " + damage + " damage.";
    }

    /**
     * Attacks the Pokemon p with punch.
     * The damage is determined randomly between a range of numbers.
     *
     * @param p Pokemon that is being attacked with punch
     * @return a description of the other Pokemon being attacked with punch by this Pokemon and how much damage was taken.
     */
    public String punch(Pokemon p) {
        int damage = (int) Math.floor(Math.random() * 4) + 1;

        p.takeDamage(damage);

        return p.getName() + " is PUNCHED by " + this.getName() + " and takes " + damage + " damage.";
    }

    /**
     * Returns the index of the type in the battle table according to the corresponding type.
     * Fire type Pokemon return 0.
     * Water type Pokemon return 1.
     * Grass type Pokemon return 2.
     *
     * @return the index of the type in the battle table according to the corresponding type
     */
    public int getType() {
        if (this instanceof Fire) {
            return 0;
        } else if (this instanceof Water) {
            return 1;
        } else if (this instanceof Grass) {
            return 2;
        } else {
            return -1;
        }
    }
}
