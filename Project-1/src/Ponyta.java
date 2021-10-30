/**
 * Ponyta is a representation of a Ponyta, subclass of Pokemon, implementation of the Fire interface
 *
 * @author Chloee Gong 2021
 */
public class Ponyta extends Pokemon implements Fire {
    /**
     * Creates a Ponyta object as a Pokemon with the name Ponyta
     */
    public Ponyta() {
        super("Ponyta");
    }

    /**
     * Returns the menu of the Ponyta's special attacks
     *
     * @return the menu of the Ponyta's special attacks
     */
    @Override
    public String getSpecialMenu() {
        return specialMenu;
    }

    /**
     * Returns the number of the Ponyta's special attacks in the menu
     *
     * @return the number of the Ponyta's special attacks in the menu
     */
    @Override
    public int getNumSpecialMenuItems() {
        return numSpecialMenuItems;
    }

    /**
     * Returns string description of the special attack used by Ponyta and its effect on the target Pokemon p.
     *
     * @param p    Pokemon that is being attacked
     * @param move the number of the corresponding special attack
     * @return the string of the corresponding special attack, and its effect on the target Pokemon.
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
     * Returns the description of the Pokemon being attacked Ponyta's ember and how much damage was taken.
     *
     * @param p the Pokemon object to be affected by ember's attack.
     * @return the description of ember and its random damage on the Pokemon object being targeted.
     */
    @Override
    public String ember(Pokemon p) {
        int ponytaType = this.getType();
        int pType = p.getType();
        double multiplier = battleTable[ponytaType][pType];
        int damage = (int) (Math.floor(Math.random() * 5) * multiplier);

        p.takeDamage(damage);

        return p.getName() + " is toasted with EMBER and takes " + damage + " damage.";
    }

    /**
     * Returns the description of the Pokemon being attacked by Ponyta's fire blast and how much damage was taken.
     *
     * @param p the Pokemon object to be affected by fire blast's attack.
     * @return the description of fire blast and its random damage on the Pokemon object being targeted.
     */
    @Override
    public String fireBlast(Pokemon p) {
        int ponytaType = this.getType();
        int pType = p.getType();
        double multiplier = battleTable[ponytaType][pType];
        int damage = (int) ((Math.floor(Math.random() * 4) + 2) * multiplier);

        p.takeDamage(damage);

        return p.getName() + " is BLASTED with FIRE and takes " + damage + " damage.";
    }

    /**
     * Returns the description of the Pokemon being attacked by Ponyta's fire punch and how much damage was taken.
     *
     * @param p the Pokemon object to be affected by fire punch's attack.
     * @return the description of fire punch and its random damage on the Pokemon object being targeted.
     */
    @Override
    public String firePunch(Pokemon p) {
        int ponytaType = this.getType();
        int pType = p.getType();
        double multiplier = battleTable[ponytaType][pType];
        int damage = (int) ((Math.floor(Math.random() * 4) + 1) * multiplier);

        p.takeDamage(damage);

        return p.getName() + " is PUNCHED by FIRE and takes " + damage + " damage.";
    }
}
