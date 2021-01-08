package behavioral.observer.editor;

import behavioral.observer.publisher.EventManager;

import java.io.File;

public class Editor {
    public EventManager events;
    private File file;

    public Editor() {
        events = new EventManager("open", "save");
    }

    public void openFile(String pathFile){
        this.file = new File(pathFile);
        events.notify("open", file);
    }

    public void saveFile() throws Exception {
        if(file != null)
            events.notify("save", file);
        else
            throw new Exception("Please open a file first!");
    }
}
