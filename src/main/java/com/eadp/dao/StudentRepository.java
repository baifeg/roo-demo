package com.eadp.dao;
import com.eadp.entity.Student;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import com.eadp.dto.StudentDTO;
import com.eadp.vo.StudentVO;
import org.springframework.roo.addon.layers.repository.jpa.annotations.finder.RooFinder;
import com.eadp.entity.Clazz;
import org.springframework.transaction.annotation.Transactional;

/**
 * = StudentRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Student.class, finders = { @RooFinder(value = "findByNameLike", returnType = StudentVO.class, formBean = StudentDTO.class), @RooFinder(value = "findByAgeGreaterThan", returnType = StudentVO.class, formBean = StudentDTO.class), @RooFinder(value = "findByAgeBetween", returnType = StudentVO.class, formBean = StudentDTO.class), @RooFinder(value = "findByAgeLessThan", returnType = StudentVO.class, formBean = StudentDTO.class) })
@Transactional(readOnly = true)
public interface StudentRepository extends DetachableJpaRepository<Student, Long>, StudentRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param clazz
     * @return Long
     */
    public abstract long countByClazz(Clazz clazz);
}
