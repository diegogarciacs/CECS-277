/*
Name: Diego Garcia, Yoshiki Yarlagadda
Date: 9/16/2021
Description: States and Populations: File IO
*/
import java.util.ArrayList;
import java.util.Scanner; 
import java.io.FileNotFoundException;
import java.io.*;
class Main {
  public static void main(String[] args) {
    // Create ArrayList to store states.
    ArrayList <String> states = new ArrayList <String> ();
    // Create ArrayList to store populations.
    ArrayList <Integer> population = new ArrayList <Integer> ();
    // Passes in both ArrayLists and reads the file into both.
    readFile(states,population);
    // Passes in both ArrayLists and displays menu.
    //menu();
    int choice;
    do{
      menu();
      choice = CheckInput.getIntRange(1,5);
      //call necessary functions according to the users choice
      switch( choice ) {
        case 1:  sortStates(states, population); 
                 displayStates(states, population);
                //  menu();
                  break;
        case 2:  sortPopulation(states, population);
                 displayStates(states, population);
                //  menu();
                  break;
        // call for totalSum of population and store int into variable
        case 3:  int sum = totalSum(population); 
        System.out.printf("U.S Population: %,d\n", sum);
                  break;
        case 4:  populationGreater(states, population);
                 displayStates(states, population); 
                  break;
        case 5:  break;
      }


    }while(choice != 5);


  }
  /**
  In both ArrayLists, read the values from the file and add the states to one list and the populations to the other (be sure to keep them in the same order)
  @param states ArrayList of states to read states from StatePops.txt into.
  @param population ArrayList of populations to read populations from StatePops.txt into.
  */
  public static void readFile(ArrayList<String> states, ArrayList<Integer> population){
    // attempts to read in from txt file
    try{
      //create read scanner
      Scanner read = new Scanner(new File("StatePops.txt"));
      // reads until no lines are present
      while(read.hasNext()){
        // stores the buffer into lines
        String line = read.nextLine();
        // splits string by , into array
        String [] fileLine = line.split(",");
        // add 0 index into states
        states.add(fileLine[0]);
        // add 1 index into population
        population.add(Integer.parseInt(fileLine[1]));
        
      }
      // close file after all lines are read
      read.close();
      // throw exception if file is not found
    } catch (FileNotFoundException fnf){
      System.out.println("File was not found.");

    }
    
  }
  /**
  Pass in both ArrayLists, sort the parallel lists alphabetically by state name.
  @param states ArrayList of states to sort alphabetically.
  @param population ArrayList of populations to be sorted according to state sort.
  */
  public static void sortStates(ArrayList<String> states, ArrayList<Integer> population){
    //uses bubble sort to sort the states alphabetically 
    // parallely updates the population arraylist 
    boolean swapped = false;
        do {
          swapped = false;
          for( int i = 0; i < population.size() - 1; i++ ) {
            if( states.get(i).compareTo(states.get(i + 1) ) > 0 ) {
              int swap = population.get( i );
              String swap_1 = states.get( i );

              population.set( i, population.get( i + 1 ) );
              states.set(i, states.get( i + 1));
              population.set( i + 1, swap );
              states.set( i + 1, swap_1 );

              swapped = true;
            }
          }
        } while(swapped);
  }
  /**
  Pass in both ArrayLists, parallel sort the ArrayLists in ascending order by population.
  @param states ArrayList of states to be parallel sorted alongside population.
  @param population ArrayList of populations to be sorted in ascending order (low to high).
  */
  public static void sortPopulation(ArrayList<String> states, ArrayList<Integer> population){
    //sorts the population in ascending order using bubble sort
    //parallelly update the states arraylist
    boolean swapped = false;
    do {
      swapped = false;
      for( int i = 0; i < population.size() - 1; i++ ) {
        if( population.get( i ) > population.get( i + 1 ) ) {
          int swap = population.get( i );
          String swap_1 = states.get( i );

          population.set( i, population.get( i + 1 ) );
          states.set(i, states.get( i + 1));
          population.set( i + 1, swap );
          states.set( i + 1, swap_1 );

          swapped = true;
        }
      }
    } while( swapped );
  }
  /**
  Passes in both ArrayLists, displays each state and its' population. 
  @param states ArrayList to be displayed in conjuction with population.
  @param population ArrayList to be displayed in conjuction with states.
  */
  public static void displayStates (ArrayList<String> states, ArrayList<Integer> population){
    //itterate through size of states and print corresponding population
    for(int i = 0; i < states.size();i++ ){
      System.out.printf(states.get(i) + " ");
      System.out.printf("%,d\n",population.get(i)); 
    }

  }
  /**
  Passes in the populations in the array list, calculate and return the sum.
  @param population ArrayList of all populations.
  @return sum sum of all populations from ArrayList of states. 
  */
  public static int totalSum (ArrayList<Integer> population) {
    //prime accumulator
    int sum = 0;
    for(int i = 0; i < population.size(); i++){
      sum =  sum + population.get(i);
    }
    //return total sum of population
    return sum;
  }

  /**
  Passes in both ArrayLists, prompt the user to enter a population, then display all states and their populations that have a larger population than what the user entered.
  @param states ArrayList passes  
  @param population arraylist 
  */
  public static void populationGreater (ArrayList<String> states, ArrayList<Integer> population) {
    System.out.print("Enter population: ");
    // accept population int from user
    int popCheck = CheckInput.getInt();
    // print all populations and states that are greater than the population entered by user
    for (int i = 0; i < population.size(); i++){
      if (population.get(i) > popCheck)
      {
        System.out.printf(states.get(i)+ " ");
        System.out.printf("%,d\n",population.get(i));
        
      }
    }
  }
  /**
  Displays the menu options.
  */
  public static void menu (){
    System.out.println("State Stats");
    System.out.println("1. Display Sorted States");
    System.out.println("2. Display Sorted Populations");
    System.out.println("3. Display Total US Population");
    System.out.println("4. Display States with Population Greater Than");
    System.out.println("5. Quit");
  }
}
