package com.eadp.controller;
import com.eadp.entity.Student;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.finder.RooSearch;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import com.eadp.dto.StudentDTO;
import com.eadp.service.StudentService;
import com.eadp.vo.StudentVO;
import io.springlets.data.domain.GlobalSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * = StudentsSearchJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Student.class, type = ControllerType.SEARCH)
@RooSearch(finders = { "findByAgeBetween", "findByAgeGreaterThan", "findByAgeLessThan", "findByNameLike" })
@RooJSON
@RestController
@RequestMapping(value = "/students/search", name = "StudentsSearchJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentsSearchJsonController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private StudentService studentService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param studentService
     */
    @Autowired
    public StudentsSearchJsonController(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return StudentService
     */
    public StudentService getStudentService() {
        return studentService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param studentService
     */
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param search
     * @param pageable
     * @return ResponseEntity
     */
    @GetMapping(name = "byNameLike", value = "/byNameLike")
    public ResponseEntity<Page<StudentVO>> byNameLike(@ModelAttribute("formBean") StudentDTO formBean, GlobalSearch search, Pageable pageable) {
        Page<StudentVO> students = getStudentService().findByNameLike(formBean, search, pageable);
        return ResponseEntity.ok(students);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param search
     * @param pageable
     * @return ResponseEntity
     */
    @GetMapping(name = "byAgeGreaterThan", value = "/byAgeGreaterThan")
    public ResponseEntity<Page<StudentVO>> byAgeGreaterThan(@ModelAttribute("formBean") StudentDTO formBean, GlobalSearch search, Pageable pageable) {
        Page<StudentVO> students = getStudentService().findByAgeGreaterThan(formBean, search, pageable);
        return ResponseEntity.ok(students);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param search
     * @param pageable
     * @return ResponseEntity
     */
    @GetMapping(name = "byAgeBetween", value = "/byAgeBetween")
    public ResponseEntity<Page<StudentVO>> byAgeBetween(@ModelAttribute("formBean") StudentDTO formBean, GlobalSearch search, Pageable pageable) {
        Page<StudentVO> students = getStudentService().findByAgeBetween(formBean, search, pageable);
        return ResponseEntity.ok(students);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param search
     * @param pageable
     * @return ResponseEntity
     */
    @GetMapping(name = "byAgeLessThan", value = "/byAgeLessThan")
    public ResponseEntity<Page<StudentVO>> byAgeLessThan(@ModelAttribute("formBean") StudentDTO formBean, GlobalSearch search, Pageable pageable) {
        Page<StudentVO> students = getStudentService().findByAgeLessThan(formBean, search, pageable);
        return ResponseEntity.ok(students);
    }
}
