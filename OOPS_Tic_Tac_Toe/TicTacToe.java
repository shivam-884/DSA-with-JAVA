package OOPS_Tic_Tac_Toe;

import java.util.Scanner;

public class TicTacToe {
    private Player player1, player2;
    private Board board;
    private int numPlayers;

    public static void main(String[] args){
        TicTacToe t = new TicTacToe();
        t.startGame();
    }

    public void startGame(){
        // Take players input
        Scanner s = new Scanner(System.in);
        player1 = takePlayerInput(++numPlayers);
        player2 = takePlayerInput(++numPlayers);
        while (player1.getSymbol() == player2.getSymbol()){
            System.out.println("Symbol already taken!! Please enter the symbol again");
            player2.setSymbol(s.next().charAt(0));
        }

        // Create the board
        board = new Board(player1.getSymbol(), player2.getSymbol());

        // play the game.
        boolean player1Turn = true;
        int status = Board.INCOMPLETE;
        while(status == Board.INCOMPLETE || status == Board.INVALIDMOVE) {
            if(player1Turn){
                System.out.println("Player 1 -" + player1.getName() + "'s turn");
                System.out.println("Enter x: ");
                int x = s.nextInt();
                System.out.println("Enter y: ");
                int y = s.nextInt();

                // This move() tell us whether the move is valid or not and also tell us
                // the status of game like if status is 1 --> player 1 wins, status is 2 --> player 2 wins,
                // status is 3 --> Draw, status is 4 --> Incomplete, status is 5 --> Invalid
                status = board.move(player1.getSymbol(), x, y);
                if(status == Board.INVALIDMOVE){
                    System.out.println("Invalid move!! Please try again !!!");
                    continue;
                }
            }else {
                System.out.println("Player 2 -" + player2.getName() + "'s turn");
                System.out.println("Enter x: ");
                int x = s.nextInt();
                System.out.println("Enter y: ");
                int y = s.nextInt();

                status = board.move(player2.getSymbol(), x, y);
                if(status == Board.INVALIDMOVE){
                    System.out.println("Invalid move!! Please try again !!!");
                    continue;
                }
            }
            player1Turn = !player1Turn;
            board.print();
        }
        if(status == Board.PLAYER1WINS){
            System.out.println("Player 1 - " + player1.getName() + " wins !!");
        } else if (status == Board.PLAYER2WINS) {
            System.out.println("Player 2 - " + player2.getName() + " wins !!");
        }else{
            System.out.println("Draw !!");
        }
    }

    private Player takePlayerInput(int num){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Player " + num + " name: ");
        String name = s.nextLine();
        System.out.println("Enter Player " + num + " symbol: ");
        char symbol = s.next().charAt(0);
        Player p = new Player(name,symbol);
        return p;
    }
}
