package main;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Todo: change this to a Command CreateDocument
        // Problem: how do we return a new command?... Should execute return stuff? Dunno...
        Document d1 = new Document();

        d1.execute(new CreateCircle(d1, 100, 100, 50));
        d1.execute(new CreateCircle(d1, 300, 300, 30));
        d1.execute(new CreateCircle(d1, 500, 100, 40));
        d1.execute(new CreateRectangle(d1, 20, 20, 10, 30));
        d1.execute(new CreateTriangle(d1, 20, 20, 10, 30, 30, 15));
        d1.undo();
        d1.undo();
        d1.undo();
        d1.redo();
        d1.redo();
        d1.redo();

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
