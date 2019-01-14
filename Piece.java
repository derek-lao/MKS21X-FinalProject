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
  public boolean move(Square target){
    if(target!=null&&(target==position.getSquare1()||target==position.getSquare2()||
    target==position.getSquare3()||target==position.getSquare4())&&
    target.isOccupied()==false)
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
        if(target==position.getSquare1()||target==position.getSquare2())
        {
          target.setPiece(this);
          this.position.setPiece(null);
          this.setPosition(target);
          return true;
        }
        if(target==position.getSquare3()||target==position.getSquare4())
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

}
