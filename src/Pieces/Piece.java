package Pieces;

import Game.Coordinate;

import java.util.ArrayList;

public abstract class Piece {

    Coordinate position;
    Color color;
    ArrayList<Coordinate> possibleMoves;

    public Piece(int x, int y, Color color)
    {
        this.position = new Coordinate(x,y);
        this.color = color;
    }

    public Piece (int x, int y)
    {
        this.position = new Coordinate(x, y);
    }

    public void updatePosition(int x, int y)
    {
        this.position = new Coordinate(x,y);
    }

    public Piece getPiece()
    {
        return this;
    }

    public boolean testBound(int x, int y)
    {
        if (x>7 || x<0 || y>7 || y<0 )
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public abstract ArrayList<Coordinate> validMoves(Piece[][] board);

    public abstract Type getType();

    public abstract String getImage();

    public abstract Color getColor();

    public abstract String verifyImage(Color color);

}
