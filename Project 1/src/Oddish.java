/**
 * Oddish is a representation of an Oddish, subclass of Pokemon, implementation of the Grass interface
 *
 * @author Daniel Jo 2021
 */
public class Oddish extends Pokemon implements Grass {
    /**
     * Creates an Oddish object as a Pokemon with the name Oddish
     */
    public Oddish() {
        super("Oddish");
    }

    /**
     * Returns the menu of the Oddish's special attacks
     *
     * @return the menu of the Oddish's special attacks
     */
    @Override
    public String getSpecialMenu() {
        return specialMenu;
    }

    /**
     * Returns the number of the Oddish's special attacks in the menu
     *
     * @return the number of the Oddish's special attacks in the menu
     */
    @Override
    public int getNumSpecialMenuItems() {
        return numSpecialMenuItems;
    }

    /**
     * Oddish attacks the Pokemon p based on the corresponding special attack move selected as an int
     *
     * @param p    Pokemon that is being attacked
     * @param move the number of the corresponding special attack
     * @return the description of the special attack the Pokemon was attacked with by the Oddish
     * based on the corresponding move and how much damage was taken
     */
    @Override
    public String specialAttack(Pokemon p, int move) {
        switch (move) {
            case 1:
                return this.vineWhip(p);
            case 2:
                return this.razorLeaf(p);
            case 3:
                return this.solarBeam(p);
            default:
                return "Invalid move";
        }
    }

    /**
     * Oddish attacks the Pokemon p with vine whip.
     * The damage is multiplied by the multiplier which is based on the other Pokemon's type.
     *
     * @param p Pokemon that is being attacked with vine whip
     * @return the description of the Pokemon being attacked with vine whip by the Oddish and how much damage was taken.
     */
    @Override
    public String vineWhip(Pokemon p) {
        int oddishType = this.getType();
        int pType = p.getType();
        double multiplier = battleTable[oddishType][pType];
        int damage = (int) ((Math.floor(Math.random() * 3) + 1) * multiplier);

        p.takeDamage(damage);

        return p.getName() + " is slapped with VINE WHIP and takes " + damage + " damage.";
    }

    /**
     * Oddish attacks the Pokemon p with razor leaf.
     * The damage is multiplied by the multiplier which is based on the other Pokemon's type.
     *
     * @param p Pokemon that is being attacked with razor leaf
     * @return the description of the Pokemon being attacked with razor leaf by the Oddish and how much damage was taken.
     */
    @Override
    public String razorLeaf(Pokemon p) {
        int oddishType = this.getType();
        int pType = p.getType();
        double multiplier = battleTable[oddishType][pType];
        int damage = (int) ((Math.floor(Math.random() * 3) + 2) * multiplier);

        p.takeDamage(damage);

        return p.getName() + " is slashed with RAZOR LEAF and takes " + damage + " damage.";
    }

    /**
     * Oddish attacks the Pokemon p with solar beam.
     * The damage is multiplied by the multiplier which is based on the other Pokemon's type.
     *
     * @param p Pokemon that is being attacked with solar beam
     * @return the description of the Pokemon being attacked with solar beam by the Oddish and how much damage was taken.
     */
    @Override
    public String solarBeam(Pokemon p) {
        int oddishType = this.getType();
        int pType = p.getType();
        double multiplier = battleTable[oddishType][pType];
        int damage = (int) (Math.floor(Math.random() * 4) * multiplier);

        p.takeDamage(damage);

        return p.getName() + " is dazzled by SOLAR BEAM and takes " + damage + " damage.";
    }
}
