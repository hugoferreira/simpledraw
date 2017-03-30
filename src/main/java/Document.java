import sun.plugin.dom.exception.InvalidStateException;

import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.io.Serializable;

public class Document {
    private List<Shape> shapes;
    private LinkedList<Command> commands;
    private int commandIndex;

    public Document() {
        shapes = new ArrayList<>();
        commands = new LinkedList<>();
        commandIndex = -1;
    }

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
        commands.add(++commandIndex, cmd);
        cmd.execute();
    }

    public void undo() {
        if(commandIndex < 0)
            throw new InvalidStateException("Nothing to undo...");

        Command lastCommand = commands.get(commandIndex);
        commandIndex--;
        lastCommand.undo();
    }

    public void redo() {
        if(commandIndex + 1 >= commands.size())
            throw new InvalidStateException("Nothing to redo...");

        commandIndex++;
        Command nextCommand = commands.get(commandIndex);
        if(!isCommandValid(nextCommand))
            throw new InvalidStateException("Can not apply transformations over deleted shape...");

        nextCommand.execute();
    }

    public void redoAll() {
        for(int i = commandIndex; i < commands.size() - 1; i++) {
            redo();
        }
    }

    private boolean isCommandValid(Command cmd) {
        if(cmd instanceof TransformShapeCommand) {
            if (!shapes.contains(((TransformShapeCommand) cmd).getShape()))
                return false;
        }
        return true;
    }
}
