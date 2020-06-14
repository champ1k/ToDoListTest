package nix.alvl.java.todolist.controller;

import nix.alvl.java.todolist.entity.Todo;
import nix.alvl.java.todolist.entity.creation.CreateTodoRequest;
import nix.alvl.java.todolist.exception.TodoNotFoundException;
import nix.alvl.java.todolist.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/{id}")
    public Todo getById(@PathVariable Integer id) {
        return todoService.getById(id).orElseThrow(() -> new TodoNotFoundException(id));
    }

    @GetMapping
    public List<Todo> getAll(@RequestParam boolean includeDone) {
        return todoService.getAll();
    }


    @GetMapping("/notdone")
    public List<Todo> getAllNotDone() {
        return todoService.getAllNotDone();
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Todo create(@RequestBody CreateTodoRequest createTodoRequest) {
        return todoService.create(createTodoRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody CreateTodoRequest createTodoRequest) {
        todoService.update(id,createTodoRequest);
    }

    @DeleteMapping
    public Todo deleteById(@PathVariable Integer id) {
        return todoService.deleteById(id).orElseThrow(() -> new TodoNotFoundException(id));
    }
}
