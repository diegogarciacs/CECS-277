public class Player
{
  // create instance variables of Die array and points
  private Die []dice;
  private int points;
  // constructor for player
  public Player()
  {
    //create an array with space for 3 objects
    dice = new Die[3];
    //populate each die with 6 sides
    for (int i = 0; i < dice.length; i++)
    {
      dice[i] = new Die(6);
    }
    //initialize points
    points = 0;
  }
  /*
  Method which returns current amount of points.
  @return points the current number of accumulated points.
  */
  public int getPoints()
  {
    return points;
  }
  /*
  Sorts the dice arrays in asccending order.
  */
  public void sort()
  {
    //bubble sort inbound
    for (int i = 0; i < dice.length-1; i++)
    {
      for (int j = i + 1; j < dice.length; j++)
      {     
        if (dice[j].lessThan(dice[i]))
        {
          Die temp = dice[j];
          dice[j] = dice[i];
          dice[i] = temp;
        }
      }
    }
  }
  /*
  Method that determines if there was a pair in the rolls.
  @return returns true/false if there is a pair in the 3 rolls.
  */
  public boolean pair()
  {
    int i = 0;
    if (dice[i].equals(dice[i+1]))
    {
      if (dice[i].equals(dice[i+2]))
      {
        //if a series of 3, break and do not add points
        return false;
      }
      points += 1;
      return true;
    } 

    if (dice[i+1].equals(dice[i+2]))
    {
      points += 1;
      return true;
    }
    return false;

  }
  /*
  Method that determines if all rolls are the same and adds the neccesary points.
  @return boolean that indicates if the rolls were all the same. 
  */
  public boolean threeOfAKind()
  {
    if (dice[0].equals(dice[1]) && dice[1].equals(dice[2]))
    {
      points +=3;
      return true;
    } 
    return false;
  }
  /*
  Method that determines if all the rolls are in ascending order and adds the proper points.
  @return boolean that determines if the rolls are ascending.
  */
  public boolean series()
  {
    for (int i = 0; i < dice.length -1; i++)
    {
      if(dice[i+1].difference(dice[i]) != 1)
      {
        return false;
      }
    }
    points +=2;
    return true;
  }
  /*
  Method that rolls all the dice in the array.
  */
  public void roll()
  {
    for (int i=0; i < dice.length; i++)
    {
      dice[i].roll();    
    }
    sort();
  }
  /*
  Method that overrides the toString() method to print out all the dice as intended.
  @return returns the string.
  */
  
  @Override
  public String toString()
  {
   return "D1 = " + dice[0].toString()+ ", " + "D2 = "+ dice[1].toString()+ ", " + "D3 = "+ dice[2].toString();
  }
 
}