package main;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class View {
    private Document document;
    private int originX, originY;

    public View(Document d) {
        this(d, 0, 0);
    }

    public View(Document d, int originX, int originY) {
        this.document = d;
        this.originX = originX;
        this.originY = originY;
    }

    public List<Shape> getPresentationShapes() {
        List<Shape> shapes = new ArrayList<>();
        for (Shape shape: document.getShapes()) {
            shapes.add(shape.translate(originX, originY));
        }
        return shapes;
    }

    public void save(String path) throws IOException {
        SvgWriter svgw = new SvgWriter(new FileWriter(path));
        for (Shape shape: getPresentationShapes()) {
            svgw.print(shape);
        }
        svgw.close();
    }

    @Override
    public String toString() {
        return "---------------\n" +
            getPresentationShapes().stream().map(Shape::toString).collect(Collectors.joining("\n"));
    }
}
