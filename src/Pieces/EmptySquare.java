package Pieces;

import Game.Coordinate;

import java.util.ArrayList;

public class EmptySquare extends Piece{

    Type type;
    String image;

    public EmptySquare(int x, int y) {
        super(x, y);
        this.type = Type.EMPTY;
        this.image = "\u5000";

    }

    @Override
    public ArrayList<Coordinate> validMoves(Piece[][] board) {
        return null;
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
        return null;
    }
}
