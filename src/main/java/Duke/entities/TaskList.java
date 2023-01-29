package Duke.entities;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import Duke.exceptions.DukeException;
import Duke.storage.Storage;

/**
 * Represents the list of Tasks of the Chat bot.
 */
public class TaskList {
    protected Storage storage;
    ArrayList<Task> list = new ArrayList<>();

    /**
     * Instantiates a TaskList Object that keeps track of the Tasks.
     *
     * @param storage The storage object that contains the preload data.
     */
    public TaskList(Storage storage) throws DukeException, FileNotFoundException {
        this.storage = storage;
        if (!storage.load(this)) {
            throw new DukeException("Sorry! I have detected weird inputs in the commands");
        }
    }

    public void addTask(Task t) {
        this.list.add(t);
    }

    public int getSize() {
        return this.list.size();
    }

    public Task getTask(int index) {
        return this.list.get(index);
    }

    public void deleteTask(int index) {
        this.list.remove(index);
    }


}
