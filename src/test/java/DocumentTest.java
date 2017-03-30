import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

/**
 * Created by joaos on 30/03/2017.
 */
public class DocumentTest {

    Document d1;

    @Before
    public void setup() {
        d1 = new Document();
    }

    @Test
    public void execute() throws Exception {
        Assert.assertEquals(0, d1.getShapes().size());

        List<Command> cmds = Arrays.asList(
                new CreateCircle(d1, 100, 100),
                new CreateCircle(d1, 300, 300),
                new CreateCircle(d1, 500, 100),
                new CreateRectangle(d1, 20, 20));
        for(Command cmd : cmds)
            d1.execute(cmd);

        Assert.assertEquals(4, d1.getShapes().size());
    }

    @Test
    public void undo() throws Exception {
        Assert.assertEquals(0, d1.getShapes().size());

        List<Command> cmds = Arrays.asList(
                new CreateCircle(d1, 100, 100),
                new CreateCircle(d1, 300, 300),
                new CreateCircle(d1, 500, 100),
                new CreateRectangle(d1, 20, 20));
        for(Command cmd : cmds)
            d1.execute(cmd);

        Assert.assertEquals(4, d1.getShapes().size());

        d1.undo();

        Assert.assertEquals(3, d1.getShapes().size());

        d1.undo();

        Assert.assertEquals(2, d1.getShapes().size());
    }

    @Test
    public void redo() throws Exception {
        Assert.assertEquals(0, d1.getShapes().size());

        List<Command> cmds = Arrays.asList(
                new CreateCircle(d1, 500, 100),
                new CreateRectangle(d1, 20, 20));
        for(Command cmd : cmds)
            d1.execute(cmd);

        Assert.assertEquals(2, d1.getShapes().size());

        d1.undo();

        Assert.assertEquals(1, d1.getShapes().size());

        d1.redo();

        Assert.assertEquals(2, d1.getShapes().size());
    }

    @Test
    public void redoAll() throws Exception {
        Assert.assertEquals(0, d1.getShapes().size());

        List<Command> cmds = Arrays.asList(
                new CreateCircle(d1, 500, 100),
                new CreateRectangle(d1, 20, 20));
        for(Command cmd : cmds)
            d1.execute(cmd);

        Assert.assertEquals(2, d1.getShapes().size());

        d1.undo();

        Assert.assertEquals(1, d1.getShapes().size());

        d1.execute(new CreateCircle(d1, 50, 15));

        Assert.assertEquals(2, d1.getShapes().size());

        d1.redo();

        Assert.assertEquals(3, d1.getShapes().size());
    }
}
