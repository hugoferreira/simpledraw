package shapes;

public class Triangle extends Shape {
	private int x1, y1, x2, y2;
    public Triangle(int x, int y, int x1, int y1, int x2, int y2) {
        super(x, y);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    
    public String toString() {
    	return this.getClass().getName() + " (X0: " + x + ", Y0: " + y + ", X1: " + x1 + ", Y1: " + y1 + ", X2: " + x2 + ", Y2: " + y2 + ")";
    }
}
