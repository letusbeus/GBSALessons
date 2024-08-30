package car.ocp;

public class Square implements Shape{

    private final int side;

    public int getSide() {
        return side;
    }

    public Square(int side) {
        this.side = side;
    }
}
