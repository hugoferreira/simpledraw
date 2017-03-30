package main;

public class CreateCircle extends CreateShape {
    public CreateCircle(Document document, int x, int y) {
        super(document, x, y);
    }

    @Override
    Shape createShape() {
        return new Circle(x, y);
    }
}
