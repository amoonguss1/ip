package Duke.Commands;

import Duke.entities.Task;
import Duke.entities.TaskList;
import Duke.Ui.Ui;

/**
 * Represents the Duke.Commands.DeleteCommand of the Chat bot.
 */
public class DeleteCommand extends Command {
    @Override
    public void processCommand() {
        System.out.println("abstract method invoked");
    }

    /**
     * Overloaded processCommand method from the abstract class Command.
     * Processes the command for a DeleteCommand Task.
     *
     * @param list The TaskList object that stores Tasks.
     * @param index The position of the Task in the TaskList to be deleted.
     * @param ui User interface of the Chat bot.
     */
    public void processCommand(TaskList list, int index, Ui ui) {
        Task t = list.getTask(index);
        list.deleteTask(index);
        ui.print(String.format("ok, this task has been removed:\n %s", t.toString()));
        ui.print(String.format("Now you have %d tasks in the list", list.getSize()));
        ui.printDivider();
    }
}
