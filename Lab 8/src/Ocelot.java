public class Ocelot extends Cat
{
  /*
  Constructor that names ocelot while refering to the parent object cat.
  @param name of ocelot. 
  */
  public Ocelot(String n)
  {
    super(n);
  }
  /*
  Function that increments hunger of ocelot and deals damage if ocelot is full.
  @param Object of player to update health.
  @return string detailing the result of feeding the ocelot.
  */
  @Override
   public String feed(Player p)
  {
    incrementHunger(2);
    if(getHunger() == 10) // 1 dmg
    {
      p.takeDamage(2);
      return getName() + " is full and slashed you for " + 2 + " HP.\n";
    }

    return getName() + " enjoys a salmon's tail.\n";
  }
  /*
  Accepts object of player to play with ocelot and returns a string detailing the experience.
  @param p Player object.
  @return String results of playing.
  */
  @Override
  public String play(Player p)
  {
    incrementHunger(-2); 
    if(getHunger() <= 1) // 4 dmg
    {
      p.takeDamage(4);
      return getName() +  " is extremely hungry and bites you for " + 4 + " HP.\n";
    }
    else if(getHunger() <= 3) // 3 dmg
    {
      p.takeDamage(3);
      return getName() +  " is very hungry and scratches you for " + 3 + " HP.\n";
    }
    else if(getHunger() <= 5) // 1 dmg
    {
      p.takeDamage(1);
      return getName() +  " is a bit hungry and hisses at you for " + 1 + " HP.\n";
    }
    
    return getName() + " jumps on you and starts to cuddle.\n" ;
  }
  /*
  Accepts object of player to pet the ocelot and returns a string detailing the experience.
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
      return getName() +  " is extremely hungry and scratches you for " + 3 + " HP.\n";
    }
    else if (getHunger() <= 3) // 2 dmg
    {
      p.takeDamage(2);
      return getName() +  " is very hungry and scratches you for " + 2 + " HP.\n";
    }
    else if(getHunger() <= 5) // 1 dmg
    {
      p.takeDamage(1);
      return getName() +  " is a bit hungry and scratches you for " + 1 + " HP.\n";
    }

    return getName() + " lets you pet them before hiding from the tiger.\n";
  }
  @Override
  public String toString()
  {
    return getName() + " is currently at a level of " + getHunger() + "/10 hunger.";
  }
}