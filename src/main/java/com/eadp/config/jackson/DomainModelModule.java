package com.eadp.config.jackson;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooDomainModelModule;
import com.eadp.controller.ClazzJsonMixin;
import com.eadp.controller.StudentJsonMixin;
import com.eadp.controller.Teacher1JsonMixin;
import com.eadp.entity.Clazz;
import com.eadp.entity.Student;
import com.eadp.entity.Teacher1;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.boot.jackson.JsonComponent;

/**
 * = DomainModelModule
 *
 * TODO Auto-generated class documentation
 *
 */
@RooDomainModelModule
@JsonComponent
public class DomainModelModule extends SimpleModule {

    /**
     * TODO Auto-generated constructor documentation
     *
     */
    public DomainModelModule() {
        // Mixin registration
        setMixInAnnotation(Clazz.class, ClazzJsonMixin.class);
        setMixInAnnotation(Student.class, StudentJsonMixin.class);
        setMixInAnnotation(Teacher1.class, Teacher1JsonMixin.class);
    }
}
