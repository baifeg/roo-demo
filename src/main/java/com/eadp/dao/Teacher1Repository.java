package com.eadp.dao;
import com.eadp.entity.Teacher1;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * = Teacher1Repository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Teacher1.class)
@Transactional(readOnly = true)
public interface Teacher1Repository extends DetachableJpaRepository<Teacher1, Long>, Teacher1RepositoryCustom {
}
