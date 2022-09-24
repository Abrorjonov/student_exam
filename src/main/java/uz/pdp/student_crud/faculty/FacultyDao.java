package uz.pdp.student_crud.faculty;


import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FacultyDao {


    private final JdbcTemplate jdbcTemplate;


    public List<Faculty> getAllFacultiesFromDb() {


        String sql = "select * from faculty";

        return jdbcTemplate.query(sql, (resultSet, row) ->
                Faculty.builder()
                        .id(resultSet.getInt(1))
                        .faculty(resultSet.getString(2))
                        .build()

        );
    }

    public void addNewFaculty(Faculty faculty) {


        String sql = "insert into faculty (faculty)\n" +
                "values ('" + faculty.getFaculty() + "');";
        int update = jdbcTemplate.update(sql);

    }

    public void editFaculty(Faculty faculty) throws IllegalAccessException {

        try {
            String sql =
                    "UPDATE faculty SET faculty = '" + faculty.getFaculty() + "'" +
                            " " +
                            "WHERE id =" + faculty.getId() + ";";
            int update = jdbcTemplate.update(sql);

        } catch (Exception e) {
            throw new IllegalAccessException("nimadur");
        }
    }

    public void deleteFacultyById(Integer id) throws IllegalAccessException {

        try {
            String sql = "delete FROM faculty where id = " + id + ";";
            jdbcTemplate.update(sql);
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalAccessException("nimadur");
        }

    }

    public Faculty getFacultyById(Integer id) {

        String sql = "select * from faculty where id = " + id;
        Faculty faculty = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Faculty.class));
        return faculty;
    }
}
