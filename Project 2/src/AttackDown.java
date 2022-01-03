/**
 * AttackDown is a decorator for decreasing attack on Pokemon, subclass of PokemonDecorator.
 *
 * @author Diego Garcia 2021
 */
public class AttackDown extends PokemonDecorator {
    /**
     * Creates a decorator to decrease attack on a Pokemon
     *
     * @param p Pokemon to decrease attack on
     */
    public AttackDown(Pokemon p) {
        super(p, "-ATK", 0);
    }

    /**
     * Gets the attack bonus which is a decrease
     *
     * @param atkType type of attack (1 for basic, 2 for special)
     * @return the attack decrease
     */
    @Override
    public int getAttackBonus(int atkType) {
        return super.getAttackBonus(atkType) - 1;
    }
}
