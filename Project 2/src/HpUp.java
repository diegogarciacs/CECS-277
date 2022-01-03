/**
 * HpUp is a decorator for increasing hp on Pokemon, subclass of PokemonDecorator.
 *
 * @author Chloee Gong 2021
 */
public class HpUp extends PokemonDecorator {
    /**
     * Creates a decorator to increase hp on a Pokemon
     *
     * @param p Pokemon to increase hp on
     */
    public HpUp(Pokemon p) {
        super(p, "+HP", (int) ((Math.random() * 2) + 1));
    }
}
