package main;

public class CreateDocument implements Command {

    private Main app;

    public CreateDocument(Main app) {
        this.app = app;
    }

    @Override
    public void execute() {
        app.addDocument(new Document());
    }

    @Override
    public void undo() {

    }
}
