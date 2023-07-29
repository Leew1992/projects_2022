package learning_1.week_11;

public class Book {

    @AutoWired
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
