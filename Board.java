public class Board{
  private Square[][] field;

  public Board(){
    field=new Square[8][8];
  }

  // does the same thing as the constructor...  may be a redundant method.
  // or maybe it is not such a good idea to do this
  public void clear(){
    field=new Square[8][8];
  }
  public void setup(){}

  public static void main(String[] args){
    // // testing to make sure I have 8x8 board
    // Board a=new Board();
    // a.field=new Square[8][8];
    // System.out.println(a.field.length);//8
    // System.out.println(a.field[0].length);//8
  }
}
