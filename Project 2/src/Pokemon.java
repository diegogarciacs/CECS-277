/**
 * Pokemon is an abstract representation of a Pokemon, subclass of Entity
 *
 * @author Daniel Jo, Chloee Gong 2021
 */
public abstract class Pokemon extends Entity {
    /**
     * The table of the elemental advantages and disadvantages to calculate the damage multiplier for special attacks
     */
    public static final double[][] battleTable = {{1, .5, 2}, {2, 1, .5}, {.5, 2, 1}};

    /**
     * Creates a Pokemon with the name, hp, and max hp
     *
     * @param n name of the Pokemon
     * @param h hp of the Pokemon
     * @param m max hp of the Pokemon
     */
    public Pokemon(String n, int h, int m) {
        super(n, h, m);
    }

    /**
     * Gets the attack type menu
     *
     * @return attack type menu
     */
    public String getAttackTypeMenu() {
        return "1. Basic Attack\n2. Special Attack";
    }

    /**
     * Gets the number of attack types
     *
     * @return number of attack types
     */
    public int getNumAttackTypeMenuItems() {
        return 2;
    }

    /**
     * Get the basic attack menu
     *
     * @param atkType type of attack (1 for basic, 2 for special)
     * @return basic attack menu
     */
    public String getAttackMenu(int atkType) {
        return "1. Slam\n2. Tackle\n3. Punch";
    }

    /**
     * Get the number of basic attacks
     *
     * @param atkType type of attack (1 for basic, 2 for special)
     * @return number of basic attacks
     */
    public int getNumAttackMenuItems(int atkType) {
        return 3;
    }

    /**
     * Attacks the Pokemon and gets the string description of the attack with the damage taken
     *
     * @param p       Pokemon that is being attacked
     * @param atkType type of attack (1 for basic, 2 for special)
     * @param move    choice of move
     * @return description of the attack
     */
    public String attack(Pokemon p, int atkType, int move) {
        String attackString = this.getAttackString(atkType, move);
        int attackDamage = this.getAttackDamage(atkType, move);
        double attackMultiplier = this.getAttackMultiplier(p, atkType);
        int attackBonus = this.getAttackBonus(atkType);
        int damage = (int) Math.round((attackDamage * attackMultiplier) + attackBonus);

        if (damage < 0) {
            damage = 0;
        }

        p.takeDamage(damage);

        return p.getName() + " is " + attackString + " by " + this.getName() + " and takes " + damage + " damage";
    }

    /**
     * Get the partial string of the basic attack
     *
     * @param atkType type of attack (1 for basic, 2 for special)
     * @param move    choice of move for basic attack
     * @return partial string of the basic attack
     */
    public String getAttackString(int atkType, int move) {
        switch (move) {
            case 1:
                return "SLAMMED";
            case 2:
                return "TACKLED";
            case 3:
                return "PUNCHED";
            default:
                return "getAttackString Error";
        }
    }

    /**
     * Get the attack damage for basic attacks
     *
     * @param atkType type of attack (1 for basic, 2 for special)
     * @param move    choice of move for basic attack
     * @return attack damage for the basic attack
     */
    public int getAttackDamage(int atkType, int move) {
        switch (move) {
            case 1:
                return (int) (Math.random() * 6);
            case 2:
                return (int) ((Math.random() * 2) + 2);
            case 3:
                return (int) ((Math.random() * 4) + 1);
            default:
                return -1;
        }
    }

    /**
     * Get the attack multiplier
     *
     * @param p       Pokemon that is being attacked
     * @param atkType type of attack (1 for basic, 2 for special)
     * @return attack multiplier
     */
    public double getAttackMultiplier(Pokemon p, int atkType) {
        return 1;
    }

    /**
     * Get the attack bonus
     *
     * @param atkType type of attack (1 for basic, 2 for special)
     * @return attack bonus
     */
    public int getAttackBonus(int atkType) {
        return 0;
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
