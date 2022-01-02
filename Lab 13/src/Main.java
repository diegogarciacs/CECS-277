public class Main {
    public static void main( String [] args ){
        System.out.println("Monster Creator!");
        System.out.println("Choose a monster.");
        System.out.println("1. Alien\n2. Beast\n3. Undead");
        int choice = CheckInput.getIntRange(1,3);
        monsterBuffer(choice);
    }

    /**
     * Method that takes the initial choice if user to create a base monster, then buffs.
     * @param choice initial choice of monster.
     */
    public static void monsterBuffer(int choice){
        Monster m = null;
        if (choice == 1){
            m = new Alien("Alien",2);

        } else if (choice == 2){
            m = new Beast("Beast",3);
        } else if (choice == 3){
            m = new Undead("Undead",3);
        }
        boolean again = true;
        while (again){
            System.out.println(m.getName()  + " has " + m.getHp() +" health, and attacks for " + m.attack()+ " damage" +
                    ".");
            System.out.println("Add an ability:\n1. Fire\n2. Flying\n3. Lasers\n4. Poison\n5. Quit");
            choice = CheckInput.getIntRange(1,5);
            if (choice == 1){
                m = new Fire(m);
            } else if (choice == 2){
                m = new Flying(m);
            } else if (choice == 3){
                m = new Lasers(m);
            } else if (choice == 4){
                m = new Poison(m);
            } else if (choice == 5){
                again = false;
            }
        }

    }

}
