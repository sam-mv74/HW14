package Q2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Teacher extends Person{
    public static final String TABLE_NAME = "Teacher";

    @Column(name = "teacher_code")
    private String teacherCode;
    private String degree;
    private Double salary;
    @Column(name = "teacher_grade")
    private TeacherGrade teacherGrade;
}
