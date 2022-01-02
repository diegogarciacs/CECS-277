/**
 * Charmander is a representation of a Charmander, subclass of Pokemon, implementation of the Fire interface
 *
 * @author Chloee Gong 2021
 */
public class Charmander extends Pokemon implements Fire {
    /**
     * Creates a Charmander object of a Pokemon with the name Charmander
     */
    public Charmander() {
        super("Charmander");
    }

    /**
     * Returns the menu of the Charmander's special attacks
     *
     * @return the menu of the Charmander's special attacks
     */
    @Override
    public String getSpecialMenu() {
        return specialMenu;
    }

    /**
     * Returns the number of the Charmander's special attacks in the menu
     *
     * @return the number of the Charmander's special attacks in the menu
     */

    @Override
    public int getNumSpecialMenuItems() {
        return numSpecialMenuItems;
    }

    /**
     * Returns string description of the special attack used by Charmander and its effect on the target Pokemon p.
     *
     * @param p    Pokemon that is being attacked
     * @param move the number of the corresponding special attack
     * @return the string of the corresponding special attack, and it's effect on the target pokemon.
     */
    @Override
    public String specialAttack(Pokemon p, int move) {
        switch (move) {
            case 1:
                return this.ember(p);
            case 2:
                return this.fireBlast(p);
            case 3:
                return this.firePunch(p);
            default:
                return "Invalid move";
        }
    }

    /**
     * Returns the description of the Pokemon being attacked by ember by Charmander and how much damage was taken.
     *
     * @param p the Pokemon object to be affected by ember's attack.
     * @return The description of ember and it's random damage on the Pokemon object being targeted.
     */
    @Override
    public String ember(Pokemon p) {
        int charmanderType = this.getType();
        int pType = p.getType();
        double multiplier = battleTable[charmanderType][pType];
        int damage = (int) (Math.floor(Math.random() * 4) * multiplier);

        p.takeDamage(damage);

        return p.getName() + " is toasted with EMBER and takes " + damage + " damage.";
    }

    /**
     * Returns the description of the Pokemon being attacked by fire blast by Charmander and how much damage was taken.
     *
     * @param p the Pokemon object to be affected by fire blasts' attack.
     * @return the description of fire blast and it's random damage on the Pokemon object being targeted.
     */
    @Override
    public String fireBlast(Pokemon p) {
        int charmanderType = this.getType();
        int pType = p.getType();
        double multiplier = battleTable[charmanderType][pType];
        int damage = (int) ((Math.floor(Math.random() * 4) + 1) * multiplier);

        p.takeDamage(damage);

        return p.getName() + " is almost dead with FIRE BLAST and takes " + damage + " damage.";
    }

    /**
     * Returns the description of the Pokemon being attacked by fire punch by Charmander and how much damage was taken.
     *
     * @param p the Pokemon object to be affected by fire blasts' attack.
     * @return The description of fire punch and its random damage on the Pokemon object being targeted.
     */

    @Override
    public String firePunch(Pokemon p) {
        int charmanderType = this.getType();
        int pType = p.getType();
        double multiplier = battleTable[charmanderType][pType];
        int damage = (int) ((Math.floor(Math.random() * 3) + 1) * multiplier);

        p.takeDamage(damage);

        return p.getName() + " is burned with FIRE PUNCH and takes " + damage + " damage.";
    }
}
