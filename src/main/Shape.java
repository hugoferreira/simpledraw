package main;

public abstract class Shape implements Cloneable {
    protected int x = 0;
    protected int y = 0;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract ShapeRenderer getRenderer();

    public Shape translate(int dx, int dy) {
        Shape newShape = null;

        try {
            newShape = (Shape) this.clone();
            newShape.x = newShape.getX() - dx;
            newShape.y = newShape.getY() - dy;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return newShape;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " (X: " + getX() + ", Y: " + getY() + ")";
    }
}
