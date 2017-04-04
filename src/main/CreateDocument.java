package main;

import java.util.ArrayList;

public class CreateDocument implements Command {

    private ArrayList list;

    public CreateDocument(ArrayList list) {
        this.list = list;
    }

    @Override
    public void execute() {
        list.add(new Document());
    }

    @Override
    public void undo() {

    }
}
