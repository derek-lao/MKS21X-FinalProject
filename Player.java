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
      if(warrior.king)
      {
        
      }
    }
  }
  public boolean capture(Piece captive){
    Piece cap1=position.getSquare1().piece;
    Piece cap2=position.getSquare2().piece;
    Piece cap3=position.getSquare3().piece;
    Piece cap4=position.getSquare4().piece;
    System.out.println(position);
    System.out.println(position.getSquare1());
    System.out.println(position.getSquare1().getSquare1());
    Square capture1=position.getSquare1().getSquare1();
    Square capture2=position.getSquare2().getSquare2();
    Square capture3=position.getSquare3().getSquare3();
    Square capture4=position.getSquare4().getSquare4();
    boolean status1= !capture1.isOccupied();
    boolean status2= !capture2.isOccupied();
    boolean status3= !capture3.isOccupied();
    boolean status4= !capture4.isOccupied();
    if(captive!=null&&captive.colorRed!=this.colorRed&&
    (captive==cap1||captive==cap2||captive==cap3||captive==cap4)&&
    (capture1!=null||capture2!=null||capture3!=null||capture4!=null)&&
    (status1||status2||status3||status4))
    {
      if(this.king)
      {
        if(captive==cap1) this.motion(capture1);
        if(captive==cap2) this.motion(capture2);
        if(captive==cap3) this.motion(capture3);
        if(captive==cap4) this.motion(capture4);
        captive.getPosition().piece=null;
        captive.setPosition(null);
        return true;
      }
      else
      {
        if(colorRed&&(captive==cap1||captive==cap2))
        {
          if(captive==cap1) this.motion(capture1);
          if(captive==cap2) this.motion(capture2);
          captive.getPosition().piece=null;
          captive.setPosition(null);
          return true;
        }
        if(!colorRed&&(captive==cap3||captive==cap4))
        {
          if(captive==cap3) this.motion(capture3);
          if(captive==cap4) this.motion(capture4);
          captive.getPosition().piece=null;
          captive.setPosition(null);
          return true;
        }
        else
        {
          return false;
        }
      }
    }
    return false;
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
