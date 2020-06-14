package nix.alvl.java.todolist.service;

import nix.alvl.java.todolist.entity.Todo;
import nix.alvl.java.todolist.entity.creation.CreateTodoRequest;
import nix.alvl.java.todolist.exception.TodoNotFoundException;
import nix.alvl.java.todolist.repository.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TodoService implements TodoOperations {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository repository) {
        this.todoRepository = repository;
    }

    @Override
    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    @Override
    public Optional<Todo> getById(Integer id) {
        return todoRepository.findById(id);
    }

    @Override
    public List<Todo> getAllNotDone() {
        return todoRepository.findByDoneFalse();
    }

    @Override
    public Todo create(CreateTodoRequest createTodoRequest) {
        var todo = new Todo();
        todo.setText(createTodoRequest.getText());
        todo.setDone(createTodoRequest.isDone());
        return todoRepository.save(todo);
    }

    @Override
    public void update(Integer id,CreateTodoRequest createTodoRequest) {
        var todo = todoRepository.findById(id).orElseThrow(()->new TodoNotFoundException(id));
        todo.setText(createTodoRequest.getText());
        todo.setDone(createTodoRequest.isDone());
        todoRepository.save(todo);
    }

    @Override
    public Optional<Todo> deleteById(Integer id) {
        var todo = todoRepository.findById(id);
        todo.ifPresent(todoRepository::delete);
        return todo;
    }
}
