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
  public boolean move(Square target){
    if(target==position.square1||target==position.square2||
    target==position.square3||target==position.square4)
    {
      if(target.isOccupied()==false)
      {
        
      }
    }
  }
}
