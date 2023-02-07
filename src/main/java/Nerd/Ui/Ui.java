package Nerd.Ui;

import Nerd.entities.Deadline;
import Nerd.entities.Event;
import Nerd.entities.Task;
import Nerd.entities.TaskList;
import java.util.Scanner;

/**
 * Represents the user interface of the Chat bot.
 */
public class Ui {
    Scanner sc;

    /**
     * Prints the welcome message.
     */
    public String showWelcome() {
        return ("Hello! I'm NerdBot\nWhat can I do for you?");
    }

    public String showCommandList() {
        String availableCommands = "Available commands:\n"
                + "todo [description]\n"
                + "event [description] /from [date] /to [date]\n"
                + "deadline [description] /by [date]\n"
                + "mark [index]\n"
                + "unmark [index]\n"
                + "list\n"
                + "delete [index]\n"
                + "date [date]\n"
                + "date formats are in yyyy-mm-dd";
        return availableCommands;
    }

    public String printError(String err) {
        return err;
    }

    public String printBye() {
        return "Bye. Hope to see you again soon!";
    }

    public String printDeadlineResponse(String deadline, int size) {
        return String.format("Received, I've added the following deadlines:\n %s\nNow you have %d tasks in the list."
                , deadline, size);
    }

    public String printDeleteResponse(String task, int size) {
        return String.format("ok, this task has been removed:\n %s\nNow you have %d tasks in the list",
                task, size);
    }

    public String printEventResponse(String event, int size) {
        return String.format("Sure!, I've added the following events:\n %s\nNow you have %d tasks in the list.",
                event, size);
    }

    public String printSearchResponse(String result, String description) {
        String output = "Here are tasks that associate with " + description + ":\n";
        output += result;
        return output;
    }

    public String printListResponse(TaskList list) {
        String output = "Here is the current list:\n";
        for (int i = 0; i < list.getSize(); i++) {
            Task t = list.getTask(i);
            output += String.format("%d.%s\n", i + 1, t.toString());
        }
        return output;
    }

    public String printMarkResponse(String task) {
        return String.format("Nice, this task has been marked as done:\n %s", task);
    }

    public String printUnmarkResponse(String task) {
        return String.format("Nice, this task has been unmarked:\n %s", task);
    }

    public String printSearchDate(String date, TaskList list) {
        String output = "Tasks occurring on " + date + ":\n";
        for (int i = 0; i < list.getSize(); i++) {
            Task currTask = list.getTask(i);
            if (currTask instanceof Deadline) {
                if (date.equals(((Deadline) currTask).getBy())) {
                    output = output + currTask.toString() + "\n";
                }
            } else if (currTask instanceof Event) {
                if (date.equals(((Event) currTask).getEndDate()) || date.equals(((Event) currTask).getStartDate())) {
                    output = output + currTask.toString() + "\n";
                }
            }
        }
        return output;
    }

    public String printTodoResponse(String todo, int size) {
        return String.format("Sure!, I've added the following todo task:\n %s\nNow you have %d tasks in the list.",
                todo, size);
    }



    public void print(String input) {
        System.out.println(input);
    }

}
