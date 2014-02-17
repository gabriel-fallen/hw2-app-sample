package ru.kpfu.it;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import ru.kpfu.it.model.Todo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    static TodoStore store = new TodoStore();

    public static void main( String[] args ) throws IOException {
        System.out.println( "Todo app" );
        store.add(new Todo("Check listAll."));
        boolean exit = false;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (!exit) {
            System.out.print("> ");
            String input = in.readLine().toLowerCase();
            String answer = "";
            if (input.equals("list")) {
                answer = listAll();
            } else if (input.startsWith("q")) {
                exit = true;
            } else if (input.startsWith("add ")) {
                answer = addTodo(input);
            }
            System.out.println(answer);
        }
    }

    static String addTodo(final String input) {
        String[] parts = input.split("\\s+", 2);
        //System.out.println(Arrays.toString(parts));
        if (parts.length == 2) {
            store.add(new Todo(parts[1]));
            return "Done.";
        } else {
            return "Missing title.";
        }
    }

    static String listAll() {
        StringBuilder sb = new StringBuilder();
        for (Todo todo : store.getAll()) {
            sb.append(String.format("%d: %s - %s\n",
                    todo.getId(), todo.getTitle(),
                    (todo.getCompleted()) ? "completed" : "open"));
        }
        return sb.toString();
    }
}






