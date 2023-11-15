package Q2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student extends Person {
    public static final String TABLE_NAME = "Student";

    @Column(name = "student_code")
    private String studentCode;
    private String major;
    @Column(name = "enter_date")
    private Date enterDate;

}
