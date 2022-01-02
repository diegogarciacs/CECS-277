/* Ball class modification of a Singleton object
 */

import java.util.*;

public class Ball{
    private static HashMap<String, Ball> colors = new HashMap<String, Ball>();
    private String color;
    private int bounces;
    private int rolls;

    /* Ball constructor
     */
    public Ball(String c){
        this.color = c;
        this.bounces = 0;
        this.rolls = 0;
        colors.put(c, this);
    }
    /* Accceses the hashmap and checks to see if the object already exists, otherwise constructs the object and returns it to be inserted.
     *
     * @param c the key of the object to be checked.
     * @return the object which to be modified.
     */
    public static Ball getInstance(String c) {

        if (colors.containsKey(c)) {
            return colors.get(c);
        }
        else{
            return new Ball(c);
        }
    }

    /* Increment the bounce count of a ball
     *
     */
    public void bounce(){
        this.bounces += 1;
    }

    /* Increment the roll count of a ball
     */
    public void roll(){
        this.rolls += 1;
    }

    /* String representation of a ball object
     * @return returns a string detailing the current status of the users ball
     */
    @Override
    public String toString(){
        return String.format("%s Ball:\n--------\nRolls: %d\nBounces: %d\n",
                this.color,
                this.rolls,
                this.bounces);
    }
}