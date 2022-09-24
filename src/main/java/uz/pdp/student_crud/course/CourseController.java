package uz.pdp.student_crud.course;


import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseDao courseDao;


    @GetMapping
    public String getAllCourses(Model model) {


        model.addAttribute("courses", courseDao.getAllCoursesFromDb());


        return "/course/view-courses";
    }

    @GetMapping("/get-form")
    public String getCourseForm() {
        return "/course/add-course-form";
    }

    @SneakyThrows
    @PostMapping
    public String addNewCourse(Course course) {
        try {
            courseDao.addNewCourse(course);
            return "redirect:/courses";

        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalAccessException("nimadur");
        }


    }

    @GetMapping("/edit/{id}")
    public String getFormForEditCourse(@PathVariable Integer id, Model model) {

        Course courseById = courseDao.getCourseById(id);
        model.addAttribute("course", courseById);
        return "/course/edit-course-form";

    }


    @PostMapping("/edit")
    public String editCourseById(Course course) {
        try {
            courseDao.editCourse(course);
            return "redirect:/courses";
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteCourseById(@PathVariable Integer id) {
        try {
            courseDao.deleteCourseById(id);
            return "redirect:/courses";
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
