public class Rectangle
{
  //instance variables that set the attributes of the rectangle
  private int x;
  private int y;
  private int width;
  private int height;

  /*
  Constructor method that sets initial values of the instance variables using width and height parameters.
  @param w width of the rectangle.
  @param h height of the rectangle.
  */
  public Rectangle(int w, int h)
  {
    //initalize positions of (x,y)
    x = 0;
    y = 0;
    // initalize width and height
    width = w;
    height = h;
  }


  /*
  Returns current x value.
  @return x returns current x position/value.
  */
  public int getX()
  {
    return x;
  }

  /*
  Returns current y value.
  @return y returns current y position/value.
  */
  public int getY()
  {
    return y;
  }
  /*
  Returns the width respectively.
  @return width returns the width of rectangle. 
  */

  public int getWidth()
  {
    return width;
  }

  /*
  Returns the height...respectively.
  @return height returns the height of the rectangle.
  */
  int getHeight()
  {
    return height;
  }

  /*
  Accepts parameters that changes value of x and y.
  @param dx passes translation with respect to x.
  @param dy passes translation with respect to y.
  */
  void translate(int dx, int dy)
  {
    x = x + dx;
    y = y + dy;
  }
}


