package uz.pdp.student_crud.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Student {
    private Integer id;
    private String full_name;
    private Integer course_id;
    private Integer faculty_id;
}
