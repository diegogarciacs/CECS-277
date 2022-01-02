public class Puppy {
    private PuppyState state;
    private int numFeeds;
    private int numPlays;
    public Puppy(){
        numFeeds = 0;
        numPlays = 0;
        state = new AsleepState();
    }

    /**
     set the state with the given paremeter s
     @param s the state being passed in
     */
    public void setState(PuppyState s){
        state = s;
    }

    /**
     returns a message when giving food to the puppy
     @return a message based on the puppy's state
     */
    public String throwBall(){
        return state.play(this);
    }
    /**
     returns a message when playing with the puppy
     @return a message based on the puppy's state
     */
    public String giveFood(){
        return state.feed(this);
    }
    /**
     returns the count for numFeeds
     @return the count for numFeeds
     */
    public int incFeeds(){
        numFeeds++;
        return numFeeds;
    }
    /**
     returns the count for numPlays
     @return the count for numPlays
     */
    public int incPlays(){
        numPlays++;
        return numPlays;
    }


    /** resets the state and the counts for numPlays/numFeeds
     */
    public void reset(){
        numFeeds = 0;
        numPlays = 0;
        state = new AsleepState();
    }
}
