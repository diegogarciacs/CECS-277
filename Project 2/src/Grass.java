/**
 * Grass is a representation of a Grass type Pokemon, subclass of Pokemon
 *
 * @author Chloee Gong 2021
 */
public class Grass extends Pokemon {
    /**
     * Creates an instance of a Grass type Pokemon with the name, hp, and max hp
     *
     * @param n name of the Grass type Pokemon
     * @param h hp of the Grass type Pokemon
     * @param m max hp of the Grass type Pokemon
     */
    public Grass(String n, int h, int m) {
        super(n, h, m);
    }

    /**
     * Gets the menu of either basic attacks or special Grass type attacks based on atkType
     *
     * @param atkType type of attack (1 for basic, 2 for special)
     * @return menu description of attacks
     */
    @Override
    public String getAttackMenu(int atkType) {
        if (atkType == 1) {
            return super.getAttackMenu(atkType);
        } else if (atkType == 2) {
            return "1. Vine Whip\n2. Razor Leaf\n3. Solar Beam";
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
                    return "SLAPPED WITH VINE WHIP";
                case 2:
                    return "HIT WITH RAZOR LEAF";
                case 3:
                    return "BLASTED WITH SOLAR BEAM";
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
                    return (int) ((Math.random() * 3) + 1);
                case 2:
                    return (int) ((Math.random() * 3) + 2);
                case 3:
                    return (int) (Math.random() * 6);
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
            int grassType = this.getType();
            int pType = p.getType();

            return battleTable[grassType][pType];
        } else {
            return -1.0;
        }
    }
}
