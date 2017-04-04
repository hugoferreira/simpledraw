package main;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateDocumentTest
{
    @Test
    public void createDocument() throws Exception {
        ArrayList<Document> list = new ArrayList<>();
        CreateDocument cd1 = new CreateDocument(list);
        cd1.execute();
        assertEquals(1, list.size());
    }

}