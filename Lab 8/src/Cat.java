public abstract class Cat
{
  //initialize variables
  private String name;
  private int hunger;
  /*
  Default constructor that initializes name and hunger.
  @param the name of the cat.
  */
  public Cat(String n)
  {
    name = n;
    hunger = 10;
  }
  /*
  Returns the name of the cat.
  @return name of the cat.
  */
  public String getName()
  {
    return name;
  }
  /*
  Returns the current hunger of the cat.
  @return hunger current hunger of the cat.
  */
  public int getHunger()
  {
    return hunger;
  }
  /*
  Increments hunger by the passed in variable amount and returns the new hunger.
  @param the amount to increment/decrement hunger by.
  */
  public int incrementHunger(int val)
  {
    hunger += val;
    if(hunger < 1)
    {
      hunger = 1;
    }
    else if(hunger > 10)
    {
      hunger = 10;
    }
    return hunger;
  }
  /*
  Abstract method that will feed the cat that it's called on. 
  @param Player object to be affected.
  @return String of cats reaction to feeding.
  */
  abstract String feed(Player p);
  /*
  Abstract method that will play with the cat that it's called on. 
  @param Player object to be affected.
  @return String of cats reaction to playing.

  */
  abstract String play(Player p);
  /*
  Abstract method that will pet the cat that it's called on. 
  @param Player object to be affected.
  @return String of cats reaction to petting.
  */
  abstract String pet(Player p);
    
  public String toString()
  {
    return name + " is currently at a level of " + hunger + "/10 hunger.";
  }
}