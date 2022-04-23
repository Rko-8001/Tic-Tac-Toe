import java.util.*;
/*
    Tic Tac Toe board class this contains all functions regarding player and computer moves
    who wins the game and valid move or not
*/
class PlayingBoard
{
    //2D array of board
    char [][] board = new char [3][3];
    /*C
        Constructor for initializing 2D board to '.' 
    */
    PlayingBoard()
    {
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3;j++)
            {
                board[i][j] = '.';
            }
        }
    }
    /*
        method to check whether position is filler or not
    */
    public boolean checkerFilled(int i, int j)
    {
        if(board[i][j] == '.')      return true;
        else                        return false;
    }
    /*
        method to mark the positon of the player
    */
    public void marker(char game, int i, int j)
    {
        board[i][j] = game;
    }
    /*
        method to display the board after every move 
    */
    public void displayBoard()
    {
        for(int i=0; i<3; i++)
        {
            System.out.print("\t");
            for(int j = 0; j<3; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    /*
        method use to find whether the player has won or not
    */
    public int checkWinner()
    {
        String line = "0"; // string created to store move in 3 rows 3 columns 2 diagonals one by one
        for(int i=0; i<8;i++)
        {
            switch (i) 
            {
                case (0):   line = line + board[0][0] + board[0][1] + board[0][2]; // 1st  row
                break;
                case (1):   line = line + board[1][0] + board[1][1] + board[1][2]; //2nd row
                break;
                case (2):   line = line + board[2][0] + board[2][1] + board[2][2]; //3rd row
                break;
                case (3):   line = line + board[0][0] + board[1][1] + board[2][2]; // 1st column
                break;
                case (4):   line = line + board[0][0] + board[1][0] + board[2][0]; //2nd column
                break;
                case (5):   line = line + board[0][1] + board[1][1] + board[2][1]; //third column
                break;
                case (6):   line = line + board[0][2] + board[1][2] + board[2][2]; //1st diagonal (0,0) to (2,2)
                break;
                case (7):   line = line + board[2][0] + board[1][1] + board[0][2]; //2nd diagonal (2,0) to (0,2)
                break;
                default:
                break;
            }  
            if(line.equals("0XXX")) //player 1 wins
            return 1;
            if(line.equals("0OOO")) //player 2 or computer wins
            return 2;
            line = "0";
        }
        return 0; //nobody wins game on
    }
    /*
        method use in computer vs player version to check if player can win in next move 
        then computer should block that move
    */
    public int checkPlayerWin(String line)
    {
        if(line.equals("0.XX"))
        return 1;
        else if(line.equals("0X.X"))
        return 2;
        else if(line.equals("0XX."))
        return 3;
        else
        return 0;
    }
    /*
        method use in computer vs player version to check if computer can win in next move 
        then computer should mark there to win the game
    */
    public int checkComputerWin(String line)
    {
        if(line.equals("0.OO"))
        return 1;
        else if(line.equals("0O.O"))
        return 2;
        else if(line.equals("0OO."))
        return 3;
        else
        return 0;
    }
    /*
    this method operates acc to the above methods and give a optimal move for computer
        for example, game looks like this
        X X .
        . . .
        . O . 
        in this case this method will return 2 so that row = 2/3 and column = 2%3 
        thus, blocking win of computer.
        
        Similarly, 
        if computer can win then it will make move there
        as this method will return exact coordinates of that location
    */
    public int optimalMove(int mayWin, int i)
    {
        if(mayWin == 1) //if empty place is at starting (.XX)
        {
            switch(i)
            {
                case 0: return 0;
                case 1: return 3;
                case 2: return 6;
                case 3: return 0;
                case 4: return 1;
                case 5: return 2;
                case 6: return 0;
                case 7: return 6;
            }
        }
        else if(mayWin == 2) //if empty place is in middle (X.X)
        {
            switch(i)
            {
                case 0: return 1;
                case 1: return 4;
                case 2: return 7;
                case 3: return 3;
                case 4: return 4;
                case 5: return 5;
                case 6: return 4;
                case 7: return 4;
            }   
        }
        else if(mayWin == 3) // if empty place is at the end  (XX.)
        {
            switch(i)
            {
                case 0: return 2;
                case 1: return 5;
                case 2: return 8;
                case 3: return 6;
                case 4: return 7;
                case 5: return 8;
                case 6: return 8;
                case 7: return 2;
            }   
        }
        return -1;
    }
    /*
    this method uses above method and firstly return a possible move so that computer wins
    of winning of cimputer not pssible then block the possible win in next move of player 
    if nothing happens then return -1 so that it can randomly mark anywhere
    */
    public int computerMove()
    {
        int mayWin; 
        int  move;
        for(int i=0; i<8;i++)
        {
            String line = "0"; // string created to store move in 3 rows 3 columns 2 diagonals one by one
            switch (i) 
            {
                case 0:   line = line + board[0][0] + board[0][1] + board[0][2]; // 1st  row
                break;
                case 1:   line = line + board[1][0] + board[1][1] + board[1][2]; //2nd row
                break;
                case 2:   line = line + board[2][0] + board[2][1] + board[2][2]; //3rd row
                break;
                case 3:   line = line + board[0][0] + board[1][0] + board[2][0]; // 1st column
                break;
                case 4:   line = line + board[0][1] + board[1][1] + board[2][1]; //2nd column
                break;
                case 5:   line = line + board[0][2] + board[1][2] + board[2][2]; //third column
                break;
                case 6:   line = line + board[0][0] + board[1][1] + board[2][2]; //1st diagonal (0,0) to (2,2)
                break;
                case 7:   line = line + board[2][0] + board[1][1] + board[0][2]; //2nd diagonal (2,0) to (0,2)
                break;
                default:
                break;
            }    
            mayWin = checkComputerWin(line);
            move = optimalMove(mayWin, i);
            if(move != -1)  
            {
                return move;
            }
            line = "0";
            
        }
        for(int i=0; i<8;i++)
        {
            String line = "0"; // string created to store move in 3 rows 3 columns 2 diagonals one by one
            switch (i) 
            {
                case 0:   line = line + board[0][0] + board[0][1] + board[0][2]; // 1st  row
                break;
                case 1:   line = line + board[1][0] + board[1][1] + board[1][2]; //2nd row
                break;
                case 2:   line = line + board[2][0] + board[2][1] + board[2][2]; //3rd row
                break;
                case 3:   line = line + board[0][0] + board[1][0] + board[2][0]; // 1st column
                break;
                case 4:   line = line + board[0][1] + board[1][1] + board[2][1]; //2nd column
                break;
                case 5:   line = line + board[0][2] + board[1][2] + board[2][2]; //third column
                break;
                case 6:   line = line + board[0][0] + board[1][1] + board[2][2]; //1st diagonal (0,0) to (2,2)
                break;
                case 7:   line = line + board[2][0] + board[1][1] + board[0][2]; //2nd diagonal (2,0) to (0,2)
                break;
                default:
                break;
            }    
            mayWin = checkPlayerWin(line);
            move = optimalMove(mayWin, i);
            if(move != -1)  
            {
                return move;
            }
        }
        return -1;
    }
}
                         /**********************Board class ends*******************************/
                         /*
                         Player class. this class stores info of a player like its nname and its marking move (O or X)
                         */
class Player
{
    String name;  //name 
    char move;   // move
    /* 
    constructor with 2 parameters for creating player object
    */
    Player(String s, char game)
    {
        name = s;
        move = game;
    }
    /* 
        constructor with 1 parameters for creating computer object
    */
    Player(char game)
    {
        move  = game;
        name  = "Computer";
    }
}    
                            /**********************Player class ends*******************************/
/*
    this is our main class TicTacToe this class contains method which runs the game and
    you can 2 versions player vs player     and     player vs computer
*/
public class TicTacToe 
{
    // creating input stream
    static Scanner input = new Scanner(System.in);
    /*
        main method of class TicTacToe
        here all other methods are called
    */
    public static void main(String[] args)
    {
        /*
            creating a object of TicTacToe class so that 
            other method can be called
        */
        TicTacToe objTicTacToe = new TicTacToe();
        System.out.println("Hey!! Welcome to Tic Tac Toe");
        char playagain = '1';
        while(playagain == '1')
        {
            System.out.println("Please Choose one version of this game:\nEnter 0 for player vs player \n\tOR\nEnter 1 for player vs computer");
            // choice contains whether the user chooses PlayervsPlayer  or PlayervsComputer
            boolean choice = objTicTacToe.welcome();
            input.nextLine(); //just to skip enter to be storred as player name
            if(choice)
            {
                objTicTacToe.playerVsPlayer();
            }
            else
            {
                objTicTacToe.computerVsPlayer();
            }
            input.nextLine();
            System.out.println("Have a great game!! \nWanna play again or not\nPress 1 for playing");
            playagain = input.nextLine().charAt(0);
        }
        System.out.println("Thanks for playing...\n");
        //closing the input stream
        input.close(); 
    } 
    /*
        method for player vs computer version
    */
    public void computerVsPlayer()
    {
        //creating obard object
        PlayingBoard game = new PlayingBoard();
        System.out.println("Enter player name");
        String name = input.nextLine(); //inputing name of player
        /*
        creating pbects of player and computer
        */
        Player player1 =  new Player(name, 'X');
        Player computer = new Player('O');
        System.out.println("\n" + player1.name + " : X \tv/s\t " + computer.name + " : O\n" );  
        int decideWinner;
        int spaces = 0;
        game.displayBoard(); //displaying the board
        /*
            running the loop until one p;ayer wins or all spaces are filled ending game in a tie
        */
        while(spaces < 9)
        {
            int i,j;
            System.out.println(player1.name + " turn");
            /*  
                player input row and columns of the move if it is alrsdy filled then 
                ask for again inputing the unfillled space and mark his move there.
            */
            while(true)
            {
                System.out.print("Please choose a location: (row , column) : ");
                i = input.nextInt();
                j = input.nextInt();
                if(i>-1&& j>-1 && j<3 && i<3)
                {
                    if(game.checkerFilled(i, j))
                    {
                        game.marker('X', i, j);
                        break;
                    }
                    else
                    {
                        System.out.println("Already filled positon!! eneter another location");
                        continue;
                    }
                }
                else
                {
                    System.out.println("Wrong input!! Enter position again.");
                    continue;
                }
            }
            spaces++;
            // dislplaying game
            game.displayBoard();
            // check winner 
            decideWinner = game.checkWinner();
            // if player wins ending the game
            if(decideWinner == 1)
            {
                System.out.println(player1.name + " is winner.\n");
                break;
            }
            /*
                this condition is to cover the case when all spaces have been filled and
                no winner is there. and computer doesnt take its move as if it does it will end in a 
                runtime error of the program
            */
            if(spaces <9)
            {
                System.out.println("Computer taking time for a move. Please wait");
                /* 
                    this variable is for whether there exist a optimal move for computer or not
                    if yes then we get the move = i*3 + j;
                    if not then it invoke the random function to mark at random place
                */
                int randInvoke = game.computerMove();
                if(randInvoke == -1)
                {
                    do
                    {
                        i = (int)(Math.random()*3);
                        j = (int)(Math.random()*3);
                    }
                    while(!game.checkerFilled(i, j));
                }
                else
                {
                    i = randInvoke/3;
                    j = randInvoke%3;
                }
                game.marker(computer.move, i, j);
                spaces++;
                game.displayBoard();
                /* 
                    checking whtehr computer has won or not
                */
                decideWinner = game.checkWinner();
                if(decideWinner == 2)
                {
                    System.out.println(computer.name + " is winner.\n");
                    break;
                }    
            }
            // tie game if all spaces are filled
            if(spaces == 9)
            System.out.println("Tie game.");
        }
    }
    /*
    Player vs player class
    */
    public void playerVsPlayer()
    {   
        PlayingBoard game = new PlayingBoard();
        
        System.out.println("Enter the name of 1st player:");
        String name1 = input.nextLine();
        System.out.println("Enter the name of 2nd player: ");
        String name2 = input.nextLine();

        Player player1 = new Player(name1, 'X');
        Player player2 = new Player(name2, 'O');
        System.out.println("\n" + player1.name + " : X \tv/s\t " + player2.name + " : O\n" );  
        int decideWinner;
        char playerTurn = 'X'; //player turn 
        int spaces = 0;
        game.displayBoard();//displaying the board
        /*
            running the loop until one p;ayer wins or all spaces are filled ending game in a tie
            */
            while(spaces < 9)
        {
            int i,j;
            // updating payer's turn
            if(spaces%2 == 0)  
            {
                playerTurn = 'X';
                System.out.println(player1.name + " turn.");
            }
            else               
            {
                playerTurn = 'O';
                System.out.println(player2.name + " turn.");
            }
            /*  
                player input row and columns of the move if it is alrsdy filled then 
                ask for again inputing the unfillled space and mark his move there.
            */
            while(true)
            {
                System.out.print("Please choose a location: (row , column) : ");
                i = input.nextInt();
                j = input.nextInt();
                if(i>-1&& j>-1 && j<3 && i<3)
                {
                    if(game.checkerFilled(i, j))
                    {
                        game.marker(playerTurn, i, j);
                        break;
                    }
                    else
                    {
                        System.out.println("Already filled positon!! eneter another location");
                        continue;
                    }
                }
                else
                {
                    System.out.println("Wrong input!! Enter position again.");
                    continue;
                }
            }
            //dsplaying board
            game.displayBoard();
            /*
                checking game winner
            */
            decideWinner = game.checkWinner();
            if(decideWinner !=0)
            {
                if(playerTurn == 'X')
                {
                    System.out.println(player1.name + " is winner.\n");
                    break;
                }   
                else
                {
                    System.out.println(player2.name + " is winner.\n");
                    break;
                }
            }
            spaces++;
        }
        // ending a game in tie
        if(spaces == 9)
        System.out.println("Tie game.");
    }
    /*
        this method is used for just simple interface and for choosing between 2 version of a  game
    */
    public boolean welcome()
    {
        while(true)
        {
            int choice = input.nextInt();
            //for player vs player
            if(choice == 0 )
            {
                System.out.println("You have choosen Player vs Player.");
                return true;
            }
            else if(choice == 1)
            {
                System.out.println("You have choosen Player vs Computer. ");
                return false;
            }
            else
            {
                System.out.println("Wrong input! Enter the choice again (either 0 or 1)");
                continue;
            }
        }
    }
}
