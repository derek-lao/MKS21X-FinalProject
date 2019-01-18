public class Player{
  public Board field;
  public boolean colorRed,myTurn;

  public Player(Board battlefield,boolean red,boolean turn){
    field=battlefield;
    red=colorRed;
    turn=myTurn;
  }

  public boolean move(Piece warrior,Square target){
    if(warrior!=null && !target.isOccupied() && !target.isRed())
    {
      Square now=warrior.getPosition();
      int nowX=now.getX();
      int nowY=now.getY();
      Square square1=field.getSquare(nowX+1,nowY-1);
      Square square2=field.getSquare(nowX-1,nowY-1);
      Square square3=field.getSquare(nowX-1,nowY+1);
      Square square4=field.getSquare(nowX+1,nowY+1);
      if(
      (warrior.king&&(
      target==square1||
      target==square2||
      target==square3||
      target==square4))     ||
      (!warrior.king&&warrior.colorRed&&(
      target==square1||
      target==square2))     ||
      (!warrior.king&&!warrior.colorRed&&(
      target==square3||
      target==square4))
      )
      {
        warrior.motion(target);
        return true;
      }
      else
      {
        return false;
      }
    }
    else
    {
      return false;
    }
  }

  public boolean capture(Piece warrior,Square target){
    // this checks if the piece being moved is valid, and if the target square is valid
    // System.out.println(warrior);
    // System.out.println(target);
    if(warrior!=null && warrior.colorRed==this.colorRed && !target.isOccupied() && !target.isRed())
    {
      Square now=warrior.getPosition();
      int nowX=now.getX();
      int nowY=now.getY();
      Square cap1=field.getSquare(nowX+1,nowY-1);
      Square cap2=field.getSquare(nowX-1,nowY-1);
      Square cap3=field.getSquare(nowX-1,nowY+1);
      Square cap4=field.getSquare(nowX+1,nowY+1);
      Piece captive1=cap1.piece;
      Piece captive2=cap2.piece;
      Piece captive3=cap3.piece;
      Piece captive4=cap4.piece;
      Square square1=field.getSquare(nowX+2,nowY-2);
      Square square2=field.getSquare(nowX-2,nowY-2);
      Square square3=field.getSquare(nowX-2,nowY+2);
      Square square4=field.getSquare(nowX+2,nowY+2);
      // this checks if the piece movement adheres to its king or not-king restrictions
      if(
      (warrior.king&&(
      target==square1||
      target==square2||
      target==square3||
      target==square4))     ||
      (!warrior.king&&warrior.colorRed&&(
      target==square1||
      target==square2))     ||
      (!warrior.king&&!warrior.colorRed&&(
      target==square3||
      target==square4))
      )
      {
        // this checks if the piece being captured is valid
        if(target==square1 && captive1!=null && captive1.colorRed!=warrior.colorRed)
        {
          warrior.motion(target);
          warrior.kill(captive1);
          return true;
        }
        if(target==square2 && captive2!=null && captive2.colorRed!=warrior.colorRed)
        {
          System.out.println(cap2);
          // System.out.println(captive2);
          warrior.motion(target);
          warrior.kill(captive2);
          return true;
        }
        if(target==square3 && captive3!=null && captive3.colorRed!=warrior.colorRed)
        {
          warrior.motion(target);
          warrior.kill(captive3);
          return true;
        }
        if(target==square4 && captive4!=null && captive4.colorRed!=warrior.colorRed)
        {
          warrior.motion(target);
          warrior.kill(captive4);
          return true;
        }
        else
        {
          return false;
        }
      }
      else
      {
        return false;
      }
    }
    else
    {
      return false;
    }
  }
  // public boolean move(Piece soldier, Square target){
  //   if(myTurn&&soldier.colorRed==this.colorRed&&soldier.move(target))
  //   {
  //     return soldier.move(target);
  //   }
  //   else
  //   {
  //     return false;
  //   }
  // }
  //
  // public boolean capture(Piece soldier, Piece captive){
  //   if(myTurn&&soldier.colorRed==this.colorRed&&soldier.capture(captive))
  //   {
  //     return soldier.capture(captive);
  //   }
  //   else
  //   {
  //     return false;
  //   }
  // }
}
