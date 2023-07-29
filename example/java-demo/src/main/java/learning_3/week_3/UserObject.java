package learning_3.week_3;

public class UserObject {

    private String name;

    public UserObject() {}

    public UserObject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserObject{" +
                "name='" + name + '\'' +
                '}';
    }
}
