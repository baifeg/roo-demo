package com.eadp.controller;
import com.eadp.entity.Clazz;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import com.eadp.service.ClazzService;
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
 * = ClazzesCollectionJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Clazz.class, type = ControllerType.COLLECTION)
@RooJSON
@RestController
@RequestMapping(value = "/clazzes", name = "ClazzesCollectionJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClazzesCollectionJsonController {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    private ClazzService clazzService;

    /**
     * TODO Auto-generated constructor documentation
     *
     * @param clazzService
     */
    @Autowired
    public ClazzesCollectionJsonController(ClazzService clazzService) {
        this.clazzService = clazzService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return ClazzService
     */
    public ClazzService getClazzService() {
        return clazzService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param clazzService
     */
    public void setClazzService(ClazzService clazzService) {
        this.clazzService = clazzService;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return ResponseEntity
     */
    @GetMapping(name = "list")
    public ResponseEntity<Page<Clazz>> list(GlobalSearch globalSearch, Pageable pageable) {
        Page<Clazz> clazzes = getClazzService().findAll(globalSearch, pageable);
        return ResponseEntity.ok(clazzes);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @return UriComponents
     */
    public static UriComponents listURI() {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(ClazzesCollectionJsonController.class).list(null, null)).build().encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param clazz
     * @param result
     * @return ResponseEntity
     */
    @PostMapping(name = "create")
    public ResponseEntity<?> create(@Valid @RequestBody Clazz clazz, BindingResult result) {
        if (clazz.getId() != null || clazz.getVersion() != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        Clazz newClazz = getClazzService().save(clazz);
        UriComponents showURI = ClazzesItemJsonController.showURI(newClazz);
        return ResponseEntity.created(showURI.toUri()).build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param clazzes
     * @param result
     * @return ResponseEntity
     */
    @PostMapping(value = "/batch", name = "createBatch")
    public ResponseEntity<?> createBatch(@Valid @RequestBody Collection<Clazz> clazzes, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        getClazzService().save(clazzes);
        return ResponseEntity.created(listURI().toUri()).build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param clazzes
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(value = "/batch", name = "updateBatch")
    public ResponseEntity<?> updateBatch(@Valid @RequestBody Collection<Clazz> clazzes, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        getClazzService().save(clazzes);
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
        getClazzService().delete(ids);
        return ResponseEntity.ok().build();
    }
}
