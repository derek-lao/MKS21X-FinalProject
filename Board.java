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
      for(int x=1;x<field[1].length;x+=2)
      {
        field[y][x]=new Square(x,y,true,null);
      }
    }
    // below this is when I set the reference squares of each square.
    // we start by setting all the corner squares
    field[7][0].setSquare1(field[6][1]);//set bottom left corner's references
    field[0][7].setSquare3(field[1][6]);//set top right corner's references
    // then set all the side squares excluding corner squares
    for(int y=0;y<7;y++)
    {
      if(field[y][0].isRed()==false)
      {
        field[y][0].setSquare1(field[y-1][1]);
        field[y][0].setSquare4(field[y+1][1]);
      }
    }
    for(int y=1;y<8;y++)
    {
      if(field[y][7].isRed()==false)
      {
        field[y][7].setSquare2(field[y-1][6]);
        field[y][7].setSquare3(field[y+1][6]);
      }
    }
    for(int x=0;x<7;x++)
    {
      if(field[0][x].isRed()==false)
      {
        field[0][x].setSquare3(field[1][x-1]);
        field[0][x].setSquare4(field[1][x+1]);
      }
    }
    for(int x=1;x<8;x++)
    {
      if(field[7][x].isRed()==false)
      {
        field[7][x].setSquare1(field[6][x+1]);
        field[7][x].setSquare2(field[6][x-1]);
      }
    }
    //then set all the middle squares
    for(int y=1;y<7;y++)
    {
      for(int x=1;x<7;x++)
      {
        if(field[y][x].isRed()==false)
        {
          field[y][x].setSquare1(field[y-1][x+1]);
          field[y][x].setSquare2(field[y-1][x-1]);
          field[y][x].setSquare3(field[y+1][x-1]);
          field[y][x].setSquare4(field[y+1][x+1]);
        }
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
