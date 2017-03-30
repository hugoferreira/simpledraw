package shapes;

public class NullShape extends Shape {
    public NullShape() {
        this(0, 0);
    }

    private NullShape(int x, int y) {
        super(x, y);
    }
}
