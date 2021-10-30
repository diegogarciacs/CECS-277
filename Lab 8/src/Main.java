/* 
   Vo, Nguyen 
   Garcia, Diego
   LAB 8 CS277
   10/14/2021
*/
class Main {
  public static void main(String[] args) {
    Player owner = new Player();

    System.out.println("Choose a kitty");
    System.out.println("1. Ocelot");
    System.out.println("2. Tabby");
    System.out.println("3. Tiger");
    int cat = CheckInput.getIntRange(1, 3);
    System.out.print("Name your kitty: ");
    String n = CheckInput.getString();
    switch(cat)
    {
      case 1: Ocelot c = new Ocelot(n);
              interactCat(c, owner);
              break;  
      case 2: Tabby a = new Tabby(n);
              interactCat(a, owner);
              break;
      case 3: Tiger t = new Tiger(n);
              interactCat(t, owner);
              break;
    }  
  }
  /*
  Method that initiates the interaction with chosen cat.
  @param c the object of cat.
  @param p the object of player.
  */
  public static void interactCat(Cat c, Player p)
  { 
    while(p.getHp() > 0)
    {
      System.out.println("1. Feed your cat");
      System.out.println("2. Play with your cat");
      System.out.println("3. Pet your cat");
      int action = CheckInput.getIntRange(1,3);
      switch(action)
      {
        case 1: System.out.print(c.feed(p));
                break;
        case 2: System.out.print(c.play(p));
                break;
        case 3: System.out.print(c.pet(p));
                break;
      }
      System.out.print(p.toString());
      if(c.getHunger() == 1)
      {
        System.out.println(c.getName() + " is extremely hungry.");
      }
      else if(c.getHunger() <= 3)
      {
        System.out.println(c.getName() + " is very hungry.");
      }
      else if(c.getHunger() <= 7)
      {
        System.out.println(c.getName() + " is a bit hungry.");
      }
      else if(c.getHunger() < 10)
      {
        System.out.println(c.getName() + " is normal.");
      }
      else if(c.getHunger() == 10)
      {
        System.out.println(c.getName() + " is full.");
      }
    }
    System.out.println("You are dead. Game Over!");
  }
}