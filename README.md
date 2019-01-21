# MKS21X-FinalProject

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
1/20:  Added move restrictions for if a player was in the middle of capturing. Added menu. I am trying to get screen to work because my terminal lags like crazy without it.
