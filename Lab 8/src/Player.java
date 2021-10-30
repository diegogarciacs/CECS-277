public class Player
{
  //initializes variables
  private int hp;
  private int mHp;
  /*
  Default constructor which initializes the player hp/mHp.
  */
  public Player()
  {
    hp = 10;
    mHp = hp;
  }
  /*
  Returns the current hp of the player object.
  @return current hp of player.
  */
  public int getHp()
  {
    return hp;
  }
  /*
  Inflicts damage on the player object (subtracts from hp).
  @param amount of damage to inflict on player.
  */
  public void takeDamage(int d)
  {
    if (hp > d){
      hp -= d;
    } 
    else {
      hp = 0;
    }
  }
  /*
  Overrides the toString to return a string of current player health.
  @return string of current player health.
  */
  @Override
  public String toString()
  {
    return "You have " + hp + "/" + mHp + " HP" + "\n";
  }
}