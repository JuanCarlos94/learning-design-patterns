package behavioral.mediator.components;

import behavioral.mediator.mediator.Mediator;
import behavioral.mediator.mediator.Note;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Filter extends JTextField implements Component {
    private Mediator mediator;
    private ListModel listModel;

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    protected void processComponentKeyEvent(KeyEvent keyEvent) {
        String start = getText();
        searchElements(start);
    }

    public void setList(ListModel listModel){
        this.listModel = listModel;
    }

    private void searchElements(String start) {
        if(listModel == null){
            return;
        }
        if(start.equals("")){
            mediator.setElementsList(listModel);
            return;
        }

        ArrayList<Note> notes = new ArrayList<Note>();
        for(int i = 0; i < listModel.getSize(); i++){
            notes.add((Note) listModel.getElementAt(i));
        }
        DefaultListModel<Note> listModel = new DefaultListModel<>();
        for(Note note : notes){
            if(note.getName().contains(start)){
                listModel.addElement(note);
            }
        }
        mediator.setElementsList(listModel);
    }

    @Override
    public String getName() {
        return "Filter";
    }
}
