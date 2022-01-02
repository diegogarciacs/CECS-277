/**
 * Squirtle is a representation of a Squirtle, subclass of Pokemon, implementation of the Water interface
 *
 * @author Diego Garcia 2021
 */
public class Squirtle extends Pokemon implements Water {
    /**
     * Creates a Squirtle object as a Pokemon with the name Squirtle
     */
    public Squirtle() {
        super("Squirtle");
    }

    /**
     * Returns the menu of the Squirtle's special attacks
     *
     * @return the menu of the Squirtle's special attacks
     */
    @Override
    public String getSpecialMenu() {
        return specialMenu;
    }

    /**
     * Returns the number of the Squirtle's special attacks in the menu
     *
     * @return the number of the Squirtle's special attacks in the menu
     */
    @Override
    public int getNumSpecialMenuItems() {
        return numSpecialMenuItems;
    }

    /**
     * Returns string description of the special attack used by Squirtle and its effect on the target Pokemon p.
     *
     * @param p    Pokemon that is being attacked
     * @param move the number of the corresponding special attack
     * @return the string of the corresponding special attack, and its effect on the target Pokemon.
     */
    @Override
    public String specialAttack(Pokemon p, int move) {
        switch (move) {
            case 1:
                return this.waterGun(p);
            case 2:
                return this.bubbleBeam(p);
            case 3:
                return this.waterfall(p);
            default:
                return "Invalid move";
        }
    }

    /**
     * Returns the description of the Pokemon being attacked Squirtle's water gun and how much damage was taken.
     *
     * @param p the Pokemon object to be affected by water gun attack.
     * @return the description of water gun and its random damage on the Pokemon object being targeted.
     */
    @Override
    public String waterGun(Pokemon p) {
        int squirtleType = this.getType();
        int pType = p.getType();
        double multiplier = battleTable[squirtleType][pType];
        int damage = (int) ((Math.floor(Math.random() * 4) + 2) * multiplier);

        p.takeDamage(damage);

        return p.getName() + " is blasted with WATERGUN! It took " + damage + " damage!";
    }

    /**
     * Returns the description of the Pokemon being attacked Squirtle's bubble beam and how much damage was taken.
     *
     * @param p the Pokemon object to be affected by bubble beam attack.
     * @return the description of bubble beam and its random damage on the Pokemon object being targeted.
     */
    @Override
    public String bubbleBeam(Pokemon p) {
        int squirtleType = this.getType();
        int pType = p.getType();
        double multiplier = battleTable[squirtleType][pType];
        int damage = (int) ((Math.floor(Math.random() * 3) + 1) * multiplier);

        p.takeDamage(damage);
        return p.getName() + " is pelted with BUBBLEBEAM! It took " + damage + " damage!";
    }

    /**
     * Returns the description of the Pokemon being attacked Squirtle's waterfall and how much damage was taken.
     *
     * @param p the Pokemon object to be affected by waterfall attack.
     * @return the description of waterfall and its random damage on the Pokemon object being targeted.
     */
    @Override
    public String waterfall(Pokemon p) {
        int squirtleType = this.getType();
        int pType = p.getType();
        double multiplier = battleTable[squirtleType][pType];
        int damage = (int) ((Math.floor(Math.random() * 4) + 1) * multiplier);

        p.takeDamage(damage);

        return p.getName() + " was flooded with WATERFALL! It took " + damage + " damage!";
    }
}
