

//API : http://mabe02.github.io/lanterna/apidocs/2.1/
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


public class TerminalDemo {
	// public static void putString(int r, int c, String s, Terminal.Color f, Terminal.Color b){
	// 	moveCursor(r,c);
	// 	for(int i = 0; i < s.length();i++){
	// 		putCharacter(s.charAt(i));
	// 	}
	// }
	public static void main(String[] args) {


		int x = 10;
		int y = 10;

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

			terminal.moveCursor(x,y);
			terminal.applyBackgroundColor(Terminal.Color.RED);//cursor background color
			terminal.applyForegroundColor(Terminal.Color.GREEN);//cursor foreground color
			//applySGR(a,b) for multiple modifiers (bold,blink) etc.
			// terminal.applySGR(Terminal.SGR.ENTER_REVERSE );//underlines on bottom
			terminal.applySGR(Terminal.SGR.ENTER_UNDERLINE);
			terminal.putCharacter('\u00a4');//puts a character in place of the cursor
			//terminal.putCharacter(' ');
			terminal.applyBackgroundColor(Terminal.Color.RED);
			terminal.applyForegroundColor(Terminal.Color.GREEN);
			terminal.applySGR(Terminal.SGR.RESET_ALL);//resets all code since the last Terminal.SGR, I think?


			// terminal.moveCursor(size.getColumns()-5,5);
			// terminal.applyBackgroundColor(Terminal.Color.RED);
			// terminal.applyForegroundColor(Terminal.Color.YELLOW);
			// terminal.applySGR(Terminal.SGR.ENTER_BOLD);
			// terminal.putCharacter(' ');
			// terminal.putCharacter(' ');
			// terminal.putCharacter('\u262d');
			// terminal.putCharacter(' ');
			// terminal.moveCursor(size.getColumns()-5,6);
			// terminal.putCharacter(' ');
			// terminal.putCharacter(' ');
			// terminal.putCharacter(' ');
			// terminal.putCharacter(' ');
			// terminal.applyBackgroundColor(Terminal.Color.DEFAULT);
			// terminal.applyForegroundColor(Terminal.Color.DEFAULT);

			Key key = screen.readInput();

			if (key != null)
			{

				if (key.getKind() == Key.Kind.Escape) {
					screen.stopScreen();
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

				screen.putString(1,4,"["+key.getCharacter() +"]",Terminal.Color.WHITE,Terminal.Color.RED);
				screen.putString(1,1,key+"        ",Terminal.Color.WHITE,Terminal.Color.RED);//to clear leftover letters pad withspaces
			}

			//DO EVEN WHEN NO KEY PRESSED:
			long tEnd = System.currentTimeMillis();
			long millis = tEnd - tStart;
			terminal.applyBackgroundColor(Terminal.Color.RED);
			terminal.applyForegroundColor(Terminal.Color.WHITE);
			terminal.moveCursor(1,2);
			terminal.putCharacter(' ');
			terminal.putCharacter(' ');
			screen.putString(1,2,"Milliseconds since start of program: "+millis,Terminal.Color.WHITE,Terminal.Color.RED);
			if(millis/1000 > lastSecond){
				lastSecond = millis / 1000;
				//one second has passed.
				screen.putString(1,3,"Seconds since start of program: "+lastSecond,Terminal.Color.WHITE,Terminal.Color.RED);

			}
		}
		screen.refresh();
	}
}
