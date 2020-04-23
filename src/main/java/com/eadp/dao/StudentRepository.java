package com.eadp.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.finder.RooFinder;
import org.springframework.transaction.annotation.Transactional;

import com.eadp.dto.StudentDTO;
import com.eadp.entity.Clazz;
import com.eadp.entity.Student;
import com.eadp.vo.StudentVO;

/**
 * = StudentRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Student.class, finders = { @RooFinder(value = "findByNameLike", returnType = StudentVO.class, formBean = StudentDTO.class), @RooFinder(value = "findByAgeGreaterThan", returnType = StudentVO.class, formBean = StudentDTO.class), @RooFinder(value = "findByAgeBetween", returnType = StudentVO.class, formBean = StudentDTO.class), @RooFinder(value = "findByAgeLessThan", returnType = StudentVO.class, formBean = StudentDTO.class) })
@Transactional(readOnly = true)
public interface StudentRepository extends JpaRepository<Student, Long>, StudentRepositoryCustom {

    /**
     * TODO Auto-generated method documentation
     *
     * @param clazz
     * @return Long
     */
    public abstract long countByClazz(Clazz clazz);
}
