package main;

import java.util.ArrayList;
import java.util.Arrays;

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

    public Document getDocument(int index) {
        return this.documents.get(index);
    }

    public static void main(String[] args) {

        Main app = Main.getInstance();

        // Todo: change this to a Command CreateDocument
        // Problem: how do we return a new command?... Should execute return stuff? Dunno...
        CreateDocument cd1 = new CreateDocument(app.documents);
        cd1.execute();

        Document d1 = app.getDocument(0);

        Circle c1 = new Circle(10, 10);
        Rectangle r1 = new Rectangle(10,10);

        d1.execute(new CreateCircle(d1, 100, 100));
        d1.execute(new CreateCircle(d1, 300, 300));
        d1.execute(new CreateCircle(d1, 500, 100));
        d1.execute(new CreateRectangle(d1, 20, 20));
        d1.execute(new CreateGroup(d1, 0,0, Arrays.asList(c1, r1)));
        d1.undo();
        d1.undo();
        d1.undo();
        d1.redo();
        d1.redo();
        d1.redo();

        View view1 = new View(d1);
        System.out.println(view1);

        View view2 = new View(d1, 10, 0);
        System.out.println(view2);

         /* TODO: Implement Polygon and Group
        Polygon p = new Polygon(30, 30);

        Group g1 = new Group(Arrays.asList(c1, c2, c3, r, p));

        d1.addShape(g1); */

        /*try {
            view1.save("/tmp/cenas.svg");
        } catch (IOException e) {
            e.printStackTrace();
        }*/

    }
}
