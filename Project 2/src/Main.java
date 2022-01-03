import java.io.FileNotFoundException;

/**
 * The main implementation of the Pokemon game.
 *
 * @author Diego Garcia, Chloee Gong, Daniel Jo 2021
 * @version 1.0
 **/
class Main {
    /**
     * Prompts Trainer to enter name and choose first Pokemon.
     * Trainer roams around map picking up items, fighting and catching wild Pokemon,
     * meeting random people, and purchasing items and healing Pokemon in the city.
     * New maps are generated as Trainer beats the gym leader at the finish of each map.
     * Game ends when Trainer runs out of health or decides to quit.
     */
    public static void main(String[] args) {
        Map map = Map.getInstance();
        int mapIndex = 1;
        int level = 1;

        System.out.println("Prof. Oak: Hello there new trainer, what is your name?");
        String trainerName = CheckInput.getString();

        System.out.println("Great to meet you, " + trainerName);
        System.out.println("Choose your first pokemon:");
        System.out.println("1. Charmander\n2. Bulbasaur\n3. Squirtle");

        int firstPokemonChoice = CheckInput.getIntRange(1, 3);
        Pokemon firstPokemon;

        switch (firstPokemonChoice) {
            case 1:
                firstPokemon = PokemonGenerator.getInstance().getPokemon("Charmander");
                break;
            case 2:
                firstPokemon = PokemonGenerator.getInstance().getPokemon("Bulbasaur");
                break;
            case 3:
                firstPokemon = PokemonGenerator.getInstance().getPokemon("Squirtle");
                break;
            default:
                System.out.println("Invalid choice");
                firstPokemon = null;
                break;
        }

        Trainer trainer = new Trainer(trainerName, firstPokemon);
        map.reveal(trainer.getLocation());

        int mainMenuChoice;

        do {
            char charAtLoc;

            System.out.println(trainer);

            mainMenuChoice = mainMenu();

            switch (mainMenuChoice) {
                case 1:
                    charAtLoc = trainer.goNorth();
                    break;
                case 2:
                    charAtLoc = trainer.goSouth();
                    break;
                case 3:
                    charAtLoc = trainer.goEast();
                    break;
                case 4:
                    charAtLoc = trainer.goWest();
                    break;
                case 5:
                    charAtLoc = 'a';
                    break;
                default:
                    charAtLoc = 'a';
                    System.out.println("Invalid selection. Please try again.");
                    break;
            }

            int battleChoice;
            int pokemonChoice;
            boolean trainerPokemonFainted;

            switch (charAtLoc) {
                case 'f':
                    System.out.println("You are almost finished! The gym leader is blocking the way");
                    Pokemon gymPokemon = PokemonGenerator.getInstance().generateRandomPokemon(level + 2);
                    System.out.println("The gym leader uses " + gymPokemon.getName());

                    do {
                        trainerPokemonFainted = true;

                        System.out.println(gymPokemon);
                        System.out.println("What do you want to do?");
                        System.out.println("1. Fight");
                        System.out.println("2. Use Potion");

                        battleChoice = CheckInput.getIntRange(1, 2);

                        switch (battleChoice) {
                            case 1:
                                trainerAttack(trainer, gymPokemon);

                                break;
                            case 2:
                                System.out.println("Choose a Pokemon:");
                                System.out.println(trainer.getPokemonList());
                                pokemonChoice = CheckInput.getIntRange(1, trainer.getNumPokemon());

                                if (trainer.hasPotion()) {
                                    trainer.usePotion(pokemonChoice - 1);
                                    System.out.println(trainer.getPokemon(pokemonChoice - 1) + " was healed to max HP");
                                } else {
                                    System.out.println("You do not have a potion to heal");
                                }

                                break;
                            default:
                                System.out.println("Error");
                                break;
                        }

                        for (int i = 0; i < trainer.getNumPokemon(); i++) {
                            if (trainer.getPokemon(i).getHp() > 0) {
                                trainerPokemonFainted = false;
                                break;
                            }
                        }
                    } while (gymPokemon.getHp() > 0 && !trainerPokemonFainted);

                    if (gymPokemon.getHp() == 0) {
                        int money = (int) ((Math.random() * 4) + 1);
                        trainer.receiveMoney(money);
                        trainer.buffAllPokemon();

                        System.out.println(gymPokemon.getName() + " fainted.");
                        System.out.println("You beat the gym leader!");
                        System.out.println("You gained " + money + " money.");
                        System.out.println("All your Pokemon were buffed!");
                        level += 1;
                    }

                    if (trainerPokemonFainted) {
                        int damage = (int) ((Math.random() * 3) + 1);
                        trainer.takeDamage(damage);

                        System.out.println("All your Pokemon fainted!");
                        System.out.println("You took " + damage + " damage from " + gymPokemon.getName());
                        System.out.println("Please come back when you are ready");
                        break;
                    }

                    System.out.println("You've found the finish");

                    switch (mapIndex) {
                        case 1:
                            try {
                                map.loadMap(2);
                                mapIndex = 2;
                            } catch (FileNotFoundException e) {
                                System.out.println("File not found");
                            }
                            break;
                        case 2:
                            try {
                                map.loadMap(3);
                                mapIndex = 3;
                            } catch (FileNotFoundException e) {
                                System.out.println("File not found");
                            }
                            break;
                        case 3:
                            try {
                                map.loadMap(1);
                                mapIndex = 1;
                            } catch (FileNotFoundException e) {
                                System.out.println("File not found");
                            }
                            break;
                        default:
                            System.out.println("Incorrect map index");
                            break;
                    }

                    break;
                case 'n':
                    System.out.println("There's nothing here...");
                    break;
                case 'i':
                    int randomItem = (int) (Math.random() * 2);

                    if (randomItem == 0) {
                        trainer.receivePotion();
                        System.out.println("You found a potion");
                    } else {
                        trainer.receivePokeball();
                        System.out.println("You found a Poke Ball");
                    }

                    map.removeCharAtLoc(trainer.getLocation());
                    break;
                case 'w':
                    Pokemon wild = PokemonGenerator.getInstance().generateRandomPokemon(level);
                    System.out.println("A wild " + wild.getName() + " has appeared.");

                    boolean caught = false;
                    boolean runAway = false;

                    do {
                        trainerPokemonFainted = true;

                        System.out.println(wild);
                        System.out.println("What do you want to do?");
                        System.out.println("1. Fight");
                        System.out.println("2. Use Potion");
                        System.out.println("3. Throw Poke Ball");
                        System.out.println("4. Run Away");

                        battleChoice = CheckInput.getIntRange(1, 4);

                        switch (battleChoice) {
                            case 1:
                                trainerAttack(trainer, wild);

                                break;
                            case 2:
                                System.out.println("Choose a Pokemon:");
                                System.out.println(trainer.getPokemonList());
                                pokemonChoice = CheckInput.getIntRange(1, trainer.getNumPokemon());

                                if (trainer.hasPotion()) {
                                    trainer.usePotion(pokemonChoice - 1);
                                    System.out.println(trainer.getPokemon(pokemonChoice - 1) + " was healed to max HP");
                                } else {
                                    System.out.println("You do not have a potion to heal");
                                }

                                break;
                            case 3:
                                System.out.println("Shake...Shake...Shake...");
                                caught = trainer.catchPokemon(wild);

                                if (caught) {
                                    System.out.println("You caught " + wild.getName());

                                    if (trainer.getNumPokemon() > 6) {
                                        System.out.println("You have 7 pokemon. Please remove one:");
                                        System.out.println(trainer.getPokemonList());
                                        pokemonChoice = CheckInput.getIntRange(1, trainer.getNumPokemon());
                                        Pokemon removedPokemon = trainer.removePokemon(pokemonChoice - 1);
                                        System.out.println(removedPokemon.getName() + " was removed.");
                                    }

                                    break;
                                } else {
                                    System.out.println(wild.getName() + " jumped out of the Poke Ball!");
                                }

                                break;
                            case 4:
                                int randomDirection = (int) (Math.random() * 4);
                                char charAfterRunAway;

                                switch (randomDirection) {
                                    case 0:
                                        charAfterRunAway = trainer.goNorth();

                                        if (charAfterRunAway == 'x') {
                                            randomDirection = (int) (Math.random() * 3);

                                            switch (randomDirection) {
                                                case 0:
                                                    trainer.goSouth();
                                                    break;
                                                case 1:
                                                    trainer.goEast();
                                                    break;
                                                case 2:
                                                    trainer.goWest();
                                                    break;
                                                default:
                                                    System.out.println("Invalid direction");
                                                    break;
                                            }
                                        }

                                        break;
                                    case 1:
                                        charAfterRunAway = trainer.goSouth();

                                        if (charAfterRunAway == 'x') {
                                            randomDirection = (int) (Math.random() * 3);

                                            switch (randomDirection) {
                                                case 0:
                                                    trainer.goNorth();
                                                    break;
                                                case 1:
                                                    trainer.goEast();
                                                    break;
                                                case 2:
                                                    trainer.goWest();
                                                    break;
                                                default:
                                                    System.out.println("Invalid direction");
                                                    break;
                                            }
                                        }

                                        break;
                                    case 2:
                                        charAfterRunAway = trainer.goEast();

                                        if (charAfterRunAway == 'x') {
                                            randomDirection = (int) (Math.random() * 3);

                                            switch (randomDirection) {
                                                case 0:
                                                    trainer.goNorth();
                                                    break;
                                                case 1:
                                                    trainer.goSouth();
                                                    break;
                                                case 2:
                                                    trainer.goWest();
                                                    break;
                                                default:
                                                    System.out.println("Invalid direction");
                                                    break;
                                            }
                                        }

                                        break;
                                    case 3:
                                        charAfterRunAway = trainer.goWest();

                                        if (charAfterRunAway == 'x') {
                                            randomDirection = (int) (Math.random() * 3);

                                            switch (randomDirection) {
                                                case 0:
                                                    trainer.goNorth();
                                                    break;
                                                case 1:
                                                    trainer.goSouth();
                                                    break;
                                                case 2:
                                                    trainer.goEast();
                                                    break;
                                                default:
                                                    System.out.println("Invalid direction");
                                                    break;
                                            }
                                        }

                                        break;
                                    default:
                                        System.out.println("Invalid direction");
                                        break;
                                }

                                System.out.println("Successfully ran away");
                                runAway = true;
                                map.reveal(trainer.getLocation());
                                break;
                            default:
                                System.out.println("Error");
                                break;
                        }

                        for (int i = 0; i < trainer.getNumPokemon(); i++) {
                            if (trainer.getPokemon(i).getHp() > 0) {
                                trainerPokemonFainted = false;
                                break;
                            }
                        }
                    } while (wild.getHp() > 0 && !caught && !runAway && !trainerPokemonFainted);

                    if (wild.getHp() == 0) {
                        int money = (int) ((Math.random() * 4) + 1);
                        trainer.receiveMoney(money);

                        System.out.println(wild.getName() + " fainted.");
                        System.out.println("You won the battle!");
                        System.out.println("You gained " + money + " money.");
                    }

                    if (trainerPokemonFainted) {
                        int damage = (int) ((Math.random() * 3) + 1);
                        trainer.takeDamage(damage);

                        System.out.println("All your Pokemon fainted!");
                        System.out.println("You took " + damage + " damage from " + wild.getName());
                        System.out.println(wild.getName() + " ran away.");
                    }

                    if (!runAway) {
                        map.removeCharAtLoc(trainer.getLocation());
                    }

                    break;
                case 'p':
                    int randomPerson = (int) (Math.random() * 3);

                    switch (randomPerson) {
                        case 0:
                            System.out.println("You run into Brock.");
                            System.out.println("Brock: I hope you catch more pokemon!");
                            System.out.println("Brock gives you a Poke Ball");
                            trainer.receivePokeball();
                            break;
                        case 1:
                            System.out.println("You run into Misty.");
                            System.out.println("Misty: Your pokemon look sick...");
                            System.out.println("Misty gives you a potion");
                            trainer.receivePotion();
                            break;
                        case 2:
                            System.out.println("You run into Team Rocket.");
                            System.out.println("Team Rocket: Prepare for trouble! And make it double!");
                            System.out.println("Team Rocket attacks you");

                            int damage = (int) ((Math.random() * 3) + 1);
                            trainer.takeDamage(damage);
                            break;
                        default:
                            System.out.println("Invalid encounter");
                            break;
                    }

                    map.removeCharAtLoc(trainer.getLocation());
                    break;
                case 'c':
                    System.out.println("You've entered the city.");
                    System.out.println("Where would you like to go?");
                    System.out.println("1. Store\n2. Pokemon Hospital");

                    int cityChoice = CheckInput.getIntRange(1, 2);

                    switch (cityChoice) {
                        case 1:
                            store(trainer);
                            break;
                        case 2:
                            System.out.println("Hello! Welcome to the Pokemon Hospital");
                            System.out.println("I'll fix your poor pokemon up in a jiffy!");
                            System.out.println("There you go! See you again soon.");

                            trainer.healAllPokemon();
                            break;
                    }

                    break;
                case 'x':
                    System.out.println("You cannot go that way");
                    break;
                default:
                    break;
            }

            map.reveal(trainer.getLocation());
            System.out.println();

        } while (mainMenuChoice != 5 && trainer.getHp() > 0);

        if (trainer.getHp() == 0) {
            System.out.println("You ran out of HP...");
        }

        System.out.println("Game Over");
    }

    /**
     * Displays the main menu for going either north, south, east, west, or quitting.
     *
     * @return the user input for going a certain direction or quitting
     */
    public static int mainMenu() {
        System.out.println("Main Menu: ");
        System.out.println("1. Go North");
        System.out.println("2. Go South");
        System.out.println("3. Go East");
        System.out.println("4. Go West");
        System.out.println("5. Quit");

        return CheckInput.getIntRange(1, 5);
    }

    /**
     * Trainer t chooses what Pokemon to attack the wild Pokemon wild with.
     * If Trainer's Pokemon does not have hp, Trainer takes random damage.
     * Otherwise, Trainer's Pokemon attacks the wild Pokemon and
     * the wild Pokemon attacks Trainer's Pokemon if it does not faint.
     *
     * @param t    trainer who is attacking the wild Pokemon
     * @param wild wild Pokemon to attack
     * @return
     */
    public static Pokemon trainerAttack(Trainer t, Pokemon wild) {
        System.out.println("Choose a Pokemon:");
        System.out.println(t.getPokemonList());

        int pokemonChoice = CheckInput.getIntRange(1, t.getNumPokemon());
        Pokemon myPokemon = t.getPokemon(pokemonChoice - 1);

        System.out.println(myPokemon.getName() + ", I choose you!");

        if (myPokemon.getHp() == 0) {
            int randomDamage = (int) ((Math.random() * 4) + 1);
            t.takeDamage(randomDamage);

            System.out.println(myPokemon.getName() + " has no HP");
            System.out.println("You took " + randomDamage + " damage");
            return null;
        }

        System.out.println(myPokemon.getAttackTypeMenu());
        int attackChoice = CheckInput.getIntRange(1, myPokemon.getNumAttackTypeMenuItems());

        if (attackChoice == 1) {
            System.out.println(myPokemon.getAttackMenu(attackChoice));
            int basicMoveChoice = CheckInput.getIntRange(1, myPokemon.getNumAttackMenuItems(1));
            System.out.println(myPokemon.attack(wild, attackChoice, basicMoveChoice));
        } else if (attackChoice == 2) {
            System.out.println(myPokemon.getAttackMenu(attackChoice));
            int specialMoveChoice = CheckInput.getIntRange(1, myPokemon.getNumAttackMenuItems(2));
            System.out.println(myPokemon.attack(wild, attackChoice, specialMoveChoice));
        }


        double chance = .25;
        double val = Math.random();

        if (val < chance) {
            t.debuffPokemon(pokemonChoice - 1);
            System.out.println(myPokemon.getName() + " was debuffed!");
        }

        if (wild.getHp() > 0) {
            int wildAttackChoice = (int) ((Math.random() * 2) + 1);

            if (wildAttackChoice == 1) {
                int wildRandomBasicMoveChoice = (int) ((Math.random() * 3) + 1);
                System.out.println(wild.attack(myPokemon, wildAttackChoice, wildRandomBasicMoveChoice));
            } else  if (wildAttackChoice == 2) {
                int wildRandomSpecialMoveChoice = (int) ((Math.random() * 3) + 1);
                System.out.println(wild.attack(myPokemon, wildAttackChoice, wildRandomSpecialMoveChoice));
            }

            chance = .1;
            val = Math.random();

            if (val < chance) {
                PokemonGenerator.getInstance().addRandomDebuff(wild);
                System.out.println(wild.getName() + " was debuffed!");
            }
        }

        return myPokemon;
    }

    /**
     * Displays the store menu and Trainer t decides what to buy based on user input.
     * Potion costs 5 and Poke Ball costs 3. Checks if Trainer has enough money.
     *
     * @param t the Trainer who wants to buy Potions of Poke Balls
     */
    public static void store(Trainer t) {
        int storeChoice;

        do {
            System.out.println("Hello! What can I help you with?");
            System.out.println("1. Buy Potions - $5\n2. Buy Poke Balls - $3\n3. Exit");

            storeChoice = CheckInput.getIntRange(1, 3);

            switch (storeChoice) {
                case 1:
                    if (t.spendMoney(5)) {
                        System.out.println("Here's your potion.");
                        t.spendMoney(5);
                        t.receivePotion();
                    } else {
                        System.out.println("You do not have enough money to buy a potion.");
                    }

                    break;
                case 2:
                    if (t.spendMoney(3)) {
                        System.out.println("Here's your Poke Ball.");
                        t.spendMoney(3);
                        t.receivePokeball();
                    } else {
                        System.out.println("You do not have enough money to buy a Poke Ball.");
                    }

                    break;
                case 3:
                    System.out.println("Thank you, come again soon!");
                    return;
                default:
                    System.out.println("Invalid store choice");
                    break;
            }
        } while (storeChoice != 3);
    }
}
