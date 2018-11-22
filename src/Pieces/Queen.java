package Pieces;

import Game.Coordinate;

import java.util.ArrayList;

public class Queen extends Piece {


    Type type;
    String image;


    public Queen(int x, int y, Color color) {
        super(x, y, color);
        this.image = verifyImage(color);
    }

    @Override
    public ArrayList<Coordinate> validMoves(Piece[][] board) {

        ArrayList<Coordinate> allowedMoves = new ArrayList<>();

        //check for the bottom part
        for (int i = this.position.getX() + 1; i < 8; i++) {
            Piece temp = board[i][this.position.getY()];
            if (temp instanceof EmptySquare) {
                allowedMoves.add(new Coordinate(i,temp.position.getY()));
            } else if (temp.getColor() != this.getColor()) {
                allowedMoves.add(new Coordinate(i,temp.position.getY()));
                break;
            } else {
                break;
            }
        }

        //check for the upper part
        for (int i = this.position.getX() - 1; i > -1; i--) {
            Piece temp = board[i][this.position.getY()];
            if (temp instanceof EmptySquare) {
                allowedMoves.add(new Coordinate(i,temp.position.getY()));
            } else if (temp.getColor() != this.getColor()) {
                allowedMoves.add(new Coordinate(i,temp.position.getY()));
                break;
            } else {
                break;
            }
        }

        //check for left part
        for (int i = this.position.getY() - 1; i > -1; i--) {
            Piece temp = board[this.position.getX()][i];
            if (temp instanceof EmptySquare) {
                allowedMoves.add(new Coordinate(temp.position.getX(),i));
            } else if (temp.getColor() != this.getColor()) {
                allowedMoves.add(new Coordinate(temp.position.getX(),i));
                break;
            } else {
                break;
            }
        }

        //check for right part
        for (int i = this.position.getY() +1; i < 8; i++) {
            Piece temp = board[this.position.getX()][i];
            if (temp instanceof EmptySquare) {
                allowedMoves.add(new Coordinate(temp.position.getX(),i));
            } else if (temp.getColor() != this.getColor()) {
                allowedMoves.add(new Coordinate(temp.position.getX(),i));
                break;
            } else {
                break;
            }

        }

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
        return this.type;
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
            this.type = Type.BQ;
            return "\u265B";
        }
        else
        {
            this.type = Type.WQ;
            return "\u2655";
        }
    }


}
