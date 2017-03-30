package main;

/**
 * Created by André on 30/03/2017.
 */
public class CircleRenderer extends ShapeRenderer {
    protected Circle circle;

    public CircleRenderer(Circle circle) {
        super();
        this.circle = circle;
    }

    @Override
    public String render() {
        // TODO: lacks testing
        return "<circle cx='" + circle.getX() + "' cy='" + circle.getY() + "' r='50' style='fill:red; stroke:black; stroke-width:0.1cm' />";
    }
}
