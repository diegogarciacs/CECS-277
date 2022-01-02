/**
 * Bulbasaur is a representation of a Bulbasaur, subclass of Pokemon, implementation of the Grass interface
 *
 * @author Daniel Jo 2021
 */
public class Bulbasaur extends Pokemon implements Grass {
    /**
     * Creates a Bulbasaur object as a Pokemon with the name Bulbasaur
     */
    public Bulbasaur() {
        super("Bulbasaur");
    }

    /**
     * Returns the menu of the Bulbasaur's special attacks
     *
     * @return the menu of the Bulbasaur's special attacks
     */
    @Override
    public String getSpecialMenu() {
        return specialMenu;
    }

    /**
     * Returns the number of the Bulbasaur's special attacks in the menu
     *
     * @return the number of the Bulbasaur's special attacks in the menu
     */
    @Override
    public int getNumSpecialMenuItems() {
        return numSpecialMenuItems;
    }

    /**
     * Bulbasaur attacks the Pokemon p based on the corresponding special attack move selected as an int
     *
     * @param p    Pokemon that is being attacked
     * @param move the number of the corresponding special attack
     * @return the description of the special attack the Pokemon was attacked with by the Bulbasaur
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
     * Bulbasaur attacks the Pokemon p with vine whip.
     * The damage is multiplied by the multiplier which is based on the other Pokemon's type.
     *
     * @param p Pokemon that is being attacked with vine whip
     * @return the description of the Pokemon being attacked with vine whip by the Bulbasaur and how much damage was taken.
     */
    @Override
    public String vineWhip(Pokemon p) {
        int bulbasaurType = this.getType();
        int pType = p.getType();
        double multiplier = battleTable[bulbasaurType][pType];
        int damage = (int) ((Math.floor(Math.random() * 3) + 1) * multiplier);

        p.takeDamage(damage);

        return p.getName() + " is slapped with VINE WHIP and takes " + damage + " damage.";
    }

    /**
     * Bulbasaur attacks the Pokemon p with razor leaf.
     * The damage is multiplied by the multiplier which is based on the other Pokemon's type.
     *
     * @param p Pokemon that is being attacked with razor leaf
     * @return the description of the Pokemon being attacked with razor leaf by the Bulbasaur and how much damage was taken.
     */
    @Override
    public String razorLeaf(Pokemon p) {
        int bulbasaurType = this.getType();
        int pType = p.getType();
        double multiplier = battleTable[bulbasaurType][pType];
        int damage = (int) ((Math.floor(Math.random() * 3) + 2) * multiplier);

        p.takeDamage(damage);

        return p.getName() + " is slashed with RAZOR LEAF and takes " + damage + " damage.";
    }

    /**
     * Bulbasaur attacks the Pokemon p with solar beam.
     * The damage is multiplied by the multiplier which is based on the other Pokemon's type.
     *
     * @param p Pokemon that is being attacked with solar beam
     * @return the description of the Pokemon being attacked with solar beam by the Bulbasaur and how much damage was taken.
     */
    @Override
    public String solarBeam(Pokemon p) {
        int bulbasaurType = this.getType();
        int pType = p.getType();
        double multiplier = battleTable[bulbasaurType][pType];
        int damage = (int) (Math.floor(Math.random() * 6) * multiplier);

        p.takeDamage(damage);

        return p.getName() + " is dazzled by SOLAR BEAM and takes " + damage + " damage.";
    }
}
