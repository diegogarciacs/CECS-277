public class Tiger extends Cat
{
  /*
  Constructor that names tiger while refering to the parent object cat.
  @param name of tiger. 
  */
  public Tiger(String n)
  {
    super(n);
  }
  /*
  Function that increments hunger of tabby and deals damage if tiger is full.
  @param Object of player to update health.
  @return string detailing the result of feeding the tiger.
  */
  @Override
  public String feed(Player p)
  {
    incrementHunger(2);
    if(getHunger() == 10) // 3 dmg
    {
      p.takeDamage(3);
      return getName() + " is full and slashed you for " + 3 + " HP.\n";
    }
    
    return getName() + " enjoys a bucket of chicken breasts.\n";
  }
  /*
  Accepts object of player to play with tiger and returns a string detailing the experience.
  @param p Player object.
  @return String results of playing.
  */
  @Override
  public String play(Player p)
  { 
    incrementHunger(-2);
    if(getHunger() <= 1) // 5 dmg
    {
      p.takeDamage(5);
      return getName() + "drools and bites your head for " + 5 + " HP.\n" + getName() +  " is dying.\n";
      
    }
    else if(getHunger() <= 3) // 4 dmg
    {
      p.takeDamage(4);
      return getName() + " licks and gnaws on your legs for " + 4 + " HP.\n" + getName() +  " is starving.\n";
     
    }
    else if(getHunger() <= 5) // 2 dmg
    {
      p.takeDamage(2);
      return getName() + " nibbles at your hand for " + 2 + " HP.\n" + getName() +  " is peckish.\n";
    }
    
    return getName() + " jumps on you and starts to cuddle.\n" ;
  }
  /*
  Accepts object of player to pet the tiger and returns a string detailing the experience.
  @param p Player object.
  @return String results of petting.
  */
  @Override
  public String pet(Player p)
  {
    incrementHunger(-2);
    if(getHunger() <= 1) // 5 dmg
    {
      p.takeDamage(3);
      return getName() +  " is extremely hungry and chews on your on hand for " + 5 + " HP.\n";
    }
    else if(getHunger() <= 3) // 4 dmg
    {
      p.takeDamage(4);
      return getName() +  " is very hungry and scratches you for " + 4 + " HP.\n";
    }
    else if(getHunger() <= 5) // 2 dmg
    {
      p.takeDamage(2);
      return getName() +  " is a bit hungry and scratches you for " + 2 + " HP.\n";
    }

    return getName() + " lets you pet them before chasing other down another cat.\n";
  }
  @Override
  public String toString()
  {
    return getName() + " is currently at a level of " + getHunger() + "/10 hunger.";
  }
}