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
import com.googlecode.lanterna.screen.*;


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
    Square currentSquare=null;
    Piece currentPiece=null;
    boolean hasCaptured=false;
    boolean menuMode=true;
    int redPiecesLeft=12;
    int blackPiecesLeft=12;

    // set of moves for early testing
    field.setup();
    red.move(field.getSquare(5,6).piece,field.getSquare(6,5));
    red.move(field.getSquare(6,5).piece,field.getSquare(7,4));
    red.move(field.getSquare(4,7).piece,field.getSquare(5,6));
    red.myTurn=!red.myTurn;
    black.myTurn=!black.myTurn;
    black.move(field.getSquare(2,3).piece,field.getSquare(1,4));
    black.capture(field.getSquare(8,3).piece,field.getSquare(6,5));
    black.capture(field.getSquare(6,5).piece,field.getSquare(4,7));
    red.myTurn=!red.myTurn;
    black.myTurn=!black.myTurn;
    red.move(field.getSquare(6,7).piece,field.getSquare(5,6));
    red.move(field.getSquare(5,8).piece,field.getSquare(6,7));
    red.move(field.getSquare(7,6).piece,field.getSquare(8,5));
    red.myTurn=!red.myTurn;
    black.myTurn=!black.myTurn;
    black.move(field.getSquare(4,7).piece,field.getSquare(5,8));
    redPiecesLeft=1;
    blackPiecesLeft=12;
    // black.capture(field.getSquare(5,8).piece,field.getSquare(7,6));


		int x = 4;
		int y = 5;

		Terminal terminal = TerminalFacade.createTextTerminal();
    Screen screen=new Screen(terminal);
		screen.startScreen();
		terminal.enterPrivateMode();

		TerminalSize size = terminal.getTerminalSize();
		terminal.setCursorVisible(false);

		boolean running = true;

		long tStart = System.currentTimeMillis();
		long lastSecond = 0;



		while(running){

      //code for cursor at any moment
      terminal.moveCursor(x,y);
			terminal.applyBackgroundColor(Terminal.Color.GREEN);//cursor background color
			terminal.applyForegroundColor(Terminal.Color.BLACK);//cursor foreground color
			//applySGR(a,b) for multiple modifiers (bold,blink) etc.
			terminal.applySGR(Terminal.SGR.ENTER_UNDERLINE);
			terminal.putCharacter('\u00a4');//puts a character in place of the cursor
			//terminal.putCharacter(' ');
			terminal.applySGR(Terminal.SGR.RESET_ALL);//resets all code since the last Terminal.SGR, I think?


      putString(1,23,terminal,"Press escape to close and quit the game.");
      if(menuMode)//permanent visual features specific to while in menu
      {
        terminal.applyForegroundColor(Terminal.Color.WHITE);
        terminal.applyBackgroundColor(Terminal.Color.BLACK);
        long tEnd = System.currentTimeMillis();
  			long millis = tEnd - tStart;
  			putString(1,2,terminal,"Milliseconds since start of program: "+millis+"     ");
  			if(millis/1000 > lastSecond){
  				lastSecond = millis / 1000;
  				//one second has passed.
  				putString(1,3,terminal,"Seconds since start of program: "+lastSecond+"    ");
        }

        terminal.applyForegroundColor(Terminal.Color.YELLOW);
        terminal.applyBackgroundColor(Terminal.Color.BLACK);
        for(int i=4;i<16;i++)
        {
          putString(1,i,terminal,"                                                                                 ");
        }
        putString(1,16,terminal,"Welcome to the Checkers game created by Derek Lao!                                ");
        putString(1,17,terminal,"This is a variant of checkers where capturing is not obligatory                   ");
        putString(1,18,terminal,"Choose one of the options below                                                   ");
        putString(1,20,terminal,"Press the key that corresponds with the option to activate                        ");
        putString(1,21,terminal,"Start new game (Press p)                                                          ");
        putString(1,22,terminal,"Continue game  (Press g)                                                          ");
        putString(1,13,terminal,"                                                                                  ");
        putString(1,14,terminal,"                                                                                  ");
      }

      if(!menuMode)//permanent visual features specific to while not in menu
      {
        terminal.applyForegroundColor(Terminal.Color.WHITE);
        terminal.applyBackgroundColor(Terminal.Color.BLACK);
        long tEnd = System.currentTimeMillis();
  			long millis = tEnd - tStart;
  			putString(1,2,terminal,"Milliseconds since start of program: "+millis);
  			if(millis/1000 > lastSecond){
  				lastSecond = millis / 1000;
  				//one second has passed.
  				putString(1,3,terminal,"Seconds since start of program: "+lastSecond);
        }


        if(blackPiecesLeft==0)
        {
          putString(1,5,terminal,"Red won! Press spacebar to return to menu and start a new game.     ");
          putString(1,6,terminal,"                                                                    ");
          for(int i=7;i<23;i++)
          {
            putString(1,i,terminal,"                                                                        ");
          }
        }
        if(redPiecesLeft==0)
        {
          putString(1,5,terminal,"Black won! Press spacebar to return to menu and start a new game.   ");
          putString(1,6,terminal,"                                                                    ");
          for(int i=7;i<23;i++)
          {
            putString(1,i,terminal,"                                                                        ");
          }
        }
        if(redPiecesLeft>0 && blackPiecesLeft>0)
        {
          putString(1,13,terminal,"Press spacebar to see menu.                                                      ");
          putString(1,14,terminal,"You will not lose your current game unless you select \"Start new game\"         ");
          putString(14,5,terminal,"Red pieces remaining: "+redPiecesLeft);
          putString(14,6,terminal,"White pieces remaining: "+blackPiecesLeft);


          if(!red.myTurn)
          {
            turner=black;
            putString(1,15,terminal,"White to move                             ");
          }
          if(red.myTurn)
          {
            turner=red;
            putString(1,15,terminal,"Red to move                               ");
          }

          //code to put down coordinates on board
          putString(4,4,terminal,"12345678");
          for(int i=5;i<13;i++)
          {
            putString(3,i,terminal,""+(i-4));
          }
          //code to create board, and set pieces, and continue to update board
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
              }
              if(!field.getSquare(r-3,c-4).isRed())
              {
                terminal.moveCursor(r,c);
                terminal.applyForegroundColor(Terminal.Color.RED);
                terminal.applyBackgroundColor(Terminal.Color.BLACK);
                terminal.applySGR(Terminal.SGR.ENTER_BOLD);
                terminal.putCharacter(' ');
              }
              if(field.getSquare(r-3,c-4).isOccupied())
              {
                Piece pieceNow=field.getSquare(r-3,c-4).piece;
                if(pieceNow.colorRed&&!pieceNow.king)
                {
                  terminal.moveCursor(r,c);
                  terminal.applyForegroundColor(Terminal.Color.RED);
                  terminal.putCharacter('\u25CF');
                }
                if(!pieceNow.colorRed&&!pieceNow.king)
                {
                  terminal.moveCursor(r,c);
                  terminal.applyForegroundColor(Terminal.Color.WHITE);
                  terminal.putCharacter('\u25CF');
                }
                if(pieceNow.colorRed&&pieceNow.king)
                {
                  terminal.moveCursor(r,c);
                  terminal.applyForegroundColor(Terminal.Color.RED);
                  terminal.putCharacter('\u25CB');
                }
                if(!pieceNow.colorRed&&pieceNow.king)
                {
                  terminal.moveCursor(r,c);
                  terminal.applyForegroundColor(Terminal.Color.WHITE);
                  terminal.putCharacter('\u25CB');
                }
              }
            }
          }
        }


      }


      Key key = terminal.readInput();
      // Key key = screen.readInput();

			if (key != null)
			{
        //keys to press specific to while in menu
        if(menuMode)
        {
          if(key.getCharacter()=='p')
          {
            field.setup();
            redPiecesLeft=12;
            blackPiecesLeft=12;
            terminal.applyForegroundColor(Terminal.Color.WHITE);
            terminal.applyBackgroundColor(Terminal.Color.BLACK);
            for(int i=16;i<23;i++)
            {
              putString(1,i,terminal,"                                                                                  ");
            }
            menuMode=!menuMode;
          }
          if(key.getCharacter()=='g')
          {
            terminal.applyForegroundColor(Terminal.Color.WHITE);
            terminal.applyBackgroundColor(Terminal.Color.BLACK);
            for(int i=16;i<23;i++)
            {
              putString(1,i,terminal,"                                                                                  ");
            }
            if(hasCaptured && turner.canCapture(currentPiece))
            {
              putString(1,20,terminal,"You can still capture!                                                           ");
              putString(1,21,terminal,"Use arrow keys to select new capture destination, then press c to capture        ");
              putString(1,22,terminal,"Press e to end turn.                                                             ");
            }
            menuMode=!menuMode;
          }
        }

        //keys to press specific to when in game, not in menu
				if(!menuMode)
        {
          terminal.applyForegroundColor(Terminal.Color.WHITE);
          terminal.applyBackgroundColor(Terminal.Color.BLACK);
          if(key.getCharacter()==' ')
          {
            menuMode=!menuMode;
          }

          if(blackPiecesLeft>0 && redPiecesLeft>0)
          {
            if(x>3 && x<12 && y>4 && y<13)
            {
              if(key.getKind()==Key.Kind.Enter)
              {
                terminal.applyForegroundColor(Terminal.Color.WHITE);
                terminal.applyBackgroundColor(Terminal.Color.BLACK);
                if(!hasCaptured)
                {
                  terminal.moveCursor(x,y);
                  currentSquare=field.getSquare(x-3,y-4);
                  if(currentSquare.piece!=null)
                  {
                    currentPiece=currentSquare.piece;
                  }
                  putString(1,16,terminal,"Piece selected.");
                  putString(1,17,terminal,"Square coordinates at the time of piece selection: "+currentSquare.getX()+","+currentSquare.getY()+"           ");
                  putString(1,18,terminal,"Use the arrow keys and then press enter if you want to select another piece.    ");
                  putString(1,20,terminal,"Use arrow keys to navigate to a legal square.                                   ");
                  putString(1,21,terminal,"Press m to move to that square if it is legal.                                  ");
                  putString(1,22,terminal,"Press c to capture to that square if it is legal.                               ");
                }
                if(hasCaptured)
                {
                  terminal.moveCursor(x,y);
                  putString(1,16,terminal,"Cannot select piece because you were in the middle of capturing.                ");
                  putString(1,17,terminal,"Use arrow keys to select new capture destination, then press c to capture       ");
                  putString(1,18,terminal,"Press e to end turn                                                             ");
                  putString(1,20,terminal,"                                                                                ");
                  putString(1,21,terminal,"                                                                                ");
                  putString(1,22,terminal,"                                                                                ");
                }
              }
              if(key.getCharacter()=='m')
              {
                terminal.applyForegroundColor(Terminal.Color.WHITE);
                terminal.applyBackgroundColor(Terminal.Color.BLACK);
                if(!hasCaptured)
                {
                  terminal.moveCursor(x,y);
                  currentSquare=field.getSquare(x-3,y-4);
                  if(turner.move(currentPiece,currentSquare))
                  {
                    // turner.move(currentPiece,currentSquare);
                    red.myTurn=!red.myTurn;
                    black.myTurn=!black.myTurn;
                    putString(1,16,terminal,"Press enter to select a piece of your color for actions.                      ");
                    putString(1,17,terminal,"                                                                              ");
                    putString(1,18,terminal,"                                                                              ");
                    putString(1,20,terminal,"                                                                              ");
                    putString(1,21,terminal,"                                                                              ");
                    putString(1,22,terminal,"                                                                              ");
                  }
                  else
                  {
                    putString(1,20,terminal,"Square coordinates for target square: "+currentSquare.getX()+","+currentSquare.getY()+"            ");
                    putString(1,21,terminal,"Piece selected to move: "+currentPiece+"                  ");
                    putString(1,22,terminal,"Error: Move failed                                                            ");
                  }
                }
                if(hasCaptured)
                {
                  terminal.moveCursor(x,y);
                  putString(1,16,terminal,"Cannot move piece because you were in the middle of capturing.                  ");
                  putString(1,17,terminal,"Use arrow keys to select new capture destination, then press c to capture       ");
                  putString(1,18,terminal,"Press e to end turn                                                             ");
                }
              }
              if(key.getCharacter()=='c')
              {
                terminal.applyForegroundColor(Terminal.Color.WHITE);
                terminal.applyBackgroundColor(Terminal.Color.BLACK);
                terminal.moveCursor(x,y);
                currentSquare=field.getSquare(x-3,y-4);
                if(turner.capture(currentPiece,currentSquare))
                {
                  if(turner==red)   blackPiecesLeft--;
                  if(turner==black) redPiecesLeft--;
                  hasCaptured=true;
                }
                else
                {
                  putString(1,20,terminal,"Square coordinates for target square to capture to: "+currentSquare.getX()+","+currentSquare.getY()+"               ");
                  putString(1,21,terminal,"Piece selected to move for capture: "+currentPiece+"                                        ");
                  putString(1,22,terminal,"Error: Capture failed                                                        ");
                }
                if(hasCaptured&&!turner.canCapture(currentPiece))
                {
                  red.myTurn=!red.myTurn;
                  black.myTurn=!black.myTurn;
                  hasCaptured=false;
                  putString(1,16,terminal,"Press enter to select a piece of your color for actions.                      ");
                  putString(1,17,terminal,"                                                                              ");
                  putString(1,18,terminal,"                                                                              ");
                  putString(1,20,terminal,"                                                                              ");
                  putString(1,21,terminal,"                                                                              ");
                  putString(1,22,terminal,"                                                                              ");
                }

              }
              if(hasCaptured && turner.canCapture(currentPiece))
              {
                putString(1,20,terminal,"You can still capture!                                                           ");
                putString(1,21,terminal,"Use arrow keys to select new capture destination, then press c to capture        ");
                putString(1,22,terminal,"Press e to end turn.                                                             ");
                if(key.getCharacter()=='e')
                {
                  red.myTurn=!red.myTurn;
                  black.myTurn=!black.myTurn;
                  putString(1,16,terminal,"                                                                              ");
                  putString(1,17,terminal,"                                                                              ");
                  putString(1,18,terminal,"                                                                              ");
                  putString(1,20,terminal,"Turn ended. To check whose turn it is, look four lines above.                 ");
                  putString(1,21,terminal,"                                                                              ");
                  putString(1,22,terminal,"                                                                              ");
                }
              }
            }
          }
        }

        // these are keys regardless of menuMode or not
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

        if (key.getKind() == Key.Kind.Escape) {
          screen.stopScreen();
					terminal.exitPrivateMode();
					running = false;
				}

        terminal.applyForegroundColor(Terminal.Color.WHITE);
        terminal.applyBackgroundColor(Terminal.Color.BLACK);
				// putString(1,4,terminal,"["+key.getCharacter() +"]");
				putString(1,1,terminal,key+"        ");//to clear leftover letters pad withspaces
			}

			//DO EVEN WHEN NO KEY PRESSED:
			long tEnd = System.currentTimeMillis();
			long millis = tEnd - tStart;
      terminal.applyForegroundColor(Terminal.Color.WHITE);
      terminal.applyBackgroundColor(Terminal.Color.BLACK);
			putString(1,2,terminal,"Milliseconds since start of program: "+millis+"                ");
			if(millis/1000 > lastSecond){
				lastSecond = millis / 1000;
				//one second has passed.
				putString(1,3,terminal,"Seconds since start of program: "+lastSecond+"                ");

			}
		}
    screen.refresh();
	}
}
