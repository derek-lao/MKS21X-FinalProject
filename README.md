# MKS21X-FinalProject

Welcome to Checkers, written by Derek Lao. This is a variant of checkers where capturing is not obligatory. There is nothing stopping the players from playing in a fashion where capturing is obligatory, it is just that the software will not force players to make a capture when a capture is possible.
****************************************************************************************************************************************
Instructions to compile and run:
In terminal, while in this directory, type:  javac -cp lanterna.jar:. Checkers.java
Then, type: java -cp lanterna.jar:. Checkers
There! Just follow the instructions on the screen!
****************************************************************************************************************************************
Rules of the game:
Every player begins with 12 pieces on predetermined squares of the board. 

Movement:
Every turn by a player, one of their pieces may only move one square at a time along a diagonal. These pieces may only move forwards, not backwards. They may only begin moving backwards when they have reached the respective ends of the board, where they become kings. A non-king is depicted by a solid circle, and a king is depicted by an empty circle. After a movement, the active player's TURN ENDS.

Capturing:
Similar to movement, every turn by a player, one of their pieces may capture an enemy piece if necessary. If the piece is not a king, it may not capture backwards until it has become a king. A king may capture in any direction along the diagonals. The requirements for making a capture are as follows: The piece you want to capture is of opposite color, and the square past that piece in the direction that you want to capture in is empty. If after making a single capture, you are still able to capture, you may make additional captures (with that same piece) until you decide to stop capturing or there are no more legal captures available for that piece. When that happens, the active player's TURN ENDS. When a piece is captured, the opponent loses that piece, and control of that piece. The piece disappears, so the square it was originally on was empty.

Becoming King:
When a piece reaches the end of the board respective to the player (as mentioned above), a piece becomes king. Once a piece becomes king, it remains king until captured until the game ends. A non-king may not move backwards in any way (movement or capturing), while a king may move backwards (movement or capturing)

****************************************************************************************************************************************
Keystrokes

Follow the keystrokes to progress through the game.
General keystrokes:

Whether game is in progress or not:

ArrowUp, ArrowDown, ArrowLeft, ArrowRight - Move cursor up, down, left, or right respectively
Esc - Quit game

While game in progress:
Enter - select piece
m - move piece to a designated square. This can only work if a piece has been selected (through the use of the enter key)
c - capture piece. The Piece will move to the square it should move to after capture. Again, this only works if a piece has been selected. This also moves if the piece has already made a capture in the same turn.
e - if in the middle of a capture sequence and the active player desires to end their turn, press this key to do so
spacebar - to pause game and go into menu

While in menu:
p - start new game
g - continue game

If the game has ended:
spacebar - go into menu
****************************************************************************************************************************************
Development Log: 
1/4:   Created repository
1/5:   Added class shell for Square class
1/7:   Completed Square class, added method shells for Board.java. Still have yet to test either.
1/8:   Added constructor and documentation for Piece.java, added code for the setup() method in Board.java. Still have yet to test.
1/9:   Tested lanterna 2.1 to work on school computer
1/10:  Tested lanterna 3.0 to work at home computer
1/11:  Tested lanterna 2.1 to work on home computer using PuTTY
1/12:  Learned how to use Terminal commands using lanterna. Have yet to write code to implement. Plan is to use every character as a space. Ideally, it should be to use every two characters as a space to mke it square.
1/13:  Wrote code for all the classes. One capture was able to work, but all the other ones failed. Move seemed to work out fine.
1/16:  Decided to make the move and capture method not involve linking squares. Changed their arguments.
1/17:  Actually wrote the methods, delinked the squares, and changed board size to 10x10 to avoid ArrayOutOfBoundsException.
1/18:  Added error lines for if the code does not work. For some reason, capture and move failed, but if I hard coded them, they worked.
1/19:  More nullPointerException's so I changed board size to 12x12. Enabled capture and move in terminal. Wrote code for canCapture in Player.java. Made it an option to capture multiple times. If the player does not want to capture, they can press e to escape move.
1/20:  Added move restrictions for if a player was in the middle of capturing. Added menu. Fixed terminal lagging. Working on implementing screen. Nullpointerexception encountered when king tries to capture backwards.
1/21:  Fixed nullpointerexception, it was due to a typo in Player.java. I have added messages for every action, and fixed flickering in places where flickering is undesirable. I have added victory messages, and end messages. Upon finishing, I am a bit emotional. It has been quite the journey.
