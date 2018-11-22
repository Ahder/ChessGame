package Pieces;

import Game.Coordinate;

import java.util.ArrayList;


public class Pawn extends Piece {

    Type type;
    String image;


    public Pawn(int x, int y, Color color) {
        super(x, y, color);
        this.image = verifyImage(color);
        initList();
    }

    public void initList()
    {
        possibleMoves = new ArrayList<>();

        //black patterns

        possibleMoves.add(new Coordinate(2,0)); // 2 squares move
        possibleMoves.add(new Coordinate(1,0));
        possibleMoves.add(new Coordinate(1,-1));
        possibleMoves.add(new Coordinate(1,1));


        //white patterns
        possibleMoves.add(new Coordinate(-2,0)); // 2 squares move
        possibleMoves.add(new Coordinate(-1,0));
        possibleMoves.add(new Coordinate(-1,1));
        possibleMoves.add(new Coordinate(-1,-1));

    }

    @Override
    public ArrayList<Coordinate> validMoves(Piece[][] board) {

        ArrayList<Coordinate> allowedMoves = new ArrayList<>();

        if(this.getColor() == Color.BLACK)
        {
            int k=0;
            if(this.position.getX()!=1)
            {
                k=1;
            }

            for (int i = k; i < 4 ; i++) {

                Coordinate destination = new Coordinate(this.position.getX()+possibleMoves.get(i).getX(),
                        this.position.getY()+possibleMoves.get(i).getY());

                int destX = destination.getX();
                int destY = destination.getY();

                if(testBound(destX, destY))
                {
                    Piece p = board[destX][destY];

                    if(p.getImage() == "\u5000" && p.position.getY() == this.position.getY())
                    {
                        allowedMoves.add(destination);
                    }
                    if(p.getImage() != "\u5000" && p.position.getY() != this.position.getY())
                    {
                        allowedMoves.add(destination);

                    }
                }

            }

        }
        else //this.getColor() == Color.WHITE
        {
            int k=2;
            if(this.position.getX()!=6)
            {
                k=3;
            }

            for (int i = k; i < 8; i++) {

                Coordinate destination = new Coordinate(this.position.getX()+possibleMoves.get(i).getX(),
                        this.position.getY()+possibleMoves.get(i).getY());

                int destX = destination.getX();
                int destY = destination.getY();

                if(testBound(destX, destY))
                {
                    Piece p = board[destX][destY];

                    if(p.getImage() == "\u5000" && p.position.getY() == this.position.getY())
                    {
                        allowedMoves.add(destination);
                    }

                    if(p.getImage() != "\u5000" && p.position.getY() != this.position.getY())
                    {
                        allowedMoves.add(destination);

                    }
                }

            }

        }

       /*for (int i = 0; i < allowedMoves.size(); i++) {
            System.out.println(allowedMoves.get(i).getX()+","+allowedMoves.get(i).getY());
        }*/

        return allowedMoves;
    }

    @Override
    public Color getColor() {
        return this.color;
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
    public String verifyImage(Color color) {
        if(color == Color.BLACK)
        {
            this.type = Type.BP;
            return "\u265F";
        }
        else
        {
            this.type = Type.WP;
            return "\u2659";
        }
    }
}
