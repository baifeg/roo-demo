package com.eadp.controller;
import com.eadp.entity.Student;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooJsonMixin;
import com.eadp.entity.Clazz;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * = StudentJsonMixin
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJsonMixin(entity = Student.class)
public abstract class StudentJsonMixin {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonDeserialize(using = ClazzDeserializer.class)
    private Clazz clazz;

    /**
     * TODO Auto-generated method documentation
     *
     * @return Clazz
     */
    public Clazz getClazz() {
        return clazz;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param clazz
     */
    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }
}
