package main;

public class Rectangle extends Shape {
    public Rectangle(int x, int y) {
        super(x, y);
    }

    @Override
    public ShapeRenderer getRenderer() {
        return null;
    }
}
