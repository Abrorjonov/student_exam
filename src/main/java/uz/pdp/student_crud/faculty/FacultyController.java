package uz.pdp.student_crud.faculty;


import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/faculties")
@RequiredArgsConstructor
public class FacultyController {

    private final FacultyDao facultyDao;


    @GetMapping
    public String getAllFaculties(Model model) {


        model.addAttribute("faculties", facultyDao.getAllFacultiesFromDb());


        return "/faculty/view-faculties";
    }

    @GetMapping("/get-form")
    public String getFacultyForm() {
        return "/faculty/add-faculty-form";
    }

    @SneakyThrows
    @PostMapping
    public String addNewFaculty(Faculty faculty) {
        try {
            facultyDao.addNewFaculty(faculty);
            return "redirect:/faculties";

        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalAccessException("nimadur");
        }


    }

    @GetMapping("/edit/{id}")
    public String getFormForEditFaculty(@PathVariable Integer id, Model model) {

        Faculty facultyById = facultyDao.getFacultyById(id);
        model.addAttribute("faculty", facultyById);
        return "/faculty/edit-faculty-form";

    }


    @PostMapping("/edit")
    public String editFacultyById(Faculty faculty) {
        try {
            facultyDao.editFaculty(faculty);
            return "redirect:/faculties";
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteFacultyById(@PathVariable Integer id) {
        try {
            facultyDao.deleteFacultyById(id);
            return "redirect:/faculties";
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
