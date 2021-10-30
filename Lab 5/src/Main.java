/*
  Lab 5
  Krystal Macias and Diego Garcia
*/

import java.util.Scanner;

class Main 
{
  public static void main(String[] args) 
  {
    //initalize grid
    char [][] grid = new char [20][20];
    // initalize width and height of rectangle
    System.out.print("Enter rectangle width (1-5): ");
    int w = CheckInput.getIntRange(1,5);
    System.out.print("Please enter the height (1-5): ");
    int h = CheckInput.getIntRange(1,5);
    //create instance of rectangle class
    Rectangle r1 = new Rectangle(w, h);
    // initalize x and y for use within main
    int x = r1.getX();
    int y = r1.getY();
    // create base grid and rectangle
    placeRect(grid, r1);
    displayGrid(grid);
    resetGrid(grid);
    // initilize choice
    int choice;
    // main logic to display grid and changes.
    do
    {
      choice = menu();

      switch(choice)
      {
        case 1: r1.translate(x, y-1);
                if (r1.getY() < 0)
                {
                  System.out.println("You cannot go that way.");
                  r1.translate(x, y+1);
                  break;
                }
                  placeRect(grid, r1);
                  displayGrid(grid);
                  resetGrid(grid);
                  break;
      
        case 2: r1.translate(x, y+1);
                if ((r1.getY() + h) > 20)
                {
                  System.out.println("You cannot go that way.");
                  r1.translate(x, y-1);
                  break;
                }
                placeRect(grid, r1);
                displayGrid(grid);
                resetGrid(grid);
                break;
        case 3: r1.translate(x-1, y);
                if (r1.getX() < 0)
                {
                  System.out.println("You cannot go that way.");
                  r1.translate(x+1, y);
                  break;
                }
                placeRect(grid, r1);
                displayGrid(grid);
                resetGrid(grid);
                break;
        case 4: r1.translate(x+1, y);
                if ((r1.getX() + w) > 20)
                {
                  System.out.println("You cannot go that way.");
                  r1.translate(x-1, y);
                  break;
                }
                placeRect(grid, r1);
                displayGrid(grid);
                resetGrid(grid);
                break;      
      
        case 5: break;
      }
  
    } while(choice !=5);


  }
  /*
  Accepts grid then displays content of grid.
  @param grid accepts grid to be displayes.
  */

  public static void displayGrid(char[][]grid)
  {
    for (int row = 0; row < grid.length; row++)
    {
      for (int col = 0; col < grid[0].length; col++)
      {
        System.out.print(grid[row][col] + " "); 
      }
      System.out.println();
    }
  }
  
  /*
  Go to the location in the grid at the rectangle’s x and y location, then, using ‘*’s, fill in the grid using the rectangle’s width and height to draw the rectangle on the grid.
  @param grid double array which encompasses all characters that make up map.
  @param r1 passes in the rectangle class.
  */
  public static void placeRect(char [][] grid, Rectangle r1)
  {
    // initalize values of x,y,w,h with respect to rectangle class
    int x = r1.getX();
    int y = r1.getY();
    int w = r1.getWidth();
    int h = r1.getHeight();
    // iterates through rows and columns 
    for (int row = 0; row < grid.length; row++)
    {
      for (int col = 0; col < grid[0].length; col++)
      {
        //logic to decide if it's a '*' or '.'
        if (row >= y && row < (y + h) && col >= x && col < (x + w))
        {
          grid[row][col] = '*';
        }
        else
        {
          grid[row][col] = '.';
        }
      }
    }
    
  }
  /*
    Pass in the grid and resets the grid by placing periods over everything including the astericks.
    @param grid grid resets
  */
  public static void resetGrid(char [][] grid)
  {
    //sets grid to all '.'
    for (int row = 0; row < grid.length; row++)
    {
      for (int col = 0; col < grid.length; col++)
      {
        grid[row][col] = '.';
      }
    }

  }

  /*
    Displays the menu options for the game.
    @return choice returns choice int.
  */
  public static int menu()
  {
  
    System.out.println("Enter Direction: ");
    System.out.println("1. Up");
    System.out.println("2. Down");
    System.out.println("3. Left");
    System.out.println("4. Right");
    System.out.println("5. Quit");
    int choice = CheckInput.getIntRange(1,5);
      
    return choice;
  }
  
}