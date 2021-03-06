package Game;

import java.util.Objects;

public class Coordinate {

    private int x;
    private int y;


    public Coordinate(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    public Coordinate getValue()
    {
        return this;
    }

    //Override equals method to compare 2 objects
    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof Coordinate)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Coordinate c = (Coordinate) o;

        // Compare the data members and return accordingly
        return Integer.compare(x, c.x) == 0
                && Double.compare(y, c.y) == 0;
    }


}
