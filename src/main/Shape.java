package main;

import java.io.Serializable;

public abstract class Shape implements Cloneable, Serializable {
    protected int x = 0;
    protected int y = 0;

    protected Style style;

    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
        style = new Style();
    }

    public Shape translate(int dx, int dy) {
        Shape newShape = null;

        try {
            newShape = (Shape) this.clone();
            newShape.x -= dx;
            newShape.y -= dy;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return newShape;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }
    public String toSvg() {
        return "";
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " (X: " + x + ", Y: " + y + ") Color: " + this.getStyle().getColor();
    }
}
