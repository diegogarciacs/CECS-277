/**
 * Interface for special attacks of Fire type Pokemon
 *
 * @author Chloee Gong 2021
 */
public interface Fire {
    /**
     * The menu of the Fire type Pokemon's special attacks.
     */
    public String specialMenu = "1. Ember\n2. Fire Blast\n3. Fire Punch";

    /**
     * The number of special menu items for Fire type Pokemon.
     */
    public int numSpecialMenuItems = 3;

    /**
     * Method for the special attack ember.
     *
     * @param p Pokemon that is being attacked by ember.
     * @return the string result of attacking the Pokemon with ember.
     */
    public String ember(Pokemon p);

    /**
     * Method for the special attack fire blast.
     *
     * @param p Pokemon that is being attacked by fire blast.
     * @return the string result of attacking the Pokemon with fire blast.
     */
    public String fireBlast(Pokemon p);

    /**
     * Method for the special attack fire punch.
     *
     * @param p Pokemon that is being attacked by fire punch.
     * @return the string result of attacking the Pokemon with fire punch.
     */
    public String firePunch(Pokemon p);
}
