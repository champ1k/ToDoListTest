package nix.alvl.java.todolist.service;

import nix.alvl.java.todolist.entity.Todo;
import nix.alvl.java.todolist.entity.creation.CreateTodoRequest;

import java.util.List;
import java.util.Optional;

public interface TodoOperations {

    List<Todo> getAll();

    Optional<Todo> getById(Integer id);

    List<Todo> getAllNotDone();

    Todo create(CreateTodoRequest createTodoRequest);

    void update(Integer id,CreateTodoRequest createTodoRequest);

    Optional<Todo> deleteById(Integer id);

}
