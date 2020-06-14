package nix.alvl.java.todolist.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class TodoNotFoundException extends ResponseStatusException {
    public TodoNotFoundException(Integer id) {
        super(HttpStatus.NOT_FOUND, "No such todo with this id - " + id);
    }
}