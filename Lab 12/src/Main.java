/*
 * Kyle Hughes, Diego Garcia, Yoshiki Yarlagadda
 *
 * Lab 12 Prototype.
 *
 * November, 16 2021
 *
 * A game where the user will encounter random enemies from a file and will try
 * to defeat as many as the player can. Note that the enemies are clones from
 * a template ArrayList of enemies.
 */

class Main {
    public static void main(String[] args)
    {
        EnemyGenerator enemy_gen = new EnemyGenerator();
        //player's stats
        int player_hp = 25;
        int player_max_hp = player_hp;
        int enemys_slain = 0;

        //random enemy generated
        Enemy rand_enemy = enemy_gen.generateEnemy();
        boolean slain = true;
        while(player_hp > 0)
        {
            //checking if new encounter initiated
            if(slain)
            {
                System.out.println("You have " + player_hp + '/' + player_max_hp + " hp.");
                System.out.println("You have encountered a " + rand_enemy.getName()+".");
                slain = false;
            }
            System.out.println(rand_enemy.toString());

            System.out.println("What do you want to do?");
            System.out.println("1. Attack Enemy");
            System.out.println("2. Quit");
            int user_menu_choice = CheckInput.getIntRange(1,2);

            //if user quits end the game
            if (user_menu_choice == 2)
            {
                System.out.println("Quitting.");
                break;
            }

            //user attack will deal a random int from 1-5 dmg to the enemy
            int rand_dmg = (int)(Math.random() * 5) + 1;
            System.out.println("You attack the " + rand_enemy.getName() + " for " + rand_dmg+".");
            rand_enemy.takeDamage(rand_dmg);

            //if the enemy is not defeated let the enemy attack the player
            if (rand_enemy.getHp() > 0)
            {
                int enemy_dmg = rand_enemy.attack();
                System.out.println("The " + rand_enemy.getName() + " attacks you for " + enemy_dmg + ".");
                player_hp -= enemy_dmg;
            }
            //if the enemy is defeated generate a new enemy and increment enemy's slain.
            else
            {
                enemys_slain++;
                System.out.println("You have slain the " + rand_enemy.getName() + ".\n");
                rand_enemy = enemy_gen.generateEnemy();
                slain = true;
            }
        }
        //if the player has been defeated
        if(player_hp <= 0)
        {
            System.out.println("You have died.");
            System.out.println("Enemies slain: " + enemys_slain);
            System.out.println("Game Over.");
        }
        //if the player quit the game.
        else
        {
            System.out.println("Enemies slain: " + enemys_slain);
        }
    }
}