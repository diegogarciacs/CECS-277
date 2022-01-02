public class AsleepState implements PuppyState{
    /**
     * Function that returns a string that tells the user it's currently asleep and unwilling to play.
     * @return string detailing the current puppy status.
     */
    @Override
    public String play(Puppy p) {
        return "Puppy is asleep. It doesn't wanna play now.";
    }
    /**
     * Function that sets the puppy into an eatingState, increments the number of feeds, and returns a string of the puppy action.
     * @return string detailing the current puppy status.
     */
    @Override
    public String feed(Puppy p) {
        p.setState(new EatingState());
        p.incFeeds();
        return "The puppy smells the food and jolts awake.";
    }

}
