package nix.alvl.java.todolist.entity;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private boolean done;

    public Todo() {
    }

    public Todo(String text) {
        this.text = text;
        this.done = false;
    }

    public Todo(String text, boolean done) {
        this.text = text;
        this.done = done;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public boolean isDone() {
        return done;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDone(boolean done) {
        this.done = done;
    }


}