import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Dragon> dragons = new ArrayList<Dragon>();
		dragons.add(new Dragon("Paarthurnax",10));
		dragons.add(new FireDragon("Volvagia",15));
		dragons.add(new FlyingDragon("Spyro",20));
		int uHP = 50;
		System.out.print("Name? ");
		String name = in.nextLine();
		System.out.println("Excellent, now fight for your life.");
		System.out.println("3 dragons stand before you.");
		boolean fight = true;
		while (fight)
		{
			System.out.println(name+ " HP: "+uHP);
			for (Dragon d: dragons)
			{
				if (d.getHp() != 0)
				{
					int index = dragons.indexOf(d);
					System.out.print(index + 1 + ". " +" Attack ");
					System.out.println(d);

				}

			}
			int attack = CheckInput.getIntRange(1,3);
			boolean dead = true;
			while (dead)
			{
				while (dragons.get(attack-1).getHp() == 0 )
				{
					System.out.println("Invalid input.");
					attack = CheckInput.getIntRange(1,3);
				}
				dead = false;
			}
			System.out.println("Choose your weapon.");
			System.out.print("1. Arrow (1 D12)\n");
			System.out.print("2. Sword (2 D6)\n");
			int weaponChoice = CheckInput.getIntRange(1,2);
			if (weaponChoice == 1) {
				int damage = 1 + (int) (Math.random() * ((12 - 1) + 1));
				dragons.get(attack - 1).takeDamage(damage);
				System.out.println("You shoot the dragon with an arrow.");
				uHP = receiveDamage(dragons, uHP);

			} else if (weaponChoice == 2)
			{
				int damage = 1 + (int) (Math.random() * ((6 - 1) + 1));
				dragons.get(attack-1).takeDamage(damage);
				damage = 1 + (int) (Math.random() * ((6 - 1) + 1));
				dragons.get(attack-1).takeDamage(damage);
				System.out.println("You slash at the dragon with your sword.");
				uHP = receiveDamage(dragons,uHP);


			}
			System.out.println();
			if (isDead(dragons))
			{
				System.out.println("Congratulations! I didn't think you'd survive that.");
				System.out.println("You've defeated all three dragons.");
				fight = false;
			}
			if (uHP <= 0)
			{
				uHP = 0;
				System.out.println("You collapse...and take your final breath.");
				System.out.println("*YOU'VE DIED*");
				fight = false;
			}



		}
	}
	public static int receiveDamage(ArrayList<Dragon> dragons, int uHP)
	{
		boolean unAttacked = true;
		while (unAttacked)
		{
			int randomAttack =  1 + (int)(Math.random() * ((2 - 1) + 1));
			int randomDrag = (int) (Math.random() * ((2) + 1));
			if (dragons.get(randomDrag).getHp() != 0 && randomDrag == 0) {

				System.out.println("Paarthurnax slashes you with his sharp claws!");
				uHP = uHP - dragons.get(0).attack();
				unAttacked = false;
				return uHP;

			} else if (dragons.get(randomDrag).getHp()!= 0 && randomDrag ==1)
			{
				if (randomAttack == 1) {
					System.out.println("Volvagia slashes you with it's sharp claws.");
					uHP = uHP - dragons.get(0).attack();
					unAttacked = false;
					return uHP;
				} else if (randomAttack == 2) {
					System.out.println("You're burned by Volvagia's flames!");
					Dragon d = dragons.get(1);
					if (d instanceof FireDragon) {
						int damage = ((FireDragon) d).fireShot();
						uHP = uHP - damage;
						unAttacked = false;
						return uHP;
					}
				}

			} else if (dragons.get(randomDrag).getHp() != 0 && randomDrag == 2)
			{
				if (randomAttack == 1) {
					System.out.println("Spyro slashes you with his sharp claws.");
					uHP = uHP - dragons.get(0).attack();
					unAttacked = false;
					return uHP;
				} else if (randomAttack == 2) {
					System.out.println("Spyro swoops down and knocks you down!");
					Dragon d = dragons.get(2);
					if (d instanceof FlyingDragon) {
						int damage = ((FlyingDragon) d).swoopAttack();
						uHP = uHP - damage;
						unAttacked = false;
						return uHP;
					}
				}

			} else if (isDead(dragons)){
				unAttacked = false;
			}

		}
		return  uHP;
	}
	public static boolean isDead(ArrayList<Dragon> dragons){
		if (dragons.get(0).getHp() == 0 && dragons.get(1).getHp() == 0 && dragons.get(2).getHp() == 0){
			return true;
		}
		return false;
	}

}