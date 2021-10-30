/**
 * Interface for special attacks of Water type Pokemon
 *
 * @author Diego Garcia 2021
 */
public interface Water {
    /**
     * The menu of the Water type Pokemon's special attacks.
     */
    public String specialMenu = "1. Water Gun\n2. Bubble Beam\n3. Waterfall";

    /**
     * The number of special menu items for Water type Pokemon.
     */
    public int numSpecialMenuItems = 3;

    /**
     * Method for the special attack water gun.
     *
     * @param p Pokemon that is being attacked by water gun.
     * @return the description of the Pokemon being attacked with water gun.
     */
    public String waterGun(Pokemon p);

    /**
     * Method for the special attack bubble beam.
     *
     * @param p Pokemon that is being attacked by bubble beam.
     * @return the description of the Pokemon being attacked with bubble beam.
     */
    public String bubbleBeam(Pokemon p);

    /**
     * Method for the special attack waterfall.
     *
     * @param p Pokemon that is being attacked by waterfall.
     * @return the description of the Pokemon being attacked with waterfall.
     */
    public String waterfall(Pokemon p);
}