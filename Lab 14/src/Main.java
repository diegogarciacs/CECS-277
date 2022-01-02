/*
  Vo, Nguyen
  Garcia, Diego
  CS277
  LAB 14
  12/09/2021
*/

class Main {
    public static void main(String[] args) {

        System.out.println("Congratulations! You just got a new puppy!");
        Puppy p = new Puppy();
        int choice = 0;
        while(choice != 3)
        {

            System.out.println("1. Feed\n2. Play\n3. Quit");
            choice = CheckInput.getIntRange(1,3);
            if(choice == 1)
                System.out.println(p.giveFood());
            else if(choice == 2)
                System.out.println(p.throwBall());
        }
    }
}