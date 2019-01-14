public class Player{
  public Board field;
  public boolean colorRed,myTurn;

  public Player(Board battlefield,boolean red,boolean turn){
    field=battlefield;
    red=colorRed;
    turn=myTurn;
  }

  public boolean move(Piece soldier, Square target){
    if(myTurn&&soldier.colorRed==this.colorRed&&soldier.move(target))
    {
      return soldier.move(target);
    }
    else
    {
      return false;
    }
  }

  public boolean capture(Piece soldier, Piece captive){
    if(myTurn&&soldier.colorRed==this.colorRed&&soldier.capture(captive))
    {
      return soldier.capture(captive);
    }
    else
    {
      return false;
    }
  }
}
