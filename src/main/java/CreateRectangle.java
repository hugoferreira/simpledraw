public class CreateRectangle extends CreateShape {
    public CreateRectangle(Document document, int x, int y) {
        super(document, x, y);
    }

    @Override
    Shape createShape() {
        return new Rectangle(x, y);
    }
}
