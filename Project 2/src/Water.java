/**
 * Water is a representation of a Water type Pokemon, subclass of Pokemon
 *
 * @author Diego Garcia 2021
 */
public class Water extends Pokemon {
    /**
     * Creates an instance of a Water type Pokemon with the name, hp, and max hp
     *
     * @param n name of the Water type Pokemon
     * @param h hp of the Water type Pokemon
     * @param m max hp of the Water type Pokemon
     */
    public Water(String n, int h, int m) {
        super(n, h, m);
    }

    /**
     * Gets the menu of either basic attacks or special Water type attacks based on atkType
     *
     * @param atkType type of attack (1 for basic, 2 for special)
     * @return menu description of attacks
     */
    @Override
    public String getAttackMenu(int atkType) {
        if (atkType == 1) {
            return super.getAttackMenu(atkType);
        } else if (atkType == 2) {
            return "1. Water Gun\n2. Bubble Beam\n3. Waterfall";
        } else {
            return "getAttackMenu Error";
        }
    }

    /**
     * Gets the number of attacks
     *
     * @param atkType type of attack (1 for basic, 2 for special)
     * @return number of attacks
     */
    @Override
    public int getNumAttackMenuItems(int atkType) {
        if (atkType == 1) {
            return super.getNumAttackMenuItems(atkType);
        } else if (atkType == 2) {
            return 3;
        } else {
            return -1;
        }
    }

    /**
     * Gets the partial string of the attack (basic or special)
     *
     * @param atkType type of attack (1 for basic, 2 for special)
     * @param move    choice of move
     * @return partial string of the attack
     */
    @Override
    public String getAttackString(int atkType, int move) {
        if (atkType == 1) {
            return super.getAttackString(atkType, move);
        } else if (atkType == 2) {
            switch (move) {
                case 1:
                    return "SPLASHED WITH WATER GUN";
                case 2:
                    return "SHOT WITH BUBBLE BEAM";
                case 3:
                    return "POURED WITH WATERFALL";
                default:
                    return "getAttackString Error";
            }
        } else {
            return "getAttackString Error";
        }
    }

    /**
     * Gets the attack damage based on the attack (either basic or special)
     *
     * @param atkType type of attack (1 for basic, 2 for special)
     * @param move    choice of move
     * @return attack damage
     */
    @Override
    public int getAttackDamage(int atkType, int move) {
        if (atkType == 1) {
            return super.getAttackDamage(atkType, move);
        } else if (atkType == 2) {
            switch (move) {
                case 1:
                    return (int) ((Math.random() * 4) + 2);
                case 2:
                    return (int) ((Math.random() * 3) + 1);
                case 3:
                    return (int) ((Math.random() * 4) + 1);
                default:
                    return -1;
            }
        } else {
            return -1;
        }
    }

    /**
     * Get the multiplier based on the types of the attacking and attacked Pokemon
     *
     * @param p       Pokemon that is being attacked
     * @param atkType type of attack (1 for basic, 2 for special)
     * @return multiplier based on battle table
     */
    @Override
    public double getAttackMultiplier(Pokemon p, int atkType) {
        if (atkType == 1) {
            return super.getAttackMultiplier(p, atkType);
        } else if (atkType == 2) {
            int waterType = this.getType();
            int pType = p.getType();

            return battleTable[waterType][pType];
        } else {
            return -1.0;
        }
    }
}
