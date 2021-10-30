/*
Name: Diego Garcia, Krystal Macias
Date: 9/30/2021
Description: Yahtzee Composition
*/

class Main 
{
  public static void main(String[] args) 
  {
    //create instance of Player class
    Player p1 = new Player();
    //prime the loop kronk
    boolean playAgain = true;
    while (playAgain)
    {
      //pass the Player instance into takeTurn()
      takeTurn(p1);
      System.out.print("Play again? (Y/N) ");
      playAgain = CheckInput.getYesNo();
      
    }
    //wrong loooooop
  }
  /* Calls the roll method, displays the result of the roll and the players score
  @param p1 player object
  */
  public static void takeTurn(Player p1)
  {
    //roll p1 dices
    p1.roll();
    System.out.println("Rolling Dice... " + p1.toString());

    if (p1.pair())
    {
      System.out.println("You got a pair!");
    }
    else if (p1.threeOfAKind())
    {
      System.out.println("You got 3 of a kind!");
    }
    else if (p1.series())
    {
      System.out.println("You got a series of 3!");
    }
    else
    {
      System.out.println("Aww. Too Bad.");
    }

    System.out.println("Score = "+ p1.getPoints() + " points.");
  }
}