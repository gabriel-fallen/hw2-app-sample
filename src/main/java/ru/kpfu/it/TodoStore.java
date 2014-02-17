package ru.kpfu.it;

import ru.kpfu.it.model.Todo;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Alexander Tchitchigin
 *         Date: 2/3/14
 *         Time: 2:22 AM
 */
public class TodoStore {
    private Set<Todo> todoSet = new HashSet<Todo>();

    public void add(Todo todo) {
        todoSet.add(todo);
    }

    public Todo get(Long id) {
        for(Todo todo : todoSet) {
            if (todo.getId().equals(id))
                return todo;
        }
        return null;
    }

    /**
     *
     * @return unmodifiable set
     */
    public Set<Todo> getAll() {
        return Collections.unmodifiableSet(todoSet);
    }

    public int size() {
        return todoSet.size();
    }
}





