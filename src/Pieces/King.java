package Pieces;

import Game.Coordinate;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class King extends Piece {

    Type type;
    String image;

    public King(int x, int y, Color color) {
        super(x, y, color);
        this.image = verifyImage(color);
        initList();
    }

    private void initList() {
        possibleMoves = new ArrayList<>();

        possibleMoves.add(new Coordinate(1 ,0));
        possibleMoves.add(new Coordinate(-1 ,0));
        possibleMoves.add(new Coordinate(0,1));
        possibleMoves.add(new Coordinate(0,-1));
        possibleMoves.add(new Coordinate(1 ,1));
        possibleMoves.add(new Coordinate(-1 ,-1));
        possibleMoves.add(new Coordinate(-1,1));
        possibleMoves.add(new Coordinate(1 ,-1));

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
            this.type = Type.BK;
            return "\u265A";
        }
        else
        {
            this.type = Type.WK;
            return "\u2654";
        }
    }
}
