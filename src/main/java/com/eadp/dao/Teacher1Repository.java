package com.eadp.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.eadp.entity.Teacher1;

/**
 * = Teacher1Repository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Teacher1.class)
@Transactional(readOnly = true)
public interface Teacher1Repository extends JpaRepository<Teacher1, Long>, Teacher1RepositoryCustom {
}
