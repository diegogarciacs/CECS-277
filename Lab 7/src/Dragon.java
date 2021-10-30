public class Dragon
{
    private String name;
    private int hp;
    private int maxHp;

    public Dragon(String n, int mHp)
    {
        name = n;
        maxHp = mHp;
        hp = mHp;
    }

    public String getName()
    {
        return name;
    }
    public int getHp()
    {
        return hp;
    }


    public int attack(){
        int Min = 3;
        int Max = 7;
        int Damage = 0;
        Damage = Min + (int)(Math.random() * ((Max - Min) + 1));
        return Damage;
    }

    public void takeDamage(int d)
    {
        hp = hp - d;
        if (hp < 0){
            hp = 0;
        }
    }

    public String toString()
    {

        return name + " " + hp + "/" + maxHp;
    }

}