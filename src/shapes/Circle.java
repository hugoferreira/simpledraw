package shapes;

public class Circle extends Shape {
	private int radius;
    public Circle(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    public String toSvg() {
        return "<circle cx='" + x + "' cy='" + y + "' r='" + radius + "' style='fill:red; stroke:black; stroke-width:0.1cm' />";
    }
    
    public String toString() {
    	return this.getClass().getName() + " (X: " + x + ", Y: " + y + ", R: " + radius + ")";
    }
}
