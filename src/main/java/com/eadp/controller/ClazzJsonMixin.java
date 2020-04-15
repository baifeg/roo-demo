package com.eadp.controller;
import com.eadp.entity.Clazz;
import org.springframework.roo.addon.web.mvc.controller.annotations.config.RooJsonMixin;
import com.eadp.entity.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

/**
 * = ClazzJsonMixin
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJsonMixin(entity = Clazz.class)
public abstract class ClazzJsonMixin {

    /**
     * TODO Auto-generated attribute documentation
     *
     */
    @JsonIgnore
    private List<Student> students;

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * TODO Auto-generated method documentation
     *
     * @param students
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
