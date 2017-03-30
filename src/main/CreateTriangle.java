package main;

import shapes.Triangle;
import shapes.Shape;

public class CreateTriangle extends CreateShape {
	private int x1, y1, x2, y2;
    public CreateTriangle(Document document, int x, int y, int x1, int y1, int x2, int y2) {
        super(document, x, y);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    Shape createShape() {
        return new Triangle(x, y, x1, y1, x2, y2);
    }
}