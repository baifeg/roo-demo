package com.eadp.controller;
import com.eadp.entity.Teacher1;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import com.eadp.service.Teacher1Service;
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
import io.swagger.annotations.Api;

/**
 * = Teacher1sItemJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Teacher1.class, type = ControllerType.ITEM)
@RooJSON
@RestController
@RequestMapping(value = "/teacher1s/{teacher1}", name = "Teacher1sItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
@Api
public class Teacher1sItemJsonController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private Teacher1Service teacher1Service;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param teacher1Service
     */
    @Autowired
    public Teacher1sItemJsonController(Teacher1Service teacher1Service) {
        this.teacher1Service = teacher1Service;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return Teacher1Service
     */
    public Teacher1Service getTeacher1Service() {
        return teacher1Service;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param teacher1Service
     */
    public void setTeacher1Service(Teacher1Service teacher1Service) {
        this.teacher1Service = teacher1Service;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Teacher1
     */
    @ModelAttribute
    public Teacher1 getTeacher1(@PathVariable("teacher1") Long id) {
        Teacher1 teacher1 = teacher1Service.findOne(id);
        if (teacher1 == null) {
            throw new NotFoundException(String.format("Teacher1 with identifier '%s' not found", id));
        }
        return teacher1;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param teacher1
     * @return ResponseEntity
     */
    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute Teacher1 teacher1) {
        return ResponseEntity.ok(teacher1);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param teacher1
     * @return UriComponents
     */
    public static UriComponents showURI(Teacher1 teacher1) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(Teacher1sItemJsonController.class).show(teacher1)).buildAndExpand(teacher1.getId()).encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param storedTeacher1
     * @param teacher1
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(name = "update")
    public ResponseEntity<?> update(@ModelAttribute Teacher1 storedTeacher1, @Valid @RequestBody Teacher1 teacher1, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        teacher1.setId(storedTeacher1.getId());
        getTeacher1Service().save(teacher1);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param teacher1
     * @return ResponseEntity
     */
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Teacher1 teacher1) {
        getTeacher1Service().delete(teacher1);
        return ResponseEntity.ok().build();
    }
}
