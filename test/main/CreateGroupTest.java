package main;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateGroupTest
{
    @Test
    public void createGroup() throws Exception {
        ArrayList<Document> list = new ArrayList<>();
        CreateDocument cd1 = new CreateDocument(list);
        cd1.execute();
        Document d1 = list.get(0);
        Circle c1 = new Circle(10, 10);
        Rectangle r1 = new Rectangle(10,10);
        d1.execute(new CreateGroup(d1, 0,0, Arrays.asList(c1, r1)));
        assertEquals(1, d1.getShapes().size());
        Group g1 = (Group)d1.getShapes().get(0);
        assertEquals(2, g1.getChildren().size());
    }

}