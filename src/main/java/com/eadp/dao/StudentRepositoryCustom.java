package com.eadp.dao;
import com.eadp.entity.Student;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepositoryCustom;
import com.eadp.dto.StudentDTO;
import com.eadp.entity.Clazz;
import com.eadp.vo.StudentVO;
import io.springlets.data.domain.GlobalSearch;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * = StudentRepositoryCustom
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepositoryCustom(entity = Student.class)
public interface StudentRepositoryCustom {

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
     * @return Long
     */
    public abstract long countByNameLike(StudentDTO formBean);

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
     * @return Long
     */
    public abstract long countByAgeGreaterThan(StudentDTO formBean);

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
    public abstract long countByAgeLessThan(StudentDTO formBean);
}
