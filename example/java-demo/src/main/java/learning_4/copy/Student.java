package learning_4.copy;

import lombok.Data;

@Data
public class Student implements Cloneable{
    private Integer classNo;
    private String className;
    private User user;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
