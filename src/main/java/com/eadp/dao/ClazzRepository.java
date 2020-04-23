package com.eadp.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.eadp.entity.Clazz;

/**
 * = ClazzRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Clazz.class)
@Transactional(readOnly = true)
public interface ClazzRepository extends JpaRepository<Clazz, Long>, ClazzRepositoryCustom {
}
