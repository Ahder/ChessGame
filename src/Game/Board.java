package Game;

import Pieces.*;

public class Board {

    
    public Piece[][] InitBoard(){

        Pawn[] blackPawns = new Pawn[8];
        Pawn[] whitePawns = new Pawn[8];



        for (int i = 0; i < 8; i++) {
                blackPawns[i] = new Pawn(1,i,Color.BLACK);
        }

        for (int i = 0; i < 8; i++) {
            whitePawns[i] = new Pawn(6,i,Color.WHITE);
        }

        Rook BK1 = new Rook(0,0, Color.BLACK);
        Rook BK2 = new Rook(0,7, Color.BLACK);
        
        Piece[][] board = {
                {BK1, new Knight(0,1,Color.BLACK), new Bishop(0,2,Color.BLACK),
                        new Queen(0,3,Color.BLACK), new King(0, 4, Color.BLACK), new Bishop(0, 5, Color.BLACK),
                        new Knight(0, 6, Color.BLACK), BK2},

                {blackPawns[0], blackPawns[1], blackPawns[2], blackPawns[3], blackPawns[4], blackPawns[5], blackPawns[6], blackPawns[7]},

                {new EmptySquare(2,0),new EmptySquare(2,1),new EmptySquare(2,2),new EmptySquare(2,3),
                        new EmptySquare(2,4),new EmptySquare(2,5),new EmptySquare(2,6),new EmptySquare(2,7)},

                {new EmptySquare(3,0),new EmptySquare(3,1),new EmptySquare(3,2),new EmptySquare(3,3),
                        new EmptySquare(3,4),new EmptySquare(3,5),new EmptySquare(3,6),new EmptySquare(3,7)},

                {new EmptySquare(4,0),new EmptySquare(4,1),new EmptySquare(4,2),new EmptySquare(4,3),
                        new EmptySquare(4,4),new EmptySquare(4,5),new EmptySquare(4,6),new EmptySquare(4,7)},

                {new EmptySquare(5,0),new EmptySquare(5,1),new EmptySquare(5,2),new EmptySquare(5,3),
                        new EmptySquare(5,4),new EmptySquare(5,5),new EmptySquare(5,6),new EmptySquare(5,7)},

                {whitePawns[0], whitePawns[1], whitePawns[2], whitePawns[3], whitePawns[4], whitePawns[5], whitePawns[6], whitePawns[7]},

                {new Rook(7,0, Color.WHITE), new Knight(7,1,Color.WHITE), new Bishop(7,2,Color.WHITE),
                        new Queen(7,3,Color.WHITE), new King(7, 4, Color.WHITE), new Bishop(7, 5, Color.WHITE),
                        new Knight(7, 6, Color.WHITE), new Rook(7, 7, Color.WHITE)}

        };

        return board;
    }

    public void printBoard(Piece board[][]){
        int num = 8;
        System.out.println("| ------------------------------------ |");
        for (int i = 0; i < 8; i++) {
            System.out.print(num+"| ");
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j].getImage()+" | ");
            }
            System.out.println();
            System.out.println(" -------------------------------------- ");
            --num;
        }

        System.out.println("   A    B    C    D    E    F    G    H");

    }




}
