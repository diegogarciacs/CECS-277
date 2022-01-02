/**
 * Interface for special attacks of Grass type Pokemon
 *
 * @author Daniel Jo 2021
 */
public interface Grass {
    /**
     * The menu of the Grass type Pokemon's special attacks
     */
    public String specialMenu = "1. Vine Whip\n2. Razor Leaf\n3. Solar Beam";

    /**
     * The number of items in the menu of the Grass type Pokemon's special attacks
     */
    public int numSpecialMenuItems = 3;

    /**
     * Method for the special attack vine whip
     *
     * @param p Pokemon that is being attacked with vine whip
     * @return the description of the Pokemon being attacked with vine whip
     */
    public String vineWhip(Pokemon p);

    /**
     * Method for the special attack razor leaf
     *
     * @param p Pokemon that is being attacked with razor leaf
     * @return the description of the Pokemon being attacked with razor leaf
     */
    public String razorLeaf(Pokemon p);

    /**
     * Method for the special attack solar beam
     *
     * @param p Pokemon that is being attacked with solar beam
     * @return the description of the Pokemon being attacked with solar beam
     */
    public String solarBeam(Pokemon p);
}
