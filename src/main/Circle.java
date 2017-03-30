package main;

public class Circle extends Shape {
    public Circle(int x, int y) {
        super(x, y);
    }

    @Override
    public ShapeRenderer getRenderer() {
        return new CircleRenderer(this);
    }
}
