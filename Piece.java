public class Piece{
  public boolean colorRed,king;
  private Square position;


  /**
  * @param red is the colorRed boolean of the Piece. True if it is red, false if it is black.
  * @param king is the isKing boolean of the Piece. True if the piece is king, false if it is not.
  * @param place is the position of the Piece, defined by a Square.
  */
  public Piece(boolean red, boolean isKing, Square place){
    colorRed=red;
    king=isKing;
    position=place;
  }

  public Square getPosition(){
    return position;
  }
  public void setPosition(Square target){
    position=target;
  }

  private void motion(Square target){
    
  }
  public boolean move(Square target){
    Square move1=position.getSquare1();
    Square move2=position.getSquare2();
    Square move3=position.getSquare3();
    Square move4=position.getSquare4();
    if(target!=null&&(target==move1||target==move2||
    target==move3||target==move4)&&target.isOccupied()==false)
    {
      if(this.king)
      {
        target.setPiece(this);
        this.position.setPiece(null);
        this.setPosition(target);
        return true;
      }
      else
      {
        if(target==move1||target==move2)
        {
          target.setPiece(this);
          this.position.setPiece(null);
          this.setPosition(target);
          return true;
        }
        if(target==move3||target==move4)
        {
          return false;
        }
      }
    }
    else
    {
      return false;
    }
  }
  public boolean capture(Piece captive){
    Piece cap1=position.getSquare1().piece;
    Piece cap2=position.getSquare2().piece;
    Piece cap3=position.getSquare3().piece;
    Piece cap4=position.getSquare4().piece;
    Square capture1=position.getSquare1();
    Square capture2=position.getSquare2();
    Square capture3=position.getSquare3();
    Square capture4=position.getSquare4();
    boolean status1=!capture1.isOccupied();
    boolean status2=!capture2.isOccupied();
    boolean status3=!capture3.isOccupied();
    boolean status4=!capture4.isOccupied();
    if(captive!=null&&captive.colorRed!=this.colorRed&&
    (captive==cap1||captive==cap2||captive==cap3||captive==cap4)&&
    (capture1!=null||capture2!=null||capture3!=null||capture4!=null)&&
    (status1||status2||status3||status4))
    {

    }

  }

}
