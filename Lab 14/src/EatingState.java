public class EatingState implements PuppyState{
    /**
     * Function that increments the puppys plays and sets the puppy into the playstate.
     * @return string detailing the current puppy status.
     */
    @Override
    public String play(Puppy p) {
        p.setState(new PlayState());
        p.incPlays();
        return "The puppy looks up from it's food and chases down the ball.";
    }
    /**
     * Function that increments the puppies feeds (unless it reaches a increment greater than 2, where it's reset to default asleep state) and returns current puppy action.
     * @return string detailing current puppy status.
     */
    @Override
    public String feed(Puppy p) {
        int n = p.incFeeds();
        if (n > 2){
            p.reset();
            return "The puppy eats so much it falls asleep";
        }
        return "The puppy continues to eat as you add another scoop of kibble to it's bowl.";
    }
}
