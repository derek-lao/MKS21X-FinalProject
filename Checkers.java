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
  Player red,black;
  Board field;

  public static void putString(int r, int c,Terminal t, String s){
		t.moveCursor(r,c);
		for(int i = 0; i < s.length();i++){
			t.putCharacter(s.charAt(i));
		}
	}
	public static void main(String[] args) {

    Board field=new Board();
    field.setup();
		int x = 4;
		int y = 5;

		Terminal terminal = TerminalFacade.createTextTerminal();
		terminal.enterPrivateMode();

		TerminalSize size = terminal.getTerminalSize();
		terminal.setCursorVisible(false);

		boolean running = true;

		long tStart = System.currentTimeMillis();
		long lastSecond = 0;

		while(running){

			terminal.moveCursor(x,y);
      terminal.applyForegroundColor(Terminal.Color.WHITE);
      terminal.applyBackgroundColor(Terminal.Color.BLACK);
      terminal.applySGR(Terminal.SGR.ENTER_BOLD);
      terminal.applySGR(Terminal.SGR.RESET_ALL);

      for(int r=4;r<12;r++)
      {
        for(int c=5;c<13;c++)
        {
          if(field.getSquare(r-4,c-5).isRed())
          {
            terminal.moveCursor(r,c);
            terminal.applyForegroundColor(Terminal.Color.BLACK);
            terminal.applyBackgroundColor(Terminal.Color.WHITE);
            terminal.applySGR(Terminal.SGR.ENTER_BOLD);
            terminal.putCharacter(' ');
            // terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
            // terminal.applyForegroundColor(Terminal.Color.DEFAULT);
          }
          if(!field.getSquare(r-4,c-5).isRed())
          {
            terminal.moveCursor(r,c);
            terminal.applyForegroundColor(Terminal.Color.RED);
            terminal.applyBackgroundColor(Terminal.Color.BLACK);
            terminal.applySGR(Terminal.SGR.ENTER_BOLD);
            terminal.putCharacter('\u25cf');
            // terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
            // terminal.applyForegroundColor(Terminal.Color.DEFAULT);
          }
        }
      }
			Key key = terminal.readInput();

			if (key != null)
			{

				if (key.getKind() == Key.Kind.Escape) {

					terminal.exitPrivateMode();
					running = false;
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
	}
}
