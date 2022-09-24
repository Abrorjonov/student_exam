package uz.pdp.student_crud.course;


import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CourseDao {


    private final JdbcTemplate jdbcTemplate;


    public List<Course> getAllCoursesFromDb() {


        String sql = "select * from course";

        return jdbcTemplate.query(sql, (resultSet, row) ->
                Course.builder()
                        .id(resultSet.getInt(1))
                        .course(resultSet.getInt(2))
                        .build()

        );
    }

    public void addNewCourse(Course course) {


        String sql = "insert into course (course)\n" +
                "values ('" + course.getCourse() + "');";
        int update = jdbcTemplate.update(sql);

    }

    public void editCourse(Course course) throws IllegalAccessException {

        try {
            String sql =
                    "UPDATE course SET course = '" + course.getCourse() + "'" +
                            " " +
                            "WHERE id =" + course.getId() + ";";
            int update = jdbcTemplate.update(sql);

        } catch (Exception e) {
            throw new IllegalAccessException("nimadur");
        }
    }

    public void deleteCourseById(Integer id) throws IllegalAccessException {

        try {
            String sql = "delete FROM course where id = " + id + ";";
            jdbcTemplate.update(sql);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalAccessException("nimadur");
        }

    }

    public Course getCourseById(Integer id) {

        String sql = "select * from course where id = " + id;
        Course course = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Course.class));
        return course;
    }
}
