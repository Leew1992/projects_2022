package learning_1.week_23;

public class ObjDto {
    private String name;
    private Integer age;

    public ObjDto() {
    }

    public ObjDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void sayHello() {
        System.out.println("hello");
    }

    public static void sayStaticHello() {
        System.out.println("static hello");
    }
}
