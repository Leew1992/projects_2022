package learning_2.other;

import java.io.Serializable;

public class User implements Serializable{
    public static int serial = 100;
    private transient int trans = 200;
    private String name;
    private int age;
    private Integer ageObj;

    public static int getSerial() {
        return serial;
    }

    public static void setSerial(int serial) {
        User.serial = serial;
    }

    public int getTrans() {
        getSerial();
        return trans +serial;
    }

    public void setTrans(int trans) {
        this.trans = trans;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int getAge() {
        return 111;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public Integer getAgeObj() {
        return ageObj;
    }

    public void setAgeObj(Integer ageObj) {
        this.ageObj = ageObj;
    }
}
