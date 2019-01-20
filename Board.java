public class Board{
  private Square[][] field;

  public Board(){
    field=new Square[12][12];
    this.clear();
  }

  Piece dummy=new Piece(null);
  // does the same thing as the constructor...  may be a redundant method.
  // or maybe it is not such a good idea to do this
  /**
  * clears the board by creating a new checkered board
  */
  public void clear(){
    field=new Square[12][12];
    for(int y=1;y<11;y+=99)
    {
      for(int x=1;x<11;x++)
      {
        field[y][x]=new Square(dummy);
      }
    }
    for(int y=1;y<11;y++)
    {
      for(int x=1;x<11;x+=9)
      {
        field[y][x]=new Square(dummy);
      }
    }
    for(int y=2;y<10;y+=2)
    {
      for(int x=2;x<10;x+=2)
      {
        field[y][x]=new Square(x-1,y-1,true,null);
      }
      for(int x=3;x<10;x+=2)
      {
        field[y][x]=new Square(x-1,y-1,false,null);
      }
    }
    for(int y=3;y<10;y+=2)
    {
      for(int x=2;x<10;x+=2)
      {
        field[y][x]=new Square(x-1,y-1,false,null);
      }
      for(int x=3;x<10;x+=2)
      {
        field[y][x]=new Square(x-1,y-1,true,null);
      }
    }
  }

  /**
  * clears board, and puts pieces in board.
  */
  public void setup(){
    clear(); // this prevents weird things from happening. It ensures all squares are correct
    for(int y=2;y<5;y++)
    {
      for(int x=2;x<10;x++)
      {
        if(!field[y][x].isRed())
        {
          field[y][x].piece=new Piece(false,false,field[y][x]);
        }
      }
    }
    for(int y=7;y<10;y++)
    {
      for(int x=2;x<10;x++)
      {
        if(!field[y][x].isRed())
        {
          field[y][x].piece=new Piece(true,false,field[y][x]);
        }
      }
    }
  }

  public Square getSquare(int x,int y){
    return field[y+1][x+1];
  }
  public static void main(String[] args){
    // // testing to make sure I have 8x8 board
    // Board a=new Board();
    // a.field=new Square[8][8];
    // System.out.println(a.field.length);//8
    // System.out.println(a.field[0].length);//8
  }
}
