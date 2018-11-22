package Pieces;

import Game.Coordinate;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Knight extends Piece {


    Type type;
    String image;


    public Knight(int x, int y, Color color) {
        super(x, y, color);
        this.image = verifyImage(color);
        InitList();
    }

    private void InitList() {
        possibleMoves = new ArrayList<>();

        possibleMoves.add(new Coordinate(2,1));
        possibleMoves.add(new Coordinate(2,-1));
        possibleMoves.add(new Coordinate(-2,1));
        possibleMoves.add(new Coordinate(-2,-1));
        possibleMoves.add(new Coordinate(-1,2));
        possibleMoves.add(new Coordinate(1,2));
        possibleMoves.add(new Coordinate(-2,1));
        possibleMoves.add(new Coordinate(-2,-1));

    }

    @Override
    public ArrayList<Coordinate> validMoves(Piece[][] board) {

        ArrayList<Coordinate> allowedMoves = new ArrayList<>();
        for (int i = 0; i < possibleMoves.size(); i++)
        {
            Coordinate destination = new Coordinate(this.position.getX()+possibleMoves.get(i).getX(),
                    this.position.getY()+possibleMoves.get(i).getY());

            int destX = destination.getX();
            int destY = destination.getY();

            if(testBound(destX, destY))
            {
                Piece p = board[destX][destY];
                if (p.getColor() != this.color)
                {
                    allowedMoves.add(destination);
                }

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
            this.type = Type.BN;
            return "\u265E";
        }
        else
        {
            this.type = Type.WN;
            return "\u2658";
        }
    }
}
