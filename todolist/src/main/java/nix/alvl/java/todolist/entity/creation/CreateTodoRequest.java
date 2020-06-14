package nix.alvl.java.todolist.entity.creation;

public class CreateTodoRequest {

    private String text;
    private boolean done;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
