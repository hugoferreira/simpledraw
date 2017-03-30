public class CreatePolygon extends CreateShape
{
    public CreatePolygon(Document document, int x, int y) {
        super(document, x, y);
    }

    @Override
    Shape createShape() {
        return new Polygon(x, y);
    }
}