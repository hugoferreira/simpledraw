package main;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    private ArrayList<Document> documents = new ArrayList<>();

    private static Main instance = null;

    private Main() {}

    private static Main getInstance() {
        if (instance == null) {
            instance = new Main();
        }
        return instance;
    }

    public static void main(String[] args) {

        Main app = Main.getInstance();

        // Todo: change this to a Command CreateDocument
        // Problem: how do we return a new command?... Should execute return stuff? Dunno...
        Document d1 = new Document();

//        new CreateDocument();

        d1.execute(new CreateCircle(d1, 100, 100));
        d1.execute(new CreateCircle(d1, 300, 300));
        d1.execute(new CreateCircle(d1, 500, 100));
        d1.execute(new CreateRectangle(d1, 20, 20));
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
