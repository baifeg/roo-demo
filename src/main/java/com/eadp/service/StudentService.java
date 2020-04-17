package com.eadp.service;
import com.eadp.entity.Student;
import io.springlets.data.web.validation.ValidatorService;
import io.springlets.format.EntityResolver;
import org.springframework.roo.addon.layers.service.annotations.RooService;
import com.eadp.dto.StudentDTO;
import com.eadp.entity.Clazz;
import com.eadp.vo.StudentVO;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = StudentService
 *
 * TODO Auto-generated class documentation
 *
 */
@RooService(entity = Student.class)
public interface StudentService extends EntityResolver<Student, Long>, ValidatorService<Student> {

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Student
     */
    public abstract Student findOne(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param student
     */
    public abstract void delete(Student student);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entities
     * @return List
     */
    public abstract List<Student> save(Iterable<Student> entities);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     */
    public abstract void delete(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @param entity
     * @return Student
     */
    public abstract Student save(Student entity);

    /**
     * TODO Auto-generated method documentation
     *
     * @param id
     * @return Student
     */
    public abstract Student findOneForUpdate(Long id);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @return List
     */
    public abstract List<Student> findAll(Iterable<Long> ids);

    /**
     * TODO Auto-generated method documentation
     *
     * @return List
     */
    public abstract List<Student> findAll();

    /**
     * TODO Auto-generated method documentation
     *
     * @return Long
     */
    public abstract long count();

    /**
     * TODO Auto-generated method documentation
     *
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Student> findAll(GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param ids
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Student> findAllByIdsIn(List<Long> ids, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param clazz
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<Student> findByClazz(Clazz clazz, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param clazz
     * @return Long
     */
    public abstract long countByClazz(Clazz clazz);

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<StudentVO> findByNameLike(StudentDTO formBean, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<StudentVO> findByAgeGreaterThan(StudentDTO formBean, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<StudentVO> findByAgeBetween(StudentDTO formBean, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @param globalSearch
     * @param pageable
     * @return Page
     */
    public abstract Page<StudentVO> findByAgeLessThan(StudentDTO formBean, GlobalSearch globalSearch, Pageable pageable);

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @return Long
     */
    public abstract long countByNameLike(StudentDTO formBean);

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @return Long
     */
    public abstract long countByAgeGreaterThan(StudentDTO formBean);

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @return Long
     */
    public abstract long countByAgeBetween(StudentDTO formBean);

    /**
     * TODO Auto-generated method documentation
     *
     * @param formBean
     * @return Long
     */
    public abstract long countByAgeLessThan(StudentDTO formBean);
}
