package main;

import shapes.Rectangle;
import shapes.Shape;

public class CreateRectangle extends CreateShape {
	private int height, width;
    public CreateRectangle(Document document, int x, int y, int h, int w) {
        super(document, x, y);
        this.height = h;
        this.width = w;
    }

    @Override
    Shape createShape() {
        return new Rectangle(x, y, height, width);
    }
}
