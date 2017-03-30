package main;

public class Circle extends Shape {
    public Circle(int x, int y) {
        super(x, y);
    }

    public String toSvg() {
        return "<circle cx='" + x + "' cy='" + y + "' r='50' style='fill:red; stroke:black; stroke-width:0.1cm' />";
    }
}
