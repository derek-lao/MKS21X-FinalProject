public class Square{
  private int xcor, ycor;
  private boolean colorRed, occupied;
  private Square square1,square2,square3,square4;
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

  public String toString(){
    String answer="["+ xcor + "," + ycor + "";
    return answer;
  }

  public void setSquare1(Square one){
    square1=one;
  }
  public void setSquare2(Square two){
    square2=two;
  }
  public void setSquare3(Square three){
    square3=three;
  }
  public void setSquare4(Square four){
    square4=four;
  }
}
