public class FlyingDragon extends Dragon{
    private int swoops = 5;

    public FlyingDragon(String n, int mHp){
        super(n, mHp);
    }

    public int swoopAttack(){
        if (swoops > 0){
            int Min = 5;
            int Max = 10;
            int Damage = 0;
            Damage = Min + (int)(Math.random() * ((Max - Min) + 1));
            swoops -= 1;
            return Damage;
        }else{
            return 0;
        }
    }

    @Override
    public String toString(){

        return super.toString() + "\nSwoops attacks remaining: " + swoops;
    }

}