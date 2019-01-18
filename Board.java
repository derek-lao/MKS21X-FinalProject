public class Board{
  private Square[][] field;

  public Board(){
    field=new Square[8][8];
    this.clear();
  }

  // does the same thing as the constructor...  may be a redundant method.
  // or maybe it is not such a good idea to do this
  /**
  * clears the board by creating a new checkered board
  */
  public void clear(){
    field=new Square[8][8];
    for(int y=0;y<8;y+=2)
    {
      for(int x=0;x<8;x+=2)
      {
        field[y][x]=new Square(x,y,true,null);
      }
      for(int x=1;x<8;x+=2)
      {
        field[y][x]=new Square(x,y,false,null);
      }
    }
    for(int y=1;y<8;y+=2)
    {
      for(int x=0;x<8;x+=2)
      {
        field[y][x]=new Square(x,y,false,null);
      }
      for(int x=1;x<8;x+=2)
      {
        field[y][x]=new Square(x,y,true,null);
      }
    }
  }

  /**
  * clears board, and puts pieces in board.
  */
  public void setup(){
    clear(); // this prevents weird things from happening. It ensures all squares are correct
    for(int y=0;y<3;y++)
    {
      for(int x=0;x<8;x++)
      {
        if(!field[y][x].isRed())
        {
          field[y][x].piece=new Piece(false,false,field[y][x]);
        }
      }
    }
    for(int y=5;y<8;y++)
    {
      for(int x=0;x<8;x++)
      {
        if(!field[y][x].isRed())
        {
          field[y][x].piece=new Piece(true,false,field[y][x]);
        }
      }
    }
  }

  public Square getSquare(int x,int y){
    return field[y][x];
  }
  public static void main(String[] args){
    // // testing to make sure I have 8x8 board
    // Board a=new Board();
    // a.field=new Square[8][8];
    // System.out.println(a.field.length);//8
    // System.out.println(a.field[0].length);//8
  }
}
