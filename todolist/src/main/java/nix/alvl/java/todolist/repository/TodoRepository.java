package nix.alvl.java.todolist.repository;

import nix.alvl.java.todolist.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
        List<Todo> findByDoneFalse();
}
