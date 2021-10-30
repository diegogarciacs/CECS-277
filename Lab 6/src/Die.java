
public class Die
{
  // instance variables
  private int sides;
  private int value; 
  
  /* Assigns the number of sides based on the value given in player
  @param s is the amount of sides given
  */
  public Die (int s)
  {
    sides = s;
    value  = 0;
  }
  
  /* Generates a random number and assigns it to value
  @return value of the roll.
  */
  public int roll ()
  {
    value = (int)(Math.random() * sides) + 1;
    return value;
  }

  /* Checks if two values are the same
  @param o side from dice
  @return true if the values are the same
  */
  @Override
  public boolean equals(Object o)
  {
    //checks to see if object o passed in is actually an object of Die
    if( o instanceof Die)
    {
      Die d = (Die) o;
      return value == d.value && sides == d.sides;
    }
    return false;
  }

  /* Compares the value of the implicit die and the explicit die
  @param d the value of the explicit die
  @return true if the implicit value is less than explicit
  */
  public boolean lessThan(Die d)
  {
    if (value < d.value)
    {
      return true;
    }
    return false;
  }

  /* Finds the difference between the implicit and explicit die values
  @param d the value of the explicit die
  @ return the difference between the two dies
  */
  public int difference(Die d)
  {
    int difference = value - d.value;
    return difference;
  }
  /* Converts the value of the die into a string
  @return the string value of die
  */
  @Override
  public String toString()
  {
    String result = value + "";
    return result;
  }
  
}