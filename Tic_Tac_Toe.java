import java.util.Random;
import java.util.Scanner;
public class Tic_Tac_Toe
{
    public static void main(String args[]) 
    {
        Scanner sc =  new Scanner(System.in);
    char board[][] = { {' ',' ',' '},{' ',' ',' '},{' ',' ',' '} };
    print_board(board);
    while(true)
    {
        player_turn(board,sc);
        if(is_game_finished(board))
        {
            break;
        }
        print_board(board);
        computer_turn(board);
        if(is_game_finished(board))
        {
            break;
        }
        print_board(board);
    }
    sc.close();
        
    }

    private static boolean  is_game_finished(char board[][]) 
    {
        if(has_contestant_won(board,'x'))
        {
            print_board(board);
            System.out.println("Player wins!");
            return true;
        }
        
        if(has_contestant_won(board,'o')) //"o" is the alphabet and not number '0'
        {
            print_board(board);
            System.out.println("System wins!");
            return true;
        }

        for(int i =0;i<board.length;i++)
        {
            for(int j =0;j<board[i].length;j++)
            {
                if(board[i][j]==' ')
                {
                    return false;
                }
            }
        }
        print_board(board);
        System.out.println("There is a tie!");
        return true;
    }
    private static boolean has_contestant_won(char board[][],char symbol)
    {
        if((board[0][0]==symbol && board[0][1]==symbol && board[0][2]==symbol) ||
           (board[1][0]==symbol && board[1][1]==symbol && board[1][2]==symbol) ||
           (board[2][0]==symbol && board[2][1]==symbol && board[2][2]==symbol) || 

           (board[0][0]==symbol && board[1][0]==symbol && board[2][0]==symbol) ||
           (board[0][1]==symbol && board[1][1]==symbol && board[2][1]==symbol) ||
           (board[0][2]==symbol && board[1][2]==symbol && board[2][2]==symbol) || 

           (board[0][0]==symbol && board[1][1]==symbol && board[2][2]==symbol) ||
           (board[0][2]==symbol && board[1][1]==symbol && board[2][0]==symbol) )
        {
            return true;
        }
        return false;
    }

    private static void computer_turn(char board[][])
    {
        Random rand = new Random();
        int computer_move;
        while(true)
        {
            computer_move = rand.nextInt(9)+1;
            if(is_valid_move(board,Integer.toString(computer_move)))
            {
                break;
            }
        }
        System.out.println("Computer chose" + computer_move );
        place_move(board,Integer.toString(computer_move),'o');
    }
    private static boolean is_valid_move(char board[][],String position)
    {
        switch(position)
        {
            case "1" :
            return (board[0][0]==' ');
            case "2" :
            return (board[0][1]==' ');
            case "3" :
            return (board[0][2]==' ');
            case "4" :
            return (board[1][0]==' ');
            case "5" :
            return (board[1][1]==' ');
            case "6" :
            return (board[1][2]==' ');
            case "7" :
            return (board[2][0]==' ');
            case "8" :
            return (board[2][1]==' ');
            case "9" :
            return (board[2][2]==' ');
            default:
            return false;
        }
    }
    private static void player_turn(char board[][], Scanner sc)
    {
        String userinput;
        while(true)
        {
            System.out.println("Where would you like to play between 1 to 9 ?");
            userinput = sc.nextLine();
            if(is_valid_move(board,userinput))
            {
                break;
            }
            else
            {
                System.out.println("Is not valid move.");
            }
        }
        place_move(board,userinput,'x');
    }
    private static void place_move(char board[][],String position,char symbol)
    {
        switch(position)
        {
            case "1" :
            board[0][0] = symbol;
            break;
            case "2" :
            board[0][1] = symbol;
            break;
            case "3" :
            board[0][2] = symbol;
            break;
            case "4" :
            board[1][0] = symbol;
            break;
            case "5" :
            board[1][1] = symbol;
            break;
            case "6" :
            board[1][2] = symbol;
            break;
            case "7" :
            board[2][0] = symbol;
            break;
            case "8" :
            board[2][1] = symbol;
            break;
            case "9" :
            board[2][2] = symbol;
            break;
            default :
            System.out.println(":(");

        }
    }
    private static void print_board(char board[][])
    {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-+-+-");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-+-+-");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }
}