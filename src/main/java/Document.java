import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.io.Serializable;

public class Document implements Serializable {
    private List<Shape> shapes = new ArrayList<>();
    private Stack<Command> commands = new Stack<>();
    private Stack<Command> undos = new Stack<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public List<Shape> getShapes() { return this.shapes; }

    @Override
    public String toString() {
        return shapes.stream().map(Shape::toString).collect(Collectors.joining("\n"));
    }

    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    public void execute(Command cmd) {
        commands.push(cmd);
        cmd.execute();
    }

    public void undo() {
        Command lastCommand = commands.pop();
        undos.push(lastCommand);
        lastCommand.undo();
    }

    public void redo() {
        execute(undos.pop());
    }
}
