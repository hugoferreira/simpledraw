import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Todo: change this to a Command CreateDocument
        // Problem: how do we return a new command?... Should execute return stuff? Dunno...
        Document d1 = new Document();

        d1.execute(new CreateCircle(d1, 100, 100));
        d1.execute(new CreateCircle(d1, 300, 300));
        d1.execute(new CreateCircle(d1, 500, 100));
        d1.execute(new CreateRectangle(d1, 20, 20));
        d1.getShapes().get(0).setStyle(new Style("red"));
        d1.undo();
        d1.undo();
        d1.undo();
        d1.redo();
        d1.redo();
        d1.redo();

        d1.execute(new CreatePolygon(d1, 100, 200));

        /* TODO: Implement Polygon and Group
        Polygon p = new Polygon(30, 30);

        Group g1 = new Group(Arrays.asList(c1, c2, c3, r, p));

        d1.addShape(g1); */

        View view1 = new View(d1);
        System.out.println(view1);

        View view2 = new View(d1, 10, 0);
        System.out.println(view2);

        try {
            view1.save("/tmp/cenas.svg");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
