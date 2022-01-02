/*
 * Alfredo Sequeida
 * Diego Garcia
 * 11/9/2021

 * Group 5
 * Lab 11
 * This program takes user input and asks the user what they want to do with a ball.
 * It then keep track of that action using a singleton-like Ball object.
 */
class Main {
    public static void main(String[] args) {

        boolean keepAsking = true;

        while (keepAsking){
            System.out.println("Choose a ball color. Type it in string format. (q to quit):");
            String color = CheckInput.getString();
            if (color.equals("q")){
                keepAsking = false;
                break;
            }
            System.out.println("1. Roll ball\n2. Bounce ball");
            int option = CheckInput.getIntRange(1,2);

            Ball ball = Ball.getInstance(color);

            switch(option){
                case (1):
                    ball.roll();
                    break;
                case (2):
                    ball.bounce();
                    break;
            }

            System.out.println(ball);
        }
    }
}