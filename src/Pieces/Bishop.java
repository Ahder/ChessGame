package Pieces;

import Game.Coordinate;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Bishop extends Piece {

    Type type;
    String image;


    public Bishop(int x, int y, Color color) {
        super(x, y, color);
        this.image = verifyImage(color);
    }

    @Override
    public ArrayList<Coordinate> validMoves(Piece[][] board) {

        ArrayList<Coordinate> allowedMoves = new ArrayList<>();

        //all possible moves in the down positive diagonal
        for (int j = this.position.getY() + 1, i = this.position.getX()+ 1; j < 8 && i < 8; j++, i++) {
            Piece temp = board[i][j];
            if (temp instanceof EmptySquare) {
                allowedMoves.add(temp.position);
            } else if (temp.getColor() != this.getColor()) {
                allowedMoves.add(temp.position);
                break;
            } else {
                break;
            }
        }

        //all possible moves in the up positive diagonal
        for (int j = this.position.getY()  - 1, i = this.position.getX()  + 1; j > -1 && i < 8; j--, i++) {
            Piece temp = board[i][j];
            if (temp instanceof EmptySquare) {
                allowedMoves.add(temp.position);
            } else if (temp.getColor() != this.getColor()) {
                allowedMoves.add(temp.position);
                break;
            } else {
                break;
            }
        }

        //all possible moves in the up negative diagonal
        for (int j = this.position.getY() - 1, i = this.position.getX()- 1; j > -1 && i > -1; j--, i--) {
            Piece temp = board[i][j];
            if (temp instanceof EmptySquare) {
                allowedMoves.add(temp.position);
            } else if (temp.getColor() != this.getColor()) {
                allowedMoves.add(temp.position);
                break;
            } else {
                break;
            }
        }

        //all possible moves in the down negative diagonal
        for (int j = this.position.getY() + 1, i = this.position.getX()- 1; j < 8 && i > -1; j++, i--) {
            Piece temp = board[i][j];
            if (temp instanceof EmptySquare) {
                allowedMoves.add(temp.position);
            } else if (temp.getColor() != this.getColor()) {
                allowedMoves.add(temp.position);
                break;
            } else {
                break;
            }
        }

        return allowedMoves;
    }

    @Override
    public Type getType() {
        return null;
    }

    @Override
    public String getImage() {
        return this.image;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public String verifyImage(Color color) {
        if(color == Color.BLACK)
        {
            this.type = Type.BB;
            return "\u265D";
        }
        else
        {
            this.type = Type.WB;
            return "\u2657";
        }
    }


}
