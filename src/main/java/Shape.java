import java.io.Serializable;

public abstract class Shape implements Cloneable, Serializable {
    protected int x = 0;
    protected int y = 0;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Shape translate(int dx, int dy) {
        Shape newShape = null;

        try {
            newShape = (Shape) this.clone();
            newShape.x -= dx;
            newShape.y -= dy;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return newShape;
    }

    public String toSvg() {
        return "";
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " (X: " + x + ", Y: " + y + ")";
    }
}
