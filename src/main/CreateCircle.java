package main;

import shapes.Circle;
import shapes.Shape;

public class CreateCircle extends CreateShape {
	private int radius;
    public CreateCircle(Document document, int x, int y, int r) {
        super(document, x, y);
        this.radius = r;
    }

    @Override
    Shape createShape() {
        return new Circle(x, y, radius);
    }
}
