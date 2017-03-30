package test;

import main.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class StateIOTest {
  @Test
  public void SaveLoad() {
    Document originalDocument = new Document();

    originalDocument.execute(new CreateCircle(originalDocument, 100, 100));
    originalDocument.execute(new CreateRectangle(originalDocument, 20, 20));
    originalDocument.undo();
    originalDocument.redo();

    StateIO.save(originalDocument, "/tmp/test.save");

    String loadedView = new View(StateIO.load("/tmp/test.save")).toString();
    String originalView = new View(originalDocument).toString();

    assertEquals(originalView, loadedView);
  }

  @Test
  public void LoadAndUndo() {
    Document originalDocument = new Document();
    originalDocument.execute(new CreateCircle(originalDocument, 100, 100));
    originalDocument.execute(new CreateRectangle(originalDocument, 20, 20));
    originalDocument.undo();

    StateIO.save(originalDocument, "/tmp/test.save");

    Document loadedDocument = StateIO.load("/tmp/test.save");
    loadedDocument.redo();
    String loadedView = new View(loadedDocument).toString();

    originalDocument.redo();
    String originalView = new View(originalDocument).toString();

    assertEquals(originalView, loadedView);
  }
}
