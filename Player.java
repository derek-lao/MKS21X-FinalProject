public class Player{
  public Board field;
  public boolean colorRed,myTurn;

  public Player(Board battlefield,boolean red,boolean turn){
    field=battlefield;
    colorRed=red;
    myTurn=turn;
  }

  public boolean move(Piece warrior,Square target){
    // this checks if the piece being moved is valid, and if the target square is valid
    if(!myTurn)
    {
      System.out.println("move: not my turn!");
      return false;
    }
    if(warrior!=null && warrior.colorRed==this.colorRed && !target.isOccupied() && !target.isRed())
    {
      Square now=warrior.getPosition();
      int nowX=now.getX();
      int nowY=now.getY();
      Square square1=field.getSquare(nowX+1,nowY-1);
      Square square2=field.getSquare(nowX-1,nowY-1);
      Square square3=field.getSquare(nowX-1,nowY+1);
      Square square4=field.getSquare(nowX+1,nowY+1);
      // System.out.println(square1);
      // System.out.println(square2);
      // System.out.println(square3);
      // System.out.println(square4);
      // System.out.println();
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
        warrior.motion(target);
        warrior.becomeKing();
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
    if(!myTurn)
    {
      System.out.println("capture: not my turn!");
      return false;
    }
    // this checks if the piece being moved is valid, and if the target square is valid
    // System.out.println(warrior);
    // System.out.println(target);
    // Square now=warrior.getPosition();
    // int nowX=now.getX();
    // int nowY=now.getY();
    // Square square1=field.getSquare(nowX+2,nowY-2);
    // Square square2=field.getSquare(nowX-2,nowY-2);
    // Square square3=field.getSquare(nowX-2,nowY+2);
    // Square square4=field.getSquare(nowX+2,nowY+2);
    // // System.out.println(square1);
    // // System.out.println(square2);
    // // System.out.println(square3);
    // // System.out.println(square4);
    // Square cap1=field.getSquare(nowX+1,nowY-1);
    // Square cap2=field.getSquare(nowX-1,nowY-1);
    // Square cap3=field.getSquare(nowX-1,nowY+1);
    // Square cap4=field.getSquare(nowX+1,nowY+1);
    // // System.out.println(cap1);
    // // System.out.println(cap2);
    // // System.out.println(cap3);
    // // System.out.println(cap4);
    // Piece captive1=cap1.piece;
    // Piece captive2=cap2.piece;
    // Piece captive3=cap3.piece;
    // Piece captive4=cap4.piece;
    // // System.out.println(captive1);
    // // System.out.println(captive2);
    // // System.out.println(captive3);
    // // System.out.println(captive4);
    // // System.out.println();
    //
    // if(
    // (warrior.king&&(
    // target==square1||
    // target==square2||
    // target==square3||
    // target==square4))     ||
    // (!warrior.king&&warrior.colorRed&&(
    // target==square1||
    // target==square2))     ||
    // (!warrior.king&&!warrior.colorRed&&(
    // target==square3||
    // target==square4))
    // )
    if(canCapture(warrior))
    {
      Square now=warrior.getPosition();
      int nowX=now.getX();
      int nowY=now.getY();
      Square square1=field.getSquare(nowX+2,nowY-2);
      Square square2=field.getSquare(nowX-2,nowY-2);
      Square square3=field.getSquare(nowX-2,nowY+2);
      Square square4=field.getSquare(nowX+2,nowY+2);
      // System.out.println(square1);
      // System.out.println(square2);
      // System.out.println(square3);
      // System.out.println(square4);
      Square cap1=field.getSquare(nowX+1,nowY-1);
      Square cap2=field.getSquare(nowX-1,nowY-1);
      Square cap3=field.getSquare(nowX-1,nowY+1);
      Square cap4=field.getSquare(nowX+1,nowY+1);
      // System.out.println(cap1);
      // System.out.println(cap2);
      // System.out.println(cap3);
      // System.out.println(cap4);
      Piece captive1=cap1.piece;
      Piece captive2=cap2.piece;
      Piece captive3=cap3.piece;
      Piece captive4=cap4.piece;
      // System.out.println(captive1);
      // System.out.println(captive2);
      // System.out.println(captive3);
      // System.out.println(captive4);
      // System.out.println();

      {
        // this checks if the piece being captured is valid
        if(target==square1) //captive1!=null&&captive1.colorRed!=warrior.colorRed
        {
          warrior.motion(target);
          warrior.kill(captive1);
          warrior.becomeKing();
          return true;
        }
        if(target==square2) //captive2!=null&&captive2.colorRed!=warrior.colorRed
        {
          // System.out.println(cap2);
          // System.out.println(captive2);
          warrior.motion(target);
          warrior.kill(captive2);
          warrior.becomeKing();
          return true;
        }
        if(target==square3) //captive3!=null&&captive3.colorRed!=warrior.colorRed
        {
          warrior.motion(target);
          warrior.kill(captive3);
          warrior.becomeKing();
          return true;
        }
        if(target==square4) //captive4!=null&&captive4.colorRed!=warrior.colorRed
        {
          warrior.motion(target);
          warrior.kill(captive4);
          warrior.becomeKing();
          return true;
        }
        else
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
  public boolean canCapture(Piece warrior){
    if(warrior!=null && warrior.colorRed==this.colorRed)
    {
      Square now=warrior.getPosition();
      int nowX=now.getX();
      int nowY=now.getY();
      Square square1=field.getSquare(nowX+2,nowY-2);
      Square square2=field.getSquare(nowX-2,nowY-2);
      Square square3=field.getSquare(nowX-2,nowY+2);
      Square square4=field.getSquare(nowX+2,nowY+2);
      // System.out.println(square1);
      // System.out.println(square2);
      // System.out.println(square3);
      // System.out.println(square4);
      Square cap1=field.getSquare(nowX+1,nowY-1);
      Square cap2=field.getSquare(nowX-1,nowY-1);
      Square cap3=field.getSquare(nowX-1,nowY+1);
      Square cap4=field.getSquare(nowX+1,nowY+1);
      // System.out.println(cap1);
      // System.out.println(cap2);
      // System.out.println(cap3);
      // System.out.println(cap4);
      Piece captive1=cap1.piece;
      Piece captive2=cap2.piece;
      Piece captive3=cap3.piece;
      Piece captive4=cap4.piece;
      // System.out.println(captive1);
      // System.out.println(captive2);
      // System.out.println(captive3);
      // System.out.println(captive4);
      // System.out.println();
      // this checks if the piece movement adheres to its king or not-king restrictions
      boolean frontalMovementValidation=
      (square1!=null&&!square1.isOccupied()&&captive1!=null&&captive1.colorRed!=warrior.colorRed)||
      (square2!=null&&!square1.isOccupied()&&captive2!=null&&captive2.colorRed!=warrior.colorRed);
      boolean backwardMovementValidation=
      (square3!=null&&!square3.isOccupied()&&captive3!=null&&captive3.colorRed!=warrior.colorRed)||
      (square4!=null&&!square4.isOccupied()&&captive4!=null&&captive4.colorRed!=warrior.colorRed);
      if(
      (warrior.king&&(frontalMovementValidation || backwardMovementValidation))     ||
      (!warrior.king&&warrior.colorRed&&(frontalMovementValidation))     ||
      (!warrior.king&&!warrior.colorRed&&(backwardMovementValidation))
      )
      {
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
}
