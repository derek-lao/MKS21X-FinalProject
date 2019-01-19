import com.googlecode.lanterna.terminal.Terminal.SGR;
import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.Key.Kind;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.Terminal.Color;
import com.googlecode.lanterna.terminal.TerminalSize;
import com.googlecode.lanterna.LanternaException;
import com.googlecode.lanterna.input.CharacterPattern;
import com.googlecode.lanterna.input.InputDecoder;
import com.googlecode.lanterna.input.InputProvider;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.input.KeyMappingProfile;


public class Checkers{
  public Player red,black;
  public Board field;

  public Checkers(){
    red=new Player(field,true,true);
    black=new Player(field,false,false);
    field=new Board();
  }



  public static void putString(int r, int c,Terminal t, String s){
		t.moveCursor(r,c);
		for(int i = 0; i < s.length();i++){
			t.putCharacter(s.charAt(i));
		}
	}
	public static void main(String[] args) {

    Board field=new Board();
    Player red=new Player(field,true,true);
    Player black=new Player(field,false,false);
    Player turner=red;



    // set of moves
    field.setup();
    red.move(field.getSquare(5,6).piece,field.getSquare(6,5));
    red.move(field.getSquare(6,5).piece,field.getSquare(7,4));
    black.capture(field.getSquare(8,3).piece,field.getSquare(6,5));
    red.move(field.getSquare(1,6).piece,field.getSquare(2,5));
    // red.capture(field.getSquare(6,5).piece,field.getSquare(4,3));// the working capture statement thus far
    // black.capture(field.getSquare(3,2).piece,field.getSquare(5,4));
		int x = 4;
		int y = 5;

		Terminal terminal = TerminalFacade.createTextTerminal();
    // Screen screen=new Screen(terminal);
		terminal.enterPrivateMode();

		TerminalSize size = terminal.getTerminalSize();
		terminal.setCursorVisible(false);

		boolean running = true;

		long tStart = System.currentTimeMillis();
		long lastSecond = 0;

		while(running){
      if(!red.myTurn)
      {
        turner=black;
      }
      if(red.myTurn)
      {
        turner=red;
      }
      //code to create board, and set pieces
      for(int r=4;r<12;r++)
      {
        for(int c=5;c<13;c++)
        {
          if(field.getSquare(r-3,c-4).isRed())
          {
            terminal.moveCursor(r,c);
            terminal.applyForegroundColor(Terminal.Color.WHITE);
            terminal.applyBackgroundColor(Terminal.Color.RED);
            terminal.applySGR(Terminal.SGR.ENTER_BOLD);
            terminal.putCharacter(' ');
            // terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
            // terminal.applyForegroundColor(Terminal.Color.DEFAULT);
          }
          if(!field.getSquare(r-3,c-4).isRed())
          {
            terminal.moveCursor(r,c);
            terminal.applyForegroundColor(Terminal.Color.RED);
            terminal.applyBackgroundColor(Terminal.Color.BLACK);
            terminal.applySGR(Terminal.SGR.ENTER_BOLD);
            terminal.putCharacter(' ');
            // terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
            // terminal.applyForegroundColor(Terminal.Color.DEFAULT);
          }
          if(field.getSquare(r-3,c-4).isOccupied()&&field.getSquare(r-3,c-4).piece.colorRed)
          {
            terminal.moveCursor(r,c);
            terminal.applyForegroundColor(Terminal.Color.RED);
            terminal.putCharacter('\u25cf');
          }
          if(field.getSquare(r-3,c-4).isOccupied()&&!field.getSquare(r-3,c-4).piece.colorRed)
          {
            terminal.moveCursor(r,c);
            terminal.applyForegroundColor(Terminal.Color.MAGENTA);
            terminal.putCharacter('\u25cf');
          }
        }
      }
      terminal.moveCursor(x,y);
			terminal.applyBackgroundColor(Terminal.Color.RED);//cursor background color
			terminal.applyForegroundColor(Terminal.Color.GREEN);//cursor foreground color
			//applySGR(a,b) for multiple modifiers (bold,blink) etc.
			terminal.applySGR(Terminal.SGR.ENTER_UNDERLINE);
			terminal.putCharacter('\u00a4');//puts a character in place of the cursor
			//terminal.putCharacter(' ');
			terminal.applyBackgroundColor(Terminal.Color.RED);
			terminal.applyForegroundColor(Terminal.Color.GREEN);
			terminal.applySGR(Terminal.SGR.RESET_ALL);//resets all code since the last Terminal.SGR, I think?

			Key key = terminal.readInput();

      int r=x;
      int c=y;
			if (key != null)
			{

				if (key.getKind() == Key.Kind.Escape) {

					terminal.exitPrivateMode();
					running = false;
				}

        if(x>3 && x<12 && y>4 && y<13)
        {
          Square currentSquare=null;
          Piece currentPiece=null;
          if(key.getKind()==Key.Kind.Enter)
          {
            terminal.moveCursor(x,y);
            currentSquare=field.getSquare(x-3,y-4);
            if(currentSquare.piece!=null)
            {
              currentPiece=currentSquare.piece;
            }
          }
          if(key.getCharacter()=='m')
          {
            terminal.moveCursor(x,y);
            currentSquare=field.getSquare(x-3,y-4);
            if(turner.move(currentPiece,currentSquare))
            {
              turner.move(currentPiece,currentSquare);
              red.myTurn=!red.myTurn;
            }
            else
            {
              putString(1,20,terminal,"Can't do that! Did something wrong with move.");
            }
          }
          if(key.getCharacter()=='c')
          {
            terminal.moveCursor(x,y);
            currentSquare=field.getSquare(x-3,y-4);
            if(turner.capture(currentPiece,currentSquare))
            {
              turner.capture(currentPiece,currentSquare);
              red.myTurn=!red.myTurn;
            }
            else
            {
              putString(1,20,terminal,"Can't do that! Did something wrong with capture.");
            }
          }

        }

				if (key.getKind() == Key.Kind.ArrowLeft) {
					terminal.moveCursor(x,y);
					terminal.putCharacter(' ');
					x--;
				}

				if (key.getKind() == Key.Kind.ArrowRight) {
					terminal.moveCursor(x,y);
					terminal.putCharacter(' ');
					x++;
				}

				if (key.getKind() == Key.Kind.ArrowUp) {
					terminal.moveCursor(x,y);
					terminal.putCharacter(' ');
					y--;
				}

				if (key.getKind() == Key.Kind.ArrowDown) {
					terminal.moveCursor(x,y);
					terminal.putCharacter(' ');
					y++;
				}
				//space moves it diagonally
				if (key.getCharacter() == ' ') {
					terminal.moveCursor(x,y);
					terminal.putCharacter(' ');
					y++;
					x++;
				}
				putString(1,4,terminal,"["+key.getCharacter() +"]");
				putString(1,1,terminal,key+"        ");//to clear leftover letters pad withspaces
			}

			//DO EVEN WHEN NO KEY PRESSED:
			long tEnd = System.currentTimeMillis();
			long millis = tEnd - tStart;
			putString(1,2,terminal,"Milliseconds since start of program: "+millis);
			if(millis/1000 > lastSecond){
				lastSecond = millis / 1000;
				//one second has passed.
				putString(1,3,terminal,"Seconds since start of program: "+lastSecond);

			}


		}
    // screen.refresh();
	}
}
