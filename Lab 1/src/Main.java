import java.util.Random;

class Main {
  public static void main(String[] args) {

    // initializing variables
    Random random = new Random();

    // random number between 0 - 100
    int randomNumber = random.nextInt(101);

    int maxRange = 100;
    int guess = 0;
    int minRange = 0;
    int count = 0;

    // initialize boolean guess
    Boolean notGuessed = true;

    // prompt the user to enter a number
    System.out.print("I’m thinking of a number. Guess a value (1-100): ");

    while (notGuessed){
      // check if input is valid
      guess = CheckInput.getIntRange(minRange, maxRange);

      // increment counter
      count ++;

      // check if guess is correct
      if (guess == randomNumber){
        notGuessed = false;
      }

      // if the guess is not correct, tell the user
      else{
        String message = "";
        // if guess is too high, store message
        if (guess > randomNumber){
          message = "Too High.";
        //else if guess is too low, store message
        } else{
          message = "Too Low. ";
        }
        // prompt the user to ask again
        System.out.print(message + " Guess again: ");
      }
    }
    // tell the user they guessed the number correct
    System.out.println("Correct!  You got it in " + count + " tries.");
  }
}