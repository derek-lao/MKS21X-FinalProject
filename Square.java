public class Square{
  private int xcor, ycor;
  private boolean colorRed, occupied;

  //constructor
  /**
  * @param x set x coordinate
  * @param y set y coordinate
  * @param red set color. If true, the color is red. If false, then the color is black.
  * @param full set occupied status. If true, then the square is occupied. If false, then the square is empty.
  */
  public Square(int x,int y,boolean red,boolean full){
    xcor=x;
    ycor=y;
    colorRed=red;
    occupied=full;
  }

  public boolean isOccupied(){
    return occupied==true;
  }
}
