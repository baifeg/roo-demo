package com.eadp.controller;
import com.eadp.entity.Clazz;
import org.springframework.roo.addon.web.mvc.controller.annotations.ControllerType;
import org.springframework.roo.addon.web.mvc.controller.annotations.RooController;
import org.springframework.roo.addon.web.mvc.controller.annotations.responses.json.RooJSON;
import com.eadp.service.ClazzService;
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
 * = ClazzesItemJsonController
 *
 * TODO Auto-generated class documentation
 *
 */
@RooController(entity = Clazz.class, type = ControllerType.ITEM)
@RooJSON
@RestController
@RequestMapping(value = "/clazzes/{clazz}", name = "ClazzesItemJsonController", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClazzesItemJsonController {

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
    public ClazzesItemJsonController(ClazzService clazzService) {
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
     * @param id
     * @return Clazz
     */
    @ModelAttribute
    public Clazz getClazz(@PathVariable("clazz") Long id) {
        Clazz clazz = clazzService.findOne(id);
        if (clazz == null) {
            throw new NotFoundException(String.format("Clazz with identifier '%s' not found", id));
        }
        return clazz;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param clazz
     * @return ResponseEntity
     */
    @GetMapping(name = "show")
    public ResponseEntity<?> show(@ModelAttribute Clazz clazz) {
        return ResponseEntity.ok(clazz);
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param clazz
     * @return UriComponents
     */
    public static UriComponents showURI(Clazz clazz) {
        return MvcUriComponentsBuilder.fromMethodCall(MvcUriComponentsBuilder.on(ClazzesItemJsonController.class).show(clazz)).buildAndExpand(clazz.getId()).encode();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param storedClazz
     * @param clazz
     * @param result
     * @return ResponseEntity
     */
    @PutMapping(name = "update")
    public ResponseEntity<?> update(@ModelAttribute Clazz storedClazz, @Valid @RequestBody Clazz clazz, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        clazz.setId(storedClazz.getId());
        getClazzService().save(clazz);
        return ResponseEntity.ok().build();
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param clazz
     * @return ResponseEntity
     */
    @DeleteMapping(name = "delete")
    public ResponseEntity<?> delete(@ModelAttribute Clazz clazz) {
        getClazzService().delete(clazz);
        return ResponseEntity.ok().build();
    }
}
