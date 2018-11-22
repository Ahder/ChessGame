import Game.Actions;
import Game.Board;
import Game.Coordinate;
import Pieces.Piece;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // NB : Code Kill method (change permute on Actions maybe ?)

    static boolean gameOver;
    static int turn; //0 for the white and 1 for the black

    public static void main(String[] args) {

        // Init Board
        gameOver = false;
        Board b = new Board();
        Actions actions = new Actions();
        Piece[][] board = b.InitBoard();
        b.printBoard(board);


        Scanner scanner = new Scanner(System.in);
        while(gameOver != true) {
            //Enter a move
            System.out.print("Enter a move : (ex. B2,B3) ");
            String move = scanner.nextLine();
            String[] splitedMove = actions.readAction(move.toUpperCase());


            Coordinate selectedPieceCoord = actions.convert(splitedMove[0]);
            Coordinate destCoord = actions.convert(splitedMove[1]);


            //Check for Valid Moves
            ArrayList<Coordinate> list;
            list = board[selectedPieceCoord.getX()][selectedPieceCoord.getY()].validMoves(board);
            if (list.contains(destCoord)) {

                System.out.println("Movement allowed !");
                board = actions.permute(selectedPieceCoord, destCoord, board);
                b.printBoard(board);

            } else {

                System.out.println("Movement Denied !");

            }


        }




    }
}
