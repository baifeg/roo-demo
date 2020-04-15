package com.eadp.dao;
import com.eadp.entity.Clazz;
import io.springlets.data.jpa.repository.DetachableJpaRepository;
import org.springframework.roo.addon.layers.repository.jpa.annotations.RooJpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * = ClazzRepository
 *
 * TODO Auto-generated class documentation
 *
 */
@RooJpaRepository(entity = Clazz.class)
@Transactional(readOnly = true)
public interface ClazzRepository extends DetachableJpaRepository<Clazz, Long>, ClazzRepositoryCustom {
}
