package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreatePolygonTest
{
    @Test
    public void createShape() throws Exception {
        Document d1 = new Document();
        d1.execute(new CreatePolygon(d1, 100, 200));
        assertEquals(1, d1.getShapes().size());
    }

}