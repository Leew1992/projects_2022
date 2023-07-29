package learning_3.week_1.dto;

public class TeacherDto extends PersonDto {
    private long teacherId;

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }
}
