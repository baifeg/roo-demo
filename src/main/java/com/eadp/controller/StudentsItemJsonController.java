package com.eadp.controller;
import com.eadp.entity.Student;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import com.eadp.service.StudentService;
import io.springlets.web.NotFoundException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

/**
 * = StudentsItemJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Student.class, type = ControllerType.ITEM)
@RooJSON
@RestController
@RequestMapping(value = "/students/{student}", name = "StudentsItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentsItemJsonController {

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
    public StudentsItemJsonController(StudentService studentService) {
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
     * @param id
     * @return Student
     */
    @ModelAttribute
    public Student getStudent(@PathVariable("student") Long id) {
        Student student = studentService.findOne(id);
        if (student == null) {
            throw new NotFoundException(String.format("Student with identifier '%s' not found", id));
        }
        return student;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param student
     * @return ResponseEntity
     */
    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute Student student) {
        return ResponseEntity.ok(student);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param student
     * @return UriComponents
     */
    public static UriComponents showURI(Student student) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(StudentsItemJsonController.class).show(student)).buildAndExpand(student.getId()).encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param storedStudent
     * @param student
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(name = "update")
    public ResponseEntity<?> update(@ModelAttribute Student storedStudent, @Valid @RequestBody Student student, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        student.setId(storedStudent.getId());
        getStudentService().save(student);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param student
     * @return ResponseEntity
     */
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Student student) {
        getStudentService().delete(student);
        return ResponseEntity.ok().build();
    }
}
