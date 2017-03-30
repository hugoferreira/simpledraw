public abstract class CreateShape extends Command {
    protected Document document;
    protected int x;
    protected int y;
    private Shape shape;

    public CreateShape(Document document, int x, int y) {
        super();
        this.x = x;
        this.y = y;
        this.document = document;
    }

    abstract Shape createShape();

    @Override
    public void execute() {
        shape = createShape();
        document.addShape(shape);
    }

    @Override
    public void undo() {
        document.removeShape(shape);
    }
}
