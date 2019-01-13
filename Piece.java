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
  public boolean move(int directon){
    if(position)
  }
}
