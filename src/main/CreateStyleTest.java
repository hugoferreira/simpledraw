package main;

import org.junit.Assert;


public class CreateStyleTest {
    @org.junit.Test
    public void testColour() throws Exception {

        Document d1 = new Document();

        d1.execute(new CreateCircle(d1, 100, 100));
        d1.execute(new CreateCircle(d1, 300, 300));

        d1.getShapes().get(0).setStyle(new Style("red"));

        Assert.assertEquals("white", d1.getShapes().get(1).getStyle().getColor());
        Assert.assertEquals("red", d1.getShapes().get(0).getStyle().getColor());

    }

}