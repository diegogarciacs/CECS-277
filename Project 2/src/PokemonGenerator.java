import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


/**
 * PokemonGenerator creates new Pokemon and adds buffs and debuffs to them.
 * PokemonGenerator uses the Singleton and Factory Method design pattern.
 *
 * @author Diego Garcia 2021
 */
public class PokemonGenerator {
    /**
     * HashMap of Pokemon and their types
     */
    private HashMap<String, String> pokemon;

    /**
     * The instance of PokemonGenerator
     */
    private static PokemonGenerator instance = null;

    /**
     * Constructs a PokemonGenerator object that fills in the HashMap of Pokemon based on the Pokemon list file
     */
    private PokemonGenerator() {
        pokemon = new HashMap<>();

        try {
            File pokemonList = new File("PokemonList.txt");
            Scanner scanner = new Scanner(pokemonList);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                int index = line.indexOf(",");
                String name = line.substring(0, index);
                String type = line.substring(index + 1);
                this.pokemon.put(name, type);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    /**
     * Creates a new instance of PokemonGenerator if it does not exist.
     * Otherwise, it returns the existing instance of PokemonGenerator.
     *
     * @return instance of PokemonGenerator
     */
    public static PokemonGenerator getInstance() {
        if (instance == null) {
            instance = new PokemonGenerator();
        }

        return instance;
    }

    /**
     * Generates a random Pokemon from the HashMap
     *
     * @param level number of buffs of the random Pokemon
     * @return randomly generated and buffed Pokemon
     */
    public Pokemon generateRandomPokemon(int level) {
        String[] names = this.pokemon.keySet().toArray(new String[this.pokemon.size()]);
        int rand = (int) (Math.random() * names.length);
        String name = names[rand];
        Pokemon randomPokemon = this.getPokemon(name);

        for (int i = 0; i < level - 1; i++) {
            randomPokemon = this.addRandomBuff(randomPokemon);
        }

        return randomPokemon;
    }

    /**
     * Creates a new Pokemon based on its name and type
     *
     * @param name name of the Pokemon
     * @return new Pokemon with its name and type
     */
    public Pokemon getPokemon(String name) {
        String type = this.pokemon.get(name);
        Pokemon newPokemon;
        int health = (int) ((Math.random() * 6) + 20);

        if (type.equalsIgnoreCase("Fire")) {
            newPokemon = new Fire(name, health, health);
        } else if (type.equalsIgnoreCase("Water")) {
            newPokemon = new Water(name, health, health);
        } else if (type.equalsIgnoreCase("Grass")) {
            newPokemon = new Grass(name, health, health);
        } else {
            newPokemon = null;
        }

        return newPokemon;
    }

    /**
     * Adds a random buff to the Pokemon
     *
     * @param p Pokemon to be buffed
     * @return buffed Pokemon
     */
    public Pokemon addRandomBuff(Pokemon p) {
        int rand = (int) (Math.random() * 2);

        if (rand == 0) {
            p = new AttackUp(p);
        } else {
            p = new HpUp(p);
        }
        return p;
    }

    /**
     * Adds a random debuff to the Pokemon
     *
     * @param p Pokemon to be debuffed
     * @return debuffed Pokemon
     */
    public Pokemon addRandomDebuff(Pokemon p) {
        int rand = (int) (Math.random() * 2);

        if (rand == 0) {
            p = new AttackDown(p);
        } else {
            p = new HpDown(p);
        }

        return p;
    }
}
