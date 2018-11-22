package Game;

import Pieces.EmptySquare;
import Pieces.Piece;
import sun.plugin.dom.core.CoreConstants;

import java.util.ArrayList;

public class Actions {

    //constructor
    public Actions(){}

    //read user input and split it into two Coordinates
    public String[] readAction(String input)
    {
        String[] output;
        output = input.split(",");
        return output;
    }

    //convert the coordinates into rows and columns
    public Coordinate convert(String input)
    {
        Coordinate destination = new Coordinate(-1,-1);
        int x,y = -1;
        char a = input.charAt(0);
        switch (a)
        {
            case 'A' : y = 0; break;
            case 'B' : y = 1; break;
            case 'C' : y = 2; break;
            case 'D' : y = 3; break;
            case 'E' : y = 4; break;
            case 'F' : y = 5; break;
            case 'G' : y = 6; break;
            case 'H' : y = 7; break;

        }

        x = Character.getNumericValue(input.charAt(1))-8;
        destination.setX(Math.abs(x));
        destination.setY(y);

        return destination;
    }


    // update the board after a valid move
    public Piece[][] permute(Coordinate init, Coordinate dest, Piece[][] board)
    {
        Piece p1 = board[init.getX()][init.getY()];
        Piece p2 = board[dest.getX()][dest.getY()];

        if(p2 instanceof EmptySquare)
        {

            board[init.getX()][init.getY()].updatePosition(dest.getX(), dest.getY());
            board[dest.getX()][dest.getY()].updatePosition(init.getX(), init.getY());

            board[init.getX()][init.getY()] = p2;
            board[dest.getX()][dest.getY()] = p1;

        }
        else
        {
            board[init.getX()][init.getY()].updatePosition(dest.getX(), dest.getY());
            board[dest.getX()][dest.getY()].updatePosition(init.getX(), init.getY());

            board[dest.getX()][dest.getY()] = p1;
            board[init.getX()][init.getY()] = new EmptySquare(init.getX(),init.getY());

        }

        return board;
    }


}
