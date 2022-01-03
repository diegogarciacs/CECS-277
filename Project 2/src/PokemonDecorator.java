/**
 * PokemonDecorator is an abstract decorator for buffing and debuffing Pokemon, subclass of Pokemon.
 * PokemonDecorator uses the Decorator design pattern.
 *
 * @author Daniel Jo 2021
 */
public abstract class PokemonDecorator extends Pokemon {
    /**
     * The Pokemon that is being buffed
     */
    private Pokemon pokemon;

    /**
     * Creates a decorator of PokemonDecorator over the Pokemon for buffs and debuffs
     *
     * @param p         Pokemon that is being buffed
     * @param extraName buff name added to the Pokemon
     * @param extraHp   extra hp added to the Pokemon
     */
    public PokemonDecorator(Pokemon p, String extraName, int extraHp) {
        super(p.getName() + extraName, p.getHp() + extraHp, p.getMaxHp() + extraHp);
        this.pokemon = p;
    }

    /**
     * Gets the menu of either basic attacks or special attacks based on atkType
     *
     * @param atkType type of attack (1 for basic, 2 for special)
     * @return menu description of attacks
     */
    @Override
    public String getAttackMenu(int atkType) {
        return this.pokemon.getAttackMenu(atkType);
    }

    /**
     * Gets the number of attacks
     *
     * @param atkType type of attack (1 for basic, 2 for special)
     * @return number of attacks
     */
    @Override
    public int getNumAttackMenuItems(int atkType) {
        return this.pokemon.getNumAttackMenuItems(atkType);
    }

    /**
     * Gets the partial string of the attack (basic or special)
     *
     * @param atkType type of attack (1 for basic, 2 for special)
     * @param move    choice of move
     * @return partial string of the attack
     */
    @Override
    public String getAttackString(int atkType, int move) {
        return this.pokemon.getAttackString(atkType, move);
    }

    /**
     * Gets the attack damage based on the attack (either basic or special)
     *
     * @param atkType type of attack (1 for basic, 2 for special)
     * @param move    choice of move
     * @return attack damage of the Pokemon's move
     */
    @Override
    public int getAttackDamage(int atkType, int move) {
        return this.pokemon.getAttackDamage(atkType, move);
    }

    /**
     * Get the attack multiplier of the Pokemon
     *
     * @param p       Pokemon that is being attacked
     * @param atkType type of attack (1 for basic, 2 for special)
     * @return attack multiplier of the Pokemon
     */
    @Override
    public double getAttackMultiplier(Pokemon p, int atkType) {
        return this.pokemon.getAttackMultiplier(p, atkType);
    }

    /**
     * Get the attack bonus of the Pokemon
     *
     * @param atkType type of attack (1 for basic, 2 for special)
     * @return attack bonus of the Pokemon
     */
    @Override
    public int getAttackBonus(int atkType) {
        return this.pokemon.getAttackBonus(atkType);
    }

    /**
     * Returns the index of the type in the battle table according to the Pokemon's corresponding type.
     * Fire type Pokemon return 0.
     * Water type Pokemon return 1.
     * Grass type Pokemon return 2.
     *
     * @return the index of the type in the battle table according to the corresponding type
     */
    @Override
    public int getType() {
        return this.pokemon.getType();
    }
}
