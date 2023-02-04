package Nerd.Commands;

import Nerd.entities.Event;
import Nerd.entities.TaskList;
import Nerd.Ui.Ui;

/**
 * Represents the Duke.Commands.EventCommand of the Chat bot.
 */
public class EventCommand extends Command {

    /**
     * Overloaded processCommand method from the abstract class Command.
     * Processes the command for a EventCommand Task.
     *
     * @param list The TaskList object that stores Tasks.
     * @param desc The description of the Event.
     * @param from The starting date of the Event.
     * @param to   The ending date of the Event.
     * @param ui   User interface of the Chat bot.
     */
    public String processCommand(TaskList list, String desc, String from, String to, Ui ui) {
        Event event = new Event(desc, from, to);
        list.addTask(event);
        return String.format("Sure!, I've added the following events:\n %s\nNow you have %d tasks in the list.",
                event.toString(), list.getSize());
    }
}
