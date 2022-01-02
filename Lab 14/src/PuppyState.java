public interface PuppyState {
    /**
     * State will override this play function.
     * @return returns puppy status string based on state
     */
    public String play(Puppy p);
    /**
     * State will override this play function.
     * @return returns puppy status string based on state
     */
    public String feed(Puppy p);
}
