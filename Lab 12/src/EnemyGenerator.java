import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class EnemyGenerator
{
    //Template enemy List
    private ArrayList<Enemy> enemyList = new ArrayList<Enemy>();

    /**
     *Constructor that fills 'enemyList' from the enemies inside of 'enemyList.txt'
     */
    public EnemyGenerator()
    {
        try
        {
            Scanner read = new Scanner(new File("enemyList.txt"));
            while(read.hasNext())
            {
                String s = read.nextLine();
                String[] split_enemy = s.split(",");
                enemyList.add(new Enemy(split_enemy[0], Integer.parseInt(split_enemy[1])));
            }
            read.close();
        }
        catch(FileNotFoundException fnf)
        {
            System.out.print("File not found.");
        }
    }

    /**
     *retruns a random Enemy clone copy from 'enemyList'
     *@return:a random Enemy clone copy from 'enemyList'
     */
    public Enemy generateEnemy()
    {
        return enemyList.get((int)(Math.random() * enemyList.size())).clone();
    }
}