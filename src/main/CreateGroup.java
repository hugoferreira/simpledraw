package main;

import java.util.List;

public class CreateGroup extends CreateShape {

    private List<Shape> shapes;

    public CreateGroup(Document document, int x, int y, List<Shape> shapes) {
        super(document, x, y);
        this.shapes = shapes;
    }

    @Override
    Shape createShape() {
        return new Group(shapes);
    }
}
