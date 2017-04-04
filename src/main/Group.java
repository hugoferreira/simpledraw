package main;

import java.util.List;
import java.util.stream.Collectors;

public class Group extends Shape {
    private List<Shape> children;

    public Group(List<Shape> children) {
        super(0, 0);
        this.children = children;
    }

    public List<Shape> getChildren(){
        return children;
    }

    @Override
    public Group translate(int dx, int dy) {
        return new Group(children.stream().map(s -> s.translate(dx, dy)).collect(Collectors.toList()));
    }

    public String toSvg() {
        return children.stream().map(Shape::toSvg).collect(Collectors.joining("\n"));
    }


    @Override
    public String toString() {
        return children.stream().map(Shape::toString).collect(Collectors.joining("\n"));
    }
}
