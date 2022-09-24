package uz.pdp.student_crud.student;


import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class StudentDao {


    private final JdbcTemplate jdbcTemplate;


    public List<StudentDto> getAllStudentsFromDb() {


        String sql = "select s.*, c.course, f.faculty from student s join course c on s.course_id = c.id join faculty f on s.\"faculty_id\" = f.id";

        return jdbcTemplate.query(sql, (resultSet, row) ->
                StudentDto.builder()
                        .id(resultSet.getInt(1))
                        .full_name(resultSet.getString(2))
                        .course_id(resultSet.getInt(3))
                        .faculty_id(resultSet.getInt(4))
                        .course_name(resultSet.getString(5))
                        .faculty_name(resultSet.getString(6))
                        .build()

        );
    }

    public void addNewStudent(StudentDto student) {

        String sql = "insert into student (full_name,course_id,faculty_id)\n" +
                "values (?,?,?)";
        int update = jdbcTemplate.update(sql,student.getFull_name(),student.getCourse_id(),student.getFaculty_id());

    }

    public void editStudent(Student student) throws IllegalAccessException {

        try {
            String sql =
                    "UPDATE student SET full_name = '" + student.getFull_name() +"',course_id  = '" + student.getCourse_id() +"',faculty_id  = '" + student.getFaculty_id() +
                            "'" +
                            " " +
                            "WHERE id =" + student.getId() + ";";
            int update = jdbcTemplate.update(sql);

        } catch (Exception e) {
            throw new IllegalAccessException("nimadur");
        }
    }

    public void deleteStudentById(Integer id) throws IllegalAccessException {

        try {
            String sql = "delete FROM student where id = " + id + ";";
            jdbcTemplate.update(sql);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalAccessException("nimadur");
        }

    }

    public Student getStudentById(Integer id) {

        String sql = "select s.*, c.course, f.faculty from student s join course c on s.course_id = c.id join faculty f on s.\"faculty_id\" = f.id where s.id =" + id;
        Student student = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Student.class));
        return student;
    }
}
