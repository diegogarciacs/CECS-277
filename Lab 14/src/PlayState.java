public class PlayState implements PuppyState
{
    /**
     * Function that increments the puppys plays (unless it's over 2 in which case it resets to default sleep state) and returns a string.
     * @return string detailing the current puppy status.
     */
    @Override
    public String play(Puppy p)
    {
        int n = p.incPlays();
        if (n > 2){
            p.reset();
            return "The puppy played so much it feel asleep!";
        }
        return "The puppy bounds after the ball.";
    }
    /**
     * Function that increments the puppys feeds (unless that value is over 2 in which case it resets to default sleep state) and returns a string.
     * @return string detailing the current puppy status.
     */
    @Override
    public String feed(Puppy p)
    {
        int n = p.incFeeds();
        if (n > 2){
            p.reset();
            return "The puppy ate so much that it fell asleep";
        }
        return "The puppy excitedly begins eating.";
    }
}