public class Square{
  private int xcor, ycor;
  private boolean colorRed;
  public Piece piece;

  //constructor
  /**
  * @param x set x coordinate
  * @param y set y coordinate
  * @param red set color. If true, the color is red. If false, then the color is black.
  * @param full set occupied status. If true, then the square is occupied. If false, then the square is empty.
  */
  public Square(int x,int y,boolean red, Piece soldier){
    xcor=x;
    ycor=y;
    colorRed=red;
    piece=soldier;
  }
  public Square(Piece soldier){
    piece=soldier;
  }

  public int getX(){
    return xcor;
  }

  public int getY(){
    return ycor;
  }

  public boolean isOccupied(){
    return piece!=null;
  }

  public boolean isRed(){
    return colorRed;
  }

  public void setPiece(Piece warrior){
    piece=warrior;
  }

}
