public class FireDragon extends Dragon{
    private int fireShots = 3;

    public FireDragon(String n, int mHp)
    {
        super(n, mHp);
    }

    public int fireShot(){
        if (fireShots > 0){
            int Min = 5;
            int Max = 9;
            int Damage = 0;
            Damage = Min + (int)(Math.random() * ((Max - Min) + 1));
            fireShots -= 1;
            return Damage;
        }else{
            return 0;
        }
    }

    @Override
    public String toString(){
        return super.toString() + "\nFire Shots remaining: " + fireShots;
    }

}