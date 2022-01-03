/**
 * AttackDown is a decorator for increasing attack on Pokemon, subclass of PokemonDecorator.
 *
 * @author Diego Garcia 2021
 */
public class AttackUp extends PokemonDecorator {
    /**
     * Creates a decorator to increase attack on a Pokemon
     *
     * @param p Pokemon to increase attack on
     */
    public AttackUp(Pokemon p) {
        super(p, "+ATK", 0);
    }

    /**
     * Gets the attack bonus for the buffed Pokemon
     *
     * @param atkType type of attack (1 for basic, 2 for special)
     * @return the attack bonuus
     */
    @Override
    public int getAttackBonus(int atkType) {
        return super.getAttackBonus(atkType) + (int) ((Math.random() * 2) + 1);
    }
}
