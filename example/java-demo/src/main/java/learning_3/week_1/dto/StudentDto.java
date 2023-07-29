package learning_3.week_1.dto;

public class StudentDto extends PersonDto {
    private long studentId;

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }
}
