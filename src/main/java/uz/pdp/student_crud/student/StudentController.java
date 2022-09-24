package uz.pdp.student_crud.student;


import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.student_crud.course.CourseDao;
import uz.pdp.student_crud.faculty.FacultyDao;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentDao studentDao;
    private final CourseDao courseDao;
    private final FacultyDao facultyDao;


    @GetMapping
    public String getAllStudents(Model model) {


        model.addAttribute("students", studentDao.getAllStudentsFromDb());


        return "/student/view-students";
    }

    @GetMapping("/get-form")
    public String getStudentForm(Model model  ) {
        model.addAttribute("course",courseDao.getAllCoursesFromDb());
        model.addAttribute("faculty",facultyDao.getAllFacultiesFromDb());
        return "/student/add-student-form";
    }

    @SneakyThrows
    @PostMapping
    public String addNewStudent(StudentDto studentDto) {
        try {
            studentDao.addNewStudent(studentDto);
            return "redirect:/students";

        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalAccessException("nimadur");
        }


    }

    @GetMapping("/edit/{id}")
    public String getFormForEditStudent(@PathVariable Integer id, Model model) {

        Student studentById = studentDao.getStudentById(id);
        model.addAttribute("student", studentById);
        model.addAttribute("course",courseDao.getAllCoursesFromDb());
        model.addAttribute("faculty",facultyDao.getAllFacultiesFromDb());

        return "/student/edit-student-form";

    }


    @PostMapping("/edit")
    public String editStudentById(Student student) {
        try {
            studentDao.editStudent(student);
            return "redirect:/students";
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable Integer id) {
        try {
            studentDao.deleteStudentById(id);
            return "redirect:/students";
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
