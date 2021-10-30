public class Tabby extends Cat
{
  /*
  Constructor that names tabby while refering to the parent object cat.
  @param name of tabby. 
  */
  public Tabby(String n)
  {
    super(n);
  }
  /*
  Function that increments hunger of tabby and deals damage if tabby is full.
  @param Object of player to update health.
  @return string detailing the result of feeding the tabby.
  */
  @Override
  public String feed(Player p)
  {
    incrementHunger(2);
    if(getHunger() == 10) // 1 dmg
    {
      p.takeDamage(1);
      return getName() + " is full and slashed you for " + 1 + " HP.\n";
    }

    return getName() + " enjoys a bowl full of food.\n";
  }
  /*
  Accepts object of player to play with tabby and returns a string detailing the experience.
  @param p Player object.
  @return String results of playing.
  */
  @Override
  public String play(Player p)
  { 
    incrementHunger(-2);
    if(getHunger() <= 1) // 3 dmg
    {
      p.takeDamage(3);
      return getName() +  " bites you for " + 3 + " HP.\n" +  getName() +  " is dying.\n";
    }
    else if(getHunger() <= 3) // 2 dmg
    {
      p.takeDamage(2);
      return getName() +  " scratches you for " + 2 + " HP.\n" + getName() +  " is starving.\n";
    }
    else if(getHunger() <= 5) // 1 dmg
    {
      p.takeDamage(1);
      return getName() +  " hisses at you for " + 1 + " HP.\n" + getName() +  " is peckish.\n";
    }
    
    return getName() + " jumps on you and starts to cuddle.\n" ;
  }
  /*
  Accepts object of player to pet the tabby and returns a string detailing the experience.
  @param p Player object.
  @return String results of petting.
  */
  @Override
  public String pet(Player p)
  {
    incrementHunger(-2);
    if(getHunger() <= 1) // 3 dmg
    {
      p.takeDamage(3);
      return getName() + " scratches your face for " + 3 + " HP.\n" + getName() +  " is dying.\n";
    }
    else if(getHunger() <= 3) // 2 dmg
    {
      p.takeDamage(2);
      return getName() +  " scratches your hand for " + 2 + " HP.\n" + getName() +  " needs food.\n";
    }
    else if(getHunger() <= 5) // 1 dmg
    {
      p.takeDamage(1);
      return getName() + " scratches your finger for " + 1 + " HP.\n" + getName() +  " is a bit hungry.\n";
    }

    return getName() + " lets you pet them before scurrying under the table.\n";
  }
  @Override
  public String toString()
  {
    return getName() + " is currently at a level of " + getHunger() + "/10 hunger.";
  }
}