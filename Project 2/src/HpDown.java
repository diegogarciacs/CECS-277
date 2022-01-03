/**
 * HpDown is a decorator for decreasing hp on Pokemon, subclass of PokemonDecorator.
 *
 * @author Chloee Gong 2021
 */
public class HpDown extends PokemonDecorator {
    /**
     * Creates a decorator to decrease hp on a Pokemon
     *
     * @param p Pokemon to decrease hp on
     */
    public HpDown(Pokemon p) {
        super(p, "-HP", -1);
    }
}
