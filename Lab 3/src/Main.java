/*
Name: Krystal Macias, Diego Garcia
Date: 9/9/2021
Description: Minesweeper Board Creator
*/

class Main {
  public static void main(String[] args) 
  {

    //accept user row input 5-10 inclusive
    System.out.print("Enter number of Rows (5-10): ");
    int rows = CheckInput.getIntRange(5,10);

    //accept user column input 5-10 inclusive
    System.out.print("Enter number of Columns (5-10): ");
    int columns = CheckInput.getIntRange(5,10);

    //accept user mine input 5-10 inclusive
    System.out.print("Enter number of Mines (5-10):");
    int mines = CheckInput.getIntRange(5,10);

    //create empty 2D array with row and columns
    int [][] grid = new int [rows][columns];

    //pass grid address and mines to place mines
    placeMines(grid, mines);

    //fill grid with counters indicating the # of 9's surronding
    fillGrid(grid);
    
    //print grid to reflect changes
    displayGrid(grid);
    
  }
  /**
  Accepts empty 2D array and # of mines to populate the grid with.
  @param grid empty grid which will be populated with mines.
  @param mines int of mines which will populate grid.
  */
  public static void placeMines(int [][] grid, int mines)
  {
    //iterate for loop for number of mines
    for (int i = 0; i < mines; i++)
    {
      //generate random row from 0 - row length
      int randomRow = (int)(Math.random()*grid.length);
      //generate random column from 0 - column length
      int randomColumn = (int)(Math.random()*grid[0].length);
      
      //test for instance where random generation already has a 9
      while (grid[randomRow][randomColumn] == 9)
      {
        randomRow = (int)(Math.random()*grid.length);
        randomColumn = (int)(Math.random()*grid[0].length);
      }
      //place mine in randomly generated grid location
      grid[randomRow][randomColumn] = 9;

    }
      
  }
  /**
  Accepts 2D array with mines already populated to further populate with counters.
  @param grid grid which has been populated with mines.
  */
  public static void fillGrid(int[][] grid)
  {
    //iterate over both rows and columns to check every element
    for (int i = 0; i < grid.length; i++)
    { 
      for (int j = 0; j < grid[0].length; j++)
      {
        //initalize counter for 9's
        int count = 0;
        //create nested loop for rows 
        for (int k = i - 1; k <= i + 1; k++)
        {
          //create nested loop for columns
          for (int l = j - 1; l <= j + 1; l++)
          {
            // test condtions for boundaries
            if (k >= 0 && l >= 0 && k < grid.length && l < grid[0].length)
            {
              //test condition for 9's found
              if (grid [k][l] == 9)
              { 
                //increment counter
                count++;
              }
            }
          }
        }
        //skips grid location if 9 is element
        if (grid[i][j] != 9)
        {
         grid[i][j] = count; 
        }
      }
    }
  }
  
  /*** Prints the grid of mines.
  * @param the grid with mines and filled in with counter digits.
  */

  public static void displayGrid(int[][] grid)
  {
    //iterates over rows and columns and prints each location
    for (int row = 0; row < grid.length; row++)
    { 
      for (int col = 0; col < grid[0].length; col++)
      {
        System.out.print(grid[row][col] + " ");
      }
      System.out.println();
    }
  }
}