package shapes;

public class Rectangle extends Shape {
	private int height, width;
    public Rectangle(int x, int y, int h, int w) {
        super(x, y);
        this.height = h;
        this.width = w;
    }
    
    public String toString() {
    	return this.getClass().getName() + " (X: " + x + ", Y: " + y + ", H: " + height + ", W: " + width + ")";
    }
}
