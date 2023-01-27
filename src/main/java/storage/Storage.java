package storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.nio.file.Path;

import Parser.Parser;
import entities.*;
import exceptions.DukeFileNotFoundException;
import exceptions.InvalidInputException;

public class Storage {
    private final Path HOME_DIRECTORY = Path.of(System.getProperty("user.dir") + "/data");
    private File file;
    private Parser parser;

    public Storage(String file) {
        this.file = new File(this.HOME_DIRECTORY + "/" + file);
        this.parser = new Parser();
    }

    public void connect() throws DukeFileNotFoundException {
        if (!file.exists()) {
            throw new DukeFileNotFoundException("An error occurred when connecting to the database!");
        }
    }

    public boolean load(TaskList list) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        String input = sc.nextLine();
        while (sc.hasNextLine()) {
            if (parser.parseText(input, list) == false) {
                return false;
            }
            input = sc.nextLine();
        }
        return true;

    }

    public void save(TaskList list) {
        try {
            FileWriter myWriter = new FileWriter(this.HOME_DIRECTORY + "/" + file);
            for (int i = 0; i < list.getSize(); i++) {
                String line = list.getTask(i).toSave();
                myWriter.write(line);
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Error! I cannot write to the file!");
        }
    }
}