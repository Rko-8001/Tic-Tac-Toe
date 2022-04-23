Name : Yadwinder Singh
Entry No.: 2020CSB1143

TicTacToe : CS202 Lab 2

Files included :
    TicTacToe.java
    README.txt
    Player.class
    PlayingBoard.class
    TicTacToe.class

Classes: (TicTacToe.java) 
    Player
    PlayingBoard
    TicTacToe

Packages Used: 
    java.util.*;

How to run: 
 ->     open folder in Terminal
 ->     type javac TicTacToe.java
 ->     then 3 files named
                            Player.class
                            TicTacToe.class
                            PlayingBoard.class
        will be created
 ->     type java TicTacToe

Inputing the data:
    Firstly 
        choose the version whether to play PlayervsPlayer or ComputervspPlayer
            0   : Player vs Player
            1   : Player vs Computer
    if(player vs Player)
    {
        enter name of player of both player
        then enter Then enter 2 integers in format of (row,comlumn)
        enter until the game is ended 
        enter the i,j in aobve format acc to the turn displayed in terminal
    }
    if(player vs Computer)
    {
        enter name of player
        then enter Then enter 2 integers in format of (row,comlumn)
        wait for computer move
        enter until the game is ended 
    }

How to input for playing game/ Rules:
        
column->    0   1   2 
row ->  0   !   .   #
        1   .   .   .
        2   .   .   ^

        as u can see 
        if user enter 
            for eg :  0 0 so he/she is marking at symbol !
                      2 2 so he/she is marking at symbol ^
                      0 2 so he/she is marking at symbol #
    **NOTE: if place is filled already u cant fill up there and cant enter 
            number less than 0 and greater than 2.

Methods Defined: 
    PlayingBoard
        Constructor : PlayingBoard()

        1. checkerFilled(int i, int j)      : return type boolean
        2. marker(char game, int i, int j)  : return type void
        3. displayBoard()                   : return type void
        4. checkWinner()                    : return type int
        5. checkPlayerWin(String line)      : return type int
        6. checkComputerWin(String line)    : return type int
        7. optimalMove(int mayWin, int i)   : return type int
        8. computerMove()                   : return type int

    Player
        Constructor:
            Player(String s, char game)
            Player(char game)
    
    TicTacToe
        1. main(String[] args)              : return type void
        2. computerVsPlayer()               : return type void
        3. void playerVsPlayer()            : return type void
        4. welcome()                        : return type boolean

Implementation:
    Enough number of comments are there to ubderstand the logic and syntax is kept simple and 
    readiblilty of code is good.