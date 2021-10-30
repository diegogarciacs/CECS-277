import java.awt.Point;
import java.util.ArrayList;

/**
 * Trainer is an abstract representation of a Trainer, subclass of Entity
 *
 * @author Chloee Gong 2021
 */
public class Trainer extends Entity {
    /**
     * The amount of money a Trainer has
     */
    private int money;

    /**
     * The number of potions a Trainer has
     */
    private int potions;

    /**
     * The number of Poke Balls a Trainer has
     */
    private int pokeballs;

    /**
     * The Trainer's current location as a Point
     */
    private Point loc;

    /**
     * The map that the Trainer is currently on as a Map
     */
    private Map map;

    /**
     * The list of Pokemon the Trainer has as an ArrayList
     */
    private ArrayList<Pokemon> pokemon;

    /**
     * Creates a Trainer object as an Entity.
     * Initializes the name and max health points using the constructor of the Entity.
     * Initializes money, potions, Poke Balls, Pokemon, map, and start location.
     *
     * @param n name of Trainer
     * @param p trainer's selected Pokemon
     * @param m current map of the Trainer
     */
    public Trainer(String n, Pokemon p, Map m) {
        super(n, 25);
        this.money = 25;
        this.potions = 1;
        this.pokeballs = 5;
        this.pokemon = new ArrayList<Pokemon>();
        this.pokemon.add(p);
        this.map = m;
        this.loc = this.map.findStart();
    }

    /**
     * Returns the amount of money the Trainer has
     *
     * @return the amount of money the Trainer has
     */
    public int getMoney() {
        return this.money;
    }

    /**
     * Spends money and returns true if Trainer has enough money.
     * If Trainer does not have enough money, returns false
     *
     * @param amt the amount of money to subtract from Trainer's money
     * @return a boolean if there is money available to spend
     */
    public boolean spendMoney(int amt) {
        if (this.money < amt) {
            return false;
        }

        this.money -= amt;
        return true;
    }

    /**
     * Adds the specified amount of money to Trainer's money
     *
     * @param amt the amount of money to add to Trainer's money
     */
    public void receiveMoney(int amt) {
        this.money += amt;
    }

    /**
     * Returns a boolean if Trainer has potions
     *
     * @return boolean if Trainer has potions
     */
    public boolean hasPotion() {
        return this.potions > 0;
    }

    /**
     * Adds a potion to Trainer's potions
     */
    public void receivePotion() {
        this.potions += 1;
    }

    /**
     * Heals selected Pokemon at index with a potion
     *
     * @param pokeIndex the selected index of Trainer's Pokemon list
     */
    public void usePotion(int pokeIndex) {
        if (this.hasPotion()) {
            this.pokemon.get(pokeIndex).heal();
            this.potions -= 1;
        }
    }

    /**
     * Returns a boolean if Trainer has Poke Balls
     *
     * @return boolean if Trainer has Poke Balls
     */
    public boolean hasPokeball() {
        return this.pokeballs > 0;
    }

    /**
     * Adds a Poke Ball to Trainer's Poke Balls
     */
    public void receivePokeball() {
        this.pokeballs += 1;
    }

    /**
     * Trainer attempts to catch Pokemon p.
     * If Trainer has Poke Ball, the Pokemon is caught based a probability.
     * Probability is the Pokemon p's current health in respect to its max health.
     * If Trainer does not have Poke Ball, returns false.
     *
     * @param p the Pokemon to be caught
     * @return a boolean to check if Pokemon was caught
     */
    public boolean catchPokemon(Pokemon p) {
        if (!this.hasPokeball()) {
            return false;
        }

        double chance = ((double) (p.getMaxHp() - p.getHp())) / p.getMaxHp();
        double val = Math.random();

        if (val < chance) {
            this.pokemon.add(p);
            return true;
        }

        return false;
    }

    /**
     * Returns the current location of Trainer
     *
     * @return the current location of Trainer
     */
    public Point getLocation() {
        return this.loc;
    }

    /**
     * Returns the char of the Trainer's new location after going north.
     * If Trainer is out of bounds, return back to original location.
     *
     * @return the char of the Trainer's new location after going north
     */
    public char goNorth() {
        char charAtLoc;

        try {
            loc.translate(-1, 0);
            charAtLoc = map.getCharAtLoc(loc);
        } catch (ArrayIndexOutOfBoundsException e) {
            loc.translate(1, 0);
            charAtLoc = 'x';
        }

        return charAtLoc;
    }

    /**
     * Returns the char of the Trainer's new location after going south.
     * If Trainer is out of bounds, return back to original location.
     *
     * @return the char of the Trainer's new location after going south
     */
    public char goSouth() {
        char charAtLoc;

        try {
            loc.translate(1, 0);
            charAtLoc = map.getCharAtLoc(loc);
        } catch (ArrayIndexOutOfBoundsException e) {
            loc.translate(-1, 0);
            charAtLoc = 'x';
        }

        return charAtLoc;
    }

    /**
     * Returns the char of the Trainer's new location after going east.
     * If Trainer is out of bounds, return back to original location.
     *
     * @return the char of the Trainer's new location after going east
     */
    public char goEast() {
        char charAtLoc;

        try {
            loc.translate(0, 1);
            charAtLoc = map.getCharAtLoc(loc);
        } catch (ArrayIndexOutOfBoundsException e) {
            loc.translate(0, -1);
            charAtLoc = 'x';
        }

        return charAtLoc;
    }

    /**
     * Returns the char of the Trainer's new location after going west.
     * If Trainer is out of bounds, return back to original location.
     *
     * @return the char of the Trainer's new location after going west
     */
    public char goWest() {
        char charAtLoc;

        try {
            loc.translate(0, -1);
            charAtLoc = map.getCharAtLoc(loc);
        } catch (ArrayIndexOutOfBoundsException e) {
            loc.translate(0, 1);
            charAtLoc = 'x';
        }

        return charAtLoc;
    }

    /**
     * Returns the number of Trainer's Pokemon
     *
     * @return the number of Trainer's  Pokemon
     */
    public int getNumPokemon() {
        return this.pokemon.size();
    }

    /**
     * Heals all of Trainer's Pokemon.
     */
    public void healAllPokemon() {
        for (int i = 0; i < this.pokemon.size(); i++) {
            this.pokemon.get(i).heal();
        }
    }

    /**
     * Gets the Pokemon of the inputted index
     *
     * @param index index of the Pokemon in the list.
     * @return the Pokemon at the desired index.
     */
    public Pokemon getPokemon(int index) {
        return this.pokemon.get(index);
    }

    /**
     * Returns list of Trainer's Pokemon.
     *
     * @return list of Pokémon
     */
    public String getPokemonList() {
        String pokemonList = "";

        for (int i = 0; i < this.pokemon.size(); i++) {
            String num = Integer.toString(i + 1);
            pokemonList += num + ". " + this.pokemon.get(i).toString() + "\n";
        }

        return pokemonList;
    }

    /**
     * Returns description of the map and Trainer's name, hp, maxHp, money, potions, Poke Balls, and Pokemon.
     *
     * @return description that details the map and the Trainer's name, hp, maxHp, money, potions, Poke Balls, and Pokemon.
     */
    @Override
    public String toString() {
        String s = "";

        s += super.toString();
        s += "\nMoney: " + this.money;
        s += "\nPotions: " + this.potions;
        s += "\nPoke Balls: " + this.pokeballs;
        s += "\nPokemon\n-------\n" + this.getPokemonList() + "\n";
        s += this.map.mapToString(this.loc);

        return s;
    }
}
