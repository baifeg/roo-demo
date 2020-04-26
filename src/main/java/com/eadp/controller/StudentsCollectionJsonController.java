package com.eadp.controller;
import com.eadp.entity.Student;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import com.eadp.service.StudentService;
import io.springlets.data.domain.GlobalSearch;
import java.util.Collection;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponents;
import io.swagger.annotations.Api;

/**
 * = StudentsCollectionJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Student.class, type = ControllerType.COLLECTION)
@RooJSON
@RestController
@RequestMapping(value = "/students", name = "StudentsCollectionJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
@Api
public class StudentsCollectionJsonController {

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
    public StudentsCollectionJsonController(StudentService studentService) {
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
     * @param globalSearch
     * @param pageable
     * @return ResponseEntity
     */
    @GetMapping(name = "list")
    public ResponseEntity<Page<Student>> list(GlobalSearch globalSearch, Pageable pageable) {
        Page<Student> students = getStudentService().findAll(globalSearch, pageable);
        return ResponseEntity.ok(students);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return UriComponents
     */
    public static UriComponents listURI() {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(StudentsCollectionJsonController.class).list(null, null)).build().encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param student
     * @param result
     * @return ResponseEntity
     */
    @PostMapping(name = "create")
    public ResponseEntity<?> create(@Valid @RequestBody Student student, BindingResult result) {
        if (student.getId() != null || student.getVersion() != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        Student newStudent = getStudentService().save(student);
        UriComponents showURI = StudentsItemJsonController.showURI(newStudent);
        return ResponseEntity.created(showURI.toUri()).build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param students
     * @param result
     * @return ResponseEntity
     */
    @PostMapping(value = "/batch", name = "createBatch")
    public ResponseEntity<?> createBatch(@Valid @RequestBody Collection<Student> students, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        getStudentService().save(students);
        return ResponseEntity.created(listURI().toUri()).build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param students
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(value = "/batch", name = "updateBatch")
    public ResponseEntity<?> updateBatch(@Valid @RequestBody Collection<Student> students, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        getStudentService().save(students);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return ResponseEntity
     */
    @DeleteMapping(value = "/batch/{ids}", name = "deleteBatch")
    public ResponseEntity<?> deleteBatch(@PathVariable("ids") Collection<Long> ids) {
        getStudentService().delete(ids);
        return ResponseEntity.ok().build();
    }
}
