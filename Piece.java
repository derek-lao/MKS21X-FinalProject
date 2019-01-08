public class Piece{
  public boolean colorRed,isKing;
  private Square position;
  public Piece(boolean red, boolean king, Square place){
    colorRed=red;
    isKing=king;
    position=place;
  }
}
