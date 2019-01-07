public class Board{
  private Square[][] field;

  public Board(){
    field=new Square[8][8];
  }
  public void clear(){}
  public void setup(){}

  public static void main(String[] args){
    // // testing to make sure I have 8x8 board
    // Board a=new Board();
    // a.field=new Square[8][8];
    // System.out.println(a.field.length);//8
    // System.out.println(a.field[0].length);//8
  }
}
