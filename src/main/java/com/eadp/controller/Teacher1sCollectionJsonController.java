package com.eadp.controller;
import com.eadp.entity.Teacher1;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import com.eadp.service.Teacher1Service;
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

/**
 * = Teacher1sCollectionJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Teacher1.class, type = ControllerType.COLLECTION)
@RooJSON
@RestController
@RequestMapping(value = "/teacher1s", name = "Teacher1sCollectionJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class Teacher1sCollectionJsonController {

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
    public Teacher1sCollectionJsonController(Teacher1Service teacher1Service) {
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
     * @param globalSearch
     * @param pageable
     * @return ResponseEntity
     */
    @GetMapping(name = "list")
    public ResponseEntity<Page<Teacher1>> list(GlobalSearch globalSearch, Pageable pageable) {
        Page<Teacher1> teacher1s = getTeacher1Service().findAll(globalSearch, pageable);
        return ResponseEntity.ok(teacher1s);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return UriComponents
     */
    public static UriComponents listURI() {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(Teacher1sCollectionJsonController.class).list(null, null)).build().encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param teacher1
     * @param result
     * @return ResponseEntity
     */
    @PostMapping(name = "create")
    public ResponseEntity<?> create(@Valid @RequestBody Teacher1 teacher1, BindingResult result) {
        if (teacher1.getId() != null || teacher1.getVersion() != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        Teacher1 newTeacher1 = getTeacher1Service().save(teacher1);
        UriComponents showURI = Teacher1sItemJsonController.showURI(newTeacher1);
        return ResponseEntity.created(showURI.toUri()).build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param teacher1s
     * @param result
     * @return ResponseEntity
     */
    @PostMapping(value = "/batch", name = "createBatch")
    public ResponseEntity<?> createBatch(@Valid @RequestBody Collection<Teacher1> teacher1s, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        getTeacher1Service().save(teacher1s);
        return ResponseEntity.created(listURI().toUri()).build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param teacher1s
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(value = "/batch", name = "updateBatch")
    public ResponseEntity<?> updateBatch(@Valid @RequestBody Collection<Teacher1> teacher1s, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        getTeacher1Service().save(teacher1s);
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
        getTeacher1Service().delete(ids);
        return ResponseEntity.ok().build();
    }
}
